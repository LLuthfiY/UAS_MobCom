package com.example.uas

import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    var httptype = "HTTP://"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getActionBar()?.setTitle("GET WEB page Source code");
        getSupportActionBar()?.setTitle("GET WEB page Source code");

        supportLoaderManager.initLoader(0, null, this)


        val spinner = findViewById<Spinner>(R.id.httpType)

        val input_text = findViewById<EditText>(R.id.weburl)
        val requestButton = findViewById<Button>(R.id.get_sc)
        val textView = findViewById<TextView>(R.id.sc_result)



        ArrayAdapter.createFromResource(
            this,
            R.array.httptype,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        requestButton.setOnClickListener {
            val queue = Volley.newRequestQueue(this)
            val url = spinner.selectedItem.toString()+ input_text.text.toString()

            val stringRequest = StringRequest(Request.Method.GET, url,
                Response.Listener<String> { response ->
                    // Display the first 500 characters of the response string.
                    Log.i("masuk", "masuk")
                    textView.text = response.toString()
                },
                Response.ErrorListener { textView.text = "That didn't work!" })
            queue.add(stringRequest)
        }
    }


}