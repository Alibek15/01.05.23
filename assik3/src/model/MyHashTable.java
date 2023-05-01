package model;

import java.util.Arrays;
import java.util.Objects;

public class MyHashTable<K,V> {
    private class HashNode<K,V>{
        private K key;
        private V value;
        private HashNode<K,V> next;

        public HashNode(K key, V value){
            this.key=key;
            this.value=value;
        }
        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }
    private HashNode<K,V>[] chainArray;
    private int M=11;
    private int size;
    public MyHashTable(){
        chainArray = new HashNode[M];
    }
    public MyHashTable(int M){
        this.M=M;
        chainArray = new HashNode[M];
    }
    private int hash(K key){
        return Math.abs(key.hashCode()) % M;
    }
    public void put(K key, V value){
        size+=1;
         var elem = chainArray[hash(key)];
        
        if(Objects.isNull(elem)){
            elem= new HashNode<>(key, value);
        }
        else{
            HashNode<K,V> val = elem;
            while(Objects.nonNull(val.next)){
                if(val.key.equals(key)){
                    val.value = value;
                    return;
                }
                val = val.next;
            }
            if(val.key.equals(key)){
                val.value = value;
            }
            else{
                val.next = new HashNode<>(key, value);
            }
        }

    }
    public V get(K key){


        HashNode<K,V> val = chainArray[hash(key)];
        while(Objects.nonNull(val)){
            if(val.key.equals(key)){
                return val.value;
            }
            val = val.next;
        }

        return val.value;
    }
    public V remove(K key){


        HashNode<K,V> val = chainArray[hash(key)];
        HashNode<K,V> previous = null;
        while(Objects.nonNull(val)){
            if(val.key.equals(key)){
                if(previous.equals( null)){
                    chainArray[hash(key)] = val.next;
                }
                else{
                    previous.next = val.next;
                }
                size--;

            }
            previous = val;
            val = val.next;
        }
        return val.value;
    }
    public boolean contains(V value){
        int index =0;
       while(index<M) {
           HashNode<K, V> val = chainArray[index];
           while (Objects.nonNull(val)){
               if(val.value.equals(value)){
                   return true;
               }
               val = val.next;
           }
       }
       return false;
    }
    public K getKey(V value){
        int index =0;
        while(index<M) {
            HashNode<K, V> val = chainArray[index];
            while (Objects.nonNull(val)){
                if(val.value.equals(value)){
                    return (K)val;
                }
                val = val.next;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "MyHashTable{" +
                "chainArray=" + Arrays.toString(chainArray) +
                ", M=" + M +
                ", size=" + size +
                '}';
    }
}
