package union_find;

public interface IUnionFind {
    public void union(int p, int q);

    public int find(int p);

    public int count();

    default public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}
