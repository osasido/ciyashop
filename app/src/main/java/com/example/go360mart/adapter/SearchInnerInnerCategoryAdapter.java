package com.example.go360mart.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.example.go360mart.R;
import com.example.go360mart.activity.CategoryListActivity;
import com.example.go360mart.customview.textview.TextViewLight;
import com.example.go360mart.interfaces.OnItemClickListner;
import com.example.go360mart.model.Home;
import com.example.go360mart.utils.RequestParamUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bhumi Shah on 11/7/2017.
 */

public class SearchInnerInnerCategoryAdapter extends RecyclerView.Adapter<SearchInnerInnerCategoryAdapter.CategoryViewHolder> {

    private List<Home.AllCategory> list;
    private Activity activity;
    private OnItemClickListner onItemClickListner;
    private Map<Integer, SearchCategoryAdapter.CategoryViewHolder> expandList = new HashMap<>();


    public SearchInnerInnerCategoryAdapter(Activity activity, OnItemClickListner onItemClickListner) {
        this.activity = activity;
        this.onItemClickListner = onItemClickListner;
    }

    public void addAll(List<Home.AllCategory> list) {
        this.list = list;
        for (int i = 0; i < list.size(); i++) {
            expandList.put(i, null);
        }
        notifyDataSetChanged();

    }


    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sinner_earch_catgory, parent, false);

        return new CategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, final int position) {

        holder.tvName.setText(list.get(position).name);

        holder.llMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, CategoryListActivity.class);
                intent.putExtra(RequestParamUtils.CATEGORY, list.get(position).id+"");
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.llMain)
        LinearLayout llMain;

        @BindView(R.id.tvName)
        TextViewLight tvName;

        public CategoryViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}