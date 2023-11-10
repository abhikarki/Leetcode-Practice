class LRUCache {

    // Node for the Double Linked List.
    class Node{
        int val;
        int key;
        Node prev = null;
        Node next = null;

        // For initializing head and tail node.
        public Node(){
            this.key = 0;
            this.val = 0;
        }
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    // HashMap with the values pointing to a node in a double linked list
    HashMap <Integer, Node> map;
    Node head = null;
    Node tail = null;
    int capacity = 0;

    public LRUCache(int capacity) {
        // Initialize the data structure i.e. HashMap with a double 
        // linked list.
        map = new HashMap<Integer, Node>();
        this.capacity = capacity;
        // Creating nodes for head and tails for easier add and delete
        // operations.
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            // Move the node to the head of the list.
            delete(map.get(key));
            add(map.get(key));
            // return the value.
            return map.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            // Add a new Node to the list and the key to the hashmap.
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            add(newNode);    
        }
        else{
            // If the key is already present, update the value and
            // add the node to the front of the linked list.
            map.get(key).val = value;
            delete(map.get(key));
            add(map.get(key));
        }  
            // If the size of the HashMap > capacity, remove the Least
            // Recently Used key i.e. the end node of the linked list. 
        if(map.size()>capacity){
            map.remove(tail.prev.key);
            delete(tail.prev);
        }           
    }

    // Delete a node.
    public void delete(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Add a node to the front of the list.
    public void add(Node node){
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


