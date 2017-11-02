package com.aavdeev.photogallery;

import android.content.Context;
import android.preference.PreferenceManager;


public class QueryPreferences {
   //ключ для хранения запроса
    private static final String PREF_SEARCH_QUERY = "searchQuery";

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
}
