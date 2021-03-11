package toan.bui.assignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static ArrayList<dummyData> dataList = dummyData.dummyDataList;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.per_hour_weather, parent, false);
        RecyclerView.ViewHolder holder = new myViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        dummyData dataInstance = dataList.get(position);

        myViewHolder my_holder = (myViewHolder) holder;
        my_holder.time.setText(String.valueOf(dataInstance.getTime()));
        my_holder.icon.setImageResource(dataInstance.getIcon());
        my_holder.degree.setText(String.valueOf(dataInstance.getDegree()));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    private static class myViewHolder extends RecyclerView.ViewHolder {
        public TextView time;
        public ImageView icon;
        public TextView degree;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            this.time = (TextView) itemView.findViewById(R.id.time);
            this.icon = itemView.findViewById(R.id.icon);
            this.degree = itemView.findViewById(R.id.degree);
        }
    }
}
