package com.example.gmodapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    private List<Results> results;
    private Context mContext;

    public RecyclerViewAdapter(Context mContext, List<Results> results) {
        this.mContext = mContext;
        this.results = results;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "ONBINDVIEWHOLDER: CALLD");

        Glide.with(mContext)
                .asBitmap()
                .load(results.get(position).getImage_url())
                .into(holder.image);

        holder.imageName.setText(results.get(position).getTitle());
        holder.score.setText(String.valueOf(results.get(position).getScore()));
        holder.parentLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, InformationActivity.class);

                Bundle b = new Bundle();
                intent.putExtra("showInfo", (Serializable) results.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    // holds views in memory then adds
    public class ViewHolder extends RecyclerView.ViewHolder{
        private CircleImageView image;
        private TextView imageName;
        private TextView score;
        private RelativeLayout parentLayout;

        public ViewHolder(View itemView){
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            score = itemView.findViewById(R.id.score);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }

    }
}
