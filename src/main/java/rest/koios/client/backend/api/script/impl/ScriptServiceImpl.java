package rest.koios.client.backend.api.script.impl;

import rest.koios.client.backend.api.base.BaseService;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.script.ScriptService;
import rest.koios.client.backend.api.script.api.ScriptApi;
import rest.koios.client.backend.api.script.model.NativeScript;
import rest.koios.client.backend.api.script.model.PlutusScript;
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
     * @param baseService Base Service
     */
    public ScriptServiceImpl(BaseService baseService) {
        super(baseService);
        scriptApi = getRetrofit().create(ScriptApi.class);
    }

    @Override
    public Result<List<NativeScript>> getNativeScriptList(Options options) throws ApiException {
        Call<List<NativeScript>> call = scriptApi.getNativeScriptList(optionsToParamMap(options));
        try {
            Response<List<NativeScript>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<PlutusScript>> getPlutusScriptList(Options options) throws ApiException {
        Call<List<PlutusScript>> call = scriptApi.getPlutusScriptList(optionsToParamMap(options));
        try {
            Response<List<PlutusScript>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<ScriptRedeemer>> getScriptRedeemers(String scriptHash, Options options) throws ApiException {
        validateHexFormat(scriptHash);
        Call<List<ScriptRedeemer>> call = scriptApi.getScriptRedeemers(scriptHash, optionsToParamMap(options));
        try {
            Response<List<ScriptRedeemer>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }
}
