package com.hogan.letyoucool.bean;

import java.io.Serializable;

/**
 * Created by chenhu on 2016/4/25.
 */
public class DynamicAppBean implements Serializable {

    private String loName;
    private String loPicUrlIos;
    private String loPicUrlAndroid;
    private String isDis;
    private String IsDisWord;

    public String getLoPicUrlPressIos() {
        return loPicUrlPressIos;
    }

    public void setLoPicUrlPressIos(String loPicUrlPressIos) {
        this.loPicUrlPressIos = loPicUrlPressIos;
    }

    public String getLoPicUrlPressAndroid() {
        return loPicUrlPressAndroid;
    }

    public void setLoPicUrlPressAndroid(String loPicUrlPressAndroid) {
        this.loPicUrlPressAndroid = loPicUrlPressAndroid;
    }

    public String getLoWebUrl() {
        return loWebUrl;
    }

    public void setLoWebUrl(String loWebUrl) {
        this.loWebUrl = loWebUrl;
    }

    private String sort;
    private String loPicUrlPressIos;
    private String loPicUrlPressAndroid;
    private String loWebUrl;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getLoName() {
        return loName;
    }

    public void setLoName(String loName) {
        this.loName = loName;
    }

    public String getLoPicUrlIos() {
        return loPicUrlIos;
    }

    public void setLoPicUrlIos(String loPicUrlIos) {
        this.loPicUrlIos = loPicUrlIos;
    }

    public String getLoPicUrlAndroid() {
        return loPicUrlAndroid;
    }

    public void setLoPicUrlAndroid(String loPicUrlAndroid) {
        this.loPicUrlAndroid = loPicUrlAndroid;
    }

    public String getIsDis() {
        return isDis;
    }

    public void setIsDis(String isDis) {
        this.isDis = isDis;
    }

    public String getIsDisWord() {
        return IsDisWord;
    }

    public void setIsDisWord(String isDisWord) {
        IsDisWord = isDisWord;
    }
}
