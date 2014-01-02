<TeXmacs|1.0.7.4>

<style|generic>

<\body>
  <doc-data|<doc-title|CS157 Homework 3>|<\doc-author-data|<author-name|Silao_Xu>>
    \;
  </doc-author-data>>

  <section|Problem 1>

  You are given an array of n distinct numbers with an unusual property: the
  numbers are strictly increasing from the first element to the <math|k>-th
  element, for some unknown integer <math|k>, and the numbers are strictly
  decreasing from the <math|k>-th element to the last element. Devise a
  <math|O>(log n) algorithm that receives such array as an input and finds
  the maximum element in the array. Explain the algorithm in high level as
  well as provide the pseudocode, then prove its correctness and run time.

  For example, if the input array is:

  1 4 7 8 6 3 0

  then the output should be 8.

  <strong|Note>: Remember, the key to communicating your solution effectively
  and painlessly is to emphasize the structure of the argument, to
  ``signpost'' the main points. If you tell us all the ingredients and how
  they relate to each other, then we will often be able to trust your
  solution even if you omit some details.

  <with|color|blue|<\itemize-dot>
    <\with|color|black>
      <item><strong|<em|Algorithm>>:

      Let <math|A> be the array with <math|n> elements. We define the problem
      that searching the maximum number from array <math|A> which ranges from
      0 to <math|n> to be <math|P<rsub|(0, n)>>.

      Let the target we need to find be <math|s>, its index in the array to
      be <math|i>. Since <math|s> is the maximum number in the array, where
      the previous sequence is in ascending order and the following sequence
      is in descending order, it must be <math|A[i-1]\<less\>A[i]\<gtr\>A[i+1]>.

      Let index <math|p> be the random pivot chosen to probe <math|s>. If
      <math|p> falls into the ascending order sequence, there will be
      <math|A[p-1]\<less\>A[p]\<less\>[p+1]>, which means currently it is a
      wrong guessing and <math|p> should fall into the indices that are
      bigger than <math|p>; and now problem <math|P<rsub|(0, n)>> could be
      divided into subproblem <math|P<rsub|(0, p)>>. On the other hand, if
      <math|p> falls into the descending order sequence, there will be
      <math|A[p-1]\<gtr\>A[p]\<gtr\>A[p+1]>, meaning that it is a wrong
      guessing and <math|p> should be picked again from indices that are
      smaller than <math|p>; and now the problem could be divided into
      subproblem <math|P<rsub|(p, n)>>.

      We choose <math|p> to be the middle pivot of every current subproblem,
      pseudocode presented as follows:

      <\code>
        <em|FindMidMax>(<math|A>, <math|l>, <math|r>):

        \ \ \ \ if <math|r\<leqslant\>l> then do:

        \ \ \ \ \ \ \ \ return <with|font-shape|italic|NULL>

        \ \ \ \ if <math|r-l=1> then do:

        \ \ \ \ \ \ \ \ return <math|A[l]>

        \ \ \ \ <math|m \<leftarrow\>\<lfloor\><frac|r+l|2>\<rfloor\>>

        \ \ \ \ if <math|m=0> then do:

        \ \ \ \ \ \ \ \ if <math|A[0]\<less\>A[1]> then do:

        \ \ \ \ \ \ \ \ \ \ \ \ return <with|font-shape|italic|FindMidMax>(<math|A>,
        <math|1>, <math|r>)

        \ \ \ \ \ \ \ \ else:

        \ \ \ \ \ \ \ \ \ \ \ \ return <math|A[0]>

        \ \ \ \ else if <math|m+1=r> then do:

        \ \ \ \ \ \ \ \ if <math|A[m-1]\<less\>A[m]> then do:

        \ \ \ \ \ \ \ \ \ \ \ \ return <with|font-shape|italic|FindMidMax>(<math|A>,
        <math|l>, <math|m>)

        \ \ \ \ \ \ \ \ else:

        \ \ \ \ \ \ \ \ \ \ \ \ return <math|A[m-1]>

        \ \ \ \ else:

        \ \ \ \ \ \ \ \ if <math|A[m-1]\<less\>A[m]\<less\>A[m+1]> then do:

        \ \ \ \ \ \ \ \ \ \ \ \ return <with|font-shape|italic|FindMidMax>(<math|A>,
        <math|m>, <math|r>)

        \ \ \ \ \ \ \ \ else if <with|mode|math|A[m-1]\<gtr\>A[m]\<gtr\>A[m+1]>
        then do:

        \ \ \ \ \ \ \ \ \ \ \ \ return <with|font-shape|italic|FindMidMax>(<math|A>,
        <math|l>, <math|m>)

        \ \ \ \ \ \ \ \ else:

        \ \ \ \ \ \ \ \ \ \ \ \ return <math|A[m]>
      </code>

      <item><strong|<em|Correctness>:>

      <em|Proof by strong induction:>

      Let the target we need to find be <math|s> and let <math|P(n)> be the
      assertion that <with|font-shape|italic|FindMidMax> works correctly for
      inputs where <math|r-l=n>. If we prove that <math|P(n)> is true for all
      <math|n>, then we know that <with|font-shape|italic|FindMixMax> works
      on all possible arguments.

      <\itemize-minus>
        <item><with|font-shape|italic|Base Case>

        In the case where <math|n=1>, we know <math|l=r-1=m>. Since we
        assumed that the function would only be called when <math|s> is found
        between <math|l> and <math|r>, it must be the case that <math|s> is
        smaller than another number on its right, which is an empty sequence,
        and bigger than any other number on its left and the function
        therefore return <math|A[0]>.

        In the case where <math|n=2>, there are 2 subcases. Subcase 1 is that
        <math|A[0]\<less\>A[1]>, then <math|m=<frac|2+0|2>=1>, because
        <math|A[m]> is bigger than its previous ascending sequence (which is
        of length 1), the function therefore return <math|A[m]>. Subcase 2 is
        that <math|A[0]\<gtr\>A[1]>. So <math|m=1> and <math|A[m]> doesn't
        meet the requirement and hence we need a recursive call, where
        <math|n<rprime|'>=m-l=1> which is smaller than 2. Now we go into the
        case (<math|n=1)>, and <math|A[0]> would be the return value.

        <item><with|font-shape|italic|Inductive Step>

        We assume that <with|font-shape|italic|FindMidMax> works as long as
        <math|r-l\<leqslant\>k>. Our goal is to prove that it works on an
        input where <math|r-l=k+1>. There are three cases, where
        <math|A[m-1]\<less\>A[m]\<gtr\>A[m+1]>, where
        <math|A[m-1]\<less\>A[m]\<less\>A[m+1]>, where
        <math|A[m-1]\<gtr\>A[m]\<gtr\>A[m+1]>.

        <\enumerate-alpha>
          <item>Case <math|<math|>A[m-1]\<less\>A[m]\<gtr\>A[m+1]>

          Clearly the function works correctly and <math|A[m]> is the target
          we need to find.

          <item>Case <math|A[m-1]\<gtr\>A[m]\<gtr\>A[m+1]>

          We know because the array is in ascending order until <math|s> and
          becomes in descending order after <math|s>. So if the recursive
          call works correctly, this call will too. For the new recursive
          call, <math|n<rprime|'>=m-l=\<lfloor\><frac|l+r|2>\<rfloor\>-l>. If
          <math|l+r> is odd, then <math|n=<frac|l+r-1|2>-l=<frac|r-l-1|2>>,
          which is definitely smaller than <math|n> (that is <math|r-l>). If
          <math|l+r> is even then <math|n<rprime|'>=<frac|r+l|2>-l=<frac|r-l|2>>,
          which is also smaller than <math|r-l> because
          <math|r-l=k+1\<gtr\>0>. So the recursive call must be to a range of
          <math|A> such that that is between 0 and <math|k> cells, and must
          be correct by our induction hypothesis.

          <item>Case <math|A[m-1]\<less\>A[m]\<less\>A[m+1]>

          This is more or less symmetrical to the previous case. We need to
          show that <math|r-(m+1)\<leqslant\>r-l>. We have
          <math|r-(m+1)=r-\<lfloor\><frac|l+r|2>\<rfloor\>-1>. If <math|r+l>
          is even, this is <math|<frac|r-l|2>-1>, which is less than
          <math|r-l>. If <math|l+r> is odd, this is
          <math|r-<frac|l+r-1|2>-1=<frac|r-l-1|2>>, which is also less than
          <math|r-l>. Therefore, the recursive call is to \ a smaller range
          of the array and can be assumed to work correctly by the induction
          hypothesis.
        </enumerate-alpha>

        Because in all cases the inductive step works, we can conclude that
        <with|font-shape|italic|FindMidMax> (and its iterative variant) are
        correct.\ 
      </itemize-minus>

      <em|<strong|<item>Runtime>>

      <em|Proof by strong induction>:

      Let <math|C> be the amount of required to run all of the code in the
      procedure except for the \ recursive calls, and let <math|T(n)> be the
      total amount of time required to run the procedure when <math|r-l=n>,
      claiming that <math|T(n)\<leqslant\>C log n+T(1)> for all
      <math|n\<geqslant\>1>.

      <\itemize-minus>
        <em|<item>Base Case>

        When <math|n=1>, <math|T(1)=C log 1 +T(1)=T(1)>.

        In the case where <math|n=2>, there are 2 subcases. Subcase 1 is that
        <math|A[0]\<less\>A[1]>, then <math|m=<frac|2+0|2>=1>, because
        <math|A[m]> is bigger than its previous ascending sequence (which is
        of length 1), the running time would be just <math|T(2)=C log 2 +
        T(1)>. Subcase 2 is that <math|A[0]\<gtr\>A[1]>. So <math|m=1> and
        <math|A[m]> doesn't meet the requirement and hence we need a
        recursive call, where <math|n<rprime|'>=m-l=1>. Now we go into the
        case (<math|n=1)>, and <math|A[0]> would be the return value. So for
        in this case the running time would be <math|C log 2+T(1)+C log 1 +
        T(1)=C log 2+2T(1)>.

        <item><with|font-shape|italic|Inductive Step>

        Now we choose a particular <math|n\<gtr\>2>. We assume that for all
        <math|k\<less\>r-l>, that <math|T(k)\<leqslant\>C log k +T(1)>. Out
        goal is to prove that for input <math|k=n=r-l>,
        <math|T(n)\<leqslant\>C log n +T(1)>. There are three cases, where
        <math|A[m-1]\<less\>A[m]\<gtr\>A[m+1]>, where
        <math|A[m-1]\<less\>A[m]\<less\>A[m+1]>, where
        <math|A[m-1]\<gtr\>A[m]\<gtr\>A[m+1]>.

        <\enumerate-alpha>
          <item>Case <math|<math|>A[m-1]\<less\>A[m]\<gtr\>A[m+1]>

          We wouldn't make any recursive call in this case, we take at most
          <math|C> amount of time for <math|n\<gtr\>2>.
          <math|T(n)\<leqslant\>C\<leqslant\>C log n+T(1)>.

          <item>Case <math|A[m-1]\<gtr\>A[m]\<gtr\>A[m+1]>

          We need at most <math|C> time to execute everything other than the
          recusive calls, we'll need <math|T(m-l)> amount of time do the
          recursive calls. That is <math|T(n)\<leqslant\>C+T(m-l)=C+T(\<lfloor\><frac|r+l|2>\<rfloor\>-l)>.
          Let <math|n<rprime|'>> to be <math|m-l>.\ 

          If <math|n> is odd number, <with|mode|math|\<lfloor\><frac|r+l|2>\<rfloor\>-l>
          would be <math|<frac|r-l-1|2>> leading to
          <math|n<rprime|'>\<less\>n>. By our inductive hypothesis, since
          <math|n<rprime|'>=<frac|r-l-1|2>\<less\>r-l=n>, we can reduce this
          to <math|T(n)\<leqslant\>C+T(<frac|r-l-1|2>)\<leqslant\>C+<left|(>C
          log (<frac|r-l-1|2>)+T(1)<right|)>=C+C log (r-l-1) -C+T(1)\<less\>C
          log n +T(1)>.

          If <math|n> is even number, <with|mode|math|\<lfloor\><frac|r+l|2>\<rfloor\>-l>
          would be <with|mode|math|<frac|r-l|2>> leading to
          <math|n<rprime|'>> must be smaller than <math|n> because
          <math|n=r-l=k+1\<gtr\>0>. By our inductive hypothesis, since
          <math|n<rprime|'>=\<lfloor\><frac|r-l|2>\<rfloor\>-l\<less\>r-l=n>,
          we can reduce this to <math|T(n)\<leqslant\>C+T(<frac|r-l|2>)\<leqslant\>C+<left|(>C
          log (<frac|r-l|2>)+T(1)<right|)>=C+C log (r-l) -C+T(1)=C log n
          +T(1)>.

          <item>Case <math|A[m-1]\<less\>A[m]\<less\>A[m+1]>

          It is more or less symmetrical to the previous one. We need
          <math|T(r-m)> amount of time to do the recursive calls. That is
          <math|T(n<rprime|'>)\<leqslant\>C+T(r-m)=C+T(r-<frac|r+l|2>)=C+T(\<lfloor\><frac|r-l|2>\<rfloor\>)>.\ 

          If <math|n> is odd number, <with|mode|math|T(\<lfloor\><frac|r-l|2>\<rfloor\>)>
          would be <math|T(<frac|r-l-1|2>)> leading to
          <math|n<rprime|'>\<less\>n>. By our inductive hypothesis, since
          <math|<frac|r-l|2>\<less\>r-l=k>, we can reduce this to
          <math|T(n)\<leqslant\>C+T(<frac|r-l-1|2>)\<leqslant\>C+<left|(>C
          log (<frac|r-l-1|2>)+T(1)<right|)>=C+C log (r-l-1) -C+T(1)\<less\>C
          log n +T(1)>.

          If <math|n> is even number, <with|mode|math|T(\<lfloor\><frac|r+l|2>\<rfloor\>-l)>
          would be <with|mode|math|T(<frac|r-l|2>)> leading to
          <math|n<rprime|'>> must be smaller than <math|n> because
          <math|n<rprime|'>=r-l=k+1\<gtr\>0>. By our inductive hypothesis,
          since <math|<frac|r-l|2>\<less\>r-l>, we can reduce this to
          <math|T(n)\<leqslant\>C+T(<frac|r-l|2>)\<leqslant\>C+<left|(>C log
          (<frac|r-l|2>)+T(1)<right|)>=C+C log (r-l) -C+T(1)=C log n +T(1)>.
        </enumerate-alpha>

        Since in all three cases we have used up to <math|C log n+T(1)> time,
        we have shown that <math|T(n)\<leqslant\>C log n+T(1)> by strong
        induction.

        At this point, we see that if <math|n\<gtr\>1>, that
        <math|T(n)\<leqslant\>C log n+T(1)>.

        If we force <math|C log n+T(1)\<less\> c log n> since we know that
        <math|T(n)> is <math|\<leqslant\>C log n +T(1)>. We'll start by
        choosing <math|c> bigger than <math|C>, say <math|C+1>. Then we can
        solve:

        <\eqnarray*>
          <tformat|<table|<row|<cell|C log n+T(1)>|<cell|\<less\>>|<cell|c
          log n>>|<row|<cell|T(1)>|<cell|\<less\>>|<cell|(c-C) log
          n>>|<row|<cell|T(1)>|<cell|\<less\>>|<cell|log n>>>>
        </eqnarray*>

        So as long as <math|n\<gtr\>2<rsup|T(1)>>, we will find the
        <math|n<rsub|0>> such that <math|T(n)\<less\>c log n>. Thus, the
        witness pair is <math|(C+1, 2<rsup|T(1)>)>, and hence <math|T(n)> is
        <math|O(log n)>.
      </itemize-minus>

      \;
    </with>
  </itemize-dot>>

  \;

  \;

  \;
</body>

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
      1> <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-1><vspace|0.5fn>
    </associate>
  </collection>
</auxiliary>