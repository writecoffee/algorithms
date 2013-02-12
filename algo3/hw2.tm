<TeXmacs|1.0.7.4>

<style|letter>

<\body>
  <doc-data|<doc-title|Homework 2>|<\doc-author-data|<author-name|Silao_Xu>>
    \;
  </doc-author-data>>

  <subsection|Problem 1.>

  <\enumerate-numeric>
    <item>How much time does it take to read in the <em|same> order?

    Let <math|l> be the <math|><em|cache lines size>, <math|c> be the
    <em|total cache size>, <math|t> be the time used for copying an aligned
    block of memory of size <math|l> containing the requested location to the
    cache.\ 

    Assume <math|l> divides <math|n> and the cache is empty originally. We
    will read the <math|n \<times\>n> array in the <em|same> order as it is
    stored in.

    Because <math|l> divides <math|n>, <math|<frac|n<rsup|2>|l>> is the total
    number of blocks of memory we need to copy to the cache. Even though
    <em|least recently used<em|>> cache lines would be evicted from the cache
    when the cache is full, it's irrelevant to the latest iteration. So, we
    only need to do <math|<frac|n<rsup|2>|l>> times of copying without any
    need to fetching backward. So the total time would be\ 

    <\equation>
      <frac|n<rsup|2>|l>t
    </equation>

    <item>How much time does it take to read in the <em|other> order?

    Let <math|l> be the <math|><em|cache lines size>, <math|c> be the
    <em|total cache size>, <math|t> be the time used for copying an aligned
    block of memory of size <math|l> containing the requested location to the
    cache.\ 

    Assume <math|l> divides <math|n> and the cache is empty originally. We
    will read the <math|n \<times\>n> array in the <em|other> order from
    which it is stored in.

    (Case 1) If <math|c \<geqslant\> n\<times\>l>, which means the cache is
    big enough to store an entire row. Even though the array are read in the
    <em|other> order from which it is stored in, every time it wants to fetch
    elements from next row, there is no need to fetch that again since it has
    been already stored in the cache. So in this case the total time would be

    <\equation>
      <frac|n<rsup|2>|l>t
    </equation>

    (Case 2) If <math|c\<less\>n\<times\>l>, which means the cache is not big
    enough to store the entire row. When the cache is full, the <em|least
    recently used> (in this case it's the oldest cache line) column would be
    evicted out and for next row iteration the same column which is in size
    <math|l> would be fetched again. So there would be totally
    <math|n<rsup|2>> times of copying. The time measured for this case would
    be

    <\equation>
      n<rsup|2>t
    </equation>

    <item><plot-output|<plot-curve*|1|x<rsup|2>/2<rsup|6>|0|10000>|>Plot the
    answer.

    <no-break><next-line><no-break><next-line><no-break><next-line><no-break><next-line><no-break><next-line><no-break><next-line><no-break><next-line><no-break>

    <with|color|magenta|<with|color|black|<item>Describe qualitatively how,
    in practice, you might notice that your code is running into cache
    issues.>>

    Let <math|l> be the <math|><em|cache lines size>, <math|c> be the
    <em|total cache size>, <math|t> be the time used for copying an aligned
    block of memory of size <math|l> containing the requested location to the
    cache.\ 

    Citing from <em|Qustion 1> and <with|font-shape|italic|Question 2>, from
    (1) and (2), we know that given a <math|n\<times\>n> array, where
    <math|l> divides <math|n>, when <math|c\<geqslant\>n\<times\>l>, no
    matter in what order we are reading the array, we will have the same
    running time, that is <math|<frac|n<rsup|2>|l>t>. However, when
    <math|c\<less\>n\<times\>l>, from (1) and (3), we know that reading in
    the <with|font-shape|italic|same order> would be qualitatively <math|l>
    times faster than reading in the <with|font-shape|italic|other order>.

    So, in practice if we don't run into cache issues, there would be no
    difference between traversing column first (let <math|i> be the index for
    traversing columns) and traversing row first (let <math|j> be the index
    for traversing rows). If we get significant different running time we
    could reason that our array length <math|n> has exceeded the
    <math|<frac|c|l>> limit. Then we can judge which iterating strategy
    (iterating <math|i> first or iterating <math|j> first) is in the
    <with|font-shape|italic|same order> with caching.
  </enumerate-numeric>

  <new-page>

  \;

  <subsection|Problem 2.>

  <\enumerate-numeric>
    <item>How many operations can a single assignment require?

    Assume the time complexity for allocating and freeing memory are both
    <math|O(log(n))>, let it be <math|a<rsub|alloc> log(n) + c<rsub|alloc>>
    and <math|a<rsub|free> log(n) + c<rsub|free>>, where <math|a<rsub|alloc>,
    a<rsub|free>>, <math|c<rsub|alloc>, c<rsub|free>> are constant values.
    Let <math|e> be the exceeding length.

    The time for allocating new memory would be <math|a<rsub|alloc> log(n +
    e) + c<rsub|alloc>>. The time for assigning the new value is constant,
    name it <math|c<rsub|assign>>. Time for copying the original array, which
    is proportional to the size <math|n>, is <math|n\<times\>c<rsub|assign>>.
    The time for freeing the original array memory is <math|a<rsub|free>
    log(n) + c<rsub|free>>. So, the time combined together is:

    <\equation*>
      T<rsub|1> =a<rsub|alloc> log(n+e)+a<rsub|free> log(n) +
      (n+1)c<rsub|assign>+c<rsub|alloc>+c<rsub|free>
    </equation*>

    In sum, the total time is dominated by the assigning part, that is
    <math|O(n)> in total.

    <item>Given an algorithm that involves at most <math|n> assignments to
    positions<math|\<leqslant\> n> in an array, how many operations might
    Matlab require to execute the code?

    In the worst case, when every time the position we need to assign exceeds
    the original array length, we would need to do
    <math|<big|sum><rsub|i=1<rsup|>><rsup|N>i> times allocations for new
    array; we need to do <math|<big|sum><rsub|i=1><rsup|N-1>i> number of
    scale for elements shifting from original array to the new array; and we
    also need to do <math|<big|sum><rsub|i=1><rsup|N-1>>number of scale for
    freeing the original array. For simplicity, we can ignore the coefficient
    <math|a<rsub|alloc>, a<rsub|free>, a<rsub|assign>> and constant values
    <math|c<rsub|alloc>, c<rsub|free>, c<rsub|assign>> because they would be
    compressed in big-O notation. So the time complexity for Matlab's
    algorithm would be calculated as

    <\eqnarray*>
      <tformat|<table|<row|<cell|<below|<wide*|log(1)+log(2)+\<ldots\>+log(N)|\<wide-underbrace\>>|operations
      for allocation>>|<cell|+>|<cell|>>|<row|<cell|<below|<wide*|log(1)+log(2)+\<ldots\>+log(N-1)|\<wide-underbrace\>>|operations
      for freeing>>|+|<cell|>>|<row|<cell|<below|<wide*|1+2+\<ldots\>+N-1|\<wide-underbrace\>>|operations
      for copying>>|<cell|+>|<cell|>>|<row|<cell|<below|<wide*|N|\<wide-underbrace\>>|ops
      for assigning>>|<cell|>|<cell|>>>>
    </eqnarray*>

    <math|\<Rightarrow\>>

    <\equation*>
      <below|<wide*|log(N!)|\<wide-underbrace\>>|operations for
      allocation>+<below|<wide*|log((N-1)!)|\<wide-underbrace\>>|operations
      for freeing>+<below|<wide*|(N-1)(N-2)/2|\<wide-underbrace\>>|ops for
      copying>+<below|<wide*|N|\<wide-underbrace\>>|ops for assigning>
    </equation*>

    \;

    <\equation*>
      \<leqslant\>2N log(N)+<frac|N(N-1)|2>
    </equation*>

    which would finally dominated by the copying operations part,
    <math|O(N<rsup|2>)> in total.

    <item>What is the competitive ratio of Matlab's algorithm to the optimal
    (with <em|foresight>) algorithm?

    Assume the size of allocating with <em|foresight> is <math|N>, where
    <math|N = n + e>, <math|e> is the predicted extension and <math|n> is the
    array size <math|>originally <math|>demanded, <math|e\<geqslant\>1> and
    <math|n\<geqslant\>1>. We also assume that in total it involves at most
    <math|N> assignment to positions <math|\<leqslant\>N>.

    <\enumerate-alpha>
      <item>Competitive Ratio of Time

      For the original Matlab's algorithm, in the worst case, when every time
      the position we need to assign exceeds the original array length, we
      would need to do <math|<big|sum><rsub|i=1<rsup|>><rsup|N>i> times
      allocations for new array; we need to do
      <math|<big|sum><rsub|i=1><rsup|N-1>i> number of scale for elements
      shifting from original array to the new array; and we also need to do
      <math|<big|sum><rsub|i=1><rsup|N-1>>number of scale for freeing the
      original array. For simplicity, we can ignore the coefficient
      <math|a<rsub|alloc>, a<rsub|free>, a<rsub|assign>> and constant values
      <math|c<rsub|alloc>, c<rsub|free>, c<rsub|assign>> because they would
      be compressed in big-O notation. So the time complexity for Matlab's
      algorithm would be calculated as

      <\eqnarray*>
        <tformat|<table|<row|<cell|<below|<wide*|log(1)+log(2)+\<ldots\>+log(N)|\<wide-underbrace\>>|operations
        for allocation>>|<cell|+>|<cell|>>|<row|<cell|<below|<wide*|log(1)+log(2)+\<ldots\>+log(N-1)|\<wide-underbrace\>>|operations
        for freeing>>|+|<cell|>>|<row|<cell|<below|<wide*|1+2+\<ldots\>+N-1|\<wide-underbrace\>>|ops
        for copying>>|<cell|+>|<cell|>>|<row|<cell|<below|<wide*|N|\<wide-underbrace\>>|ops
        for assigning>>|<cell|>|<cell|>>>>
      </eqnarray*>

      <math|\<Rightarrow\>>

      <\equation*>
        <below|<wide*|log(N!)|\<wide-underbrace\>>|operations for
        allocation>+<below|<wide*|log((N-1)!)|\<wide-underbrace\>>|operations
        for freeing>+<below|<wide*|(N-1)(N-2)/2|\<wide-underbrace\>>|ops for
        copying>+<below|<wide*|N|\<wide-underbrace\>>|ops for assigning>
      </equation*>

      \;

      <\equation*>
        \<leqslant\>2N log(N)+<frac|N(N-1)|2>
      </equation*>

      which would finally dominated by the copying operations part,
      <math|O(N<rsup|2>)> in total.

      For the optimal algorithm, we only need to allocate once, the time
      complexity for allocating would be <math|O(log(N))> and for assigning
      would be <math|O(N)> and no need for shifting. The overall complexity
      would be dominated by the assigning part, that is, <math|O(N)> in
      total.

      So the competitive ratio between the Matlab algorithm and the optimal
      algorithm would be

      <\equation*>
        <frac|O(N<rsup|2>)|O(N)>
      </equation*>

      <item>Competitive Ratio of Memory Usage

      For the Matlab algorithm, in the worst case, we would allocate new
      array, which is 1 bigger in size than the original one when the index
      exceeds the array boundary. It would take at most <math|N + N-1> number
      of memory at once, where <math|N> is for the newest array, <math|N-1>
      is for the original array, waiting for shifting. <math|N-1> size of
      memory would be freed in the end. So the memory usage would be
      <math|O(N)> overall.

      For the optimal algorithm, we allocate only once and it is the final
      size. So it would be <math|O(N)> overall as well.

      The competitive ratio between the Matlab algorithm and the optimal
      algorithm would be

      <\equation*>
        <frac|O(N)|O(N)>
      </equation*>
    </enumerate-alpha>

    <item>Improvement. Every time we are forced to expand an array, instead
    of expanding it only as much as is necessary, we now round up to the
    nearest power of 2 size. Write pseudocode for the new strategy.

    <\code>
      assign(array, value, i, n):

      \ \ \ \ if i \<less\> n:

      \ \ \ \ \ \ \ \ array[i] := value

      \ \ \ \ else:

      \ \ \ \ \ \ \ \ newSize := <math|2<rsup|\<lceil\>log<rsub|2>(i)\<rceil\>>>

      \ \ \ \ \ \ \ \ memPtr := allocate(newSize)

      \ \ \ \ \ \ \ \ free(array, n)

      \ \ \ \ \ \ \ \ array := memPtr

      \ \ \ \ \ \ \ \ array[i] := value
    </code>

    <item>Analyze your pseudocode: What is its competitive ratio with OPT?
    How does its memory use compare with OPT? How does its memory use compare
    with the original Matlab implementation?

    <\enumerate-alpha>
      <item>Competitive Ratio of Time

      We are doing assignment with array index <math|i>, where <math|i> is
      from 1 to <math|N>. For convenience of computation, we let
      <math|N=2<rsup|k> (i.e, k = log(N)), k\<geqslant\>0>. We also assume
      that in total it involves at most <math|N> assignment to positions
      <math|\<leqslant\>N>.

      For the algorithm given above, in the worst case when every time for
      assignment the index exceed only 1 of the original size, the overall
      space scale we need to allocate is <math|<big|sum><rsub|i=1><rsup|k>2<rsup|i>>
      for the reason that we round up the nearest power of 2 size everytime
      and given any consecutive index access between <math|[2<rsup|i-1>,
      2<rsup|i>)> there is no need to assign again.

      For simplicity, we can ignore the coefficient <math|a<rsub|alloc>,
      a<rsub|free>, a<rsub|assign>> and constant values <math|c<rsub|alloc>,
      c<rsub|free>, c<rsub|assign>> because they would be compressed in big-O
      notation. So the time complexity for this algorithm would be calculated
      as

      <\eqnarray*>
        <tformat|<table|<row|<cell|<below|<wide*|log(2<rsup|1>)+log(2<rsup|2>)+\<ldots\>+log(2<rsup|k>)|\<wide-underbrace\>>|operations
        for allocation>>|<cell|+>|<cell|>>|<row|<cell|<below|<wide*|log(2<rsup|1>)+log(2<rsup|2>)+\<ldots\>+log(2<rsup|k-1>)|\<wide-underbrace\>>|operations
        for freeing>>|+|<cell|>>|<row|<cell|<below|<wide*|2<rsup|1>+2<rsup|2>+\<ldots\>
        +2<rsup|k-1>|\<wide-underbrace\>>|ops for
        copying>>|<cell|+>|<cell|>>|<row|<cell|<below|<wide*|N|\<wide-underbrace\>>|ops
        for assigning>>|<cell|>|<cell|>>>>
      </eqnarray*>

      <math|\<Rightarrow\>>

      <\equation*>
        <below|<wide*|log(2<rsup|1+2+3+\<ldots\>+k>)|\<wide-underbrace\>>|operations
        for allocation>+<below|<wide*|log(2<rsup|1+2+3+\<ldots\>+k-1>)|\<wide-underbrace\>>|operations
        for freeing>+<below|<wide*|2<rsup|k>-2|\<wide-underbrace\>>|ops for
        copying>+<below|<wide*|N|\<wide-underbrace\>>|ops for assigning>
      </equation*>

      <\equation*>
        \<leqslant\>2\<times\><frac|k(k-1)|2>+2<rsup|k>-2+N
      </equation*>

      So, the overall complexity would be dominated by the copying part,
      namely <math|O(2<rsup|k>)>. Substituting <math|k> with <math|log(N)>,
      the competitive ratio between the Matlab algorithm and the optimal
      algorithm would be

      <\equation*>
        <frac|O(N<rsup|2>)|O(N)>
      </equation*>

      <item>Competitive Ratio of Memory Usage

      For this algorithm, we keep assigning from 1 to <math|N>, where
      <math|N=2<rsup|k>>, <math|k\<geqslant\>0>. We will keep reallocating at
      an interval of <math|2<rsup|i>-2<rsup|i-1>>, <math|i> is from 1 to
      <math|k>. It would take at most <math|2<rsup|k> + 2<rsup|k-1>> number
      of memory at once, where <math|2<rsup|k>> is for the newest array,
      <math|2<rsup|k-1>> is for the original array, waiting to be shifting.
      <math|><math|2<rsup|k-1>> size of memory would be freed in the end.
      Substituting <math|k> with <math|log(N)>, we will get <math|O(N)> space
      complexity.

      The competitive ratio between the Matlab algorithm and the algorithm
      here we are trying to optimize would be

      <\equation*>
        <frac|O(N)|O(N)>
      </equation*>
    </enumerate-alpha>

    <item>Instead of rounding up to the nearest power of 2, repeat the
    calculations assuming we round up to the nearest power of <math|c>, for
    some constant <math|c\<gtr\>1>. Reason about the <math|c> you pick.

    \;
  </enumerate-numeric>

  <new-page>

  <subsection|Problem 3.>

  <\enumerate-numeric>
    <item>
  </enumerate-numeric>
</body>

<\initial>
  <\collection>
    <associate|language|american>
  </collection>
</initial>

<\references>
  <\collection>
    <associate|T1|<tuple|1|?>>
    <associate|auto-1|<tuple|1|1>>
    <associate|auto-2|<tuple|2|2>>
    <associate|auto-3|<tuple|3|?>>
  </collection>
</references>

<\auxiliary>
  <\collection>
    <\associate|toc>
      <with|par-left|<quote|1.5fn>|Problem 1.
      <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-1>>

      <with|par-left|<quote|1.5fn>|Problem 2.
      <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-2>>

      <with|par-left|<quote|1.5fn>|Problem 3.
      <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-3>>
    </associate>
  </collection>
</auxiliary>