package com.billderouin.gramster.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.billderouin.gramster.R;
import com.billderouin.gramster.post.Post;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by bill on 7/12/15.
 */
public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.ViewHolder> {
    private static final String TAG = PostListAdapter.class.getSimpleName();

    private Context mContext;

    private ArrayList<Post> mPosts;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTitle;
        public ImageView mImage;
        public TextView mAuthor;
        public TextView mPosted;
        public TextView mDescription;

        public ViewHolder(View itemView) {
            super(itemView);

            mTitle = (TextView)itemView.findViewById(R.id.post_title);
            mImage = (ImageView)itemView.findViewById(R.id.post_image);
            mAuthor = (TextView)itemView.findViewById(R.id.post_author);
            mPosted = (TextView)itemView.findViewById(R.id.post_posted);
            mDescription = (TextView)itemView.findViewById(R.id.post_description);
        }
    }

    public PostListAdapter(Context context, ArrayList<Post> posts) {
        super();

        mContext = context;
        mPosts = posts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.view_post, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Post p = mPosts.get(i);
        viewHolder.mTitle.setText(p.getmTitle());
        viewHolder.mAuthor.setText(p.getmAuthor());
        viewHolder.mPosted.setText(p.getmPosted());
        viewHolder.mDescription.setText(p.getmDescription());

        Picasso.with(mContext).load(p.getmPath()).into(viewHolder.mImage);
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }
}
