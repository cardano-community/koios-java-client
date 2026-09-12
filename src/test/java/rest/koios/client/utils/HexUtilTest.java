package rest.koios.client.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HexUtilTest {

    private static final String TX_HASH =
            "4123d70f66414cc921f6ffc29a899aafc7137a99a0fd453d6b200863ef5702d6";

    @Test
    void encodeDecodeRoundTripsTest() {
        byte[] bytes = HexUtil.decodeHexString(TX_HASH);
        assertEquals(32, bytes.length);
        assertEquals(TX_HASH, HexUtil.encodeHexString(bytes));
    }

    @Test
    void encodeWithPrefixTest() {
        byte[] bytes = {(byte) 0xde, (byte) 0xad, (byte) 0xbe, (byte) 0xef};
        assertEquals("deadbeef", HexUtil.encodeHexString(bytes));
        assertEquals("deadbeef", HexUtil.encodeHexString(bytes, false));
        assertEquals("0xdeadbeef", HexUtil.encodeHexString(bytes, true));
    }

    @Test
    void decodeAcceptsPrefixTest() {
        assertArrayEquals(HexUtil.decodeHexString("deadbeef"),
                HexUtil.decodeHexString("0xdeadbeef"));
    }

    @Test
    void encodeNullReturnsNullTest() {
        assertNull(HexUtil.encodeHexString(null));
        assertNull(HexUtil.encodeHexString(null, true));
    }

    @Test
    void encodeEmptyArrayTest() {
        assertEquals("", HexUtil.encodeHexString(new byte[0]));
        assertEquals("0x", HexUtil.encodeHexString(new byte[0], true));
    }

    @Test
    void decodeRejectsOddLengthTest() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> HexUtil.decodeHexString("abc"));
        assertTrue(e.getMessage().contains("Invalid hexadecimal String"), e.getMessage());
    }

    @Test
    void decodeRejectsNullTest() {
        assertThrows(IllegalArgumentException.class, () -> HexUtil.decodeHexString(null));
    }

    @Test
    void decodeRejectsNonHexCharacterTest() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> HexUtil.decodeHexString("zz"));
        assertTrue(e.getMessage().contains("Invalid Hexadecimal Character"), e.getMessage());
    }

    @Test
    void byteToHexCoversSignedRangeTest() {
        assertEquals("00", HexUtil.byteToHex((byte) 0));
        assertEquals("0f", HexUtil.byteToHex((byte) 15));
        assertEquals("7f", HexUtil.byteToHex(Byte.MAX_VALUE));
        // negative bytes must not sign-extend
        assertEquals("80", HexUtil.byteToHex(Byte.MIN_VALUE));
        assertEquals("ff", HexUtil.byteToHex((byte) -1));
    }

    @Test
    void hexToByteTest() {
        assertEquals((byte) 0, HexUtil.hexToByte("00"));
        assertEquals((byte) 255, HexUtil.hexToByte("ff"));
        assertEquals((byte) 255, HexUtil.hexToByte("FF"));
        assertEquals((byte) 171, HexUtil.hexToByte("ab"));
    }

    @Test
    void allByteValuesRoundTripTest() {
        byte[] all = new byte[256];
        for (int i = 0; i < 256; i++) {
            all[i] = (byte) i;
        }
        assertArrayEquals(all, HexUtil.decodeHexString(HexUtil.encodeHexString(all)));
    }
}
