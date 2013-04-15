<TeXmacs|1.0.7.18>

<style|generic>

<\body>
  <doc-data|<doc-title|Linear Programming>>

  <\itemize>
    <item><strong|Simple in Action>

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

      <strong|Action: constraint (5) is released> (regarding
      <math|x<rsub|2>>) until (3) becomes tight, then <math|x<rsub|2>=3>. New
      vertex <math|<around*|(|0,3|)>>, new tight constraints (3)(4), new
      value is 15.

      <item>Change Coordinates <math|y<rsub|1>=x<rsub|1>,y<rsub|2>=3+x<rsub|1>-x<rsub|2>\<Leftrightarrow\>x<rsub|1>=y<rsub|1>,x<rsub|2>=3+y<rsub|1>-y<rsub|2>>.

      New LP

      <\equation*>
        <text|<em|max>> <around*|(|15+7y<rsub|1>-5y<rsub|2>|)>
      </equation*>

      <\eqnarray*>
        <tformat|<table|<row|<cell|y<rsub|1>+y<rsub|2>>|<cell|\<leqslant\>>|<cell|7<htab|5mm><around*|(|1|)>>>|<row|<cell|3y<rsub|1>-2y<rsub|2>>|<cell|\<leqslant\>>|<cell|3<htab|5mm><around*|(|2|)>>>|<row|<cell|y<rsub|2>>|<cell|\<geqslant\>>|<cell|0<htab|5mm><around*|(|3|)>>>|<row|<cell|y<rsub|1>>|<cell|\<geqslant\>>|<cell|0<htab|5mm><around*|(|4|)>>>|<row|<cell|-y<rsub|1>+y<rsub|2>>|<cell|\<geqslant\>>|<cell|3<htab|5mm><around*|(|5|)>>>>>
      </eqnarray*>

      <strong|Action: constraint (4) is released> (regarding
      <math|y<rsub|2>>) until (2) becomes tight, then <math|y<rsub|1>=1>. New
      vertex <math|<around*|(|1,0|)>> <em|(in coordinate system
      <math|<around*|(|y<rsub|1>,y<rsub|2>|)>>)>, new tight constraints
      (2)(3), new value is 22.

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

    \;
  </itemize>
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