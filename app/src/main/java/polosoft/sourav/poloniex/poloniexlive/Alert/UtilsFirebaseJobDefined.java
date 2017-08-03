package polosoft.sourav.poloniex.poloniexlive.Alert;

import android.content.Context;
import android.support.annotation.NonNull;

import com.firebase.jobdispatcher.Constraint;
import com.firebase.jobdispatcher.Driver;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Lifetime;
import com.firebase.jobdispatcher.RetryStrategy;
import com.firebase.jobdispatcher.Trigger;

/**
 * Created by Sourav on 24-06-2017.
 */

public class UtilsFirebaseJobDefined {
    private static boolean sInitialized;
   private static FirebaseJobDispatcher dispatcher;

    synchronized public static void scheduleChargingReminder(@NonNull final Context context) {

        // if already running then return


        Driver driver = new GooglePlayDriver(context);
        dispatcher = new FirebaseJobDispatcher(driver);

        /* Create the Job to periodically create reminders to drink water */
        Job constraintReminderJob = dispatcher.newJobBuilder()
                /* The Service that will be used to write to preferences */
                .setService(Utils_JobService.class)
                .setTag("job")
                .setLifetime(Lifetime.FOREVER)

                .setRecurring(true)
                .setTrigger(Trigger.executionWindow(0,40))
               .setReplaceCurrent(true)
                .setRetryStrategy(RetryStrategy.DEFAULT_EXPONENTIAL)

                .setConstraints(Constraint.ON_ANY_NETWORK
                        // only run on an unmetered network
                        //   Constraint.ON_UNMETERED_NETWORK
                        // only run when the device is charging

                )
                /* Once the Job is ready, call the builder's build method to return the Job */
                .build();

        /* Schedule the Job with the dispatcher */
        dispatcher.mustSchedule(constraintReminderJob);

        /* The job has been initialized */
        sInitialized = true;
    }

    public static void toCancelThisJob() {
       if(dispatcher !=null){
        dispatcher.cancelAll();
    }}




}