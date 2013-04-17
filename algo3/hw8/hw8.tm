<TeXmacs|1.0.7.18>

<style|generic>

<\body>
  <doc-data|<doc-title|CS157 Homework 8>|<doc-author|<author-data|<author-name|Silao_xu
  and Tc28>>>>

  <\enumerate-numeric>
    <item>The variables we define are as follows:

    <\eqnarray*>
      <tformat|<table|<row|<cell|w<rsub|i>>|<cell|=>|<cell|<text|number of
      workers for month <math|i>>>>|<row|<cell|
      t<rsub|i>>|<cell|=>|<cell|<text|number of experienced workers
      participate in the training for month
      <math|i>>>>|<row|<cell|c<rsub|i>>|<cell|=>|<cell|<text|the cost for
      employing in month <math|i>>>>>>
    </eqnarray*>

    The constraints are as follows:

    <\eqnarray*>
      <tformat|<table|<row|<cell|150\<cdot\><around*|(|w<rsub|<text|<em|May>>>-t<rsub|<text|<em|May>>>|)>+50\<cdot\>t<rsub|<text|<em|May>>>>|<cell|\<geqslant\>>|<cell|8000<htab|5mm><around*|(|1|)>>>|<row|<cell|150\<cdot\><around*|(|w<rsub|<text|<em|Jun>>>-t<rsub|<text|<em|Jun>>><rsub|>|)>+50\<cdot\>t<rsub|<text|<em|Jun>>>>|<cell|\<geqslant\>>|<cell|9000<htab|5mm><around*|(|2|)>>>|<row|<cell|150\<cdot\><around*|(|w<rsub|<text|<em|Jul>>>-t<rsub|<text|<em|Jul>>><rsub|>|)>+50\<cdot\>t<rsub|<text|<em|Jul>>>>|<cell|\<geqslant\>>|<cell|7000<htab|5mm><around*|(|3|)>>>|<row|<cell|150\<cdot\><around*|(|w<rsub|<text|<em|Aug>>>-t<rsub|<text|<em|Aug>>><rsub|>|)>+50\<cdot\>t<rsub|<text|<em|Aug>>>>|<cell|\<geqslant\>>|<cell|10000<htab|5mm><around*|(|4|)>>>|<row|<cell|150\<cdot\><around*|(|w<rsub|<text|<em|Sep>>>-t<rsub|<text|<em|Sep>>><rsub|>|)>+50\<cdot\>t<rsub|<text|<em|Sep>>>>|<cell|\<geqslant\>>|<cell|9000<htab|5mm><around*|(|5|)>>>|<row|<cell|150\<cdot\><around*|(|w<rsub|<text|<em|Oct>>>-t<rsub|<text|<em|Oct>>><rsub|>|)>+50\<cdot\>t<rsub|<text|<em|Oct>>>>|<cell|\<geqslant\>>|<cell|11000<htab|5mm><around*|(|6|)>>>|<row|<cell|w<rsub|<text|<em|May>>>>|<cell|=>|<cell|60<htab|5mm><around*|(|7|)>>>|<row|<cell|w<rsub|<text|<em|Jun>>>>|<cell|=>|<cell|0.9\<cdot\>w<rsub|<text|<em|May>>>+t<rsub|<text|<em|May>>><htab|5mm><around*|(|8|)>>>|<row|<cell|w<rsub|<text|<em|Jul>>>>|<cell|=>|<cell|0.9\<cdot\>w<rsub|<text|<em|Jun>>>+t<rsub|<text|<em|Jun>>><htab|5mm><around*|(|9|)>>>|<row|<cell|w<rsub|<text|<em|Aug>>>>|<cell|=>|<cell|0.9\<cdot\>w<rsub|<text|<em|Jul>>>+t<rsub|<text|<em|Jul>>><htab|5mm><around*|(|10|)>>>|<row|<cell|w<rsub|<text|<em|Sep>>>>|<cell|=>|<cell|0.9\<cdot\>w<rsub|<text|<em|Aug>>>+t<rsub|<text|<em|Aug>>><htab|5mm><around*|(|11|)>>>|<row|<cell|w<rsub|<text|<em|Oct>>>>|<cell|=>|<cell|0.9\<cdot\>w<rsub|<text|<em|Sep>>>+t<rsub|<text|<em|Sep>>><htab|5mm><around*|(|12|)>>>>>
    </eqnarray*>

    For each <math|c<rsub|i>>, it could be interpretted as\ 

    <\equation*>
      c<rsub|i>=3400\<cdot\>w<rsub|i>-1600\<cdot\>t<rsub|i>
    </equation*>

    Our object is to minimize the toal cost:

    <\equation*>
      c<rsub|<text|<em|May>>>+c<rsub|<text|<em|Jun>>>+c<rsub|<text|<em|Jul>>>+c<rsub|<text|<em|Aug>>>+c<rsub|<text|<em|Sep>>>+c<rsub|<text|<em|Oct>>>
    </equation*>

    and plugging the <em|linear equality constraints> (7) to (12) into it we
    can get the objective function:

    <\equation*>
      min<around*|(|3400\<times\><around*|(|60\<times\><big|sum><rsub|i<rsub|>=0><rsup|5>0.9<rsup|i>+t<rsub|<text|<em|May>>>\<cdot\><big|sum><rsub|j=0><rsup|4>0.9<rsup|j>+t<rsub|<text|<em|Jun>>>\<cdot\><big|sum><rsub|k=0><rsup|3>0.9<rsup|k>+t<rsub|<text|<em|Jul>>>\<cdot\><big|sum><rsub|p=0><rsup|2>0.9<rsup|p>+t<rsub|<text|<em|Aug>>>\<cdot\><big|sum><rsub|q=0><rsup|1>0.9<rsup|q>+t<rsub|<text|<em|Sep>>>\<cdot\>0.9|)>-1600<around*|(|t<rsub|<text|<em|May>>>+t<rsub|<text|<em|Jun>>>+t<rsub|<text|<em|Jul>>>+t<rsub|<text|<em|Aug>>>+t<rsub|<text|<em|Sep>>>+t<rsub|<text|<em|Oct>>>|)>|)>
    </equation*>

    Plugging the <em|linear equality constraints> (7) to (12) into <em|linear
    inequality constraints> (1) to (6), and negating both sides of them, we
    can get new <em|linear inequalitiy constraints> containing up to 6
    variables shown as follows:

    <\eqnarray*>
      <tformat|<table|<row|<cell|-150\<times\>60+100\<cdot\>t<rsub|<text|<em|May>>>>|<cell|\<leqslant\>>|<cell|-8000>>|<row|<cell|-150\<cdot\><around*|(|0.9\<times\>60+t<rsub|<text|<em|May>>>|)>+100\<cdot\>t<rsub|<text|<em|Jun>>>>|<cell|\<leqslant\>>|<cell|-9000>>|<row|<cell|-150\<cdot\><around*|(|0.9<rsup|2>\<times\>60+0.9t<rsub|<text|<em|May>>>+t<rsub|<text|<em|Jun>>><rsub|>|)>+100\<cdot\>t<rsub|<text|<em|Jul>>>>|<cell|\<leqslant\>>|<cell|-7000>>|<row|<cell|-150\<cdot\><around*|(|0.9<rsup|3>\<times\>60+0.9<rsup|2>t<rsub|<text|<em|May>>>+0.9t<rsub|<text|<em|Jun>>>+t<rsub|<text|<em|Jul>>>|)>+100\<cdot\>t<rsub|<text|<em|Aug>>>>|<cell|\<leqslant\>>|<cell|-10000>>|<row|<cell|-150\<cdot\><around*|(|0.9<rsup|4>\<times\>60+0.9<rsup|3>t<rsub|<text|<em|May>>>+0.9<rsup|2>t<rsub|<text|<em|Jun>>>+0.9t<rsub|<text|<em|Jul>>>+t<rsub|<text|<em|Aug>>>|)>+100\<cdot\>t<rsub|<text|<em|Sep>>>>|<cell|\<leqslant\>>|<cell|-9000>>|<row|<cell|-150\<cdot\><around*|(|0.9<rsup|5>\<times\>60+0.9<rsup|4>t<rsub|<text|<em|May>>>+0.9<rsup|3>t<rsub|<text|<em|Jun>>>+0.9<rsup|2>t<rsub|<text|<em|Jul>>>+0.9t<rsub|<text|<em|Aug>>>+t<rsub|<text|<em|Sep>>>|)>+100\<cdot\>t<rsub|<text|<em|Oct>>>>|<cell|\<leqslant\>>|<cell|-11000>>>>
    </eqnarray*>

    <math|\<Rightarrow\>>

    <\eqnarray*>
      <tformat|<table|<row|<cell|100\<cdot\>t<rsub|<text|<em|May>>>>|<cell|\<leqslant\>>|<cell|-8000+150\<times\>60\<times\>0.9<rsup|0><htab|5mm><around*|(|1<rprime|'>|)>>>|<row|<cell|-150\<cdot\>t<rsub|<text|<em|May>>>+100\<cdot\>t<rsub|<text|<em|Jun>>>>|<cell|\<leqslant\>>|<cell|-9000+150\<times\>60\<times\>0.9<rsup|1><htab|5mm><around*|(|2<rprime|'>|)>>>|<row|<cell|-150\<cdot\><around*|(|0.9t<rsub|<text|<em|May>>>+t<rsub|<text|<em|Jun>>><rsub|>|)>+100\<cdot\>t<rsub|<text|<em|Jul>>>>|<cell|\<leqslant\>>|<cell|-7000+150\<times\>60\<times\>0.9<rsup|2><htab|5mm><around*|(|3<rprime|'>|)>>>|<row|<cell|-150\<cdot\><around*|(|0.9<rsup|2>t<rsub|<text|<em|May>>>+0.9t<rsub|<text|<em|Jun>>>+t<rsub|<text|<em|Jul>>>|)>+100\<cdot\>t<rsub|<text|<em|Aug>>>>|<cell|\<leqslant\>>|<cell|-10000+150\<times\>60\<times\>0.9<rsup|3><htab|5mm><around*|(|4<rprime|'>|)>>>|<row|<cell|-150\<cdot\><around*|(|0.9<rsup|3>t<rsub|<text|<em|May>>>+0.9<rsup|2>t<rsub|<text|<em|Jun>>>+0.9t<rsub|<text|<em|Jul>>>+t<rsub|<text|<em|Aug>>>|)>+100\<cdot\>t<rsub|<text|<em|Sep>>>>|<cell|\<leqslant\>>|<cell|-9000+150\<times\>60\<times\>0.9<rsup|4><htab|5mm><around*|(|5<rprime|'>|)>>>|<row|<cell|-150\<cdot\><around*|(|0.9<rsup|4>t<rsub|<text|<em|May>>>+0.9<rsup|3>t<rsub|<text|<em|Jun>>>+0.9<rsup|2>t<rsub|<text|<em|Jul>>>+0.9t<rsub|<text|<em|Aug>>>+t<rsub|<text|<em|Sep>>>|)>+100\<cdot\>t<rsub|<text|<em|Oct>>>>|<cell|\<leqslant\>>|<cell|-11000+150\<times\>60\<times\>0.9<rsup|5><htab|5mm><around*|(|6<rprime|'>|)>>>>>
    </eqnarray*>

    Plugging the\ 

    \;
  </enumerate-numeric>
</body>

<\initial>
  <\collection>
    <associate|page-type|letter>
  </collection>
</initial>