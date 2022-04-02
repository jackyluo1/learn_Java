class UnionFind {
    private int[] parents;

    public UnionFind(int size) {
        this.parents = new int[size];
        for (int i = 0; i < size; i++)
            parents[i] = i;
    }

    public int find(int n) {
        int p = this.parents[n];
        if (p == n)
            return this.parents[n];
        this.parents[n] = find(p);
        return this.parents[n];
    }

    public boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        parents[p1] = p2;
        return p1 == p2;
    }

    public boolean isBipartite(int[][] graph) {
        UnionFind uf = new UnionFind(graph.length);
        // check now
        for (int u = 0; u < graph.length; u++) {
            int firstNeighborOfU = graph[u].length == 0 ? -1 : graph[u][0];// Ensure to handle empty edge/v
            for (int v : graph[u]) {
                if (uf.find(u) == uf.find(v))
                    return false;// If we ever find U and any of its neighbors in same set return false.
                uf.union(firstNeighborOfU, v);// For U->V. Assuming U is in one Set, All neighbors of U should be in
                                              // other Set. So try unifying all neghbors of U in other set
            }
        }
        return true;
    }

}
