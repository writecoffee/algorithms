<TeXmacs|1.0.7.19>

<style|generic>

<\body>
  <doc-data|<doc-title|CS157 Homework 8>|<doc-author|<author-data|<author-name|Silao_xu
  and Tc28>>>>

  <subsubsection|Problem 5>

  <strong|Duality>:

  <\enumerate>
    <item>Namely, recall from lecture that the dual to our linear program is:
    <math|<text|max><rsub|y>b<rsup|T>\<cdot\>y> subject to the constraints
    <math|A<rsup|T>\<cdot\>y=u<rsup|T>> and <math|y\<geqslant\>0> (the
    unbounded variables <math|x> correspond to equality constraints under
    duality). Show that the coefficients <math|<around*|{|y<rsub|i>|}>><emdash>that
    we found in our physics thought experiment above<emdash>make everything
    work out:

    <\enumerate>
      <item>show that <math|{y<rsub|i>}> is a feasible solution to the dual
      linear program

      Based on the fact from the physics intution, we have
      <math|y<rsub|1>A<rsub|1>+\<ldots\>+y<rsub|m>A<rsub|m>=u>, there is the
      constraints such that <math|A<rsup|T>\<cdot\>y=u>. Based on the fact
      that <math|y<rsub|1>,\<ldots\>y<rsub|m>> are all non-negative, the
      constraint that in dual program<emdash><math|y\<geqslant\>0> could be
      satisfied. So, we can draw conclusion that
      <math|<around*|{|y<rsub|i>|}>> is a feasible solution to the dual
      linear program.

      <item>show that the objective value of <math|{y<rsub|i>}> in the dual
      linear program <em|equals> the optimal objective value of the original
      linear program, <math|u\<cdot\>x<rsup|\<ast\>>>

      For the constraints that passes through <math|x<rsup|\<ast\>>>, we have
      <math|A<rsub|i>\<cdot\>x<rsup|\<ast\>>=b<rsup|i>>. Suppose we have a
      coefficients <math|<around*|{|y<rsub|i><rsup|\<ast\>>|}>> such that
      <math|y<rsup|\<ast\>><rsub|i>\<gtr\>0>, then left-multiplying
      <math|y<rsup|\<ast\>><rsup|T>> in both side of
      <math|A\<cdot\>x<rsup|\<ast\>>=b>, we get

      <\eqnarray*>
        <tformat|<table|<row|<cell|y<rsup|\<ast\>T>\<cdot\>A\<cdot\>x<rsup|\<ast\>>>|<cell|=>|<cell|y<rsup|\<ast\>T>\<cdot\>b>>|<row|<cell|A<rsup|T>\<cdot\>y<rsup|\<ast\>>\<cdot\>x<rsup|\<ast\>>>|<cell|=>|<cell|b<rsup|T>\<cdot\>y<rsup|\<ast\>>>>|<row|<cell|u\<cdot\>x<rsup|\<ast\>>>|<cell|=>|<cell|b<rsup|T>\<cdot\>y<rsup|\<ast\>><htab|5mm><around*|(|1|)>>>>>
      </eqnarray*>

      For any coefficients <math|<around*|{|y<rsub|i>|}>> that is a feasible
      solution to the dual linear program which has
      <math|A<rsub|i>\<cdot\>x\<geqslant\>b<rsub|i>>, left-multiplying
      <math|y<rsup|T>> in both side of the contraints of primal LP, we have\ 

      <\eqnarray*>
        <tformat|<table|<row|<cell|y<rsup|T>\<cdot\>A\<cdot\>x>|<cell|\<geqslant\>>|<cell|y<rsup|T>\<cdot\>b>>|<row|<cell|<around*|(|y<rsup|T>\<cdot\>A\<cdot\>x|)><rsup|T>>|<cell|\<geqslant\>>|<cell|<around*|(|y<rsup|T>\<cdot\>b|)><rsup|T>>>|<row|<cell|x<rsup|T>\<cdot\><around*|(|A<rsup|T>\<cdot\>y|)>>|<cell|\<geqslant\>>|<cell|b<rsup|T>\<cdot\>y>>|<row|<cell|x<rsup|T>\<cdot\>u<rsup|T>>|<cell|\<geqslant\>>|<cell|b<rsup|T>\<cdot\>y>>|<row|<cell|u\<cdot\>x>|<cell|\<geqslant\>>|<cell|b<rsup|T>\<cdot\>y<htab|5mm><around*|(|2|)>>>>>
      </eqnarray*>

      Plugging <math|x<rsup|\<ast\>>> into the left-hand side of (2), we have
      <math|u\<cdot\>x<rsup|\<ast\>>\<geqslant\>b<rsup|T>\<cdot\>y>,
      substituting <math|u\<cdot\>x<rsup|\<ast\>>> with
      <math|y<rsup|\<ast\>>\<cdot\>b<rsup|T>> according to (1), we get the
      upper bound for the dual LP as follows

      <\eqnarray*>
        <tformat|<table|<row|<cell|y<rsup|\<ast\>>\<cdot\>b<rsup|T>>|<cell|\<geqslant\>>|<cell|y\<cdot\>b<rsup|T><htab|5mm><around*|(|3|)>>>>>
      </eqnarray*>

      Since <math|u\<cdot\>x<rsup|\<ast\>>> is the lower bound for the primal
      linear program, which has been already known, and
      <math|y<rsup|\<ast\>>\<cdot\>b<rsup|T>> is the upper bound for the dual
      linear program and plus the equality (1), <em|Duality> <em|Theorem>
      proved here.

      <item>summarize what you have found.

      For the primal LP, let <math|<text|<em|OPT> >= <text|Maximize
      >C<rsup|T>x>, <em|s.t.>, <math|A x\<leqslant\>b>,
      <math|\<forall\>x<rsub|i>\<in\>x,x<rsub|i>\<geqslant\>0>. For the dual
      LP, let <math|<text|<em|OPT>><rsup|\<ast\>>= <text|Minimize
      >b<rsup|T>y>, <em|s.t.>, <math|A<rsup|T>y\<geqslant\>C>,
      <math|\<forall\>y<rsub|i>\<in\>y,y<rsub|i>\<geqslant\>0>.

      When <em|OPT><math| = +\<infty\>> and thus on its counterpart, the dual
      LP is infeasible; when primal LP is infeasible,
      <math|<text|<em|OPT>><rsup|\<ast\>>=-\<infty\>> and <em|vice versa>.

      When <math|<text|<em|OPT>>\<in\>R>,
      <math|<text|<em|OPT>><rsup|\<ast\>>> also is within <math|R>, their
      boundary coincide.
    </enumerate>

    <item>We consider randomized strategies for the players. Suppose that
    you, the row player, know that the column player picks rock with
    probability 0.5, paper with probability 0.2, and scissors with
    probability 0.3, then your <em|expected payoff> for each of your three
    strategies may be found by taking 0.5 times the first column of <math|A>,
    plus 0.2 times the second column of <math|A>, plus 0.3 times the third
    column of <math|A>, which equals <math|<matrix|<tformat|<table|<row|<cell|0.1>|<cell|0.2>|<cell|-0.3>>>>><rsup|T>>,
    meaning that you could make expected profit of 0.1 by choosing rock all
    the time, 0.2 by choosing paper all the time, or <math|-0.3> by choosing
    scissors all the time. To express this slightly more in the language of
    linear programming, the entry 0.1 guarantees you an expected profit of at
    least 0.1, regardless of the other entries of the matrix, etc. Given
    these choices, you will presumably choose paper, for an expected profit
    of 0.2. Your opponent wants to minimize your profit.

    <\enumerate>
      <item>(7 points) Assume the framework outlined above, where your
      opponent<emdash>the column player<emdash>declares a probability
      distribution on columns, and then you choose the best row to play.
      Write a linear program that your opponent could solve to choose the
      distribution on columns that would minimize your expected profit in
      this interaction. <strong|Explain> how it works.

      Firstly, we lable the column player's probabilities of choosing rock,
      pocket and scissor to be <math|r<rsub|c>,p<rsub|c>,s<rsub|c>> and thus
      the <em|expected payoff> for column player's three strategies could be
      computed as <math|A\<cdot\><matrix|<tformat|<table|<row|<cell|r<rsub|c>>>|<row|<cell|p<rsub|c>>>|<row|<cell|s<rsub|c>>>>>>>,
      which is equivalent to <math|<matrix|<tformat|<table|<row|<cell|-p<rsub|c>+s<rsub|c>>>|<row|<cell|r<rsub|c>-s<rsub|c>>>|<row|<cell|-r<rsub|c>+p<rsub|c>>>>>>>,
      we name it as matrix <math|B>. For row player, his/her strategy is
      choossing the maximum <em|expected payoff> from row of <math|B>. As
      oppose to the row player, we know the opponent could solve to choose
      the distribution on columns that would minimize row player's expected
      profit in this interaction and therefore the objective function could
      be written as

      <\eqnarray*>
        <tformat|<table|<row|<cell|<text|Minimize
        \ >w>|<cell|=>|<cell|<text|max><around*|(|-p<rsub|c>+s<rsub|c>,r<rsub|c>-s<rsub|c>,-r<rsub|c>+p<rsub|c>|)><htab|5mm><around*|(|1|)>>>>>
      </eqnarray*>

      We let the maximum-<em|expected payoff> choice of row player to be
      <math|w> and now the objecive function becomes minimizing
      <math|C\<cdot\>X>, where <math|X=<matrix|<tformat|<table|<row|<cell|r<rsub|c>>|<cell|p<rsub|c>>|<cell|s<rsub|c>>|<cell|w>>>>><rsup|T>>
      and <math|C=<matrix|<tformat|<table|<row|<cell|0>|<cell|0>|<cell|0>|<cell|1>>>>>>
      and the constraints could be interpreted as follows

      <\eqnarray*>
        <tformat|<table|<row|<cell|-p<rsub|c>+s<rsub|c>-w>|<cell|\<geqslant\>>|<cell|0<htab|5mm><around*|(|2|)>>>|<row|<cell|r<rsub|c>-s<rsub|c>-w>|<cell|\<geqslant\>>|<cell|0>>|<row|<cell|-r<rsub|c>+p<rsub|c>-w>|<cell|\<geqslant\>>|<cell|0>>|<row|<cell|r<rsub|c>+p<rsub|c>+s<rsub|c>>|<cell|=>|<cell|1>>|<row|<cell|r<rsub|c>,p<rsub|c>,s<rsub|c>,w>|<cell|\<geqslant\>>|<cell|0>>>>
      </eqnarray*>

      The matrix form for representing the constraints in (2) could be
      interpretted as inequality constraints <math|B\<cdot\>X\<leqslant\>b>
      together with equality constraints <math|B<rprime|'>\<cdot\>X=b<rprime|'>>,
      where <math|b=<around*|[|0,0,0|]><rsup|T>>,
      <math|b<rprime|'>=<around*|[|1|]>>,
      <math|B=<matrix|<tformat|<table|<row|<cell|0>|<cell|-1>|<cell|1>|<cell|-1>>|<row|<cell|1>|<cell|0>|<cell|-1>|<cell|-1>>|<row|<cell|-1>|<cell|1>|<cell|0>|<cell|-1>>>>>>,
      <math|B<rprime|'>=<matrix|<tformat|<table|<row|<cell|1>|<cell|1>|<cell|1>|<cell|0>>>>>>,
      where <math|r<rsub|c>,p<rsub|c>,s<rsub|c>\<geqslant\>0>.

      So, the linear problem is represented as

      <\eqnarray*>
        <tformat|<table|<row|<cell|<text|Minimize \ >C\<cdot\>X,<text|
        <em|s.t.>>>|<cell|>|<cell|>>|<row|<cell|B\<cdot\>X>|<cell|\<geqslant\>>|<cell|b>>|<row|<cell|B<rprime|'>\<cdot\>X>|<cell|=>|<cell|b<rprime|'><htab|5mm>\<forall\>x<rsub|i>\<in\>X,x<rsub|i>\<geqslant\>0>>>>
      </eqnarray*>

      <item>(3 points) Take the dual of this linear program, and explain how
      it solves the same problem as above but with the roles of the two
      players swapped.

      We define <math|B<rsub|r>> as <math|<matrix|<tformat|<table|<row|<cell|B>>|<row|<cell|B<rprime|'>>>>>><rsup|T>>,
      multiplying <math|B<rsub|r>> by new variables vector
      <math|Y=<matrix|<tformat|<table|<row|<cell|r<rsub|r>>|<cell|p<rsub|r>>|<cell|s<rsub|r><rsub|>>|<cell|w<rsub|r>>>>>><rsup|T>>,
      <math|\<forall\>y<rsub|i>\<in\>Y,y<rsub|i>\<geqslant\>0>, we know that
      each row of the resulting matrix forming the coefficients for the
      original <math|X> in objective function, <math|C>, which should be no
      bigger than <math|C>. So we have the following new constraints\ 

      <\eqnarray*>
        <tformat|<table|<row|<cell|p<rsub|r>-s<rsub|r>>|<cell|\<leqslant\>>|<cell|w<rsub|r><htab|5mm><around*|(|3|)>>>|<row|<cell|-r<rsub|r>+s<rsub|r>>|<cell|\<leqslant\>>|<cell|w<rsub|r>>>|<row|<cell|r<rsub|r>-p<rsub|r>>|<cell|\<leqslant\>>|<cell|w<rsub|r>>>|<row|<cell|-r<rsub|r>-p<rsub|r>-s<rsub|r>>|<cell|\<leqslant\>>|<cell|1>>>>
      </eqnarray*>

      Multiplying <math|b<rsup|T>> by <math|Y>, we get the new objective
      function as follows, which strives to find the best possible lower
      bound\ 

      <\eqnarray*>
        <tformat|<table|<row|<cell|<text|Maximize
        \ >w<rsub|r>>|<cell|>|<cell|>>>>
      </eqnarray*>

      As the role of the two players swapped, the problem becomes

      <\eqnarray*>
        <tformat|<table|<row|<cell|<text|Maximize
        \ >b<rsup|T>\<cdot\>Y,<text| <em|s.t.>>>|<cell|>|<cell|>>|<row|<cell|B<rsub|r>\<cdot\>Y>|<cell|\<leqslant\>>|<cell|C<htab|5mm>\<forall\>y<rsub|i>\<in\>Y,y<rsub|i>\<geqslant\>0>>>>
      </eqnarray*>

      The left-hand side of (3) is equivalent to
      <math|A\<cdot\><matrix|<tformat|<table|<row|<cell|r<rsub|r>>|<cell|p<rsub|r>>|<cell|s<rsub|r>>>>>><rsup|T>>,
      and <math|w<rsub|r>> is interpreted as
      <math|<text|max><around*|(|p<rsub|r>-s<rsub|r>,-r<rsub|r>+s<rsub|r>,r<rsub|r>-p<rsub|r>|)>>
      and thus the problem is interpreted as choosing the best strategy which
      would maximize <em|expected payoff> for row player himself/herself.

      <item>(5 points) Because these two linear programs are dual, the linear
      programming duality theorem says that they have the <em|same> optimal
      objective value. Consider the following process: you solve the linear
      program from part b) and choose a row according to that probability
      distribution, and your opponent solves the linear program from part a)
      and chooses a column according to that probability distribution.
      Conclude that both players would be happy to play like this, that
      neither can make more profit by changing her strategy.

      (This pair of probabilistic strategies is called a <em|Nash
      equilibrium>, and we have shown its existence here, and found it, by
      the power of linear programming duality.)

      Based on <em|Duality Theorem>, problems in a) and b) are dual problem
      to each other and thus they have the same optimum <em|expected payoff>.\ 

      From column player's perspective, the strategy guarantees that the row
      player's <em|expected payoff> would be at most <math|E>. On the other
      hand, from row player's perspective, his/her strategy guarantees that
      his/her own <em|expected payoff> would be at least <math|E>. So they
      are happy to play like this and <math|E> would be 0, the possibilities
      of these 3 choices would be <math|<frac|1|3>> equally. From here, we
      could draw a conclusion that neither can make more profit by changing
      his/her strategy.\ 
    </enumerate>

    \;

    \;
  </enumerate>

  \;

  \;
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
      <with|par-left|<quote|3fn>|Problem 5
      <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-1>>
    </associate>
  </collection>
</auxiliary>