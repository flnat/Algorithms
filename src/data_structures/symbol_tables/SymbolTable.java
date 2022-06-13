package data_structures.symbol_tables;

interface SymbolTable<Key extends Comparable<Key>, Value> {

    public void put(Key key, Value val);

    public Value get(Key key);

    public void delete(Key key);

    public void deleteMin();

    default public boolean contains(Key key) {
        return get(key) != null;
    }

    public int size();

    public Iterable<Key> keys();

    default public boolean isEmpty() {
        return size() == 0;
    }

    public Key min();

    public Key floor();

    public Key select();

    public int rank();

}
