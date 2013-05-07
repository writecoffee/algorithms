<TeXmacs|1.0.7.19>

<style|generic>

<\body>
  <doc-data|<doc-title|Maximum Flow>>

  <\itemize>
    <item><strong|Ford-fulgerson Algorithm>

    <\render-code>
      <math|H=copy of G\<nocomma\>,<text|the residual graph>>

      <strong|while> <math|H> has a path from <math|s> to <math|t>
      <strong|do>

      \ \ \ \ <math|p=<text|<em|s-t> path in <math|H>, <math|v> be its
      value>>

      \ \ \ \ <math|f=<text|augument <math|f> with <math|p>>>

      \ \ \ \ <math|H=>new residual graph of <math|G> for <math|f>

      <strong|return> <math|f>
    </render-code>

    <item><strong|Relation between Flow and Matching>

    <strong|<em|Three> <em|steps><em|>>: (1) Build the flow; (2) Prove the
    resulting flow could be turned into a maximum match; (3) Prove the flow
    <math|f> satisfies all the constraints.

    <em|Proving that solving the maximum flow problem can give us a valid
    matching plan.>

    Because the capacities are integers, our flow will be
    <with|color|blue|integral>. Because the capacities are all 1, we will
    either use an edge completely or not use an edge at all.

    Let <math|M> be the set of edges going from <math|A> to <math|B> that we
    use. We will show that (i) <math|M> is a matching, (ii) <math|M> is the
    largest possible matching.

    <\enumerate>
      <item><math|M> is a valid marriage plan

      We can choose at most one edge leaving any vertex in <math|A>. We can
      choose at most one edge reaching vertex in <math|B>. If we chose more
      than 1, we couldn't have balanced flow between <math|A> and <math|B>.

      <item><math|M> is the largest possible matching

      The correspondence between flows and matchings is <emdash> if there is
      a matching of <math|k> edges between <math|A> and <math|B>, the
      resulting flow <math|f>, starting from <math|s> and sinking into
      <math|t>, would be of value <math|k>, where <math|f> has 1 unit of flow
      across each of the <math|k> edges and <math|\<leqslant\>1> unit leaves
      (from <math|A>) and enters (into <math|B>) each node; if there is a
      flow <math|f> of integral value <math|k>, there is a matching with
      <math|k> edges between <math|A> and <math|B>.

      We have found the maximum flow <math|f> with <math|k> edges (via
      <em|Ford-fulgerson Algo>) and this corresponds to a matching <math|M>
      of <math|k> edges. If there was a matching with <math|\<gtr\>k> edges,
      we could have found a flow with value <math|\<gtr\>k>, contradicting
      that <math|f> was maximum. Hence <math|M> is the maximum matching.
    </enumerate>

    <item><strong|Min-cut>

    \;

    <\theorem>
      Maximum <math|s>-<math|t> flow is <math|\<leqslant\>> minimum
      <math|s>-<math|t> cut. (Why Ford-Fugerson can stop? the best flow is as
      best as min <math|s>-<math|t> cut, and then as long as we build the
      flow which is evaluated to equalto the min <math|s>-<math|t> cu, we
      know it's as best as possible, we can stop.
    </theorem>

    <item><strong|Runtime>

    The running time of <em|Ford-Fulkerson> is
    <math|O<around*|(|<around*|\||E|\|>\<cdot\><around*|\||f|\|>|)>> where
    <math|<around*|\||E|\|>> is the number of edges of <math|G> and
    <math|<around*|\||f|\|>=<big|sum><rsub|e<text| leaving
    <math|s>>>c<rsub|e>\<nocomma\>=max<around*|(|n,m|)>>. There would be at
    most <math|n+m+n m> edges in <math|G>. So the running time is
    <math|O<around*|(|n m<rsup|2>|)>>.
  </itemize>
</body>

<\initial>
  <\collection>
    <associate|page-type|letter>
  </collection>
</initial>