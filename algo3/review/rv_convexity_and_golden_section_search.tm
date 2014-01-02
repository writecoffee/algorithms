<TeXmacs|1.0.7.19>

<style|generic>

<\body>
  <doc-data|<doc-title|Convexity and Golden Section Search>>

  <\itemize>
    <item><strong|Convexity>

    <\definition>
      A function <math|f> from <math|n>-dimensional space to the real numbers
      is convex if for any two inputs <math|x> and <math|y>, the line segment
      in the graph of <math|f> from <math|(x, f(x))> to <math|(y, f(y))> lies
      on or above the graph of <math|f>. (The To express this slightly more
      formally, for any interpolation parameter between 0 and 1, we have the
      condition <with|color|red|<with|color|brown|<math|\<lambda\>f(x) + (1
      -\<lambda\> )f(y) \<geqslant\>f(x + (1 -\<lambda\> )y)>>>.
    </definition>

    <strong|Claim <em|1>>: there does not exist a convext function which
    passes through <math|<around*|(|x<rsub|1>,f<around*|(|x<rsub|1>|)>|)>,<around*|(|x<rsub|2>,f<around*|(|x<rsub|2>|)>|)>,<around*|(|x<rsub|3>,f<around*|(|x<rsub|3>|)>|)>>
    and any fourth point in the ``red'' region. <strong|Claim <em|2>>: as
    oppose to last claim, the convex function lie outside the region whose
    <math|x>-coordinate is between <math|x<rsub|1>> and <math|x<rsub|3>>.

    <\lemma>
      Assume you have an algorithm that can minimize convext functions in
      <math|n-1> dimensions; then we can solve the full <math|n>-dimensional
      minimization algorithm by just running a 1-dimensional minimization
      algorithm over the function that is the result of minimizing the input
      function over its remaining <math|n-1> dimensions (using the
      <math|n-1>-dimensional algorithm as a black box). <strong|Crucial
      Fact>: Given a convex function in two dimensions, <math|f(x, y)>, if we
      define a new function <math|g(x) = <text|min><rsub|y> f(x, y)> to be
      the minimum of <math|f> along its second dimension, for each value of
      <math|x>, then <math|g> is a convex function.
    </lemma>

    <\lemma>
      The first time the algorithm makes a bad decision
      (<math|<wide|g|~><around*|(|x<rsub|2>|)>\<less\><wide|g|~><around*|(|x<rsub|4>|)>>
      while <math|g<around*|(|x<rsub|2>|)>\<gtr\>g<around*|(|x<rsub|4>|)>>),
      recursing to an interval that does not contain the global minimumis
      happens, the true global minimum of <math|g> is at least
      <math|<wide|g|~><around*|(|x<rsub|2>|)>-\<phi\><rsup|2>\<epsilon\>>.
    </lemma>

    <item><strong|Golden Section Search>

    <\definition>
      <math|\<phi\>=<frac|<sqrt|5>+1|2>>, which has the property
      <math|1+\<phi\>=\<phi\><rsup|2>\<nocomma\>,<frac|1|\<phi\><rsup|2>>+<frac|1|\<phi\>>=1>,
      we make <math|x<rsub|4>=x<rsub|1>+x<rsub|3>-x<rsub|2>> lie in whichever
      interval <math|<around*|[|x<rsub|1>,x<rsub|2>|]>> or
      <math|<around*|[|x<rsub|2>,x<rsub|3>|]>> is larger, recurse on the side
      which could have prospective better lower bound. Stops when
      <math|f<around*|(|x<rsub|2>|)>-f<around*|(|x<rsub|4>|)>\<leqslant\>\<epsilon\>>.
    </definition>

    <strong|Analysis>: Each iteration the size of the interval decreases by a
    factor of <math|\<phi\>>, using one function evaluation (as
    <math|x<rsub|2>\<nocomma\>,x<rsub|4>> are computed in previous
    recursion). So to improve the precision by a factor of <math|p> takes
    <math|log<rsub|\<phi\>>p> iterations now, which is 30% better than
    <math|2log<rsub|2>p> of the binary search algorithm.
  </itemize>
</body>

<\initial>
  <\collection>
    <associate|page-type|letter>
  </collection>
</initial>