package masterung.androidthai.in.th.muciapp.utility;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import masterung.androidthai.in.th.muciapp.R;

public class PacketSalseAdapter extends RecyclerView.Adapter<PacketSalseAdapter.PacketViewHolder>{

    private Context context;
    private ArrayList<String> namePacketStringArrayList,
            priceStringArrayList, pointStringArrayList;
    private LayoutInflater layoutInflater;

    public PacketSalseAdapter(Context context,
                              ArrayList<String> namePacketStringArrayList,
                              ArrayList<String> priceStringArrayList,
                              ArrayList<String> pointStringArrayList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.namePacketStringArrayList = namePacketStringArrayList;
        this.priceStringArrayList = priceStringArrayList;
        this.pointStringArrayList = pointStringArrayList;
    }

    @NonNull
    @Override
    public PacketViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = layoutInflater.inflate(R.layout.recyclerview_package_salse, viewGroup, false);
        PacketViewHolder packetViewHolder = new PacketViewHolder(view);

        return packetViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PacketViewHolder packetViewHolder, int i) {

        String nameString = namePacketStringArrayList.get(i);
        String priceString = priceStringArrayList.get(i);
        String pointString = pointStringArrayList.get(i);

        packetViewHolder.nameTextView.setText(nameString);
        packetViewHolder.priceTextView.setText(priceString + " Bath.");
        packetViewHolder.pointTextView.setText("Point " + pointString + " Point");
    }

    @Override
    public int getItemCount() {
        return namePacketStringArrayList.size();
    }

    public class PacketViewHolder extends RecyclerView.ViewHolder{

        private TextView nameTextView, priceTextView, pointTextView;

        public PacketViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.txtNamePacket);
            priceTextView = itemView.findViewById(R.id.txtPrice);
            pointTextView = itemView.findViewById(R.id.txtPoint);

        }
    }   // Packet Class



}   // Main Class
