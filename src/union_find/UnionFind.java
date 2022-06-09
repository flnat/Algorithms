package union_find;

public abstract class UnionFind implements IUnionFind {
    protected int[] id;
    protected int count;

    public UnionFind(int n) {
        count = n;
        id = new int[count];

        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    @Override
    public int count() {
        return count;
    }

}
