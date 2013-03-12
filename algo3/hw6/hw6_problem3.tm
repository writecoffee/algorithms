<TeXmacs|1.0.7.4>

<style|letter>

<\body>
  <surround|||<doc-data|<doc-title|CS157 Homework
  6>|<\doc-author-data|<author-name|tqian and silao_xu>>
    \;
  </doc-author-data>|<doc-date|<date|>>>>

  <section|Problem 3>

  <\enumerate-numeric>
    <item>When choosing a hash function, we want to make sure that collisions
    are unlikely. One way to ensure this is to randomly choose a hash
    function from a large family, where different functions in the hash
    function family scramble elements in different ways. A hash function
    family <math|H> is a family of functions {<math|h<rsub|p>>} :
    <math|X\<rightarrow\>Y> , where <math|p> ranges over <em|parameters> in a
    set P. Throughout this problem, we will let <math|m> be the size of the
    range of the hash function family, <math|m=\|Y\|>. Typically, a hash
    function is parameterized by several parameters; for example, if <math|h>
    is parameterized by triples <math|p = (p<rsub|1>, p<rsub|2>, p<rsub|3>)>,
    where <math|p<rsub|1>> ranges over some set <math|P<rsub|1>>,
    <math|p<rsub|2>> ranges over some set <math|P<rsub|2>>, and
    <math|p<rsub|3>> ranges over some set <math|P<rsub|3>>, then the universe
    of parameters <math|P> consists of all values of these triples.
    Specifically, <math|P=P<rsub|1>\<times\>P<rsub|2>\<times\>P<rsub|3>>, and
    <math|\|P\|=\|P<rsub|1>\|\<cdot\>\|P<rsub|2>\|\<cdot\>\|P<rsub|3>\|>.

    A hash function family <math|H> is called universal if for each pair
    <math|a,b\<in\>X> with <math|a\<neq\>b>, at most
    <frac|\|<math|P>\||<math|m>> out of the <math|\|P\|> parameters <math|p>
    make <math|a> and <math|b> collide as <math|h<rsub|p>(a)=h<rsub|p>(b)>.

    For each of the following hash function families, either prove it is
    universal or give a counterexample. Additionally, compute how many bits
    are needed to choose a random element of the family (namely, compute
    <math|log<rsub|2>\|P\|> in each case).

    The notation [<math|m>] denotes the set of integers
    {<math|0,1,2,\<ldots\>,m-1>}.

    <\enumerate-alpha>
      <item>(3 points) <math|H> = {<math|h<rsub|p>> :
      <math|p\<in\>>[<math|m>]} where <math|m> is a fixed prime and

      <\equation*>
        h<rsub|p>(x)=p x mod m.
      </equation*>

      Each of these functions is parameterized by an integer <math|p> in
      <math|[m]>, and maps an integer <math|x> in [<math|m>] to an output in
      [<math|m>].

      The hash function family <math|H={h<rsub|p>: p\<in\>[m]}> where
      <math|m> is a fixed prime is universal if and only if for each pair
      <math|a,b\<in\>X> with <math|a\<neq\>b>, at most
      <math|<frac|\|P\||m>=1> out of the <math|\|P\|> paramaters <math|p>
      make <math|a> and <math|b> collide as <math|h<rsub|p>(a)=h<rsub|p>(b)>.

      If <math|h<rsub|p>(a)=h<rsub|p>(b)> and <math|a\<neq\>b>, then we have

      <\eqnarray*>
        <tformat|<table|<row|<cell|p a mod m>|<cell|=>|<cell|p b mod
        m>>|<row|<cell|p a mod m - p b mod
        m>|<cell|=>|<cell|0>>|<row|<cell|p(a-b) mod m>|<cell|=>|<cell|0>>>>
      </eqnarray*>

      Because <math|a\<neq\>b> (and thus <math|a-b \<neq\>0 mod m>) and
      <math|><math|m> is prime, <math|p> uniform at random. In addition,
      <math|m> is larger than any of <math|p\<in\>[m]>, left-hand side
      euqally likely to be any of <math|{0,1,2,\<ldots\>,m-1}>, which implies
      <math|Prob[h<rsub|p>(x)=h<rsub|p>(y)]=<frac|1|m>>.

      We conclude that because for each pair <math|a,b\<in\>X> with
      <math|a\<neq\>b>, at most <math|<frac|\|P\||m>=1> out of the
      <math|\|P\|> parameters <math|p> could make <math|a> and <math|b>
      collide as <math|h<rsub|p>(a)=h<rsub|p>(b)>, \ the hash function family
      <math|H={h<rsub|p> : p\<in\>[m]}> is universal.

      <item>(3 points) <math|H={h<rsub|p1,p2>: p<rsub|1>,p<rsub|2>\<in\>[m]}>
      where <math|m> is a fixed prime and

      <\equation*>
        h<rsub|p1,p2>(x<rsub|1>,x<rsub|2>)=(p<rsub|1>x<rsub|1>+p<rsub|2>x<rsub|2>)
        mod m.
      </equation*>

      Each of these functions is parameterized by a pair of intergers
      <math|p<rsub|1>> and <math|p<rsub|2>> in [<math|m>], and maps a pair of
      integers <math|x<rsub|1>> and <math|x<rsub|2>> in [<math|m>] to an
      output in [<math|m>].

      If <math|h<rsub|p<rsub|1>,p<rsub|2>>(x<rsub|1>,
      x<rsub|2>)=h<rsub|p<rsub|1>,p<rsub|2>>(y<rsub|1>,y<rsub|2>)> and
      <math|x<rsub|1>\<neq\>y<rsub|1>>, then we have

      <\eqnarray*>
        <tformat|<table|<row|<cell|p<rsub|1>(x<rsub|1>-y<rsub|1>) \ mod
        m>|<cell|=>|<cell|p<rsub|2> (y<rsub|2>-x<rsub|2>) mod m>>>>
      </eqnarray*>

      We condition on <math|p<rsub|2>>, namely with <math|p<rsub|2>> fixed
      arbitrarily, so right-hand side should be some fixed number ranges over
      <math|{0,1,2,\<ldots\>,m-1}>. But <math|p<rsub|<rsub|1>>> still
      randomly ranges over <math|[m]> and because
      <math|x<rsub|1>\<neq\>y<rsub|1>> (and thus
      <math|x<rsub|1>-y<rsub|1>\<neq\>0 mod m)>.

      <math|m> is larger than any <math|p\<in\>P>, so
      <math|x<rsub|1>-y<rsub|1>> is non-zero modulo <math|m>. Also <math|m>
      is prime, <math|p<rsub|1>> uniform at random, so left-hand side equally
      likely to be any of <math|{0,1,\<ldots\>,m-1}>, which implies
      <math|Prob[h<rsub|p<rsub|1>,p<rsub|2>>(x)=h<rsub|p<rsub|1>,p<rsub|2>>(y)]=<frac|1|m>>.

      We conclude that because for each pair
      <math|(x<rsub|1>,x<rsub|2>),(y<rsub|1>,y<rsub|2>)\<in\>X> with the pair
      <math|x<rsub|1>,y<rsub|1>> and <math|x<rsub|2>,y<rsub|2>> not
      equivalent at the same time, at most <math|<frac|\|P\||m>=1> out of the
      <math|\|P\|> parameters <math|p<rsub|1>,p<rsub|2><rsub|>> could make
      <math|(x<rsub|1>,x<rsub|2>)> and <math|(y<rsub|1>,y<rsub|2>)> collide
      as <math|h<rsub|p<rsub|1>,p<rsub|2>>(x<rsub|1>,x<rsub|2>)=h<rsub|p<rsub|1>,p<rsub|2>>(y<rsub|1>,y<rsub|2>)>,
      the hash function family <math|H={h<rsub|p>(x)=p<rsub|1>x<rsub|1>+p<rsub|2>x<rsub|2>
      mod m}> is universal.

      <item>(3 points) <math|H> is as in part 3.1b except <math|m> is now a
      fixed power of 2 (instead of a prime).

      We'll give a counter-example such that the hash family
      <math|H={h<rsub|p<rsub|1>,p<rsub|2>>(x<rsub|1>,x<rsub|2>)=p<rsub|1>x<rsub|1>+p<rsub|2>x<rsub|2>
      mod m}> where <math|m> is a fixed power of 2 is not universal.

      Suppose <math|x<rsub|1>=0, x<rsub|2>=0>, then
      <math|h<rsub|p<rsub|1>,p<rsub|2>>(x<rsub|1>,x<rsub|2>)=0> and suppose
      <math|y<rsub|1>=0,y<rsub|2>=2>, then

      <\eqnarray*>
        <tformat|<table|<row|<cell|h<rsub|p<rsub|1>,p<rsub|2>>(x<rsub|1>-x<rsub|2>)
        \ mod m>|<cell|=>|<cell|2p<rsub|2> mod m>>>>
      </eqnarray*>

      If <math|h<rsub|p<rsub|1>,p<rsub|2>>(x<rsub|1>,x<rsub|2>)=h<rsub|p<rsub|1>,p<rsub|2>>(y<rsub|1>,y<rsub|2>)=0>
      then

      <\equation*>
        <with|mode|text|<math|2p<rsub|2> mod m=0>>
      </equation*>

      Since <math|m> is a fixed power of 2, and <math|p<rsub|2>\<in\>[m]>, so
      <math|p<rsub|2>=0> or <math|p<rsub|2>=<frac|m|2>>, and <math|p<rsub|1>>
      could be any value in <math|[m]>.

      Thus, we have <math|2m> pairs of <math|p<rsub|1>,p<rsub|2>> such that

      <\equation*>
        h<rsub|p<rsub|1>,0>(0,0)=h<rsub|p<rsub|1>,0>(0,2) and
        h<rsub|p<rsub|1>,<frac|m|2>>(0,0)=h<rsub|p<rsub|1>,<frac|m|2>>(0,2),p<rsub|1>\<in\>[m]
      </equation*>

      Since for pair <math|x<rsub|1>=0>, <math|x<rsub|2>=0> and
      <math|y<rsub|1>=0>, <math|y<rsub|2>=2>, <math|\|P\|=2m>,
      <math|<frac|\|P\||m>=2> out of the <math|\|P\|=m<rsup|2>> parameter
      pairs <math|p<rsub|1>,p<rsub|2>> making <math|x<rsub|1>,x<rsub|2>> and
      <math|y<rsub|1>,y<rsub|2>> collide as
      <math|h<rsub|p<rsub|1>,p<rsub|2>>(x<rsub|1>,x<rsub|2>)=h<rsub|p<rsub|1>,p<rsub|2>>(y<rsub|1>,y<rsub|2>)>,
      so the hash function family <math|H={h<rsub|p<rsub|1>,p<rsub|2>>(x<rsub|1>,x<rsub|2>)=p<rsub|1>x<rsub|1>+p<rsub|2>x<rsub|2>
      mod m}> is not universal.

      <item>(4 points) <math|H> is the set of all functions from pairs
      <math|x<rsub|1>,x<rsub|2>\<in\>[m] to [m]>.

      \;
    </enumerate-alpha>

    <item>(3 points) Hacking a hash function: suppose for a member of the
    hash function family from part 3.1b you have found two inputs
    (<math|x<rsub|1>>, <math|x<rsub|2>>) and <math|(x<rprime|'><rsub|1>,
    x<rprime|'><rsub|2>)> that hash to the same value. Describe how to find
    further inputs that collide.\ 

    (Suppose you are interacting with a server, and you start to suspect that
    the server is using a hash function like this. This sort of technique
    might be used to crash the server, if their hash function data structures
    are not implemented well.)

    Because we have found inputs <math|(x<rsub|1>,x<rsub|2>)> and
    <math|(x<rsub|1><rprime|'>,x<rsub|2><rprime|'>)> collide, we have:

    <\eqnarray*>
      <tformat|<table|<row|<cell|p<rsub|1>(x<rsub|1>-x<rprime|'><rsub|1>)
      \ mod m>|<cell|=>|<cell|p<rsub|2> (x<rprime|'><rsub|2>-x<rsub|2>) mod
      m>>>>
    </eqnarray*>

    The right-hand side fixed, and <math|m> and <math|p<rsub|1>> are fixed as
    well, as long as <math|x<rsub|3>-x<rsub|3><rprime|'>> is <math|k> times
    (<math|><math|k> is in <math|Z>*) <math|x<rsub|1>-x<rsub|1><rprime|'>>,
    we could find as many as possible pairs of
    <math|(x<rsub|3>,x<rsub|3><rprime|'>)> to crash the server?.

    <item>(7 points) A much stronger property than universal hashing is
    <math|k>-<em|independent hashing>. A hash function family
    {<math|h<rsub|p>>} : <math|X\<rightarrow\>Y> is <math|k>-independent if
    for any distinct <math|x<rsub|1>, . . . , x<rsub|k>\<in\>X> and any
    <math|y<rsub|1>, . . . , y<rsub|k> \<in\>Y>, for exactly a
    <math|<frac|1|m<rsup|k>>> fraction of parameters <math|p> we will have
    <math|h<rsub|p>(x<rsub|1>) = y<rsub|1>> and <math|h<rsub|p>(x<rsub|2>) =
    y<rsub|2>> and <math|... h<rsub|p>(x<rsub|k>) = y<rsub|k>>.

    For a prime <math|m> consider the family of hash functions from
    <math|[m]> to <math|[m]> parameterized by <math|p = (p<rsub|0>,\<ldots\>
    ,p<rsub|k-1>)>, where <math|h<rsub|p>(x) =
    p<rsub|0>+p<rsub|1>x+p<rsub|2>x<rsup|2>+. . .+p<rsub|k-1>x<rsup|k-1> mod
    m>. Show that this family is <math|k>-independent.\ 

    (Hint: Recall the familiar fact that for any <math|k> distinct real
    numbers <math|x<rsub|1>, \<ldots\>, x<rsub|k>>, and any <math|k> real
    numbers <math|y<rsub|1>,\<ldots\>,y<rsub|k>>, there is a <em|unique>
    degree <math|k-1> polynomial that passes through these <math|k> pairs
    <math|(x<rsub|i>,y<rsub|i>)>. The same fact is true modulo a prime
    <math|m>. Assume and use this fact.)\ 

    Intuitively, if a hash-function is 10-independent, this means that for
    any 10 elements, their hash destinations will look as though they had
    been chosen uniformly at random. This is very useful for analyzing (and
    preventing) unfortunate hashing patterns involving up to 10 elements,
    because you can deduce that such patterns will occur no more often than
    if the hash destinations had been chosen at random.
  </enumerate-numeric>
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
      3> <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-1><vspace|0.5fn>
    </associate>
  </collection>
</auxiliary>