
# let A = 2-D array
# initialize A[0, x] = 0 for x = 0,1,2,...,W
# for i = 1,2,3,...n:
#     for x = 0,2,3,...,w:
#         A[i, x] := max{A[i - 1, x], A[i - 1, x - w_i] + v_i} // x - w_i cannot underflow
# return A[n, w]

import sys
import functools

sys.setrecursionlimit(2000)

def decorator(d):
    def _d(fn):
        return functools.update_wrapper(d(fn), fn)
    return _d
decorator = decorator(decorator)

@decorator
def trace(f):
    indent = '   '
    def _f(*args):
        signature = '%s(%s)' % (f.__name__, ', '.join(map(repr, args)))
        print '%s--> %s' % (trace.level * indent, signature)
        trace.level += 1
        try:
            result = f(*args)
            print '%s<-- %s == %s' % ((trace.level - 1) * indent, signature, result)
        finally:
            trace.level -= 1
        return result
    trace.level = 0
    return _f

@decorator
def memo(f):
    cache = {}
    def _f(*args):
        try:
            return cache[args]
        except KeyError:
            result = f(*args)
            cache[args] = result
            return result
        except TypeError:
            return f(*args)
    _f.cache = cache
    return _f

global items

def getMaxKnapsack(W, N, A):
    global items
    for i in xrange(1, N + 1):
        for x in xrange(1, W + 1):
            pw = x - items[i - 1][1]
            A[i][x] = max([A[i - 1][x], A[i - 1][pw] + items[i - 1][0] if pw >= 0 else 0])
    return A[N][W]

@memo
def getMaxKnapsackRecv(N, W):
    if N == 0 or W == 0: return 0
    pw = W - items[N - 1][1]
    return max([getMaxKnapsackRecv(N - 1, W), \
            getMaxKnapsackRecv(N - 1, pw) + items[N - 1][0] if pw >= 0 else 0])

def read(fileName):
    with open(fileName, "r") as f:
        lines = f.readlines()
        array = list(map(int, filter((lambda c: c != '\n'), line.split(' '))) for line in lines[1:])
        return array, int(lines[0].split(' ')[0]), int(lines[0].split(' ')[1])

#def test(fileName="debug.txt"):
def test(fileName="knapsack2.txt"):
    global items
    items, knapsack_size, num_of_items = read(fileName)
    print getMaxKnapsackRecv(num_of_items, knapsack_size)

test()
