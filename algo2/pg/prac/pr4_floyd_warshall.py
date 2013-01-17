
import itertools
import sys

def floyd_warshall(A, n, edges):
    print edges
    for i in xrange(1, n + 1):
        for j in xrange(1, n + 1):
            if i == j:
                A[0][i][j] = 0
            elif (i, j) in edges:
                A[0][i][j] = edges[(i, j)]
            elif i != j and (i, j) not in edges:
                A[0][i][j] = sys.maxint
    print A[0]
    print A
    for k in xrange(1, n + 1):
        for i in xrange(1, n + 1):
            for j in xrange(1, n + 1):
                A[k][i][j] = min(A[k - 1][i][j], A[k - 1][i][k] + A[k - 1][k][j])
    for row in A[n]:
        print row

def getPair(t):
    return (t[0], t[1]), t[2]

def read(fileName):
    with open(fileName, "r") as f:
        lines = f.readlines()
        array = dict(getPair(map(int, filter((lambda c: c != '\n'), line.split(' ')))) for line in lines[1:])
        return array, int(lines[0].split(' ')[0]), int(lines[0].split(' ')[1])

def test(fileName="test"):
    edges, n, edge_cnt = read(fileName)
    A = [[[sys.maxint, ] * (n + 1) for _ in xrange(n + 1)]  for _ in xrange(n + 1)]
    floyd_warshall(A, n, edges)

def testClique(n=4):
    edges = {}
    for (x, y) in itertools.combinations(range(1, n + 1), 2):
        edges[(x, y)], edges[(y, x)] = -1, -1
    A = [[[sys.maxint, ] * (n + 1) for _ in xrange(n + 1)]  for _ in xrange(n + 1)]
    floyd_warshall(A, n, edges)

test()
testClique()
