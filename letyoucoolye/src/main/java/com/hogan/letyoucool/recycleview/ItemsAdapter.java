package com.hogan.letyoucool.recycleview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hogan.letyoucool.R;

import java.util.List;

/**
 * Created by Administrator on 2016/1/26.
 */
public class ItemsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> mData;
    private final LayoutInflater mLayoutInflater;
    private Context mContext;
    private static final int EMPTY_VIEW = 1;
    private static final int VIEW_PROG = 2;

    private int visibleThreshold = 1;
    private int lastVisibleItem, totalItemCount;
    private boolean loading;
    private OnLoadMoreListener onLoadMoreListener;

    public ItemsAdapter(Context context, List<String> data, RecyclerView recyclerView) {
        this.mContext = context;
        this.mData = data;
        this.mLayoutInflater = LayoutInflater.from(mContext);
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    totalItemCount = linearLayoutManager.getItemCount();
                    lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                    if (!loading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                        // End has been reached
                        // Do something
                        if (onLoadMoreListener != null) {
                            onLoadMoreListener.onLoadMore();
                        }
                    }
                }
            });
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==EMPTY_VIEW){
            return new EmptyViewHolder(mLayoutInflater.inflate(R.layout.empty_view, parent, false));
        }else if(viewType==VIEW_PROG){
            return new ProgressViewHolder(mLayoutInflater.inflate(R.layout.progressbar_item, parent, false));
        }else{
            return new ItemHolder(mLayoutInflater.inflate(R.layout.item_list, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemHolder) {
            final String string = mData.get(position);
            ItemHolder itemHolder = (ItemHolder)holder;
            itemHolder.mTextView.setText(string);
        }else if(holder instanceof ProgressViewHolder){
            ((ProgressViewHolder) holder).progressBar.setIndeterminate(true);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size() > 0 ? mData.size() : 1;
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    public void setLoading() {
        loading = true;
    }

    public void setLoaded() {
        loading = false;
    }

    @Override
    public int getItemViewType(int position) {
        if (mData.size() == 0) {
            return EMPTY_VIEW;
        }
        return mData.get(position) != null ? super.getItemViewType(position) : VIEW_PROG;
    }

}
