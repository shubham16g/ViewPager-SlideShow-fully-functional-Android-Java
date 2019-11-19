package com.shubhamindia.pageviewerslideshow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.viewpager.widget.PagerAdapter;

public class SwiperAdapter extends PagerAdapter {

    private Context context;
    private int [] images = {R.drawable.q,R.drawable.w,R.drawable.e,R.drawable.r,R.drawable.t,R.drawable.y,R.drawable.u};

    SwiperAdapter(Context context) {
        this.context = context;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(images[position]);
        container.addView(imageView);
        getItemPosition(imageView);
        return imageView;
    }

    @Override
    public int getCount() {
        return images.length;
    }
    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
