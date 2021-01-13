package com.mrizaf.uas_mobcom

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Get Web Page Source Code"

        val items   = arrayOf("http://", "https://")
        val adapter = ArrayAdapter(this, R.layout.spinner_list, items)
        spinner_uri.adapter = adapter

        button_get.setOnClickListener {
            val url = "${spinner_uri.selectedItem}${input_uri.text}"

            volleyRequestResponse(url)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun volleyRequestResponse(url: String) {
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(Request.Method.GET, url,
            { response ->
                // Display the first 500 characters of the response string.
                text_result.text = response
            },
            { text_result.text = "Something wrong! please retry" })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)
    }
}