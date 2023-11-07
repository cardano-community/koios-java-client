package rest.koios.client.backend.api.transactions.impl;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rest.koios.client.backend.api.base.BaseService;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.common.UTxO;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.transactions.api.TransactionApi;
import rest.koios.client.backend.api.transactions.model.*;
import rest.koios.client.backend.api.transactions.TransactionsService;
import rest.koios.client.backend.factory.options.Options;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Transaction Service Implementation
 */
public class TransactionsServiceImpl extends BaseService implements TransactionsService {

    private final TransactionApi transactionApi;

    /**
     * Transaction Service Implementation Constructor
     *
     * @param baseUrl Base Url
     * @param apiToken Authorization Bearer JWT Token
     */
    public TransactionsServiceImpl(String baseUrl, String apiToken) {
        super(baseUrl, apiToken);
        transactionApi = getRetrofit().create(TransactionApi.class);
    }

    @Override
    public Result<List<UTxO>> getUTxOInfo(List<String> utxoRefs, boolean extended) throws ApiException {
        Call<List<UTxO>> call = transactionApi.getUTxOInfo(buildBodyUTxOs(utxoRefs, extended), Collections.emptyMap());
        try {
            Response<List<UTxO>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<TxInfo> getTransactionInformation(String txHash) throws ApiException {
        validateHexFormat(txHash);
        Call<List<TxInfo>> call = transactionApi.getTransactionInformation(buildBody(List.of(txHash)), Collections.emptyMap());
        try {
            Response<List<TxInfo>> response = (Response) execute(call);
            return processResponseGetOne(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<TxInfo>> getTransactionInformation(List<String> txHashes, Options options) throws ApiException {
        for (String tx : txHashes) {
            validateHexFormat(tx);
        }
        Call<List<TxInfo>> call = transactionApi.getTransactionInformation(buildBody(txHashes), optionsToParamMap(options));
        try {
            Response<List<TxInfo>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<TxMetadata>> getTransactionMetadata(List<String> txHashes, Options options) throws ApiException {
        for (String tx : txHashes) {
            validateHexFormat(tx);
        }
        Call<List<TxMetadata>> call = transactionApi.getTransactionMetadata(buildBody(txHashes), optionsToParamMap(options));
        try {
            Response<List<TxMetadata>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<TxMetadataLabels>> getTransactionMetadataLabels(Options options) throws ApiException {
        Call<List<TxMetadataLabels>> call = transactionApi.getTransactionMetadataLabels(optionsToParamMap(options));
        try {
            Response<List<TxMetadataLabels>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<String> submitTx(byte[] cborData) throws ApiException {
        RequestBody requestBody = RequestBody.create(cborData, MediaType.parse("application/cbor"));
        Call<String> txnCall = transactionApi.submitTx(requestBody);
        try {
            Response<String> response = txnCall.execute();
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<TxStatus>> getTransactionStatus(List<String> txHashes, Options options) throws ApiException {
        for (String tx : txHashes) {
            validateHexFormat(tx);
        }
        Call<List<TxStatus>> call = transactionApi.getTransactionStatus(buildBody(txHashes), optionsToParamMap(options));
        try {
            Response<List<TxStatus>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    private Map<String, Object> buildBody(List<String> txHashes) {
        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("_tx_hashes", txHashes);
        return bodyMap;
    }

    private Map<String, Object> buildBodyUTxOs(List<String> utxoRefs, boolean extended) {
        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("_utxo_refs", utxoRefs);
        bodyMap.put("_extended", extended);
        return bodyMap;
    }
}
