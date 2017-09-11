package com.example.krasimir.recipeturnik;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.krasimir.recipeturnik.model.Category;

import java.util.List;


public class MenuCategoryAdapter extends RecyclerView.Adapter<MenuCategoryAdapter.ViewHolder> {
    private static List<Category> mDataset;
    private static IOnItemClicked callback;

    public void setCallback(IOnItemClicked callback){
        this.callback=callback;
    }

    public MenuCategoryAdapter(List<Category>data, IOnItemClicked callback){
        this.mDataset=data;
        this.setCallback(callback);
    }


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextTitleView;
        public TextView mTextDescrView;
        public RelativeLayout mLayoutMenuRow;


        public ViewHolder(View v) {
            super(v);

            mTextTitleView=(TextView)v.findViewById(R.id.titleCategoryTextView);
            mTextDescrView=(TextView)v.findViewById(R.id.descCategoryTextView);
            mLayoutMenuRow=(RelativeLayout)v.findViewById(R.id.menuRowlayout);

            mLayoutMenuRow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (callback!=null){
                        callback.onItemClicked(getAdapterPosition());
                    }
                }
            });

        }
    }


    // Create new views (invoked by the layout manager)
    @Override
    public MenuCategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.manu_category_row, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.mTextTitleView.setText(mDataset.get(position).getCategoryName());
        holder.mTextDescrView.setText(mDataset.get(position).getDescCategoryName());
        holder.mLayoutMenuRow.setBackgroundResource(mDataset.get(position).getImage());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
