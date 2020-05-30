public class HashBuck<K, V> {

    private static class Node<K,V> {
        private K key;
        private V value;
        private Node<K,V> next;
        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
    public Node<K,V>[] array;
    public int usedSize;
    public HashBuck() {
        this.array = (Node<K,V>[])new Node[10];
    }
    public void put(K key, V val) {
        int tmp = key.hashCode();
        int index = tmp % array.length;

        Node<K,V> cur = this.array[index];
        while (cur != null) {
            if (cur.key.equals(key)) {
                cur.value = val;
                return;
            }
            cur = cur.next;
        }
        Node<K,V> node = new Node<>(key,val);
        node.next = array[index];
        array[index] = node;
        usedSize++;
        if (loadFactor() > 0.75) {
            resize();
        }

    }
    public void resize() {
        Node<K,V>[] newArray = (Node<K, V>[]) new Node[array.length * 2];

        for (Node<K,V> value : array) {
            Node<K,V> cur = value;
            while (cur != null) {
                int tmp = cur.key.hashCode();
                int index = tmp % newArray.length;
                Node<K,V> curNext = cur.next;
                cur.next = newArray[index];
                newArray[index] = cur;
                cur = curNext;
            }
        }

        this.array = newArray;

    }
    public double loadFactor() {
        return this.usedSize * 1.0 / array.length;
    }
    public V get(K key) {
        int tmp = key.hashCode();
        int index = tmp % array.length;
        Node<K,V> cur = array[index];
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }

}
