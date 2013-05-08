<TeXmacs|1.0.7.19>

<style|generic>

<\body>
  <doc-data|<doc-title|Dynamic Programming>>

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
</body>

<\initial>
  <\collection>
    <associate|page-type|letter>
  </collection>
</initial>