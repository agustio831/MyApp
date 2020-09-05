package com.example.cobamateri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;

    private SliderAdaptor sliderAdaptor;

    private Button mNextBtn;
    private Button mBackBtn;

    private int mCurrentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         mSlideViewPager = findViewById(R.id.SlideViewPager);

         mNextBtn = findViewById(R.id.nextBtn);
         mBackBtn = findViewById(R.id.backBtn);

         sliderAdaptor = new SliderAdaptor(this);
         mSlideViewPager.setAdapter(sliderAdaptor);

         mSlideViewPager.addOnPageChangeListener(viewListener);


         mNextBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if (mNextBtn.getText().toString().equals("Contoh")){
                     OpenActivityContoh();
                 }else {
                     mSlideViewPager.setCurrentItem(mCurrentPage + 1);
                 }
             }
         });

         mBackBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 mSlideViewPager.setCurrentItem(mCurrentPage - 1);
             }
         });

    }


    public void OpenActivityContoh() {
        Intent intent = new Intent(this, CobaVideo.class);
        startActivity(intent);
        //finish();
    }

    ViewPager.OnPageChangeListener viewListener = new OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {
            mCurrentPage = i;

            if (i == 0) {

                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(false);
                mBackBtn.setVisibility(View.INVISIBLE);

                mNextBtn.setText("Next");
                mBackBtn.setText("");

            } else if (i == 3) {
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);

                mNextBtn.setText("Contoh");
                mBackBtn.setText("Back");



            } else {
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);

                mNextBtn.setText("Next");
                mBackBtn.setText("Back");
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


}