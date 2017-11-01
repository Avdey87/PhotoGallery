package com.aavdeev.photogallery;


import android.net.Uri;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FlickrFetchr {
    private static final String TAG = "FlickrFetchr";
    private static final String API_KEY = "6771afce2581b99038dbcc1b87e88750";

    //получаем строку подключения
    public byte[] getUrlBytes(String urlSpec) throws IOException {
        //Пременная типа URL записываем в нее адрес
        URL url = new URL(urlSpec);
        //устанавливаем соединение
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        try {
            //пишим в out byte строку передаваему серверу
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            //пишем в in ответ от сервера
            InputStream in = connection.getInputStream();
// если соединение не удалось выбрасывам ошибку
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new IOException(connection.getResponseMessage() + " : with "
                        + urlSpec);
            }
            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while ((bytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, bytesRead);
            }
            out.close();
            return out.toByteArray();
        } finally {
            connection.disconnect();
        }

    }

    public String getUrlString(String urlSpec) throws IOException {
        return new String(getUrlBytes(urlSpec));
    }


    // Здесь мы используем класс Uri.Builder для построения
    // полного URL-адреса для API-запроса к Flickr.
    // Uri.Builder — вспомогательный класс для создания
    // параметризованных URL-адресов с правильным кодированием символов.
    // Метод Uri.Builder.appendQueryParameter(String,String)
    // автоматически кодирует строки запросов.
    public List<GalleryItem> fetchItems() {
        List<GalleryItem> items = new ArrayList<>();
        try {
            String url = Uri.parse("https://api.flickr.com/services/rest/")
                    .buildUpon()
                    .appendQueryParameter("method", "flickr.photos.getRecent")
                    .appendQueryParameter("api_key", API_KEY)
                    .appendQueryParameter("format", "json")
                    .appendQueryParameter("nojsoncallback", "1")
                    .appendQueryParameter("extras", "url_s")
                    .build().toString();
            String jsonString = getUrlString(url);
            Log.i(TAG, "Received JSON: " + jsonString);
            JSONObject jsonObject = new JSONObject(jsonString);
            parseGson(items, jsonString);
        } catch (JSONException je) {
            Log.e(TAG, "Failed to parse JSON", je);
        } catch (IOException e) {
            Log.e(TAG, "Failed to fetch items", e);
        }

        return items;
    }

    private void parseGson(List<GalleryItem> items, String jsonString) {
        Gson gson = new GsonBuilder().create();
        Flickr flickr = gson.fromJson(jsonString, Flickr.class);
        for (Flickr.PhotosBean.PhotoBean p : flickr.photos.photo) {
            GalleryItem item = new GalleryItem();
            item.setmId(p.id);
            item.setmCaption(p.title);
            item.setmUrl(p.url_s);
            items.add(item);
        }
    }


    //разбор json ответа
  /*  private void parseItems(List<GalleryItem> items, JSONObject jsonObject)
            throws IOException, JSONException {
        JSONObject photosJsonObject = jsonObject.getJSONObject("photos");
        JSONArray photoJsonArray = photosJsonObject.getJSONArray("photo");

        for (int i = 1; i < photoJsonArray.length(); i++) {
            JSONObject photoJsonObject = photoJsonArray.getJSONObject(i);

            GalleryItem item = new GalleryItem();

            item.setmId(photoJsonObject.getString("id"));
            item.setmCaption(photoJsonObject.getString("title"));

            if (!photoJsonObject.has("url_s")) {
                continue;
            }
            item.setmUrl(photoJsonObject.getString("url_s"));
            items.add(item);
        }


    }*/


}




