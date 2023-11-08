package rest.koios.client.backend.factory.options;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import rest.koios.client.backend.api.base.common.TxHash;
import rest.koios.client.backend.api.address.AddressService;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.factory.BackendFactory;
import rest.koios.client.backend.factory.options.filters.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OptionsPreviewTest {

    private AddressService addressService;

    @BeforeAll
    public void setup() {
        addressService = BackendFactory.getKoiosPreviewService().getAddressService();
    }

    @Test
    void MixedOptionsTest() throws ApiException {
        String address = "addr_test1qrvaadv0h7atv366u6966u4rft2svjlf5uajy8lkpsgdrc24rnskuetxz2u3m5ac22s3njvftxcl2fc8k8kjr088ge0qz98xmv";

        Options options = Options.builder()
                .option(Limit.of(10))
                .option(Offset.of(0))
                .option(Order.by("block_height", SortType.DESC))
                .option(Filter.of("block_height", FilterType.GTE, "42248"))
                .option(Filter.of("block_height", FilterType.LTE, "69447")).build();

        Result<List<TxHash>> transactionsResult = addressService.getAddressTransactions(List.of(address), options);

        assertTrue(transactionsResult.isSuccessful());
        assertNotNull(transactionsResult.getValue());
        log.info(transactionsResult.getValue().toString());
        assertEquals(10, transactionsResult.getValue().size());
        assertEquals("8a1f7811d7c3c46c3421e5b6515239c8cd7cce21c371bb0d5c107d0296fab29d", transactionsResult.getValue().get(0).getTxHash());
        assertNotEquals(0, transactionsResult.getValue().get(0).getBlockHeight());
        assertNotNull(transactionsResult.getValue().get(0).getBlockTime());
    }

    @Test
    void MixedWithLogicalOperatorOptionsTest() throws ApiException {
        String address = "addr_test1qrvaadv0h7atv366u6966u4rft2svjlf5uajy8lkpsgdrc24rnskuetxz2u3m5ac22s3njvftxcl2fc8k8kjr088ge0qz98xmv";

        Options options = Options.builder()
                .option(Limit.of(6))
                .option(Offset.of(0))
                .option(Order.by("block_height", SortType.DESC))
                .option(LogicalOperatorFilter.of(LogicalOperatorFilterType.AND,
                        Filter.of("block_height", FilterType.GTE, "42248"),
                        Filter.of("block_height", FilterType.LTE, "69447"))).build();

        Result<List<TxHash>> transactionsResult = addressService.getAddressTransactions(List.of(address), options);

        assertTrue(transactionsResult.isSuccessful());
        assertNotNull(transactionsResult.getValue());
        log.info(transactionsResult.getValue().toString());
        assertEquals(6, transactionsResult.getValue().size());
        assertEquals("8a1f7811d7c3c46c3421e5b6515239c8cd7cce21c371bb0d5c107d0296fab29d", transactionsResult.getValue().get(0).getTxHash());
        assertNotEquals(0, transactionsResult.getValue().get(0).getBlockHeight());
        assertNotNull(transactionsResult.getValue().get(0).getBlockTime());
    }

    @Test
    void MixedWithNotOperatorOptionsTest() throws ApiException {
        String address = "addr_test1qrvaadv0h7atv366u6966u4rft2svjlf5uajy8lkpsgdrc24rnskuetxz2u3m5ac22s3njvftxcl2fc8k8kjr088ge0qz98xmv";

        Options options = Options.builder()
                .option(Limit.of(50))
                .option(Offset.of(0))
                .option(Order.by("block_height", SortType.DESC))
                .option(LogicalOperatorFilter.of(LogicalOperatorFilterType.AND,
                        Filter.of("block_height", FilterType.GTE, "42248"),
                        Filter.of("block_height", FilterType.LTE, "69447"),
                        NotOperatorFilter.of(Filter.of("block_height", FilterType.EQ, "58776")))).build();

        Result<List<TxHash>> transactionsResult = addressService.getAddressTransactions(List.of(address), options);

        assertTrue(transactionsResult.isSuccessful());
        assertNotNull(transactionsResult.getValue());
        log.info(transactionsResult.getValue().toString());
        assertEquals(39, transactionsResult.getValue().size());
        assertEquals("8a1f7811d7c3c46c3421e5b6515239c8cd7cce21c371bb0d5c107d0296fab29d", transactionsResult.getValue().get(0).getTxHash());
        assertNotEquals(0, transactionsResult.getValue().get(0).getBlockHeight());
        assertNotNull(transactionsResult.getValue().get(0).getBlockTime());
    }

    @Test
    void MixedWithLogicalNotOperatorOptionsTest() throws ApiException {
        String address = "addr_test1qrvaadv0h7atv366u6966u4rft2svjlf5uajy8lkpsgdrc24rnskuetxz2u3m5ac22s3njvftxcl2fc8k8kjr088ge0qz98xmv";

        Options options = Options.builder()
                .option(Limit.of(20))
                .option(Offset.of(0))
                .option(Order.by("block_height", SortType.DESC))
                .option(NotOperatorFilter.of(LogicalOperatorFilter.of(LogicalOperatorFilterType.AND,
                        Filter.of("block_height", FilterType.GTE, "42248"),
                        Filter.of("block_height", FilterType.LTE, "69447")))).build();

        Result<List<TxHash>> transactionsResult = addressService.getAddressTransactions(List.of(address), options);

        assertTrue(transactionsResult.isSuccessful());
        assertNotNull(transactionsResult.getValue());
        log.info(transactionsResult.getValue().toString());
        assertEquals(20, transactionsResult.getValue().size());
        assertNotEquals("8a1f7811d7c3c46c3421e5b6515239c8cd7cce21c371bb0d5c107d0296fab29d", transactionsResult.getValue().get(0).getTxHash());
        assertNotEquals(0, transactionsResult.getValue().get(0).getBlockHeight());
        assertNotNull(transactionsResult.getValue().get(0).getBlockTime());
    }
}
