package rest.koios.client.backend.api.script.impl;

import rest.koios.client.backend.api.base.BaseService;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.script.ScriptService;
import rest.koios.client.backend.api.script.api.ScriptApi;
import rest.koios.client.backend.api.script.model.Script;
import rest.koios.client.backend.api.script.model.ScriptRedeemer;
import rest.koios.client.backend.factory.options.Options;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

/**
 * Script Service Implementation
 */
public class ScriptServiceImpl extends BaseService implements ScriptService {

    private final ScriptApi scriptApi;

    /**
     * Script Service Implementation Constructor
     *
     * @param baseUrl Base URL
     */
    public ScriptServiceImpl(String baseUrl) {
        super(baseUrl);
        scriptApi = getRetrofit().create(ScriptApi.class);
    }

    @Override
    public Result<List<Script>> getScriptList(Options options) throws ApiException {
        Call<List<Script>> call = scriptApi.getScriptList(options.toMap());
        try {
            Response<List<Script>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<ScriptRedeemer>> getScriptRedeemers(String scriptHash) throws ApiException {
        validateHexFormat(scriptHash);
        Call<List<ScriptRedeemer>> call = scriptApi.getScriptRedeemers(scriptHash);
        try {
            Response<List<ScriptRedeemer>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }
}
