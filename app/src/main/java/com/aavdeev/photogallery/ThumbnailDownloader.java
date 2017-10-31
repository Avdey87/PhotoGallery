package com.aavdeev.photogallery;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ThumbnailDownloader<T> extends HandlerThread {
    private static final String TAG = "ThumbnailDownloader";
    private static final int MESSAGE_DOWNLOAD = 0;

    private Handler mRequestHandler;
    private ConcurrentMap<T, String> mRequestMap = new ConcurrentHashMap<T, String>();
    private Handler mResponseHandler;
    private ThumbnailDownloaderListern<T> mThumbnailDownloaderListern;

    public interface ThumbnailDownloaderListern<T> {
        //вызывается когда изображение было полностью загружено и готово к добавлению
        void onThumbnailDownloader(T target, Bitmap thumbnail);
    }

    public void setmThumbnailDownloaderListern(ThumbnailDownloaderListern<T> listener) {
        mThumbnailDownloaderListern = listener;
    }

    public ThumbnailDownloader(Handler responseHandler) {
        super(TAG);
        mResponseHandler = responseHandler;
    }

    @Override
    protected void onLooperPrepared() {
        mRequestHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == MESSAGE_DOWNLOAD) {
                    T target = (T) msg.obj;
                    Log.i(TAG, "Got a request for URL: " + mRequestMap.get(target));
                    handleRequest(target);
                }
            }
        };
    }

    //Ожидает получение объекта типа Т , выполняющий функции индетификатора
    //загрузки и String URL-адресом для загрузки.
    //Метод будет вызывается GalleryItemAdapter в его реализации onBindViewHolder()
    public void queueThumbnail(T target, String url) {
        Log.i(TAG, "Got a URL: " + url);
//если адресная строка пуста
        if (url == null) {
           //удаляем из mRequestMap
            mRequestMap.remove(target);
        }
        //иначе кладем в таблицу mRequestMap
        //target(индетификатор запроса) и занчение(url)
        else {
            mRequestMap.put(target, url);
            //
            mRequestHandler.obtainMessage(MESSAGE_DOWNLOAD, target).sendToTarget();
        }
    }

    //удаление всех запросов очереди
    public void clearQueue() {
        mResponseHandler.removeMessages(MESSAGE_DOWNLOAD);
    }

    private void handleRequest(final T target) {
        try {
            final String url = mRequestMap.get(target);
            if (url == null) {
                return;
            }
            byte[] bitmapBytes = new FlickrFetchr().getUrlBytes(url);
            final Bitmap bitmap = BitmapFactory.decodeByteArray(bitmapBytes, 0, bitmapBytes.length);
            Log.i(TAG, "Bitmap created ");

            mResponseHandler.post(new Runnable() {
                @Override
                public void run() {
                    if (mRequestMap.get(target) != url) {
                        return;
                    }

                    mRequestMap.remove(target);
                    mThumbnailDownloaderListern.onThumbnailDownloader(target, bitmap);
                }
            });
        } catch (IOException e) {
            Log.e(TAG, "Error downloading image ", e);
        }
    }
}
