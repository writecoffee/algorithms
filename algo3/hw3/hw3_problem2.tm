<TeXmacs|1.0.7.4>

<style|generic>

<\body>
  <doc-data|<doc-title|CS157 Homework 3>|<\doc-author-data|<author-name|Silao_Xu>>
    \;
  </doc-author-data>>

  <section|Problem 2>

  Given a tree with <math|n> vertices that has weighted edges, and a positive
  integer <math|k>, we would like to find a path (that does not use any
  vertex more than once) of length <math|k> in the tree, whose sum of edge
  weights is maximal. Recall that the length of a path is the number of edges
  in that path.

  Over the course of the following steps, we will devise an <math|O(n log n)>
  algorithm for this problem, that uses a mix of divide-and-conquer and
  dynamic programming. (There is a simpler algorithm that takes time
  <math|O(n k)>, but that is not what we are aiming for.) For each of the
  following parts that asks for an algorithm, a proof of correctness and
  running time complexity is also needed.\ 

  <\enumerate-numeric>
    <item><with|color|dark-gray|Suppose you have a rooted tree with <math|n>
    vertices. Design an <math|O(n)> algorithm that finds the best (that is,
    the maximal weight) path of length <math|k> that starts at the root, and
    goes down from there. (Hint: dynamic programming.)>

    <\with|color|blue>
      Define <math|M<rsub|v, k>> as the maxium weight for the length-<math|k>
      path which starts from node <math|v>. The problem could be divided into
      sub-problem for computing <math|M<rsub|u,k-1>> for all children of node
      <math|v> then adding the weight of edge <math|(u, v)>, we then pick the
      biggest one. The recursion could be written as follows:

      <\equation*>
        M<rsub|v, k> = <choice|<tformat|<table|<row|<cell|0>|<cell|(k=0)>>|<row|<cell|-\<infty\>>|<cell|(k
        \<gtr\> 0 and v is leaf node)>>|<row|<cell|<below|max|for every child
        u of v><rsub|><left|{>M<rsub|u, k-1> +w<rsub|v,
        u><left|}>>|<cell|(k\<gtr\>0 and v is not leaf node)>>>>> \ 
      </equation*>

      Pseudocode is as follows:

      <\with|font-base-size|8>
        <with|font-base-size|9|<\code>
          let <math|M> be 2-dimension <math|N\<times\>k> table

          <em|HeaviestPath>(<math|v>, <math|k>):

          \ \ \ \ if <math|k=0> then:

          \ \ \ \ \ \ \ \ <math|M[v, k] \<leftarrow\>0>

          \ \ \ \ \ \ \ \ return 0

          \ \ \ \ <math|m\<leftarrow\> -\<infty\>>, <math|t\<leftarrow\>0>

          \ \ \ \ for each child <math|u> of <math|v> do:

          \ \ \ \ \ \ \ \ if <math|M[u, k-1] \<neq\>-\<infty\>> then do:

          \ \ \ \ \ \ \ \ \ \ \ \ <math|t\<leftarrow\>M[u, k-1]+w(v, u)>

          \ \ \ \ \ \ \ \ else:

          \ \ \ \ \ \ \ \ \ \ \ \ <math|t\<leftarrow\>><with|font-shape|italic|HeaviestPath>(<math|u>,
          <math|k-1>)<math|+w(v,u)>

          \ \ \ \ \ \ \ \ if <math|t \<gtr\> m> then do:

          \ \ \ \ \ \ \ \ \ \ \ \ <math|m\<leftarrow\>t>

          \ \ \ \ return <math|m>
        </code>>
      </with>

      We know that a tree is a special graph which contains no cycle. Also,
      as what the problem specifies, we only need consider directed path
      which starts from the root. Let the tree as graph <math|G<rsub|N, V>>
      Since all nodes will be touched at most once, the computation time
      would not exceed <math|\|V\|>, which is <math|N-1> in this case. So the
      time complexity would be <math|O(n)>.
    </with>

    <item>Suppose <strong|for this part only> that the root of the tree has
    exactly two children. Modify your algorithm above so that it now finds
    the best path of length <math|k> that passes through the root. (It can
    start or end at the root, or pass through it as an intermediate node.)
    This algorithm should also take <math|O(n)> time.

    Define <math|M<rsub|v, k>> as the maxium weight for the length-<math|k>
    path which starts from node <math|v>. As special case, because the root
    has exactly 2 children The problem could be divided into sub-problem for
    computing <math|M<rsub|u,k-1>> for all children of node <math|v> then
    adding the weight of edge <math|(u, v)>, we then pick the biggest one.
    The recursion could be written as follows:

    <\with|font-base-size|8>
      <with|color|blue|<\equation*>
        M<rsub|v, k> = <choice|<tformat|<table|<row|<cell|0>|<cell|(k=0)>>|<row|<cell|-\<infty\>>|<cell|(k
        \<gtr\> 0 and v =leaf node)>>|<row|<cell|max<left|{><below|<above|max|k>|l=1><rsub|>{M<rsub|x,
        l> +w<rsub|v, x>+M<rsub|y, k-l>+w<rsub|v, y>},
        M<rsub|x,k>,M<rsub|y,k><left|}>>|<cell|(k\<gtr\>0 and v
        =<with|font-base-size|8|>root)>>|<row|<cell|<below|max|for every
        child u of v><rsub|>(M<rsub|u, k-1> +w<rsub|v, u>)>|<cell|(k\<gtr\>0
        and v \<neq\>leaf node and v \<neq\>root)>>>>> \ 
      </equation*>>
    </with>

    \;

    <item>Now solve the previous part without restricting the number of
    children of the root. The algorithm should still take <math|O(n)> running
    time. <strong|Warning or hint>: Make sure your path does not use any
    vertices more than once; check that the starting vertex and the ending
    vertex of the path do not belong to the same subtree of the root.

    <\with|font-base-size|9>
      <with|font-base-size|8|<\equation*>
        <with|color|blue|M<rsub|v, k> = <choice|<tformat|<cwith|5|5|1|1|cell-rborder|>|<cwith|2|2|1|1|cell-halign|r>|<cwith|4|4|1|1|cell-halign|r>|<cwith|7|7|1|1|cell-halign|r>|<table|<row|<cell|0>|<cell|>|<cell|(k=0)>>|<row|<cell|>|<cell|>|<cell|>>|<row|<cell|-\<infty\>>|<cell|>|<cell|(k
        \<gtr\> 0 and v =leaf node)>>|<row|<cell|>|<cell|>|<cell|>>|<row|<cell|max<left|{><below|max|every
        x, \ y><left|(><below|<above|max|k>|l=1><rsub|>{M<rsub|x, l>
        +w<rsub|v, x>+M<rsub|y, k-l>+w<rsub|v, y>}<right|)>,
        >|<cell|>|<cell|>>|<row|<cell| \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ <below|max|for
        every child u><left|(>M<rsub|u, k-1> +w<rsub|v,
        u><right|)><left|}>>|<cell|>|<cell|(k\<gtr\>0 and v
        =<with|font-base-size|8|>root)>>|<row|<cell|>|<cell|>|<cell|>>|<row|<cell|<below|max|for
        every child u of v><rsub|>(M<rsub|u, k-1> +w<rsub|v,
        u>)>|<cell|>|<cell|(k\<gtr\>0 and v \<neq\>leaf node and v
        \<neq\>root)>>>>> \ >
      </equation*>>
    </with>

    <item>Prove that for any given tree with <math|n> vertices, there is a
    vertex that, if we remove it, splits the tree into several smaller trees
    where each of these remaining trees has at most <math|<frac|n|2>>
    vertices.

    <item>Find a <math|O(n)> algorithm that finds such a vertex. (Hint:
    dynamic programming. Note that one way to solve the previous part is to
    come up with an algorithm for this part and then prove that the output
    satisfies the conditions of the previous part.)

    <item>Use the previous two algorithms you have constructed to design an
    <math|O(n log n)> <em|divide-andconquer> algorithm that solves our
    problem, finding the maximal-weight path of length k in the tree.\ 

    <strong|Note>: You do not have to solve parts 3 and 5 to get credit for
    part 6: in part 6 you may assume that algorithms for parts 3 and 5 exist
    and they work correctly as indicated.
  </enumerate-numeric>

  \;
</body>

<\initial>
  <\collection>
    <associate|page-breaking|sloppy>
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
      <vspace*|1fn><with|font-series|<quote|bold>|math-font-series|<quote|bold>|Problem
      2> <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-1><vspace|0.5fn>
    </associate>
  </collection>
</auxiliary>