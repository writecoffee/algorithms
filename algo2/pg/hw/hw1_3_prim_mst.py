# initialize X={s}
# T=EMPTY
# while X != V:
#    let e = (u, v) be the cheapest edge of G with u in X, v not in X
#    add e to T, add v to X
# 
#    when v added to X:
#        for each edge (v, w) in E:
#            if w is in V - X
#                delete w from heap
#                re-compute key[w] := min{key[w], Cvw}
#                re-insert w into heap

import heapq
import csv
import unittest

X = []
V_X = {}
num_of_nodes = 0
num_of_edges = 0
G = {}
sum_cost = 0
frontier = []

def compute_MST():
    global X, sum_cost
    while V_X:
        cost, v = heapq.heappop(frontier)
        # filtering out out-of-date frontier vertex which has already been included into X
        if v in X:
            continue
        # sum up the cost for MST
        sum_cost += cost
        # add v to X
        X.append(v)
        # remove v from V-X
        del V_X[v]
        for neighbor in G[v]:
            # w is in V-X, update the frontier by just adding it to the heap
            if neighbor not in X:
                heapq.heappush(frontier, (G[v][neighbor], neighbor))
    assert len(X) == int(num_of_nodes)
    return sum_cost
        
def heap_init():
    global X
    start, s_edges = G.iteritems().next()
    # add s to X
    X.append(start)
    # build current heap
    for neighbor in G[start]:
        heapq.heappush(frontier, (s_edges[neighbor], neighbor))
    # remove s from V_X
    del V_X[start]
    

def read_schedule(filename):
    global V_X, num_of_nodes, num_of_edges
    tsv = csv.reader(open(filename), delimiter=' ')
    # jobs counts
    num_of_nodes, num_of_edges = tsv.next()
    # build heap
    for t in tsv:
        u, v, cost = t[0], t[1], int(t[2])
        if u not in V_X:
            V_X[u] = True
        if v not in V_X:
            V_X[v] = True
        if u not in G:
            G[u] = {}
        if v not in G:
            G[v] = {}
        G[u][v] = cost
        G[v][u] = cost

def test():
    read_schedule("edges.txt")

test()
heap_init()
print compute_MST()
