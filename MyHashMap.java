/**
   Design a HashMap without using any built-in hash table libraries.
   Implement the MyHashMap class:
   MyHashMap() initializes the object with an empty map.
   void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
   int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
   void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.

   Constraints:

    0 <= key, value <= 106
    At most 104 calls will be made to put, get, and remove.
 */

import java.util.LinkedList;

class MyHashMap{
    private LinkedList<Node>[] buckets;
    private int bucketSize = 1000;


    public MyHashMap() {
        buckets = new LinkedList[bucketSize];
        for(int i=0;i<bucketSize;i++){
            buckets[i] = new LinkedList<>();
        }
    }
    
    class Node{
        private int key;
        private int value;
        
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    public void put(int key, int value) {
        int index = key % bucketSize;
        LinkedList<Node> bucket = buckets[index];
        
        for(Node node: bucket){
            if(node.key == key){
                node.value = value;
                return;
            }
        }
        
        bucket.add(new Node(key,value));
    }
    
    public int get(int key) {
        int index = key % bucketSize;
        LinkedList<Node> bucket = buckets[index];
        
        for(Node node: bucket){
            if(node.key == key){
                return node.value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = key % bucketSize;
        LinkedList<Node> bucket = buckets[index];
        
        for(Node node : bucket){
            if(node.key == key){
                bucket.remove(node);
                break;
            }
        }
    }
}
