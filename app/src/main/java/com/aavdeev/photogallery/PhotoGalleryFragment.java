package com.aavdeev.photogallery;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.support.v7.widget.SearchView;




import java.util.ArrayList;
import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

public class PhotoGalleryFragment extends Fragment {
    private RecyclerView mPhotoRecyclerView;
    private static final String TAG = "PhotoGalleryFragment";
    private List<GalleryItem> mItems = new ArrayList<>();
    private int lastFetchedPage = 1;
    private ThumbnailDownloader<PhotoHolder> mThumbnailDownloader;

    public static PhotoGalleryFragment newInstance() {
        return new PhotoGalleryFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //удержание фрагмента чтобы поворот не приводил к многократному созданию новых объектов AsyncTask
        setRetainInstance(true);
        //устанавливаем окошко меню
        setHasOptionsMenu(true);
        updateItems();
        Handler responseHandler = new Handler();
//Создаем экземпляр ThumbnailDownloader
        mThumbnailDownloader = new ThumbnailDownloader<>(responseHandler);
        mThumbnailDownloader.setmThumbnailDownloaderListern(new ThumbnailDownloader.ThumbnailDownloaderListern<PhotoHolder>() {
            @Override
            public void onThumbnailDownloader(PhotoHolder photoHolder, Bitmap bitmap) {
                Drawable drawable = new BitmapDrawable(getResources(), bitmap);
                photoHolder.bindDrawable(drawable);
            }
        });
        //Запускаем ThumbnailDownloader
        mThumbnailDownloader.start();
        //получаем цыкл
        mThumbnailDownloader.getLooper();
        //выводим сообщение в лог
        Log.i(TAG, "Background thread started ");
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_photo_gallery, container, false);
        final int columns = 3;

