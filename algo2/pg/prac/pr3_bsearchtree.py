
def getValue(matrix, i, j):
    if i > 7 or j > 7: return 0
    if i > j: return 0
    else:
        return matrix[i][j]

def compute(matrix, n):
    p = ["dummy", 0.05, 0.4, 0.08, 0.04, 0.1, 0.1, 0.23]
    for i in range(1, n + 1):
        matrix[i][i] = p[i]

    for s in range(n):
        for i in range(1, n + 1):
            if i + s > 7: continue
            if i == i + s: continue
            matrix[i][i + s] = min([sum(p[i:i+s+1]) + getValue(matrix, i, r - 1) + getValue(matrix, r + 1, i + s) for r in range(i, i + s + 1)])

    print matrix[1][n]

def test():
    n = 7
    matrix = [[0,] * (n+1) for x in xrange(n+1)]
    compute(matrix, n)

test()
