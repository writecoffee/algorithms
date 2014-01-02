<TeXmacs|1.0.7.19>

<style|generic>

<\body>
  <doc-data|<doc-title|Image Denoising>>

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
</body>

<\initial>
  <\collection>
    <associate|page-type|letter>
  </collection>
</initial>

<\references>
  <\collection>
    <associate|auto-1|<tuple|1|?>>
  </collection>
</references>