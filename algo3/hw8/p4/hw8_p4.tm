<TeXmacs|1.0.7.19>

<style|generic>

<\body>
  <doc-data|<doc-title|CS157 Homework 8>|<doc-author|<author-data|<author-name|Silao_xu
  and Tc28>>>>

  <subsection|Problem 4>

  <strong|Convexity>:

  In this problem we will be exploring various aspects of convexity. Recall
  the definition of a convex function (http://en.wikipedia.org/wiki/Convex_function):
  a function <math|f> from <math|n>-dimensional space to the real numbers is
  convex if for any two inputs <math|x> and <math|y>, the line segment in the
  graph of <math|f> from <math|(x, f(x))> to <math|(y, f(y))> lies on or
  above the graph of <math|f>. (The picture is easiest to draw for dimension
  <math|n = 1>.) To express this slightly more formally, for any
  interpolation parameter between 0 and 1, we have the condition
  <math|\<lambda\>f(x) + (1 -\<lambda\> )f(y) \<geqslant\>f(x + (1
  -\<lambda\> )y)>. Make sure you understand what this means in one dimension
  before moving on.

  <\enumerate-numeric>
    <item>(5 points) Recall the golden section search algorithm from the
    optimization lab, for minimizing convex functions <math|f> in one
    dimension. At each moment in the algorithm, you will be considering the
    function value at three unequally spaced points,
    <math|x<rsub|1>\<less\>x<rsub|2>\<less\>x<rsub|3>> where <math|x<rsub|2>>
    is <math|\<phi\>> times closer to one endpoint than than the other, where
    <math|\<phi\>>, the golden ratio, is <math|<frac|<sqrt|5>+1|2>>. Consider
    the case where <math|x<rsub|2>> is closer to <math|x<rsub|1>> than
    <math|x<rsub|3>>. Also, by the induction hypothesis of the algorithm,
    <math|f<around*|(|x<rsub|2>|)>> is less than or equal to
    <math|f<around*|(|x<rsub|1>|)>> and <math|f<around*|(|x<rsub|3>|)>>.

    Clearly the minimum value of <math|f> on this interval is at most
    <math|f<around*|(|x<rsub|2>|)>>. Find the best <em|lower bound> for
    <math|f>, in terms of <math|f(x<rsub|1>)>, <math|f(x<rsub|2>)>, and
    <math|f(x<rsub|3>)>, given that <math|f> is convex. Explain.

    <\itemize>
      <item><em|Case 1>: <math|x> locates in
      <math|<around*|[|x<rsub|2>,x<rsub|3>|]>>

      According to the definition of convexity, we know that
      <math|<frac|x<rsub|2>-x<rsub|1>|x<rsub|3>-x<rsub|2>>=<frac|\<lambda\>|1-\<lambda\>>>.
      Also, according to the golden ratio, the
      <math|<frac|<around*|\||x<rsub|1>-x<rsub|2>|\|>|<around*|\||x<rsub|2>-x<rsub|3>|\|>>=<frac|1|\<phi\>>>
      and thus we find the relation between <math|\<phi\>> and
      <math|\<lambda\>>, that is

      <\eqnarray*>
        <tformat|<table|<row|<cell|<frac|\<lambda\>|1-\<lambda\>>>|<cell|=>|<cell|<frac|1|\<phi\>>>>|<row|<cell|\<lambda\>>|<cell|=>|<cell|<frac|1|\<phi\><rsup|2>><htab|5mm><around*|(|1|)>>>>>
      </eqnarray*>

      Similarly, we could also find the relation between <math|1-\<lambda\>>
      and <math|\<phi\>>, which is

      <\eqnarray*>
        <tformat|<table|<row|<cell|1-\<lambda\>>|<cell|=>|<cell|1-<frac|1|\<phi\><rsup|2>>>>|<row|<cell|>|<cell|=>|<cell|<frac|\<phi\><rsup|2>-1|\<phi\><rsup|2>>>>|<row|<cell|>|<cell|=>|<cell|<frac|\<phi\>|\<phi\><rsup|2>>>>|<row|<cell|>|<cell|=>|<cell|<frac|1|\<phi\>><htab|5mm><around*|(|2|)>>>>>
      </eqnarray*>

      The condition of convexity constraints the point
      <math|<around*|(|x,y|)>> for the best <em|lower bound>, lie on the same
      line as <math|<around*|(|x<rsub|2>,f<around*|(|x<rsub|2>|)>|)>> and
      <math|<around*|(|x<rsub|1>,f<around*|(|x<rsub|1>|)>|)>>, and that is

      <\eqnarray*>
        <tformat|<table|<row|<cell|<around*|(|1-\<lambda\>|)>f<around*|(|x<rsub|1>|)>+\<lambda\>y>|<cell|=>|<cell|f<around*|(|x<rsub|2>|)>>>|<row|<cell|y>|<cell|=>|<cell|<frac|f<around*|(|x<rsub|2>|)>-<around*|(|1-\<lambda\>|)>f<around*|(|x<rsub|1>|)>|\<lambda\>><htab|5mm><around*|(|3|)>>>>>
      </eqnarray*>

      Plugging (1) and (2) into (3), we get the possible best <em|lower
      bound> for case 1

      <\eqnarray*>
        <tformat|<table|<row|<cell|y>|<cell|=>|<cell|\<phi\><rsup|2>f<around*|(|x<rsub|2>|)>-\<phi\>f<around*|(|x<rsub|1>|)>>>>>
      </eqnarray*>

      <item><em|Case 2>: <math|x> locates in
      <math|<around*|[|x<rsub|1>,x<rsub|2>|]>>

      Similarly, the condition of convexity constraints the point
      <math|<around*|(|x<rprime|'>,y<rprime|'>|)>> for the best <em|lower
      bound>, locating in <math|<around*|[|x<rsub|1>,x<rsub|2>|]>>, lie on
      the same line as <math|<around*|(|x<rsub|2>,f<around*|(|x<rsub|2>|)>|)>>
      and <math|<around*|(|x<rsub|3>,f<around*|(|x<rsub|3>|)>|)>>, that is

      <\eqnarray*>
        <tformat|<table|<row|<cell|<around*|(|1-\<lambda\>|)>y<rprime|'>+f<around*|(|x<rsub|3>|)>\<lambda\>>|<cell|=>|<cell|f<around*|(|x<rsub|2>|)>>>|<row|<cell|y<rprime|'>>|<cell|=>|<cell|<frac|f<around*|(|x<rsub|2>|)>-f<around*|(|x<rsub|3>|)>\<lambda\>|1-\<lambda\>><htab|5mm><around*|(|4|)>>>>>
      </eqnarray*>

      Plugging (1) and (2) into (4), we get the possible best <em|lower
      bound> for case 2

      <\eqnarray*>
        <tformat|<table|<row|<cell|y<rprime|'>>|<cell|=>|<cell|\<phi\><rsup|2>f<around*|(|x<rsub|2>|)>-\<phi\>f<around*|(|x<rsub|3>|)>>>>>
      </eqnarray*>

      <item><em|Summary>

      The best <em|lower bound> taking <em|Case 1> and <em|2> into account
      both would be <math|<text|min><around*|(|y,y<rprime|'>|)>>.
    </itemize>

    <item>(3 points) Suppose we want our golden section search algorithm to
    return a value <math|x> such that <math|f(x)> is within of the global
    minimum. What <em|stopping condition> for the algorithm do your results
    from the previous part suggest? Explain.

    Using the <em|Golden Ratio Search> method, each step we would derive a
    new searching point <math|x<rsub|4>> where
    <math|x<rsub|4>=x<rsub|1>+x<rsub|3>-x<rsub|2>>. Also, we could predict
    the best <em|lowest point> within <math|<around*|[|x<rsub|1>,x<rsub|3>|]>>
    of the convex function would be either <math|y> or <math|y<rprime|'>>.

    Now we could define the <em|stopping condition> as
    <math|<around*|\||y-f<around*|(|x<rsub|4>|)>|\|>\<leqslant\>\<epsilon\>>
    (for <em|Case 1>) or <math|<around*|\||y<rprime|'>-f<around*|(|x<rsub|4>|)>|\|>\<leqslant\>\<epsilon\>>
    (for <em|Case 2>).

    <item>Given a convex function in two dimensions, <math|f(x, y)>, if we
    define a new function <math|g(x) = <text|min><rsub|y> f(x, y)> to be the
    minimum of <math|f> along its second dimension, for each value of
    <math|x>, then <math|g> is a convex function. Prove this.

    From the convext function <math|f<around*|(|x,y|)>>, we know that\ 

    <\eqnarray*>
      <tformat|<table|<row|<cell|\<lambda\>f<around*|(|x<rsub|1>,y<rsub|1>|)>+<around*|(|1-\<lambda\>|)>f<around*|(|x<rsub|2>,y<rsub|2>|)>>|<cell|\<geqslant\>>|<cell|f<around*|(|\<lambda\>x<rsub|1>+<around*|(|1-\<lambda\>|)>x<rsub|2>,\<lambda\>y<rsub|1>+<around*|(|1-\<lambda\>|)>y<rsub|2>|)><htab|5mm><around*|(|5|)>>>>>
    </eqnarray*>

    where <math|\<lambda\>\<in\><around*|[|0,1|]>>.

    We let <math|f<around*|(|x<rsub|1>,y<rsub|<text|min>>|)>> be the minimum
    of <math|f<around*|(|x<rsub|1>,y|)>> along <math|f>'s second dimension,
    and <math|f<around*|(|x<rsub|2>,y<rsub|<text|min>><rprime|'>|)>> be the
    minimum of <math|f<around*|(|x<rsub|2>,y|)>> along its second dimension.
    We have

    <\eqnarray*>
      <tformat|<table|<row|<cell|g<around*|(|x<rsub|1>|)>>|<cell|=>|<cell|<text|min><rsub|y>f<around*|(|x<rsub|1>,y|)>>>|<row|<cell|>|<cell|=>|<cell|f<around*|(|x<rsub|1>,y<rsub|<text|min>>|)>>>>>
    </eqnarray*>

    and

    <\eqnarray*>
      <tformat|<table|<row|<cell|g<around*|(|x<rsub|2>|)>>|<cell|=>|<cell|<text|min><rsub|y>f<around*|(|x<rsub|2>,y|)>>>|<row|<cell|>|<cell|=>|<cell|f<around*|(|x<rsub|2>,y<rsub|<text|min>><rprime|'>|)>>>>>
    </eqnarray*>

    also according to the convexity condition and substitute
    <math|f<around*|(|x<rsub|2>,y<rprime|'><rsub|<text|min>>|)>> and
    <math|f<around*|(|x<rsub|1>,y<rsub|<text|min>>|)>> with
    <math|g<around*|(|x<rsub|2>|)>> and <math|g<around*|(|x<rsub|1>|)>>
    respectively, we have

    <\eqnarray*>
      <tformat|<table|<row|<cell|\<lambda\>f<around*|(|x<rsub|1>,y<rsub|<text|min>>|)>+<around*|(|1-\<lambda\>|)>f<around*|(|x<rsub|2>,y<rsub|<text|min>><rprime|'>|)>>|<cell|\<geqslant\>>|<cell|f<around*|(|\<lambda\>x<rsub|1>+<around*|(|1-\<lambda\>|)>x<rsub|2>,\<lambda\>y<rsub|<text|min>>+<around*|(|1-\<lambda\>|)>y<rsub|<text|min>><rprime|'>|)>>>|<row|<cell|\<lambda\>g<around*|(|x<rsub|1>|)>+<around*|(|1-\<lambda\>|)>g<around*|(|x<rsub|2>|)>>|<cell|\<geqslant\>>|<cell|f<around*|(|\<lambda\>x<rsub|1>+<around*|(|1-\<lambda\>|)>x<rsub|2>,\<lambda\>y<rsub|<text|min>>+<around*|(|1-\<lambda\>|)>y<rsub|<text|min>><rprime|'>|)><htab|5mm><around*|(|6|)>>>>>
    </eqnarray*>

    Fixing the first dimension of <math|f> and let it be
    <math|\<lambda\>x<rsub|1>+<around*|(|1-\<lambda\>|)>x<rsub|2>>, we could
    define a new function <math|h<around*|(|y|)>=f<around*|(|\<lambda\>x<rsub|1>+<around*|(|1-\<lambda\>|)>x<rsub|2>,y|)>>
    where <math|y> is variable. Based on the fact that
    <math|f<around*|(|x,y|)>> is a convext function in two dimensions, for
    any two inputs <math|y<rsub|1>> and <math|y<rsub|2>>, the line segment in
    the graph of <math|f> from <math|h<around*|(|y<rsub|1>|)>> to
    <math|h<around*|(|y<rsub|2>|)>> lies on or above the graph of <math|f>,
    and thus lies on or above the graph of <math|h>. So
    <math|h<around*|(|y|)>> is also a convex function, and from the defintion
    of convexity we could derive

    <\eqnarray*>
      <tformat|<table|<row|<cell|h<around*|(|\<lambda\>y<rsub|<text|min>>+<around*|(|1-\<lambda\>|)>y<rsub|<text|min>><rprime|'>|)>>|<cell|\<leqslant\>>|<cell|\<lambda\>h<around*|(|y<rsub|<text|min>>|)>+<around*|(|1-\<lambda\>|)>h<around*|(|y<rsub|<text|min>><rprime|'>|)>>>>>
    </eqnarray*>

    where <math|\<lambda\>y<rsub|<text|min>>+<around*|(|1-\<lambda\>|)>y<rsub|<text|min>><rprime|'><rsub|>>
    is a minimum value of <math|f> over its second dimension for value
    <math|x=\<lambda\>x<rsub|1>+<around*|(|1-\<lambda\>|)>x<rsub|2>>. So
    <math|f<around*|(|\<lambda\>x<rsub|1>+<around*|(|1-\<lambda\>|)>x<rsub|2>,\<lambda\>y<rsub|<text|min>>+<around*|(|1-\<lambda\>|)>y<rsub|<text|min>><rprime|'>|)>=g<around*|(|\<lambda\>x<rsub|1>+<around*|(|1-\<lambda\>|)>x<rsub|2>|)>>
    and plug it into the right-hand side of (6), we get\ 

    <\eqnarray*>
      <tformat|<table|<row|<cell|\<lambda\>g<around*|(|x<rsub|1>|)>+<around*|(|1-\<lambda\>|)>g<around*|(|x<rsub|2>|)>>|<cell|\<geqslant\>>|<cell|g<around*|(|\<lambda\>x<rsub|1>+<around*|(|1-\<lambda\>|)>x<rsub|2>|)>>>>>
    </eqnarray*>

    According to the formal convexity condition, we conclude that <math|g> is
    also a convex function.

    <item>(6 points) A further complication with this kind of recursive
    optimization procedure has to do with numerical precision. The golden
    section search algorithm will not find the exact minimum value of its
    input function, but will, rather, return a value which may be larger than
    the minimum. This error may make subsequent layers of the recursion have
    even larger errors.

    Show that the first time the algorithm makes a bad decision, recursing to
    an interval that does not contain the global minimumis happens, the true
    global minimum of <math|g> is at least
    <math|<wide|g|~><around*|(|x<rsub|2>|)>-\<phi\><rsup|2>\<epsilon\>>.

    In this case, we could apply our extimated best <em|lower bound> from
    part 1, such that\ 

    <\eqnarray*>
      <tformat|<table|<row|<cell|g<rsub|<text|min>>>|<cell|\<geqslant\>>|<cell|\<phi\><rsup|2>g<around*|(|x<rsub|4>|)>-\<phi\>g<around*|(|x<rsub|2>|)><htab|5mm><around*|(|7|)>>>>>
    </eqnarray*>

    Also <math|<wide|g|~><around*|(|x<rsub|2>|)>> must be within the interval
    <math|<around*|[|g<around*|(|x|)>,\<epsilon\>+g<around*|(|x|)>|]>>, that
    is <math|<wide|g|~><around*|(|x<rsub|2>|)>\<gtr\>g<around*|(|x<rsub|2>|)>>,
    plugging it into (7) we get

    <\eqnarray*>
      <tformat|<table|<row|<cell|g<rsub|<text|min>>>|<cell|\<geqslant\>>|<cell|\<phi\><rsup|2>g<around*|(|x<rsub|4>|)>-\<phi\><wide|g|~><around*|(|x<rsub|2>|)><htab|5mm><around*|(|8|)>>>>>
    </eqnarray*>

    We know that <math|<wide|g|~><around*|(|x<rsub|4>|)>-g<around*|(|x<rsub|4>|)>\<leqslant\>\<epsilon\>>,
    that is <math|<wide|g|~><around*|(|x<rsub|4>|)>-\<epsilon\>\<leqslant\>g<around*|(|x<rsub|4>|)>>
    and given <math|<wide|g|~><around*|(|x<rsub|2>|)>\<less\><wide|g|~><around*|(|x<rsub|4>|)>>
    we have

    <\eqnarray*>
      <tformat|<table|<row|<cell|g<around*|(|x<rsub|4>|)>>|<cell|\<geqslant\>>|<cell|<wide|g|~><around*|(|x<rsub|2>|)>-\<epsilon\><htab|5mm><around*|(|9|)>>>>>
    </eqnarray*>

    Plugging (9) into (8), we could draw the conclusion that

    <\eqnarray*>
      <tformat|<table|<row|<cell|g<rsub|<text|min>>>|<cell|\<geqslant\>>|<cell|\<phi\><rsup|2><around*|(|<wide|g|~><around*|(|x<rsub|2>|)>-\<epsilon\>|)>-\<phi\><wide|g|~><around*|(|x<rsub|2>|)>>>|<row|<cell|>|<cell|=>|<cell|<around*|(|\<phi\><rsup|2>-\<phi\>|)><wide|g|~><around*|(|x<rsub|2>|)>-\<phi\><rsup|2>\<epsilon\>>>|<row|<cell|>|<cell|=>|<cell|<wide|g|~><around*|(|x<rsub|2>|)>-\<phi\><rsup|2>\<epsilon\><htab|5mm><around*|(|1+\<phi\>=\<phi\><rsup|2>|)>>>>>
    </eqnarray*>
  </enumerate-numeric>
</body>

<\initial>
  <\collection>
    <associate|page-type|letter>
  </collection>
</initial>

<\references>
  <\collection>
    <associate|auto-1|<tuple|1|1>>
  </collection>
</references>

<\auxiliary>
  <\collection>
    <\associate|toc>
      <with|par-left|<quote|1.5fn>|Problem 4
      <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-1>>
    </associate>
  </collection>
</auxiliary>