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

      \ \ \ \ if i \<less\> n then:

      \ \ \ \ \ \ \ \ array[i] <math|\<leftarrow\>> value

      \ \ \ \ else:

      \ \ \ \ \ \ \ \ newSize <math|\<leftarrow\>>
      <math|2<rsup|\<lceil\>log<rsub|2>(i)\<rceil\>>>

      \ \ \ \ \ \ \ \ memPtr <math|\<leftarrow\>> allocate(newSize)

      \ \ \ \ \ \ \ \ free(array, n)

      \ \ \ \ \ \ \ \ array <math|\<leftarrow\>> memPtr

      \ \ \ \ \ \ \ \ array[i] <math|><math|\<leftarrow\>> value
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
        \<leqslant\>2\<times\><frac|k(k-1)|2>+2<rsup|k>-2+2<rsup|k>
      </equation*>

      So, the overall complexity would be dominated by the copying and
      assigning part, namely <math|O(2<rsup|k>)>. Substituting <math|k> with
      <math|log(N)>, the running time complexity of this algorithm would be
      <math|O(N)>. The competitive ratio between the OPT algorithm and this
      algorithm would be

      <\equation*>
        <frac|O(N)|O(N)>
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

      The competitive ratio between the OPT algorithm and the algorithm here
      we are trying to optimize would be

      <\equation*>
        <frac|O(N)|O(N)>
      </equation*>
    </enumerate-alpha>

    <item>Instead of rounding up to the nearest power of 2, repeat the
    calculations assuming we round up to the nearest power of <math|c>, for
    some constant <math|c\<gtr\>1>. Reason about the <math|c> you pick.

    <\eqnarray*>
      <tformat|<table|<row|<cell|c<rsup|1>+c<rsup|2>+\<ldots\>+c<rsup|k>>|<cell|=>|<cell|<frac|c(1-c<rsup|k-1>)|1-c>>>|<row|<cell|>|<cell|=>|<cell|<frac|c-c<rsup|k>|1-c>>>>>
    </eqnarray*>

    because

    <\equation*>
      c<rsup|k>\<less\>c\<times\>n
    </equation*>

    <math|\<Rightarrow\>>

    <\equation*>
      c<rsup|1>+c<rsup|2>+\<ldots\>+c<rsup|k> \<less\>
      <frac|c-c\<times\>n|1-c>
    </equation*>

    <next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line>

    \;
  </enumerate-numeric>

  <new-page>

  <subsection|Problem 3.>

  <\enumerate-numeric>
    <item>The amount of memory used by the standard dynamic programming
    approach to edit distance is <math|O(n<rsup|2>)>, which is the same order
    as the amount of time the algorithm takes; while we might be happy
    waiting for several billion CPU cycles, our code might crash on current
    hardware if it also demands several billion memory locations.
    Fortunately, we do not need to store the whole two-dimensional table: it
    is enough to store just the current row being computed, and the previous
    row that we have just finished computing. Write pseudocode for this
    strategy.

    <\code>
      edit_distance(s1, s1_len, s2, s2_len):

      \ \ \ \ create 2D array M[2][s2_len + 1]

      \ \ \ \ for j <math|\<leftarrow\>> 1 to s1_len do:

      \ \ \ \ \ \ \ \ M[0][j] <math|\<leftarrow\>> j

      \ \ \ \ for i <math|\<leftarrow\>> 1 to s2_len do:

      \ \ \ \ \ \ \ \ M[i % 2][0] <math|\<leftarrow\>> i

      \ \ \ \ \ \ \ \ for j <math|\<leftarrow\>> 1 to s1_len do:

      \ \ \ \ \ \ \ \ \ \ \ \ if s1[i - 1] <math|=> s2[j - 1] then:

      \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ M[i % 2][j] <math|\<leftarrow\>> M[(i -
      1) % 2][j - 1]

      \ \ \ \ \ \ \ \ \ \ \ \ else:

      \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ iPrev <math|\<leftarrow\>> M[(i - 1) %
      2][j]

      \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ jPrev <math|\<leftarrow\>> M[i % 2][j -
      1]

      \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ ijPrev <math|\<leftarrow\>> M[(i - 1) %
      2][j - 1]

      \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ M[i % 2][j] <math|\<leftarrow\>>
      min(iPrev, jPrev, ijPrev) + 1

      \ \ \ \ return M[(s1_len - 1) % 2][s2_len]
    </code>

    <item>Describe, in a few sentences, and using concepts from lecture
    and/or your knowledge of systems why and how this approach is an
    improvement.

    In this strategy, we only need to use <math|2n> memory and optimally the
    entire table could be loaded in cache and new value could be renewed just
    in cache.

    <item>Find a way to lay out the entries of the table in memory so that
    when the two letters are the same, instead of doing a memory copy, the
    algorithm <with|font-shape|italic|does nothing>. Write pseudocode for the
    edit distance problem where the <with|font-shape|italic|same> memory
    address is used for location <math|(i-1, j-1)> and for location <math|(i,
    j)>.

    <\code>
      edit_dist_relayout(s1, s1_len, s2, s2_len):

      \ \ \ \ create array M[s2_len + 1]

      \ \ \ \ for j <math|\<leftarrow\>> 0 to s1_len do:

      \ \ \ \ \ \ \ \ M[j] <math|\<leftarrow\>> j

      \ \ \ \ for i <math|\<leftarrow\>> 1 to s2_len do:

      \ \ \ \ \ \ \ \ if s1[0] <math|\<neq\>> s2[i - 1] do:

      \ \ \ \ \ \ \ \ \ \ \ \ M[0] <math|\<leftarrow\>> min(M[0], M[1], i) +
      1

      \ \ \ \ \ \ \ \ for j <math|\<leftarrow\>> 2 to s1_len do:

      \ \ \ \ \ \ \ \ \ \ \ \ if s1[j - 1] <math|\<neq\>> s2[i - 1]:

      \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ M[j - 1] <math|\<leftarrow\>> min(M[j -
      2], M[j - 1], M[j]) + 1

      \ \ \ \ return M[s2_len]
    </code>

    <item>Describe in a few sentences how your algorithm works, and why it is
    correct.

    <\with|par-mode|center>
      <small-table|<block*|<tformat|<cwith|2|2|2|2|cell-background|yellow>|<cwith|1|2|1|1|cell-background|pink>|<table|<row|<cell|<math|a<with|color|white|>>>|<cell|<math|b>>>|<row|<cell|<math|<with|color|white|>c<with|color|white|>>>|<cell|<math|d>>>>>>|<with|mode|math|a=M[i-1][j-1],
      b=M[i-1][j], c=M[i][j-1], d=M[i][j]>>
    </with>

    For the algorithm in <with|font-shape|italic|Question 1>, for every
    current iteration of <math|i> and <math|j>, we access 4 unit in the
    table. Let them to be <math|a=M[i-1][j-1], b=M[i-1][j], c=M[i][j-1],
    d=M[i][j]>. We'll no longer need <math|c> and <math|a> after the current
    iteration (color in RED) and will yank one new table unit <math|d> for
    next iteration (color in YELLOW). So the intuition is that if we could
    replace <math|a> or <math|c> with new value <math|d>, the benefit would
    be that we don't need to copy <math|a> and generate new value <math|d> if
    <math|s<rsub|1>[i] =s<rsub|2>[j]> since the result of previous
    calculation has already been stored in <math|a>.

    <\with|par-mode|center>
      <small-table|<block*|<tformat|<cwith|1|1|2|2|cell-background|yellow>|<cwith|1|1|1|1|cell-background|pink>|<table|<row|<cell|<math|a>>|<cell|<math|c>>|<cell|<math|b>>>>>>|<with|mode|math|a=M[i-1][j-1],
      b=M[i-1][j], c=M[i][j-1]>>
    </with>

    After re-layouting the table, for next iteration, we will need entry
    <math|c, b> again, where <math|c> might be renewed and <math|b> is the
    current diagonal value.

    <item>

    <next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line>

    <item>In all of the above variants of the edit distance algorithm, we are
    computing the same entries of the same table, in the same
    order<emdash>just storing them differently. However, there is a different
    order of computing these entries that may have some advantages: diagonal.
    We start at (0, 0), and in round <math|r>, for <math|r\<leqslant\>n>,
    compute the entries along the diagonal going from (<math|r>, 0) to (0,
    <math|r>); after <math|n> rounds of this, we next compute the entries in
    the diagonal from (<math|n>, 1) to (1, <math|n>), and so on. Write
    pseudocode for this and explain why it works.

    <\code>
      edit_dist_diagonal(s1, s1_len, s2, s2_len):

      \ \ \ \ create 2D-array M[s1_len + 1][s2_len + 1]

      \ \ \ \ for j <math|\<leftarrow\>> 0 to s2_len do:

      \ \ \ \ \ \ \ \ M[0][j] <math|\<leftarrow\>> j

      \ \ \ \ for i <math|\<leftarrow\>> 1 to s1_len do:

      \ \ \ \ \ \ \ \ M[i][0] <math|\<leftarrow\>> i

      \ \ \ \ for i <math|\<leftarrow\>> 1 to s1_len do:

      \ \ \ \ \ \ \ \ for j <math|\<leftarrow\>> 1 to i do:

      \ \ \ \ \ \ \ \ \ \ \ \ if s1[i - j] <math|=> s2[j] do:

      \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ M[i - j][j] <math|\<leftarrow\>> M[i -
      j - 1][j - 1]

      \ \ \ \ \ \ \ \ \ \ \ \ else:

      \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ M[i - j][j] <math|\<leftarrow\>>
      min(M[i - j - 1][j],\ 

      \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ M[i
      - j - 1][j - 1],\ 

      \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ M[i
      - j][j - 1]) + 1

      \ \ \ \ for j <math|\<leftarrow\>> 1 to s2_len do:

      \ \ \ \ \ \ \ \ for i <math|\<leftarrow\>> j to 1 do:

      \ \ \ \ \ \ \ \ \ \ \ \ if s1[i - j] <math|=> s2[j] do:

      \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ M[s1_len - (i - j)][j]
      <math|\<leftarrow\>> M[s1_len - (i - j) - 1][j - 1]

      \ \ \ \ \ \ \ \ \ \ \ \ else:

      \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ M[s1_len - (i - j)][j]
      <math|\<leftarrow\>> min(M[s1_len - (i - j) - 1][j],\ 

      \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ M[s1_len
      - (i - j) - 1][j - 1],\ 

      \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ M[s1_len
      - (i - j)][j - 1]) + 1

      \;

      \ \ \ \ return M[s1_len][s2_len]
    </code>

    Since we are doing diagonal computation for <math|m\<times\>n> table,
    everytime <math|M[i][j]> depends on the values <math|M[i - 1][j-1],
    M[i][j-1], M[i-1][j]> and they are all have been computed by prior
    diagonal computation.

    <item>Plot the rate of getting work done as a function of <math|k>, for a
    workload of 1,000,000 units. What is the best number of processors to
    use?

    Let the rate of getting work done to be <math|R>.

    <\equation*>
      R=<frac|1,000,000|k>+1,000k
    </equation*>

    Plot <math|R>:

    <\with|par-mode|center>
      <postscript|<tuple|<#89504E470D0A1A0A0000000D494844520000015F0000007D08020000008AC4F75F0000000373424954080808DBE14FE00000001974455874536F66747761726500676E6F6D652D73637265656E73686F74EF03BF3E0000115549444154789CEDDD7F681B679A07F0676F6578072C9881183447CC7A6E2DD0986459892EC4228195482191B7B0752EC7D52629B1365712DF05BAE9DEB164BB844BD3E3B20907C92A654BE470D7D8853476A089DD425A0536172934676959DB1AB1321973091971367987DA78066CD0FD31AE9B5AB22CCB1A8DC67A3E7F29AFDFB19E51E56FE7C73BEFFBBD7C3E0F082154E0AFAC2E002154A7301D1042C5613A986E7068D0EA1210AA04A60342A8384C07D3C9336AFC816C7515086D1AA683E9941C95246A7515086D1AA683E92429657509085502D3C1743EB153D775ABAB4068D3301DCCE7006DD9EA1A10DA3C4C07845071980EE6733080C70EC886301D4C274B49BCEE80EC08D3C174E26E9FD5252054094C07845071980EA6230ED0F1BA03B2214C07F33940D735AB8B4068D3301D4C979A4C5A5D024295C074305DE72B3E6DC1EA2210DA3C87D505D4949C95C327C3B17B3100A0B3347A3D2AEE16A509A9F7482FCFF3852DC656E5F45C6F5B00002056EC2B425BD540C70E9AA6A5A7D3AB03932E5DB9140C04BB0E760503C1C80791A22DE5F75C6F5B006008E80B38DE01D94F03A543EC8B58D7C1AED57FA65229D1230280E811538F53455BCAEFB9DEB60090FC9FB82C27CCDF3F84AAAC51CE2C928F93BE57BE332A495BD018C20000E364345D2BDA527ECFF5B60500FFDEA08A870EC8861A251DCEBF7F9EAA2B53B00403C1E19BC34C33A3E91AD3C468F3DFFC6117B418CAE9B9DEB608D957A39C590CDF1E8EDD8FC5EEC70020763FC6B5705EAF57CA4800206524EF4FBC0050D86228A7E77ADB82311A6ABE56FB8950F57CFFECD9B356D7502B4B303A369A4824DC3F74B7FEA055F48837876FCE2FCC3F78F8E0ADE36F399DCEC21663BB727AAEB72D004C4C4C7CF527FDCDA3F8B405B299EFE15A5866EB3FD59F4AF9E20FC2561782D0E634CA998585FC7BFC1C8E78403684E950130ED0F0490B6437980EB5409C445FC078403683E9500B841015874B22BBC174305DFC519C6D261A8603B21B4C07D3F9F7F81907E0D492C876301D6A813433F82016B21D4C875A60594255BC2A896C06D3A1169866A2E2606A6437980EA68B3F8AC3B22E4FAB561782D0E6603A98CEBFC74F1C44FDE6095184ECA2519EE00680C8E508BB83D5177417EFEA7AADAB8633C781B89B939FE1B103B2994639769065597E26F7F6F4F61CE9B97AF52AD470E638006077B04A0E8F1D90CD344A3A088270F1C2450050E754E22450C399E30080771175B651EF682E41F231BD7821FEDEBFC62E5E885B5D0DDA84063AB300005882E8F5E8995F9F811ACE1C177F140700AAEBB004D054A31DB596A268D2644E929474864AD91CCFB3C401DD877DBE5DACD5A5A14D68A074D0346DE8A3A1F0F1B07151A06633C7F9F7F87B7B7AC7EE0E2A39CAB77235DDE75AA1549332AA34A14819459254E204AF871777BB0201A1C3C33748266E3F0D940E910F22FD27FA1986D1348D611863AE37DF4F7C6B667F7BB9C5504ECFF5B65DC5EF64E5673ADF5AABBD35DB12A4A7A934A948524E9A54D4795D145DA287EF3EEC133D2CC7E1CC9ADB41A3A4C3E867A3890709795A06005DD7A303D1FE13FDD1EB51654E49A552FD27FA01A0B0C5504ECFF5B65D25B6F37256F177F2853FB20B59A6E98C2249AA34A9E49EAA6D02DBB18BF7770AE163DEED7A4CD4E070E638D30D0E0DF6F6F4C6EECBB17BF27BEF07AD2E671394A754CAA8C6E583996CCEC5B3A287174556F0F01DED1C9E2F6C7B8D72EC60A1F8A3786F4FAFB0D3154FC4ACAE6503DFBD7C90238488222F7AD8F0719FE8E1193C5D6830980EA6F3EFF10380E066F8162267A9E0AEA383706D1EA48C22651529A34A19459F075164450FDFFD7A87F8EB20D78279D0D0301D6AC7BF5788DD97C396A683360FD2B4224954CEE4A46945A5BAE876091E3E1810FA4F74F23CC601FA16A643ED845E13DFF9E558F898AF9667EC9A06B1CFD3EABC2E4DAB724651A9DE26BA3A3C9C3F20848F77F2AD1807685D980EB523089CE8E62F5E49BEF34B1357BEA1B39A34ADCA59459A56E56945A53A7112EF8FF960A7201CF30A421D9DD7A03A87E9603AE3AAA4F1BAE70DEF3FFEF348E8A0D02156E9AF7409E4192ACFA872964AD38A9455890304372BB6F3A18020E0C902DA02BCA3693AE38EE6EA3FE309E5FCFBB1BE37BC877A3A36FDBB96407E4695195592A93CA3CAD3549955059E15DA39A1DD25BA39A11D4722A1AAC17430DD9A74000059A2E15323422BEBDF2B8822EF7FA560ACF112C833545B0635A72A735A4E51E519AA3C5395599DE759A18D13DA5841E084365668C37107C82C980EA62B4C0743F2B132F4715296553AA71739C35B064164F91D1CEF22AE56967771C24E9677319805A866301D4CD77FAA3F7279ED8C0F6B681AA8731A804E9A398E00E0C901AA037855D274C668A8D218069856065361437496722D1CA574E8E3A1FE93459E6731C4EEC52449020794E8535D834383EA9C0A0E208474BFDECD711C0068F3DAD02743BAAEBB5A5C877E7EC838EE2BDAB86209E28FE2FE7D1B7F61B6F88EC6C7B8F17BE491C96E0CDEB0BA846DE2E11F1F2E7EBD98CFE7A7D253B7466EADD76D7171F1DCF97335AC2B9FCFE79FFCE589F1623C397E2D7ACD787DEBE6ADF1E4783E9FBF3B76F7E11F1F9668342C7EBDF8BB7FFF5D0DDE71717171CD5B1765E2DC50834383E6FD721BD560CCFE62AD7AF81CB658435A4A830318270300B95C4ED82900407A221D1D8852FA9D59F906AE0FC03244AE46225723DABC76F1C2C5D1CF46A31F46D313694551A21F4623572383FF35A8691A00181D62F762D10FA391CB115996575F2B4F95F2CB13DCC2CA8B3661756523292BF976F900C0B7CB2765A5128D2B957F34A0EBBA51390014565BAD7764188610929E4897DE290B668E2BF12DA9FA8FEAB986125BD5430D257E54F51ACA914824C476D178AD3C55B81DDCE89D5179460E1F091B07D5ABFA8EF41142FA4FF61BA715BAAE0B6D42F81FC21DBB3B466E8F74EEEBEC3FD92F08C2D8E76346FFD50E815703831F0F1AAF43074363F7C62AA833FEDF7151140160E5EFB90900806559AAD2F51AD7ABBC68B5D57A47A15D482412A5F7A59AD71D0ABF1935FBF6D7EC2B5EC18F2449EA3FD5BFDED507CBCBABEC475BFC6D456FE294A6E4148EE5565F8F7D36D6D9D9E9F39631EAD4011D620700C012D0396ABC167789A98F52AB1D8CFF0F1BC723C66B97CB4537BFC840F27132A7E4C2C7C29BDDB088F5AAADD23B721CA7CC6D707054CD74A8E03F7983C04FA63A9A000028A54C33C3B22C2C97B5117190F23B7CA773C1EF8F0E44D7B484FBBEFDB34CA69289C789BE637D469D8CF1C4FB124013A80BAA116D451B2BB6D577DCE803C47B16C81EB866CE98F24FC9292EDE75E86787A2D7A31CCBAD9E7E6FAC09B81D9C9C9505B7204D4A6D42DB666B78390BD6484FA4138944DFB13EE6A5693044B7989C4CFABCBEE49F92A25B2CD1686008A32F7F3377F946D56EF11D354DDB309B301D903DB4B9DB72CF72825BC8E572BC8B8726E879A367E0FA407773F79AB5854AE87EBD7BECCE987E4F679BD9EEC3DD552C6FE4F608692603D70700806D667B8FF60240E84068E893A14422E16A71F9F7AF9C5A166D5CD104DEDDDEC8E588712FB674B55B7CC75C2ED7E66E2BBD53381ACA74EB8D95449BA2695AEC8B58D76B5D5617B24D8C7E361AFC69902939E157A3AC7663A17AB8A3B90D300CE3DFEB97B3B2D5856C07B22CFBF7F84B4703E099C5C696409ED6E467396D195445933232BB839326151D8025A4C3C3D105BDFB75B1C4AA0DE58C9544E5E0386ECDCD4B54194128EB624D95D3A1E2956CAB88523A76676CE893A1D13BA32B2DE52FA8AB68F233559EA1F253559EA1B9A72A55758E25A409C41FF384107030A2C0EACB00CB3AD74C48339127954B57E27256F5EF134EBFDD69E103D45BD9F12AAA87EF00AA8E32876D9635B4F3C993D3BF3A6D8CD30C1D08E5F3F933EF9E19FF6A3C9FCF8F7F357EE6DD33455B4C12F86960F5F57A65BC78B17863F0CBBE63A7CF9DFFB2EFF8ADC0FE6BDD876F9C7EFBEEEF2F3DBC353235FED5F3E7CF17CB7CBB274F5EFC3E321E3A70E3C6E0D49A1FD5782475393B9E37EDF3AFABEF00DA22539EB378FEBFCFBB0F77E7F3F9D0CF42C6C0F8C5AF57BE2B852D2679F98F64F54D9FFCE545607FE8DA1FC603FB43DD3FBF163A70E3F4895B81FDA1BB9F4E4DA55F2C961B05EBBAFBE954E8C08DA9F48B971B2D4C070B3FFF7AF80EA02D32E1BA43452BD99A6209928F1465816A0BDA3BFF129BC9E6D81602CB1A2100CBDAB5AB3D1CCF00403010E97A6DF3D33415D3F55A07C732E7CF8D0DFE67EFEA658897678EAB31CB3EFFFAF90EA02DA8241DFA4FAD7D2A7675FE828A57B2AD4E199722F20C4D671429AB02405728AA01040302E3607A8F7478777501687FFB7743BD477D439F30A4190060EB65ACE1DF2744AF27DFFBB7D86F7EBBB2EC958557254DFDFCD753CBEF00325525E950622E938A57B2ADB80C59A6E98C2A498A9C5182A128DFC28ABB38D1ED0280D1B1B0F13FF0DFE831E2A08C53483EAE7E1985C2C7FD912B757117D3D4CF7F3DB5FC0E205355F3CC622B2BD9964F51342993932694F4349DC9E6D81656F470A2DB157A5510DA7986014AA931C460F4F351FF5E3FC77166945182BF938F5CD16599D6787AF86F77FC8E353B0EB5FA0EA0DAB0C158493AAB49999C245129A34892CA3A41F0F0A2C7258A5CDD2EEE18B91C677790DE1E1FE05849645BF5381A6A6571474931168086E595C51D7B0EFBC45DAC31FF479DF37AF9913BE9DE1E004BAF4A22B415F5910E4B204FD3644691A49C3449D559B5CDEDEAF070C15785FE7FB2E57A2DE22E977C61E5D2038E95443665593A284F8DF305259DA133D99CAB95153DBCD72BF4BE61D66A6E158FE12BA7679196050B2E3D20544D351B59F1E2C5E2C3F8F36B7F183FFDF6DDD0816B3D876F9C7BF7CB5B37A7A6FEFC7CEBC39036B495317CE5F42C6C3979E2EE54F2791E679D45B665E6B1C312A43354CA28D2442E9551F4795D74BBC45D7CF7619FE8A9F5826E82205CBC701100D43995380900A452A933BF3A0300A2474CFD3655B4C5504ECFC2166127273FA31D5E7C8800D99529E9204BF4BDFF88E564B5CDCD767878FF3E217CDCCBB7D6C131764563F8CAE959D8C2EF243945876F9EE0C60B93C8764C4907D74EEEF4DBC18E760B967834631C67393D0B5BD8162E959201C0BFC78FD180ECC89474609C50B515E837C98C719CE5F42C6CE17790FB73F81001B2B1FAB8A369BEAD8CE12BA767610BC712AAEAC5AB41C80E6C3056D2A628D57E717464F84E6F39ABEC225487705E49B370CD0C5DD001474321DBC274304D1330040A563F44C836301D4C4408D117301E905D613A9888751275012F4C22BBC27430116926DA02AE6781EC0AD3C1440C015DD7F1AA24B2294C071329737A6A628345D011AA5B980E26127672AC7383E5E111AA5B980E26627710D2288351D13684E960228680BE8C5725915D613A98883888AEE155496457980E2622CDA0E37007645BDF3F7BF6ACD535D48E9C950FFDFDA1378FBE09007496462211FA35FDF4F6A7C2DF084EA7B3B0C5D8AA9C9E45B7CD4E53F5FF1648B3FAA3DD3FB272B711AA48031D3B689A969E4EC3F2CA3F2F5DB9140C04BB0E760503C1C80791A22DE5F72CBA2D7180B60C08D95403A543EC8B58D7C1AED57FA65229D123823113E4E354D196F27B16DD96218CAEEBF147F1C1A1C15AED254255D328E9907C9CF4BDE27BB9C5EC792557E1CC71C8A6B6D5EDF812934A9E7FFF3C55A9F13A18080EDF1C367B5E49000007E87866816C6B5BA543892998866F0F1B2F828160EC7E0C36B33E7565F34A82F104B78E4F7023BB6AA47B164B303A369A4824DC3F74B7FEA055F48837876FCE2FCC3F78F8E0ADE36F399DCEC21663BB727A16DD7636B730F16785FF6B1DEF59203BC279254D949E50221F24C13186F34A223B6A94AB9216C2B192C8A6301DCCE420FA320E96447685E960228600603820DBC27440081587E9603A7C821BD914A683895842549C5712D916A68399B6D55833D470301D1042C5613A988810469FC79B16C8AE301DCCE400C0AB92C8B6301D4C875725914D613A988871C0C95341ABAB40A842980E666A82AE8382D5452054217C461321541C1E3B20848AC37440081587E980102A0ED30121541CA60342A8384C07845071FF0FAD14474F33537DF90000000049454E44AE426082>|png>|*5/8|*5/8||||>
    </with>

    We know that given any real number <math|a> and <math|b>

    <\equation*>
      <with|mode|text|<math|(a+b)<rsup|2>\<geqslant\>0>>
      \ \ \ \ \ \<Rightarrow\> \ \ \ \ \ \ \ a<rsup|2>+b<rsup|2>+2 a
      b\<geqslant\>0 \ \ \ \ \ \ \<Rightarrow\>
      \ \ \ \ a<rsup|2>+b<rsup|2>\<geqslant\> 2 a b
    </equation*>

    <math|R> could be represented with the above form

    <\eqnarray*>
      <tformat|<table|<row|<cell|R>|<cell|=>|<cell|(<frac|1,000<rsup|>|<sqrt|k>>)<rsup|2>+(10<sqrt|10k>)<rsup|2>>>|<row|<cell|>|<cell|\<geqslant\>>|<cell|20,000<sqrt|10>>>>>
    </eqnarray*>

    The minimum rate should be <with|mode|math|20,000<sqrt|10>> and therefore
    the best number of processors to be use is
    <math|\<lceil\>10<sqrt|10>\<rceil\>=32>.

    <item>What is the general formula for the best number of processors to
    use?

    Let the rate of getting work done to be <math|R>.

    <\eqnarray*>
      <tformat|<table|<row|<cell|R>|<cell|=>|<cell|<frac|w|k>+k
      p>>|<row|<cell|>|<cell|=>|<cell|(<sqrt|<frac|w|k>>)<rsup|2> + (<sqrt|k
      p>)<rsup|2>>>|<row|<cell|>|<cell|\<geqslant\>>|<cell|2<sqrt|w p>>>>>
    </eqnarray*>

    The minimum rate should be <with|mode|math|2<sqrt|w p>> and if we
    substitute <with|mode|math|2<sqrt|w p>> into the equation
    <with|mode|math|<tabular|<tformat|<table|<row|<cell|R>|<cell|=>|<cell|<frac|w|k>+k
    p>>>>>> we could get the best number of processors to use is
    <math|<sqrt|<frac|w|p>>>.

    \;
  </enumerate-numeric>

  <new-page>

  \;

  <subsection|Problem 4.>

  <\enumerate-numeric>
    <item>Write pseudocode to look up location of a key in a <math|k>-ary
    search tree.

    <\code>
      lookup(currRoot, key):

      \ \ \ \ if currRoot not exists:

      \ \ \ \ \ \ \ \ return NOT_FOUND

      \ \ \ \ for i <math|\<leftarrow\>> 1 to k do:

      \ \ \ \ \ \ \ \ if currRoot.keys[i - 1] \<gtr\> key then:

      \ \ \ \ \ \ \ \ \ \ \ \ lookup(currRoot.children[i - 1], key)

      \ \ \ \ \ \ \ \ else if currRoot.keys[i - 1] <math|=> key then:

      \ \ \ \ \ \ \ \ \ \ \ \ return currRoot.children[i - 1]

      \ \ \ \ if i <math|=> k then:

      \ \ \ \ \ \ \ \ lookup(currRoot.children[i], key)
    </code>

    <item>Given a search tree with <math|n> nodes, what is its depth?

    <\eqnarray*>
      <tformat|<table|<row|<cell|k<rsup|0>+k<rsup|1>+k<rsup|2>+
      \<ldots\>+k<rsup|d+1>>|<cell|=>|<cell|n>>|<row|<cell|<frac|(1-k<rsup|d+1>)|1-k>>|<cell|=>|<cell|n>>|<row|<cell|d>|<cell|=>|<cell|log<rsub|k>(n
      k-n+1)-1>>>>
    </eqnarray*>

    <item>How long does a linear search for a random element in a list of
    length <math|k-1> take, under these rules?

    <\equation*>
      <frac|1|k-1><big|sum><rsub|j=1><rsup|k-1>(<below|<wide*|<frac|j|c>\<times\>t|\<wide-underbrace\>>|loading
      cache>+<below|<wide*|j|\<wide-underbrace\>>|iterating the key list>+1)
    </equation*>

    <item>Taking the product of your results in the last two parts of this
    problem should give you an estimate for how long a simple lookup will
    take in your <math|k>-ary tree. Now we must decide: what value of
    <math|k> is best? Plot the time you have computed as a function of
    <math|k>.

    <next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line><next-line>

    <item>How to traverse?

    \;

    \;

    \;
  </enumerate-numeric>

  \;

  \;

  \;

  \;
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
    <associate|auto-2|<tuple|2|3>>
    <associate|auto-3|<tuple|3|7>>
    <associate|auto-4|<tuple|1|8>>
    <associate|auto-5|<tuple|2|8>>
    <associate|auto-6|<tuple|4|?>>
  </collection>
</references>

<\auxiliary>
  <\collection>
    <\associate|table>
      <tuple|normal|<with|mode|<quote|math>|a=M[i-1][j-1], b=M[i-1][j],
      c=M[i][j-1], d=M[i][j]>|<pageref|auto-4>>

      <tuple|normal|<with|mode|<quote|math>|a=M[i-1][j-1], b=M[i-1][j],
      c=M[i][j-1]>|<pageref|auto-5>>
    </associate>
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

      <with|par-left|<quote|1.5fn>|Problem 4.
      <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-6>>
    </associate>
  </collection>
</auxiliary>