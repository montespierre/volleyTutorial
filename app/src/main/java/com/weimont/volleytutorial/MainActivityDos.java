package com.weimont.volleytutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivityDos extends AppCompatActivity {

    TextView vTextview;
    RequestQueue requestQueue;
    private static final String URL1 = "https://my-json-server.typicode.com/typicode/demo/comments";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dos);

        requestQueue = Volley.newRequestQueue(this);

        //UI
        initUI();

        stringRequest();


    }

    private void initUI() {
        vTextview = findViewById(R.id.textView);
    }

    private void stringRequest(){
        StringRequest request = new StringRequest(
                Request.Method.GET,
                URL1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        vTextview.setText(response);

                    }
                },
                new Response.ErrorListener(){

                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }


        );
        requestQueue.add(request);
    }
}