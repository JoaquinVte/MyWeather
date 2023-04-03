package es.ieslavereda.myweather.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import es.ieslavereda.myweather.Parameters;
import es.ieslavereda.myweather.R;
import es.ieslavereda.myweather.base.ImageDownloader;


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private final List<es.ieslavereda.myweather.activities.List> list;
    private final LayoutInflater inflater;
    private View.OnClickListener onClickListener;
    private Context context;


    public MyRecyclerViewAdapter(Context context, List<es.ieslavereda.myweather.activities.List> list){
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.simple_element,parent,false);
        view.setOnClickListener(onClickListener);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String url = Parameters.ICON_URL_PRE+ list.get(position).weather.get(0).icon + Parameters.ICON_URL_POST;
        ImageDownloader.downloadImage(url,holder.image);
        Date date = new Date((long)list.get(position).dt*1000);
        SimpleDateFormat dateFor = new SimpleDateFormat("E");
        SimpleDateFormat timeFor = new SimpleDateFormat("hh:mm");
        String stringDate= dateFor.format(date);
        String stringTime = timeFor.format(date);
        holder.day.setText(stringDate);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView day;
        TextView time;
        TextView description;
        TextView temp;
        TextView tmax;
        TextView tmin;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            day = itemView.findViewById(R.id.day);
            description = itemView.findViewById(R.id.description);
            time = itemView.findViewById(R.id.time);
            temp = itemView.findViewById(R.id.temp);
            tmax = itemView.findViewById(R.id.tmax);
            tmin = itemView.findViewById(R.id.tmin);
        }

    }

}
