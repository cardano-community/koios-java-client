package rest.koios.client.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TupleTest {

    @Test
    void holdsBothValuesTest() {
        Tuple<String, Integer> tuple = new Tuple<>("policy", 42);
        assertEquals("policy", tuple._1);
        assertEquals(42, tuple._2);
    }

    @Test
    void acceptsNullsTest() {
        Tuple<String, String> tuple = new Tuple<>(null, null);
        assertNull(tuple._1);
        assertNull(tuple._2);
    }

    @Test
    void supportsMixedTypesTest() {
        Tuple<byte[], Boolean> tuple = new Tuple<>(new byte[]{1, 2}, true);
        assertArrayEquals(new byte[]{1, 2}, tuple._1);
        assertTrue(tuple._2);
    }
}
