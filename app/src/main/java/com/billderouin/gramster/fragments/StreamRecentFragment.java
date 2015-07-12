package com.billderouin.gramster.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.billderouin.gramster.R;
import com.billderouin.gramster.VolleySingleton;
import com.billderouin.gramster.adapters.PostListAdapter;
import com.billderouin.gramster.post.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by bill on 7/11/15.
 */
public class StreamRecentFragment extends Fragment {
    private static final String TAG = StreamRecentFragment.class.getSimpleName();

    private static final String URL_RECENT = "http://10.121.14.27:3000/api/image/recent/";
    private static final String URL_IMAGE = "http://10.121.14.27:3000/api/image/view/";

    private RecyclerView mRecyclerView;
    private PostListAdapter mAdapter;

    private ArrayList<Post> mPosts;

    // Required default constructor
    public StreamRecentFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Request request = new StringRequest(Request.Method.GET, URL_RECENT, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                loadPosts(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e(TAG, volleyError.toString());
            }
        });
        VolleySingleton.getRequestQueue(getActivity()).add(request);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recent, container, false);

        mPosts = new ArrayList<>();
        mAdapter = new PostListAdapter(getActivity(), mPosts);

        mRecyclerView = (RecyclerView)rootView.findViewById(R.id.recent_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

    private void loadPosts(String json) {
        try {
            JSONArray array = new JSONArray(json);
            for (int i = 0; i < array.length(); i++) {
                JSONObject o = array.getJSONObject(i);
                String imageId = o.getString("id");
                Request request = new StringRequest(Request.Method.GET, URL_IMAGE + imageId, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        loadPost(s);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e(TAG, volleyError.toString());
                    }
                });
                VolleySingleton.getRequestQueue(getActivity()).add(request);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void loadPost(String json) {
        try {
            JSONObject postObject = new JSONObject(json);
            String title = postObject.getString("title");
            String author = postObject.getString("author");
            String path = postObject.getString("path");
            String posted = postObject.getString("posted");
            String description = postObject.getString("description");

            Post newPost = new Post(title, author, path, description, posted);
            mPosts.add(newPost);
            mAdapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
