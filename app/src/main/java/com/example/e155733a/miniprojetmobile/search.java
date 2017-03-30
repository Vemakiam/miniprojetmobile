package com.example.e155733a.miniprojetmobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by E155733A on 30/03/17.
 */
public class search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest =
                new StringRequest(
                        Request.Method.POST,
                        "http://www.perdu.com",
                        new Response.Listener<String>() {
                            public void onResponse(String response) {
                                try {
                                    JSONObject repObj = (JSONObject) new JSONTokener(response).nextValue();
                                    JSONArray ar = repObj.getJSONObject("responseData").getJSONArray("results");
                                    for (int i=0; i<= ar.length();i++) {
                                        JSONObject val = ar.getJSONObject(i);
                                        s += val.getString("title") + val.getString("url") + "\n\n";
                                    }
                                } catch (JSONException je) {
                                    Log.e(TAG, je.getMessage());
                                }


                                TextView visu = (TextView) findViewById(R.id.bonjour);
                                visu.setText(response);
                            }},
                        new Response.ErrorListener() {
                            public void onErrorResponse(VolleyError error) {
                                Log.e("VOLLEY", error.getMessage());
                            }})
                {
                    protected Map<String,String> getParams(){
                        Map<String,String> params = new HashMap<String, String>();
                        params.put("nom", "Lanoix");
                        return params;
                    }
                };
        queue.add(stringRequest);
    }
}
