package com.shubhamindia.pageviewerslideshow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private ViewPager slideShow;
    private Handler handler = new Handler();
    private RadioGroup slide_int_group;
    private RadioButton slide_int_1,slide_int_2,slide_int_3,slide_int_4,slide_int_5,slide_int_6,slide_int_7;
    private int counter = 0;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            counter++;
            if (counter == 7) {
                counter = 0;
            }
            switchSlideInt();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupSlideShow();

        slideShow.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
            @Override
            public void onPageSelected(int position) {
                counter = position;
                switchSlideInt();
            }
            @Override
            public void onPageScrollStateChanged(int state) {}
        });

        slide_int_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.slide_int_1:
                        handler.removeCallbacks(runnable);
                        counter = 0;
                        break;
                    case R.id.slide_int_2:
                        handler.removeCallbacks(runnable);
                        counter = 1;
                        break;
                    case R.id.slide_int_3:
                        handler.removeCallbacks(runnable);
                        counter = 2;
                        break;
                    case R.id.slide_int_4:
                        handler.removeCallbacks(runnable);
                        counter = 3;
                        break;
                    case R.id.slide_int_5:
                        handler.removeCallbacks(runnable);
                        counter = 4;
                        break;
                    case R.id.slide_int_6:
                        handler.removeCallbacks(runnable);
                        counter = 5;
                        break;
                    case R.id.slide_int_7:
                        handler.removeCallbacks(runnable);
                        counter = 6;
                        break;
                }
                handler.postDelayed(runnable,4000);
                slideShow.setCurrentItem(counter,true);
            }
        });
    }

    private void setupSlideShow() {
        slide_int_group = findViewById(R.id.slide_int_group);
        slide_int_1 = findViewById(R.id.slide_int_1);
        slide_int_2 = findViewById(R.id.slide_int_2);
        slide_int_3 = findViewById(R.id.slide_int_3);
        slide_int_4 = findViewById(R.id.slide_int_4);
        slide_int_5 = findViewById(R.id.slide_int_5);
        slide_int_6 = findViewById(R.id.slide_int_6);
        slide_int_7 = findViewById(R.id.slide_int_7);
        slideShow = findViewById(R.id.slide_show);
        SwiperAdapter adapter = new SwiperAdapter(MainActivity.this);
        slideShow.setAdapter(adapter);
    }

    private void switchSlideInt() {
        switch (counter) {
            case 0:
                slide_int_1.setChecked(true);
                break;
            case 1:
                slide_int_2.setChecked(true);
                break;
            case 2:
                slide_int_3.setChecked(true);
                break;
            case 3:
                slide_int_4.setChecked(true);
                break;
            case 4:
                slide_int_5.setChecked(true);
                break;
            case 5:
                slide_int_6.setChecked(true);
                break;
            case 6:
                slide_int_7.setChecked(true);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable,4000);

    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }
}
