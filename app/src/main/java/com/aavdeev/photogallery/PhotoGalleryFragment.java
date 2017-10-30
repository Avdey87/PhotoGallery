package com.aavdeev.photogallery;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.AsyncLayoutInflater;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PhotoGalleryFragment extends Fragment {
    private RecyclerView mPhotoRecyclerView;
    private static final String TAG = "PhotoGalleryFragment";
    private List<GalleryItem> mItems = new ArrayList<>();

    public static PhotoGalleryFragment newInstance() {
        return new PhotoGalleryFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //удержание фрагмента чтобы поворот не приводил к многократному созданию новых объектов AsyncTask
        setRetainInstance(true);
        new FetchItemsTask().execute();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_photo_gallery, container, false);

        mPhotoRecyclerView = (RecyclerView) v
                .findViewById(R.id.fragment_photo_gallery_recycle_view);
        mPhotoRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        setupAdapter();
        return v;
    }

    //метод проверяет состояние списка объектов GalleryItem
    private void setupAdapter() {
        //проверка что фрагмент был присоеденен к активности
        if (isAdded()) {
            mPhotoRecyclerView.setAdapter(new PhotoAdapter(mItems));
        }
    }

    //Класс удержатель для просмотра
    private class PhotoHolder extends RecyclerView.ViewHolder {
        private TextView mTitleTextView;

        //Удержатель фото
        public PhotoHolder(View itemView) {
            super(itemView);
            //в переменную записываем текст отображения
            mTitleTextView = (TextView) itemView;
        }

        //мето для сыези картинки с текстом
        public void bindGalleryItem(GalleryItem item) {
            mTitleTextView.setText(item.toString());
        }
    }

    // Класс переходник
    private class PhotoAdapter extends RecyclerView.Adapter<PhotoHolder> {
        private List<GalleryItem> mGalleryItems;

        public PhotoAdapter(List<GalleryItem> galleryItems) {
            mGalleryItems = galleryItems;
        }

        //Создаем тображение удержателя
        @Override
        public PhotoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // в текст вью записываем текущую актиность
            TextView textView = new TextView(getActivity());
            //возращаем фото (ввиде текста)
            return new PhotoHolder(textView);
        }

        //метод связка
        @Override
        public void onBindViewHolder(PhotoHolder photoHolder, int position) {
            //устанавливаем текущую позицию картинки
            GalleryItem galleryItem = mGalleryItems.get(position);
            //связываем фото с позицией
            photoHolder.bindGalleryItem(galleryItem);
        }

        //метод возвращает размер галлери фото
        @Override
        public int getItemCount() {
            return mGalleryItems.size();
        }
    }


    // третий параметр List<GalleryItem>> определяет тип результата AsyncTask он задает тип значений возвращаемого doInBackground(…), а также тип входного параметра onPostExecute(…).
    private class FetchItemsTask extends AsyncTask<Void, Void, List<GalleryItem>> {

        //возвращает список элементов GalleryItem
        //загрузка файлов в фоновм резиме
        @Override
        protected List<GalleryItem> doInBackground(Void... params) {
            return new FlickrFetchr().fetchItems();
        }

        //метод обновляет поле mItems и вызвывает setupAdapter() после загрузки фото для обновления источника
        //Этот метод получает список, загруженный в doInBackground(…), помещает его в mItems и обновляет адаптер RecyclerView.
        @Override
        protected void onPostExecute(List<GalleryItem> items) {
            mItems = items;
            setupAdapter();
        }
    }

}
