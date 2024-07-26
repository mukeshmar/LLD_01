package live.mukeshtechlab.generics.generic;

public interface Pair <K, V>{
    public void setKeyValue(K key, V value);
    public K getKey();
    public V getValue();
}
