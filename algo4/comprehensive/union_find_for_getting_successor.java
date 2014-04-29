public class union_find_for_getting_successor {
    class UnionFindSet {
        int[] id;
        int[] sz;
        int[] mc;

        UnionFindSet(int n) {
            id = new int[n];
            sz = new int[n];
            mc = new int[n];

            for (int i = 0; i < n; ++i) {
                id[i] = mc[i] = i;
                sz[i] = 1;
            }
        }

        int getLeader(int p) {
            if (id[p] == p) {
                return p;
            } else {
                return getLeader(id[p]);
            }
        }

        void unionComp(int p, int q) {
            int i = getLeader(p), j = getLeader(q);
            if (i == j) {
                return;
            }

            if (sz[i] < sz[j]) {
                id[i] = j;
                sz[j] += sz[i];
                sz[i] = sz[j];
                mc[j] = Math.max(mc[i], mc[j]);
            } else {
                id[j] = i;
                sz[j] += sz[i];
                sz[i] = sz[j];
                mc[i] = Math.max(mc[i], mc[j]);
            }
        }

        int getMaxInComp(int p) {
            return mc[getLeader(p)];
        }
    }

    class MySuccessor {
        private boolean[] deleted;
        private int n;
        private UnionFindSet uf;

        MySuccessor(int _n) {
            uf = new UnionFindSet(_n);
            deleted = new boolean[_n];
            n = _n;
        }

        void remove(int id) {
            deleted[id] = true;
            if (id - 1 >= 0 && deleted[id - 1]) {
                uf.unionComp(id - 1, id);
            }

            if (id + 1 < n && deleted[id + 1]) {
                uf.unionComp(id, id + 1);
            }
        }

        int query(int id) {
            if (!deleted[id]) {
                return id;
            }

            int mc = uf.getMaxInComp(id) + 1;
            return mc < n ? mc : -1;
        }
    }

    MySuccessor instance;

    public void init(int n) {
        instance = new MySuccessor(n);
    }

    public void removeNum(int x) {
        instance.remove(x);
    }

    public int query(int x) {
        return instance.query(x);
    }

    public static void main(String[] args) {
        union_find_for_getting_successor ins = new union_find_for_getting_successor();
        ins.init(6);
        ins.removeNum(1);
        ins.query(1);
//        ins.removeNum(3);
//        ins.removeNum(2);
//        ins.removeNum(2);
//        ins.query(3);
    }
}