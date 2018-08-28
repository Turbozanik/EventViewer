package com.cryospav2.data.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import static com.cryospav2.data.Constants.ADS_KEY;
import static com.cryospav2.data.Constants.CAPSULE_ID;
import static com.cryospav2.data.Constants.CASH_OPTION;
import static com.cryospav2.data.Constants.CLIENT_TOKEN;
import static com.cryospav2.data.Constants.COMPANY_ID;
import static com.cryospav2.data.Constants.COMPANY_STATE;
import static com.cryospav2.data.Constants.DEVICE_ID_PARAM;
import static com.cryospav2.data.Constants.HOUR;
import static com.cryospav2.data.Constants.LAST_SESSION_TIME;
import static com.cryospav2.data.Constants.LOGO_KEY;
import static com.cryospav2.data.Constants.LOGO_TEXT_KEY;
import static com.cryospav2.data.Constants.MERCHANT_ID;
import static com.cryospav2.data.Constants.MERCHANT_KEY;
import static com.cryospav2.data.Constants.OPERATOR_TOKEN;
import static com.cryospav2.data.Constants.PAYMENT_SERVICE;
import static com.cryospav2.data.Constants.POS_STATUS;
import static com.cryospav2.data.Constants.PRECOOL_TEMP;
import static com.cryospav2.data.Constants.PRECOOL_TEMP_PARAM;
import static com.cryospav2.data.Constants.PRECOOL_TIME_LEFT_PARAM;
import static com.cryospav2.data.Constants.PRECOOL_TIME_PARAM;
import static com.cryospav2.data.Constants.UNIT_ID;
import static com.cryospav2.data.Constants.VIDEO_LAST_UPDATE;

public class PrefsDataSource {
    private static SharedPreferences prefs;

