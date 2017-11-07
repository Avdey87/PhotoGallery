package com.aavdeev.photogallery;


import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

public class PollService2 extends JobService {
    private PollTask mCurrentTask;
    private static final String TAG = "PollService2";
    private static final long POLL_INTERVAL = 1000 * 60;

    public static Intent newIntent(Context context) {
        return new Intent(context, PollService2.class);
    }


    private class PollTask extends AsyncTask<JobParameters, Void, Void> {
        @Override
        protected Void doInBackground(JobParameters... params) {
            JobParameters jobParams = params[0];
            return null;
        }

    }



    @Override
    public boolean onStartJob(JobParameters params) {
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
