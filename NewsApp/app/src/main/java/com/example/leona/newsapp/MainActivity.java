package com.example.leona.newsapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.example.leona.newsapp.utilities.NetworkUtils;



import java.io.IOException;
import java.net.URL;




public class MainActivity extends AppCompatActivity {

    private ProgressBar progress;
    private TextView textView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.displayJSON);
        progress = (ProgressBar) findViewById(R.id.progress);

    }
        //oncreateoptons and menu inflater allow the searchicon xml to become an object and be displayed
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchicon, menu);
        return true;

    }


    //*****************************************8

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemNumber = item.getItemId();

        if (itemNumber == R.id.action_search) {
           URL url = NetworkUtils.makeUrl();
            new NewsRequests().execute(url);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public class NewsRequests extends AsyncTask<URL, Void, String> {



        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textView.setText("");
            progress.setVisibility(View.VISIBLE);

        }
        @Override
        protected String doInBackground(URL... params){

            URL url = params[0];
            String result = null;

            try{
                result = NetworkUtils.getResponseFromHttpUrl(url);

            } catch (IOException e){
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progress.setVisibility(View.INVISIBLE);
            textView.setText(s);
        }
    }


}
