
import copy
import sys
import heapq

GReverse = {0: {}}
GPrime = {0: {}}
edges = None
nodes_cnt = None
edges_cnt = None
shortest = []

def Dijkstra(s):
    global shortest
    finished = {}
    heap = [(0, s)]
    dist_so_far = {s: 0}
    while dist_so_far:
        cost, u = heapq.heappop(heap)
        if u in finished or (u in dist_so_far and dist_so_far[u] < cost):
            continue
        del dist_so_far[u]
        finished[u] = cost
        if u not in GPrime:
            continue
        for v in filter(lambda v: v not in finished, GPrime[u]):
            if v not in dist_so_far or finished[u] + GPrime[u][v] < dist_so_far[v]:
                dist_so_far[v] = finished[u] + GPrime[u][v]
                heapq.heappush(heap, (dist_so_far[v], v))
    return finished

def checkNegativeLoop(A):
    global nodes_cnt
    for i in xrange(nodes_cnt + 1):
        if A[1][i] != A[0][i]:
            print i, A[0][i], A[1][i]

def reWeighting(GPrime, A):
    global nodes_cnt
    for u in filter(lambda k: k != 0, GPrime.keys()):
        for v in GPrime[u]:
            GPrime[u][v] = GPrime[u][v] + A[0][u] - A[0][v]

def computeShortestPath(A):
    global shortest, nodes_cnt
    for v in filter(lambda v: v != 0, set(GPrime.keys() + GReverse.keys())):
        result = Dijkstra(v)
        for t, cost in result.iteritems():
            shortest.append(cost - A[0][v] + A[0][t])

def BellmanFord(s=0):
    global GReverse, GPrime, nodes_cnt, edges_cnt, shortest
    A = [[0,] * (nodes_cnt + 1) for _ in xrange(2)]
    for i in xrange(1, nodes_cnt + 1):
        A[s][i] = sys.maxint
    for i in xrange(1, nodes_cnt + 1):
        A[0][:] = A[1][:]
        for v in set(GPrime.keys() + GReverse.keys()):
            A[1][v] = min([A[0][v], min([A[0][w] + GReverse[v][w] for w in GReverse[v]])])
    # diff
    checkNegativeLoop(A)
    return A

def JohnsonAlgo():
    A = BellmanFord()
    # recompute the edge cost
    reWeighting(GPrime, A)
    # get the shortest path for each Dijkatra
    computeShortestPath(A)

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

test()
print min(shortest)
