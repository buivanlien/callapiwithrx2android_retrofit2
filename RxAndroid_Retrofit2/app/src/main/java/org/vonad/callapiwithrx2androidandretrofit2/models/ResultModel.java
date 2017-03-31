package org.vonad.callapiwithrx2androidandretrofit2.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by VONAD
 */

public class ResultModel {
    @SerializedName("name")
    private String name;
    @SerializedName("company")
    private String company;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
