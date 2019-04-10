package com.onepiece.cailei.navigationbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Navigationbar extends AbsNavigationbar {


    Navigationbar(Builder builder) {
        super(builder);

    }


    public static class Builder extends AbsNavigationbar.Builder {
        public Builder(Context context, int layoutId, ViewGroup parent) {
            super(context, layoutId, parent);
        }

        @Override
        public Navigationbar create() {
            return new Navigationbar(this);
        }
    }
}
