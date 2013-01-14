
import copy
import sys
import heapq

GReverse = {0: {}}
GPrime = {0: {}}
edges = None
nodes_cnt = None
edges_cnt = None

def printA():
    for i in xrange(nodes_cnt + 1):
        for j in xrange(nodes_cnt + 1):
            print 'length-limit %d, from %d, to: %d, cost: %d' % (i, 0, j, A[i][j])


def Dijkstra(s):
    finished = {}
    heap = [(0, s)]
    dist_so_far = {s: 0}
    while dist_so_far:
        cost, u = heapq.heappop(heap)
        if u in finished or (u in dist_so_far and dist_so_far[u] < cost):
            continue
        del dist_so_far[u]
        finished[u] = cost
        for v in [v for v in GPrime[u] if v not in finished]:
            if v not in dist_so_far or finished[u] + GPrime[u][v]):
                dist_so_far[v] = finished[u] + GPrime[u][v]
                heapq.heappush(heap, (dist_so_far[v], v))
    return min(map(lambda k, v: v, finished.iteritems()))


def BellmanFord(s=0):
    global GReverse, GPrime, nodes_cnt, edges_cnt
    A = [[0,] * (nodes_cnt + 1) for _ in xrange(nodes_cnt + 1)]
    for i in xrange(1, nodes_cnt + 1):
        A[s][i] = sys.maxint
    for i in xrange(1, nodes_cnt + 1):
        for v in GPrime.keys():
            A[i][v] = min([A[i - 1][v], min([A[i - 1][w] + GReverse[v][w] for w in GReverse[v]])])
    for i in xrange(nodes_cnt + 1):
        if A[nodes_cnt - 1][i] != A[nodes_cnt][i]:
            print i, A[nodes_cnt - 1][i], A[nodes_cnt][i]
    C = {}
    for u in GPrime:
        for v in G[u]:
            GPrime[u][v] = GPrime[u][v] + A[nodes_cnt - 1][u] - A[nodes_cnt - 1][v]

    for v in GPrime.keys():
        

    for u in GPrime:
        for v in GPrime[u]:
            shortest += [GPrime[u][v] - A[nodes_cnt - 1][u] + A[nodes_cnt - 1][v]]
    return min(shortest)

def JohnsonAlgo():
    pass

def buildGraph(edges):
    global GReverse, GPrime
    for u, v, cost in edges:
        # construct G'
        if u not in GPrime[0]:
            GPrime[0][v] = 0
        if v not in GPrime[0]:
            GPrime[0][u] = 0
        if u not in GPrime:
            GPrime[u] = {}
        GPrime[u][v] = cost
        # construct traditional G
        if v not in GReverse:
            GReverse[v] = {}
        if u not in GReverse:
            GReverse[u] = {}
        GReverse[v][u] = cost
        for k in GReverse.keys():
            GReverse[k][0] = 0

def read(fileName):
    with open(fileName, "r") as f:
        lines = f.readlines()
        array = list(map(int, filter((lambda c: c != '\n'), line.split(' '))) for line in lines[1:])
        return array, int(lines[0].split(' ')[0]), int(lines[0].split(' ')[1])

def test(fileName="g3.txt"):
    global edges, nodes_cnt, edges_cnt
    edges, nodes_cnt, edges_cnt = read(fileName)
    buildGraph(edges)
    JohnsonAlgo()
    BellmanFord()

test()
