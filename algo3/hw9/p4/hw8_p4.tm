<TeXmacs|1.0.7.14>

<style|generic>

<\body>
  <doc-data|<doc-title|CS157 Homework 9>|<doc-author|<\author-data|<author-name|Silao_xu
  and Ccwang>>
    \;
  </author-data>>>

  <\enumerate>
    <item>(15 points) Consider a version of the ``maximum matching'' problem,
    where there are <math|n\<geqslant\>100> people on the left, 100 people on
    the right, <with|color|blue|certain> pairs of them are willing to get
    married (``matched''), no one can get married twice, and we want to match
    the maximal number of people so that we end up with 100 marriages.

    Recall from class that you can set this up as a max-flow problem, by
    considering the people as a graph with 1 unit of capacity along each edge
    connecting a person on the left to a person they are willing to marry on
    the right; additionally, each person on the left has an edge from the
    source <math|s> with capacity 1 (representing the constraint that each
    person on the left can have at most 1 marriage), and each person on the
    right has an edge going to the sink <math|t> with capacity 1
    (representing the constraint that each person on the right can have at
    most 1 marriage). The algorithm works by first running one of the maximum
    flow algorithms we have seen in class, and then marrying any two people
    that have flow between them.\ 

    For this part, modify this construction so that it solves the problem
    with the additional constraint: the first 40 people on the left <em|must>
    get married. Prove that your construction is a correct algorithm.\ 

    Please include a diagram. Your proof should be sure to touch on the
    following points: 1) any assignment returned by your algorithm is a valid
    marriage plan; in particular, be sure to point out that integer
    capacities on edges implies that the flow returned by the algorithms from
    class will have integer values; 2) any marriage plan could be converted
    into a flow that satisfies the constraints you describe, proving that
    your algorithm does not ``miss out'' on any good marriage plans.

    <\itemize>
      <item>Given bipartite graph <math|B=<around*|(|A\<cup\>B,E|)>> in
      <em|Diagram 1>, we have the following notation,\ 

      <\eqnarray*>
        <tformat|<table|<row|<cell|A>|<cell|=>|<cell|P\<cup\>Q, <text|
        represents the <math|n> people on the
        left>>>|<row|<cell|P>|<cell|=>|<cell|<text|the 40 people on the left
        we ensure they <em|must> get married>>>|<row|<cell|Q>|<cell|=>|<cell|<text|the
        other <math|n-40> people on the left>>>|<row|<cell|B>|<cell|=>|<cell|<text|the
        100 people on the right>>>>>
      </eqnarray*>

      such that very people in <math|A> has at least 1 directed edge going
      into <math|B> with capacity 1 and also every vertice in <math|B> has at
      least one edge directing into it from <math|A> with capacity 1.\ 

      We add new vertices <math|s> and <math|t>, then we add an edge from
      <math|s> to every vertex in <math|P> and add an edge from every vertex
      in <math|B> to <math|t>. Make all the edge capacities 1. We add new
      vertice <math|s<rprime|'>> and add an edge from <math|s> to
      <math|s<rprime|'>> with capacity 60 and edges from <math|s<rprime|'>>
      directing into every vertice in <math|Q> with capacity 1. The resulting
      graph <math|G> is shown in <em|Diagram 2>.

      <item>Now we are going to prove after solving the maximum network flow
      problem on graph <math|G>, we will get the maximum marriages and the
      first 40 people on the left <em|must> get married.

      \;
    </itemize>

    <item>(10 points) Consider the (apparently very different though actually
    very similar) problem of scheduling weekly TA office hours in a course.
    Suppose there are n TAs on the course staff and <math|m> non-overlapping
    one-hour slots throughout the week during which TAs may hold office
    hours; however, no more than one TA can be assigned to each hour. Each TA
    <math|i> is available only during some subset
    <math|T<rsub|i>\<subseteq\><around*|{|1,\<ldots\>,m|}>> of the weekly
    slots; further, each TA has to hold at least 2 hours every week. Your
    task is to assign TA staff to TA hours in a way that satisfies all
    aforementioned constraints.

    <strong|Hint>: Design your algorithm as an adaptation of your algorithm
    for the previous part, using a max-flow algorithm as a subroutine (how do
    each of the elements of this problem correspond with elements from the
    problem of the previous part?). You might want to first consider the
    problem without the constraint that each TA must cover at least two
    hours.\ 

    Include a proof of correctness, though feel free to make use of concepts
    from the previous part to avoid repeating yourself.\ 

    Also, analyze the run time of your algorithm here in terms of n and m.
    You might want to check <strong|http://en.wikipedia.org/wiki/Maximum_flow_problem#Solutions>
    for reference on the running time of max-flow algorithms.
  </enumerate>
</body>

<\initial>
  <\collection>
    <associate|page-type|letter>
  </collection>
</initial>