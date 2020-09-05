package com.example.cobamateri;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdaptor extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdaptor (Context context){
        this.context = context;
    }

    public int[] slide_images = {
            R.drawable.ikon_makan,
            R.drawable.ikon_tidur,
            R.drawable.ikon_koding,
            0
    };

    public String[] slide_descs = {
            "Makanan",
            "Tidur",
            "Koding",
            "kosong"
    };

    @Override
    public int getCount() {
        return slide_descs.length;

    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        //mendeklarasikan gambar dan teks
        ImageView SliderImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView SliderDescription = (TextView) view.findViewById(R.id.slide_desc);

        SliderImageView.setImageResource(slide_images[position]);
        SliderDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
