<TeXmacs|1.0.7.19>

<style|generic>

<\body>
  <doc-data|<doc-title|Greedy Algorithm>>

  <item><em|<strong|Cloest Hotel>>

  Each morning, Bilbo will choose for his next night the hotel closest to his
  destination that he can reach that day, or his destination if he can reach
  his destination that day.

  We claim, by induction, that for each <math|i\<geqslant\>0>, under this
  strategy at the ith night Bilbo will be as close as possible to his
  destination. If at night <math|i> Bilbo is at location <math|x>, which is
  the greatest possible location he could be along his route for night
  <math|i>, and on the next day he travels to hotel at greatest location less
  than or equal to <math|x + 20>, then clearly at night <math|i + 1> he will
  be as far as possible along his route for night <math|i + 1>, proving the
  induction. Thus Bilbo greedy strategy will get him as far as possible each
  day, leading him to finish his journey in the least number of days.

  <item><em|<strong|Attend Events>>

  At the moment each event starts, choose a person from your dorm room to go
  to that event.\ 

  This strategy can only fail if there is no one in your dorm room when an
  event starts, meaning that all your <math|k> friends are already at
  <math|k> events. These <math|k> events and the just-starting event make
  <math|k + 1> events. Since there are <math|k+1> events happening
  simultaneously, there is no way to attend each event with only <math|k>
  people. Thus the only way our strategy fails is if our task is impossible,
  meaning our algorithm will succeed in all possible cases.

  <item><em|<strong|Scheduling Jobs>>

  <strong|Claim>: algorithm (order jobs according to decreasing ratios
  <math|w<rsub|i>/l<rsub|i>>) is always correct.

  <strong|Proof>: by an <em|Exchange Argument>, by Contradiction.
  <strong|Plan>: fix arbitrary input of <math|n> jobs, will proceed by
  contradiction. Let <math|\<sigma\>=> greedy schedule, <math|\<sigma\>>*=
  optimal schedule, will produce schedule even better than <math|\<sigma\>>*,
  contradicting purported optimality of <math|\<sigma\>>*.

  <strong|Assume>: all <math|w<rsub|i>/l<rsub|i>> are distinct; [just by
  renaming jobs] <math|w<rsub|1>/l<rsub|1>\<gtr\>w<rsub|2>/l<rsub|2>\<gtr\>\<ldots\>\<gtr\>w<rsub|n>/l<rsub|n>>,
  where <math|job<rsub|1>> has the greatest ratio.

  <strong|Thus>: greedy schedule sigma is just <math|1,2,3,\<ldots\>,n>. If
  optimal schedule <math|\<sigma\>>* is inequivalent to <math|\<sigma\>>,
  then there are consecutive jobs <math|i,j> with <math|i\<gtr\>j>. [only
  schedule where indices always go up is <math|1,2,\<ldots\>,n>].

  <strong|Thought Experiment>: ramifications of the exchange of jobs
  <math|\<rightarrow\>> it has to have this pair of consecutive jobs where
  the earlier one has the higher index; <em|Effect of this exchange on the
  completion time of>: <math|<rsup|<around*|(|1|)>>k> other than <math|i> or
  <math|j>: before the swap, it has to wait for a bunch of ops to complete,
  including <math|i> and <math|j>, the amount of time elapsed is the same,
  thus jobs other than <math|i> and <math|j> are completely agnostic to the
  swap; <math|k> preceed <math|i> and <math|j> is the same.
  <math|<rsup|<around*|(|2|)>>>job <math|i>: goes up, now it has to wait for
  <math|j>, goes up by the lenght of <math|j>.
  <math|<rsup|<around*|(|3|)>>>job <math|j>: drops, no longer has to wait for
  job <math|i>, goes down precisely the length of job <math|i>.

  <strong|Cost-Benefit Analysis>: <em|Upshot>s:
  <math|i\<gtr\>j\<Rightarrow\><frac|w<rsub|i>|l<rsub|i>>\<less\><frac|w<rsub|j>|l<rsub|j>>\<Rightarrow\>w<rsub|i>l<rsub|j>\<less\>w<rsub|j>l<rsub|i>\<Rightarrow\>cost
  \<less\> benefit\<Rightarrow\>>swap improves <math|\<sigma\>>*, contradicts
  optimality of <math|\<sigma\>>*. <em|QED>!

  <item><em|<strong|Prim's MST Algorithm>>

  <\render-code>
    PRIM(<math|s>)

    <tabular|<tformat|<table|<row|<cell|1>|<cell|<math|X\<leftarrow\><around*|{|s|}>>>>|<row|<cell|2>|<cell|<math|T\<leftarrow\>>EMPTY>>|<row|<cell|3>|<cell|<strong|while>
    <math|X!=V>:>>|<row|<cell|4>|<cell|<htab|5mm><math|e\<leftarrow\><around*|(|u,v|)>>
    /* be the cheapest edge of <math|G> with <math|u> in <math|X>, <math|v>
    not in <math|X> */>>|<row|<cell|5>|<cell|<htab|5mm><math|T\<leftarrow\>T\<cup\><around*|{|e|}>>>>|<row|<cell|6>|<cell|<htab|5mm><math|X\<leftarrow\>X\<cup\><around*|{|v|}>>>>>>>
  </render-code>

  <item><strong|<em|Kruskal's MST Algorithm>>

  <\render-code>
    KRUSKAL(<math|s>)

    <tabular|<tformat|<table|<row|<cell|1>|<cell|sort edges in increasing
    order /* bottle-neck in the end <math|O<around*|(|m log n|)>>
    */>>|<row|<cell|2>|<cell|[rename edge <math|1,2,\<ldots\>,m>, so that
    <math|c<rsub|1>\<less\>c<rsub|2>\<less\>c<rsub|3>\<ldots\>\<less\>c<rsub|m>>]>>|<row|<cell|3>|<cell|<math|T=><em|EMPTY
    SET>>>|<row|<cell|4>|<cell|<strong|for> <math|i=1> <strong|to> <math|m>
    <strong|do>:>>|<row|<cell|5>|<cell|<htab|5mm><strong|if>
    <math|T\<cup\><around*|{|i|}>> has no cycle <strong|then do>: /*
    originally <math|O<around*|(|n|)>> without Union-Find
    */>>|<row|<cell|6>|<cell|<htab|5mm><htab|5mm><math|T\<leftarrow\>T\<cup\><around*|{|i|}>>>>|<row|<cell|7>|<cell|<strong|return>
    <math|T>>>>>>
  </render-code>

  <item><strong|<em|Union-Find for Kruskal MST>>

  <strong|Raison d'etre>: maintain partition of a set of objects.
  <strong|Motivation>: <math|\<theta\><around*|(|1|)>> time for cycle checks.\ 

  <strong|Find(<math|x>)>: return name of group that <math|x> belongs to.
  <strong|Union(<math|c<rsub|i>,c<rsub|j>>)>: fuse groups <math|c<rsub|i>>
  and <math|c<rsub|j>> into a single one.\ 

  <strong|Idea>: when two componenets merge, have smaller one inherit the
  leader of the larger one; you have to quickly determine which group is
  larger, so you may maintain a size field for each group. <em|How many
  leader pointer updates are now required to restore the invariant in the
  worst case?> <strong|<math|\<theta\><around*|(|log n|)>>>. <strong|Reason>:
  you are joining a group at least as big as yours, so the size of the union,
  the size of your new community, is at least double the size of your
  previous one.
</body>

<\initial>
  <\collection>
    <associate|page-type|letter>
  </collection>
</initial>