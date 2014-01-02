<TeXmacs|1.0.7.19>

<style|generic>

<\body>
  <doc-data|<doc-title|CS157 Homework 8>|<doc-author|<author-data|<author-name|Silao_xu
  and Tc28>>>>

  <subsection|Problem 1>

  Many industries have to solve some version of the following ``hiring
  problem.'' Suppose you run a business that needs 8000 hours of labor in
  May, 9000 hours in June, 7000 in July, 10,000 in August, 9000 in September,
  and and 11,000 in October. Also, suppose that currently, as May starts, you
  have 60 experienced employees working for you. Each month, each experienced
  employee can either work up to 150 hours for in that month or work up to 50
  hours that month while also training one new hire who will then be ready to
  work the following month (and will be called an ``experienced'' worker the
  following month). At the end of each month, 10% of your experienced
  employees quit. It costs $3400 a month to employ an experienced worker, and
  $1800 a month for each trainee.

  <\enumerate-numeric>
    <item>(10 points) Write a linear program that represents this problem,
    and describe what corresponds to what, and why it accurately represents
    the problem. (Note, do not worry about integrality of the solution; the
    optimum of the linear program may include things that mean, for example,
    ``hire 27.3 people in June''.)

    The variables we define are as follows:

    <\eqnarray*>
      <tformat|<table|<row|<cell|w<rsub|i>>|<cell|=>|<cell|<text|number of
      workers for month <math|i>>>>|<row|<cell|
      t<rsub|i>>|<cell|=>|<cell|<text|number of experienced workers
      participate in the training for month
      <math|i>>>>|<row|<cell|c<rsub|i>>|<cell|=>|<cell|<text|the cost for
      employing in month <math|i>>>>>>
    </eqnarray*>

    The constraints we could infer are as follows:

    <\eqnarray*>
      <tformat|<table|<row|<cell|150\<cdot\><around*|(|w<rsub|<text|<em|May>>>-t<rsub|<text|<em|May>>>|)>+50\<cdot\>t<rsub|<text|<em|May>>>>|<cell|\<geqslant\>>|<cell|8000<htab|5mm><around*|(|1|)>>>|<row|<cell|150\<cdot\><around*|(|w<rsub|<text|<em|Jun>>>-t<rsub|<text|<em|Jun>>><rsub|>|)>+50\<cdot\>t<rsub|<text|<em|Jun>>>>|<cell|\<geqslant\>>|<cell|9000>>|<row|<cell|150\<cdot\><around*|(|w<rsub|<text|<em|Jul>>>-t<rsub|<text|<em|Jul>>><rsub|>|)>+50\<cdot\>t<rsub|<text|<em|Jul>>>>|<cell|\<geqslant\>>|<cell|7000>>|<row|<cell|150\<cdot\><around*|(|w<rsub|<text|<em|Aug>>>-t<rsub|<text|<em|Aug>>><rsub|>|)>+50\<cdot\>t<rsub|<text|<em|Aug>>>>|<cell|\<geqslant\>>|<cell|10000>>|<row|<cell|150\<cdot\><around*|(|w<rsub|<text|<em|Sep>>>-t<rsub|<text|<em|Sep>>><rsub|>|)>+50\<cdot\>t<rsub|<text|<em|Sep>>>>|<cell|\<geqslant\>>|<cell|9000>>|<row|<cell|150\<cdot\><around*|(|w<rsub|<text|<em|Oct>>>-t<rsub|<text|<em|Oct>>><rsub|>|)>+50\<cdot\>t<rsub|<text|<em|Oct>>>>|<cell|\<geqslant\>>|<cell|11000>>|<row|<cell|w<rsub|<text|<em|May>>>>|<cell|=>|<cell|60>>|<row|<cell|w<rsub|<text|<em|Jun>>>>|<cell|=>|<cell|0.9\<cdot\>w<rsub|<text|<em|May>>>+t<rsub|<text|<em|May>>>>>|<row|<cell|w<rsub|<text|<em|Jul>>>>|<cell|=>|<cell|0.9\<cdot\>w<rsub|<text|<em|Jun>>>+t<rsub|<text|<em|Jun>>>>>|<row|<cell|w<rsub|<text|<em|Aug>>>>|<cell|=>|<cell|0.9\<cdot\>w<rsub|<text|<em|Jul>>>+t<rsub|<text|<em|Jul>>>>>|<row|<cell|w<rsub|<text|<em|Sep>>>>|<cell|=>|<cell|0.9\<cdot\>w<rsub|<text|<em|Aug>>>+t<rsub|<text|<em|Aug>>>>>|<row|<cell|w<rsub|<text|<em|Oct>>>>|<cell|=>|<cell|0.9\<cdot\>w<rsub|<text|<em|Sep>>>+t<rsub|<text|<em|Sep>>><htab|5mm>>>|<row|<cell|w<rsub|<text|<em|May>>>,w<rsub|<text|<em|Jun>>>,w<rsub|<text|<em|Jul>>>,w<rsub|<text|<em|Aug>>>,w<rsub|<text|<em|Sep>>>,w<rsub|<text|<em|Oct>>>>|<cell|\<geqslant\>>|<cell|0>>|<row|<cell|t<rsub|<text|<em|May>>>,t<rsub|<text|<em|Jun>>>,t<rsub|<text|<em|Jul>>>,t<rsub|<text|<em|Aug>>>,t<rsub|<text|<em|Sep>>>,t<rsub|<text|<em|Oct>>>>|<cell|\<geqslant\>>|<cell|0>>>>
    </eqnarray*>

    For each <math|c<rsub|i>>, it could be interpretted as\ 

    <\eqnarray*>
      <tformat|<table|<row|<cell|>|<cell|c<rsub|i>=3400\<cdot\>w<rsub|i>-1600\<cdot\>t<rsub|i>>|<cell|>>>>
    </eqnarray*>

    Now we have 12-variable vector <math|<around*|[|w<rsub|<text|<em|May>>>,t<rsub|<text|<em|May>>>,\<ldots\>,w<rsub|<text|<em|Oct>>>,t<rsub|<text|<em|Oct>>>|]>>.
    The matrix form of representing the constraints in (1) should be
    interpreted as inequality constraints <math|A\<cdot\>X\<leqslant\>b>
    together with equality constraints <math|A<rprime|'>\<cdot\>x=b<rprime|'>>,
    where <math|b=<matrix|<tformat|<table|<row|<cell|-8000>|<cell|-9000>|<cell|-7000>|<cell|-10000>|<cell|-9000>|<cell|-11000>>>>><rsup|T>>,
    <math|b<rprime|'>=<matrix|<tformat|<table|<row|<cell|60>|<cell|0>|<cell|0>|<cell|0>|<cell|0>|<cell|0>>>>><rsup|T>>,
    <math|X=<matrix|<tformat|<table|<row|<cell|w<rsub|<text|<em|May>>>>|<cell|t<rsub|<text|<em|May>>>>|<cell|\<cdots\>>|<cell|w<rsub|<text|<em|Oct>>>>|<cell|t<rsub|<text|<em|Oct>>>>>>>><rsup|T>>.
    In <math|A> and <math|A<rprime|'>>, each two columns represents a pair
    <math|w<rsub|i>> and <math|t<rsub|i>>, each row-<math|i> represents the
    negation of the total hours all workers would contribute in month
    <math|i>.

    And thus our objective function could be represented as follows:

    <\equation*>
      <text|Minimize \ >3400<big|sum><rsub|i>w<rsub|i>-1600<big|sum><rsub|i>t<rsub|i>\<nocomma\><text|,
      such that >A\<cdot\>x\<leqslant\>b,\<forall\>x<rsub|j>\<in\>X,x<rsub|j>\<geqslant\>0
    </equation*>

    <item>(5 points) Solve the linear program via Matlab's <strong|linprog>
    routine, and describe the optimal hiring strategy, along with the details
    of how you set up the problem in Matlab. (Type help linprog for details.)

    We have expressed the linear program in the matrix form
    <math|A\<cdot\>x\<leqslant\>b> and <math|A<rprime|'>\<cdot\>x=b<rprime|'>>.
    Matrix <math|A> and <math|A<rprime|'>> are expressed as follows
    respectively:

    <\eqnarray*>
      <tformat|<table|<row|<cell|A<rsub|6\<times\>12>>|<cell|=>|<cell|<with|font-base-size|8|<matrix|<tformat|<table|<row|<cell|-150>|<cell|100>|<cell|0>|<cell|0>|<cell|\<cdots\>>|<cell|0>|<cell|0>>|<row|<cell|0>|<cell|0>|<cell|-150>|<cell|100>|<cell|>|<cell|>|<cell|\<vdots\>>>|<row|<cell|\<vdots\>>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|\<ddots\>>|<cell|\<vdots\>>>|<row|<cell|0>|<cell|0>|<cell|0>|<cell|0>|<cell|\<cdots\>>|<cell|-150>|<cell|100>>>>>>>>|<row|<cell|A<rprime|'><rsub|6\<times\>12>>|<cell|=>|<cell|<with|font-base-size|8|<matrix|<tformat|<table|<row|<cell|1>|<cell|0>|<cell|0>|<cell|0>|<cell|0>|<cell|\<cdots\>>|<cell|0>|<cell|0>|<cell|0>|<cell|0>>|<row|<cell|-0.9>|<cell|-1>|<cell|1>|<cell|0>|<cell|0>|<cell|>|<cell|0>|<cell|0>|<cell|0>|<cell|0>>|<row|<cell|0>|<cell|0>|<cell|-0.9>|<cell|-1>|<cell|1>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|\<vdots\>>>|<row|<cell|\<vdots\>>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|>|<cell|\<ddots\>>|<cell|\<vdots\>>>|<row|<cell|0>|<cell|0>|<cell|0>|<cell|0>|<cell|\<cdots\>>|<cell|>|<cell|-0.9>|<cell|-1>|<cell|1>|<cell|0>>>>>>>>>>
    </eqnarray*>

    In <math|A>, each two columns represents a pair <math|w<rsub|i>> and
    <math|t<rsub|i>>, each row-<math|i> represents the neation of the total
    hours all workers contributed in that month. In <math|A<rprime|'>>, each
    three column represents <math|w<rsub|i-1>,t<rsub|i>> and <math|w<rsub|i>>
    for the reason that each month's total workers number consists of last
    month's 90 percent of last month's experienced workers and last month new
    workers who got trained. Also, since the total workers number for May has
    already known, it consists of itself.

    The resulting strategy computed by the linear programming is as follows:

    <\eqnarray*>
      <tformat|<table|<row|<cell|X>|<cell|=>|<cell|<with|font-base-size|7|<matrix|<tformat|<table|<row|<cell|60.00>>|<row|<cell|7.81>>|<row|<cell|61.80>>|<row|<cell|2.71>>|<row|<cell|58.34>>|<row|<cell|17.51>>|<row|<cell|70.02>>|<row|<cell|5.03>>|<row|<cell|68.06>>|<row|<cell|12.08>>|<row|<cell|73.33>>|<row|<cell|0.00>>>>>>>>>>
    </eqnarray*>

    which means we could arrange 7.81, 2.71, 17.51, 5.03, 12.08 and 0
    experienced works for training from May to Octorber respectively. And the
    overall minimal cost for employing in these 6 months is <math|1259100>.

    <\session|matlab|default>
      \;
    </session>
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
      <with|par-left|<quote|1.5fn>|Problem 1
      <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-1>>
    </associate>
  </collection>
</auxiliary>