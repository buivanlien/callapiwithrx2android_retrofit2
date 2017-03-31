package org.vonad.callapiwithrx2androidandretrofit2.interfaces;

/**
 * Created by VONAD
 */

public interface IResultListener<T> {
    public void onSuccess(T result);

    public void onFail(String message);
}