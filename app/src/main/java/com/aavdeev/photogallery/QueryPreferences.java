package com.aavdeev.photogallery;

import android.content.Context;
import android.net.ConnectivityManager;
import android.preference.PreferenceManager;


public class QueryPreferences {
   //ключ для хранения запроса
    private static final String PREF_SEARCH_QUERY = "searchQuery";
    //хранение индетификатора
    private static final String PREF_LAST_RESULT_ID = "lastResultId";
    private static final String PREF_IS_ALARM_ON = "isAlarmOn";



    //возвращает значение запроса
    public static String getStoredQuery(Context context) {
        //получаем объект поумолчанию для заданного контекста
        return PreferenceManager.getDefaultSharedPreferences(context)
                //
                .getString(PREF_SEARCH_QUERY, null);
    }

    public static void setStrongedQuery(Context context, String query) {
        PreferenceManager.getDefaultSharedPreferences(context)
                //сохраняет занчение в SharedPreferences.
                .edit()
                //определяет возврощаемое занчение поумолчаниюъ
                //которое должно возвращаться при отсутсвии записи
                //с ключем PREF_SEARCH_QUERY
                .putString(PREF_SEARCH_QUERY, query)
                //внести изменения
                .apply();
    }

    public static String getPrefLastResultId(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(PREF_LAST_RESULT_ID, null);
    }

    public static boolean isAlarmOn(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(PREF_IS_ALARM_ON, false);
    }

    public static void setAlarmOn(Context context, boolean isOn) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putBoolean(PREF_IS_ALARM_ON, isOn)
                .apply();
    }

    public static void setPrefLastResultId(Context context, String lastResultId) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putString(PREF_LAST_RESULT_ID, lastResultId)
                .apply();
    }
}
