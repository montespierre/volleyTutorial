package com.weimont.volleytutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivityDos extends AppCompatActivity {


    RequestQueue requestQueue;
    ImageView imageView;


    private static final String URL4 = "https://depor.com/resizer/btHIkiAyuYW7tloVn_tbUiiKHJY=/580x330/smart/filters:format(jpeg):quality(75)/arc-anglerfish-arc2-prod-elcomercio.s3.amazonaws.com/public/I7MKT5366JBOPH7TQUB3GBIG6Y.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dos);

        requestQueue = Volley.newRequestQueue(this);

        //UI
        initUI();

        //stringRequest();
        //jsonArrayRequest();
        //jsonObjectRequest();
        imageRequest();


    }

    private void initUI() {
        imageView = findViewById(R.id.imageView);
    }

    private void imageRequest(){
        ImageRequest imageRequest = new ImageRequest(
                URL4,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        imageView.setImageBitmap(response);

                    }
                },
                0,
                0,
                null,
                null,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                    }
                }


        );
        requestQueue.add(imageRequest);
    }






    }
