package com.example.my_yolo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val go_intent=findViewById(R.id.cameraButton) as Button
        go_intent.setOnClickListener{
            val intent= Intent(this@MainActivity,CameraActivity::class.java)
            startActivity(intent)
        }
    }
}