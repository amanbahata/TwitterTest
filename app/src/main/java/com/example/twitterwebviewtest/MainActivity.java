package com.example.twitterwebviewtest;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private Toolbar toolbar;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        webView = findViewById(R.id.web_view);
        toolbar = findViewById(R.id.action_favorite);
        setSupportActionBar(toolbar);



        String string = "<a class=\"twitter-timeline\"" +
                "href=\"https://twitter.com/brightonhovebus\"" +
                "data-chrome=\"noheader nofooter noborders\">" +
                "</a><script async src=\"https://platform.twitter.com/widgets.js\"" +
                "charset=\"utf-8\"></script>";

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadData(string, "text/html", null);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_refresh) {
            webView.reload();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }}
