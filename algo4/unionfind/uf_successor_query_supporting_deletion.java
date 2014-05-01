public class uf_successor_query_supporting_deletion {
    private int[] leaders;
    private int[] nexts;
    private int[] sizes;
    private boolean[] deleted;
    private int n;

    public void init(int _n) {
        n = _n;
        leaders = new int[_n];
        nexts = new int[_n];
        deleted = new boolean[_n];
        sizes = new int[_n];

        for (int i = 0; i < n; ++i) {
            leaders[i] = nexts[i] = i;
            sizes[i] = 1;
        }
    }

    public void removeNum(int x) {
        deleted[x] = true;

        if (x - 1 >= 0 && deleted[x - 1]) {
            fuseGroups(x - 1, x);
        }

        if (x + 1 < n && deleted[x + 1]) {
            fuseGroups(x, x + 1);
        }
    }

    public int query(int x) {
        if (!deleted[x]) {
            return x;
        }

        int result = nexts[getLeader(x)] + 1;
        return result < n ? result : -1;
    }

    /**
     * We need to keep probing the valid leader till "leaders[x] == x" because
     * ONLY valid leaders could be mapped to up-to-date successor.
     * 
     * Note that we will only update one group's leader in every "fuse" action!
     */
    private int getLeader(int x) {
        if (leaders[x] == x) {
            return x;
        } else {
            return getLeader(leaders[x]);
        }
    }

    /**
     * We always fuse the smaller group into the larger group. That ensures we
     * will get O(log n) time complexity in searching for the up-to-date leader.
     * 
     */
    private void fuseGroups(int l, int r) {
        int ll = getLeader(l), rl = getLeader(r);

        if (ll == rl) {
            return;
        }

        if (sizes[ll] > sizes[rl]) {
            leaders[rl] = ll;
            nexts[ll] = Math.max(nexts[ll], nexts[rl]);
            sizes[ll] += sizes[rl];
        } else {
            leaders[ll] = rl;
            nexts[rl] = Math.max(nexts[ll], nexts[rl]);
            sizes[rl] += sizes[ll];
        }
    }
}
