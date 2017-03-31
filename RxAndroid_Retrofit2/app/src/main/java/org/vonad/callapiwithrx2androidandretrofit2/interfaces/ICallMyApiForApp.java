package org.vonad.callapiwithrx2androidandretrofit2.interfaces;

import org.vonad.callapiwithrx2androidandretrofit2.models.ResultModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by VONAD
 */

public interface ICallMyApiForApp {
    //remember {user} is user of path.
    @GET("/users/{user}")
    Observable<ResultModel> getResultModels(@Path("user") String nameUser);

}
