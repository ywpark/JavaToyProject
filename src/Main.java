import hashmap.MakeHashMap;

public class Main {
    public static void main(String[] args) {

        MakeHashMap mhm = new MakeHashMap();

        mhm.put("a", 1);
        mhm.put("b", 2);
        mhm.put("c", 3);
        mhm.put("ab", 4);
        mhm.put("ac", 5);
        mhm.put("ba", 99);

        System.out.println("key ab = " + mhm.get("ab"));
        System.out.println("key ba = " + mhm.get("ba"));
    }
}