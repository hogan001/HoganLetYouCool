package com.hogan.letyoucool.recycleview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hogan.letyoucool.R;


/**
 * Created by Administrator on 2016/1/26.
 */
public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView mTextView;
    public ImageView imageView;
    public ItemClickListener mListener;
    public ItemHolder(View itemView,ItemClickListener mListener) {
        super(itemView);
        mTextView = (TextView)itemView.findViewById(R.id.item_tv);
        imageView = (ImageView) itemView.findViewById(R.id.item_imageview);
        this.mListener=mListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
            if(mListener!=null){
                mListener.OnItemClick(v,getAdapterPosition());
            }
    }

}
