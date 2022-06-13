package union_find;

public class WeightedQuickUnion extends UnionFind {

    private int[] size;

    public WeightedQuickUnion(int n) {
        super(n);
        size = new int[n];
        for (int i = 0; i < size.length; i++) {
            size[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);

        if (i == j) {
            return;
        }

        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else {
            id[j] = i;
            size[i] += size[j];
        }
        count--;

    }

    @Override
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }
}
