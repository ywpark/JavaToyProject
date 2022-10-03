import hashmap.MakeHashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MakeHashMapTest {

    @Test
    @DisplayName("PUT & GET 테스트")
    void PutAndGetTest() {

        MakeHashMap mhm =  new MakeHashMap();
        mhm.put("a", "abc");
        mhm.put("b", 123);

        assertEquals("abc", mhm.get("a").toString());
        assertEquals(123, (int)mhm.get("b"));
        assertEquals(null, mhm.get("c"));

        assertThrows(NullPointerException.class, () -> {
            mhm.put("d", null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            mhm.put(null, "abc");
        });
    }

    @Test
    @DisplayName("Contain 테스트")
    void containTest() {

        MakeHashMap mhm =  new MakeHashMap();
        mhm.put("a", "abc");
        mhm.put("b", 123);

        assertEquals(true, mhm.contain("a"));
        assertEquals(false,mhm.contain("c"));
    }
}