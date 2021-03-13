package com.weimont.volleytutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivityDos extends AppCompatActivity {

    TextView vTextview;
    RequestQueue requestQueue;

    private static final String URL3 = "https://my-json-server.typicode.com/typicode/demo/db";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dos);

        requestQueue = Volley.newRequestQueue(this);

        //UI
        initUI();

        //stringRequest();
        //jsonArrayRequest();
        jsonObjectRequest();


    }

    private void initUI() {
        vTextview = findViewById(R.id.textView);
    }





    private void jsonObjectRequest(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                URL3,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        JSONArray jsonArray = null;
                        try {
                            jsonArray = response.getJSONArray("posts");
                            int size = jsonArray.length();

                            for(int i = 0; i < size; i++){
                                JSONObject jsonObject = new JSONObject(jsonArray.get(i).toString());
                                String title = jsonObject.getString("title");

                                vTextview.append("Title: " + title + "\n");



                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }





                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }


        );

        requestQueue.add(jsonObjectRequest);


        }
    }
