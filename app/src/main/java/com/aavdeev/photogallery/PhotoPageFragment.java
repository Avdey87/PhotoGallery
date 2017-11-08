package com.aavdeev.photogallery;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PhotoPageFragment extends VisibleFragment {
    private static final String ARG_URI = "photo_page_url";

    private Uri mUri;
    private WebView mWebView;

    public static PhotoPageFragment newInstance(Uri uri) {
        Bundle args = new Bundle();
        args.putParcelable(ARG_URI, uri);
        PhotoPageFragment fragment = new PhotoPageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUri = getArguments().getParcelable(ARG_URI);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_photo_gallery, container, false);
        mWebView = (WebView) v.findViewById(R.id.fragment_photo_page_web_view);
        //включаем JavaScript
        mWebView.getSettings().setJavaScriptEnabled(true);
        //устанавливаем WebViewClient
        mWebView.setWebViewClient(new WebViewClient(){
            //указываем что должно происходить призагрузке URL
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //false ставаится для загрузки данных с URL
                return false;
            }
        });
        return v;
    }
}
