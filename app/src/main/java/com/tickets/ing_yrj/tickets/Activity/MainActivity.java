package com.tickets.ing_yrj.tickets.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.tickets.ing_yrj.tickets.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Serializable {
    private Button main_btn_list_tickets;
    public final String TAG="Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicialice_component();
        inicialice_events();
    }
    private void inicialice_component(){
        main_btn_list_tickets=(Button) findViewById(R.id.main_btn_list_tickets);
    }
    private void inicialice_events(){
        main_btn_list_tickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadTikets();
            }
        });
    }
    private void loadTikets() {
        final RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        final String url = "null";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, response);
                        requestQueue.stop();
                        Intent intent=new Intent(MainActivity.this, TicketsActivity.class);
                        intent.putExtra("response",  getJsonItemTickest().toString());
                        startActivity(intent);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "Error conexion URL "+url+" volley: "+error);
                requestQueue.stop();
                Intent intent=new Intent(MainActivity.this, TicketsActivity.class);
                intent.putExtra("response",  getJsonItemTickest().toString());
                startActivity(intent);
            }
        });
        requestQueue.add(stringRequest);
    }

    private String getJsonItemTickest()  {
            StringBuffer sb = new StringBuffer();
            BufferedReader br = null;
            try{
                br = new BufferedReader(new InputStreamReader(getApplicationContext().getResources().openRawResource(R.raw.item)));
                String line;
                while((line = br.readLine()) != null){
                    sb.append(line);
                }
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                try{
                    br.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return sb.toString();
        }
}
