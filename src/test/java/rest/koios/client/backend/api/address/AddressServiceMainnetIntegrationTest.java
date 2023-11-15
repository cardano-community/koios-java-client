package rest.koios.client.backend.api.address;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import rest.koios.client.backend.api.base.common.TxHash;
import rest.koios.client.backend.api.address.model.AddressAsset;
import rest.koios.client.backend.api.address.model.AddressInfo;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.common.UTxO;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.factory.BackendFactory;
import rest.koios.client.backend.factory.options.Options;
import rest.koios.client.backend.factory.options.SortType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AddressServiceMainnetIntegrationTest {

    private AddressService addressService;

    @BeforeAll
    public void setup() {
        addressService = BackendFactory.getKoiosMainnetService().getAddressService();
    }

    @Test
    void getAddressInformationTest() throws ApiException {
        String address = "addr1qyp9kz50sh9c53hpmk3l4ewj9ur794t2hdqpngsjn3wkc5sztv9glpwt3frwrhdrltjaytc8ut2k4w6qrx3p98zad3fq07xe9g";
        Result<AddressInfo> addressInformationResult = addressService.getAddressInformation(address);
        Assertions.assertTrue(addressInformationResult.isSuccessful());
        Assertions.assertNotNull(addressInformationResult.getValue());
        log.info(addressInformationResult.getValue().toString());
    }

    @Test
    void getAddressInformationTest2() throws ApiException {
        List<String> addresses = List.of("addr1qy2jt0qpqz2z2z9zx5w4xemekkce7yderz53kjue53lpqv90lkfa9sgrfjuz6uvt4uqtrqhl2kj0a9lnr9ndzutx32gqleeckv",
                "addr1q9xvgr4ehvu5k5tmaly7ugpnvekpqvnxj8xy50pa7kyetlnhel389pa4rnq6fmkzwsaynmw0mnldhlmchn2sfd589fgsz9dd0y");
        Result<List<AddressInfo>> addressInformationResult = addressService.getAddressInformation(addresses, SortType.ASC, Options.EMPTY);
        Assertions.assertTrue(addressInformationResult.isSuccessful());
        Assertions.assertNotNull(addressInformationResult.getValue());
        log.info(addressInformationResult.getValue().toString());
    }

    @Test
    void getAddressInformationBadRequestTest() {
        String address = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> addressService.getAddressInformation(address));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAddressUTxOsTest() throws ApiException {
        List<String> addresses = List.of("addr1qy2jt0qpqz2z2z9zx5w4xemekkce7yderz53kjue53lpqv90lkfa9sgrfjuz6uvt4uqtrqhl2kj0a9lnr9ndzutx32gqleeckv",
                "addr1q9xvgr4ehvu5k5tmaly7ugpnvekpqvnxj8xy50pa7kyetlnhel389pa4rnq6fmkzwsaynmw0mnldhlmchn2sfd589fgsz9dd0y");
        Result<List<UTxO>> addressUTxOsResult = addressService.getAddressUTxOs(addresses, true, Options.EMPTY);
        Assertions.assertTrue(addressUTxOsResult.isSuccessful());
        Assertions.assertNotNull(addressUTxOsResult.getValue());
        log.info(addressUTxOsResult.getValue().toString());
    }

    @Test
    void getAddressUTxOsBadRequestTest() {
        List<String> addresses = List.of("asdf123",
                "addr1q9xvgr4ehvu5k5tmaly7ugpnvekpqvnxj8xy50pa7kyetlnhel389pa4rnq6fmkzwsaynmw0mnldhlmchn2sfd589fgsz9dd0y");
        ApiException exception = assertThrows(ApiException.class, () -> addressService.getAddressUTxOs(addresses, false, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getUTxOsFromPaymentCredentialsTest() throws ApiException {
        List<String> addresses = List.of("025b0a8f85cb8a46e1dda3fae5d22f07e2d56abb4019a2129c5d6c52",
                "13f6870c5e4f3b242463e4dc1f2f56b02a032d3797d933816f15e555");
        Result<List<UTxO>> addressUTxOsResult = addressService.getUTxOsFromPaymentCredentials(addresses, true, Options.EMPTY);
        Assertions.assertTrue(addressUTxOsResult.isSuccessful());
        Assertions.assertNotNull(addressUTxOsResult.getValue());
        log.info(addressUTxOsResult.getValue().toString());
    }

    @Test
    void getAddressTransactionsTest() throws ApiException {
        String address = "addr1qyp9kz50sh9c53hpmk3l4ewj9ur794t2hdqpngsjn3wkc5sztv9glpwt3frwrhdrltjaytc8ut2k4w6qrx3p98zad3fq07xe9g";
        Result<List<TxHash>> txHashesResult = addressService.getAddressTransactions(List.of(address), 250, Options.EMPTY);
        Assertions.assertTrue(txHashesResult.isSuccessful());
        Assertions.assertNotNull(txHashesResult.getValue());
        log.info(txHashesResult.getValue().toString());
    }

    @Test
    void getAddressTransactionsBadRequestTest() {
        String badAddress = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> addressService.getAddressTransactions(List.of(badAddress), 250, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);

        String address = "addr1qyp9kz50sh9c53hpmk3l4ewj9ur794t2hdqpngsjn3wkc5sztv9glpwt3frwrhdrltjaytc8ut2k4w6qrx3p98zad3fq07xe9g";
        exception = assertThrows(ApiException.class, () -> addressService.getAddressTransactions(List.of(address), -5, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAddressAssetsTest() throws ApiException {
        String address = "addr1vx0l928zuszdgn2qs062tyze320v0vmg3hdszkw3fykwdece25sw8";
        Result<List<AddressAsset>> assetInfosResult = addressService.getAddressAssets(List.of(address), Options.EMPTY);
        Assertions.assertTrue(assetInfosResult.isSuccessful());
        Assertions.assertNotNull(assetInfosResult.getValue());
        Assertions.assertFalse(assetInfosResult.getValue().isEmpty());
        log.info(assetInfosResult.getValue().toString());
    }

    @Test
    void getAddressAssetsBadRequestTest() {
        String address = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> addressService.getAddressAssets(List.of(address), Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getTransactionsByPaymentCredentialsTest() throws ApiException {
        String paymentCredentials = "025b0a8f85cb8a46e1dda3fae5d22f07e2d56abb4019a2129c5d6c52";
        Result<List<TxHash>> txHashesResult = addressService.getTransactionsByPaymentCredentials(List.of(paymentCredentials), Options.EMPTY);
        Assertions.assertTrue(txHashesResult.isSuccessful());
        Assertions.assertNotNull(txHashesResult.getValue());
        log.info(txHashesResult.getValue().toString());
    }

    @Test
    void getTransactionsByPaymentCredentialsBadRequestTest() {
        String badPaymentCredentials = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> addressService.getTransactionsByPaymentCredentials(List.of(badPaymentCredentials), 250, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);

        String paymentCredentials = "025b0a8f85cb8a46e1dda3fae5d22f07e2d56abb4019a2129c5d6c52";
        exception = assertThrows(ApiException.class, () -> addressService.getTransactionsByPaymentCredentials(List.of(paymentCredentials), -5, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }
}
