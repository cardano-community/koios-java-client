package rest.koios.client.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Covers the accepting side of {@link Bech32Util}, which the existing tests do not reach -
 * they only assert that malformed input is rejected.
 */
class Bech32UtilValidationTest {

    // real mainnet identifiers
    private static final String STAKE_ADDRESS =
            "stake1uyrx65wjqjgeeksd8hptmcgl5jfyrqkfq0xe8xlp367kphsckq250";
    private static final String POOL_ID =
            "pool1z5uqdk7dzdxaae5633fqfcu2eqzy3a3rgtuvy087fdld7yws0xt";
    private static final String DREP_ID =
            "drep1ygqzg3ed7rdqeg3343jw0fptqzc3lqtk3rvnnmgq64rj85sxd4sr4";

    @Test
    void acceptsRealIdentifiersTest() {
        assertTrue(Bech32Util.isValid(STAKE_ADDRESS));
        assertTrue(Bech32Util.isValid(POOL_ID));
        assertTrue(Bech32Util.isValid(DREP_ID));
    }

    @Test
    void acceptsValidCharactersTest() {
        assertTrue(Bech32Util.hasValidChars(STAKE_ADDRESS));
        assertTrue(Bech32Util.hasValidChars(POOL_ID));
    }

    @Test
    void rejectsCorruptedChecksumTest() {
        // flip the final character: still valid bech32 charset, wrong checksum
        char last = POOL_ID.charAt(POOL_ID.length() - 1);
        char swapped = last == 't' ? 'v' : 't';
        String corrupted = POOL_ID.substring(0, POOL_ID.length() - 1) + swapped;

        assertTrue(Bech32Util.hasValidChars(corrupted), "charset is still valid");
        assertFalse(Bech32Util.isValid(corrupted), "checksum must fail");
    }

    @Test
    void rejectsMixedCaseTest() {
        String mixed = "Stake1uyrx65wjqjgeeksd8hptmcgl5jfyrqkfq0xe8xlp367kphsckq250";
        assertFalse(Bech32Util.hasValidChars(mixed));
        assertFalse(Bech32Util.isValid(mixed));
    }

    @Test
    void rejectsMissingSeparatorTest() {
        assertFalse(Bech32Util.hasValidChars("thisstringhasnoseparatoratall"));
    }

    @Test
    void rejectsTooShortForChecksumTest() {
        // has a separator and valid chars, but no room for a checksum
        assertFalse(Bech32Util.isValid("a1qqq"));
    }

    @Test
    void rejectsNullAndEmptyTest() {
        assertFalse(Bech32Util.isValid(null));
        assertFalse(Bech32Util.isValid(""));
    }
}
