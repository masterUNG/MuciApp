package masterung.androidthai.in.th.muciapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import masterung.androidthai.in.th.muciapp.R;
import masterung.androidthai.in.th.muciapp.utility.MyConstant;
import masterung.androidthai.in.th.muciapp.utility.PacketSalseAdapter;
import masterung.androidthai.in.th.muciapp.utility.ReadAllData;

public class PackageSalseFragment extends Fragment{

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Create RecyclerView
        createRecyclerView();


    }   // Main Method

    private void createRecyclerView() {
        RecyclerView recyclerView = getView().findViewById(R.id.recyclerViewPackageSalse);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
//                getActivity(), LinearLayoutManager.HORIZONTAL, false);
//        recyclerView.setLayoutManager(linearLayoutManager);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(
                2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        MyConstant myConstant = new MyConstant();
        String[] columnStrings = myConstant.getColumn_tm_packetpoint();

        ArrayList<String> nameStringArrayList = new ArrayList<>();
        ArrayList<String> priceStringArrayList = new ArrayList<>();
        ArrayList<String> pointStringArrayList = new ArrayList<>();

        try {

            ReadAllData readAllData = new ReadAllData(getActivity());
            readAllData.execute(myConstant.getUrlPackageSalse());
            String jsonString = readAllData.get();
            Log.d("19AugV3", "JSON ==> " + jsonString);

            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i=0; i<jsonArray.length(); i+=1) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                nameStringArrayList.add(jsonObject.getString(columnStrings[1]));
                priceStringArrayList.add(jsonObject.getString(columnStrings[4]));
                pointStringArrayList.add(jsonObject.getString(columnStrings[3]));

            }   // for

            PacketSalseAdapter packetSalseAdapter = new PacketSalseAdapter(getActivity(),
                    nameStringArrayList, priceStringArrayList, pointStringArrayList);
            recyclerView.setAdapter(packetSalseAdapter);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_package_sale, container, false);
        return view;
    }
}
