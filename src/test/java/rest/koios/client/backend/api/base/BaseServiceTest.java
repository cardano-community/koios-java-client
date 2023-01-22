package rest.koios.client.backend.api.base;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.factory.OperationType;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BaseServiceTest {

    private final BaseService baseService = new BaseService(OperationType.KOIOS_MAINNET.getBaseUrl());

    @Test
    void validateHexFormatTest() {
        Assertions.assertDoesNotThrow(() -> baseService.validateHexFormat(""));
        Assertions.assertDoesNotThrow(() -> baseService.validateHexFormat("0123456789abcdef"));
        Assertions.assertThrows(ApiException.class, () -> baseService.validateHexFormat("asdf"));
    }

    @Test
    void validateEpochTest() {
        Assertions.assertDoesNotThrow(() -> baseService.validateEpoch(123));
        Assertions.assertThrows(ApiException.class, () -> baseService.validateEpoch(-123));
        Assertions.assertThrows(ApiException.class, () -> baseService.validateEpoch(null));
    }

    @Test
    void validateBech32Test() {
        Assertions.assertDoesNotThrow(() -> baseService.validateBech32("addr1qy8rxq8r59dkd5vwq42dmsyjf7w6q0ypsys0jzcg99sas2hdl6k7kz4erhgrn30sc8ky06rzfpjw8mt7suk2w3qerlus6jrfqy"));
        Assertions.assertThrows(ApiException.class, () -> baseService.validateBech32("123"));
    }
}
