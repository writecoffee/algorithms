<TeXmacs|1.0.7.4>

<style|generic>

<\body>
  <doc-data|<doc-title|CS157 Homework 3>|<\doc-author-data|<author-name|Silao_Xu>>
    \;
  </doc-author-data>>

  <section|Problem 3>

  2.

  <\code>
    a=ones(1,10);

    b=ones(1,10);

    expect=[1:10, 9:-1:1];
  </code>

  Let <math|a=ones(1,10), b=ones(1,10), expect=[1:10, 9:-1:1]>.

  max(abs(conv(a,b)-expect)) returns 0 and max(abs(myconv(a,b)-expect))
  returns 1.7764e-15. Method fft() and ifft() has floating-point error. For\ 

  5.

  7.

  For a particular space we store intermediate result (the bignumber % 10).
  The number should be less than <math|2<rsup|32>-1>, which is the upper
  bound of Integer range. So intermediate result could be
  <math|9\<times\>9\<times\>n=81n>.\ 

  Let <math|81n\<leqslant\>2<rsup|32>-1>, we could derive the longest length
  to be <math|\<lfloor\><frac|2<rsup|32>-1|81>\<rfloor\>=53024287>.
</body>

<\references>
  <\collection>
    <associate|auto-1|<tuple|1|?>>
  </collection>
</references>

<\auxiliary>
  <\collection>
    <\associate|toc>
      <vspace*|1fn><with|font-series|<quote|bold>|math-font-series|<quote|bold>|Problem
      3> <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-1><vspace|0.5fn>
    </associate>
  </collection>
</auxiliary>