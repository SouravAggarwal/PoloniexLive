package polosoft.sourav.poloniex.poloniexlive.Alert;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.NotificationCompat;

import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Sourav on 02-07-2017.
 */

public class Utils_JobService extends JobService {
    private AsyncTask mBackgroundTask;

    @Override
    public boolean onStartJob(final JobParameters job) {
        mBackgroundTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                try {

                    String jsondata = Utils_url.getAlerHttpResponse();
                    List<UtilsListObj> alertData = Utils_Jsonparsing.getAlerSimpleData(getApplicationContext(), jsondata);


                    return alertData;

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                List<UtilsListObj> alertData = (List<UtilsListObj>) o;
                mathcing(alertData);
                jobFinished(job, false);
            }
        };
        mBackgroundTask.execute();
        return true;

    }

    @Override
    public boolean onStopJob(JobParameters job) {
        if (mBackgroundTask != null) mBackgroundTask.cancel(true);
        return true;
    }

    //p-----------------------Working.......
    public void openurl() throws Exception {
        String jsondata = Utils_url.getAlerHttpResponse();
        List<UtilsListObj> alertData = Utils_Jsonparsing.getAlerSimpleData(this, jsondata);
        //  mathcing(alertData);
    }


    public void mathcing(List<UtilsListObj> alertData) {
        try {
            Alert_main main = new Alert_main();
            List<Alert_UIListObject> dblist = main.displayDatabaseInfo(getApplicationContext());

            for (int i = 0; i < dblist.size(); i++) {
                for (int j = 0; j < alertData.size(); j++) {
                    String dbvar = dblist.get(i).getCoinCode();
                    String datas = alertData.get(j).gethCoin();
                    if (dbvar.equals(datas)) {
                        // Double currentPrice = Double.parseDouble(alertData.get(i).gethJsonLastPrice());
                        DecimalFormat magnitudeFormat = new DecimalFormat("0.00000000");
                        String d = alertData.get(j).gethJsonLastPrice();
                        double dd = Double.parseDouble(d);
                        String current = magnitudeFormat.format(dd);

                        double currentPrice = Double.parseDouble(current);

                        Double dbHigh = Double.parseDouble(dblist.get(i).getPriceHigh());
                        Double dbLow = Double.parseDouble(dblist.get(i).getPriceLow());
                        String desc;
                        String alertTitle = dblist.get(i).getKeyNote();
                        if (currentPrice >= dbHigh) {
                            desc = dblist.get(i).CoinName + ":" + currentPrice;
                            notifyme(getApplicationContext(), alertTitle, desc);
                            playSound();
                            if (currentPrice <= dbLow) {
                                desc = dblist.get(i).CoinName + ":" + currentPrice;
                                notifyme(getApplicationContext(), alertTitle, desc);
                                playSound();
                            }


                        }

                    }


                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void playSound() {
        try {
            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
            Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
            r.play();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void notifyme(Context context, String title, String desc) {


        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(context)

                        .setColor(ContextCompat.getColor(context, polosoft.sourav.poloniex.poloniexlive.R.color.colorPrimary))
                        .setSmallIcon(polosoft.sourav.poloniex.poloniexlive.R.mipmap.ic_launcher55)
                        //  .setLargeIcon(largeIcon(context))
                        .setContentTitle(title)
                        .setContentText(desc)
                        .setDefaults(Notification.PRIORITY_HIGH)
                        .setDefaults(Notification.DEFAULT_VIBRATE)
                        .setContentIntent(contentIntent(context))
                        .setAutoCancel(true);
        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);

        /* WATER_REMINDER_NOTIFICATION_ID allows you to update or cancel the notification later on */
        notificationManager.notify(1, mBuilder.build());
    }

    private static PendingIntent contentIntent(Context context) {
        Intent startActivityIntent = new Intent(context, Alert_main.class);
        return PendingIntent.getActivity(
                context,
                1,
                startActivityIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
    }
}
