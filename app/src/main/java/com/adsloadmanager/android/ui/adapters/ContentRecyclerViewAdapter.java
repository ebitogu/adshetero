package com.adsloadmanager.android.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adsloadmanager.android.R;
import com.adsloadmanager.android.models.ContentItem;
import com.adsloadmanager.android.models.ImageViewItem;
import com.adsloadmanager.android.ui.AppAdView;

import java.util.List;

/**
 * @author Wan Clem
 **/
public class ContentRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int CONTENT_TYPE_AD = 0;
    private static final int OTHER_CONTENT = 1;

    private List<ContentItem> contentItemList;
    private LayoutInflater layoutInflater;
    private Context context;

    public ContentRecyclerViewAdapter(Context context, List<ContentItem> contentItemList) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.contentItemList = contentItemList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        RecyclerView.ViewHolder viewHolder;
        if (viewType == CONTENT_TYPE_AD) {
            itemView = layoutInflater.inflate(R.layout.recycler_item_ads_view, parent, false);
            viewHolder = new AdViewContentItemViewHolder(itemView);
        } else {
            itemView = layoutInflater.inflate(R.layout.recycler_item_image_view, parent, false);
            viewHolder = new ContentItemViewHolder(itemView);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ContentItemViewHolder) {
            ContentItemViewHolder contentItemViewHolder = (ContentItemViewHolder) holder;
            ContentItem contentItem = contentItemList.get(position);
            contentItemViewHolder.bindData(contentItem);
        } else if (holder instanceof AdViewContentItemViewHolder) {
            AdViewContentItemViewHolder adViewContentItemViewHolder = (AdViewContentItemViewHolder) holder;
            adViewContentItemViewHolder.loadAd(context);
        }
    }

    @Override
    public int getItemCount() {
        return contentItemList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position % 10 == 0 ? CONTENT_TYPE_AD : OTHER_CONTENT;
    }

    static class AdViewContentItemViewHolder extends RecyclerView.ViewHolder {

        AppAdView appAdView;

        AdViewContentItemViewHolder(@NonNull View itemView) {
            super(itemView);
            appAdView = itemView.findViewById(R.id.ad_view);
        }

        void loadAd(Context context) {
            appAdView.refreshAd(context);
        }

    }

    static class ContentItemViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        ContentItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.content_image_view);
        }

        void bindData(ContentItem contentItem) {
            imageView.setImageResource(((ImageViewItem) contentItem).getResId());
        }

    }

}
