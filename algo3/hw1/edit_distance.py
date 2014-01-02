
def compute(s1, s2):
    ilen, jlen = len(s1) + 1, len(s2) + 1
    array = [[0,] * (jlen) for _ in xrange(ilen)]
    for j in xrange(1, jlen):
        array[0][j] = j;

    for i in xrange(1, ilen):
        array[i % 2][0] = i;
        for j in xrange(1, jlen):
            if s1[i - 1] == s2[j - 1]:
                array[i][j] = array[i - 1][j - 1]
            else:
                array[i][j] = min([array[i - 1][j-1], array[i - 1][j], array[i][j - 1]]) + 1
    return array[ilen - 1][jlen - 1]



def test(s1=bytearray("cat"), s2=bytearray("crat")):
    print compute(s1, s2)

test()
