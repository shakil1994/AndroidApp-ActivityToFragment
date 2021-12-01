package com.blackbirds.shakil.demoactivitytofragment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blackbirds.shakil.demoactivitytofragment.Common.Common;
import com.blackbirds.shakil.demoactivitytofragment.EventBus.ItemClick;
import com.blackbirds.shakil.demoactivitytofragment.Interface.IRecyclerClickListener;
import com.blackbirds.shakil.demoactivitytofragment.Model.PhotosModel;
import com.blackbirds.shakil.demoactivitytofragment.R;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.MyViewHolder> {

    private Context context;
    private List<PhotosModel> photosModels;

    public ImageListAdapter(Context context, List<PhotosModel> photosModels) {
        this.context = context;
        this.photosModels = photosModels;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        holder.txtTitle.setText(String.valueOf(photosModels.get(position).getTitle()));
        Picasso.get().load(photosModels.get(position).getUrl()).into(holder.imgView);

        holder.setListener((view, pos) -> {
            Common.categorySelected = photosModels.get(pos);
            EventBus.getDefault().postSticky(new ItemClick(true, photosModels.get(pos)));

            Toast.makeText(context, "Position Click: " + pos, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return photosModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtTitle;
        ImageView imgView;

        IRecyclerClickListener listener;

        public void setListener(IRecyclerClickListener listener) {
            this.listener = listener;
        }


        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txtTitle);
            imgView = itemView.findViewById(R.id.imgView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onItemClickListener(v, getAdapterPosition());
        }
    }
}
