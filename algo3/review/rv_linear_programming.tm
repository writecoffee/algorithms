<TeXmacs|1.0.7.19>

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

    <item><strong|Linear Regression>

    Given <math|n> points <math|<around*|(|x<rsub|i>,y<rsub|i>|)>>, find a
    line that best approximates them. Compare ``least squares'' (L2),
    <em|L1>, <em|L1 maximum deviation> regression.

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
      x<rsub|i>+q-y<rsub|i>|\|>> and taking the variables <math|p> and
      <math|q> into account, the objective function could be interpretted as
      follows:

      <\eqnarray*>
        <tformat|<table|<row|<cell|>|<cell|0p+0q+<big|sum><rsub|i=1><rsup|n>Z<rsub|i>>|<cell|<htab|5mm><around*|(|4|)>>>>>
      </eqnarray*>

      <item>For <em|L1 maximum deviation>,
      <math|<text|max><rsub|i><around*|\||p x<rsub|i>+q-y<rsub|i>|\|>>, the
      constraints for every point should be

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
      x<rsub|i>+q-y<rsub|i>|\|>> and taking the variables <math|p> and
      <math|q> into account, the objective function could be interpretted as
      follows:

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
      whose coordinates are integer, the problem could be solved in
      polynomial time by LP.
    </theorem>

    <\theorem>
      The set of optima of a LP always includes a vertex of the constraint
      polytope.
    </theorem>

    <strong|Example>, LP for maximizing <math|<big|sum><rsub|i\<in\>C>r<rsub|i>>.
    <strong|variables>: <math|c<rsub|i>>: whether or not a course is being
    taken; <strong|constraints>: <math|0\<leqslant\>c<rsub|i>\<leqslant\>1>
    and <math|c<rsub|i>> is an integer (meaning that <math|c<rsub|i>> is
    either 0 or 1); if course <math|j> is a prerequisite for course <math|i>,
    then we add the constraint <math|c<rsub|j>\<geqslant\>c<rsub|i>>, meaning
    that if <math|c<rsub|i>=1>, then we must have <math|c<rsub|j>=1> as well.
    <strong|objective function>: <math|<text|max><big|sum><rsub|i>c<rsub|i>r<rsub|i>>.
    <strong|proof>: recall that a vertex is defined by a subset of the
    constraints being at equality. Note that all the constraints, at
    equality, have one of the three forms
    <math|<rsup|<around*|(|1|)>>c<rsub|i>=0>,
    <math|<rsup|<around*|(|2|)>>c<rsub|i>=1>, or
    <math|<rsup|<around*|(|3|)>>c<rsub|i>=c<rsub|j>>. Thus if several such
    equations have a unique solution, that solution must clarly have each
    coordinate equal to 0 or 1. Namely, the LP always has an integer
    solution.
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
    <associate|auto-2|<tuple|2|?>>
  </collection>
</references>