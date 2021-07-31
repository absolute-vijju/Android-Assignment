package com.example.swipe_delete;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MYCLASS> {

    Context context;
    List<GetterSetter> al;

    public MyAdapter(Context context, List<GetterSetter> al) {
        this.context = context;
        this.al = al;
    }

    @NonNull
    @Override
    public MYCLASS onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.rowfile, parent, false);
        return new MYCLASS(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MYCLASS holder, int position) {
        holder.tvid.setText("Id: " + al.get(position).getId());
        holder.tvname.setText("Name: " + al.get(position).getName());
        holder.tvdes.setText("Description: " + al.get(position).getDescription());
        holder.tvprice.setText("Price: " + al.get(position).getPrice());
        Picasso.with(context).load(al.get(position).getThumbnail()).into(holder.imview);
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class MYCLASS extends RecyclerView.ViewHolder {

        ImageView imview;
        TextView tvid, tvname, tvdes, tvprice;

        public MYCLASS(@NonNull View itemView) {
            super(itemView);

            imview = itemView.findViewById(R.id.imview);
            tvid = itemView.findViewById(R.id.tvid);
            tvname = itemView.findViewById(R.id.tvname);
            tvdes = itemView.findViewById(R.id.tvdes);
            tvprice = itemView.findViewById(R.id.tvprice);
        }
    }
}
