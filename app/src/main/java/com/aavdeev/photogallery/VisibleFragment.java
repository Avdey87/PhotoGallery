package com.aavdeev.photogallery;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.Toast;

public abstract class VisibleFragment extends Fragment {
    private static final String TAG = "VisibleFragment";

    @Override
    public void onStop() {
        super.onStop();
        getActivity().unregisterReceiver(mOnShowNotification);
    }

    @Override
    public void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter(PollService.ACTION_SHOW_NOTIFICATION);

        getActivity().registerReceiver(mOnShowNotification, filter);
    }

    private BroadcastReceiver mOnShowNotification = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(getActivity(), " Got a boardcast: " + intent.getAction(),
                    Toast.LENGTH_LONG)
                    .show();
        }
    };
}
