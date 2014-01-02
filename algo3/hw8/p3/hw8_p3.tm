<TeXmacs|1.0.7.19>

<style|generic>

<\body>
  <doc-data|<doc-title|CS157 Homework 8>|<doc-author|<author-data|<author-name|Silao_xu
  Tc28>>>>

  <subsection|Problem 3>

  Some courses are rewarding to take; other courses you take only because
  they are prerequisites for rewarding courses later on.\ 

  Suppose a university offers <math|n> courses, and each course <math|i> has
  a set of prerequisites <math|p<rsub|i>\<subset\><around*|[|n|]>>, all of
  which you must take if you plan on taking course <math|i>. (You may assume
  that there are no cyclic dependencies in the prerequisite list.) In
  addition, for each course <math|i>, you also know how rewarding it will be
  to take, a number <math|r<rsub|i>>, in arbitrary units, which could be
  positive or negative! Your goal is to find a set <math|C> of courses to
  take, subject to the prerequisite constraints (for each course i and each
  prerequisite <math|j\<in\>p<rsub|i>>, if <math|i> is in <math|C> then
  <math|j> is in <math|C>), in order to maximize
  <math|<big|sum><rsub|i\<in\>C>r<rsub|i>>.

  <\enumerate-numeric>
    <item>(5 points) Express this problem as an integer program, where each
    course corresponds to a variable that has value 0 if the course is not
    taken, and 1 if it is. Each constraint should enforce a single relation
    of the form ``course <math|j> is a prerequisite for course <math|i>''.

    The variables we define are as follows:

    <\eqnarray*>
      <tformat|<table|<row|<cell|x<rsub|i>>|<cell|=>|<cell|<text|whether
      course <math|i> is taken or not, 1 represents it will be taken, 0 as
      opposite>>>>>
    </eqnarray*>

    Our objective is to maximize the overall rewards. The reward of
    course-<math|i> would be taken into account when <math|x<rsub|i>=1>. The
    objective function is shown in (1).

    <\eqnarray*>
      <tformat|<table|<row|<cell|>|<cell|<text|Maximize
      \ ><big|sum><rsub|i\<in\><around*|[|n|]>>r<rsub|i>x<rsub|i>>|<cell|<htab|5mm><around*|(|1|)>>>>>
    </eqnarray*>

    The constraint for each course-<math|i> we could derive is represented in
    (2), which means if course-<math|i> would be taken, all of its
    corresponding prerequisite courses should be taken for sure and thus the
    right-hand side (the sum of all prerequisite) has to be no less than
    <math|<around*|\||p<rsub|i>|\|>> times <math|x<rsub|i>> no matter whether
    course-<math|i> was taken or not.

    <\eqnarray*>
      <tformat|<table|<row|<cell|<around*|\||p<rsub|i>|\|>\<cdot\>x<rsub|i>>|<cell|\<leqslant\>>|<cell|<big|sum><rsub|<text|<math|j>>\<in\>p<rsub|i>>x<rsub|j><htab|5mm><around*|(|2|)>>>>>
    </eqnarray*>

    We define <em|IsPre> as a function denoting the preceding relationship
    between each pair of courses, its formal representation is as follows:

    <\equation*>
      <text|<em|IsPre>><around*|(|i,j|)>=<choice|<tformat|<table|<row|<cell|-1>|<cell|<text|course-<math|j>
      is course-<math|i>'s correspoinding
      prerequisite>>>|<row|<cell|0>|<cell|<text|course-<math|j> isn't
      <math|i>'s prerequisite>>>>>>
    </equation*>

    Now (2) could be represented in the form <math|A\<cdot\>x\<leqslant\>b>,
    where <math|x> is the <math|n\<times\>1> input vector representing the
    corresponding variable for each course, <math|b> is a <math|n\<times\>1>
    zeros vector. <math|A> is a <math|n\<times\>n> matrix shown as follows in
    detail:

    <\equation*>
      A<rsub|n\<times\>n>=<with|font-base-size|8|<matrix|<tformat|<table|<row|<cell|<around*|\||p<rsub|1>|\|>>|<cell|<text|<em|IsPre>><around*|(|1,2|)>>|<cell|<text|<em|IsPre>><around*|(|1,3|)>>|<cell|\<cdots\>>|<cell|<text|<em|IsPre>><around*|(|1,n|)>>>|<row|<cell|<text|<em|IsPre>><around*|(|2,1|)>>|<cell|<around*|\||p<rsub|2>|\|>>|<cell|<text|<em|IsPre>><around*|(|2,3|)>>|<cell|\<cdots\>>|<cell|<text|<em|IsPre>><around*|(|2,n|)>>>|<row|<cell|\<vdots\>>|<cell|>|<cell|>|<cell|\<ddots\>>|<cell|\<vdots\>>>|<row|<cell|<text|<em|IsPre>><around*|(|n,1|)>>|<cell|<text|<em|IsPre>><around*|(|n,2|)>>|<cell|<text|<em|IsPre>><around*|(|n,3|)>>|<cell|\<cdots\>>|<cell|<around*|\||p<rsub|n>|\|>>>>>>>
    </equation*>

    To sum these up, the problem represented in the integer program form is
    as below:

    <\eqnarray*>
      <tformat|<table|<row|<cell|>|<cell|<text|Maximize
      \ ><big|sum><rsub|i\<in\><around*|[|n|]>>r<rsub|i>x<rsub|i><text|, such
      that >A\<cdot\>x\<leqslant\>b<text|, where
      <math|x<rsub|i>\<in\><around*|{|0,1|}>>>>|<cell|<htab|5mm><around*|(|3|)>>>>>
    </eqnarray*>

    <item>(10 points) Show that this problem can in fact be solved in
    polynomial time by linear programming: taking the above integer program
    and ignoring the integrality constraints, show that the resulting linear
    program has an optimal solution all of whose coordinates are integers.\ 

    (<strong|Hint>: Two possible ways to prove this include 1) consider a
    hypothetical optimum solution to the linear program, take all its
    non-integer coordinates, and figure out how to modify them to a solution
    that is at least as good but which has more of its coordinates equal to 0
    or 1; or 2) make use of the fact that the set of optima of a linear
    program always includes a vertex of the constraint polytope, and show
    that such a vertex must have 0-1 coordinates.)

    We know that the feasible region of a linear program is specied by a set
    of inequalities and is therefore the intersection of the corresponding
    half-spaces, a convex polyhedron.

    Based on the face that the set of optima of a linear program always
    includes a vertex of the constraint polytope, and there are <math|n>
    variables in (1), we need at least <math|n> linear equality functions to
    uniquely determine a feasible solution. Given the integer program in (3),
    the vertex we are striving to find is supposed to be satisfied with these
    <math|n> linear equality constraints such that

    <\eqnarray*>
      <tformat|<table|<row|<cell|>|<cell|<around*|\||p<rsub|i>|\|>x<rsub|i>-<big|sum><rsub|j\<in\>p<rsub|i>>x<rsub|j>=0>|<cell|<htab|5mm><around*|(|4|)>>>>>
    </eqnarray*>

    From (4), we could infer that <math|x<rsub|i>> and each of its
    corresponding courses' coefficient <math|x<rsub|j>> all would be either 1
    or 0 and thus every dimension of the vertex must have either coordinate 0
    or 1. So the vertex must have 0-1 coordinates. This also implies that the
    resulting linear program has an optimal solution all of whose coordinates
    are integers.

    Now we can draw a conclusion that the problem can be solved in polynomial
    time by linear programming.
  </enumerate-numeric>
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

<\auxiliary>
  <\collection>
    <\associate|toc>
      <with|par-left|<quote|1.5fn>|Problem 3
      <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-1>>
    </associate>
  </collection>
</auxiliary>