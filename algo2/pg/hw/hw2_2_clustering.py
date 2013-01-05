class Vertex:
    bits = None
    checksum = None
    leader = None
    chkmin = None
    chkmax = None
    # initializer
    def __init__(self, bits, leader, spacing):
        self.bits = bits
        self.checksum = reduce(lambda x, y: x + y, bits)
        self.chkmin = self.checksum - spacing
        self.chkmax = self.checksum + spacing
        self.leader = leader
    # update leader pointer 
    def updateLeader(self, newLeader):
        self.leader = newLeader
    # return hamming distance
    def calcHammingDist(self, otherVertex):
        return sum(1 if bit1 != bit2 else 0 for bit1, bit2 in zip(self.bits, otherVertex.bits))
    # return boolean for judging necessity of calculating hamming dist
    def isApplicable(self, otherVertex):
        return self.chkmin < otherVertex.checksum < self.chkmax

class UnionFind:
    vertices = None
    clustersCnt = None
    clustersSize = None
    # initializer, assuming all input vertices have unique cluster(leader) int number
    def __init__(self, vertices):
        self.vertices = vertices
        self.clustersCnt = len(vertices)
        self.clustersSize = {}
    # union and merge, update smaller one first
    def union(self, u, v):
        leader1 = u.leader
        leader2 = v.leader
        if leader1 != leader2:
            if leader1 not in self.clustersSize:
                self.clustersSize[leader1] = 1
            if leader2 not in self.clustersSize:
                self.clustersSize[leader2] = 1
            self.clustersCnt -= 1
            # update smaller cluster first
            if self.clustersSize[leader1] > self.clustersSize[leader2]:
                map(lambda v: v.updateLeader(leader1), filter(lambda v: v.leader == leader2, self.vertices))
            elif self.clustersSize[leader1] <= self.clustersSize[leader2]: 
                map(lambda v: v.updateLeader(leader1), filter(lambda v: v.leader == leader2, self.vertices))

def read(fileName):
    with open(fileName, "r") as f:
        lines = f.readlines()
        array = list(map(int, filter((lambda c: c != '\n'), line.split(' '))) for line in lines[1:])
        return array, int(lines[0].split(' ')[0]), int(lines[0].split(' ')[1])

def test(spacing=3, fileName="clustering2.txt"):
    bitsList, vertexCount, bitLength = read("clustering2.txt")
    vertices = []
    for i in range(vertexCount):
        vertices.append(Vertex(bitsList[i], i, spacing))
    unionFind = UnionFind(vertices)
    # O(301 * n) for distance calculation
    for i in range(vertexCount):
        u = vertices[i]
        for j in range(i + 1, vertexCount):
            v = vertices[j]
            if u.leader == v.leader:
                continue
            # C(24, 0) + C(24, 1) + C(24, 2) = 301 times for calculating 
            if u.isApplicable(v):
                distance = u.calcHammingDist(v)
                # O(n log n) for update leader pointers totally
                if distance < spacing:
                    unionFind.union(u, v)
    return unionFind.clustersCnt

print test()
