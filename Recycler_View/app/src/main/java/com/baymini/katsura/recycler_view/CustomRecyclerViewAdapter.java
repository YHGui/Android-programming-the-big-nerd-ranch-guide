package com.baymini.katsura.recycler_view;

import android.support.v7.widget.RecyclerView;
import android.widget.AdapterView;

/**
 * Created by Katsura on 2016-04-14.
 */
public abstract class CustomRecyclerViewAdapter extends RecyclerView.Adapter {
    private AdapterView.OnItemClickListener onItemClickListener;
    private AdapterView.OnItemLongClickListener onItemLongClickListener;

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
       this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }
}
