package example.android.com.drager2;

import android.app.Activity;
import android.content.ComponentName;
import android.os.Bundle;
import android.view.View;

import me.tatarka.support.job.JobInfo;
import me.tatarka.support.job.JobScheduler;


public class MainActivity extends Activity {

    private static final int JOB_ID = 0x34;
    JobScheduler jobScheduler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Get an instance of the JobScheduler, this will delegate to the system JobScheduler on api 21+
// and to a custom implementataion on older api levels.
     //    jobScheduler = JobScheduler.getInstance(this);



       findViewById(R.id.startBtn).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               testPeriodic();
           }
       });
    }

    private void testPeriodic() {

        ComponentName componentName = new ComponentName(getApplicationContext(), TestService.class);
        JobInfo jobInfo = new JobInfo.Builder(JOB_ID, componentName)
                .setPeriodic(60000)
                .setPersisted(true)
                .build();

        JobScheduler jobScheduler = JobScheduler.getInstance(MainActivity.this);
        jobScheduler.schedule(jobInfo);

    }


}

