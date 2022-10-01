package rest.koios.client.backend.factory.options;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import rest.koios.client.backend.api.TxHash;
import rest.koios.client.backend.api.address.AddressService;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.factory.BackendFactory;
import rest.koios.client.backend.factory.options.filters.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OptionsTest {

    private AddressService addressService;

    @BeforeAll
    public void setup() {
        addressService = BackendFactory.getKoiosTestnetService().getAddressService();
    }

    @Test
    void MixedOptionsTest() throws ApiException {
        String address = "addr_test1qzx9hu8j4ah3auytk0mwcupd69hpc52t0cw39a65ndrah86djs784u92a3m5w475w3w35tyd6v3qumkze80j8a6h5tuqq5xe8y";

        Options options = Options.builder()
                .option(Limit.of(10))
                .option(Offset.of(0))
                .option(Order.by("block_height", SortType.DESC))
                .option(Filter.of("block_height", FilterType.GTE, "3168087"))
                .option(Filter.of("block_height", FilterType.LTE, "3168097")).build();

        Result<List<TxHash>> transactionsResult = addressService.getAddressTransactions(List.of(address), options);

        assertTrue(transactionsResult.isSuccessful());
        assertNotNull(transactionsResult.getValue());
        log.info(transactionsResult.getValue().toString());
        assertEquals(8, transactionsResult.getValue().size());
        assertEquals("389867cb7a962b370764c1c255c54e72abc9073983e9b17d5aabcb3fe043b8c3", transactionsResult.getValue().get(0).getTxHash());
        assertNotEquals(0, transactionsResult.getValue().get(0).getBlockHeight());
        assertNotNull(transactionsResult.getValue().get(0).getBlockTime());
    }

    @Test
    void MixedWithLogicalOperatorOptionsTest() throws ApiException {
        String address = "addr_test1qzx9hu8j4ah3auytk0mwcupd69hpc52t0cw39a65ndrah86djs784u92a3m5w475w3w35tyd6v3qumkze80j8a6h5tuqq5xe8y";

        Options options = Options.builder()
                .option(Limit.of(50))
                .option(Offset.of(0))
                .option(Order.by("block_height", SortType.DESC))
                .option(LogicalOperatorFilter.of(LogicalOperatorFilterType.AND,
                        Filter.of("block_height", FilterType.GTE, "3168087"),
                        Filter.of("block_height", FilterType.LTE, "3168097"))).build();

        Result<List<TxHash>> transactionsResult = addressService.getAddressTransactions(List.of(address), options);

        assertTrue(transactionsResult.isSuccessful());
        assertNotNull(transactionsResult.getValue());
        log.info(transactionsResult.getValue().toString());
        assertEquals(8, transactionsResult.getValue().size());
        assertEquals("389867cb7a962b370764c1c255c54e72abc9073983e9b17d5aabcb3fe043b8c3", transactionsResult.getValue().get(0).getTxHash());
        assertNotEquals(0, transactionsResult.getValue().get(0).getBlockHeight());
        assertNotNull(transactionsResult.getValue().get(0).getBlockTime());
    }

    @Test
    void MixedWithNotOperatorOptionsTest() throws ApiException {
        String address = "addr_test1qzx9hu8j4ah3auytk0mwcupd69hpc52t0cw39a65ndrah86djs784u92a3m5w475w3w35tyd6v3qumkze80j8a6h5tuqq5xe8y";

        Options options = Options.builder()
                .option(Limit.of(50))
                .option(Offset.of(0))
                .option(Order.by("block_height", SortType.DESC))
                .option(LogicalOperatorFilter.of(LogicalOperatorFilterType.AND,
                        Filter.of("block_height", FilterType.GTE, "3168087"),
                        Filter.of("block_height", FilterType.LTE, "3168097"),
                        NotOperatorFilter.of(Filter.of("block_height", FilterType.EQ, "3168096")))).build();

        Result<List<TxHash>> transactionsResult = addressService.getAddressTransactions(List.of(address), options);

        assertTrue(transactionsResult.isSuccessful());
        assertNotNull(transactionsResult.getValue());
        log.info(transactionsResult.getValue().toString());
        assertEquals(7, transactionsResult.getValue().size());
        assertEquals("389867cb7a962b370764c1c255c54e72abc9073983e9b17d5aabcb3fe043b8c3", transactionsResult.getValue().get(0).getTxHash());
        assertNotEquals(0, transactionsResult.getValue().get(0).getBlockHeight());
        assertNotNull(transactionsResult.getValue().get(0).getBlockTime());
    }

    @Test
    void MixedWithLogicalNotOperatorOptionsTest() throws ApiException {
        String address = "addr_test1qzx9hu8j4ah3auytk0mwcupd69hpc52t0cw39a65ndrah86djs784u92a3m5w475w3w35tyd6v3qumkze80j8a6h5tuqq5xe8y";

        Options options = Options.builder()
                .option(Limit.of(50))
                .option(Offset.of(0))
                .option(Order.by("block_height", SortType.DESC))
                .option(NotOperatorFilter.of(LogicalOperatorFilter.of(LogicalOperatorFilterType.AND,
                        Filter.of("block_height", FilterType.GTE, "3168087"),
                        Filter.of("block_height", FilterType.LTE, "3168097")))).build();

        Result<List<TxHash>> transactionsResult = addressService.getAddressTransactions(List.of(address), options);

        assertTrue(transactionsResult.isSuccessful());
        assertNotNull(transactionsResult.getValue());
        log.info(transactionsResult.getValue().toString());
        assertEquals(50, transactionsResult.getValue().size());
        assertNotEquals("389867cb7a962b370764c1c255c54e72abc9073983e9b17d5aabcb3fe043b8c3", transactionsResult.getValue().get(0).getTxHash());
        assertNotEquals(0, transactionsResult.getValue().get(0).getBlockHeight());
        assertNotNull(transactionsResult.getValue().get(0).getBlockTime());
    }
}
