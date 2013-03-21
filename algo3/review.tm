<TeXmacs|1.0.7.18>

<style|generic>

<\body>
  <section|FFT & rFFT>

  <\itemize-dot>
    <item>Linear Combination

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

    <item>Cosine Basis

    <math|a b=<around*|[|cos<around*|(|<around*|(|.5:100|)>/<with|color|red|100>\<star\>pi\<star\>3|)>;cos<around*|(|<around*|(|.5:100|)>/<with|color|red|100>\<star\>pi\<star\>4|)>|]>>

    <math|c=<around*|[|3,-5|]>\<star\>a b>

    <math|<around*|(|c\<cdot\>a b<rprime|'>|)>./diag<around*|(|a b\<cdot\>a
    b<rprime|'>|)><rprime|'>> recovers the coefficients exactly.
    <with|color|red|Why? Because cosine fucntions are orthogonal to each
    other>: the matrix <math|a b\<cdot\>a b<rprime|'>> only has entries on
    its diagonal; vector <math|x>, <math|y> are orthogonal if their dot
    product is 0, thus <math|sum<around*|(|a.\<star\>b|)>\<approx\>0>, the
    frequency number has to be between <with|color|red|0> and
    <with|color|red|99>.

    <item>Cosine Transform of an Image

    <\itemize-minus>
      <item><with|font-shape|italic|inverse cosine transform>: is the process
      of expressing a signal interms of cosines for our vector <math|c> we
      computed as <math|<around*|(|c\<star\>M<rprime|'>|)>./diag<around*|(|M\<star\>M<rprime|'>|)>>,\ 

      <item><with|font-shape|italic|cosine transform>: is the process of
      taking coefficients and computing the corresponding linear combination
      of cosines, which we computed by just multiplying by <math|M>.
    </itemize-minus>

    <item>Fourier Transforms

    <\enumerate-roman>
      <item>Pseudocode for FFT

      <with|font-shape|italic|Input>: <math|<around*|(|a<rsub|0>,a<rsub|1>,\<ldots\>,a<rsub|n-1>|)>>
      coefficients of a polynomial <math|f> of degree <math|\<less\>n>,
      <math|n=2p=2<rsup|k>> (power of 2, assume n' is pad to
      <math|n=2<rsup|k>>)

      let <math|<choice|<tformat|<table|<row|<cell|f<rsup|<around*|(|0|)>> be
      the polynomial with coefficients <around*|(|a<rsub|0>,a<rsub|2>,a<rsub|4>,\<ldots\>|)>>>|<row|<cell|f<rsup|<around*|(|1|)>>
      be the polynomial with coefficients
      <around*|(|a<rsub|1>,a<rsub|3>,a<rsub|5>,\<ldots\>|)>>>>>>>

      <math|<choice|<tformat|<table|<row|<cell|recursively find
      <around*|{|f<rsup|<around*|(|0|)>><around*|(|y|)>: y is p<rsup|th>
      complex root of 1|}>>>|<row|<cell|recursively find
      <around*|{|f<rsup|<around*|(|1|)>><around*|(|y|)>:y is p<rsup|th>
      complex root of 1|}>>>>>>>

      for each <math|j>, let <math|x<rsub|j>=e<rsup|2\<pi\>i j/n>>,
      <math|y\<leftarrow\>x<rsub|j><rsup|2>>,
      <math|y=<choice|<tformat|<table|<row|<cell|e<rsup|2\<pi\>i j
      /P>\<nocomma\>,<htab|5mm>if j\<leqslant\>P-1>>|<row|<cell|e<rsup|2\<pi\>i
      <around*|(|j-P|)>/P>,<htab|5mm>if j\<geqslant\>P>>>>>>

      <math|f<around*|(|x<rsub|j>|)>\<leftarrow\>f<rsup|<around*|(|0|)>><around*|(|y|)>+x<rsub|j>f<rsup|<around*|(|1|)>><around*|(|y|)>>

      <with|font-shape|italic|Output>: <math|<around*|{|f<around*|(|x<rsub|j>|)>:
      0\<leqslant\>j\<leqslant\>n-1|}>>

      <item>Theorem

      This is an <math|O<around*|(|n log n|)>> algorithm.

      <item>Matrix

      <math|<matrix|<tformat|<table|<row|<cell|y<rsub|0>>>|<row|<cell|y<rsub|1>>>|<row|<cell|\<ldots\>>>|<row|<cell|\<ldots\>>>|<row|<cell|y<rsub|j>>>|<row|<cell|\<ldots\>>>|<row|<cell|y<rsub|n-1>>>>>>=<matrix|<tformat|<table|<row|<cell|<tabular|<tformat|<cwith|1|1|1|1|cell-hyphen|t>|<table|<row|<cell|1>>>>>>|<cell|x<rsub|0>>|<cell|x<rsub|0><rsup|2>>|<cell|\<ldots\>>|<cell|x<rsub|0><rsup|k>>|<cell|\<ldots\>>|<cell|x<rsub|0><rsup|n-1>>>|<row|<cell|1>|<cell|x<rsub|1>>|<cell|x<rsub|1><rsup|2>>|<cell|\<ldots\>>|<cell|\<ldots\>>|<cell|\<ldots\>>|<cell|x<rsub|1><rsup|n-1>>>|<row|<cell|\<ldots\>>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|>>|<row|<cell|\<ldots\>>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|>>|<row|<cell|1>|<cell|x<rsub|j>>|<cell|x<rsub|j><rsup|2>>|<cell|\<ldots\>>|<cell|e<rsup|2\<pi\>i<around*|(|j
      k|)>/n>>|<cell|\<ldots\>>|<cell|x<rsub|j><rsup|n-1>>>|<row|<cell|\<ldots\>>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|>>|<row|<cell|1>|<cell|x<rsub|n-1>>|<cell|x<rsub|n-1><rsup|2>>|<cell|\<ldots\>>|<cell|>|<cell|\<ldots\>>|<cell|x<rsup|n-1><rsub|n-1>>>>>><matrix|<tformat|<table|<row|<cell|a<rsub|0>>>|<row|<cell|a<rsub|1>>>|<row|<cell|\<ldots\>>>|<row|<cell|\<ldots\>>>|<row|<cell|a<rsub|j>>>|<row|<cell|\<ldots\>>>|<row|<cell|a<rsub|n-1>>>>>>>
    </enumerate-roman>

    <item>Inverse FFT

    <\enumerate-roman>
      <item>Given: the images of the <math|n<rsup|th>> roots of 1 by an
      unknown polynomial of degree <math|\<leqslant\>n-1>

      <item>Output: the coefficients of the polynomial

      <item>Call it <math|p<around*|(|x|)>>, the unknown coefficients:
      <math|a<rsub|0>,a<rsub|1>,\<ldots\>,a<rsub|n-1>>,
      <math|p<around*|(|x|)>=a<rsub|0>+a<rsub|1>x+\<ldots\>+a<rsub|n-1>x<rsup|n-1>>

      <item>Call the <math|n<rsup|th>> roots of unity:
      <math|x<rsub|0>,x<rsub|1>,\<ldots\>,x<rsub|n-1>>,
      <math|x<rsub|j>=e<rsup|2\<pi\>i j/n>>

      <item>Call their images: <math|y<rsub|0>,y<rsub|1>,\<ldots\>,y<rsub|n-1>>

      <item>We want <math|a<rsub|0>,a<rsub|1>,\<ldots\>,a<rsub|n-1>>, this is
      a linear system of equation

      <item>We just need to invert the above matrix, let
      <math|z=e<rsup|2\<pi\>i / n>>

      <math|M=<matrix|<tformat|<table|<row|<cell|1>|<cell|z<rsup|0>>|<cell|z<rsup|0>>|<cell|\<ldots\>>|<cell|z<rsup|0<around*|(|k|)>>>|<cell|\<ldots\>>|<cell|z<rsup|0<around*|(|n-1|)>>>>|<row|<cell|\<ldots\>>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|>>|<row|<cell|1>|<cell|z<rsup|j>>|<cell|z<rsup|2j>>|<cell|\<ldots\>>|<cell|z<rsup|j
      k>>|<cell|\<ldots\>>|<cell|z<rsup|j<around*|(|n-1|)>>>>|<row|<cell|\<ldots\>>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|>>|<row|<cell|1>|<cell|z<rsup|n-1>>|<cell|z<rsup|2<around*|(|n-1|)>>>|<cell|\<ldots\>>|<cell|\<ldots\>>|<cell|\<ldots\>>|<cell|z<rsup|<around*|(|n-1|)><rsup|2>>>>>>>>

      the Van der Mondes matrix has a non-zero determinant, inverse matrix
      is:

      <math|M<rsup|-1>=<matrix|<tformat|<table|<row|<cell|1>|<cell|1>|<cell|1>|<cell|\<ldots\>>|<cell|1>|<cell|\<ldots\>>|<cell|1>>|<row|<cell|1>|<cell|z<rsup|-1>>|<cell|z<rsup|-2>>|<cell|\<ldots\>>|<cell|>|<cell|>|<cell|>>|<row|<cell|1>|<cell|z<rsup|-2>>|<cell|z<rsup|-4>>|<cell|\<ldots\>>|<cell|>|<cell|>|<cell|>>|<row|<cell|1>|<cell|\<ldots\>>|<cell|\<ldots\>>|<cell|z<rsup|-j
      k>>|<cell|>|<cell|>|<cell|>>|<row|<cell|\<ldots\>>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|>>|<row|<cell|1>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|>>>>>\<cdot\><frac|1|n>>

      <item><math|<around*|(|a<rsub|j>|)>=M<rsup|-1><around*|(|y<rsub|j>|)>>
    </enumerate-roman>

    <item>Relation between FFT and Convolution

    <math|p<around*|(|x|)>=<big|sum><rsup|n-1><rsub|j=0>a<rsub|j>x<rsup|j>>,
    <math|q<around*|(|x|)>=<big|sum><rsup|n-1><rsub|i=0>b<rsub|i>x<rsup|i>\<nocomma\>>,
    <math|C<rsub|k>=<big|sum><rsub|j+i=k>a<rsub|j>b<rsub|i>>.

    <math|<around*|(|a<rsub|0>+a<rsub|1>x|)><around*|(|b<rsub|0>+b<rsub|1>x|)>=<below|<wide*|a<rsub|0>b<rsub|0>|\<wide-underbrace\>>|C<rsub|0>>+<below|<wide*|<around*|(|a<rsub|0>b<rsub|1>+a<rsub|1>b<rsub|0>|)>|\<wide-underbrace\>>|C<rsub|1>>x+<below|<wide*|a<rsub|1>b<rsub|1>x<rsup|2>|\<wide-underbrace\>>|C<rsub|2>>>

    <math|a<rsup|T>=<around*|(|a<rsub|0>,\<ldots\>,a<rsub|n-1>|)>>,
    <math|b<rsup|T>=<around*|(|b<rsub|0>,\<ldots\>,b<rsub|n-1>|)>>,
    <math|a\<otimes\>b=C<rsub|2n>=DFT<rsub|2n><rsup|-1><around*|(|DFT<rsub|2n><around*|(|a|)>\<cdot\>DFT<rsub|2n><around*|(|b|)>|)>>

    <item>To multiply <math|A<around*|(|x|)>=a<rsub|0>+a<rsub|1>x+\<ldots\>+a<rsub|n-1>x<rsup|n-1>>
    by <math|B<around*|(|x|)>=b<rsub|0>+b<rsub|1>x+\<ldots\>+b<rsub|n-1>x<rsup|n-1>>:

    <\enumerate-alpha>
      <item>find <math|<around*|(|x<rsub|i>,A<around*|(|x<rsub|i>|)>|)>> and
      <math|<around*|(|x<rsub|i>,B<around*|(|x<rsub|i>|)>|)>> for <math|2n-1>
      different values of <math|x<rsub|i>>

      <htab|5mm><math|O<around*|(|n log n|)>> with
      <with|font-shape|italic|FFT>

      <item>for all <math|i> compute <math|p<around*|(|x<rsub|i>|)>\<cdot\>q<around*|(|x<rsub|i>|)>><htab|5mm><math|O<around*|(|n|)>>

      <item><math|p q<around*|(|x|)>> is the polynomial with points
      <math|<around*|(|x<rsub|i>,p<around*|(|x<rsub|i>|)>\<cdot\>q<around*|(|x<rsub|i>|)>|)>>
      of <with|font-shape|italic|deg><math|\<leqslant\>2n-2>

      <htab|5mm><math|O<around*|(|n log n|)>> with
      <with|font-shape|italic|iFFT>
    </enumerate-alpha>

    <item>Application: Big-Multiplication

    <\render-code>
      BIG-MULT(<math|a,b>)

      <tabular|<tformat|<table|<row|<cell|1>|<cell|na=length(a);
      nb=length(b);>>|<row|<cell|2>|<cell|a=[a zeros(1, nb-1)]; b=[b zeros(1,
      na-1)];>>|<row|<cell|3>|<cell|c=ifft(fft(a).*fft(b));>>|<row|<cell|4>|<cell|<math|\<ldots\>>>>>>>
    </render-code>
  </itemize-dot>

  <section|Dynamic Programming>

  <\itemize-dot>
    <item><em|Number of paths in a graph>: If we multiply by <math|M>
    repeatedly, this corresponds to longer paths: the <math|l>th entry of the
    vector <math|e<rsub|i>\<cdot\>M<rsup|k>> records the number of paths of
    length <math|k> in <math|G> going from <math|i> to <math|l>.
    <em|Recursive representation of paths in a graph>:\ 

    <tabular|<tformat|<table|<row|<cell|PATHS(<math|i,k,l>):>>|<row|<cell|<htab|5mm>return:
    <math|<big|sum><rsub|j>><math|PATHS<around*|(|i,k-1,j|)>\<cdot\>M<around*|(|j,l|)>>>>>>>

    <em|Minimum cost paths in a graph>:\ 

    <tabular|<tformat|<table|<row|<cell|PATHS(<math|i,k,l>):>>|<row|<cell|<htab|5mm>return:
    <math|min<rsub|j>><math|PATHS<around*|(|i,k-1,j|)>+M<around*|(|j,l|)>>>>>>>

    <item>Egg Dropping Problem

    Let <math|f<around*|(|t,n|)>> be the most floors given <math|t> trials,
    <math|n> eggs (i.e. at most <math|t> depth, at most <math|n> left moves,
    <math|f<around*|(|t,n|)>=> most number of nodes to add to tree).
    <math|f<around*|(|t,n|)>=1+f<around*|(|t-1,n-1|)>+f<around*|(|t-1,n|)>>

    <item>Edit Distance

    The recurrence for editDistance from the problem statement is:

    <\equation*>
      S<around*|(|i,j|)>=<choice|<tformat|<table|<row|<cell|S<around*|(|i-1,j-1|)>>|<cell|<htab|5mm>if
      A<around*|[|i|]>=B<around*|[|j|]>>>|<row|<cell|min<around*|(|S<around*|(|i-1,j|)>,S<around*|(|i,j-1|)>,S<around*|(|i-1,j-1|)>|)>+1>|<cell|<htab|5mm>if
      A<around*|[|i|]>\<neq\>B<around*|[|j|]>>>>>>
    </equation*>

    <with|color|blue|Recall the <with|font-shape|italic|meaning> of
    <math|S<around*|(|i,j|)>>>: it is the edit distance between the first
    <math|i> characters of the first string <math|A> and the first <math|j>
    characters of the second string <math|B>. <with|color|blue|Thus we want
    to compute> <math|S<around*|(|A.length\<nocomma\>,B.length|)>>, which we
    do via dynamic programming, filling in all entries
    <math|S<around*|(|i,j|)>> for <math|i> between 0 and <math|A.length> and
    <math|j> between 0 and <math|B.length>, leading to a 2-dimensional array
    with dimensions <math|<around*|(|A.length+1|)>\<times\><around*|(|B.length+1|)>>

    <with|color|blue|The base cases for our algortihm encode the fact that>
    the edit distance between the empty string and a string of length
    <math|i> (or <math|j>) is <math|i> (or <math|j> respectively):

    <\eqnarray*>
      <tformat|<table|<row|<cell|S<around*|(|i,0|)>>|<cell|=>|i\<nocomma\>,<htab|5mm>
      \<forall\>i\<nocomma\>,0 \<leqslant\>i\<leqslant\>A.length>|<row|<cell|S<around*|(|0,j|)>>|<cell|=>|<cell|j,<htab|5mm>
      \<forall\>j, 0\<leqslant\>j\<leqslant\>B.length>>>>
    </eqnarray*>

    <item>Bellman-Ford Algorithm

    <\render-code>
      BELLMAN-FORD()

      <tabular|<tformat|<table|<row|<cell|1>|<cell|<math|A\<leftarrow\>>2D
      array (indexed by <math|i> and <math|v>)>>|<row|<cell|2>|<cell|<math|A<around*|[|0,s|]>=0>>>|<row|<cell|3>|<cell|<math|A<around*|[|0,v|]>=+\<infty\>
      ,\<forall\>v,v\<neq\>s> >>|<row|<cell|4>|<cell|<strong|for>
      <math|i\<leftarrow\>1> <strong|to> <math|n-1>:>>|<row|<cell|5>|<cell|<htab|5mm><strong|for>
      each <math|v\<in\>V> <strong|do>:>>|<row|<cell|6>|<cell|<htab|5mm><htab|5mm><with|font-base-size|10|<math|A<around*|[|i,v|]>=min<around*|(|A<around*|[|i-1,v|]>,min<around*|(|A<around*|[|i-1,w|]>+c<rsub|w
      v>,\<forall\><around*|(|w,v|)>\<nocomma\>,<around*|(|w,v|)>\<in\>E|)>|)>>>>>>>>
    </render-code>

    <item>Knapsack Problem

    <\render-code>
      KNAPSACK(<math|W>)

      <tabular|<tformat|<table|<row|<cell|1>|<cell|<math|A\<leftarrow\>>2D
      array (indexed by <math|i> and <math|v>)>>|<row|<cell|2>|<cell|initialize
      <math|A<around*|[|0,x|]>=0,\<forall\>x,x\<in\><around*|{|0,1,2,\<ldots\>,W|}>>>>|<row|<cell|3>|<cell|<strong|for>
      <math|i=1,2,\<ldots\>,n>:>>|<row|<cell|4>|<cell|<htab|5mm><strong|for>
      <math|x=0,1,2,\<ldots\>,W>:>>|<row|<cell|5>|<cell|<htab|5mm><htab|5mm><math|A<around*|[|i,x|]>\<leftarrow\>max<around*|{|A<around*|[|i-1,x|]>,A<around*|[|i-1,x-w<rsub|i>|]>+v<rsub|i>|}>><htab|5mm><with|font-base-size|10|/*<math|x-w<rsub|i>\<geqslant\>0>
      */>>>|<row|<cell|6>|<cell|<strong|return> <math|A<around*|[|n,w|]>>
      >>>>>
    </render-code>

    <item>Optimal Binary Search Tree

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

    <item>Longest Palindromic Subsequences

    We describe a dynamic programming approach for coy mputing the length of
    the longest palindromic subsequence in a string of characters.
    <with|color|blue|We will define a recurrence in terms of
    <math|T<around*|(|i,j|)>>, representing the
    <with|font-shape|italic|length of the longest palindromic subsequence
    consisting of characters from i to j inclusive>>. We now derive a
    recurrence relation for <math|T>.

    There are two cases to the recurrence. Either the first and last
    character of the substring from <math|i> to <math|j> match, or they do
    not:\ 

    <\enumerate-roman>
      <item>If they match, then the length of the longest palindromic
      subsequence from <math|i> to <math|j> must be two more than the length
      of the longest palindromic subsequence from <math|i+1> to <math|j-1>.

      <item>If they do not match, then no palindromic subsequence can both
      start with the <math|i>th character and end with the <math|j>th
      character, so the longest palindromic subsequence between <math|i> and
      <math|j> must be <with|font-shape|italic|either> the longest
      palindromic subsequence between <math|i> and <math|j-1>, or the longest
      palindromic subsequence between <math|i+1> and <math|j>.
    </enumerate-roman>

    Written explicitly, the recurrence is:

    <\equation*>
      T<around*|(|i,j|)>=<choice|<tformat|<table|<row|<cell|T<around*|(|i+1,j-1|)>+2>|<cell|<htab|5mm>if
      s<around*|[|i|]>=s<around*|[|j|]>>>|<row|<cell|max<around*|(|T<around*|(|i+1,j|)>,T<around*|(|i,j-1|)>|)>>|<cell|<htab|5mm>if
      s<around*|[|i|]>\<neq\>s<around*|[|j|]>>>>>>
    </equation*>

    Since the recurrence only makes use of entries with greater first index,
    or smaller second index, we can fill in the table with two nested loops,
    where one loop decreases the first index and the other loop increases the
    second index.

    It is fairly clear that the following two base cases are enough to define
    the rest of the values in <math|T>:

    <\itemize-dot>
      <item>String of length 1: for all <math|i> between 0 and <math|n-1>,
      let <math|T<around*|(|i,j|)>=1>.

      <item>String of length 0: for all <math|i> between 1 and <math|n-1>,
      let <math|T<around*|(|i,i-1|)>=0>.
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
    recurrence for <math|T<around*|(|i,j|)>>> correctly expresses the length
    of the longest palindromic subsequence between location <math|i> and
    <math|j> <with|color|blue|in terms of values that have already been
    computed>. <math|<rsup|<around*|(|2|)>>>And finally, <with|color|blue|the
    base cases>, strings of length 0 and 1, clearly have longest palindromic
    subsequences of lengths 0 and 1 respectively.
    <math|<rsup|<around*|(|3|)>>><with|color|blue|Therefore, induction on the
    number of times line 9 in the pseudocode is executed yields a proof of
    correctness of the values of the table <math|T>>, and in particular,
    <with|color|blue|guarantees> that the answer <math|T<around*|(|0,n-1|)>>
    returns the length of the longest palindromic subsequence of the entire
    string.

    <strong|<with|font-shape|italic|Running Time Analysis>>

    We fill half of a table that contains <math|O<around*|(|n<rsup|2>|)>>
    elements. In filling each element, we do constant work. Thus, the runtime
    of our algorithm is <math|O<around*|(|n<rsup|2>|)>>.

    <item><em|<strong|Maximum Sum>> of a Triangle

    Let <math|T> be a triangle of numbers with <math|r> rows, where
    <math|T<around*|[|i,j|]>> is the number in the <math|i>th row of T that
    is <math|j> from the left, starting from 1 (e.g.,
    <math|T<around*|[|3,2|]>> in the example triangle is <math|>4). We define
    an algorithm defined by the following recurrence relation:

    <\equation*>
      S<around*|[|i,j|]>=<choice|<tformat|<table|<row|<cell|T<around*|[|i,j|]>>|<cell|<htab|5mm>if
      i=r>>|<row|<cell|T<around*|[|i,j|]>+max<around*|(|T<around*|[|i+1,j|]>,T<around*|[|i+1,j+1|]>|)>>|<cell|<htab|5mm>if
      i\<less\>r>>>>>
    </equation*>

    where <math|1\<leqslant\>i\<leqslant\>r,1\<leqslant\>j\<leqslant\>i> and
    <math|S<around*|[|i,j|]>> is the maximum sum from row <math|r> of
    <math|T> to <math|T<around*|[|i,j|]>>.

    <math|S<around*|[|i,j|]>> is an <math|r\<times\>r> table. We will fill
    only the bottom half of the table (we only need <math|i\<geqslant\>j>),
    <with|color|blue|starting at the bottom row and working across rows to
    the top>. The maximum sum in <math|T> will be stored at
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
      If we have a triangle with only one row, then it can only have one
      entry, and it is clear that the maximum sum in the tree is exactly the
      value of that entry.

      <item>General Case: We want to show that the algorithm returns the
      correct answer when <math|r=k+1>. Starting from the top of the triangle
      , the path followed to obtain the maximum sum must pass through one of
      the numbers in the second row of <math|T>. Both of these taken
      individually are the top row of triangles with <math|k> rows , so we
      know from the induction hypothesis that <math|S<around*|[|2,j|]>>
      stores the maximum sum from the base of <math|T> to the numbers in the
      second row. Since the path to the top row is obtained by adding this
      sum to the value stored in the first row of <math|T>, it is clear that
      the maximum sum for <math|T> will be obtained by adding
      <math|T<around*|[|1,1|]>> to the maximum of the sums stored in the
      second row of <math|T>, <with|color|blue|which is exactly what is
      calculated by the recurrence relation>. Therefore, our algorithm is
      correct for <math|r=k+1> and therefore for all <math|r>.
    </itemize-minus>

    <strong|<with|font-shape|italic|Running Time>>

    During the execution of this algorithm, we consider each number a
    constant number of times. Therefore, the algorithm runs in
    <math|O<around*|(|n|)>> where <math|n> is the number of elements in the
    triangle.

    <item><em|<strong|MinCost>> of Cutting Wood

    Input: a sequence of cuts <math|A=<around*|{|a<rsub|1>,a<rsub|2>,\<ldots\>,a<rsub|n>|}>>,
    where <math|a<rsub|i>> is the distance from the left edge of the piece of
    wood, and <math|L>, the length of the piece of wood.

    For the recurrence relation, redefine
    <math|A=<around*|{|a<rsub|1>,a<rsub|2>,\<ldots\>,a<rsub|n>,a<rsub|n+1>|}>=<around*|{|a<rsub|1>,a<rsub|2>,\<ldots\>,a<rsub|n>,L|}>>
    such that in the recurrence relation, <math|a<rsub|n+1>=L>. The
    recurrence relation for this problem can be described as

    <\equation*>
      C<around*|[|i,j|]>=<choice|<tformat|<table|<row|<cell|0>|<cell|<htab|5mm>if
      i=j or i=j-1>>|<row|<cell|a<rsub|j>-a<rsub|i>+min<rsub|i\<less\>k\<less\>j><around*|(|C<around*|[|i,j|]>+C<around*|[|k,j|]>|)>>|<cell|<htab|5mm>if
      i\<neq\>j and i\<neq\>j-1>>>>>
    </equation*>

    where <math|C<around*|[|i,j|]>> is the minimum cost of cutting the wood
    between cuts <math|a<rsub|i>> and <math|a<rsub|j>> and
    <math|i\<leftarrow\>0> to <math|n> and <math|j\<leftarrow\>1> to
    <math|n+1>.

    <math|C<around*|[|i,j|]>> is a table in which only the upper half is
    filled (we only need <math|i\<leqslant\>j> since we are looking at the
    cost of cuttin between positions <math|a<rsub|i>> and <math|a<rsub|j>>,
    so all other entries would be redundant.) Each entry
    <math|C<around*|[|i,j|]>> holds the minimum cost of cutting the wood
    between positions <math|a<rsub|i>> and <math|a<rsub|j>>,
    <with|color|blue|and the table is filled diagonally, from the center
    diagonal to the upper-right corner>.

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
    cutting between positions <math|a<rsub|i>> and <math|a<rsub|j>>, since
    the algorithm follows the recurrence relation defined above.

    <\itemize-minus>
      <item>Base Case: First, the base cases are true. In the base case where
      <math|i=j>, it is obvious that there is no cut betwen a position and
      itself. In the base case where <math|i=j-1>, there are no cuts between
      positions <math|a<rsub|i>> and <math|a<rsub|j>>, hence the cost is
      again 0.

      <item>Now take all other cases in which there is at least one cut
      between positions <math|a<rsub|i>> and <math|a<rsub|j>>. Suppose the
      minimum cost <math|C<around*|[|i,j|]>> for making all cuts between
      <math|a<rsub|i>> and <math|a<rsub|j>> is obtained by making the next
      cut at some position <math|a<rsub|k><rprime|'>>,
      <math|i\<less\>k<rprime|'>\<less\>j>. Then<with|color|blue|
      <math|C<around*|[|i,j|]>=a<rsub|j>-a<rsub|i>+C<around*|[|i,k<rprime|'>|]>+C<around*|[|k<rprime|'>,j|]>>>.
      Because <math|a<rsub|j>-a<rsub|i>> is constant for any given <math|i,j>
      (the length of a piece of wood does not change regardless of how it
      will be cut), <math|C<around*|[|i,k<rprime|'>|]>+C<around*|[|k<rprime|'>,j|]>>
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
  </itemize-dot>

  <section|Divide & Conquer>

  <\itemize-dot>
    <item><em|<strong|Medium-Find>>

    <em|Runtime:> depends on how ``lucky'' we are <math|\<rightarrow\>>
    ``unlucky'' if <math|x> is always the largest or smallest elem of
    <math|L> (e.g., <math|L> is sorted). It would be
    <math|O<around*|(|n<rsup|2>|)>>. <math|<rsup|<around*|(|1|)>>>So instead
    of choosing <math|x> to be the first element, let it be a random element.
    <math|<rsup|<around*|(|2|)>>>Assume fixed input, prove it run in
    <math|O<around*|(|n|)>> time. <em|Claim>: runtime depends only on the
    size of <math|L>. Let <math|T<around*|(|n|)>> b the time the algo takes
    on average, suppose that <math|<around*|\||L<rsub|1>|\|>=5,<around*|\||L<rsub|2>|\|>=n-5-1>.
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
    The probability of this happening is <math|1/2>, since the distribution
    of <math|R<around*|(|x|)>> is uniform <math|\<Rightarrow\>> Takes a
    constant number of ``coin flips'' (choices of random numer) to get to
    this case <math|\<Rightarrow\>> takes time <math|O<around*|(|n|)>>
    [expected to take this amount of time].

    <item><em|<strong|Select a pivot deterministically>>

    <math|<around*|(|1|)>> divide the list into groups of 5 elements;
    <math|<around*|(|2|)>> for each group, find its mediam
    <math|\<rightarrow\>O<around*|(|1|)>> for each
    <math|\<Rightarrow\>O<around*|(|n|)>> total; <math|<around*|(|3|)>> find
    the median of these <math|n/5> elements recursively and use it as your
    pivot.\ 

    <em|Why does this guarantee a good pivot?> If there are <math|n> elements
    total, then the pivot is greater than at least <math|3n/10> elements, and
    less than at least <math|3n/10> elements <math|\<Rightarrow\>>
    <math|3n/10\<leqslant\>R<around*|(|pivot|)>\<leqslant\>7n/10\<Rightarrow\>T<around*|(|n|)>\<leqslant\>T<around*|(|7n/10|)>+T<around*|(|n/5|)>+n>,
    base case 1.

    <item><strong|<em|FindMax>> value increasing from the left, descending to
    the right

    Given a location <math|i> in the 1-indexed array <math|A> of length
    <math|n>, we can clearly tell if <math|i> is to the left of the max, to
    the right of the max, or is the max, via the following three-way test:

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
    algorithm, which will thus solve the problem in <math|O(log n)> time
    (since each test can be done in constant time).

    <item><em|<strong|BigWin>> <math|O<around*|(|n log n|)>> Solution

    <em|<strong|Heuristic>>: Starting at the center element, <math|c>, we
    find the maximum sum, <math|L>, of consecutive elements to the left of
    <math|c> that includes <math|c>. Similarly, we find the maximum sum,
    <math|R>, of consecutive elements to the right of <math|c> that includes
    <math|c>. Then, <em|BigMiddleWin> should return <math|L+R-c>.

    <em|<strong|Algorithm>>: Consider the center element, <math|c>, in the
    list. Either the maximum sum is completely contained in the elements to
    the left of <math|c>, completely contained in the elements to the right
    of c, or passes through <math|c>. We have already seen how to solve the
    last case with <em|BigMiddleWin>. We can then consider an algorithm,
    <em|BigWin>, which takes as input a list, <math|l>. It returns the max of
    <em|BigMiddleWin> of <math|l>, <em|BigWin> of the left half of <math|l>,
    and <em|BigWin> of the right half of <math|l>.

    <em|<strong|Correctness>>: We can assume that <em|BigMiddleWin> will
    return the correct maximum of a given list. Any contiguous subsequence
    from a list <math|l> either contains the middle element or it doesn't. In
    the case that it does, the maximum of all such paths will be returned by
    <em|BigMiddleWin>. Since the sequence is contiguous, if it does not
    contain the middle element then all elements must fall in the left half,
    or they must fall in the right half. These can both be treated as
    independent lists (since they share no elements), and <with|color|blue|so
    we can solve them independently>. <em|<with|color|blue|Thus, the maximum
    total sum will be the max of the sum that considers only the left half,
    the sum that considers only the right half, and the sum that considers
    the whole list together>>.

    <em|<strong|Runtime>>: The algorithm leads to a recurrence of the form
    <math|T(n) = 2T(n/2)+O(n)>. We have solved this recurrence before, and
    know it is <math|O(n log n)>.
  </itemize-dot>

  <section|Greedy Algorithm>

  <\itemize-dot>
    <item><em|<strong|Cloest Hotel>>

    Each morning, Bilbo will choose for his next night the hotel closest to
    his destination that he can reach that day, or his destination if he can
    reach his destination that day.

    We claim, by induction, that for each <math|i\<geqslant\>0>, under this
    strategy at the ith night Bilbo will be as close as possible to his
    destination. If at night <math|i> Bilbo is at location <math|x>, which is
    the greatest possible location he could be along his route for night
    <math|i>, and on the next day he travels to hotel at greatest location
    less than or equal to <math|x + 20>, then clearly at night <math|i + 1>
    he will be as far as possible along his route for night <math|i + 1>,
    proving the induction. Thus Bilbo greedy strategy will get him as far as
    possible each day, leading him to finish his journey in the least number
    of days.

    <item><em|<strong|Attend Events>>

    At the moment each event starts, choose a person from your dorm room to
    go to that event.\ 

    This strategy can only fail if there is no one in your dorm room when an
    event starts, meaning that all your <math|k> friends are already at
    <math|k> events. These <math|k> events and the just-starting event make
    <math|k + 1> events. Since there are <math|k+1> events happening
    simultaneously, there is no way to attend each event with only <math|k>
    people. Thus the only way our strategy fails is if our task is
    impossible, meaning our algorithm will succeed in all possible cases.

    <item><em|<strong|Scheduling Jobs>>

    <strong|Claim>: algorithm (order jobs according to decreasing ratios
    <math|w<rsub|i>/l<rsub|i>>) is always correct.

    <strong|Proof>: by an <em|Exchange Argument>, by Contradiction.
    <strong|Plan>: fix arbitrary input of <math|n> jobs, will proceed by
    contradiction. Let <math|\<sigma\>=> greedy schedule, <math|\<sigma\>>*=
    optimal schedule, will produce schedule even better than
    <math|\<sigma\>>*, contradicting purported optimality of
    <math|\<sigma\>>*.

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
    completion time of>: <math|<rsup|<around*|(|1|)>>k> other than <math|i>
    or <math|j>: before the swap, it has to wait for a bunch of ops to
    complete, including <math|i> and <math|j>, the amount of time elapsed is
    the same, thus jobs other than <math|i> and <math|j> are completely
    agnostic to the swap; <math|k> preceed <math|i> and <math|j> is the same.
    <math|<rsup|<around*|(|2|)>>>job <math|i>: goes up, now it has to wait
    for <math|j>, goes up by the lenght of <math|j>.
    <math|<rsup|<around*|(|3|)>>>job <math|j>: drops, no longer has to wait
    for job <math|i>, goes down precisely the length of job <math|i>.

    <strong|Cost-Benefit Analysis>: <em|Upshot>s:
    <math|i\<gtr\>j\<Rightarrow\><frac|w<rsub|i>|l<rsub|i>>\<less\><frac|w<rsub|j>|l<rsub|j>>\<Rightarrow\>w<rsub|i>l<rsub|j>\<less\>w<rsub|j>l<rsub|i>\<Rightarrow\>cost
    \<less\> benefit\<Rightarrow\>>swap improves <math|\<sigma\>>*,
    contradicts optimality of <math|\<sigma\>>*. <em|QED>!

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
    <strong|Motivation>: <math|\<theta\><around*|(|1|)>> time for cycle
    checks.\ 

    <strong|Find(<math|x>)>: return name of group that <math|x> belongs to.
    <strong|Union(<math|c<rsub|i>,c<rsub|j>>)>: fuse groups <math|c<rsub|i>>
    and <math|c<rsub|j>> into a single one.\ 

    <strong|Idea>: when two componenets merge, have smaller one inherit the
    leader of the larger one; you have to quickly determine which group is
    larger, so you may maintain a size field for each group. <em|How many
    leader pointer updates are now required to restore the invariant in the
    worst case?> <strong|<math|\<theta\><around*|(|log n|)>>>.
    <strong|Reason>: you are joining a group at least as big as yours, so the
    size of the union, the size of your new community, is at least double the
    size of your previous one.
  </itemize-dot>

  <section|Other Data Structure>

  <\itemize-dot>
    <item><em|<strong|Suffix Tree>>

    Stores every ``suffix'' (encoding) of an input

    total #letters <math|=<big|sum><rsub|i=1><rsup|n>i=O<around*|(|n<rsup|2>|)>>
    [whoops!]

    But what about the structure? <math|n> leaves, one for each suffix
    <math|\<rightarrow\>> compactly store by storing index of starting ending
    letter of suffix <math|=O<around*|(|n|)>> storage [yay!]

    <math|\<Rightarrow\>> Actually a mess to store in practice (but that's
    find-more important to think of what we can do with it)

    <\itemize-minus>
      <item><em|Searching for Substrings>: only 1 branch at each step storing
      a given level, so we can search for a substring in linear time.

      <item><em|Longest Common Substring>: <strong|IDEA 1>: ``overlay'' 1
      tree on the other: find the node that has children from both trees & is
      longest. <strong|IDEA 2>: build a suffix tree for <math|<around*|[|word
      1|]>\<times\><around*|[|word 2|]>>, run regular suffix tree algo and
      post-processing.
    </itemize-minus>
  </itemize-dot>

  \;
</body>

<\initial>
  <\collection>
    <associate|font-base-size|12>
    <associate|page-bot|1>
    <associate|page-even|1>
    <associate|page-medium|paper>
    <associate|page-odd|1>
    <associate|page-right|1>
    <associate|page-top|1>
    <associate|page-type|a5>
  </collection>
</initial>

<\references>
  <\collection>
    <associate|auto-1|<tuple|1|1>>
    <associate|auto-2|<tuple|2|3>>
    <associate|auto-3|<tuple|3|9>>
    <associate|auto-4|<tuple|4|11>>
    <associate|auto-5|<tuple|5|?>>
    <associate|auto-6|<tuple|6|?>>
    <associate|auto-7|<tuple|7|?>>
  </collection>
</references>

<\auxiliary>
  <\collection>
    <\associate|toc>
      <vspace*|1fn><with|font-series|<quote|bold>|math-font-series|<quote|bold>|FFT
      & rFFT> <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-1><vspace|0.5fn>

      <vspace*|1fn><with|font-series|<quote|bold>|math-font-series|<quote|bold>|Dynamic
      Programming> <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-2><vspace|0.5fn>

      <vspace*|1fn><with|font-series|<quote|bold>|math-font-series|<quote|bold>|Divide
      & Conquer> <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-3><vspace|0.5fn>

      <vspace*|1fn><with|font-series|<quote|bold>|math-font-series|<quote|bold>|Greedy
      Algorithm> <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-4><vspace|0.5fn>
    </associate>
  </collection>
</auxiliary>