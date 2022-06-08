package data_structures.symbol_tables;

interface SymbolTable<Key extends Comparable<Key>, Value> {
    
    public void put(Key key, Value val);
    public Value get(Key key);
    public void delete(Key key);
    default public boolean contains(Key key){
        return get(key) != null;
    }
    public int size();
    public Iterable<Key> keys();
    default public boolean isEmpty(){
        return size() == 0;
    }


}
