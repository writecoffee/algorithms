<TeXmacs|1.0.7.19>

<style|generic>

<\body>
  <doc-data|<doc-title|Divide and Conquer>>

  <item><em|<strong|Medium-Find>>

  <em|Runtime:> depends on how ``lucky'' we are <math|\<rightarrow\>>
  ``unlucky'' if <math|x> is always the largest or smallest elem of <math|L>
  (e.g., <math|L> is sorted). It would be <math|O<around*|(|n<rsup|2>|)>>.
  <math|<rsup|<around*|(|1|)>>>So instead of choosing <math|x> to be the
  first element, let it be a random element.
  <math|<rsup|<around*|(|2|)>>>Assume fixed input, prove it run in
  <math|O<around*|(|n|)>> time. <em|Claim>: runtime depends only on the size
  of <math|L>. Let <math|T<around*|(|n|)>> b the time the algo takes on
  average, suppose that <math|<around*|\||L<rsub|1>|\|>=5,<around*|\||L<rsub|2>|\|>=n-5-1>.
  Then we either need to do <math|T<around*|(|5|)>> or
  <math|T<around*|(|n-5-1|)>>. In the worst case, it will be
  <math|max<around*|(|T<around*|(|5|)>,T<around*|(|n-5-1|)>|)>>.

  Let <math|R<around*|(|x|)>> be the rank of <math|x> in <math|L>. Then
  <math|<around*|\||L<rsub|1>|\|>=R<around*|(|x|)>-1,<around*|\||L<rsub|2>|\|>=n-R<around*|(|x|)>>
  then the time will be at most <math|max<around*|(|T<around*|(|<around*|\||L<rsub|1>|\|>|)>,T<around*|(|<around*|\||L<rsub|2>|\|>|)>|)>>.
  When <math|<around*|\||L<rsub|1>|\|>=<around*|\||L<rsub|2>|\|>>, then
  <math|T<around*|(|n|)>=T<around*|(|n/2|)>+n>. If
  <math|n/4\<leqslant\>R<around*|(|x|)>\<leqslant\>3n/4>, then
  <math|<around*|\||L<rsub|1>|\|>\<leqslant\>3n/4\<nocomma\>>,
  <math|<around*|\||L<rsub|2>|\|>\<leqslant\>3n/4\<Rightarrow\>T<around*|(|n|)>\<leqslant\>T<around*|(|3n/4|)>+n>.
  The probability of this happening is <math|1/2>, since the distribution of
  <math|R<around*|(|x|)>> is uniform <math|\<Rightarrow\>> Takes a constant
  number of ``coin flips'' (choices of random numer) to get to this case
  <math|\<Rightarrow\>> takes time <math|O<around*|(|n|)>> [expected to take
  this amount of time].

  <item><em|<strong|Deterministic Selection (Medium-Find)>>

  <em|Input>: an array <math|A> with <math|n> distinct (for simplicty)
  numbers and a nubmer <math|i\<in\><around*|{|1,2,\<ldots\>,n|}>>.

  <em|Output>: <math|i<rsup|th>> order statistic
  (<math|i.e.,><math|i<rsup|th>> smallest element of input array)

  <em|Example>: median. (<math|i=<frac|n+1|2>> for <math|n> odd,
  <math|i=<frac|n|2>> for <math|n> even)

  <em|DSelect Algorithm>: (Select a pivot deterministically)

  <\render-code>
    <with|font-shape|small-caps|Dselect>(<strong|array> <math|A>,
    <strong|length> <math|n>, <strong|order statistic> <math|i>)

    <tabular|<tformat|<table|<row|<cell|1>|<cell|<em|Break <math|A> into
    groups of 5, sort each group><htab|5mm><emdash>
    <math|\<theta\><around*|(|n|)>>>|<cell|>>|<row|<cell|2>|<cell|<math|C\<leftarrow\>>the
    <math|n/5> ``middle elements''<htab|5mm><emdash>
    <math|\<theta\><around*|(|n|)>>>|<cell|>>|<row|<cell|3>|<cell|<math|p\<leftarrow\>><with|font-shape|small-caps|DSelect>(<math|C,n/5,n/10>)<htab|5mm><with|font-base-size|10|/*
    recursively computes median of <math|C> */><htab|5mm><emdash>
    <math|T<around*|(|<frac|n|5>|)>>>|<cell|>>|<row|<cell|4>|<cell|<em|Partition
    <math|A> around <math|p>><htab|5mm>---
    <math|\<theta\><around*|(|n|)>>>|<cell|>>|<row|<cell|5>|<cell|<strong|if>
    <math|j=i> <strong|then return> <math|p>>|<cell|>>|<row|<cell|6>|<cell|<strong|if>
    <math|j\<less\>i> <strong|then return>
    <with|font-shape|small-caps|DSelect>(<math|1<rsup|st>> part of <math|A>,
    <math|j-1>, <math|i>)>|<cell|>>|<row|<cell|7>|<cell|<strong|else>
    <strong|return> <with|font-shape|small-caps|DSelect>(<math|2<rsup|nd>>
    part of <math|A>, <math|n-j>, <math|i-j>)>|<cell|>>>>>
  </render-code>

  <em|The Key Lemma>:

  <math|2<rsup|nd>> recursive call (in line 6 or 7) guaranteed to be on an
  array of size <math|\<leqslant\><frac|7|10>n> (roughly).

  <\itemize-minus>
    <item>(<em|<with|color|blue|Rough Proof>>): Let <math|k=n/5=># of groups,
    let <math|x<rsub|i>=i<rsup|th>> smallest of the <math|k> ``middle
    elements''. [so pivot<math|=x<rsub|k/2>>]\ 

    <item>(<em|<with|color|blue|Goal>>): <math|\<geqslant\>30>% of input
    array smaller than <math|x<rsub|k/2>>, <math|\<geqslant\>30>% is
    bigger.<with|color|blue|<with|color|black|>>

    <item>(<with|color|blue|<em|Though Experiment>>): Imagine we lay out
    elements of <math|A> in a 2-D grid:

    <math|x<rsub|k/2>> bigger than 60% of the elements in
    <math|\<approx\>50>% of the groups <math|\<Rightarrow\>> bigger than 30%
    of <math|A> (similarly, smaller than 30% of <math|A>)
  </itemize-minus>

  <em|Running Time>:

  Let <math|T<around*|(|n|)>> be the maximum running time of
  <with|font-shape|small-caps|DSelect> on an input array of length <math|n>.
  There is a constant <math|c\<geqslant\>1> such that:

  <with|font-base-size|9|<\enumerate-numeric>
    <item><math|T<around*|(|1|)>=1>

    <item><math|T<around*|(|n|)>\<leqslant\>c
    n+T<around*|(|n/5|)>+T<around*|(|<frac|7|10>n|)>>
  </enumerate-numeric>>

  <em|<with|color|red|Note>>: different-sized subproblems
  <math|\<Rightarrow\>> can't use Master Method!
  <em|<with|color|red|Strategy>>: ``hope and check''.
  <em|<with|color|red|Hope>>: there is some constant <math|a> (independent of
  <math|n>) such that <math|T<around*|(|n|)>\<leqslant\>a n>,
  <math|\<forall\>n\<geqslant\>1>.\ 

  <em|Claim>: Let <math|a=10c>, then <math|T<around*|(|n|)>\<leqslant\>a
  n\<nocomma\>,\<forall\>n\<geqslant\>1>.\ 

  <em|Proof>: by induction on <math|n>. (<em|Base case>):
  <math|T<around*|(|1|)>=1\<leqslant\>a\<cdot\>1> (<em|Inductive
  Hypothesis>): <math|T<around*|(|k|)>\<leqslant\>a k,\<forall\>k\<less\>n>,
  we have

  <with|font-base-size|9|<\eqnarray*>
    <tformat|<table|<row|<cell|T<around*|(|n|)>>|<cell|\<leqslant\>>|<cell|c
    n+T<around*|(|n/5|)>+T<around*|(|<frac|7|10>n|)>>>|<row|<cell|>|<cell|\<leqslant\>>|<cell|c
    n+a<around*|(|n/5|)>+a<around*|(|<frac|7|10>n|)>>>|<row|<cell|>|<cell|=>|<cell|n<around*|(|c+<frac|9|10>a|)>>>|<row|<cell|>|<cell|=>|<cell|a
    n>>>>
  </eqnarray*>>

  <item><strong|<em|FindMax>> value increasing from the left, descending to
  the right

  Given a location <math|i> in the 1-indexed array <math|A> of length
  <math|n>, we can clearly tell if <math|i> is to the left of the max, to the
  right of the max, or is the max, via the following three-way test:

  <\equation*>
    <choice|<tformat|<table|<row|<cell|i\<less\>n and
    A<around*|[|i|]>\<less\>A<around*|[|i+1|]>>|<cell|\<rightarrow\><htab|5mm><with|math-font-family|mt|max>
    is to the right of i>>|<row|<cell|i\<gtr\>1 and
    A<around*|[|i|]>\<less\>A<around*|[|i-1|]>>|<cell|\<rightarrow\><htab|5mm><with|math-font-family|mt|max>
    is to the left of i>>|<row|<cell|else>|<cell|\<rightarrow\><htab|5mm><with|math-font-family|mt|max>
    is at i>>>>>
  </equation*>

  Knowing whether the desired location is to the left, to the right, or on
  the current location is exactly the subroutine used in the binary search
  algorithm, which will thus solve the problem in <math|O(log n)> time (since
  each test can be done in constant time).

  <item><em|<strong|BigWin>> <math|O<around*|(|n log n|)>> Solution

  <em|<strong|Heuristic>>: Starting at the center element, <math|c>, we find
  the maximum sum, <math|L>, of consecutive elements to the left of <math|c>
  that includes <math|c>. Similarly, we find the maximum sum, <math|R>, of
  consecutive elements to the right of <math|c> that includes <math|c>. Then,
  <em|BigMiddleWin> should return <math|L+R-c>.

  <em|<strong|Algorithm>>: Consider the center element, <math|c>, in the
  list. Either the maximum sum is completely contained in the elements to the
  left of <math|c>, completely contained in the elements to the right of c,
  or passes through <math|c>. We have already seen how to solve the last case
  with <em|BigMiddleWin>. We can then consider an algorithm, <em|BigWin>,
  which takes as input a list, <math|l>. It returns the max of
  <em|BigMiddleWin> of <math|l>, <em|BigWin> of the left half of <math|l>,
  and <em|BigWin> of the right half of <math|l>.

  <em|<strong|Correctness>>: We can assume that <em|BigMiddleWin> will return
  the correct maximum of a given list. Any contiguous subsequence from a list
  <math|l> either contains the middle element or it doesn't. In the case that
  it does, the maximum of all such paths will be returned by
  <em|BigMiddleWin>. Since the sequence is contiguous, if it does not contain
  the middle element then all elements must fall in the left half, or they
  must fall in the right half. These can both be treated as independent lists
  (since they share no elements), and <with|color|blue|so we can solve them
  independently>. <em|<with|color|blue|Thus, the maximum total sum will be
  the max of the sum that considers only the left half, the sum that
  considers only the right half, and the sum that considers the whole list
  together>>.

  <em|<strong|Runtime>>: The algorithm leads to a recurrence of the form
  <math|T(n) = 2T(n/2)+O(n)>. We have solved this recurrence before, and know
  it is <math|O(n log n)>.

  <strong|<em|<with|color|dark cyan|Improvement>>>: We store two variables,
  currentMax and globalMax. We initialize both to zero. We then start from
  the rst element in the list and iter- ate through to the last. At each
  element, e, we set <math|<text|<em|currentMax> =
  max(<em|currentMax>+<math|e>, 0)>> and <math|<text|<em|globalMax> =
  max(<em|globalMax>, <em|currentMax>)>>. <strong|<em|<with|color|dark
  cyan|Correctness>>>: Our algorithm sums the elements as we see them. We
  keep track of the largest sum we have seen so far. The only time we reset
  the sum is when the sum has dropped below 0. If this occurred, then
  choosing no elements is still better than choosing elements such that we
  get a negative sum. Therefore, our algorithm must produce the maximum sum.
  <em|<strong|<with|color|dark cyan|Runtime>>>: We consider each element once
  and do a constant amount of work for each element. Thus the runtime is
  <math|O(n)>.
</body>

<\initial>
  <\collection>
    <associate|page-type|letter>
  </collection>
</initial>