package live.mukeshtechlab.generics.generic;


public class PairImp <K, V> implements Pair<K, V>{
    private K key;
    private V value;

//    public PairImp(K key, V value){
//        this.key = key;
//        this.value = value;
//    }

    @Override
    public void setKeyValue(K key, V value){
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey(){
        return key;
    }

    @Override
    public V getValue(){
        return value;
    }
}
