package com.example.krasimir.recipeturnik;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.krasimir.recipeturnik.model.Category;
import com.example.krasimir.recipeturnik.model.CategoryItems;
import com.squareup.picasso.Picasso;

import java.util.List;



public class SelectedCategoryAdapter extends RecyclerView.Adapter<SelectedCategoryAdapter.ViewHolder> {
    private static List<CategoryItems> mDataset;
    private static Context ctx;
    private static IOnItemClicked callback;



    public SelectedCategoryAdapter(List<CategoryItems>data, Context ctx,IOnItemClicked callback){
        this.mDataset=data;
        this.ctx=ctx;
        this.callback=callback;
    }


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public TextView mTextTitleView;
        //public TextView mTextDescrView;
        public TextView mTextSubNameView;
        public ImageView mImageItemView;
        public LinearLayout mLayoutItemRow;


        public ViewHolder(View v) {
            super(v);

            mTextTitleView=(TextView)v.findViewById(R.id.itemNameTextView);
           // mTextDescrView=(TextView)v.findViewById(R.id.itemDescTextView);
            mTextSubNameView=(TextView)v.findViewById(R.id.itemCategoryTextView);
            mImageItemView=(ImageView)v.findViewById(R.id.itemImageView);

            mLayoutItemRow=(LinearLayout)v.findViewById(R.id.itemRowlayout);

            mLayoutItemRow.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (callback!=null){
                callback.onItemClicked(getAdapterPosition());
            }
        }
    }


    // Create new views (invoked by the layout manager)
    @Override
    public SelectedCategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.selected_item_row, parent, false);
        // set the view's size, margins, paddings and layout parameters

        SelectedCategoryAdapter.ViewHolder vh=new SelectedCategoryAdapter.ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextTitleView.setText(mDataset.get(position).getItemTitle());
        holder.mTextSubNameView.setText(mDataset.get(position).getItemCategoryIdent());
        //holder.mTextDescrView.setText(mDataset.get(position).getItemDesc());
        //holder.mImageItemView.setImageResource(R.mipmap.breakfast_img);
        String imageURL=mDataset.get(position).getImageURL();
        Picasso.with(ctx).load(imageURL).into(holder.mImageItemView);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
