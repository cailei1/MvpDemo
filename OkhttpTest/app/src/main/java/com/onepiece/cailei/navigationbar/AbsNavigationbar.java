package com.onepiece.cailei.navigationbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class AbsNavigationbar {
    private AbsNavigationbar.Builder builder;

    AbsNavigationbar(AbsNavigationbar.Builder builder){
        this.builder=builder;
        createNavigation();
    }

    public void createNavigation(){
        View navigationView = LayoutInflater.from(builder.context).inflate(builder.layoutId,
                builder.parent, false);

        builder.parent.addView(navigationView, 0);
    }

    //builder
    public static abstract class Builder {
        Context context;
        int layoutId;
        ViewGroup parent;

        public Builder(Context context, int layoutId, ViewGroup parent) {
            this.context = context;
            this.layoutId = layoutId;
            this.parent = parent;
        }

        protected abstract AbsNavigationbar create();
    }
}
