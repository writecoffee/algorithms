<TeXmacs|1.0.7.18>

<style|<tuple|letter|scripts>>

<\body>
  <surround|||<doc-data|<doc-title|CS157 Homework
  6>|<doc-author|<\author-data|<author-name|tqian and silao_xu>>
    \;
  </author-data>>|<doc-date|<date|>>>>

  <section|Problem 3>

  <\enumerate-numeric>
    <item>When choosing a hash function, we want to make sure that collisions
    are unlikely. One way to ensure this is to randomly choose a hash
    function from a large family, where different functions in the hash
    function family scramble elements in different ways. A hash function
    family <math|H> is a family of functions {<math|h<rsub|p>>} :
    <math|X\<rightarrow\>Y> , where <math|p> ranges over <em|parameters> in a
    set <math|P>. Throughout this problem, we will let <math|m> be the size
    of the range of the hash function family, <math|m=<around|\||Y|\|>>.
    Typically, a hash function is parameterized by several parameters; for
    example, if <math|h> is parameterized by triples <math|p =
    <around|(|p<rsub|1>, p<rsub|2>, p<rsub|3>|)>>, where <math|p<rsub|1>>
    ranges over some set <math|P<rsub|1>>, <math|p<rsub|2>> ranges over some
    set <math|P<rsub|2>>, and <math|p<rsub|3>> ranges over some set
    <math|P<rsub|3>>, then the universe of parameters <math|P> consists of
    all values of these triples. Specifically,
    <math|P=P<rsub|1>\<times\>P<rsub|2>\<times\>P<rsub|3>>, and
    <math|<around|\||P|\|>=<around|\||P<rsub|1>|\|>\<cdot\><around|\||P<rsub|2>|\|>\<cdot\><around|\||P<rsub|3>|\|>>.

    A hash function family <math|H> is called universal if for each pair
    <math|a,b\<in\>X> with <math|a\<neq\>b>, at most
    <frac|\|<math|P>\||<math|m>> out of the <math|<around|\||P|\|>>
    parameters <math|p> make <math|a> and <math|b> collide as
    <math|h<rsub|p><around|(|a|)>=h<rsub|p><around|(|b|)>>.

    For each of the following hash function families, either prove it is
    universal or give a counterexample. <with|color|dark blue|Additionally,
    compute how many bits are needed to choose a random element of the family
    (namely, compute <math|log<rsub|2><around|\||P|\|>> in each case)>.

    The notation [<math|m>] denotes the set of integers
    {<math|0,1,2,\<ldots\>,m-1>}.

    <\enumerate-alpha>
      <item>(3 points) <math|H> = {<math|h<rsub|p>> :
      <math|p\<in\>>[<math|m>]} where <math|m> is a fixed prime and

      <\equation*>
        h<rsub|p><around|(|x|)>=p x mod m.
      </equation*>

      Each of these functions is parameterized by an integer <math|p> in
      <math|<around|[|m|]>>, and maps an integer <math|x> in [<math|m>] to an
      output in [<math|m>].

      The hash function family <math|H=<around|{|h<rsub|p>:
      p\<in\><around|[|m|]>|}>> where <math|m> is a fixed prime is universal
      if and only if for each pair <math|a,b\<in\>X> with <math|a\<neq\>b>,
      at most <math|<frac|<around|\||P|\|>|m>=1> out of the
      <math|<around|\||P|\|>> paramaters <math|p> make <math|a> and <math|b>
      collide as <math|h<rsub|p><around|(|a|)>=h<rsub|p><around|(|b|)>>.

      Suppose <math|h<rsub|p><around|(|a|)>=h<rsub|p><around|(|b|)>> and
      <math|a\<neq\>b>, then we have

      <\eqnarray*>
        <tformat|<table|<row|<cell|p a mod m>|<cell|=>|<cell|p b mod
        m>>|<row|<cell|p a mod m - p b mod
        m>|<cell|=>|<cell|0>>|<row|<cell|p<around|(|a-b|)> mod
        m>|<cell|=>|<cell|0>>>>
      </eqnarray*>

      Because <math|a\<neq\>b> (and thus <math|a-b \<neq\>0 mod m>), <math|m>
      is bigger than <math|a> and <math|b> each, <math|<around*|(|a-b|)>>
      cannot be zero modulo <math|m>. Also <math|m> is prime, so <math|p>
      uniform at random. So left-hand side euqally likely to be any of
      <math|<around|{|0,1,2,\<ldots\>,m-1|}>> and there is <math|<frac|1|m>>
      probability to make the left-hand side of above equation become 0,
      which implies <math|Prob<around|[|h<rsub|p><around|(|x|)>=h<rsub|p><around|(|y|)>|]>=<frac|1|m>>.

      We conclude that for each pair <math|a,b\<in\>X> with <math|a\<neq\>b>,
      at most <math|<frac|<around|\||P|\|>|m>=1> out of the
      <math|<around|\||P|\|>> parameters <math|p> could make <math|a> and
      <math|b> collide as <math|h<rsub|p><around|(|a|)>=h<rsub|p><around|(|b|)>>,
      the hash function family <math|H=<around|{|h<rsub|p> :
      p\<in\><around|[|m|]>|}>> is thus universal.

      <\with|color|dark blue>
        <\with|color|black>
          The number of bits for choosing a random element of the family is\ 

          <\equation*>
            log<rsub|2><around*|(|<around*|\||P|\|>|)>=log<rsub|2><around*|(|m|)>
          </equation*>
        </with>
      </with>

      <item>(3 points) <math|H=<around|{|h<rsub|p1,p2>:
      p<rsub|1>,p<rsub|2>\<in\><around|[|m|]>|}>> where <math|m> is a fixed
      prime and

      <\equation*>
        h<rsub|p1,p2><around|(|x<rsub|1>,x<rsub|2>|)>=<around|(|p<rsub|1>x<rsub|1>+p<rsub|2>x<rsub|2>|)>
        mod m.
      </equation*>

      Each of these functions is parameterized by a pair of intergers
      <math|p<rsub|1>> and <math|p<rsub|2>> in [<math|m>], and maps a pair of
      integers <math|x<rsub|1>> and <math|x<rsub|2>> in [<math|m>] to an
      output in [<math|m>].

      Suppose <math|h<rsub|p<rsub|1>,p<rsub|2>><around|(|x<rsub|1>,
      x<rsub|2>|)>=h<rsub|p<rsub|1>,p<rsub|2>><around|(|x<rprime|'><rsub|1>,x<rprime|'><rsub|2>|)>>
      and the pair of intergers <around*|(|<math|x<rsub|1>,x<rsub|2>>|)> and
      <math|<around*|(|x<rsub|1><rprime|'>,x<rsub|2><rprime|'>|)>> differs in
      the first element, namely <math|x<rsub|1>\<neq\>x<rprime|'><rsub|1>>,
      then we have

      <\eqnarray*>
        <tformat|<table|<row|<cell|p<rsub|1><around|(|x<rsub|1>-x<rprime|'><rsub|1>|)>
        \ mod m>|<cell|=>|<cell|p<rsub|2><around|(|x<rprime|'><rsub|2>-x<rsub|2>|)>
        mod m>>>>
      </eqnarray*>

      Our goal is to prove that <math|p<rsub|1>> uniform at random.

      <\itemize-dot>
        <item>Firstly, based on the ``<em|Principle of Deferred Decisions>'',
        we first fixed the choices for <math|p<rsub|2>>, and then considered
        the effect of the random choice of <math|p<rsub|1>> given fixed
        <math|p<rsub|2>>. So the right-hand side of above equation should be
        some fixed number ranges over <math|<around|{|0,1,2,\<ldots\>,m-1|}>>,
        but <math|p<rsub|1>> still randomly ranges over
        <math|<around|[|m|]>>.

        <item>Second of all, integer <math|x<rsub|1>> and
        <math|x<rprime|'><rsub|1>> are in <math|<around*|[|m|]>>, so <math|m>
        is bigger than <math|x<rsub|1>,x<rsub|1><rprime|'>> each. Together
        with the given condition that <math|x<rsub|1>\<neq\>x<rsub|1><rprime|'>>,
        <math|x<rsub|1>-x<rprime|'><rsub|1>> couldn't zero modulo <math|m>.

        <item>Thirdly, <math|m> is prime.
      </itemize-dot>

      Based on the above three ingredients, <math|p<rsub|1>> uniform at
      random and therefore the left-hand side equally likely to be any of
      <math|<around|{|0,1,\<ldots\>,m-1|}>>, which implies
      <math|Prob<around|[|h<rsub|p<rsub|1>,p<rsub|2>><around|(|x|)>=h<rsub|p<rsub|1>,p<rsub|2>><around|(|y|)>|]>=<frac|1|m>>.

      We conclude that for each pair <math|<around|(|x<rsub|1>,x<rsub|2>|)>,<around|(|x<rprime|'><rsub|1>,x<rprime|'><rsub|2>|)>\<in\>X>
      with the pairs <math|x<rsub|1>,x<rprime|'><rsub|1>> and
      <math|x<rsub|2>,x<rprime|'><rsub|2>> not equivalent at the same time,
      at most <math|<frac|<around|\||P|\|>|m>=1> out of the
      <math|<around|\||P|\|>> parameters <math|p<rsub|1>,p<rsub|2><rsub|>>
      could make <math|<around|(|x<rsub|1>,x<rsub|2>|)>> and
      <math|<around|(|y<rsub|1>,y<rsub|2>|)>> collide as
      <math|h<rsub|p<rsub|1>,p<rsub|2>><around|(|x<rsub|1>,x<rsub|2>|)>=h<rsub|p<rsub|1>,p<rsub|2>><around|(|y<rsub|1>,y<rsub|2>|)>>,
      the hash function family <math|H=<around|{|h<rsub|p><around|(|x|)>=p<rsub|1>x<rsub|1>+p<rsub|2>x<rsub|2>
      mod m|}>> is thus universal.

      The number of bits for choosing a random element of the family is\ 

      <\equation*>
        log<rsub|2><around*|(|<around*|\||P|\|>|)>=log<rsub|2><around*|(|m<rsup|2>|)>
      </equation*>

      <item>(3 points) <math|H> is as in part 3.1b except <math|m> is now a
      fixed power of 2 (instead of a prime).

      We'll give a counter-example such that the hash family
      <math|H=<around|{|h<rsub|p<rsub|1>,p<rsub|2>><around|(|x<rsub|1>,x<rsub|2>|)>=p<rsub|1>x<rsub|1>+p<rsub|2>x<rsub|2>
      mod m|}>> where <math|m> is a fixed power of 2 is not universal.

      Suppose <math|x<rsub|1>=0, x<rsub|2>=0>, then
      <math|h<rsub|p<rsub|1>,p<rsub|2>><around|(|x<rsub|1>,x<rsub|2>|)>=0>
      and suppose <math|x<rprime|'><rsub|1>=0,x<rprime|'><rsub|2>=2>, then

      <\eqnarray*>
        <tformat|<table|<row|<cell|h<rsub|p<rsub|1>,p<rsub|2>><around|(|x<rsub|1>-x<rsub|2>|)>
        \ mod m>|<cell|=>|<cell|2p<rsub|2> mod m>>>>
      </eqnarray*>

      If <math|h<rsub|p<rsub|1>,p<rsub|2>><around|(|x<rsub|1>,x<rsub|2>|)>=h<rsub|p<rsub|1>,p<rsub|2>><around|(|x<rprime|'><rsub|1>,x<rprime|'><rsub|2>|)>=0>
      then

      <\equation*>
        <text|<math|2p<rsub|2> mod m=0>>
      </equation*>

      Since <math|m> is a fixed power of 2, and
      <math|p<rsub|2>\<in\><around|[|m|]>>, so <math|p<rsub|2>=0> or
      <math|p<rsub|2>=<frac|m|2>>, and <math|p<rsub|1>> could be any value in
      <math|<around|[|m|]>>.

      Thus, we have <math|2m> pairs of <math|p<rsub|1>,p<rsub|2>> such that

      <with|font-base-size|8|<\eqnarray*>
        <tformat|<table|<row|<cell|h<rsub|p<rsub|1>,0><around|(|0,0|)>>|<cell|=>|<cell|h<rsub|p<rsub|1>,0><around|(|0,2|)><htab|5mm><around*|(|p<rsub|1>\<in\><around*|[|m|]>|)>>>|<row|<cell|h<rsub|p<rsub|1>,<frac|m|2>><around|(|0,0|)>>|<cell|=>|<cell|h<rsub|p<rsub|1>,<frac|m|2>><around|(|0,2|)><htab|5mm><around*|(|p<rsub|1>\<in\><around*|[|m|]>|)>>>>>
      </eqnarray*>>

      Since for pair <math|x<rsub|1>=0>, <math|x<rsub|2>=0> and
      <math|x<rprime|'><rsub|1>=0>, <math|x<rprime|'><rsub|2>=2>,
      <math|<around|\||P|\|>=2m>, <math|<frac|<around|\||P|\|>|m>=2> out of
      the <math|<around|\||P|\|>=m<rsup|2>> parameter pairs
      <math|p<rsub|1>,p<rsub|2>> making <math|x<rsub|1>,x<rsub|2>> and
      <math|x<rprime|'><rsub|1>,x<rprime|'><rsub|2>> collide as
      <math|h<rsub|p<rsub|1>,p<rsub|2>><around|(|x<rsub|1>,x<rsub|2>|)>=h<rsub|p<rsub|1>,p<rsub|2>><around|(|x<rprime|'><rsub|1>,x<rprime|'><rsub|2>|)>>,
      so the hash function family <math|H=<around|{|h<rsub|p<rsub|1>,p<rsub|2>><around|(|x<rsub|1>,x<rsub|2>|)>=p<rsub|1>x<rsub|1>+p<rsub|2>x<rsub|2>
      mod m|}>> is not universal.

      <item>(4 points) <math|H> is the set of all functions from pairs
      <math|x<rsub|1>,x<rsub|2>\<in\><around|[|m|]> to <around|[|m|]>>.

      Suppose <math|P=P<rsub|1>\<times\>P<rsub|2>>,
      <math|<around*|\||P|\|>=n> where <math|n> is unknown. The hash function
      family <math|H=<around*|{|h<rsub|p> : X\<rightarrow\>Y|}>> is universal
      only if for each pair of inputs <math|x<rsub|>> and
      <math|x<rprime|'>\<in\><around*|[|m|]>> with
      <math|x\<neq\>x<rprime|'>>, at most <math|<frac|<around*|\||P|\|>|m>=1>
      out of the <math|<around*|\||P|\|>> parameters make a collision as
      <math|h<rsub|p><around*|(|x<rsub|1>,x<rsub|2>|)>=h<rsub|p><around*|(|x<rsub|1><rprime|'>,x<rsub|2><rprime|'>|)>>.

      <with|font-shape|italic|Case 1>: <math|m> is prime

      Suppose <math|h<rsub|p<rsub|1>,p<rsub|2>><around|(|x<rsub|1>,
      x<rsub|2>|)>=h<rsub|p<rsub|1>,p<rsub|2>><around|(|x<rprime|'><rsub|1>,x<rprime|'><rsub|2>|)>>
      and the pair of intergers <around*|(|<math|x<rsub|1>,x<rsub|2>>|)> and
      <math|<around*|(|x<rsub|1><rprime|'>,x<rsub|2><rprime|'>|)>> differs in
      the first element, namely <math|x<rsub|1>\<neq\>x<rprime|'><rsub|1>>,
      then we have

      <\eqnarray*>
        <tformat|<table|<row|<cell|p<rsub|1><around|(|x<rsub|1>-x<rprime|'><rsub|1>|)>
        \ mod m>|<cell|=>|<cell|p<rsub|2><around|(|x<rprime|'><rsub|2>-x<rsub|2>|)>
        mod m>>>>
      </eqnarray*>

      Our goal is to prove that <math|p<rsub|1>> uniform at random.

      <\itemize-dot>
        <item>Firstly, based on the ``<em|Principle of Deferred Decisions>'',
        we first fixed the choices for <math|p<rsub|2>>, and then considered
        the effect of the random choice of <math|p<rsub|1>> given fixed
        <math|p<rsub|2>>. So the right-hand side of above equation should be
        some fixed number ranges over <math|<around|{|0,1,2,\<ldots\>,m-1|}>>,
        but <math|p<rsub|1>> still randomly ranges over
        <math|<around*|[|n|]>>.

        <item>Second of all, integer <math|x<rsub|1>> and
        <math|x<rprime|'><rsub|1>> are in <math|<around*|[|m|]>>, so <math|m>
        is bigger than <math|x<rsub|1>,x<rsub|1><rprime|'>> each. Together
        with the given condition that <math|x<rsub|1>\<neq\>x<rsub|1><rprime|'>>,
        <math|x<rsub|1>-x<rprime|'><rsub|1>> couldn't zero modulo <math|m>.

        <item>Thirdly, <math|m> is prime.
      </itemize-dot>

      Based on the above three ingredients, <math|p<rsub|1>> uniform at
      random and therefore the left-hand side equally likely to be any of
      <math|<around|{|0,1,\<ldots\>,m-1|}>>, which implies
      <math|Prob<around|[|h<rsub|p<rsub|1>,p<rsub|2>><around|(|x|)>=h<rsub|p<rsub|1>,p<rsub|2>><around|(|y|)>|]>=<frac|1|m>>.

      We conclude that for each pair <math|<around|(|x<rsub|1>,x<rsub|2>|)>,<around|(|x<rprime|'><rsub|1>,x<rprime|'><rsub|2>|)>\<in\>X>
      with the pairs <math|x<rsub|1>,x<rprime|'><rsub|1>> and
      <math|x<rsub|2>,x<rprime|'><rsub|2>> not equivalent at the same time,
      at most <math|<frac|<around|\||P|\|>|m>> out of the
      <math|<around|\||P|\|>> parameters <math|p<rsub|1>,p<rsub|2><rsub|>>
      could make <math|<around|(|x<rsub|1>,x<rsub|2>|)>> and
      <math|<around|(|x<rprime|'><rsub|1>,x<rprime|'><rsub|2>|)>> collide as
      <math|h<rsub|p<rsub|1>,p<rsub|2>><around|(|x<rsub|1>,x<rsub|2>|)>=h<rsub|p<rsub|1>,p<rsub|2>><around|(|x<rprime|'><rsub|1>,x<rprime|'><rsub|2>|)>>,
      the hash function family <math|H> is thus universal.

      <\with|color|dark magenta>
        The number of bits for choosing a random element of the family is\ 

        <\equation*>
          log<rsub|2><around*|(|<around*|\||P|\|>|)>=log<rsub|2><around*|(|n|)>
        </equation*>
      </with>

      <with|font-shape|italic|Case 2>: <math|m> is not prime

      We will give a counter-example showing that the hash function family
      <math|H=<around*|{|h<rsub|p> : X\<rightarrow\>Y|}>> is not universal.

      Suppose <math|d> divides <math|m>, let
      <math|x<rsub|1>=0,x<rsub|2>=0,x<rsub|1><rprime|'>=0,x<rsub|2><rprime|'>=d>,
      then if <math|h<rsub|p><around*|(|x<rsub|1>,x<rsub|2>|)>=h<rsub|p><around*|(|x<rsub|1><rprime|'>,x<rsub|2><rprime|'>|)>>,
      we have\ 

      <\equation*>
        h<rsub|p<rsub|1>,p<rsub|2>><around*|(|x<rsub|1>-x<rsub|2>|)> mod m=d
        p<rsub|2> mod m
      </equation*>

      Both left-hand side and right-hand side of above equation range over
      <math|<around*|[|m|]>>, so let <math|h<rsub|p<rsub|1>,p<rsub|2>><around*|(|x<rsub|1>,x<rsub|2>|)>=h<rsub|p<rsub|1>,p<rsub|2>><around*|(|x<rsub|1><rprime|'>,x<rsub|2><rprime|'>|)>=0>,
      <with|font-shape|italic|i.e.>

      <\equation*>
        d p<rsub|2> mod m=0
      </equation*>

      Because <math|d> divides <math|m> and
      <math|p<rsub|2>\<in\><around*|[|n|]>>, <math|p<rsub|2>> coud either be
      0 or <math|<frac|m|d>>. We haven't condition on <math|p<rsub|1>> and
      thus <math|p<rsub|1>> could be any value in <math|<around*|[|n|]>>. Now
      we have <math|2n> pairs of <math|<around*|(|p<rsub|1>,p<rsub|2>|)>>
      such that\ 

      <with|font-base-size|8|<\eqnarray*>
        <tformat|<table|<row|h<rsub|p<rsub|1>,0><around*|(|0,0|)>|<cell|=>|<cell|h<rsub|p<rsub|1>,0><around*|(|0,d|)><htab|5mm><around*|(|p<rsub|1>\<in\><around*|[|n|]>|)>>>|<row|<cell|h<rsub|p<rsub|1>,<frac|m|d>><around*|(|0,0|)>>|<cell|=>|<cell|h<rsub|p<rsub|1>,<frac|m|d>><around*|(|0,d|)><htab|5mm><around*|(|p<rsub|1>\<in\><around*|[|n|]>|)>>>>>
      </eqnarray*>>

      Since for pairs <math|x<rsub|1>=0,x<rsub|2>=0> and
      <math|x<rsub|1><rprime|'>=0,x<rsub|2><rprime|'>=d>, there are
      <math|<frac|2n|m>> out of <math|n> parameter pairs
      <math|p<rsub|1>,p<rsub|2>> making <math|x<rsub|1>,x<rsub|2>> and
      <math|x<rsub|1><rprime|'>,x<rsub|2><rprime|'>> collide as
      <math|h<rsub|p<rsub|1>,p<rsub|2>><around*|(|x<rsub|1>,x<rsub|2>|)>=h<rsub|p<rsub|1>,p<rsub|2>><around*|(|x<rsub|1><rprime|'>,x<rsub|2><rprime|'>|)>>,
      so the hash function family <math|H> is not universal in this case.
    </enumerate-alpha>

    <\with|color|dark brown>
      <item>(3 points) Hacking a hash function: suppose for a member of the
      hash function family from part 3.1b you have found two inputs
      (<math|x<rsub|1>>, <math|x<rsub|2>>) and
      <math|<around|(|x<rprime|'><rsub|1>, x<rprime|'><rsub|2>|)>> that hash
      to the same value. Describe how to find further inputs that collide.

      (Suppose you are interacting with a server, and you start to suspect
      that the server is using a hash function like this. This sort of
      technique might be used to crash the server, if their hash function
      data structures are not implemented well.)
    </with>

    Because we have found inputs <math|<around|(|x<rsub|1>,x<rsub|2>|)>> and
    <math|<around|(|x<rsub|1><rprime|'>,x<rsub|2><rprime|'>|)>> collide, we
    have

    <\with|font-base-size|8>
      <\eqnarray*>
        <tformat|<cwith|3|3|3|3|cell-hyphen|t>|<table|<row|<cell|<around*|(|p<rsub|1>x<rsub|1>-p<rsub|2>x<rsub|2>|)>
        mod m>|<cell|=>|<cell|<around*|(|p<rsub|1>x<rprime|'><rsub|1>-p<rsub|2>x<rsub|2><rprime|'>
        |)> mod m>>|<row|<cell|<around*|(|<around*|(|p<rsub|1>x<rsub|1>+p<rsub|2>x<rsub|2>|)>-<around*|(|p<rsub|1>x<rsub|1><rprime|'>+p<rsub|2>x<rsub|2><rprime|'>|)>|)>
        mod m>|<cell|=>|<cell|0 mod m>>|<row|<cell|<around*|(|<around*|(|p<rsub|1>x<rsub|1>+p<rsub|2>x<rsub|2>|)>+k<around*|(|p<rsub|1>x<rsub|1>+p<rsub|2>x<rsub|2>-<around*|(|p<rsub|1>x<rsub|1><rprime|'>+p<rsub|2>x<rsub|2><rprime|'>|)>|)>|)>
        mod m>|<cell|=>|<cell|<around*|(|p<rsub|1>x<rsub|1>+p<rsub|2>x<rsub|2>|)>
        mod m<htab|5mm><around*|(|k\<in\>Z<rsup|+>|)>>>|<row|<cell|<around*|(|p<rsub|1><around*|(|x<rsub|1>+k<around*|(|x<rsub|1>-x<rsub|1><rprime|'>|)>|)>+p<rsub|2><around*|(|x<rsub|2>+k<around*|(|x<rsub|2>-x<rsub|2><rprime|'>|)>|)>|)>
        mod m>|<cell|=>|<cell|<around*|(|p<rsub|1>x<rsub|1>+p<rsub|2>x<rsub|2>|)>
        mod m>>|<row|<cell|h<rsub|p<rsub|1>,p<rsub|2>><around*|(|x<rsub|1>+k<around*|(|x<rsub|1>-x<rsub|1><rprime|'>|)>\<nocomma\>\<nocomma\>,x<rsub|2>+k<around*|(|x<rsub|2>-x<rsub|2><rprime|'>|)>|)>>|<cell|=>|<cell|h<rsub|p<rsub|1>,p<rsub|2>><around*|(|x<rsub|1>,x<rsub|2>|)>>>>>
      </eqnarray*>
    </with>

    Similarly, we could also derive that\ 

    <\with|font-base-size|8>
      <\eqnarray*>
        <tformat|<table|<row|<cell|<tabular|<tformat|<table|<row|<cell|h<rsub|p<rsub|1>,p<rsub|2>><around*|(|x<rsub|1><rprime|'>+k<around*|(|x<rsub|1>-x<rsub|1><rprime|'>|)>\<nocomma\>\<nocomma\>,x<rsub|2><rprime|'>+k<around*|(|x<rsub|2>-x<rsub|2><rprime|'>|)>|)>>>>>>>|<cell|=>|<cell|h<rsub|p<rsub|1>,p<rsub|2>><around*|(|x<rsub|1><rprime|'>,x<rsub|2><rprime|'>|)><htab|5mm><around*|(|k\<in\>Z<rsup|+>|)>>>>>
      </eqnarray*>
    </with>

    So we could find futher inputs pairs <math|<around*|(|x<rsub|1><rprime|''>,x<rsub|2><rprime|''>|)>>
    as long as it commits to the form

    <\with|font-base-size|8>
      <\eqnarray*>
        <tformat|<table|<row|<cell|x<rsub|1><rprime|''>>|<cell|=>|<cell|x<rsub|1>+k<around*|(|x<rsub|1>-x<rsub|1><rprime|'>|)>>>|<row|<cell|x<rsub|2><rprime|''>>|<cell|=>|<cell|x<rsub|2>+k<around*|(|x<rsub|1>-x<rsub|1><rprime|'>|)><htab|5mm><around*|(|k\<in\>Z<rsup|+>|)>>>>>
      </eqnarray*>
    </with>

    or

    <with|font-base-size|8|<\eqnarray*>
      <tformat|<table|<row|<cell|x<rsub|1><rprime|''>>|<cell|=>|<cell|x<rsub|1><rprime|'>+k<around*|(|x<rsub|1>-x<rsub|1><rprime|'>|)>>>|<row|<cell|x<rsub|2><rprime|''>>|<cell|=>|<cell|x<rsub|2><rprime|'>+k<around*|(|x<rsub|1>-x<rsub|1><rprime|'>|)><htab|5mm><around*|(|k\<in\>Z<rsup|+>|)>>>>>
    </eqnarray*>>

    <\with|color|dark brown>
      <item>(7 points) A much stronger property than universal hashing is
      <math|k>-<em|independent hashing>. A hash function family
      {<math|h<rsub|p>>} : <math|X\<rightarrow\>Y> is <math|k>-independent if
      for any distinct <math|x<rsub|1>, . . . , x<rsub|k>\<in\>X> and any
      <math|y<rsub|1>, . . . , y<rsub|k> \<in\>Y>, for exactly a
      <math|<frac|1|m<rsup|k>>> fraction of parameters <math|p> we will have
      <math|h<rsub|p><around|(|x<rsub|1>|)> = y<rsub|1>> and
      <math|h<rsub|p><around|(|x<rsub|2>|)> = y<rsub|2>> and <math|...
      h<rsub|p><around|(|x<rsub|k>|)> = y<rsub|k>>.

      For a prime <math|m> consider the family of hash functions from
      <math|<around|[|m|]>> to <math|<around|[|m|]>> parameterized by <math|p
      = <around|(|p<rsub|0>,\<ldots\> ,p<rsub|k-1>|)>>, where
      <math|h<rsub|p><around|(|x|)> = p<rsub|0>+p<rsub|1>x+p<rsub|2>x<rsup|2>+.
      . .+p<rsub|k-1>x<rsup|k-1> mod m>. Show that this family is
      <math|k>-independent.\ 

      (Hint: Recall the familiar fact that for any <math|k> distinct real
      numbers <math|x<rsub|1>, \<ldots\>, x<rsub|k>>, and any <math|k> real
      numbers <math|y<rsub|1>,\<ldots\>,y<rsub|k>>, there is a <em|unique>
      degree <math|k-1> polynomial that passes through these <math|k> pairs
      <math|<around|(|x<rsub|i>,y<rsub|i>|)>>. The same fact is true modulo a
      prime <math|m>. Assume and use this fact.)\ 

      Intuitively, if a hash-function is 10-independent, this means that for
      any 10 elements, their hash destinations will look as though they had
      been chosen uniformly at random. This is very useful for analyzing (and
      preventing) unfortunate hashing patterns involving up to 10 elements,
      because you can deduce that such patterns will occur no more often than
      if the hash destinations had been chosen at random.
    </with>

    Given the hash function family <math|H=<around*|{|h<rsub|p> :
    X\<rightarrow\>Y|}>> from <math|<around*|[|m|]>> to
    <math|<around*|[|m|]>>, there are <math|C<rsub|m><rsup|k>> ways of
    \ choosing <math|k> distinct inputs <math|x<rsub|1>,x<rsub|2>,\<ldots\>,x<rsub|k>>
    from <math|X> and <math|m<rsup|k>> different output because of <math|m>
    different values for each <math|y<rsub|i>\<in\>Y>,
    <math|i\<in\><around*|{|1,2,\<ldots\>,k|}>>. So there will be
    <math|C<rsub|m><rsup|k>\<cdot\>m<rsup|k>> number of ways of mapping
    <math|X> to <math|Y> and the hash function family <math|H> is
    parameterized by the parameter set <math|p> where
    <math|<around*|\||p|\|>=C<rsub|m><rsup|k>\<cdot\>m<rsup|k>>.

    Assume we have the key claim: for any <math|k> distinct real numbers
    <math|x<rsub|1>, \<ldots\>, x<rsub|k>>, and any <math|k> real numbers
    <math|y<rsub|1>,\<ldots\>,y<rsub|k>>, there is a <em|unique> degree
    <math|k-1> polynomial that passes through these <math|k> pairs
    <math|<around|(|x<rsub|i>,y<rsub|i>|)>>. The same fact is true modulo a
    prime <math|m>. Based on this fact, there exists a hash function

    <\equation*>
      h<rsub|p><around*|(|x|)>=p<rsub|0>+p<rsub|1>x+p<rsub|2>x<rsup|2>+\<ldots\>+p<rsub|k-1>x<rsup|k-1>
      mod m
    </equation*>

    such that <math|X\<rightarrow\>Y> from <math|<around*|[|m|]>> to
    <math|<around*|[|m|]>> is parameterized by a unique parameter set.

    For output <math|y<rsub|1>,y<rsub|2>,\<ldots\>,y<rsub|k>>, we can choose
    a distinct input <math|x<rsub|1>,x<rsub|2>\<ldots\>,x<rsub|k>> from
    <math|<around*|[|m|]>> such that <math|h<rsub|p><around*|(|x<rsub|i>|)>=y<rsub|i>>
    for each <math|i\<in\><around*|{|1,2,\<ldots\>,k|}>>. The number of the
    parameters is equivalent to choosing <math|k> input from
    <math|<around*|[|m|]>>, namely <math|C<rsub|m><rsup|k>>, which is exactly
    <math|<frac|1|m<rsup|k>>> fraction of parameter set
    <math|<around*|\||p|\|>> and thus the hash function family
    <math|<around*|{|h<rsub|p>|}> : X\<rightarrow\>Y> is
    <math|k>-independent.

    <\with|color|dark brown>
      <item>(7 points) The hash function family
      <math|h<rsub|p><around*|(|x|)>> of the previous part is a bit odd
      because it maps <math|[m]> to itself. Consider instead a prime <math|q>
      that is smaller than <math|m>, and consider instead a new hash function
      family <math|h<rsub|p><rprime|'>(x)> from <math|[m]> to <math|[q]>
      computed as: <math|h<rprime|'><rsub|p>(x) = h<rsub|p>(x) mod q =
      (p<rsub|0> + p<rsub|1>x + p<rsub|2>x<rsub|2> + . . . +
      p<rsub|k-1>x<rsup|k-1> mod m) mod q><emdash>the hash function from the
      previous part, parameterized identically, but then taken modulo
      <math|q>. This new hash function family
      <math|h<rsub|p><rprime|'><around*|(|x|)>> will
      <with|font-shape|italic|not> be <math|k>-independent, but in many cases
      it will be ``close enough for practical purpose''. (Note that, unlike
      for the previous part of this problem, the range of <math|h<rprime|'>>
      has size <math|q> instead of <math|m>.)

      Find bounds on the fraction of parameters <math|p> such that
      <math|h<rprime|'><rsub|p><around*|(|x<rsub|1>|)>=y<rsub|1>> and
      <math|h<rprime|'><rsub|p><around*|(|x<rsub|2>|)>=y<rsub|2>> and
      <math|\<ldots\>> <math|h<rsub|p><rprime|'><around*|(|x<rsub|k>|)>=y<rsub|k>>,
      when <math|x<rsub|1>,\<ldots\>,x<rsub|k>> are distinct elements of
      <math|<around*|[|m|]>> and <math|y<rsub|1>,\<ldots\>,y<rsub|k>> are
      elements of <math|<around*|[|q|]>>.

      Use these bounds and the approximation <math|e<rsup|x>\<approx\>1+x>
      for small <math|x> to show that (subject to this approximation), when
      <math|q> is smaller than <math|m/k>, then the fraction of <math|p> such
      that <math|h<rsub|p><rprime|'><around*|(|x<rsub|1>|)>=y<rsub|1>> and
      <math|h<rsub|p><rprime|'><around*|(|x<rsub|2>|)>=y<rsub|2>> and
      <math|\<ldots\>> <math|h<rsub|p><rprime|'><around*|(|x<rsub|k>|)>=y<rsub|k>>
      is within a factor of <math|e> of <math|<frac|1|q<rsup|k>>>. (Thus, the
      hash function family <math|h<rsub|p><rprime|'><around*|(|x|)>> is
      ``e-close to being <math|k>-independent''.)
    </with>

    <math|X> in <math|<around*|[|m|]>> maps to <math|m<rsup|k>> number of
    output of <math|h<rsub|p><around*|(|x<rsub|i>|)>> in <math|Y<rprime|'>>
    ranging over <math|<around*|[|m|]>>. <math|Y<rprime|'>> is then taken
    modulo <math|q> and mapped to <math|y<rsub|1>,y<rsub|2>,\<ldots\>,y<rsub|k>>
    in <math|Y> ranging over <math|<around*|[|q|]>>. We claim that the
    mapping relation is as <math|X\<rightarrow\>Y<rprime|'>\<rightarrow\>Y>.

    Each of the output from <math|Y<rprime|'>> will be mapped to at least
    <math|\<lfloor\><frac|m|q>\<rfloor\>\<nocomma\>> and at most
    <math|\<lceil\><frac|m|q>\<rceil\>> number of outputs from <math|Y>
    within <math|<around*|[|q|]>>. Thus, the <math|k> outputs from <math|Y>
    are determined by <math|<around*|[|\<lfloor\><frac|m|q>\<rfloor\>\<nocomma\><rsup|k>,\<lceil\><frac|m|q>\<rceil\><rsup|k>|]>>
    outputs from <math|Y<rprime|'>>. And according to
    <with|font-shape|italic|Question 3.3>, we know that exactly
    <math|<frac|1|m<rsup|k>>> fraction of all parameters <math|p> maps
    <math|k> distinct elements from <math|X> to <math|Y<rprime|'>>, so the
    bound on the fraction of parameters <math|p> that maps <math|k> distinct
    <math|X> to <math|Y> by element is <math|<around*|[|<frac|\<lfloor\><frac|m|q>\<rfloor\>\<nocomma\><rsup|k>|m<rsup|k>>,<frac|\<lceil\><frac|m|q>\<rceil\><rsup|k>|m<rsup|k>>|]>>.

    For the left bound

    <\eqnarray*>
      <tformat|<table|<row|<cell|<frac|\<lfloor\><frac|m|q>\<rfloor\>\<nocomma\><rsup|k>|m<rsup|k>>>|<cell|\<geqslant\>>|<cell|<frac|<around*|(|<frac|m|q>-1|)>\<nocomma\><rsup|k>|m<rsup|k>>>>|<row|<cell|>|<cell|=>|<cell|<frac|<around*|(|<frac|m|q><around*|(|1-<frac|q|m>|)>|)>\<nocomma\><rsup|k>|m<rsup|k>>>>|<row|<cell|>|<cell|\<gtr\>>|<cell|<frac|<frac|m<rsup|k>|q<rsup|k>><around*|(|1-<frac|1|k>|)><rsup|k>|m<rsup|k>><htab|5mm><around*|(|q\<less\>m/k|)>>>|<row|<cell|>|<cell|=>|<cell|<frac|<around*|(|1-<frac|1|k>|)><rsup|k>|q<rsup|k>>>>|<row|<cell|>|<cell|\<approx\>>|<cell|<frac|<around*|(|e<rsup|-<frac|1|k>>|)><rsup|k>|q<rsup|k>><htab|5mm><around*|(|e<rsup|x>\<approx\>1-x|)>>>|<row|<cell|>|<cell|=>|<cell|<frac|1|e
      q<rsup|k>>>>>>
    </eqnarray*>

    For the right bound

    <\eqnarray*>
      <tformat|<table|<row|<cell|<frac|\<lceil\><frac|m|q>\<rceil\><rsup|k>|m<rsup|k>>>|<cell|\<leqslant\>>|<cell|<frac|<around*|(|<frac|m|q>+1|)>\<nocomma\><rsup|k>|m<rsup|k>>>>|<row|<cell|>|<cell|=>|<cell|<frac|m<rsup|k><around*|(|<frac|1|q>+<frac|1|m>|)>\<nocomma\><rsup|k>|m<rsup|k>>>>|<row|<cell|>|<cell|=>|<cell|<frac|1|q<rsup|k>><around*|(|1+<frac|q|m>|)><rsup|k>>>|<row|<cell|>|<cell|\<less\>>|<cell|<frac|1|q<rsup|k>><around*|(|1+<frac|1|k>|)><rsup|k><htab|5mm><around*|(|q\<less\>m/k|)>>>|<row|<cell|>|<cell|\<approx\>>|<cell|<frac|<around*|(|e<rsup|<frac|1|k>>|)><rsup|k>|q<rsup|k>><htab|5mm><around*|(|e<rsup|x>\<approx\>1-x|)>>>|<row|<cell|>|<cell|=>|<cell|<frac|e|q<rsup|k>>>>>>
    </eqnarray*>

    \;

    Thus, the hash function family <math|h<rsub|p><rprime|'><around*|(|x|)>>
    is ``e-close to being <math|k>-independent''.
  </enumerate-numeric>
</body>

<\initial>
  <\collection>
    <associate|par-hyphen|normal>
  </collection>
</initial>

<\references>
  <\collection>
    <associate|auto-1|<tuple|1|1>>
    <associate|auto-2|<tuple|1|?>>
  </collection>
</references>

<\auxiliary>
  <\collection>
    <\associate|toc>
      <vspace*|1fn><with|font-series|<quote|bold>|math-font-series|<quote|bold>|Problem
      3> <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-1><vspace|0.5fn>
    </associate>
  </collection>
</auxiliary>