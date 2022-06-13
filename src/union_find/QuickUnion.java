package union_find;

public class QuickUnion extends UnionFind {

    public QuickUnion(int n) {
        super(n);
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot){
            return;
        }

        id[pRoot] = qRoot;
        count--;
        
    }

    @Override
    public int find(int p) {
        while(p != id[p]){
            p = id[p];
        }
        return p;
    }
    
}
