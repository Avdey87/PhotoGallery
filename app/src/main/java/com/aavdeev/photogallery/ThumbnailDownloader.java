package com.aavdeev.photogallery;

import android.os.HandlerThread;
import android.util.Log;

public class ThumbnailDownloader<T> extends HandlerThread {
    private static final String TAG = "ThumbnailDownloader";

    public ThumbnailDownloader() {
        super(TAG);
    }

    //Ожидает получение объекта типа Т , выполняющий функции индетификатора
    //загрузки и String URL-адресом для загрузки.
    //Метод будет вызывается GalleryItemAdapter в его реализации onBindViewHolder()
    public void queueThumbnail(T target, String url) {
        Log.i(TAG, "Got a URL: " + url);
    }
}
