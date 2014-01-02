<TeXmacs|1.0.7.19>

<style|generic>

<\body>
  <doc-data|<doc-title|Linear Programming>>

  <\itemize>
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

    <strong|<em|Example>>, LP for maximizing
    <math|<big|sum><rsub|i\<in\>C>r<rsub|i>>.
    <strong|<with|color|blue|variables>>: <math|c<rsub|i>>: whether or not a
    course is being taken; <strong|<with|color|blue|constraints>>:
    <math|0\<leqslant\>c<rsub|i>\<leqslant\>1> and <math|c<rsub|i>> is an
    integer (meaning that <math|c<rsub|i>> is either 0 or 1); if course
    <math|j> is a prerequisite for course <math|i>, then we add the
    constraint <math|c<rsub|j>\<geqslant\>c<rsub|i>>, meaning that if
    <math|c<rsub|i>=1>, then we must have <math|c<rsub|j>=1> as well.
    <strong|<with|color|blue|objective function>>:
    <math|<text|max><big|sum><rsub|i>c<rsub|i>r<rsub|i>>.
    <strong|<with|color|blue|proof>>: recall that a vertex is defined by a
    subset of the constraints being at equality. Note that all the
    constraints, at equality, have one of the three forms
    <math|<rsup|<around*|(|1|)>>c<rsub|i>=0>,
    <math|<rsup|<around*|(|2|)>>c<rsub|i>=1>, or
    <math|<rsup|<around*|(|3|)>>c<rsub|i>=c<rsub|j>>. Thus if several such
    equations have a unique solution, that solution must clarly have each
    coordinate equal to 0 or 1. Namely, the LP always has an integer
    solution.

    <item><strong|Duality>

    We appeal to the following physics intuition:

    <\enumerate>
      <item>the force that constraint <math|i> exerts on the marble must be a
      nonnegative multiple of <math|A<rsub|i>>, where <math|A<rsub|i>> is the
      <math|i>th row of the matrix <math|A>, associated with the <math|i>th
      constraint <math|A<rsub|i>\<cdot\>x\<geqslant\>b<rsub|i>>;

      <item>the total force these contraints exert on the marble must be in
      the up direction, <math|u>;

      <item>only constraints that pass through <math|x<rsup|\<ast\>>> can
      exert force on the marble.
    </enumerate>

    The physics intuition could be expressed in the following fact:

    <\enumerate>
      <item>there are nonnegative values <math|y<rsub|i>,\<ldots\>,y<rsub|m>>
      such that

      <item><math|y<rsub|1>A<rsub|1>+\<ldots\>+y<rsub|m>A<rsub|m>=u>, and
      where

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

    <em|<strong|Example>> (Intuition): in <em|Scissor-Paper-Rock> problem,
    for row player, her <em|expected playoff> is <with|color|blue|at least
    (by lower bound)> <math|f> in primal form (maximization), but her
    <em|expected playoff> is <with|color|blue|at most (by upper bound)>
    <math|f<rsup|\<ast\>>> in dual form (minimization), given the column
    player's strategy. By strong duality, <math|f=f<rsup|\<ast\>>> and thus
    the row player gets <em|expected payoff> exactly <math|f> and cannot
    improve this.

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
      <math|\<leqslant\>> everywhere, we can simply take negation on both
      side of <math|\<geqslant\>>.

      <item>Equalities: ``<math|=>'' could be turned into
      ``<math|\<leqslant\>>'' or ``<math|\<geqslant\>>'', it holds for both
      maximization and minimization.

      <item>For <math|x<rsub|i>\<geqslant\>0>: solution is to define new
      variables, <em|e.g.>, <math|3x<rsub|1>+4x<rsub|5>\<leqslant\>6>, we let
      <math|x<rsub|1>=x<rsub|1><rsup|+>-x<rsub|1><rsup|->>,
      <math|x<rsub|1><rsup|+>,x<rsub|1><rsup|->> both <math|\<geqslant\>0>.
      If <math|x<rsub|1>=-3>, <math|x<rsub|1><rsup|+>=0>,
      <math|x<rsub|1><rsup|->=3>.
    </itemize>

    <item><strong|Note>

    The dual of an unconstrainted variable is an equality constraint,
    <em|e.g.>, <strong|variables> <math|<matrix|<tformat|<table|<row|<cell|r>|<cell|p>|<cell|s>|<cell|m>>>>>>,
    <strong|objective function> <math|<text|maximize >m>, constraints
    <math|<matrix|<tformat|<table|<row|<cell|-A<rsub|1,1>>|<cell|-A<rsub|2,1>>|<cell|-A<rsub|3,1>>|<cell|1>>|<row|<cell|-A<rsub|1,2>>|<cell|-A<rsub|2,2>>|<cell|-A<rsub|3,2>>|<cell|1>>|<row|<cell|-A1,3>|<cell|-A<rsub|2,3>>|<cell|-A<rsub|3,3>>|<cell|1>>|<row|<cell|1>|<cell|1>|<cell|1>|<cell|0>>>>><matrix|<tformat|<table|<row|<cell|r>>|<row|<cell|p>>|<row|<cell|s>>|<row|<cell|m>>>>><stack|<tformat|<table|<row|<cell|\<leqslant\>>>|<row|<cell|\<leqslant\>>>|<row|<cell|\<leqslant\>>>|<row|<cell|=>>>>><matrix|<tformat|<table|<row|<cell|0>>|<row|<cell|0>>|<row|<cell|0>>|<row|<cell|1>>>>>>,
    and <math|r,p,s\<geqslant\>0>, with <math|m> unconstrainted.
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