package lab3;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyHashMap <K,V> {
    private static class HashCell<K,V>{
        public V value;
        public K key;
        public void setCell(K _key,V _data){
            this.key = _key;
            this.value = _data;
        }
        public HashCell(){
        }
        @Override
        public boolean equals(Object other){
            if (other == this) {
                return true;
            }
            if (other == null || other.getClass() != this.getClass()) {
                return false;
            }
            HashCell<K,V> otherCell= (HashCell)other;
            return otherCell.key.equals(this.key)&&otherCell.value.equals(this.value);
        }
    }

    private int size=0;
    private int hashSize = 91;
    public int size(){
        return this.size;
    }
    public ArrayList<LinkedList<HashCell<K,V>>> data = new ArrayList<>();
    public MyHashMap(){
        this.hashSize=91;
        this.data = new ArrayList<LinkedList<HashCell<K, V>>>();
        for(int i=0;i<this.hashSize;i++) {
            data.add(new LinkedList<HashCell<K, V>>());
        }
    }

    public ArrayList<K> show_keys(){
        ArrayList<K> res= new ArrayList<K>();
        for(int i = 0; i<this.data.size(); i++){
            for (HashCell<K,V> cell : data.get(i)){
                res.add(cell.key);
            }
        }
        return res;
    }
    public ArrayList<V> showValues(){
        ArrayList<V> res= new ArrayList<V>();
        for(int i = 0; i<this.data.size(); i++){
            for (HashCell<K,V> cell : data.get(i)){
                res.add(cell.value);
            }
        }
        return res;
    }
    public void put(K key,V value){
        HashCell<K,V> newCell = new HashCell<>();
        newCell.setCell(key,value);
        int indexInArrayList = key.hashCode();
        for(int indexInLinkedList = 0; indexInLinkedList <this.data.get(indexInArrayList).size(); indexInLinkedList++){
            if(this.data.get(indexInArrayList).get(indexInLinkedList).key.equals(key)){
                this.data.get(indexInArrayList).set(indexInLinkedList,newCell);
                this.size++;
                return;
            }
        }
        this.data.get(indexInArrayList).add(newCell);
        this.size++;
        return;
    }
    public int remove (K keyForDelete){
        int indexInArrayList = keyForDelete.hashCode();
        for(int indexInLinkedList = 0; indexInLinkedList <this.data.get(indexInArrayList).size(); indexInLinkedList++){
            if(this.data.get(indexInArrayList).get(indexInLinkedList).key.equals(keyForDelete)){
                this.data.get(indexInArrayList).remove(indexInLinkedList);
                this.size--;
                return 0;
            }
        }
        return -1;
    }
    public boolean contains(K keyForFind){
        int indexInArrayList = keyForFind.hashCode();
        for(int indexInLinkedList = 0; indexInLinkedList <this.data.get(indexInArrayList).size(); indexInLinkedList++){
            if(this.data.get(indexInArrayList).get(indexInLinkedList).key.equals(keyForFind)){
                return true;
            }
        }
        return false;
    }
    public V get(K keyForExtract){
        int indexInArrayList = keyForExtract.hashCode();
        for(int indexInLinkedList = 0; indexInLinkedList <this.data.get(indexInArrayList).size(); indexInLinkedList++){
            if(this.data.get(indexInArrayList).get(indexInLinkedList).key.equals(keyForExtract)){
                return this.data.get(indexInArrayList).get(indexInLinkedList).value;
            }
        }
        return null;
    }

}
