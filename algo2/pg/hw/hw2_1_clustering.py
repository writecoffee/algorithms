# -- Kruskal's Algorithm
# sort edges in increasing order
# [rename edge 1,2,3,...m, so that c1 < c2 < c3 < ... < cm] 
# T = empty set
# for i = 1 to m
#     if T U {i} has no cycle
#         add i to T
#         return T

# -- Single-link Clustering Algorithm
# initially, each point in a separate cluster
# repeat until only k clusters:
#     let p, q = closest pair of separated points
#     (determines the current spacing)
#     merge the clusters containing p & q into a single cluster

import sys
import csv

k = 4
E = []
V = {}
leader = {}

def read_clustering(filename):
    global E, G, clusters
    tsv = csv.reader(open(filename), delimiter=' ')
    num_of_nodes = int(tsv.next()[0])
    clusters = num_of_nodes
    for t in tsv:
        u, v, cost = t[0], t[1], int(t[2])
        E.append((cost, [u, v]))
        if u not in V:
            V[u] = u
            leader[u] = [u]
        if v not in V:
            V[v] = v
            leader[v] = [v]
    E[:] = sorted(E, key=lambda t: t[0])


def clustering():
    global clusters, k, ci, spacing

    # O(m): for cluster check O(1) per iteration
    # O(n log n): for leader pointer updates
    for cost, pair in E:
        if clusters == k:
            break
        u, v = pair[0], pair[1]
        if V[u] != V[v]:
            if len(leader[V[u]]) > len(leader[V[v]]):
                leader[V[u]] += leader[V[v]]
                ori_leader = V[v]
                new_leader = V[u]
                for i in leader[V[v]]:
                    V[i] = new_leader
                del leader[ori_leader]
            elif len(leader[V[u]]) <= len(leader[V[v]]):
                leader[V[v]] += leader[V[u]]
                ori_leader = V[u]
                new_leader = V[v]
                for i in leader[V[u]]:
                    V[i] = new_leader
                del leader[ori_leader]
            clusters -= 1
        else: continue

    # O(m): get minimum inter-cluster distance
    spacing = sys.maxint
    for cost, pair in E:
        u, v = pair[0], pair[1]
        if V[u] != V[v] and cost < spacing:
            spacing = cost
    return spacing

read_clustering("clustering1.txt")
clustering()
print spacing
