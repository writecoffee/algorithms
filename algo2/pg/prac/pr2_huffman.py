
class HuffNode:
    name = None
    freq = None
    lChild = None
    rChild = None
    def __init__(self, name, freq):
        self.name = name
        self.freq = freq

def huffmanCoding(p, q):
    if len(p) == 0 and len(q) == 0:
        return None
    if len(p) == 1 and len(q) == 0:
        return p.pop(0)
    l, r = None, None
    while not (len(p) == 0 and len(q) == 1):
        # (1) edge case when all elements are popped out because of (3)
        if len(p) == 0:
            l, r = q.pop(0), q.pop(0)
        # (2) the first iteration
        elif len(q) == 0:
            l, r = p.pop(0), p.pop(0)
        # (3) 2 smallest nodes in p are both smaller than q[0]
        elif p[0].freq < q[0].freq and len(p) > 1 and p[1].freq < q[0].freq:
            l, r = p.pop(0), p.pop(0)
        # (4) 2 smallest nodes in q are both smaller than p[0]
        elif p[0].freq > q[0].freq and len(q) > 1 and p[0].freq > q[1].freq:
            l, r = q.pop(0), q.pop(0)
        else:
            l, r = p.pop(0), q.pop(0)
        internalNode = HuffNode(l.name + r.name, l.freq + r.freq)
        internalNode.lChild = l
        internalNode.rChild = r
        # due to the claim that all resultant meta-nodes' freq will be no less than
        # any elements in q
        q.append(internalNode)
        print \
           'internal node %s' % ((internalNode.name, internalNode.freq), ),\
           'left %s' % ((l.name, l.freq), ),\
           'right %s' % ((r.name, r.freq), )
    return q.pop(0)

t = 0
def traverse(root, depth):
    global t
    if root.lChild is None and root.rChild is None:
        t += depth * root.freq
        return
    if root.lChild:
        traverse(root.lChild, depth + 1)
    if root.rChild:
        traverse(root.rChild, depth + 1)


def read(fileName):
    with open(fileName, "r") as f:
        lines = f.readlines()
        array = list(line.split(' ', 1) for line in lines[1:])
        return array, int(lines[0])

def test(fileName="huffman_nodes.txt"):
    nlist, nodeCount = read(fileName)
    nodes = map(lambda l: HuffNode(l[0], int(l[1])), nlist)
    nodes[:] = sorted(nodes, key=lambda node: node.freq)
    root = huffmanCoding(nodes, [])
    traverse(root, 0)
    print t

test()
