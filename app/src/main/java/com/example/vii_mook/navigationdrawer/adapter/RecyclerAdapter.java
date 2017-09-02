package com.example.vii_mook.navigationdrawer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.vii_mook.navigationdrawer.R;
import com.example.vii_mook.navigationdrawer.model.Landscape;

import java.util.List;

/**
 * Created by vii-mook on 8/31/2017 AD.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<Landscape> mData;
    private LayoutInflater inflater;

    private static final String TAG = RecyclerAdapter.class.getSimpleName();

    public RecyclerAdapter(Context context, List<Landscape> data) {
        inflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_main_list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Landscape current = mData.get(position);
        holder.setData(current, position);
        holder.setListeners();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;
        ImageView imgThumb,imgDelete, imgAdd;
        int position;
        Landscape current;

        public MyViewHolder(View itemview) {
            super(itemview);

            title = (TextView) itemview.findViewById(R.id.tvTitle);
            imgThumb = (ImageView) itemview.findViewById(R.id.img_row);
            imgAdd = (ImageView) itemview.findViewById(R.id.img_row_add);
            imgDelete = (ImageView) itemview.findViewById(R.id.img_row_delete);
        }

        public void setData(Landscape current, int position) {
            this.title.setText(current.getTitle());
            this.imgThumb.setImageResource(current.getImageID());
            this.position = position;
            this.current = current;
        }

        public void setListeners() {
            imgDelete.setOnClickListener(MyViewHolder.this);
            imgAdd.setOnClickListener(MyViewHolder.this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.img_row_delete:
                    removeItem(position);
                    break;
                case R.id.img_row_add:
                    addItem(position, current);
                    break;
            }

        }
    }

    private void addItem(int position, Landscape current) {
        mData.add(position, current);
        notifyItemInserted(position);
        notifyItemRangeChanged(position,mData.size());
    }

    private void removeItem(int position) {
        mData.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,mData.size());
    }
}

