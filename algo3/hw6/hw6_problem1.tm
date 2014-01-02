<TeXmacs|1.0.7.4>

<style|letter>

<\body>
  <surround|||<doc-data|<doc-title|CS157 Homework
  6>|<doc-author-data|<author-name|tqian and silao_xu>|<\author-address>
    \;
  </author-address>>|<doc-date|<date|>>>>

  <section|Problem 1>

  (30 points) You can allocate a block of n memory locations on your computer
  in constant time, however the contents of the memory in the block may be
  arbitrary. Typically, you will initialize these memory locations before you
  use them, by setting them all to a special symbol Empty, which takes
  <math|O>(<math|n>) time.\ 

  The object of this problem is to create a new data structure that mimics
  the properties of an array, while being much faster to initialize, but
  while still ensuring that any values returned by this data structure are
  meaningful, and not uninitialized garbage.\ 

  You need to come up with a data structure that behaves like a 0-indexed
  array <math|A> of n elements. The following operations must take a constant
  time:\ 

  <\itemize-dot>
    <item>set(index, value): Assign the value to <math|A>[index].

    <item>get(index): Return the value from <math|A>[index]. If no value has
    yet been assigned, return Empty.

    <item>initialize(n): Initialize the data structure so that it will mimic
    an array of size <math|n>, and where any <strong|get> call returns
    <strong|Empty>.
  </itemize-dot>

  <strong|Warning>: Keep in mind that, initially, the entries in memory can
  be arbitrary and may imitate valid parts of whatever data structure you
  design<emdash>your data structure should work <em|no matter what> is in
  memory initially.\ 

  <strong|Hints>:\ 

  <\itemize-dot>
    <item>Use more than <math|n> storage (but you do not need to use more
    than <math|O>(<math|n>) storage).\ 

    <item>Most memory locations may be garbage, but think about how you can
    be sure some memory locations are meaningful.

    <item>Because all operations in this data structure must take constant
    (worst case) time, you cannot use anything fancy: no hash tables, no
    binary search trees, no heaps, etc.
  </itemize-dot>

  <strong|Important>: If you are using extra space, please explain in
  sentences how they are used. As always, you need to communicate clearly
  that your proposed data structure works correctly, and that the running
  time for each operation, including initialization, is
  constant.<em|<strong|>>

  <\itemize-dot>
    <item>initialize(n): Initialize the data structure so that it will mimic
    an array of size <math|n>, and where any <strong|get> call returns
    <strong|Empty>.

    We need another two <math|n>-element arrays and a counter.

    Counter is used for recording how many items are assigned values so far.
    It starts from 0 and ends with <math|n> (when all entries are filled).

    Array <math|F> is used for recording the <math|i>th element's assignment
    order, <em|e.g.>, in the first time we assign value to <math|A[1]>,
    <math|F[1]> should be 0 and in the second time we assign value to
    <math|A[8]>, <math|F[8]> should be 1.

    Array <math|T> is used as asserting whether entry <math|i> has been
    assigned value.

    <with|font-base-size|8|<\code>
      <em|initialize>(<math|n>):

      1 \ \ \ <math|A\<leftarrow\>>new array of length <math|n>

      2 \ \ \ <math|F\<leftarrow\>>new array of length <math|n> /* for
      recording assignment sequence */

      3 \ \ \ <math|T\<leftarrow\>>new array of length <math|n> /* for
      asserting entry <math|i> in <math|A> has been assigned */

      4 \ \ \ <math|count\<leftarrow\>0> /* for counting how many entries
      have been assigned so far */
    </code>>

    <item>get(index): Return the value from <math|A>[index]. If no value has
    yet been assigned, return <em|Empty>.

    Initially, the condition in line 1 of the following pseudocode
    (<math|F[index]\<less\>count)> would never be true because after
    filtering out all the valid assigning order number
    (<math|F[index]\<geqslant\>0>), there would be no entry in <math|F> could
    be smaller than count-0. <with|font-shape|italic|Empty> would be returned
    in this case.

    <with|font-base-size|8|<\code>
      <em|get>(<math|index>):

      1 \ \ \ if <math|F[index]\<geqslant\>0> and
      <math|F[index]\<less\>count> and <math|T[F[index]]=index> then do:

      2 \ \ \ \ \ \ \ return <math|A[index]>

      3 \ \ \ else:

      4 \ \ \ \ \ \ \ return <with|font-shape|italic|Empty>
    </code>>

    Firstly, we need to judge the index <math|i> we want to retrieve is in
    our assigning order. If not, the value has yet been assigned. If so,
    since there's still a possibility that garbage value could be stored in
    <math|F[i]> and the value is by accidence smaller than <math|count>, we
    need another assurance, <math|T[F[i]]>, such that index <math|i> points
    to the only really assigned entries.

    <item><with|font-shape|italic|set> operation is based on
    <with|font-shape|italic|get> operation when the same entry in <math|A> is
    going to be modified. Otherwise, we need to set up condition telling that
    the index has already been assigned (see line 4 to 7).

    <with|font-base-size|8|<\code>
      <with|font-shape|italic|set>(<math|index>, <math|value>):

      1 \ \ \ if <with|font-shape|italic|get>(<math|index>)<math|\<neq\>><with|font-shape|italic|Empty>
      then do:

      2 \ \ \ \ \ \ \ <math|A[index]\<leftarrow\>value>

      3 \ \ \ else:

      4 \ \ \ \ \ \ \ <math|A[index]\<leftarrow\>value>

      5 \ \ \ \ \ \ \ <math|F[index]\<leftarrow\>count>

      6 \ \ \ \ \ \ \ <math|T[top]\<leftarrow\>index>

      7 \ \ \ \ \ \ \ <math|count\<leftarrow\>count+1>
    </code>>
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