    public PrefsDataSource(Context context) {
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void savePrecoolTargetTemp(float temp) {
        prefs.edit()
                .putFloat(PRECOOL_TEMP, temp)
                .apply();
    }

//    public static float getPrecoolTargetTemp() {
//        return prefs.getFloat(PRECOOL_TEMP, PRECOOL_OFF);
//    }

    public static void saveLastSessionTime(String lastSession) {
        prefs.edit()
                .putString(LAST_SESSION_TIME, lastSession)
                .apply();
    }

    public static String getLastSessionTime() {
        return prefs.getString(LAST_SESSION_TIME, null);
    }

    public static void saveCompanyAds(String videoUrl) {
        prefs.edit()
                .putString(ADS_KEY, videoUrl)
                .apply();
    }

    public static String getCompanyLogoText() {
        return prefs.getString(LOGO_TEXT_KEY, "");
    }

    public static String getCompanyState() {
        return prefs.getString(COMPANY_STATE, "");
    }

    public static boolean isUnitCashOptionEnabled() {
        return prefs.getBoolean(CASH_OPTION, true);
    }

    public static ArrayList<Float> getPrecoolTempParams() {
        String precoolTempParams = prefs.getString(PRECOOL_TEMP_PARAM, null);
        if (TextUtils.isEmpty(precoolTempParams)) {
            ArrayList<Float> paramsList = new ArrayList<>();
//            paramsList.add(PRECOOL_TEMP_LEVEL0);
//            paramsList.add(PRECOOL_TEMP_LEVEL1);
//            paramsList.add(PRECOOL_TEMP_LEVEL2);
//            paramsList.add(PRECOOL_TEMP_LEVEL3);
//            paramsList.add(PRECOOL_TEMP_LEVEL4);
//            paramsList.add(PRECOOL_TEMP_LEVEL5);
//            paramsList.add(PRECOOL_TEMP_LEVEL6);
            return paramsList;
        }
        return new Gson().fromJson(precoolTempParams, new TypeToken<ArrayList<Float>>() {
        }.getType());
    }

    public static void savePrecoolTime(long precoolTime) {
        prefs.edit()
                .putLong(PRECOOL_TIME_PARAM, precoolTime)
                .apply();
    }

    public static long getPrecoolTime() {
        if (prefs.getLong(PRECOOL_TIME_PARAM, 0) == 0) {
            savePrecoolTime(HOUR / 2); // TODO: 04.05.17
        }
        return prefs.getLong(PRECOOL_TIME_PARAM, 0);
    }

    public static void savePrecoolTimeLeft(long timeLeft) {
        prefs.edit()
                .putLong(PRECOOL_TIME_LEFT_PARAM, timeLeft)
                .apply();
    }

    public static long getPrecoolTimeLeft() {
        return prefs.getLong(PRECOOL_TIME_LEFT_PARAM, 0);
    }

    public static int getPaymentServiceType() {
        return prefs.getInt(PAYMENT_SERVICE, 0);
    }

    public void saveCustomerToken(String token) {
        prefs.edit()
                .putString(CLIENT_TOKEN, token)
                .apply();
    }

    public void removeCustomerToken() {
        prefs.edit()
                .putString(CLIENT_TOKEN, null)
                .apply();
    }

    public String getCustomerToken() {
        return prefs.getString(CLIENT_TOKEN, null);
    }

    public void saveOperatorToken(String token) {
        prefs.edit()
                .putString(OPERATOR_TOKEN, token)
                .apply();
    }

    public void removeOperatorToken() {
        prefs.edit()
                .putString(OPERATOR_TOKEN, null)
                .apply();
    }

    public String getOperatorToken() {
        return prefs.getString(OPERATOR_TOKEN, null);
    }

    public void saveCompanyId(int id) {
        prefs.edit()
                .putInt(COMPANY_ID, id)
                .apply();
    }

    public void saveCapsuleId(int id) {
        prefs.edit()
                .putInt(CAPSULE_ID, id)
                .apply();
    }

    public void removeCompanyId() {
        prefs.edit()
                .putString(COMPANY_ID, null)
                .apply();
    }

    public int getCompanyId() {
        return prefs.getInt(COMPANY_ID, 0);
    }

    public int getCapsuleId() {
        return prefs.getInt(CAPSULE_ID, 0);
    }

    public void saveUnitId(int id) {
        prefs.edit()
                .putInt(UNIT_ID, id)
                .apply();
    }

    public void saveDeviceId(int deviceId) {
        prefs.edit()
                .putInt(DEVICE_ID_PARAM, deviceId)
                .apply();
    }

    public int getDeviceId() {
        return prefs.getInt(DEVICE_ID_PARAM, 0);
    }

    public void removeUnitId() {
        prefs.edit()
                .putString(UNIT_ID, null)
                .apply();
    }

    public int getUnitId() {
        return prefs.getInt(UNIT_ID, -1);
    }

    public void saveMerchantId(String merchantId) {
        prefs.edit()
                .putString(MERCHANT_ID, merchantId)
                .apply();
    }

    public void removeMerchantId() {
        prefs.edit()
                .putString(MERCHANT_ID, null)
                .apply();
    }

    public String getMerchantId() {
        return prefs.getString(MERCHANT_ID, null);
    }

    public void saveMerchantKey(String merchantKey) {
        prefs.edit()
                .putString(MERCHANT_KEY, merchantKey)
                .apply();
    }

    public void saveCompanyLogo(String url) {
        prefs.edit()
                .putString(LOGO_KEY, url)
                .apply();
    }

    public String getCompanyLogo() {
        return prefs.getString(LOGO_KEY, "");
    }

    public void removeMerchantKey() {
        prefs.edit()
                .putString(MERCHANT_KEY, null)
                .apply();
    }

    public String getMerchantKey() {
        return prefs.getString(MERCHANT_KEY, null);
    }

    public String getCompanyAds() {
        return prefs.getString(ADS_KEY, "");
    }

    public void saveCompanyLogoText(String text) {
        prefs.edit()
                .putString(LOGO_TEXT_KEY, text)
                .apply();
    }

    public void saveCompanyState(String state) {
        prefs.edit()
                .putString(COMPANY_STATE, state)
                .apply();
    }

    public void saveUnitCashOption(boolean isCashAllowed) {
        prefs.edit()
                .putBoolean(CASH_OPTION, isCashAllowed)
                .apply();
    }

    public void savePrecoolTempParams(ArrayList<Float> paramsList) {
        prefs.edit()
                .putString(PRECOOL_TEMP_PARAM, new Gson().toJson(paramsList))
                .apply();
    }

    public void savePaymentServiceType(int paymentSystem) {
        prefs.edit()
                .putInt(PAYMENT_SERVICE, paymentSystem)
                .apply();
    }

    public void savePosStatusFlag(boolean publicView) {
        prefs.edit()
                .putBoolean(POS_STATUS, publicView)
                .apply();
    }

    public boolean getPosStatusFlag() {
        return prefs.getBoolean(POS_STATUS, true);
    }

    public long getLastVideoUpdateDate() {
        return prefs.getInt(VIDEO_LAST_UPDATE, 0);
    }

    public void setLastVideoUpdateDate(long timestamp) {
        prefs.edit()
                .putLong(VIDEO_LAST_UPDATE, timestamp)
                .apply();
    }
}
