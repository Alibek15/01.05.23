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
        // Check if a linked list exists at the computed index
        if(Objects.isNull(elem)){
            elem= new HashNode<>(key, value);
        }
        else{
            HashNode<K,V> current = elem;
            while(Objects.nonNull(current.next)){
                if(current.key.equals(key)){
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            if(current.key.equals(key)){
                current.value = value;
            }
            else{
                current.next = new HashNode<>(key, value);
            }
        }

    }
    public V get(K key){


        HashNode<K,V> current = chainArray[hash(key)];
        while(Objects.nonNull(current)){
            if(current.key.equals(key)){
                return current.value;
            }
            current = current.next;
        }

        return current.value;
    }
    public V remove(K key){


        HashNode<K,V> current = chainArray[hash(key)];
        HashNode<K,V> previous = null;
        while(Objects.nonNull(current)){
            if(current.key.equals(key)){
                if(previous.equals( null)){
                    chainArray[hash(key)] = current.next;
                }
                else{
                    previous.next = current.next;
                }
                size--;

            }
            previous = current;
            current = current.next;
        }
        return current.value;
    }
    public boolean contains(V value){
        int index =0;
       while(index<M) {
           HashNode<K, V> current = chainArray[index];
           while (Objects.nonNull(current)){
               if(current.value.equals(value)){
                   return true;
               }
               current = current.next;
           }
       }
       return false;
    }
    public K getKey(V value){
        int index =0;
        while(index<M) {
            HashNode<K, V> current = chainArray[index];
            while (Objects.nonNull(current)){
                if(current.value.equals(value)){
                    return (K)current;
                }
                current = current.next;
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
