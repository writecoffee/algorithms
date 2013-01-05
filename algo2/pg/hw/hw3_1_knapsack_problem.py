
# let A = 2-D array
# initialize A[0, x] = 0 for x = 0,1,2,...,W
# for i = 1,2,3,...n:
#     for x = 0,2,3,...,w:
#         A[i, x] := max{A[i - 1, x], A[i - 1, x - w_i] + v_i} // x - w_i cannot underflow
# return A[n, w]

global items

def getMaxKnapsack(W, N, A):
    global items
    for i in xrange(1, N + 1):
        for x in xrange(1, W + 1):
            pw = x - items[i - 1][1]
            A[i][x] = max([A[i - 1][x], A[i - 1][pw] + items[i - 1][0] if pw >= 0 else 0])
    return A[N][W]

def read(fileName):
    with open(fileName, "r") as f:
        lines = f.readlines()
        array = list(map(int, filter((lambda c: c != '\n'), line.split(' '))) for line in lines[1:])
        return array, int(lines[0].split(' ')[0]), int(lines[0].split(' ')[1])

def test(fileName="knapsack1.txt"):
    global items
    items, knapsack_size, num_of_items = read(fileName)
    A = [[0,] * (knapsack_size + 1) for x in xrange(num_of_items + 1)]
    print getMaxKnapsack(knapsack_size, num_of_items, A)

test()
