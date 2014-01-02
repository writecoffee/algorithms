<TeXmacs|1.0.7.19>

<style|generic>

<\body>
  <doc-data|<doc-title|Principal Components Analysis>>

  <\itemize>
    <item><strong|Punchline>

    It is about using sophisticated tools to reveal things you wouldn't know
    to look for otherwise; also, it gives us faith in the Fourier (or cosine)
    transform that we can recover something essentially the same via this
    purely <with|color|blue|statistical> technique.

    <item><strong|Significance>

    Matrix <math|u> should be <math|256\<times\>256>, where each column
    represents a <math|16\<times\>16> image chunk; where collectively all 256
    image chunks (columns) can be added together in different combinations to
    represent all <math|16\<times\>16> image blocks; and where the first
    column is the most important image chunk and etc.

    If we can only pick 10 coefficients <math|c<rsub|1>,\<ldots\>,c<rsub|10>>
    to represent an image, we should pick the first 10 chunks to multiple
    with the <math|c> vector.

    The resulting 256 <math|16\<times\>16> blocks, arranged in 16 rows of 16
    columns could be used to generate an image similar to <em|Discrete Cosine
    Transform> <with|color|blue|basis> one by arranging them from top left to
    the right in descending order of importance.

    <item><strong|Take-home Message>

    We put this problem on the set because it is a powerful analytic
    technique with a broad range of applications. Most directly, this can be
    used not just for images but also for sound compression. Less directly,
    principal components analysis (PCA) can be used on many types of data,
    even discrete, and is commonly found in machine learning, pattern
    recognition, data mining to name a few. By preprocessing features with
    PCA before feeding them into some other algorithm (possibly a classifier
    like a support vector machine (SVM) or a statistical model like a hidden
    Markov model (HMM)) one can allow the more powerful algorithm to focus on
    the ``important'' parts of the data and thus do a better job than it
    would have on the unprocessed data.\ 

    The PCA basis looks similar to the cosine basis: <with|color|blue|the
    first elements of each are basically the same; the next two elements of
    the PCA look like a rearrangement of the two elements on the second
    diagonal of the cosine basis (possibly rotated); the next three elements
    of the PCA look like a rearrangement of the 3 elements on the 3rd
    diagonal of the cosine basis; after this it becomes slightly harder,
    visually, to match up parts of the two bases.> But both go from
    representing coarse detail to representing fine detail. Both are
    <em|<with|color|blue|<with|color|red|orthonormal>>>, meaning that each
    basis vector (<math|16\<times\>16> image chunk) from one of the two bases
    has a dot product of 0 with every other basis vector in its basis.
  </itemize>
</body>

<\initial>
  <\collection>
    <associate|page-type|letter>
  </collection>
</initial>