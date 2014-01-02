<TeXmacs|1.0.7.19>

<style|generic>

<\body>
  <doc-data|<doc-title|Fast Fourier Transform>>

  <\itemize-dot>
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
    other>: the matrix <math|a b\<cdot\>a b<rprime|'>> only has entries on
    its diagonal; vector <math|x>, <math|y> are orthogonal if their dot
    product is 0, thus <math|sum<around*|(|a.\<star\>b|)>\<approx\>0>, the
    frequency number has to be between <with|color|red|0> and
    <with|color|red|99>.

    <strong|<item>Cosine Transform of an Image>

    <\itemize-minus>
      <item><with|font-shape|italic|inverse cosine transform>: is the process
      of expressing a signal interms of cosines for our vector <math|c> we
      computed as <math|<around*|(|c\<star\>M<rprime|'>|)>./diag<around*|(|M\<star\>M<rprime|'>|)>>,\ 

      <item><with|font-shape|italic|cosine transform>: is the process of
      taking coefficients and computing the corresponding linear combination
      of cosines, which we computed by just multiplying by <math|M>.
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
        <tformat|<table|<row|<cell|f<rsup|<around*|(|0|)>><around*|(|y|)>: y
        is p<rsup|th> complex root of 1>|<cell|>|<cell|>>|<row|<cell|f<rsup|<around*|(|1|)>><around*|(|y|)>:y
        is p<rsup|th> complex root of 1>|<cell|>|<cell|>>>>
      </eqnarray*>

      for each <math|j>, let <math|x<rsub|j>=e<rsup|2\<pi\>i j/n>>,
      <math|y\<leftarrow\>x<rsub|j><rsup|2>>,\ 

      <\eqnarray*>
        <tformat|<table|<row|<cell|y=<choice|<tformat|<table|<row|<cell|e<rsup|2\<pi\>i
        j /P>\<nocomma\>,<htab|5mm>if j\<leqslant\>P-1>>|<row|<cell|e<rsup|2\<pi\>i
        <around*|(|j-P|)>/P>,<htab|5mm>if
        j\<geqslant\>P>>>>>>|<cell|>|<cell|<htab|5mm>>>>>
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
    different values of <math|x<rsub|i>>;
    <math|<with|color|blue|O<around*|(|n log n|)>>> with
    <with|font-shape|italic|FFT>; (2) for all <math|i> compute
    <math|p<around*|(|x<rsub|i>|)>\<cdot\>q<around*|(|x<rsub|i>|)>>;
    <with|color|blue|<math|O<around*|(|n|)>>>; (3) <math|p q<around*|(|x|)>>
    is the polynomial with points <math|<around*|(|x<rsub|i>,p<around*|(|x<rsub|i>|)>\<cdot\>q<around*|(|x<rsub|i>|)>|)>>
    of <with|font-shape|italic|deg><math|\<leqslant\>2n-2>;
    <math|<with|color|blue|O<around*|(|n log n|)>>> with <em|iFFT>.

    <\render-code>
      <with|font-shape|small-caps|Big-Mult>(<math|a,b>)

      <tabular|<tformat|<table|<row|<cell|1>|<cell|<math|><em|na>=<strong|length>(<math|a>);
      <em|nb>=<strong|length>(<math|b>);>>|<row|<cell|2>|<cell|<math|a=[a
      <text| <strong|zeros>>(1, <text|<em|nb>>-1)]; b=[b <text|<strong|
      zeros>>(1, <text|<em|na>>-1)];>>>|<row|<cell|3>|<cell|<math|c=ifft<around*|(|fft<around*|(|a|)>.\<ast\>fft<around*|(|b|)>|)>>;
      /* inner matrix dimensions must agree */>>|<row|<cell|4>|<cell|/*
      remove redundant zeros */>>>>>
    </render-code>
  </itemize-dot>
</body>

<\initial>
  <\collection>
    <associate|page-type|letter>
  </collection>
</initial>