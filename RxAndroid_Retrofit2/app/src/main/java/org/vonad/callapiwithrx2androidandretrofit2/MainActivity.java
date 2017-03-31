package org.vonad.callapiwithrx2androidandretrofit2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.vonad.callapiwithrx2androidandretrofit2.data.DataServices;
import org.vonad.callapiwithrx2androidandretrofit2.interfaces.IResultListener;
import org.vonad.callapiwithrx2androidandretrofit2.models.ResultModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
