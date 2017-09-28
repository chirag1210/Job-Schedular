package example.android.com.drager2;

/**
 * Created by Chirag Chaudhari on 31,August,2017
 */

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import me.tatarka.support.job.JobParameters;
import me.tatarka.support.job.JobService;

public class TestService extends JobService {

    JobParameters params;
    DoItTask doIt;

    @Override
    public boolean onStartJob(JobParameters params) {
        this.params = params;
        Log.e("onStartJob", "Work to be called from here");
        Toast.makeText(this,"onStartJob ",Toast.LENGTH_LONG).show();


      /*  doIt = new DoItTask();
        doIt.execute();
        return true;
        */
          jobFinished(params,false);
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.e("onStopJob", "System calling to stop the job here");
        Toast.makeText(this,"onStopJob",Toast.LENGTH_LONG).show();
       /* if (doIt != null)
            doIt.cancel(true);*/
        return false;
    }

    private class DoItTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            Log.e("DoItTask", "Working here...");
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            Log.e("DoItTask", "Clean up the task here and call jobFinished...");
            jobFinished(params, false);
            super.onPostExecute(aVoid);
        }


    }

}
