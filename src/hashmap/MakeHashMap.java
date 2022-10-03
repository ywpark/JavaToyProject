package hashmap;

import java.util.List;
import java.util.ArrayList;

class Node {

    private String key;
    private Object value;

    public Node(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getValue() {
        return this.value;
    }
    public boolean equalsByMapKey(String mapKey) {
        if(mapKey == null)
            return false;
        return this.key.equals(mapKey);
    }
}

/**
 * HashMap 을 만들어보자
 */
public class MakeHashMap {

    /**
     * values 저장하는 기본 Array Size
     */
    private final int INIT_VALUES_SIZE = 10;

    /**
     * Values
     */
    private Object[] buckets;

    public MakeHashMap() {
        buckets = new Object[INIT_VALUES_SIZE];
    }

    /**
     * Create Hash value
     * @param key Map Key
     * @return Hash value
     */
    private int getHash(String key) {
        int hash = 0;
        for(int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            hash += ch;
        }
        return hash;
    }

    private int getHashIndex(int hash) {
        return hash%INIT_VALUES_SIZE;
    }

    public void put(String key, Object value) {

        vaildParameter(key, value);

        int h = getHash(key);
        int idx = getHashIndex(h);

        if(buckets[idx] == null){

            List<Node> nodes = new ArrayList<>();
            Node newNode = new Node(key, value);
            nodes.add(newNode);

            buckets[idx] = nodes;
            return;
        }

        List<Node> nodes = (List<Node>) buckets[idx];
        Node newNode = new Node(key, value);
        nodes.add(newNode);
    }

    private void vaildParameter(String key, Object value) {
        if(key == null)
            throw new IllegalArgumentException("key is Null");

        if(value == null)
            throw new NullPointerException("values is Null");
    }

    public Object get(String key) {

        int h = getHash(key);
        int idx = getHashIndex(h);

        if(contain(key)) {
            List<Node> nodes = (List<Node>)buckets[idx];
            for(int i = 0; i  < nodes.size(); i++) {
                Node node = nodes.get(i);
                if(node.equalsByMapKey(key)) {
                    return node.getValue();
                }
            }
        }
        return null;
    }

    public boolean contain(String key) {

        boolean result = false;
        int h = getHash(key);
        int idx = getHashIndex(h);

        List<Node> nodes = (List<Node>)buckets[idx];
        if(nodes == null)
            return false;

        for(int i = 0; i  < nodes.size(); i++) {
            Node node = nodes.get(i);
            if(node.equalsByMapKey(key)) {
                result = true;
                break;
            }
        }

        return result;
    }

}
