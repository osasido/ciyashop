package com.example.go360mart.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.example.go360mart.R;
import com.example.go360mart.activity.WebDataActivity;
import com.example.go360mart.customview.textview.TextViewLight;
import com.example.go360mart.interfaces.OnItemClickListner;
import com.example.go360mart.model.Home;
import com.example.go360mart.utils.RequestParamUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by User on 17-11-2017.
 */

public class WebPagesAdapter extends RecyclerView.Adapter<WebPagesAdapter.RecentViewHolder> {

    private List<Home.WebViewPages> list = new ArrayList<>();
    private Activity activity;
    private OnItemClickListner onItemClickListner;
    private int width = 0, height = 0;

    public WebPagesAdapter(Activity activity, OnItemClickListner onItemClickListner) {
        this.activity = activity;
        this.onItemClickListner = onItemClickListner;
    }

    public void addAll(List<Home.WebViewPages> list) {
        this.list = list;
        getWidthAndHeight();
        notifyDataSetChanged();
    }

    @Override
    public WebPagesAdapter.RecentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_info_pages, parent, false);

        return new WebPagesAdapter.RecentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WebPagesAdapter.RecentViewHolder holder, final int position) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.tvInfoPageTitle.setText(Html.fromHtml(list.get(position).webViewPagesPageTitle, Html.FROM_HTML_MODE_COMPACT));
        } else {
            holder.tvInfoPageTitle.setText(Html.fromHtml(list.get(position).webViewPagesPageTitle));
        }

        holder.llMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, WebDataActivity.class);
                intent.putExtra(RequestParamUtils.WebData, list.get(position).webViewPagesPageId);
                intent.putExtra(RequestParamUtils.WebTitle, list.get(position).webViewPagesPageTitle);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void getWidthAndHeight() {
        int height_value = activity.getResources().getInteger(R.integer.height);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        width = displayMetrics.widthPixels / 2 - height_value * 2;
        height = width / 2 + height_value;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class RecentViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.llMain)
        LinearLayout llMain;

        @BindView(R.id.tvInfoPageTitle)
        TextViewLight tvInfoPageTitle;

        public RecentViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
