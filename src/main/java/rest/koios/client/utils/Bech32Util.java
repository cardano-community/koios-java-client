package rest.koios.client.utils;

import org.bouncycastle.util.Arrays;

/**
 * Bech32 Utility Class
 */
public class Bech32Util {

    private Bech32Util() {
        throw new IllegalStateException("Utility Class");
    }

    private static final int TOTAL_MAX_LENGTH = 108; //103 = mainnet length of a delegation address, 108 = testnet length
    private static final int CHECK_SUM_SIZE = 6;
    private static final int HRP_MIN_LENGTH = 1;
    private static final int HRP_MAX_LENGTH = 83;
    private static final int HRP_MIN_VALUE = 33;
    private static final int HRP_MAX_VALUE = 126;
    private static final char SEPARATOR = '1';
    private static final String B_32_CHARS = "qpzry9x8gf2tvdw0s3jn54khce6mua7l";

    /**
     * isValid
     * Check whether bech32 Encoded String is Valid
     *
     * @param bech32EncodedString bech32 encoded string to check
     * @return true whether bech32 Encoded String is valid, false otherwise
     */
    public static boolean isValid(String bech32EncodedString) {
        if (!hasValidChars(bech32EncodedString)) {
            return false;
        }
        Tuple<String, byte[]> data = bech32Decode(bech32EncodedString);
        if (data._2.length < CHECK_SUM_SIZE) {
            return false;
        }

        return verifyChecksum(data._1, data._2);
    }

    /**
     * hasValidChars
     * Check whether bech32 Encoded String contains valid Chars
     *
     * @param bech32EncodedString bech32 encoded string to check
     * @return true whether bech32 Encoded String contains valid Chars, false otherwise
     */
    public static boolean hasValidChars(String bech32EncodedString) {
        if ((bech32EncodedString == null || bech32EncodedString.isEmpty()) || bech32EncodedString.length() > TOTAL_MAX_LENGTH) {
            return false;
        }

        // Reject mixed upper and lower characters.
        if (!bech32EncodedString.toLowerCase().equals(bech32EncodedString) && !bech32EncodedString.toUpperCase().equals(bech32EncodedString)) {
            return false;
        }

        // Check if it has a separator
        int sepIndex = bech32EncodedString.lastIndexOf(SEPARATOR);
        if (sepIndex == -1) {
            return false;
        }

        // Validate human readable part
        String hrp = bech32EncodedString.substring(0, sepIndex);
        if (!isValidHrp(hrp)) {
            return false;
        }

        // Validate data part
        String data = bech32EncodedString.substring(sepIndex + 1);
        return data.length() >= CHECK_SUM_SIZE && data.chars().noneMatch(x -> B_32_CHARS.indexOf(x) == -1);
    }

    private static boolean isValidHrp(String hrp) {
        return hrp != null &&
                hrp.trim().length() > 0 &&
                hrp.length() >= HRP_MIN_LENGTH &&
                hrp.length() < HRP_MAX_LENGTH &&
                hrp.chars().allMatch(character -> character >= HRP_MIN_VALUE && character <= HRP_MAX_VALUE);
    }

    private static int polymod(final byte[] values) {
        int c = 1;
        for (byte v_i : values) {
            int c0 = (c >>> 25) & 0xff;
            c = ((c & 0x1ffffff) << 5) ^ (v_i & 0xff);
            if ((c0 & 1) != 0) c ^= 0x3b6a57b2;
            if ((c0 & 2) != 0) c ^= 0x26508e6d;
            if ((c0 & 4) != 0) c ^= 0x1ea119fa;
            if ((c0 & 8) != 0) c ^= 0x3d4233dd;
            if ((c0 & 16) != 0) c ^= 0x2a1462b3;
        }
        return c;
    }

    private static byte[] expandHrp(String hrp) {
        byte[] result = new byte[(2 * hrp.length()) + 1];
        for (int i = 0; i < hrp.length(); i++) {
            result[i] = (byte) (( hrp.charAt(i)) >> 5);
            result[i + hrp.length() + 1] = (byte) (( hrp.charAt(i)) & 0b0001_1111 /*=31*/);
        }
        return result;
    }

    private static boolean verifyChecksum(String hrp, byte[] data) {
        byte[] temp = Arrays.concatenate(expandHrp(hrp), data);
        return polymod(temp) == 1;
    }

    private static Tuple<String, byte[]> bech32Decode(String bech32EncodedString) {

        bech32EncodedString = bech32EncodedString.toLowerCase();

        int separatorIndex = bech32EncodedString.lastIndexOf(SEPARATOR);
        String hrp = bech32EncodedString.substring(0, separatorIndex);
        String data = bech32EncodedString.substring(separatorIndex + 1);

        byte[] b32Arr = new byte[data.length()];
        for (int i = 0; i < data.length(); i++) {
            b32Arr[i] = (byte) B_32_CHARS.indexOf(data.charAt(i));
        }

        return new Tuple<>(hrp, b32Arr);
    }
}
