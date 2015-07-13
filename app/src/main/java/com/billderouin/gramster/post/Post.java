package com.billderouin.gramster.post;

import android.util.Log;

/**
 * Created by bill on 7/12/15.
 */
public class Post {
    private static final String TAG = Post.class.getSimpleName();

    private static final String HOST = "http://10.121.14.27:3000";

    private String mId;
    private String mTitle;
    private String mAuthor;
    private String mPath;
    private String mDescription;
    private String mPosted;

    public Post(String mId, String mTitle, String mAuthor, String mPath, String mDescription, String mPosted) {
        this.mId = mId;
        this.mTitle = mTitle;
        this.mAuthor = mAuthor;
        this.mPath = mPath.startsWith("http://") ? mPath : HOST + mPath;
        this.mDescription = mDescription;
        this.mPosted = mPosted;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public void setmAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public String getmPath() {
        return mPath;
    }

    public void setmPath(String mPath) {
        this.mPath = mPath;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmPosted() {
        return mPosted;
    }

    public void setmPosted(String mPosted) {
        this.mPosted = mPosted;
    }
}
