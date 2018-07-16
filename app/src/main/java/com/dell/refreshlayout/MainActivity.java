package com.dell.refreshlayout;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.myswipe);
        final TextView txt = (TextView)findViewById(R.id.mytxt);

        txt.setText("Total Swipe = 0");

        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Color.RED);
        swipeRefreshLayout.setColorSchemeColors(Color.BLUE);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                number++;
                txt.setText("Total Swipe :"+ number);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);

                    }
                }, 3000);

            }
        });
    }
}
