<TeXmacs|1.0.7.19>

<style|generic>

<\body>
  <with|color|magenta|<section|Dynamic Programming>>

  <item><em|Number of paths in a graph>: If we multiply by <math|M>
  repeatedly, this corresponds to longer paths: the <math|l>th entry of the
  vector <math|e<rsub|i>\<cdot\>M<rsup|k>> records the number of paths of
  length <math|k> in <math|G> going from <math|i> to <math|l>. <em|Recursive
  representation of paths in a graph>:\ 

  <tabular|<tformat|<table|<row|<cell|PATHS(<math|i,k,l>):>>|<row|<cell|<htab|5mm>return:
  <math|<big|sum><rsub|j>><math|PATHS<around*|(|i,k-1,j|)>\<cdot\>M<around*|(|j,l|)>>>>>>>

  <em|Minimum cost paths in a graph>:\ 

  <tabular|<tformat|<table|<row|<cell|PATHS(<math|i,k,l>):>>|<row|<cell|<htab|5mm>return:
  <math|min<rsub|j>><math|PATHS<around*|(|i,k-1,j|)>+M<around*|(|j,l|)>>>>>>>

  <strong|<item>Egg Dropping Problem>

  Let <math|f<around*|(|t,n|)>> be the most floors given <math|t> trials,
  <math|n> eggs (i.e. at most <math|t> depth, at most <math|n> left moves,
  <math|f<around*|(|t,n|)>=> most number of nodes to add to tree).
  <math|f<around*|(|t,n|)>=1+f<around*|(|t-1,n-1|)>+f<around*|(|t-1,n|)>>

  <strong|<item>Edit Distance>

  The recurrence for editDistance from the problem statement is:

  <\equation*>
    S<around*|(|i,j|)>=<choice|<tformat|<table|<row|<cell|S<around*|(|i-1,j-1|)>>|<cell|<htab|5mm>if
    A<around*|[|i|]>=B<around*|[|j|]>>>|<row|<cell|min<around*|(|S<around*|(|i-1,j|)>,S<around*|(|i,j-1|)>,S<around*|(|i-1,j-1|)>|)>+1>|<cell|<htab|5mm>if
    A<around*|[|i|]>\<neq\>B<around*|[|j|]>>>>>>
  </equation*>

  <with|color|blue|Recall the <with|font-shape|italic|meaning> of
  <math|S<around*|(|i,j|)>>>: it is the edit distance between the first
  <math|i> characters of the first string <math|A> and the first <math|j>
  characters of the second string <math|B>. <with|color|blue|Thus we want to
  compute> <math|S<around*|(|A.length\<nocomma\>,B.length|)>>, which we do
  via dynamic programming, filling in all entries <math|S<around*|(|i,j|)>>
  for <math|i> between 0 and <math|A.length> and <math|j> between 0 and
  <math|B.length>, leading to a 2-dimensional array with dimensions
  <math|<around*|(|A.length+1|)>\<times\><around*|(|B.length+1|)>>

  <with|color|blue|The base cases for our algortihm encode the fact that> the
  edit distance between the empty string and a string of length <math|i> (or
  <math|j>) is <math|i> (or <math|j> respectively):

  <\eqnarray*>
    <tformat|<table|<row|<cell|S<around*|(|i,0|)>>|<cell|=>|i\<nocomma\>,<htab|5mm>
    \<forall\>i\<nocomma\>,0 \<leqslant\>i\<leqslant\>A.length>|<row|<cell|S<around*|(|0,j|)>>|<cell|=>|<cell|j,<htab|5mm>
    \<forall\>j, 0\<leqslant\>j\<leqslant\>B.length>>>>
  </eqnarray*>

  <strong|<item>Bellman-Ford Algorithm>

  <\render-code>
    BELLMAN-FORD()

    <tabular|<tformat|<table|<row|<cell|1>|<cell|<math|A\<leftarrow\>>2D
    array (indexed by <math|i> and <math|v>)>>|<row|<cell|2>|<cell|<math|A<around*|[|0,s|]>=0>>>|<row|<cell|3>|<cell|<math|A<around*|[|0,v|]>=+\<infty\>
    ,\<forall\>v,v\<neq\>s> >>|<row|<cell|4>|<cell|<strong|for>
    <math|i\<leftarrow\>1> <strong|to> <math|n-1>:>>|<row|<cell|5>|<cell|<htab|5mm><strong|for>
    each <math|v\<in\>V> <strong|do>:>>|<row|<cell|6>|<cell|<htab|5mm><htab|5mm><with|font-base-size|10|<math|A<around*|[|i,v|]>=min<around*|(|A<around*|[|i-1,v|]>,min<around*|(|A<around*|[|i-1,w|]>+c<rsub|w
    v>,\<forall\><around*|(|w,v|)>\<nocomma\>,<around*|(|w,v|)>\<in\>E|)>|)>>>>>>>>
  </render-code>

  <strong|<item>Knapsack Problem>

  <\render-code>
    KNAPSACK(<math|W>)

    <tabular|<tformat|<table|<row|<cell|1>|<cell|<math|A\<leftarrow\>>2D
    array (indexed by <math|i> and <math|v>)>>|<row|<cell|2>|<cell|initialize
    <math|A<around*|[|0,x|]>=0,\<forall\>x,x\<in\><around*|{|0,1,2,\<ldots\>,W|}>>>>|<row|<cell|3>|<cell|<strong|for>
    <math|i=1,2,\<ldots\>,n>:>>|<row|<cell|4>|<cell|<htab|5mm><strong|for>
    <math|x=0,1,2,\<ldots\>,W>:>>|<row|<cell|5>|<cell|<htab|5mm><htab|5mm><math|A<around*|[|i,x|]>\<leftarrow\>max<around*|{|A<around*|[|i-1,x|]>,A<around*|[|i-1,x-w<rsub|i>|]>+v<rsub|i>|}>><htab|5mm><with|font-base-size|10|/*<math|x-w<rsub|i>\<geqslant\>0>
    */>>>|<row|<cell|6>|<cell|<strong|return> <math|A<around*|[|n,w|]>> >>>>>
  </render-code>

  <strong|<item>Optimal Binary Search Tree>

  <\render-code>
    OPTIMAL-BST()

    <tabular|<tformat|<table|<row|<cell|1>|<cell|<math|A\<leftarrow\>>2D
    array>>|<row|<cell|2>|<cell|<strong|for> <math|s\<leftarrow\>0>
    <strong|to> <math|n-1> <strong|do>: /* <math|s> represents
    <math|<around*|(|j-i|)>>*/>>|<row|<cell|3>|<cell|<htab|5mm><strong|for>
    <math|i\<leftarrow\>0> <strong|to> <math|n> /* <math|i> represents
    contiguous interval */>>|<row|<cell|4>|<cell|<htab|5mm><htab|5mm><math|A<around*|[|i,i+s|]>\<leftarrow\>min<rsub|r=1><rsup|i+s><around*|{|<big|sum><rsub|k=i><rsup|i+s>p<rsub|k>+A<around*|[|i,r-1|]>+A<around*|[|r+1,i+s|]>|}>><htab|5mm>>>|<row|<cell|5>|<cell|<htab|5mm><htab|5mm><htab|5mm><htab|5mm><htab|5mm><htab|5mm><htab|5mm><htab|5mm><htab|5mm><htab|5mm>/*
    as 0 if 1st index \<gtr\> 2nd index*/>>|<row|<cell|6>|<cell|<strong|return>
    <math|A<around*|[|1,n|]>>>>>>>
  </render-code>

  <strong|<item>Longest Palindromic Subsequences>

  We describe a dynamic programming approach for coy mputing the length of
  the longest palindromic subsequence in a string of characters.
  <with|color|blue|We will define a recurrence in terms of
  <math|T<around*|(|i,j|)>>, representing the <with|font-shape|italic|length
  of the longest palindromic subsequence consisting of characters from i to j
  inclusive>>. We now derive a recurrence relation for <math|T>.

  There are two cases to the recurrence. Either the first and last character
  of the substring from <math|i> to <math|j> match, or they do not:\ 

  <\enumerate-roman>
    <item>If they match, then the length of the longest palindromic
    subsequence from <math|i> to <math|j> must be two more than the length of
    the longest palindromic subsequence from <math|i+1> to <math|j-1>.

    <item>If they do not match, then no palindromic subsequence can both
    start with the <math|i>th character and end with the <math|j>th
    character, so the longest palindromic subsequence between <math|i> and
    <math|j> must be <with|font-shape|italic|either> the longest palindromic
    subsequence between <math|i> and <math|j-1>, or the longest palindromic
    subsequence between <math|i+1> and <math|j>.
  </enumerate-roman>

  Written explicitly, the recurrence is:

  <\equation*>
    T<around*|(|i,j|)>=<choice|<tformat|<table|<row|<cell|T<around*|(|i+1,j-1|)>+2>|<cell|<htab|5mm>if
    s<around*|[|i|]>=s<around*|[|j|]>>>|<row|<cell|max<around*|(|T<around*|(|i+1,j|)>,T<around*|(|i,j-1|)>|)>>|<cell|<htab|5mm>if
    s<around*|[|i|]>\<neq\>s<around*|[|j|]>>>>>>
  </equation*>

  Since the recurrence only makes use of entries with greater first index, or
  smaller second index, we can fill in the table with two nested loops, where
  one loop decreases the first index and the other loop increases the second
  index.

  It is fairly clear that the following two base cases are enough to define
  the rest of the values in <math|T>:

  <\itemize-dot>
    <item>String of length 1: for all <math|i> between 0 and <math|n-1>, let
    <math|T<around*|(|i,j|)>=1>.

    <item>String of length 0: for all <math|i> between 1 and <math|n-1>, let
    <math|T<around*|(|i,i-1|)>=0>.
  </itemize-dot>

  The following is the pseudocode for our algorithm, <with|color|blue|which
  accepts as input a string <math|s> and outputs the length of the longest
  palindromic subsequence>:

  <\render-code>
    PALINDROME(<math|s>)

    <tabular|<tformat|<table|<row|<cell|1>|<cell|Set
    <math|n\<leftarrow\>>LENGTH(<math|s>)>>|<row|<cell|2>|<cell|Create
    2-dimensional array <math|T<around*|[|n|]><around*|[|n|]>>>>|<row|<cell|3>|<cell|<strong|for>
    <math|i\<leftarrow\>0> to <math|n-1>>>|<row|<cell|4>|<cell|<htab|5mm><strong|do>
    <math|T<around*|(|i,i|)>=1>>>|<row|<cell|5>|<cell|<strong|for>
    <math|i\<leftarrow\>0> to <math|n-1>>>|<row|<cell|6>|<cell|<htab|5mm><strong|do>
    <math|T<around*|(|i,i-1|)>=0>>>|<row|<cell|7>|<cell|<with|color|blue|<strong|for>
    <math|i\<leftarrow\>n-1> down to 0>>>|<row|<cell|8>|<cell|<htab|5mm><strong|do
    for> <math|j\<leftarrow\>i+1> to <math|n-1>>>|<row|<cell|9>|<cell|<htab|5mm><htab|5mm><strong|do
    if> <math|s<around*|(|i|)>=s<around*|(|j|)>>>>|<row|<cell|10>|<cell|<htab|5mm><htab|5mm><htab|5mm><strong|then>
    <math|T<around*|(|i,j|)>\<leftarrow\>T<around*|(|i+1,j-1|)>+2>>>|<row|<cell|11>|<cell|<htab|5mm><htab|5mm><htab|5mm><strong|else>
    <math|T<around*|(|i,j|)>\<leftarrow\>>max(<math|T<around*|(|i+1,j|)>,T<around*|(|i,j-1|)>>)>>|<row|<cell|12>|<cell|Return
    <math|T<around*|(|0,n-1|)>>>>>>>
  </render-code>

  <strong|<with|font-shape|italic|Proof Of Correctness>>

  As we derived the pseudocode above, we introduced all the elements needed
  for a proof of correctness. We need only assemble the pieces:

  <math|<rsup|<text|(1)>>><with|color|blue|We argued above that the
  recurrence for <math|T<around*|(|i,j|)>>> correctly expresses the length of
  the longest palindromic subsequence between location <math|i> and <math|j>
  <with|color|blue|in terms of values that have already been computed>.
  <math|<rsup|<around*|(|2|)>>>And finally, <with|color|blue|the base cases>,
  strings of length 0 and 1, clearly have longest palindromic subsequences of
  lengths 0 and 1 respectively. <math|<rsup|<around*|(|3|)>>><with|color|blue|Therefore,
  induction on the number of times line 9 in the pseudocode is executed
  yields a proof of correctness of the values of the table <math|T>>, and in
  particular, <with|color|blue|guarantees> that the answer
  <math|T<around*|(|0,n-1|)>> returns the length of the longest palindromic
  subsequence of the entire string.

  <strong|<with|font-shape|italic|Running Time Analysis>>

  We fill half of a table that contains <math|O<around*|(|n<rsup|2>|)>>
  elements. In filling each element, we do constant work. Thus, the runtime
  of our algorithm is <math|O<around*|(|n<rsup|2>|)>>.

  <strong|<item><em|<strong|Maximum Sum>> of a Triangle>

  Let <math|T> be a triangle of numbers with <math|r> rows, where
  <math|T<around*|[|i,j|]>> is the number in the <math|i>th row of T that is
  <math|j> from the left, starting from 1 (e.g., <math|T<around*|[|3,2|]>> in
  the example triangle is <math|>4). We define an algorithm defined by the
  following recurrence relation:

  <\equation*>
    S<around*|[|i,j|]>=<choice|<tformat|<table|<row|<cell|T<around*|[|i,j|]>>|<cell|<htab|5mm>if
    i=r>>|<row|<cell|T<around*|[|i,j|]>+max<around*|(|T<around*|[|i+1,j|]>,T<around*|[|i+1,j+1|]>|)>>|<cell|<htab|5mm>if
    i\<less\>r>>>>>
  </equation*>

  where <math|1\<leqslant\>i\<leqslant\>r,1\<leqslant\>j\<leqslant\>i> and
  <math|S<around*|[|i,j|]>> is the maximum sum from row <math|r> of <math|T>
  to <math|T<around*|[|i,j|]>>.

  <math|S<around*|[|i,j|]>> is an <math|r\<times\>r> table. We will fill only
  the bottom half of the table (we only need <math|i\<geqslant\>j>),
  <with|color|blue|starting at the bottom row and working across rows to the
  top>. The maximum sum in <math|T> will be stored at
  <math|S<around*|[|1,1|]>>.

  <\render-code>
    MAX-SUM(<math|T>)

    <tabular|<tformat|<table|<row|<cell|1>|<cell|<math|r\<leftarrow\>T.numRows>>>|<row|<cell|2>|<cell|<math|S\<leftarrow\>n\<times\>n>
    matrix>>|<row|<cell|3>|<cell|<strong|for> <math|j\<leftarrow\>1> to
    <math|r>>>|<row|<cell|4>|<cell|<htab|5mm><strong|do>>>|<row|<cell|5>|<cell|<htab|5mm><htab|5mm><math|S<around*|[|r,j|]>\<leftarrow\>T<around*|[|r,j|]>>>>|<row|<cell|6>|<cell|<strong|for>
    <math|i\<leftarrow\>r-1> to 1 <strong|do>>>|<row|<cell|7>|<cell|<htab|5mm><strong|for>
    <math|j\<leftarrow\>1> to <math|i> <strong|do>>>|<row|<cell|8>|<cell|<htab|5mm><htab|5mm><math|S<around*|[|i,j|]>\<leftarrow\>T<around*|[|i,j|]>+max<around*|(|T<around*|[|i+1,j|]>,T<around*|[|i+1,j+1|]>|)>>>>|<row|<cell|9>|<cell|Retrun
    <math|S<around*|[|1,1|]>>>>>>>
  </render-code>

  <strong|<with|font-shape|italic|Proof Of Correctness>>

  We can prove that the algorithm is correct by showing that the recurrence
  relation works and each <math|S<around*|[|i,j|]>> is the maximum sum from
  row <math|r> of <math|T> to <math|T<around*|[|i,j|]>>.

  <\itemize-minus>
    <item>Inductive Hypothesis: The algorithm returns the maximum sum for a
    triangle with <math|r=k> rows.

    <item>Base Case: First, the base case <math|<around*|(|r=1|)>> is true.
    If we have a triangle with only one row, then it can only have one entry,
    and it is clear that the maximum sum in the tree is exactly the value of
    that entry.

    <item>General Case: We want to show that the algorithm returns the
    correct answer when <math|r=k+1>. Starting from the top of the triangle ,
    the path followed to obtain the maximum sum must pass through one of the
    numbers in the second row of <math|T>. Both of these taken individually
    are the top row of triangles with <math|k> rows , so we know from the
    induction hypothesis that <math|S<around*|[|2,j|]>> stores the maximum
    sum from the base of <math|T> to the numbers in the second row. Since the
    path to the top row is obtained by adding this sum to the value stored in
    the first row of <math|T>, it is clear that the maximum sum for <math|T>
    will be obtained by adding <math|T<around*|[|1,1|]>> to the maximum of
    the sums stored in the second row of <math|T>, <with|color|blue|which is
    exactly what is calculated by the recurrence relation>. Therefore, our
    algorithm is correct for <math|r=k+1> and therefore for all <math|r>.
  </itemize-minus>

  <strong|<with|font-shape|italic|Running Time>>

  During the execution of this algorithm, we consider each number a constant
  number of times. Therefore, the algorithm runs in <math|O<around*|(|n|)>>
  where <math|n> is the number of elements in the triangle.

  <strong|<item><em|<strong|MinCost>> of Cutting Wood>

  Input: a sequence of cuts <math|A=<around*|{|a<rsub|1>,a<rsub|2>,\<ldots\>,a<rsub|n>|}>>,
  where <math|a<rsub|i>> is the distance from the left edge of the piece of
  wood, and <math|L>, the length of the piece of wood.

  For the recurrence relation, redefine <math|A=<around*|{|a<rsub|1>,a<rsub|2>,\<ldots\>,a<rsub|n>,a<rsub|n+1>|}>=<around*|{|a<rsub|1>,a<rsub|2>,\<ldots\>,a<rsub|n>,L|}>>
  such that in the recurrence relation, <math|a<rsub|n+1>=L>. The recurrence
  relation for this problem can be described as

  <\equation*>
    C<around*|[|i,j|]>=<choice|<tformat|<table|<row|<cell|0>|<cell|<htab|5mm>if
    i=j or i=j-1>>|<row|<cell|a<rsub|j>-a<rsub|i>+min<rsub|i\<less\>k\<less\>j><around*|(|C<around*|[|i,j|]>+C<around*|[|k,j|]>|)>>|<cell|<htab|5mm>if
    i\<neq\>j and i\<neq\>j-1>>>>>
  </equation*>

  where <math|C<around*|[|i,j|]>> is the minimum cost of cutting the wood
  between cuts <math|a<rsub|i>> and <math|a<rsub|j>> and
  <math|i\<leftarrow\>0> to <math|n> and <math|j\<leftarrow\>1> to
  <math|n+1>.

  <math|C<around*|[|i,j|]>> is a table in which only the upper half is filled
  (we only need <math|i\<leqslant\>j> since we are looking at the cost of
  cuttin between positions <math|a<rsub|i>> and <math|a<rsub|j>>, so all
  other entries would be redundant.) Each entry <math|C<around*|[|i,j|]>>
  holds the minimum cost of cutting the wood between positions
  <math|a<rsub|i>> and <math|a<rsub|j>>, <with|color|blue|and the table is
  filled diagonally, from the center diagonal to the upper-right corner>.

  <\render-code>
    MIN-COST(<math|<around*|{|a<rsub|1>,a<rsub|2>,\<ldots\>,a<rsub|n>|}>,L>)

    <tabular|<tformat|<table|<row|<cell|1>|<cell|<math|A\<leftarrow\><around*|{|a<rsub|1>,a<rsub|2>,\<ldots\>,a<rsub|n>,L|}>>>>|<row|<cell|2>|<cell|<strong|for>
    <math|i\<leftarrow\>1> to <math|n>>>|<row|<cell|3>|<cell|<htab|5mm><strong|do
    for> <math|j\<leftarrow\>0> to <math|n+1-i>>>|<row|<cell|4>|<cell|<htab|5mm><htab|5mm><strong|do
    if> <math|i=1>>>|<row|<cell|5>|<cell|<htab|5mm><htab|5mm><htab|5mm><strong|then>
    <math|C<around*|[|j,j+i|]>\<leftarrow\>0>>>|<row|<cell|6>|<cell|<htab|5mm><htab|5mm><htab|5mm><strong|else>
    <with|font-base-size|11|<math|C<around*|[|j,j+i|]>\<leftarrow\>a<rsub|j+1>-a<rsub|j>+min<rsub|j\<less\>k\<less\>j+i><around*|(|C<around*|[|j,k|]>+C<around*|[|k,j+i|]>|)>>>>>|<row|<cell|7>|<cell|<strong|return>
    <math|C<around*|[|0,n+1|]>>>>>>>
  </render-code>

  <em|<strong|Proof Of Correctness>>

  We can prove that the algorithm is correct by showing that the recurrence
  relation works and each <math|C<around*|[|i,j|]>> is the minimum cost of
  cutting between positions <math|a<rsub|i>> and <math|a<rsub|j>>, since the
  algorithm follows the recurrence relation defined above.

  <\itemize-minus>
    <item>Base Case: First, the base cases are true. In the base case where
    <math|i=j>, it is obvious that there is no cut betwen a position and
    itself. In the base case where <math|i=j-1>, there are no cuts between
    positions <math|a<rsub|i>> and <math|a<rsub|j>>, hence the cost is again
    0.

    <item>Now take all other cases in which there is at least one cut between
    positions <math|a<rsub|i>> and <math|a<rsub|j>>. Suppose the minimum cost
    <math|C<around*|[|i,j|]>> for making all cuts between <math|a<rsub|i>>
    and <math|a<rsub|j>> is obtained by making the next cut at some position
    <math|a<rsub|k><rprime|'>>, <math|i\<less\>k<rprime|'>\<less\>j>.
    Then<with|color|blue| <math|C<around*|[|i,j|]>=a<rsub|j>-a<rsub|i>+C<around*|[|i,k<rprime|'>|]>+C<around*|[|k<rprime|'>,j|]>>>.
    Because <math|a<rsub|j>-a<rsub|i>> is constant for any given <math|i,j>
    (the length of a piece of wood does not change regardless of how it will
    be cut), <math|C<around*|[|i,k<rprime|'>|]>+C<around*|[|k<rprime|'>,j|]>>
    is the minimum of all <math|C<around*|[|i,k|]>+C<around*|[|k,j|]>,\<forall\>i,i\<less\>k\<less\>j>,
    where <math|a<rsub|k>> is the next cut, and the recurrence relation(and
    hence the algorithm) holds.
  </itemize-minus>

  <em|<strong|Running Time>>

  The recurrence relation fills in the upper triangle of a table with
  dimensions <math|n> by <math|n>. There are thus <math|n<rsup|2>/2> or
  <math|O<around*|(|n<rsup|2>|)>> entries in the table. For every entry
  <math|C<around*|[|i,j|]>>, we perform on the order of
  <math|O<around*|(|n|)>> operations by comparing the sum of the entries
  <math|C<around*|[|i,k|]>+C<around*|[|k,j|]>> for all
  <math|i\<less\>k\<less\>j>. This is a linear number of operations on the
  order of <math|n> since in the worst case, we have
  <math|0\<less\>k\<less\>n+1> and have to sum the entries
  <math|C<around*|[|0,1|]>+C<around*|[|1,n+1|]>> through
  <math|C<around*|[|0,n|]>+C<around*|[|n,n+1|]>>. The total runtime is thus
  <math|O<around*|(|n<rsup|3>|)>>.

  <item><strong|Max-Weight-Path>

  <\enumerate>
    <em|<em|<item>>Find a path that goes through the root without restricting
    the nubmer of children for each node>.\ 

    <item><em|Find the vertex that if we remove it, splits the tree into
    several smaller trees where each of these remaining trees has at most
    <math|<frac|n|2>> vertices>.

    <item><em|Design an O(n log n) divide-andconquer algorithm that solves
    our problem, finding the maximal-weight path of length k in the tree.>

    Consider a node v as returned by the algorithm from part 5, and consider
    an optimal path of length <math|k> in the tree. Further, consider making
    <math|v> the root of the tree (this can be done in linear time via a
    depth-first search starting at <math|v>). There are two cases: either the
    path passes through <math|v>, or the path does not pass through <math|v>
    in which case it must be contained entirely within a single subtree of
    <math|v>.

    This observation gives us the structure of the algorithm:

    <\render-code>
      <with|font-shape|small-caps|Max-Weight-Path><math|<around*|(|G,k|)>>

      \ \ \ \ <math|v> = the vertex from the algorithm of part 5.

      \ \ \ \ Rearrange <math|G> to make <math|v> the root.

      \ \ \ \ return max<math|<choice|<tformat|<table|<row|<cell|Result of
      the algorithm of part 3 on (G, k)>>|<row|<cell|<text|<with|font-shape|small-caps|Max-Weight-Path><math|<around*|(|S<rsub|i>,k|)>>>
      for each subtree \ S<rsub|i> of v>>>>>>
    </render-code>

    As discussed above, given the correctness of algorithms from parts 3 and
    5, the correctness of this algorithm follows.

    We now analyze the run time. Note that for each recursive invocation of
    the algorithm on a tree of size <math|t>, we do <math|O(t)> work at the
    current level of recursion, namely a constant amount of work per vertex.
    Further, since the recursive calls are on disjoint sets of vertices, the
    total time spent at a given depth <math|j> of the recursion, across all
    recursive calls of <with|font-shape|small-caps|Max-Weight-Path>, is
    <math|O(n)>. As shown in part 4, each recursive call will be on a subtree
    at most half the size, which implies that there are at most <math|log n>
    levels of recursion. Thus the total time of our algorithm is
    <math|O<around*|(|n log n|)>>, as desired.
  </enumerate>

  <subsection|<with|color|magenta|Greedy Algorithm>>

  <item><em|<strong|Cloest Hotel>>

  Each morning, Bilbo will choose for his next night the hotel closest to his
  destination that he can reach that day, or his destination if he can reach
  his destination that day.

  We claim, by induction, that for each <math|i\<geqslant\>0>, under this
  strategy at the ith night Bilbo will be as close as possible to his
  destination. If at night <math|i> Bilbo is at location <math|x>, which is
  the greatest possible location he could be along his route for night
  <math|i>, and on the next day he travels to hotel at greatest location less
  than or equal to <math|x + 20>, then clearly at night <math|i + 1> he will
  be as far as possible along his route for night <math|i + 1>, proving the
  induction. Thus Bilbo greedy strategy will get him as far as possible each
  day, leading him to finish his journey in the least number of days.

  <item><em|<strong|Attend Events>>

  At the moment each event starts, choose a person from your dorm room to go
  to that event.\ 

  This strategy can only fail if there is no one in your dorm room when an
  event starts, meaning that all your <math|k> friends are already at
  <math|k> events. These <math|k> events and the just-starting event make
  <math|k + 1> events. Since there are <math|k+1> events happening
  simultaneously, there is no way to attend each event with only <math|k>
  people. Thus the only way our strategy fails is if our task is impossible,
  meaning our algorithm will succeed in all possible cases.

  <item><em|<strong|Scheduling Jobs>>

  <strong|Claim>: algorithm (order jobs according to decreasing ratios
  <math|w<rsub|i>/l<rsub|i>>) is always correct.

  <strong|Proof>: by an <em|Exchange Argument>, by Contradiction.
  <strong|Plan>: fix arbitrary input of <math|n> jobs, will proceed by
  contradiction. Let <math|\<sigma\>=> greedy schedule, <math|\<sigma\>>*=
  optimal schedule, will produce schedule even better than <math|\<sigma\>>*,
  contradicting purported optimality of <math|\<sigma\>>*.

  <strong|Assume>: all <math|w<rsub|i>/l<rsub|i>> are distinct; [just by
  renaming jobs] <math|w<rsub|1>/l<rsub|1>\<gtr\>w<rsub|2>/l<rsub|2>\<gtr\>\<ldots\>\<gtr\>w<rsub|n>/l<rsub|n>>,
  where <math|job<rsub|1>> has the greatest ratio.

  <strong|Thus>: greedy schedule sigma is just <math|1,2,3,\<ldots\>,n>. If
  optimal schedule <math|\<sigma\>>* is inequivalent to <math|\<sigma\>>,
  then there are consecutive jobs <math|i,j> with <math|i\<gtr\>j>. [only
  schedule where indices always go up is <math|1,2,\<ldots\>,n>].

  <strong|Thought Experiment>: ramifications of the exchange of jobs
  <math|\<rightarrow\>> it has to have this pair of consecutive jobs where
  the earlier one has the higher index; <em|Effect of this exchange on the
  completion time of>: <math|<rsup|<around*|(|1|)>>k> other than <math|i> or
  <math|j>: before the swap, it has to wait for a bunch of ops to complete,
  including <math|i> and <math|j>, the amount of time elapsed is the same,
  thus jobs other than <math|i> and <math|j> are completely agnostic to the
  swap; <math|k> preceed <math|i> and <math|j> is the same.
  <math|<rsup|<around*|(|2|)>>>job <math|i>: goes up, now it has to wait for
  <math|j>, goes up by the lenght of <math|j>.
  <math|<rsup|<around*|(|3|)>>>job <math|j>: drops, no longer has to wait for
  job <math|i>, goes down precisely the length of job <math|i>.

  <strong|Cost-Benefit Analysis>: <em|Upshot>s:
  <math|i\<gtr\>j\<Rightarrow\><frac|w<rsub|i>|l<rsub|i>>\<less\><frac|w<rsub|j>|l<rsub|j>>\<Rightarrow\>w<rsub|i>l<rsub|j>\<less\>w<rsub|j>l<rsub|i>\<Rightarrow\>cost
  \<less\> benefit\<Rightarrow\>>swap improves <math|\<sigma\>>*, contradicts
  optimality of <math|\<sigma\>>*. <em|QED>!

  <item><em|<strong|Prim's MST Algorithm>>

  <\render-code>
    PRIM(<math|s>)

    <tabular|<tformat|<table|<row|<cell|1>|<cell|<math|X\<leftarrow\><around*|{|s|}>>>>|<row|<cell|2>|<cell|<math|T\<leftarrow\>>EMPTY>>|<row|<cell|3>|<cell|<strong|while>
    <math|X!=V>:>>|<row|<cell|4>|<cell|<htab|5mm><math|e\<leftarrow\><around*|(|u,v|)>>
    /* be the cheapest edge of <math|G> with <math|u> in <math|X>, <math|v>
    not in <math|X> */>>|<row|<cell|5>|<cell|<htab|5mm><math|T\<leftarrow\>T\<cup\><around*|{|e|}>>>>|<row|<cell|6>|<cell|<htab|5mm><math|X\<leftarrow\>X\<cup\><around*|{|v|}>>>>>>>
  </render-code>

  <item><strong|<em|Kruskal's MST Algorithm>>

  <\render-code>
    KRUSKAL(<math|s>)

    <tabular|<tformat|<table|<row|<cell|1>|<cell|sort edges in increasing
    order /* bottle-neck in the end <math|O<around*|(|m log n|)>>
    */>>|<row|<cell|2>|<cell|[rename edge <math|1,2,\<ldots\>,m>, so that
    <math|c<rsub|1>\<less\>c<rsub|2>\<less\>c<rsub|3>\<ldots\>\<less\>c<rsub|m>>]>>|<row|<cell|3>|<cell|<math|T=><em|EMPTY
    SET>>>|<row|<cell|4>|<cell|<strong|for> <math|i=1> <strong|to> <math|m>
    <strong|do>:>>|<row|<cell|5>|<cell|<htab|5mm><strong|if>
    <math|T\<cup\><around*|{|i|}>> has no cycle <strong|then do>: /*
    originally <math|O<around*|(|n|)>> without Union-Find
    */>>|<row|<cell|6>|<cell|<htab|5mm><htab|5mm><math|T\<leftarrow\>T\<cup\><around*|{|i|}>>>>|<row|<cell|7>|<cell|<strong|return>
    <math|T>>>>>>
  </render-code>

  <item><strong|<em|Union-Find for Kruskal MST>>

  <strong|Raison d'etre>: maintain partition of a set of objects.
  <strong|Motivation>: <math|\<theta\><around*|(|1|)>> time for cycle checks.\ 

  <strong|Find(<math|x>)>: return name of group that <math|x> belongs to.
  <strong|Union(<math|c<rsub|i>,c<rsub|j>>)>: fuse groups <math|c<rsub|i>>
  and <math|c<rsub|j>> into a single one.\ 

  <strong|Idea>: when two componenets merge, have smaller one inherit the
  leader of the larger one; you have to quickly determine which group is
  larger, so you may maintain a size field for each group. <em|How many
  leader pointer updates are now required to restore the invariant in the
  worst case?> <strong|<math|\<theta\><around*|(|log n|)>>>. <strong|Reason>:
  you are joining a group at least as big as yours, so the size of the union,
  the size of your new community, is at least double the size of your
  previous one.

  <subsection|<with|color|magenta|Divide and Conquer>>

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

  <subsection|<with|color|magenta|Linear Programming>>

  <item><strong|Simple in Action for LP>

  <\enumerate-numeric>
    <item>Original LP

    <\equation*>
      <text|<em|max>> <around*|(|2x<rsub|1>+5x<rsub|2>|)>
    </equation*>

    <\eqnarray*>
      <tformat|<table|<row|<cell|2x<rsub|1>-x<rsub|2>>|<cell|\<leqslant\>>|<cell|4<htab|5mm><around*|(|1|)>>>|<row|<cell|x<rsub|1>+2x<rsub|2>>|<cell|\<leqslant\>>|<cell|9<htab|5mm><around*|(|2|)>>>|<row|<cell|-x<rsub|1>+x<rsub|2>>|<cell|\<leqslant\>>|<cell|3<htab|5mm><around*|(|3|)>>>|<row|<cell|x<rsub|1>>|<cell|\<geqslant\>>|<cell|0<htab|5mm><around*|(|4|)>>>|<row|<cell|x<rsub|2>>|<cell|\<geqslant\>>|<cell|0<htab|5mm><around*|(|5|)>>>>>
    </eqnarray*>

    Variables <math|x<rsub|1>,x<rsub|2>>, origin
    <math|x<rsub|1>=x<rsub|2>=0>, (4) and (5) are tight.

    Value is <math|2\<times\>0+5\<times\>0=0>.

    <strong|Action: constraint (5) is released> (regarding <math|x<rsub|2>>)
    until (3) becomes tight, then <math|x<rsub|2>=3>. New vertex
    <math|<around*|(|0,3|)>>, new tight constraints (3)(4), new value is 15.

    <item>Change Coordinates <math|y<rsub|1>=x<rsub|1>,y<rsub|2>=3+x<rsub|1>-x<rsub|2>\<Leftrightarrow\>x<rsub|1>=y<rsub|1>,x<rsub|2>=3+y<rsub|1>-y<rsub|2>>.

    New LP

    <\equation*>
      <text|<em|max>> <around*|(|15+7y<rsub|1>-5y<rsub|2>|)>
    </equation*>

    <\eqnarray*>
      <tformat|<table|<row|<cell|y<rsub|1>+y<rsub|2>>|<cell|\<leqslant\>>|<cell|7<htab|5mm><around*|(|1|)>>>|<row|<cell|3y<rsub|1>-2y<rsub|2>>|<cell|\<leqslant\>>|<cell|3<htab|5mm><around*|(|2|)>>>|<row|<cell|y<rsub|2>>|<cell|\<geqslant\>>|<cell|0<htab|5mm><around*|(|3|)>>>|<row|<cell|y<rsub|1>>|<cell|\<geqslant\>>|<cell|0<htab|5mm><around*|(|4|)>>>|<row|<cell|-y<rsub|1>+y<rsub|2>>|<cell|\<geqslant\>>|<cell|3<htab|5mm><around*|(|5|)>>>>>
    </eqnarray*>

    <strong|Action: constraint (4) is released> (regarding <math|y<rsub|2>>)
    until (2) becomes tight, then <math|y<rsub|1>=1>. New vertex
    <math|<around*|(|1,0|)>> <em|(in coordinate system
    <math|<around*|(|y<rsub|1>,y<rsub|2>|)>>)>, new tight constraints (2)(3),
    new value is 22.

    <item>Change Coordinates <math|z<rsub|1>=3-3y<rsub|1>+2y<rsub|2>,z<rsub|2>=y<rsub|2>\<Leftrightarrow\>y<rsub|1>=1-<frac|1|3>z<rsub|1>-<frac|2|3>z<rsub|2>,y<rsub|2>=z<rsub|2>>.

    \ New New LP

    <\equation*>
      <text|<em|max>> <around*|(|22-<frac|7|3>z<rsub|1>-<frac|1|3>z<rsub|2>|)>
    </equation*>

    <\eqnarray*>
      <tformat|<table|<row|<cell|-<frac|1|3>z<rsub|1>+<frac|5|3>z<rsub|2>>|<cell|\<leqslant\>>|<cell|6<htab|5mm><around*|(|1|)>>>|<row|<cell|z<rsub|1>>|<cell|\<geqslant\>>|<cell|0<htab|5mm><around*|(|2|)>>>|<row|<cell|z<rsub|2>>|<cell|\<geqslant\>>|<cell|0<htab|5mm><around*|(|3|)>>>|<row|<cell|-<frac|1|3>z<rsub|1>-<frac|2|3>z<rsub|2>>|<cell|\<leqslant\>>|<cell|1<htab|5mm><around*|(|4|)>>>|<row|<cell|<frac|1|3>z<rsub|1>+<frac|1|3>z<rsub|2>>|<cell|\<leqslant\>>|<cell|4<htab|5mm><around*|(|5|)>>>>>
    </eqnarray*>

    New variables <math|z<rsub|1>,z<rsub|2>>, vertex
    <math|<around*|(|0,0|)>>, (2)(3) are tight, value is 22.
    <with|color|red|All coefficients are less than 0>, we cannot get better
    than that, therefore the optimal value is 22.

    <item>Unreveal the changes of coordinates.

    <\equation*>
      z<rsub|1>=0,z<rsub|2>=0\<Leftrightarrow\>y<rsub|1>=1,y<rsub|2>=0\<Leftrightarrow\>x<rsub|1>=1,x<rsub|2>=4\<nocomma\>
    </equation*>
  </enumerate-numeric>

  <item><strong|Linear Regression>

  Given <math|n> points <math|<around*|(|x<rsub|i>,y<rsub|i>|)>>, find a line
  that best approximates them. Compare ``least squares'' (L2), <em|L1>,
  <em|L1 maximum deviation> regression.

  <\itemize>
    <item>For <em|L1> that minimize <math|<big|sum><rsub|i=1><rsup|n><around*|\||p
    x<rsub|i>+q-y<rsub|i>|\|>>, the constraints for every point should be

    <\eqnarray*>
      <tformat|<table|<row|<cell|>|<cell|-Z<rsub|i>\<leqslant\>p
      x<rsub|i>+q-y<rsub|i>\<leqslant\>Z<rsub|i>,Z<rsub|i>\<geqslant\>0>|<cell|<htab|5mm><around*|(|1|)>>>>>
    </eqnarray*>

    (1) could be expanded into two related constraints for each point
    <math|<around*|(|x<rsub|i>,y<rsub|i>|)>>

    <\eqnarray*>
      <tformat|<table|<row|<cell|p x<rsub|i>+q-y<rsub|i>>|<cell|\<leqslant\>>|<cell|Z<rsub|i><htab|5mm><around*|(|2|)>>>|<row|<cell|-p
      x<rsub|i>-q+y<rsub|i>>|<cell|\<leqslant\>>|<cell|Z<rsub|i>>>>>
    </eqnarray*>

    Extracting the variables <math|x<rsub|i>,y<rsub|i>,Z<rsub|i>>, our
    constraint inequality functions (2) become

    <\eqnarray*>
      <tformat|<table|<row|<cell|p x<rsub|i>+q-Z<rsub|i>>|<cell|\<leqslant\>>|<cell|y<rsub|i><htab|5mm><around*|(|3|)>>>|<row|<cell|-p
      x<rsub|i>-q-Z<rsub|i>>|<cell|\<leqslant\>>|<cell|-y<rsub|i>>>>>
    </eqnarray*>

    Our objective is to minimize <math|<big|sum><rsub|i=1><rsup|n><around*|\||p
    x<rsub|i>+q-y<rsub|i>|\|>> and taking the variables <math|p> and <math|q>
    into account, the objective function could be interpretted as follows:

    <\eqnarray*>
      <tformat|<table|<row|<cell|>|<cell|0p+0q+<big|sum><rsub|i=1><rsup|n>Z<rsub|i>>|<cell|<htab|5mm><around*|(|4|)>>>>>
    </eqnarray*>

    <item>For <em|L1 maximum deviation>, <math|<text|max><rsub|i><around*|\||p
    x<rsub|i>+q-y<rsub|i>|\|>>, the constraints for every point should be

    <\eqnarray*>
      <tformat|<table|<row|<cell|>|<cell|-Z\<leqslant\>p
      x<rsub|i>+q-y<rsub|i>\<leqslant\>Z,Z\<geqslant\>0>|<cell|<htab|5mm><around*|(|5|)>>>>>
    </eqnarray*>

    And now the <math|Z> is the overall constraint for every point, the
    constraints inequality function could be represented as follows:

    <\eqnarray*>
      <tformat|<table|<row|<cell|p x<rsub|i>+q-Z>|<cell|\<leqslant\>>|<cell|y<rsub|i><htab|5mm><around*|(|6|)>>>|<row|<cell|-p
      x<rsub|i>-q-Z>|<cell|\<leqslant\>>|<cell|-y<rsub|i>>>>>
    </eqnarray*>

    Our objective is to minimize <math|<text|max><rsub|i><around*|\||p
    x<rsub|i>+q-y<rsub|i>|\|>> and taking the variables <math|p> and <math|q>
    into account, the objective function could be interpretted as follows:

    <\eqnarray*>
      <tformat|<table|<row|<cell|>|<cell|0p+0q+Z>|<cell|<htab|5mm><around*|(|7|)>>>>>
    </eqnarray*>

    <item>In Figure 1, we plot 10 points in the coordinates and arbitrarily
    setting the first point be the outlier. The legend is that gray line
    represents the built-in least-squares regression routine
    <with|font|stix|polyfit>; red line represents our
    <with|font|stix|L1Regression> and green line denotes
    <with|font|stix|L1MaxRegression>.

    From the image, we know that the built-in least squares regression
    <with|font|stix|polyfit> looks <em|worse> than L1Regression but still
    better than L1MaxRegression.
  </itemize>

  <item><strong|Proof for Polynimial Time Solution of LP and key Theorem>

  <\theorem>
    As long as the resulting linear program has an optimal solution all of
    whose coordinates are integer, the problem could be solved in polynomial
    time by LP.
  </theorem>

  <\theorem>
    The set of optima of a LP always includes a vertex of the constraint
    polytope.
  </theorem>

  <strong|<em|Example>>, LP for maximizing
  <math|<big|sum><rsub|i\<in\>C>r<rsub|i>>.
  <strong|<with|color|blue|variables>>: <math|c<rsub|i>>: whether or not a
  course is being taken; <strong|<with|color|blue|constraints>>:
  <math|0\<leqslant\>c<rsub|i>\<leqslant\>1> and <math|c<rsub|i>> is an
  integer (meaning that <math|c<rsub|i>> is either 0 or 1); if course
  <math|j> is a prerequisite for course <math|i>, then we add the constraint
  <math|c<rsub|j>\<geqslant\>c<rsub|i>>, meaning that if <math|c<rsub|i>=1>,
  then we must have <math|c<rsub|j>=1> as well.
  <strong|<with|color|blue|objective function>>:
  <math|<text|max><big|sum><rsub|i>c<rsub|i>r<rsub|i>>.
  <strong|<with|color|blue|proof>>: recall that a vertex is defined by a
  subset of the constraints being at equality. Note that all the constraints,
  at equality, have one of the three forms
  <math|<rsup|<around*|(|1|)>>c<rsub|i>=0>,
  <math|<rsup|<around*|(|2|)>>c<rsub|i>=1>, or
  <math|<rsup|<around*|(|3|)>>c<rsub|i>=c<rsub|j>>. Thus if several such
  equations have a unique solution, that solution must clarly have each
  coordinate equal to 0 or 1. Namely, the LP always has an integer solution.

  <item><strong|Duality>

  We appeal to the following physics intuition:

  <\enumerate>
    <item>the force that constraint <math|i> exerts on the marble must be a
    nonnegative multiple of <math|A<rsub|i>>, where <math|A<rsub|i>> is the
    <math|i>th row of the matrix <math|A>, associated with the <math|i>th
    constraint <math|A<rsub|i>\<cdot\>x\<geqslant\>b<rsub|i>>;

    <item>the total force these contraints exert on the marble must be in the
    up direction, <math|u>;

    <item>only constraints that pass through <math|x<rsup|\<ast\>>> can exert
    force on the marble.
  </enumerate>

  The physics intuition could be expressed in the following fact:

  <\enumerate>
    <item>there are nonnegative values <math|y<rsub|i>,\<ldots\>,y<rsub|m>>
    such that

    <item><math|y<rsub|1>A<rsub|1>+\<ldots\>+y<rsub|m>A<rsub|m>=u>, and where

    <item><math|y<rsub|i>=0> if contraint <math|i> does not pass through
    <math|x<rsup|\<ast\>>> (explicitly, constraint <math|i>, which says
    <math|A<rsub|i>\<cdot\>x\<geqslant\>b<rsub|i>>, passes through
    <math|x<rsup|\<ast\>>> if <math|A<rsub|i>\<cdot\>x<rsup|\<ast\>>=b<rsub|i>>).
  </enumerate>

  Here <math|<around*|{|y<rsub|i>|}>> is a feasible soution to the dual LP,
  also the objective value of <math|<around*|{|y<rsub|i>|}>> in the dual
  linear program equals the optimal objective value of the original LP,
  <math|u\<cdot\>x<rsup|\<ast\>>>, <em|i.e.>, <math|u
  x<rsup|\<ast\>>=b<rsup|T>y>.\ 

  <\theorem>
    Let <math|<with|color|blue|OPT=<text|Maximize >c<rsup|T>X>>,
    <math|<with|color|dark red|A x\<leqslant\>b,x\<geqslant\>0>>,
    <with|color|blue|<math|OPT<rsup|*\<ast\>>=<text|Minimize >b<rsup|T>Y>>,
    <with|color|dark red|<math|A<rsup|T>y\<geqslant\>c,y\<geqslant\>0>>.
    There are three possibilities:

    <\eqnarray*>
      <tformat|<table|<row|<cell|<text|OPT>=+\<infty\>>|<cell|\<Leftrightarrow\>>|<cell|<text|dual
      LP is infeasible>>>|<row|<cell|<text|or
      OPT<math|>>\<in\>R>|<cell|\<Leftrightarrow\>>|<cell|<text|OPT><rsup|\<ast\>>\<in\>R<htab|5mm><around*|(|<text|OPT>=<text|OPT><rsup|\<ast\>>|)>>>|<row|<cell|<text|or
      LP is infeasible>>|<cell|\<Leftrightarrow\>>|<cell|<text|OPT><rsup|\<ast\>>=-\<infty\>>>>>
    </eqnarray*>
  </theorem>

  <em|<strong|Example>> (Intuition): in <em|Scissor-Paper-Rock> problem, for
  row player, her <em|expected playoff> is <with|color|blue|at least (by
  lower bound)> <math|f> in primal form (maximization), but her <em|expected
  playoff> is <with|color|blue|at most (by upper bound)>
  <math|f<rsup|\<ast\>>> in dual form (minimization), given the column
  player's strategy. By strong duality, <math|f=f<rsup|\<ast\>>> and thus the
  row player gets <em|expected payoff> exactly <math|f> and cannot improve
  this.

  <item><strong|Duality in General>

  We want to express the LP in normal and general form such that either
  <with|color|blue|<math|<text|max > C<rsup|T>X>>, <em|s.t.> <math|A
  X\<leqslant\>b>, <math|X\<geqslant\>0> or <with|color|blue|min>
  <math|<with|color|blue|C<rsup|T>X>>, <math|A X\<geqslant\>b>,
  <math|X\<geqslant\>0>. In general, inequalities could be of the form
  ``<math|\<leqslant\>>'', ``<math|\<geqslant\>>'', ``<math|=>'' and mixed,
  <math|x<rsub|i>>'s not necessarily <math|\<geqslant\>0>.

  <\itemize>
    <item>Inequalities: <em|e.g.>, for maximization, we want
    <math|\<leqslant\>> everywhere, we can simply take negation on both side
    of <math|\<geqslant\>>.

    <item>Equalities: ``<math|=>'' could be turned into
    ``<math|\<leqslant\>>'' or ``<math|\<geqslant\>>'', it holds for both
    maximization and minimization.

    <item>For <math|x<rsub|i>\<geqslant\>0>: solution is to define new
    variables, <em|e.g.>, <math|3x<rsub|1>+4x<rsub|5>\<leqslant\>6>, we let
    <math|x<rsub|1>=x<rsub|1><rsup|+>-x<rsub|1><rsup|->>,
    <math|x<rsub|1><rsup|+>,x<rsub|1><rsup|->> both <math|\<geqslant\>0>. If
    <math|x<rsub|1>=-3>, <math|x<rsub|1><rsup|+>=0>,
    <math|x<rsub|1><rsup|->=3>.
  </itemize>

  <item><strong|Note>

  The dual of an unconstrainted variable is an equality constraint,
  <em|e.g.>, <strong|variables> <math|<matrix|<tformat|<table|<row|<cell|r>|<cell|p>|<cell|s>|<cell|m>>>>>>,
  <strong|objective function> <math|<text|maximize >m>, constraints
  <math|<matrix|<tformat|<table|<row|<cell|-A<rsub|1,1>>|<cell|-A<rsub|2,1>>|<cell|-A<rsub|3,1>>|<cell|1>>|<row|<cell|-A<rsub|1,2>>|<cell|-A<rsub|2,2>>|<cell|-A<rsub|3,2>>|<cell|1>>|<row|<cell|-A1,3>|<cell|-A<rsub|2,3>>|<cell|-A<rsub|3,3>>|<cell|1>>|<row|<cell|1>|<cell|1>|<cell|1>|<cell|0>>>>><matrix|<tformat|<table|<row|<cell|r>>|<row|<cell|p>>|<row|<cell|s>>|<row|<cell|m>>>>><stack|<tformat|<table|<row|<cell|\<leqslant\>>>|<row|<cell|\<leqslant\>>>|<row|<cell|\<leqslant\>>>|<row|<cell|=>>>>><matrix|<tformat|<table|<row|<cell|0>>|<row|<cell|0>>|<row|<cell|0>>|<row|<cell|1>>>>>>,
  and <math|r,p,s\<geqslant\>0>, with <math|m> unconstrainted.

  <subsection|<with|color|magenta|Maximum Flow>>

  <item><strong|Ford-fulgerson Algorithm>

  <\render-code>
    initial flow: <math|f<rsub|e>=0,\<forall\>e>

    <math|H=copy of G\<nocomma\>,<text|the residual graph>>

    <strong|while> <math|H> has a path from <math|s> to <math|t> <strong|do>

    \ \ \ \ <math|p=<text|<em|s-t> path in <math|H>, <math|v> be its value>>

    \ \ \ \ <math|f=<text|augument <math|f> with <math|p>>>

    \ \ \ \ <math|H=>new residual graph of <math|G> for <math|f>

    <strong|return> <math|f>
  </render-code>

  <item><strong|Relation between Flow and Matching>

  <strong|<em|Three> <em|steps><em|>>: (1) Build the flow; (2) Prove the
  resulting flow could be turned into a maximum match; (3) Prove the flow
  <math|f> satisfies all the constraints.

  <em|Proving that solving the maximum flow problem can give us a valid
  matching plan.>

  Because the capacities are integers, our flow will be
  <with|color|blue|integral>. Because the capacities are all 1, we will
  either use an edge completely or not use an edge at all.

  Let <math|M> be the set of edges going from <math|A> to <math|B> that we
  use. We will show that (i) <math|M> is a matching, (ii) <math|M> is the
  largest possible matching.

  <\enumerate>
    <item><math|M> is a valid marriage plan

    We can choose at most one edge leaving any vertex in <math|A>. We can
    choose at most one edge reaching vertex in <math|B>. If we chose more
    than 1, we couldn't have balanced flow between <math|A> and <math|B>.

    <item><math|M> is the largest possible matching

    The correspondence between flows and matchings is <emdash> if there is a
    matching of <math|k> edges between <math|A> and <math|B>, the resulting
    flow <math|f>, starting from <math|s> and sinking into <math|t>, would be
    of value <math|k>, where <math|f> has 1 unit of flow across each of the
    <math|k> edges and <math|\<leqslant\>1> unit leaves (from <math|A>) and
    enters (into <math|B>) each node; if there is a flow <math|f> of integral
    value <math|k>, there is a matching with <math|k> edges between <math|A>
    and <math|B>.

    We have found the maximum flow <math|f> with <math|k> edges (via
    <em|Ford-fulgerson Algo>) and this corresponds to a matching <math|M> of
    <math|k> edges. If there was a matching with <math|\<gtr\>k> edges, we
    could have found a flow with value <math|\<gtr\>k>, contradicting that
    <math|f> was maximum. Hence <math|M> is the maximum matching.
  </enumerate>

  <item><strong|Min-cut>

  <em|As a byproduct of the Ford-Fugerson Algorithm>. Let <math|L> be the
  nodes that <em|are> reachable from <math|s> in <math|H>, and let
  <math|R=V-L> be the rest of the nodes. Then <math|<around*|(|L,R|)>> is a
  cut in the graph <math|G>.

  <\theorem>
    Maximum <math|s>-<math|t> flow is <math|\<leqslant\>> minimum
    <math|s>-<math|t> cut. (Why Ford-Fugerson can stop? the best flow is as
    best as min <math|s>-<math|t> cut, and then as long as we build the flow
    which is evaluated to equalto the min <math|s>-<math|t> cu, we know it's
    as best as possible, we can stop.
  </theorem>

  <item><strong|Runtime>

  The running time of <em|Ford-Fulkerson> is
  <math|O<around*|(|<around*|\||E|\|>\<cdot\><around*|\||f|\|>|)>> where
  <math|<around*|\||E|\|>> is the number of edges of <math|G> and
  <math|<around*|\||f|\|>=<big|sum><rsub|e<text| leaving
  <math|s>>>c<rsub|e>\<nocomma\>=<around*|\||A|\|>=n>. There would be at most
  <math|n+m+n m> edges in <math|G>. So the running time is
  <math|O<around*|(|n<rsup|2> m|)>>.

  However, if paths are chosen in a sensible mannerin particular, by using a
  breadth-firrst search, which finds the path with the fewest
  edges<emdash>then the number of iterations is at most
  <math|O<around*|(|<around*|\||V|\|>\<cdot\><around*|\||E|\|>|)>>, no matter
  what the capacities are. This latter bound gives an overall running time of
  <math|O<around*|(|<around*|\||V|\|>\<cdot\><around*|\||E|\|><rsup|2>|)>>
  for maximum flow. (<em|Edmonds-Karp>: at each iteration, pick shortest
  <math|s>-<math|t> path)

  <subsection|<with|color|magenta|Fast Fourier Transform>>

  <strong|<item>Linear Combination>

  <\math>
    a=randn<around*|(|1\<nocomma\>,100|)>
  </math>

  <math|b =randn<around*|(|1,100|)>>

  <math|a b=<around*|[|a;b|]>>

  <math|c=<around*|[|3,-5|]>>

  <math|<around*|(|c \<star\>a b<rprime|'>|)>./diag<around*|(|a b\<star\>a
  b<rprime|'>|)><rprime|'>>

  <\math>
    c\<star\>a b<rprime|'>\<star\>inv<around*|(|a b\<star\>a
    b<rprime|'>|)>=<around*|[|3,-5|]>
  </math>

  <strong|<item>Cosine Basis>

  <math|a b=<around*|[|cos<around*|(|<around*|(|.5:100|)>/<with|color|red|100>\<star\>pi\<star\>3|)>;cos<around*|(|<around*|(|.5:100|)>/<with|color|red|100>\<star\>pi\<star\>4|)>|]>>

  <math|c=<around*|[|3,-5|]>\<star\>a b>

  <math|<around*|(|c\<cdot\>a b<rprime|'>|)>./diag<around*|(|a b\<cdot\>a
  b<rprime|'>|)><rprime|'>> recovers the coefficients exactly.
  <with|color|red|Why? Because cosine fucntions are orthogonal to each
  other>: the matrix <math|a b\<cdot\>a b<rprime|'>> only has entries on its
  diagonal; vector <math|x>, <math|y> are orthogonal if their dot product is
  0, thus <math|sum<around*|(|a.\<star\>b|)>\<approx\>0>, the frequency
  number has to be between <with|color|red|0> and <with|color|red|99>.

  <strong|<item>Cosine Transform of an Image>

  <\itemize-minus>
    <item><with|font-shape|italic|inverse cosine transform>: is the process
    of expressing a signal interms of cosines for our vector <math|c> we
    computed as <math|<around*|(|c\<star\>M<rprime|'>|)>./diag<around*|(|M\<star\>M<rprime|'>|)>>,\ 

    <item><with|font-shape|italic|cosine transform>: is the process of taking
    coefficients and computing the corresponding linear combination of
    cosines, which we computed by just multiplying by <math|M>.
  </itemize-minus>

  <strong|<item>Fourier Transforms>

  <\enumerate-roman>
    <item>Pseudocode for FFT

    <with|font-shape|italic|Input>: <math|<around*|(|a<rsub|0>,a<rsub|1>,\<ldots\>,a<rsub|n-1>|)>>
    coefficients of a polynomial <math|f> of degree <math|\<less\>n>,
    <math|n=2p=2<rsup|k>> (power of 2, assume n' is pad to
    <math|n=2<rsup|k>>)

    <\eqnarray*>
      <tformat|<table|<row|<cell|<text|let
      ><choice|<tformat|<table|<row|<cell|f<rsup|<around*|(|0|)>> be the
      polynomial with coefficients <around*|(|a<rsub|0>,a<rsub|2>,a<rsub|4>,\<ldots\>|)>>>|<row|<cell|f<rsup|<around*|(|1|)>>
      be the polynomial with coefficients
      <around*|(|a<rsub|1>,a<rsub|3>,a<rsub|5>,\<ldots\>|)>>>>>>>|<cell|>|<cell|>>>>
    </eqnarray*>

    recursively find\ 

    <\eqnarray*>
      <tformat|<table|<row|<cell|f<rsup|<around*|(|0|)>><around*|(|y|)>: y is
      p<rsup|th> complex root of 1>|<cell|>|<cell|>>|<row|<cell|f<rsup|<around*|(|1|)>><around*|(|y|)>:y
      is p<rsup|th> complex root of 1>|<cell|>|<cell|>>>>
    </eqnarray*>

    for each <math|j>, let <math|x<rsub|j>=e<rsup|2\<pi\>i j/n>>,
    <math|y\<leftarrow\>x<rsub|j><rsup|2>>,\ 

    <\eqnarray*>
      <tformat|<table|<row|<cell|y=<choice|<tformat|<table|<row|<cell|e<rsup|2\<pi\>i
      j /P>\<nocomma\>,<htab|5mm>if j\<leqslant\>P-1>>|<row|<cell|e<rsup|2\<pi\>i
      <around*|(|j-P|)>/P>,<htab|5mm>if j\<geqslant\>P>>>>>>|<cell|>|<cell|<htab|5mm>>>>>
    </eqnarray*>

    <math|f<around*|(|x<rsub|j>|)>\<leftarrow\>f<rsup|<around*|(|0|)>><around*|(|y|)>+x<rsub|j>f<rsup|<around*|(|1|)>><around*|(|y|)>>

    <with|font-shape|italic|Output>: <math|<around*|{|f<around*|(|x<rsub|j>|)>:
    0\<leqslant\>j\<leqslant\>n-1|}>>

    <item>Theorem

    This is an <math|O<around*|(|n log n|)>> algorithm.

    <item>Matrix

    <\eqnarray*>
      <tformat|<table|<row|<cell|>|<cell|<matrix|<tformat|<table|<row|<cell|y<rsub|0>>>|<row|<cell|y<rsub|1>>>|<row|<cell|\<ldots\>>>|<row|<cell|\<ldots\>>>|<row|<cell|y<rsub|j>>>|<row|<cell|\<ldots\>>>|<row|<cell|y<rsub|n-1>>>>>>=<matrix|<tformat|<table|<row|<cell|<tabular|<tformat|<cwith|1|1|1|1|cell-hyphen|t>|<table|<row|<cell|1>>>>>>|<cell|x<rsub|0>>|<cell|x<rsub|0><rsup|2>>|<cell|\<ldots\>>|<cell|x<rsub|0><rsup|k>>|<cell|\<ldots\>>|<cell|x<rsub|0><rsup|n-1>>>|<row|<cell|1>|<cell|x<rsub|1>>|<cell|x<rsub|1><rsup|2>>|<cell|\<ldots\>>|<cell|\<ldots\>>|<cell|\<ldots\>>|<cell|x<rsub|1><rsup|n-1>>>|<row|<cell|\<ldots\>>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|>>|<row|<cell|\<ldots\>>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|>>|<row|<cell|1>|<cell|x<rsub|j>>|<cell|x<rsub|j><rsup|2>>|<cell|\<ldots\>>|<cell|e<rsup|2\<pi\>i<around*|(|j
      k|)>/n>>|<cell|\<ldots\>>|<cell|x<rsub|j><rsup|n-1>>>|<row|<cell|\<ldots\>>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|>>|<row|<cell|1>|<cell|x<rsub|n-1>>|<cell|x<rsub|n-1><rsup|2>>|<cell|\<ldots\>>|<cell|>|<cell|\<ldots\>>|<cell|x<rsup|n-1><rsub|n-1>>>>>><matrix|<tformat|<table|<row|<cell|a<rsub|0>>>|<row|<cell|a<rsub|1>>>|<row|<cell|\<ldots\>>>|<row|<cell|\<ldots\>>>|<row|<cell|a<rsub|j>>>|<row|<cell|\<ldots\>>>|<row|<cell|a<rsub|n-1>>>>>>>|<cell|>>>>
    </eqnarray*>
  </enumerate-roman>

  <strong|<item>Inverse FFT>

  <\enumerate-roman>
    <item>Given: the images of the <math|n<rsup|th>> roots of 1 by an unknown
    polynomial of degree <math|\<leqslant\>n-1>

    <item>Output: the coefficients of the polynomial

    <item>Call it <math|p<around*|(|x|)>>, the unknown coefficients:
    <math|a<rsub|0>,a<rsub|1>,\<ldots\>,a<rsub|n-1>>,
    <math|p<around*|(|x|)>=a<rsub|0>+a<rsub|1>x+\<ldots\>+a<rsub|n-1>x<rsup|n-1>>

    <item>Call the <math|n<rsup|th>> roots of unity:
    <math|x<rsub|0>,x<rsub|1>,\<ldots\>,x<rsub|n-1>>,
    <math|x<rsub|j>=e<rsup|2\<pi\>i j/n>>

    <item>Call their images: <math|y<rsub|0>,y<rsub|1>,\<ldots\>,y<rsub|n-1>>

    <item>We want <math|a<rsub|0>,a<rsub|1>,\<ldots\>,a<rsub|n-1>>, this is a
    linear system of equation

    <item>We just need to invert the above matrix, let
    <math|z=e<rsup|2\<pi\>i / n>>

    <math|M=<matrix|<tformat|<table|<row|<cell|1>|<cell|z<rsup|0>>|<cell|z<rsup|0>>|<cell|\<ldots\>>|<cell|z<rsup|0<around*|(|k|)>>>|<cell|\<ldots\>>|<cell|z<rsup|0<around*|(|n-1|)>>>>|<row|<cell|\<ldots\>>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|>>|<row|<cell|1>|<cell|z<rsup|j>>|<cell|z<rsup|2j>>|<cell|\<ldots\>>|<cell|z<rsup|j
    k>>|<cell|\<ldots\>>|<cell|z<rsup|j<around*|(|n-1|)>>>>|<row|<cell|\<ldots\>>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|>>|<row|<cell|1>|<cell|z<rsup|n-1>>|<cell|z<rsup|2<around*|(|n-1|)>>>|<cell|\<ldots\>>|<cell|\<ldots\>>|<cell|\<ldots\>>|<cell|z<rsup|<around*|(|n-1|)><rsup|2>>>>>>>>

    the Van der Mondes matrix has a non-zero determinant, inverse matrix is:

    <math|M<rsup|-1>=<matrix|<tformat|<table|<row|<cell|1>|<cell|1>|<cell|1>|<cell|\<ldots\>>|<cell|1>|<cell|\<ldots\>>|<cell|1>>|<row|<cell|1>|<cell|z<rsup|-1>>|<cell|z<rsup|-2>>|<cell|\<ldots\>>|<cell|>|<cell|>|<cell|>>|<row|<cell|1>|<cell|z<rsup|-2>>|<cell|z<rsup|-4>>|<cell|\<ldots\>>|<cell|>|<cell|>|<cell|>>|<row|<cell|1>|<cell|\<ldots\>>|<cell|\<ldots\>>|<cell|z<rsup|-j
    k>>|<cell|>|<cell|>|<cell|>>|<row|<cell|\<ldots\>>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|>>|<row|<cell|1>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|>>>>>\<cdot\><frac|1|n>>

    <item><math|<around*|(|a<rsub|j>|)>=M<rsup|-1><around*|(|y<rsub|j>|)>>
  </enumerate-roman>

  <strong|<item>Relation between <em|FFT> and <em|Convolution>>

  <\eqnarray*>
    <tformat|<table|<row|<cell|p<around*|(|x|)>=<big|sum><rsup|n-1><rsub|j=0>a<rsub|j>x<rsup|j>,
    q<around*|(|x|)>=<big|sum><rsup|n-1><rsub|i=0>b<rsub|i>x<rsup|i>\<nocomma\>\<nocomma\>,
    C<rsub|k>=<big|sum><rsub|j+i=k>a<rsub|j>b<rsub|i>>|<cell|>|<cell|>>>>
  </eqnarray*>

  <em|e.g.>

  <\eqnarray*>
    <tformat|<table|<row|<cell|<around*|(|a<rsub|0>+a<rsub|1>x|)><around*|(|b<rsub|0>+b<rsub|1>x|)>>|<cell|=>|<cell|<below|<wide*|a<rsub|0>b<rsub|0>|\<wide-underbrace\>>|C<rsub|0>>+<below|<wide*|<around*|(|a<rsub|0>b<rsub|1>+a<rsub|1>b<rsub|0>|)>|\<wide-underbrace\>>|C<rsub|1>>x+<below|<wide*|a<rsub|1>b<rsub|1>x<rsup|2>|\<wide-underbrace\>>|C<rsub|2>>>>>>
  </eqnarray*>

  <math|>

  Let <math|a<rsup|T>=<around*|(|a<rsub|0>,\<ldots\>,a<rsub|n-1>|)>>,
  <math|b<rsup|T>=<around*|(|b<rsub|0>,\<ldots\>,b<rsub|n-1>|)>>, the
  relation we get is as follows

  <\eqnarray*>
    <tformat|<table|<row|<cell|<with|color|blue|a\<otimes\>b=C=<text|<em|DFT>><rsub|2n><rsup|-1><around*|(|<text|<em|DFT>><rsub|2n><around*|(|a|)>\<cdot\><text|<em|DFT>><rsub|2n><around*|(|b|)>|)>>>|<cell|>|<cell|>>>>
  </eqnarray*>

  <strong|<item>Application: Big-Multiplication>

  To multiply <math|A<around*|(|x|)>=a<rsub|0>+a<rsub|1>x+\<ldots\>+a<rsub|n-1>x<rsup|n-1>>
  by <math|B<around*|(|x|)>=b<rsub|0>+b<rsub|1>x+\<ldots\>+b<rsub|n-1>x<rsup|n-1>>:
  (1) find <math|<around*|(|x<rsub|i>,A<around*|(|x<rsub|i>|)>|)>> and
  <math|<around*|(|x<rsub|i>,B<around*|(|x<rsub|i>|)>|)>> for <math|2n-1>
  different values of <math|x<rsub|i>>; <math|<with|color|blue|O<around*|(|n
  log n|)>>> with <with|font-shape|italic|FFT>; (2) for all <math|i> compute
  <math|p<around*|(|x<rsub|i>|)>\<cdot\>q<around*|(|x<rsub|i>|)>>;
  <with|color|blue|<math|O<around*|(|n|)>>>; (3) <math|p q<around*|(|x|)>> is
  the polynomial with points <math|<around*|(|x<rsub|i>,p<around*|(|x<rsub|i>|)>\<cdot\>q<around*|(|x<rsub|i>|)>|)>>
  of <with|font-shape|italic|deg><math|\<leqslant\>2n-2>;
  <math|<with|color|blue|O<around*|(|n log n|)>>> with <em|iFFT>.

  <\render-code>
    <with|font-shape|small-caps|Big-Mult>(<math|a,b>)

    <tabular|<tformat|<table|<row|<cell|1>|<cell|<math|><em|na>=<strong|length>(<math|a>);
    <em|nb>=<strong|length>(<math|b>);>>|<row|<cell|2>|<cell|<math|a=[a
    <text| <strong|zeros>>(1, <text|<em|nb>>-1)]; b=[b <text|<strong|
    zeros>>(1, <text|<em|na>>-1)];>>>|<row|<cell|3>|<cell|<math|c=ifft<around*|(|fft<around*|(|a|)>.\<ast\>fft<around*|(|b|)>|)>>;
    /* inner matrix dimensions must agree */>>|<row|<cell|4>|<cell|/* remove
    redundant zeros */>>>>>
  </render-code>

  <subsection|<with|color|magenta|Denoise Quadratic (Image Denoising)>>

  According to the handout, the equation we are trying to minimize is as
  follows:

  <\eqnarray*>
    <tformat|<table|<row|<cell|>|<cell|<below|<wide*|k<big|sum><rsub|i><around*|(|x<rsub|i>-x<rsub|i<rsub|<text|<em|right>>>>|)><rsup|2>|\<wide-underbrace\>>|A>+<below|<wide*|k<big|sum><rsub|j><around*|(|x<rsub|j>-x<rsub|j<rsub|<text|<em|up>>>>|)><rsup|2>|\<wide-underbrace\>>|B>+<big|sum><rsub|m><around*|(|x<rsub|m>-I<rsub|m>|)><rsup|2>>|<cell|<htab|5mm><around*|(|1|)>>>>>
  </eqnarray*>

  <math|A> and <math|B> above could be represented by the convolution form,
  so (1) is equivalent to\ 

  <\equation*>
    <below|<wide*|k<around*|(|X\<otimes\>K<rsub|1>|)><rsup|2>|\<wide-underbrace\>>|A<rsup|<text|<em|Conv>>>>+<below|<wide*|k<around*|(|X\<otimes\>K<rsub|2>|)><rsup|2>|\<wide-underbrace\>>|B<rsup|<text|<em|Conv>>>>+<big|sum><rsub|m><around*|(|x<rsub|m>-I<rsub|m<rsub|>>|)><rsup|2>
  </equation*>

  where <math|K<rsub|1>=<matrix|<tformat|<table|<row|<cell|-1>|<cell|1>>>>>,
  K<rsub|2>=<matrix|<tformat|<table|<row|<cell|1>>|<row|<cell|-1>>>>>>, as we
  compute convolution for each row and each column for above. Now
  <math|A<rsup|<text|<em|Conv>>>> and <math|B<rsup|<text|<em|Conv>>>> could
  be expressed as follows using <em|Fourier> transform,

  <\equation*>
    k<around*|(|F<around*|(|X|)>\<cdot\>F<around*|(|K<rsub|1>|)>|)><rsup|2>+k<around*|(|F<around*|(|X|)>\<cdot\>F<around*|(|K<rsub|2>|)>|)><rsup|2>+<big|sum><rsub|k><around*|(|x<rsub|m>-I<rsub|m<rsub|>>|)><rsup|2>
  </equation*>

  According to <em|Parseval's Theorm><emdash><em|the sum of the squares of
  the magnitudes of <math|x> equals the sum of the squares of the magnitudes
  of its (1 or 2-dimensional) Fourier Transform>, we could tranform the term
  <math|<big|sum><rsub|m><around*|(|x-I<rsub|m>|)><rsup|2>> into the
  <em|Fourier> transform, so we have

  <\eqnarray*>
    <tformat|<table|<row|<cell|>|<cell|>|<cell|k<around*|(|F<around*|(|X|)>\<cdot\>F<around*|(|K<rsub|1>|)>|)><rsup|2>+k<around*|(|F<around*|(|X|)>\<cdot\>F<around*|(|K<rsub|1>|)>|)><rsup|2>+
    <around*|(|F<around*|(|X|)>-F<around*|(|I|)>|)><rsup|2><htab|5mm><around*|(|2|)>>>>>
  </eqnarray*>

  So taking the variable <math|X>, to calculate the derivative of (2) in
  order to minimize <em|X>, we have\ 

  <\eqnarray*>
    <tformat|<table|<row|<cell|2 k F<around*|(|X|)>\<cdot\>F<around*|(|K<rsub|1>|)><rsup|2>+2k
    F<around*|(|X|)>\<cdot\>F<around*|(|K<rsub|2>|)><rsup|2>+2F<around*|(|X|)>-2F<around*|(|I|)>>|<cell|=>|<cell|0>>|<row|<cell|F<around*|(|X|)>>|<cell|=>|<cell|<frac|F<around*|(|I|)>|k<around*|(|F<around*|(|K<rsub|1>|)><rsup|2>+F<around*|(|K<rsub|2>|)><rsup|2>|)>+1>>>>>
  </eqnarray*>

  Now using inverse <em|Fourier> transform we could get the <math|X> which
  could minimize the formula (1), that is

  <\equation*>
    X=F<rsup|-1><around*|(|<frac|F<around*|(|I|)>|k<around*|(|F<around*|(|K<rsub|1>|)><rsup|2>+F<around*|(|K<rsub|2>|)><rsup|2>|)>+1>|)>
  </equation*>

  <subsection|<with|color|magenta|Convexity and Golden Section Search>>

  <item><strong|Convexity>

  <\definition>
    A function <math|f> from <math|n>-dimensional space to the real numbers
    is convex if for any two inputs <math|x> and <math|y>, the line segment
    in the graph of <math|f> from <math|(x, f(x))> to <math|(y, f(y))> lies
    on or above the graph of <math|f>. (The To express this slightly more
    formally, for any interpolation parameter between 0 and 1, we have the
    condition <with|color|red|<with|color|brown|<math|\<lambda\>f(x) + (1
    -\<lambda\> )f(y) \<geqslant\>f(x + (1 -\<lambda\> )y)>>>.
  </definition>

  <strong|Claim <em|1>>: there does not exist a convext function which passes
  through <math|<around*|(|x<rsub|1>,f<around*|(|x<rsub|1>|)>|)>,<around*|(|x<rsub|2>,f<around*|(|x<rsub|2>|)>|)>,<around*|(|x<rsub|3>,f<around*|(|x<rsub|3>|)>|)>>
  and any fourth point in the ``red'' region. <strong|Claim <em|2>>: as
  oppose to last claim, the convex function lie outside the region whose
  <math|x>-coordinate is between <math|x<rsub|1>> and <math|x<rsub|3>>.

  <\lemma>
    Assume you have an algorithm that can minimize convext functions in
    <math|n-1> dimensions; then we can solve the full <math|n>-dimensional
    minimization algorithm by just running a 1-dimensional minimization
    algorithm over the function that is the result of minimizing the input
    function over its remaining <math|n-1> dimensions (using the
    <math|n-1>-dimensional algorithm as a black box). <strong|Crucial Fact>:
    Given a convex function in two dimensions, <math|f(x, y)>, if we define a
    new function <math|g(x) = <text|min><rsub|y> f(x, y)> to be the minimum
    of <math|f> along its second dimension, for each value of <math|x>, then
    <math|g> is a convex function.
  </lemma>

  <\lemma>
    The first time the algorithm makes a bad decision
    (<math|<wide|g|~><around*|(|x<rsub|2>|)>\<less\><wide|g|~><around*|(|x<rsub|4>|)>>
    while <math|g<around*|(|x<rsub|2>|)>\<gtr\>g<around*|(|x<rsub|4>|)>>),
    recursing to an interval that does not contain the global minimumis
    happens, the true global minimum of <math|g> is at least
    <math|<wide|g|~><around*|(|x<rsub|2>|)>-\<phi\><rsup|2>\<epsilon\>>.
  </lemma>

  <item><strong|Golden Section Search>

  <\definition>
    <math|\<phi\>=<frac|<sqrt|5>+1|2>>, which has the property
    <math|1+\<phi\>=\<phi\><rsup|2>\<nocomma\>,<frac|1|\<phi\><rsup|2>>+<frac|1|\<phi\>>=1>,
    we make <math|x<rsub|4>=x<rsub|1>+x<rsub|3>-x<rsub|2>> lie in whichever
    interval <math|<around*|[|x<rsub|1>,x<rsub|2>|]>> or
    <math|<around*|[|x<rsub|2>,x<rsub|3>|]>> is larger, recurse on the side
    which could have prospective better lower bound. Stops when
    <math|f<around*|(|x<rsub|2>|)>-f<around*|(|x<rsub|4>|)>\<leqslant\>\<epsilon\>>.
  </definition>

  <strong|Analysis>: Each iteration the size of the interval decreases by a
  factor of <math|\<phi\>>, using one function evaluation (as
  <math|x<rsub|2>\<nocomma\>,x<rsub|4>> are computed in previous recursion).
  So to improve the precision by a factor of <math|p> takes
  <math|log<rsub|\<phi\>>p> iterations now, which is 30% better than
  <math|2log<rsub|2>p> of the binary search algorithm.

  <subsection|<with|color|magenta|Principle Components Analysis>>

  <item><strong|Punchline>

  It is about using sophisticated tools to reveal things you wouldn't know to
  look for otherwise; also, it gives us faith in the Fourier (or cosine)
  transform that we can recover something essentially the same via this
  purely <with|color|blue|statistical> technique.

  <item><strong|Significance>

  Matrix <math|u> should be <math|256\<times\>256>, where each column
  represents a <math|16\<times\>16> image chunk; where collectively all 256
  image chunks (columns) can be added together in different combinations to
  represent all <math|16\<times\>16> image blocks; and where the first column
  is the most important image chunk and etc.

  If we can only pick 10 coefficients <math|c<rsub|1>,\<ldots\>,c<rsub|10>>
  to represent an image, we should pick the first 10 chunks to multiple with
  the <math|c> vector.

  The resulting 256 <math|16\<times\>16> blocks, arranged in 16 rows of 16
  columns could be used to generate an image similar to <em|Discrete Cosine
  Transform> <with|color|blue|basis> one by arranging them from top left to
  the right in descending order of importance.

  <item><strong|Take-home Message>

  We put this problem on the set because it is a powerful analytic technique
  with a broad range of applications. Most directly, this can be used not
  just for images but also for sound compression. Less directly, principal
  components analysis (PCA) can be used on many types of data, even discrete,
  and is commonly found in machine learning, pattern recognition, data mining
  to name a few. By preprocessing features with PCA before feeding them into
  some other algorithm (possibly a classifier like a support vector machine
  (SVM) or a statistical model like a hidden Markov model (HMM)) one can
  allow the more powerful algorithm to focus on the ``important'' parts of
  the data and thus do a better job than it would have on the unprocessed
  data.\ 

  The PCA basis looks similar to the cosine basis: <with|color|blue|the first
  elements of each are basically the same; the next two elements of the PCA
  look like a rearrangement of the two elements on the second diagonal of the
  cosine basis (possibly rotated); the next three elements of the PCA look
  like a rearrangement of the 3 elements on the 3rd diagonal of the cosine
  basis; after this it becomes slightly harder, visually, to match up parts
  of the two bases.> But both go from representing coarse detail to
  representing fine detail. Both are <em|<with|color|blue|<with|color|red|orthonormal>>>,
  meaning that each basis vector (<math|16\<times\>16> image chunk) from one
  of the two bases has a dot product of 0 with every other basis vector in
  its basis.

  <subsection|<with|color|magenta|Random Walk>>

  <\eqnarray*>
    <tformat|<table|<row|<cell|p>|<cell|=>|<cell|<text|is a probability
    distribution on people><htab|5mm><around*|(|<big|sum>p<rsub|i>=1,p<rsub|i>\<geqslant\>0|)>>>|<row|<cell|f<around*|(|i,j|)>>|<cell|=>|<cell|f<around*|(|j,i|)>>>|<row|<cell|<text|<em|fr>><around*|(|j,i|)>>|<cell|=>|<cell|1/k,<htab|5mm><around*|(|<text|for
    each friend <math|j> of <math|i>, >k=<text|sum of the entries in column
    <math|i>>|)>>>>>
  </eqnarray*>

  <em|fr><math|\<cdot\>p> is the probability distribution of starting from a
  person drawn from the distribution <math|p> and taking one random step
  along the friendship graph. <em|fr><math|<rsup|3>\<cdot\>p> will be the
  result of taking three random steps along the friendship graph.

  The 1st eigenvectors will be the distribution that the random walk
  converges to, times a constant.

  For p2.2, we could find the right answer via picking the two p with the
  highest discrepancy (p5-p10), which means, I think, p10 shows us the even
  distribution of reaching person i after 10 walks from person-1 and p5 shows
  us the ``concentration'' of reaching people in the group 1 where peron-1
  is.

  And for part 4, maybe some discussion about how random walks reveal
  interesting things about the structure of a graph that would be hard to see
  otherwise; and further, that <em|<with|color|blue|eigenvectors>> reveal
  delicate information about random walks that just may be hard to figure out
  from random walks themselves (exactly the connection between random walks
  and <em|eigenvectors> is beyond the scope of this course).

  <subsection|<with|color|magenta|Parallel Programming>>

  <em|<item>Suppose we used only 1 multiprocessor and only 1 thread. How long
  would it take to read in (and use) 128 bytes from global memory? How long
  would it take if we used 1 warp instead?>

  Using one multiprocessor with one thread means each 4-byte memory request
  from the thread results in a separate memory transfer. Thus 128/4 = 32
  memory transfers are required to read 128 bytes, using
  <math|32\<times\>200=6400ns> total time. If instead we use one warp of
  threads, all 32 threads can access different contiguous elements in
  parallel, necessitating only a single access for a total of 200ns.

  <em|<item>If a block contains 32 warps, how much memory in registers can
  each thread use? How much shared memory can we dedicate to each thread?>

  Both of these resources are split evenly amongst the <math|32=2<rsup|5>>
  threads of each of the 32 warps. So each thread gets
  <math|2<rsup|16>/2<rsup|10>=64> registers and
  <math|32K/2<rsup|10>=2<rsup|15>/2<rsup|10>=32> bytes of shared memory.

  <item>(a) How long would it take for 1 warp to access 32 4-byte elements
  from the same bank of shared memory? If all elements are in the same bank
  they must be accessed in <with|color|blue|serial> in 32 access cycles at
  1ns for a total of 32ns. (b) How long would it take to access 32 4-byte
  elements if each element is in a different bank? If all elements are in
  different banks they can be accessed in parallel in a single access cycle
  for a total of 1ns.
</body>

<\initial>
  <\collection>
    <associate|page-type|letter>
  </collection>
</initial>

<\references>
  <\collection>
    <associate|auto-1|<tuple|1|?>>
    <associate|auto-10|<tuple|1.9|?>>
    <associate|auto-11|<tuple|1.10|?>>
    <associate|auto-2|<tuple|1.1|?>>
    <associate|auto-3|<tuple|1.2|?>>
    <associate|auto-4|<tuple|1.3|?>>
    <associate|auto-5|<tuple|1.4|?>>
    <associate|auto-6|<tuple|1.5|?>>
    <associate|auto-7|<tuple|1.6|?>>
    <associate|auto-8|<tuple|1.7|?>>
    <associate|auto-9|<tuple|1.8|?>>
  </collection>
</references>

<\auxiliary>
  <\collection>
    <\associate|toc>
      <vspace*|1fn><with|font-series|<quote|bold>|math-font-series|<quote|bold>|Dynamic
      Programming> <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-1><vspace|0.5fn>
    </associate>
  </collection>
</auxiliary>