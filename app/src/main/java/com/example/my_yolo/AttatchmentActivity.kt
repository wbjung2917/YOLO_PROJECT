package com.example.my_yolo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AttatchmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attatchment)

        val get_intent = Intent(Intent.ACTION_GET_CONTENT)
        get_intent.setType("*/*")
        startActivityForResult(get_intent,10)
    }
}
