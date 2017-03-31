package org.vonad.callapiwithrx2androidandretrofit2.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.vonad.callapiwithrx2androidandretrofit2.interfaces.ICallMyApiForApp;
import org.vonad.callapiwithrx2androidandretrofit2.interfaces.IResultListener;
import org.vonad.callapiwithrx2androidandretrofit2.models.ResultModel;
import org.vonad.callapiwithrx2androidandretrofit2.utils.ApiContants;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by VONAD
 */

public class DataServices {

    private static <T> T createRetrofitService(final Class<T> clazz) {
        return createRetrofitService(clazz, ApiContants.WS_API_URL);
    }

    private static <T> T createRetrofitService(final Class<T> clazz, String baseApiUrl) {
        OkHttpClient okClient = new OkHttpClient.Builder()
                .build();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        return new Retrofit.Builder()
                .baseUrl(baseApiUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okClient)
                .build().create(clazz);
    }
    //Call api.
    public static void getInforOfUser(String nameUserLogin, final IResultListener<ResultModel> resultListener) {
        createRetrofitService(ICallMyApiForApp.class, ApiContants.WS_API_URL).getResultModels(nameUserLogin)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultModel>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ResultModel appDifferenceModels) {
                resultListener.onSuccess(appDifferenceModels);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(">>>>>> check fail:" + e.getMessage());
                resultListener.onFail(">>>>>> Fail:" + e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });


    }

}


