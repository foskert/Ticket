package com.tickets.ing_yrj.tickets.Activity;

import android.content.Intent;
import android.os.Bundle;
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

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
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
        final String url = "";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, response);
                        requestQueue.stop();
                        Intent intent=new Intent(MainActivity.this, TicketsActivity.class);
                        if(response.equals("")){
                            intent.putExtra("response", response);
                        }else{
                            try {
                                intent.putExtra("response", getDataTickest());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        startActivity(intent);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "Error conexion URL "+url+" volley: "+error);
                requestQueue.stop();
                Intent intent=new Intent(MainActivity.this, TicketsActivity.class);
                try {
                    intent.putExtra("response", getDataTickest());
                } catch (JSONException e) {
                    Log.d(TAG, "Error data json "+error);
                    e.printStackTrace();
                }
                startActivity(intent);
            }
        });
        requestQueue.add(stringRequest);
    }

    private String getDataTickest() throws JSONException {
        JSONObject json = new JSONObject();
        JSONObject ticketJson = new JSONObject();
        for(int i=0; i<7;i++){
            ticketJson.put("number", "25635475687"+i);
            ticketJson.put("date", "2018/09/01");
            ticketJson.put("urlImg", "https://www.google.co.ve/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwi9-e-K1ZrdAhWBr1kKHcN3AD0QjRx6BAgBEAU&url=https%3A%2F%2Fes.seaicons.com%2F96245%2F&psig=AOvVaw1F_UO79vRtY-3SQz-rh-po&ust=1535920817397301");
            ticketJson.put("point", "5");
            if(i==0 || i==1) {
                ticketJson.put("item1", "Lorem ipsum dolor sit amet consectetur adipiscing elit, non fermentum mattis nulla quisque nisi, vestibulum orci pellentesque id aptent platea.");
                ticketJson.put("item2", "Lorem ipsum dolor sit amet consectetur adipiscing elit, non fermentum mattis nulla quisque nisi, vestibulum orci pellentesque id aptent platea.");
            }else{
                ticketJson.put("item1", "");
                ticketJson.put("item2", "");
            }
            if(i==0) {
                ticketJson.put("item1", "Lorem ipsum dolor sit amet consectetur adipiscing elit, non fermentum mattis nulla quisque nisi, vestibulum orci pellentesque id aptent platea.");
                ticketJson.put("item2", "Lorem ipsum dolor sit amet consectetur adipiscing elit, non fermentum mattis nulla quisque nisi, vestibulum orci pellentesque id aptent platea.");
                ticketJson.put("item3", "Lorem ipsum dolor sit amet consectetur adipiscing elit, non fermentum mattis nulla quisque nisi, vestibulum orci pellentesque id aptent platea.");
                ticketJson.put("item4", "Lorem ipsum dolor sit amet consectetur adipiscing elit, non fermentum mattis nulla quisque nisi, vestibulum orci pellentesque id aptent platea.");
                ticketJson.put("item5", "Lorem ipsum dolor sit amet consectetur adipiscing elit, non fermentum mattis nulla quisque nisi, vestibulum orci pellentesque id aptent platea.");
                ticketJson.put("item6", "Lorem ipsum dolor sit amet consectetur adipiscing elit, non fermentum mattis nulla quisque nisi, vestibulum orci pellentesque id aptent platea.");
                ticketJson.put("item7", "Lorem ipsum dolor sit amet consectetur adipiscing elit, non fermentum mattis nulla quisque nisi, vestibulum orci pellentesque id aptent platea.");
                ticketJson.put("item8", "Lorem ipsum dolor sit amet consectetur adipiscing elit, non fermentum mattis nulla quisque nisi, vestibulum orci pellentesque id aptent platea.");
                ticketJson.put("item9", "Lorem ipsum dolor sit amet consectetur adipiscing elit, non fermentum mattis nulla quisque nisi, vestibulum orci pellentesque id aptent platea.");
                ticketJson.put("item10", "Lorem ipsum dolor sit amet consectetur adipiscing elit, non fermentum mattis nulla quisque nisi, vestibulum orci pellentesque id aptent platea.");
            }else{
                ticketJson.put("item1", "");
                ticketJson.put("item2", "");
                ticketJson.put("item3", "");
                ticketJson.put("item4", "");
                ticketJson.put("item5", "");
                ticketJson.put("item6", "");
                ticketJson.put("item7", "");
                ticketJson.put("item8", "");
                ticketJson.put("item9", "");
                ticketJson.put("item10", "");
            }
            json.put("Tickets",ticketJson);
        }
        return json.toString();
    }
}
