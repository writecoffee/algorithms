<TeXmacs|1.0.7.4>

<style|generic>

<\body>
  <set-header|<compact-item|Silao Xu \ \ \ \ \ CS157 Algorithm Design
  \ \ \ <vspace*|1fn> \ Homework 1>>

  <\enumerate-numeric>
    <paragraph|Problem 1>

    \ \ \ \ <small-table|<tabular|<tformat|<table|<row|<cell|<math|i><math|/v>>|<cell|<math|s>>|<cell|<math|a>>|<cell|<math|b>>|<cell|<math|c>>|<cell|<math|t>>>|<row|<cell|1>|<cell|0>|<cell|+<math|\<infty\>>>|<cell|+<math|\<infty\>>>|<cell|+<math|\<infty\>>>|<cell|+<math|\<infty\>>>>|<row|<cell|2>|<cell|0>|<cell|1>|<cell|2>|<cell|+<math|\<infty\>>>|<cell|+<math|\<infty\>>>>|<row|<cell|3>|<cell|0>|<cell|1>|<cell|2>|<cell|4>|<cell|3>>|<row|<cell|4>|<cell|0>|<cell|1>|<cell|2>|<cell|4>|<cell|2>>|<row|<cell|5>|<cell|0>|<cell|1>|<cell|2>|<cell|4>|<cell|2>>>>>|Bellman-ford
    Shortest Path> <small-table|<tabular|<tformat|<table|<row|<cell|<math|i><math|/v>>|<cell|<math|a>>|<cell|<math|b>>|<cell|<math|c>>|<cell|<math|t>>>|<row|<cell|1>|<cell|<math|>null>|<cell|null>|<cell|null>|<cell|null>>|<row|<cell|2>|<cell|<math|s>>|<cell|<math|s>>|<cell|null>|<cell|null>>|<row|<cell|3>|<cell|<math|s>>|<cell|<math|s>>|<cell|<math|b>>|<cell|<math|b>>>|<row|<cell|4>|<cell|<math|s>>|<cell|<math|s>>|<cell|<math|b>>|<cell|<math|c>>>|<row|<cell|5>|<cell|<math|s>>|<cell|<math|s>>|<cell|<math|b>>|<cell|<math|c>>>>>>|Back
    Tracing of Previous Hop>

    From Table (1), we could do one more iteration loop for detecting cycle
    and since all columns are the same with the last iteration -- 5, we can
    assure that there is no cycle added to the shortest path.

    From Table (2), we can do backtracing from <math|T[5][t]>, the result
    <math|c> is the entry with which we should consult for previous iteration
    -- 4.\ 

    Finally, the shortest path <math|s\<rightarrow\> b\<rightarrow\>
    c\<rightarrow\> t> is found.
  </enumerate-numeric>

  \;

  <\enumerate-numeric>
    <paragraph|Problem 3>

    Let <math|f(t, n)> be the maximum value of <math|m> that is
    distinguishable using <math|t> tries and <math|n> eggs. The base case is
    that when we only have one trial left, given <math|n \<geqslant\> 1>, no
    matter how many eggs we are left, we could only do one more trial; when
    we only have one egg left, at most we could do <math|t> more trials,
    where <math|t \<geqslant\> 2>.

    <\equation*>
      <choice|<tformat|<table|<row|<cell|f(1,
      n)>|<cell|<with|mode|text|=>>|<cell|1>|<cell|for<htab|5mm> n
      \<geqslant\>1>>|<row|<cell|f(t, 0)>|<cell|=>|<cell|0>|<cell|for<htab|5mm>
      t=1>>|<row|<cell|f(t, 1)>|<cell|=>|<cell|t>|<cell|for<htab|5mm> t
      \<geqslant\> 2>>>>>
    </equation*>

    Suppose floor <math|x> is from which given <math|t> eggs and <math|n>
    eggs in total we drop our first egg. For every drop, there are two
    possible scenarios:

    <\enumerate-roman>
      <item>The egg didn't get broken, so we could still do further trials on
      the upper floor with the same number of eggs (<math|n>) and with one
      less trial (<math|t-1>).

      <item>The egg got broken, it means that critical floor <math|m> is
      between 0 to <math|x>. Also, we are only left with <math|t-1> trials
      and <math|n-1> eggs.
    </enumerate-roman>

    <math|f(t, n)> should be as capable as covering the current <math|x>
    floors and its upper floor if current egg did't break, so we have:

    <\equation*>
      f(t, n) = f(t-1, n) + x
    </equation*>

    To ensure scenario (ii) that we could still find out the critical floor
    <math|m>, in the Worst Case where every egg was dropped to be broken. So
    we have to ensure that <math|f(t-1, n-1)> should be big enough to cover
    the bottom <math|x-1> floors:

    <\equation*>
      x - 1 \<leqslant\> f(t-1, n-1)
    </equation*>

    We also want to be ambitious enough that the floor <math|m> could be
    found as soon as possible, so floor <math|x> should be chosen to be as
    maximum as possible. Now <math|f(t, n)> would be:

    <\equation*>
      f(t, n) = f(t -1, n) + f(t-1, n-1) +1
    </equation*>

    Now let <math|k > be number of floors for a building such that given
    <math|n> eggs and <math|t> tries, we are assured to find out the critical
    floor <math|m> from which the egg must be dropped to be broken, under the
    Worst Case Scenario where every egg was dropped to be broken. The problem
    is turned into finding the minimum trial limitation <math|s> that
    satisfies <math|f(s, n) \<geqslant\> k>. So we derive a dynamic
    programming approach for storing the intermediate results starting from
    <math|f(1, 1)> increasing <math|n> and we will end with <math|f(log(k),
    n)> doing binary search on <math|t> to find <math|s>.

    The time and space complexity are both <math|O(n log(k))>.
  </enumerate-numeric>

  \;

  <\enumerate-numeric>
    <paragraph|Problem 4>

    <item>Length of palindromic subsequence.

    <\enumerate-alpha>
      <item>a (1)

      <item>bcacb (5)

      <item>dbcacbd (7)

      <item>sallas (6)

      <item>aaaa (4)
    </enumerate-alpha>

    <item>Dynamic algorithm design for sub-palindrome problem.

    <\itemize-dot>
      <item>Let <math|T> to be a <math|N \<times\> N> matrix, where <math|N>
      denotes the length of the input sequence
      <math|x<rsub|0>x<rsub|1>\<ldots\>.x<rsub|n-1>>. <math|T<rsub|(i,j)>>
      means that we pick a sub-string from input sequence which starts from
      position-<math|i> and ends at position-<math|j>, where <math|i> and
      <math|j> satisfy the condition <math|i \<leqslant\> j>.

      <item>We will fill in the table from the diagonal line, which will be
      filled in from bottom-right to upper-left, to the upper-right corner.

      <item><math|T<rsub|(i, j)> = <choice|<tformat|<table|<row|<cell|max(T<rsub|(i+1,
      j)>, T<rsub|(i, j - 1)>)>|<cell|<with|mode|text|(if <math|j - i
      \<leqslant\> 1>)>>>|<row|<cell|2+T<rsub|(i \ + \ 1, j - 1)>>|<cell|(if
      x<rsub|i> = x<rsub|j>)>>|<row|<cell|j - i>|<cell|(otherwise)>>>>> \ >

      <item>Pseudo-code:

      <\code>
        sub_palindrome(string, i, j):

        \ \ \ \ if j - 1 \<less\>= 1:

        \ \ \ \ \ \ \ \ return 1

        \ \ \ \ if string[i] == string[j]:

        \ \ \ \ \ \ \ \ return 2 + sub_palindrome(string, i + 1, j - 1)

        \ \ \ \ else:

        \ \ \ \ \ \ \ \ return max(sub_palindrome(string, i + 1, j),\ 

        \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ sub_palindrome(string, i, j -
        1))
      </code>

      <item>Correctness and complexity:\ 

      <\enumerate-alpha>
        <item>Optimal Substructure

        We want the result with the longest subsequence which is a
        palindrome. Let sequence <math|S =x<rsub|m>x<rsub|m<rsub|>+1>\<ldots\>.x<rsub|n>>
        is the continguous subsequence with the maximum palindrome
        subsequence in it of the original sequence <math|X>, it could be
        narrowed down to 2 cases: (Case 1) <math|x<rsub|m>> matched with
        <math|x<rsub|n>>, the next optimal subsequence should be contained in
        <math|x<rsub|m+1>x<rsub|m+2>\<ldots\>.x<rsub|n-1>>; (Proof of Case 1)
        if <math|S>* is better than <math|S> with regarding to the sequence
        <math|x<rsub|m+1>x<rsub|m+2>\<ldots\>.x<rsub|n-1>>, then <math|S>*
        should be better than <math|S> with regarding to the sequence
        <math|x<rsub|m>x<rsub|m+1>\<ldots\>.x<rsub|n>>, which leads to
        contradiction with our assumption; (Case 2) otherwise, the next
        longest subsequence would be contained in either
        <math|x<rsub|m+1>x<rsub|m+2>\<ldots\>.x<rsub|n>> or
        <math|x<rsub|m>x<rsub|m+1>\<ldots\>.x<rsub|n-1>>, and since every
        time we pick the one with the longest palindrome subsequence we could
        assure that we have the optimal subsequence in case 2; (Proof of Case
        2) if the next longest subsequence is contained in
        <math|x<rsub|m+1>x<rsub|m+2>\<ldots\>.x<rsub|n>>, and <math|S>* is
        better than <math|S> with regarding to the sequence
        <with|mode|math|x<rsub|m+1>x<rsub|m+2>\<ldots\>.x<rsub|n>>, then
        <math|S>* would equally be better than <math|S> with regarding to the
        sequence <math|x<rsub|m>x<rsub|m+1>\<ldots\>.x<rsub|n>>,
        contradicting with our original assumption with <math|S>. A similar
        proof could be conducted if the next longest subsequence is contained
        in <math|x<rsub|m>x<rsub|m+1>\<ldots\>.x<rsub|n-1>>.

        Since every time when we narrow down the subsequence, we have assured
        that the longest palindromic subsequence had been taken into account,
        the overall computation is optimal.\ 

        <item>Complexity

        Since we need to fill in the table from bottom-right to top-left, and
        then till the upper-right corner, we only need at most half of the
        table, which is <frac|<math|n<rsup|2>>|2>. Therefore, the total time
        and space complexity are both <math|O(n<rsup|2>)>.
      </enumerate-alpha>
    </itemize-dot>
  </enumerate-numeric>

  \;

  <\enumerate-numeric>
    <paragraph|Problem 5>

    <item>Let <math|m> be the length of a line, <math|n> be the total number
    of words, and we label every word with indices in an increasing order
    from 1 to <math|n>.\ 

    Let <math|P<rsub|(i,j)>> be the penalty value when we choose words from
    index <math|i> to index <math|j>. If current end, <math|j>, is not the
    last word, namely we are handling from the first line to the penultimate
    line, the penalty for each of those lines should be the maximum line
    capacity minus the spaces (assuming each pair of words is seperated by
    only one space at most), and then minus the total word length summed up,
    the rest then should be squared. If we are handling the last line and the
    last line could be filled into the <math|m> characters space, its penalty
    would be neglected according to the definition, otherwise, the case is
    not allowed giving a plus infinite number:

    <\with|par-mode|center>
      <math|P<rsub|(i, j)> = <choice|<tformat|<cwith|1|-1|1|1|cell-halign|l>|<table|<row|(m
      - (j-i)\<times\>1 - <big|sum><rsub|k=i><rsup|j>WordLen(k))<rsup|2>|<cell|<with|mode|text|(<math|j
      \ \ \<neq\> n )>>>>|<row|<cell|0>|<cell|(j = n and m -
      (j-i)\<times\>1-<big|sum><rsub|k=i><rsup|j>WordLen(k)\<geqslant\>0)>>|<row|<cell|+\<infty\>>|<cell|(j
      =n and m-(j-i) \<times\>1 - <big|sum><rsub|k=i><rsup|j>WordLen(k)\<less\>0)>>>>>
      \ >
    </with>

    Let <math|k> be the current index of the last word chosen to be fit in
    the current line. Let <math|f(k)> be the optimal alignment with minimum
    penalty using the first <math|k> words. So, if the current split could be
    tolorated by the current line, then the minimum penalty would just be
    <math|P<rsub|(1,k)>> itself. Otherwise, we should find an optimal way of
    splitting the line for every word-<math|s> from index 1 to <math|k>:

    <\with|par-mode|center>
      <with|mode|math|f(k) = <choice|<tformat|<cwith|1|-1|1|1|cell-halign|l>|<table|<row|P<rsub|(1,k)>|<cell|<with|mode|text|(<with|mode|math|m
      - (j-i)\<times\>1-<big|sum><rsub|k=i><rsup|j>WordLen(k)\<geqslant\>0>)>>>|<row|<cell|min<rsub|1\<leqslant\>s\<less\>k><left|{>f(s)+P<rsub|(s+1,
      k)><right|}>>|<cell|(otherwise)>>>>> \ >
    </with>

    <item>Correctness

    <item>Time Complexity

    \;
  </enumerate-numeric>

  \;
</body>

<\initial>
  <\collection>
    <associate|language|american>
  </collection>
</initial>

<\references>
  <\collection>
    <associate|auto-1|<tuple|1|1>>
    <associate|auto-2|<tuple|1|1>>
    <associate|auto-3|<tuple|2|1>>
    <associate|auto-4|<tuple|2|1>>
    <associate|auto-5|<tuple|3|2>>
    <associate|auto-6|<tuple|4|4>>
  </collection>
</references>

<\auxiliary>
  <\collection>
    <\associate|table>
      <tuple|normal|Bellman-ford Shortest Path|<pageref|auto-2>>

      <tuple|normal|Back Tracing of Previous Hop|<pageref|auto-3>>
    </associate>
    <\associate|toc>
      <with|par-left|<quote|6fn>|Problem 1
      <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-1><vspace|0.15fn>>

      <with|par-left|<quote|6fn>|Problem 3
      <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-4><vspace|0.15fn>>

      <with|par-left|<quote|6fn>|Problem 4
      <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-5><vspace|0.15fn>>

      <with|par-left|<quote|6fn>|Problem 5
      <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-6><vspace|0.15fn>>
    </associate>
  </collection>
</auxiliary>