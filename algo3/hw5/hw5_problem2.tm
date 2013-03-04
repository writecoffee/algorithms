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
  science events on time, and it is rude to leave early.\ 

  <with|color|black|Design a greedy algorithm so that you and your friends,
  between you, can attend every computer science event, if this is possible
  at all.> As above, points on this problem will only be given for the proof
  that your algorithm is optimal; more points will be given for simpler and
  clearer proofs. Remember, if you are having trouble proving the correctness
  of your algorithm, consider a different algorithm; if your proof seems
  unwieldy and awkward, consider a different proof approach<emdash>your first
  idea might be correct, but might not be the best.

  <\itemize-dot>
    <strong|<em|<item>Algorithm>>

    Let the number of people be <math|n> and assume that there are at most
    <math|n> events overlapped at the same time.

    <with|font-base-size|9|<\code>
      01 <math|n\<leftarrow\>>number of people

      02 <math|m\<leftarrow\>>number of events

      03 label each people from 1 to <math|n>

      04 label each event from 1 to <math|m> sorted by beginning time in
      ascending order

      05 def <with|font-shape|italic|Arrange-Events>():

      06 \ \ \ construct a <math|m> array
      ``<with|font-shape|italic|Attends>'' in which each element <math|i>
      stores an empty

      07 \ \ \ \ \ \ \ set storing the people who are attending

      08 \ \ \ <math|p\<leftarrow\>><with|font-shape|italic|NULL>

      09 \ \ \ <math|i\<leftarrow\>>1

      10 \ \ \ <math|S\<leftarrow\>>set(all people)

      11 \ \ \ <math|E\<leftarrow\>>set(all events)

      12 \ \ \ while <math|i\<leqslant\>m>:

      13 \ \ \ \ \ \ \ <math|P\<leftarrow\>>set(events in <math|E> that will
      finish later than event<math|<rsub|i>>'s start time)

      14 \ \ \ \ \ \ \ <math|V\<leftarrow\>>set(people who had attended
      events those are in <math|P>)

      15 \ \ \ \ \ \ \ <math|F\<leftarrow\>S-V>, <math|q\<leftarrow\>\|V\|>

      16 \ \ \ \ \ \ \ <math|l\<leftarrow\>>number of events overlapped with
      event <math|i>

      17 \ \ \ \ \ \ \ <math|e\<leftarrow\>>set(events that overlapped with
      event <math|i>)

      18 \ \ \ \ \ \ \ <with|font-shape|italic|Attends>[<math|i>]<math|\<leftarrow\>>set(<math|n-q-l>
      number of people chosen from <math|S>)

      19 \ \ \ \ \ \ \ <math|F\<leftarrow\>F-><with|font-shape|italic|Attends>[<math|i>]

      20 \ \ \ \ \ \ \ for each <em|event><math|<rsub|j>> in <math|e> do:

      21 \ \ \ \ \ \ \ \ \ \ \ <with|font-shape|italic|Attends>[<math|j>]<math|\<leftarrow\>>set(1
      people chosen from <math|F>)

      22 \ \ \ \ \ \ \ \ \ \ \ <math|F\<leftarrow\>F-><with|font-shape|italic|Attends>[<math|j>]

      23 \ \ \ \ \ \ \ end

      24 \ \ \ \ \ \ \ <math|i\<leftarrow\>i+1+l>, <math|q\<leftarrow\>0>

      25 \ \ \ \ \ \ \ <math|E\<leftarrow\>E-e-><with|font-shape|italic|event><math|><math|<rsub|i>>

      26 \ \ \ end

      27 \ \ \ return <with|font-shape|italic|Attends>

      28 end
    </code>>

    <strong|<em|<item>Correctness>>

    <\itemize-minus>
      <item><strong|Claim>. <with|font-shape|italic|Arrange-Event>
      terminates.

      <with|font-shape|italic|Proof>: Since we have ordered the events by
      their staring time, the maximum index for those events would be
      <math|m>, <math|m> is the number of events. In line 23 the
      <with|font-shape|italic|Arrange-Event>'s index <math|i> (defined in
      line 9) would keep increasing and line 12 would become true at some
      point.

      <item><strong|Claim>. <with|font-shape|italic|Arrange-Event> satisfies
      the feasibility that every event has at least one people to attend.

      <em|Contradiction Hypothesis>:\ 

      Assume that there is an event, <with|font-shape|italic|event><math|<rsub|k>>,
      that has no people attend, which means there is no available people at
      the moment when it starts.

      So, in line 18, we get empty set for <em|event><math|<rsub|k>>, that is\ 

      <\eqnarray*>
        <tformat|<table|<row|<cell|n-q-l>|<cell|\<leqslant\>>|<cell|0>>|<row|<cell|n>|<cell|\<leqslant\>>|<cell|l+q>>>>
      </eqnarray*>

      which means <with|font-shape|italic|event><math|<rsub|k>>'s overlapping
      events number is <math|\<geqslant\>>the number of people <math|n>.
      Plusing <with|font-shape|italic|event><math|<rsub|k>> itself, this
      sequence of overlapping events is <math|\<gtr\>n>. It contradicts with
      the prerequisite that the number of events occurs at the same time
      cannot exceed <math|n>.

      So we can conclude that <with|font-shape|italic|Arrange-Event>
      satisfies the feasibility that every event has at least one people to
      attend.

      <item><strong|Claim>. <with|font-shape|italic|Arrange-Event> satisfies
      the optimality criteria that we achieve maximum total attendant number
      for all events.

      <with|font-shape|italic|Proof>: Let <math|S>* be the optimal solution
      got from <with|font-shape|italic|Arrange-Event>. Assume that there is
      an optimal solution <math|S> which can arrange more attandants than
      solution <math|S>* overall. There must be an event,
      <with|font-shape|italic|event><math|<rsub|k>>, such that\ 

      <\eqnarray*>
        <tformat|<table|<row|<cell|<with|mode|text|<with|font-shape|italic|Attends>*[<math|i>]<math|=><with|font-shape|italic|Attends>[<math|i>]>>|<cell|(for
        i\<less\>k)>|<cell|>>>>
      </eqnarray*>

      and

      <\eqnarray*>
        <tformat|<table|<row|<cell|<with|mode|text|<with|font-shape|italic|Attends>*[<math|i>]<math|\<less\>><with|font-shape|italic|Attends>[<math|i>]>>|<cell|(for
        i=k)>|<cell|>>>>
      </eqnarray*>

      Case 1: there are some consecutive events that overlap
      <with|font-shape|italic|event><math|<rsub|k>>. Since for
      <math|i\<less\>k>, we had assigned the same number of people for
      <with|font-shape|italic|event><math|<rsub|i>>, in line 18, for
      <with|font-shape|italic|event><math|<rsub|k>> we assign more people in
      solution <math|S> than in solution <math|S>*, then for the following
      events that overlap with <with|font-shape|italic|event><math|<rsub|k>>,
      there will be one event cannot be assigned with people to attend.
      <with|color|black|It contradicts with the feasibility that every event
      has at least one person to attend.>

      Case 2: there is no consecutive overlapping event for
      <with|font-shape|italic|event><math|<rsub|k>>. Since for
      <math|i\<less\>k>, we had assigned the same number of people for
      <with|font-shape|italic|event><math|<rsub|i>>. In line 18, suppose we
      can assign more people than <math|S>*, that is at this moment
      <with|mode|math|n<rsub|free> = n-q+c>, where <math|c> is a constant
      positive integer. Let <math|n<rsub|busy>=q>. It's obvious since these
      people are still in events that would end after
      <with|font-shape|italic|event><math|<rsub|k>>'s ending time. So, for
      <math|S>, <math|n<rsub|free>+n<rsub|busy>=n+c>, it contradicts with the
      fact that we have <math|n> people for assigning.

      To sum this up, <with|font-shape|italic|Arrange-Event> satisfies the
      opitimality criteria that we would achieve the maximum total attendant
      number overall.
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
      2> <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-1><vspace|0.5fn>
    </associate>
  </collection>
</auxiliary>