class LRUCache {
    private class Node{
        int key;
        int value;
        Node next;
        Node prev;
        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }

    private Node head;
    private Node tail;
    Map<Integer,Node> cache; //we are keeping key and whole node in map
    int capacity;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        cache=new HashMap<>();
        this.head=new Node(-1,-1);
        this.tail=new Node(-1,-1);
        head.next=tail; //connecting the dummy head and dummy tail
        tail.prev=head; //connecting the dummy head and dummy tail
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if(node==null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        if(node==null){
            Node newNode = new Node(key,value);
            cache.put(key,newNode);
            addNode(newNode);//adding the node at head
            if(cache.size()>capacity){
                Node lru = tail.prev;
                removeNode(lru); //remove from DLL
                cache.remove(lru.key); //remove from hashmap
            }
        }
        else{
    node.value = value; //changing the value from previous value to new given value of that key
            cache.put(key,node);
            moveToHead(node);
        }
    }
    public void removeNode(Node node){
        Node previous = node.prev;
        Node nxt = node.next;
        previous.next = nxt;
        nxt.prev = previous;
    }
    public void addNode(Node node){
        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        head.next = node;
    }
    public void moveToHead(Node node){
        removeNode(node);
        addNode(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */