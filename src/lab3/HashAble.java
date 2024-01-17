package lab3;
public abstract class HashAble<K,V> {
    public abstract Integer getHashForValue(V value, int module);
    public abstract Integer getHashForKey(K key, int module);
    public abstract V defaultValue();
    public abstract K defaultKey();
    public HashAble(){

    }
}
