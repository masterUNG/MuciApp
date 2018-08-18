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
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONObject;

import masterung.androidthai.in.th.muciapp.NotificaionActivity;
import masterung.androidthai.in.th.muciapp.R;
import masterung.androidthai.in.th.muciapp.utility.MyConstant;
import masterung.androidthai.in.th.muciapp.utility.ReadAllData;

public class MainFragment extends Fragment{

    //    Explicit
    private Handler handler = new Handler();
    private boolean resultABoolean = false;
    private  Runnable runnable = new Runnable() {
        @Override
        public void run() {

            checkResult();

            if (resultABoolean) {
                myNotification();
            } else {
                handler.postDelayed(runnable, 1000);
            }



        }
    };

    private void checkResult() {

        try {

            MyConstant myConstant = new MyConstant();
            ReadAllData readAllData = new ReadAllData(getActivity());
            readAllData.execute(myConstant.getUrlTestString());
            String jsonString = readAllData.get();
            Log.d("18AugV1", "JSON ==> " + jsonString);

            JSONArray jsonArray = new JSONArray(jsonString);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String resultString = jsonObject.getString("Result");
            resultABoolean = Boolean.parseBoolean(resultString);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        handler.postDelayed(runnable, 1000);

//        Register Controller
        registerController();


    }   // Main Method

    private void registerController() {
        Button button = getView().findViewById(R.id.btnRegister);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentFragmentMain, new RegisterFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

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