        mPhotoRecyclerView = (RecyclerView) v
                .findViewById(R.id.fragment_photo_gallery_recycle_view);
        mPhotoRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), columns));
        mPhotoRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Point size = new Point();
                getActivity().getWindowManager().getDefaultDisplay().getSize(size);
                int newColumns = (int) Math.floor(size.x * 3 / 1440);
                if (newColumns != columns) {
                    GridLayoutManager layoutManager = (GridLayoutManager) mPhotoRecyclerView.getLayoutManager();
                    layoutManager.setSpanCount(newColumns);
                }
            }
        });
        mPhotoRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                PhotoAdapter adapter = (PhotoAdapter) recyclerView.getAdapter();
                int lastPosicion = adapter.getLastBoundPosition();
                GridLayoutManager layoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                int loadBufferPosition = 1;
                if (lastPosicion >= adapter.getItemCount() - layoutManager.getSpanCount() - loadBufferPosition) {
                 //  new FetchItemsTask().execute(lastPosicion + 1);
                }
            }


            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        setupAdapter();
        return v;
    }

    //уничтожение вью
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //уничтожение всех запросов очереди
        mThumbnailDownloader.clearQueue();
    }

    //Удаление потока
    @Override
    public void onDestroy() {
        super.onDestroy();
        //команда прекращения потока
        mThumbnailDownloader.quit();
        //пишем в лог, поток уничтожен
        Log.i(TAG, "Background thread destroyed");
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.fragment_photo_gallery, menu);

        //получаем поле MenuItem представляющее поле поиска
        MenuItem searchItem = menu.findItem(R.id.menu_item_search);
        //searchView извлекаем объект SearchView методом getActionView
        final SearchView searchView = (SearchView) searchItem.getActionView();
        //устанавливаем слушетеля на searchView
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            //Отправка запроса от пользователя
            @Override
            public boolean onQueryTextSubmit(String s) {
                Log.d(TAG, "QueryTextSubmit: " + s);
                QueryPreferences.setStrongedQuery(getActivity(), s);
                updateItems();
                return true;
            }

            //выполняется прикаждом изменении текста в текстовом поле
            @Override
            public boolean onQueryTextChange(String s) {
                Log.d(TAG, "QueryTextChange: " + s);
                return false;
            }
        });
    }

   //метод обработки нажатия на меню
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //если нажато очитсть
            case R.id.menu_item_clear:
                //QueryPreferences присваеваем null
                QueryPreferences.setStrongedQuery(getContext(), null);
                updateItems();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateItems() {
        String query = QueryPreferences.getStoredQuery(getActivity());
        new FetchItemsTask(query).execute();
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
        private ImageView mItemImageView;

        //Удержатель фото
        public PhotoHolder(View itemView) {
            super(itemView);
            //в переменную записываем текст отображения
            mItemImageView = (ImageView) itemView.findViewById(R.id.fragment_photo_hallery_image_view);

        }

        public void bindGalleryItem(GalleryItem galleryItem) {
            Picasso.with(getActivity())
                    .load(galleryItem.getmUrl())
                    .placeholder(R.drawable.bill_up_close)
                    .into(mItemImageView);
        }

        public void bindDrawable(Drawable drawable) {
            mItemImageView.setImageDrawable(drawable);
        }
    }

    // Класс переходник
    private class PhotoAdapter extends RecyclerView.Adapter<PhotoHolder> {
        private List<GalleryItem> mGalleryItems;
        private int lastBoundPosition;

        public int getLastBoundPosition() {
            return lastBoundPosition;
        }

        public PhotoAdapter(List<GalleryItem> galleryItems) {
            mGalleryItems = galleryItems;
        }

        //Создаем тображение удержателя
        @Override
        public PhotoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.gallery_item, parent,
                    false);
            return new PhotoHolder(view);
        }

        //метод связка
        @Override
        public void onBindViewHolder(PhotoHolder photoHolder, int position) {
            //устанавливаем текущую позицию картинки
            GalleryItem galleryItem = mGalleryItems.get(position);
            photoHolder.bindGalleryItem(galleryItem);

            //связываем фото с позицией
         /*   Drawable planceholder = getResources().getDrawable(R.drawable.bill_up_close);
            photoHolder.bindDrawable(planceholder);
            mThumbnailDownloader.queueThumbnail(photoHolder, galleryItem.getmUrl());
            lastBoundPosition = position;
            Log.i(TAG, "Last bound position is " + Integer.toString(lastBoundPosition));*/

        }

        //метод возвращает размер галлери фото
        @Override
        public int getItemCount() {
            return mGalleryItems.size();
        }
    }


    // третий параметр List<GalleryItem>> определяет тип результата AsyncTask он задает тип значений возвращаемого doInBackground(…), а также тип входного параметра onPostExecute(…).
    private class FetchItemsTask extends AsyncTask<Void, Void, List<GalleryItem>> {
        private String mQuery;

        public FetchItemsTask(String query) {
            mQuery = query;
        }
        //возвращает список элементов GalleryItem
        //загрузка файлов в фоновм резиме
        @Override
        protected List<GalleryItem> doInBackground(Void... params) {
                      //если писковый запрс равен null
            if (mQuery== null) {
                //выводим последнии фото
                return new FlickrFetchr().fetchRecentPhotos();
            } else {
                //получаем результат поиска
                return new FlickrFetchr().searchPhotos(mQuery);
            }
        }

        //метод обновляет поле mItems и вызвывает setupAdapter() после загрузки фото для обновления источника
        //Этот метод получает список, загруженный в doInBackground(…), помещает его в mItems и обновляет адаптер RecyclerView.
        @Override
        protected void onPostExecute(List<GalleryItem> items) {
            if (lastFetchedPage > 1) {
                mItems.addAll(items);
                mPhotoRecyclerView.getAdapter().notifyDataSetChanged();
            } else {
                mItems = items;
                setupAdapter();
            }
            lastFetchedPage++;
        }


        public void execute(int i) {
        }
    }


}
