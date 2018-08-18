package masterung.androidthai.in.th.muciapp.fragment;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import masterung.androidthai.in.th.muciapp.NotificaionActivity;
import masterung.androidthai.in.th.muciapp.R;

public class MainFragment extends Fragment{

    //    Explicit
    private Handler handler = new Handler();
    private int timesAnInt = 0;
    private  Runnable runnable = new Runnable() {
        @Override
        public void run() {
            timesAnInt += 1;
            Log.d("18AugV1", "time ==> " + timesAnInt);
            if (timesAnInt == 10) {
                myNotification();
            }

            handler.postDelayed(runnable, 1000);

        }
    };


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        handler.postDelayed(runnable, 1000);

    }   // Main Method

    private void myNotification() {

        Intent intent = new Intent(getActivity(), NotificaionActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                getActivity(),
                (int) System.currentTimeMillis(),
                intent,
                0);

        Uri uri = RingtoneManager.getDefaultUri(Notification.DEFAULT_SOUND);

        Notification notification = new Notification.Builder(getActivity())
                .setContentTitle("This is Title")
                .setContentText("This is Text")
                .setSmallIcon(R.drawable.ic_action_noti)
                .setSound(uri)
                .setContentIntent(pendingIntent).build();

        NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(0, notification);





    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }
}
