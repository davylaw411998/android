package com.example.minhthongpc.getjson;

import android.content.Intent;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.JsonObjectRequest;
import com.example.minhthongpc.getjson.model.ThongTin;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {
    private ViewPager viewPager;

    private String url;

    private TextView albumView;
    ArrayList<ThongTin>modelthongtin = new ArrayList<>();
    ViewPaperAdapter viewPaperAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        viewPager =findViewById(R.id.viewpager);


        albumView =findViewById(R.id.albumview);

        //Intent intent = getIntent();

        //url=intent.getStringExtra("Url");

        //ReadJSON

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,"http://nopbai.live/data/data.json",null,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        try
                        {
                            String tenalbum = response.getString("name");
                            JSONArray jsonArray =response.getJSONArray("images");
                            for(int i=0;i<jsonArray.length();i++)
                            {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                modelthongtin.add(new ThongTin(jsonObject.getString("name"),
                                        jsonObject.getString("description")));


                            }
                            Toast.makeText(Activity2.this,""+modelthongtin.size(), Toast.LENGTH_SHORT).show();
                            viewPaperAdapter = new ViewPaperAdapter(Activity2.this,modelthongtin);
                            // viewPaperAdapter.notifyDataSetChanged();
                            viewPager.setAdapter(viewPaperAdapter);
                            albumView.setText(tenalbum);



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Activity2.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonObjectRequest);
        viewPaperAdapter = new ViewPaperAdapter(this,modelthongtin);
       // viewPaperAdapter.notifyDataSetChanged();
        viewPager.setAdapter(viewPaperAdapter);

    }

}
