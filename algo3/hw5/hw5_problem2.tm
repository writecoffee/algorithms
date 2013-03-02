<TeXmacs|1.0.7.4>

<style|letter>

<\body>
  <surround|||<doc-data|<doc-title|CS157 Homework
  5>|<\doc-author-data|<author-name|chaoqian and silao_xu>>
    \;
  </doc-author-data>|<doc-date|<date|>>>>

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
      <math|n\<leftarrow\>>number of people

      <math|m\<leftarrow\>>number of events

      construct a <math|m> array ``<with|font-shape|italic|Attends>'' in
      which each element <math|i> stores an empty

      \ \ \ \ set storing the people who are attending

      label each people from 1 to <math|n>

      label each event from 1 to <math|m> sorted by beginning time in
      ascending order

      def Arrange():

      \ \ \ \ <math|p\<leftarrow\>><with|font-shape|italic|NULL>

      \ \ \ \ <math|i\<leftarrow\>>1

      \ \ \ \ <math|S\<leftarrow\>>set(all people)

      \ \ \ \ <math|E\<leftarrow\>>set(all events)

      \ \ \ \ while <math|i\<leqslant\>m>:

      \ \ \ \ \ \ \ \ <math|p\<leftarrow\>>set(events in <math|E> finished
      earlier than event<math|<rsub|i>>'s start time)

      \ \ \ \ \ \ \ \ <math|S\<leftarrow\>S\<cup\>p>

      \ \ \ \ \ \ \ \ <math|l\<leftarrow\>>number of events overlapped with
      event <math|i>

      \ \ \ \ \ \ \ \ <math|e\<leftarrow\>>set(events that overlapped with
      event <math|i>)

      \ \ \ \ \ \ \ \ <with|font-shape|italic|Attends>[<math|i>]<math|\<leftarrow\>>set(<math|m-l>
      people chosen from <math|S>)

      \ \ \ \ \ \ \ \ <math|S\<leftarrow\>S-><with|font-shape|italic|Attends>[<math|i>]

      \ \ \ \ \ \ \ \ for each <em|event><math|<rsub|j>> in <math|e> do:

      \ \ \ \ \ \ \ \ \ \ \ \ <with|font-shape|italic|Attends>[<math|j>]<math|\<leftarrow\>>set(1
      people chosen from <math|S>)

      \ \ \ \ \ \ \ \ \ \ \ \ <math|S\<leftarrow\>S-><with|font-shape|italic|Attends>[<math|j>]

      \ \ \ \ \ \ \ \ end

      \ \ \ \ \ \ \ \ <math|i\<leftarrow\>i+l>

      \ \ \ \ \ \ \ \ <math|E\<leftarrow\>E-e-><with|font-shape|italic|event><math|><math|<rsub|i>>

      \ \ \ \ end

      \ \ \ \ return <with|font-shape|italic|Attends>

      end
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