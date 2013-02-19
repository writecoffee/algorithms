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
        <with|color|blue|M<rsub|v, k> = <choice|<tformat|<cwith|5|5|1|1|cell-rborder|>|<cwith|2|2|1|1|cell-halign|r>|<cwith|4|4|1|1|cell-halign|r>|<cwith|7|7|1|1|cell-halign|r>|<cwith|8|8|3|3|cell-valign|b>|<cwith|9|9|3|3|cell-valign|t>|<cwith|8|8|1|1|cell-valign|b>|<table|<row|<cell|0>|<cell|>|<cell|<with|font-base-size|7|(k=0)>>>|<row|<cell|>|<cell|>|<cell|>>|<row|<cell|-\<infty\>>|<cell|>|<cell|<with|font-base-size|7|(k
        \<gtr\> 0 and v =leaf node)>>>|<row|<cell|>|<cell|>|<cell|>>|<row|<cell|max<left|{><below|max|every
        children pari x, \ y of v><left|(>{M<rsub|x, l> +w<rsub|v,
        x>+M<rsub|y, k-l>+w<rsub|v, y>}<right|)>,
        >|<cell|>|<cell|>>|<row|<cell|<htab|5mm><htab|5mm><below|max|for
        every child u><left|(>M<rsub|u, k-1> +w<rsub|v,
        u><right|)><left|}>>|<cell|>|<cell|<with|font-base-size|7|(k\<gtr\>0
        and v =root)>>>|<row|<cell|>|<cell|>|<cell|<with|mode|text|>>>|<row|<cell|<below|max|for
        every child u of v><rsub|>(M<rsub|u, k-1> +w<rsub|v,
        u>)>|<cell|>|<cell|<with|font-base-size|7|(k\<gtr\>0 and v
        \<neq\>leaf >>>|<row||<cell|>|<cell|<htab|5mm>and v \<neq\>root)>>>>>
        \ >
      </equation*>>
    </with>

    <item>Prove that for any given tree with <math|n> vertices, there is a
    vertex that, if we remove it, splits the tree into several smaller trees
    where each of these remaining trees has at most <math|<frac|n|2>>
    vertices.

    <\enumerate-alpha>
      <\with|color|blue>
        <item>Firstly, we prove the <with|font-shape|italic|Lemma>: picking
        any specific node as root <math|r>, there would be no more than one
        subtree which contains <math|\<geqslant\><frac|n|2>> nodes.

        <strong|<em|Proof>:>

        Given a tree graph <math|T> with <math|n> vertices, we define
        <math|S(r)> to be the number of nodes contained in subtree-<math|r>,
        <math|r> is any specific node chosen to be the root for tree
        <math|T>.

        We assume that there are 2 subtrees, <math|t<rsub|1>> and
        <math|t<rsub|2>>, which contains <math|S(t<rsub|1>)> and
        <math|S(t<rsub|2>)> number of nodes, where <math|S(t<rsub|1>),
        S(t<rsub|2>) \<geqslant\><frac|n|2>> respectively. So there would be
        <math|S(t<rsub|1>)+S(t<rsub|2>) \<geqslant\><frac|n|2>\<times\>2=n>
        for subtrees of <math|r>, resulting <math|1+n> nodes, plusing node
        <math|r>, for the tree given.

        This leads to a contradiction. So our original assumption that there
        would be more than 1 subtree could have more than <math|<frac|n|2>>
        nodes was wrong, and there must be at most one subtree which can
        exceed <frac|n|2> number of nodes.

        <item>We now prove that for any given tree with <math|n> vertices,
        there is a vertex that, if we remove it, splits the tree into several
        smaller trees where each of these remaining trees has at most
        <math|<frac|n|2>> vertices.

        <strong|<em|Proof>:>

        We define the above problem as <math|P(r)>.

        Given a tree graph <math|T> with <math|n> vertices. We define
        <math|S(v)> to be the number of nodes contained in subtree
        <math|T<rsub|v>> which starts from root <math|v>. Let <math|r> be an
        arbitrary vertex chosen to be the root of <math|T> and there exists a
        subtree <math|T<rsub|e>>, where vertex <math|e> is the root, of
        <math|T<rsub|r>> such that <math|S(T<rsub|e>)\<gtr\><frac|n|2>>.

        Now we choose <math|e> as the new root, the new <math|S(r)> computed
        would be the number of nodes <math|r> plus all other subtrees of
        <math|r> except <math|T<rsub|e>>, which would be either
        <math|\<less\><frac|n|2>> or <math|=<frac|n|2>>.

        <with|font-shape|italic|Case 1> (<math|new S(T<rsub|r>)=<frac|n|2>>)

        The resulting new subtree <math|T<rsub|r>> of <math|T<rsub|e>> has
        the property that <math|S<rsub|>(r)=<frac|n|2>>. According to the
        <with|font-shape|italic|lemma> we have proven in part (a), the number
        of nodes contained by other subtrees of <math|T<rsub|r>> would be all
        <math|\<less\> <frac|n|2>>. So we could find vertex <math|e>, such
        that if we remove it the remaining smaller trees has at most
        <math|<frac|n|2>> vertices.

        <with|font-shape|italic|Case 2> (<math|new
        S(T<rsub|r>)\<less\><frac|n|2>>)

        Among all other subtrees of <math|T<rsub|e>>, let the one contains
        the most number of nodes be <math|m>,
        <math|S(T<rsub|m>)\<leqslant\>S(T<rsub|e>)-1>. <math|S(T<rsub|m>)>
        would be<math|\<less\><frac|n|2>>, <math|=<frac|n|2>> or
        <math|\<gtr\><frac|n|2>>.

        <\enumerate-roman>
          <item>If <math|S(T<rsub|m>)=<frac|n|2>>, then according the
          <with|font-shape|italic|lemma> we have proven in part (a),
          \ <math|S(r)> must be <math|\<less\><frac|n|2>>.\ 

          <item>If <math|S(T<rsub|m>)\<less\><frac|n|2>>, then since
          <math|S(r)\<less\><frac|n|2>> in this case, we have found an vertex
          <math|e> such that each of its subtree has less than <frac|n|2>
          number of nodes.

          <item>If <math|S(T<rsub|m>)\<gtr\><frac|n|2>>, then we'll choose
          <math|m> as a new root. The new subtree <math|T<rsub|e>> for root
          <math|m> would be <math|\<geqslant\>S(T<rsub|r>)+1>. All subtree
          for new root <math|m> except <math|T<rsub|e>> would be
          <math|\<leqslant\>S(T<rsub|m>)-1>.
        </enumerate-roman>

        So there is always one new subtree keeps increasing, that is the new
        subtree <math|T<rsub|e>> for the new tree <math|T<rsub|m>>, the
        number of vertices within that subtree and always one subtree keep
        decreasing. It will ends up that the increasing side reach
        <math|<frac|n|2>>, the decreasing side reaches <frac|n|2> or both
        side reach <math|\<less\><frac|n|2>>.
      </with>
    </enumerate-alpha>

    <item>Find a <math|O(n)> algorithm that finds such a vertex. (Hint:
    dynamic programming. Note that one way to solve the previous part is to
    come up with an algorithm for this part and then prove that the output
    satisfies the conditions of the previous part.)

    <\with|color|blue>
      Firstly, randomly pick one vertex as the root <math|r>. Recurse on
      <math|r> to compute nodes contained in the subtree-<math|r>. We define
      <math|S(r)> to be the number of nodes contained in subtree-<math|r> and
      the recursion could be expressed as follows:

      <\equation*>
        S(r) = <choice|<tformat|<table|<row|<cell|>|<cell|1>|<cell|r is leaf
        node>>|<row|<cell|<rsub|>>|<cell|1+<big|sum><rsub|every child
        t>S(t)>|<cell|r is not leaf node>>>>>
      </equation*>

      Let <math|v> be the current root picked to be check. Let <math|s> be
      the child of <math|v> who contains the maximum number of nodes,
      <math|S<rsub|max>(v)>, in its subtree among all children of <math|v>.
      The recursion could be written as follows:

      <\equation*>
        <with|font-shape|italic|FindVertex>(v) =
        <choice|<tformat|<table|<row|<cell|FindVertex(s)>|<cell|>|<cell|S<rsub|max>(v)\<gtr\>\<lceil\><frac|n|2>\<rceil\>>>|<row|<cell|<rsub|>v>|<cell|>|<cell|S<rsub|max>(v)\<leqslant\>\<lceil\><frac|n|2>\<rceil\>>>>>>
      </equation*>

      \;
    </with>

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
    <associate|auto-2|<tuple|1|?>>
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