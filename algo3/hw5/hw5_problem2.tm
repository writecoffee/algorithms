<TeXmacs|1.0.7.4>

<style|letter>

<\body>
  <surround|||<doc-data|<doc-title|CS157 Homework
  5>|<doc-author-data|<author-name|chaoqian and silao_xu>|<\author-address>
    \;
  </author-address>>|<doc-date|<date|>>>>

  <section|Problem 2>

  (10 points) You and your group of friends spend all your time hanging out
  in your dorm room unless there is a computer science event happening, in
  which you attend the event, and then immediately return to your dorm room.
  However, there may be overlapping events, in which case you aim to have at
  least one of you attend each event. Of course, you must arrive to computer
  science events on time, and it is rude to leave early. Design a greedy
  algorithm so that you and your friends, between you, can attend every
  computer science event, if this is possible at all. As above, points on
  this problem will only be given for the proof that your algorithm is
  optimal; more points will be given for simpler and clearer proofs.
  Remember, if you are having trouble proving the correctness of your
  algorithm, consider a different algorithm; if your proof seems unwieldy and
  awkward, consider a different proof approach<emdash>your first idea might
  be correct, but might not be the best.

  <\itemize-dot>
    <strong|<em|<item>Algorithm>>

    Let the number of people be <math|n> and the number of events be
    <math|m>. Let's assume that there are at most <math|n> events overlap at
    the same time.\ 

    <\code>
      label each people from <math|1> to <math|n>

      label each event from 1 to <math|m>

      def Arrange():

      \ \ \ \ 
    </code>

    <strong|<em|<item>Correctness>>

    <\itemize-minus>
      <item><with|font-shape|italic|Proof by Induction>

      <item><with|font-shape|italic|Base Case>

      <item><with|font-shape|italic|Inductive Hypothesis>
    </itemize-minus>
  </itemize-dot>

  \;
</body>

<\references>
  <\collection>
    <associate|auto-1|<tuple|1|1>>
  </collection>
</references>

<\auxiliary>
  <\collection>
    <\associate|toc>
      <vspace*|1fn><with|font-series|<quote|bold>|math-font-series|<quote|bold>|Problem
      1> <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-1><vspace|0.5fn>
    </associate>
  </collection>
</auxiliary>