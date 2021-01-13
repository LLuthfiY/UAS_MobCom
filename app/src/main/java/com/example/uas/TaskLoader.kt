package com.example.uas

import android.content.Context
import android.util.Log
import androidx.loader.content.AsyncTaskLoader
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class TaskLoader(context: Context, url: String) : AsyncTaskLoader<String>(context) {
    val murl = url
    var result = ""
    override fun loadInBackground(): String? {
        val queue = Volley.newRequestQueue(context)
        val stringRequest = StringRequest(
            Request.Method.GET, murl,
            Response.Listener<String> { response ->
                // Display the first 500 characters of the response string.
                Log.i("masuk", "masuk")
                result = response.toString()
            },
            Response.ErrorListener {result = "That didn't work!" })
        queue.add(stringRequest)

        return result;
    }

}