package org.vonad.callapiwithrx2androidandretrofit2;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.vonad.callapiwithrx2androidandretrofit2.data.DataServices;
import org.vonad.callapiwithrx2androidandretrofit2.interfaces.IResultListener;
import org.vonad.callapiwithrx2androidandretrofit2.models.ResultModel;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        DataServices.getInforOfUser("buivanlien", new IResultListener<ResultModel>() {
            @Override
            public void onSuccess(ResultModel result) {
                System.out.println(">>>> Result :" + result.getName() + "__" + result.getCompany());
            }

            @Override
            public void onFail(String message) {

            }
        });
    }
}
