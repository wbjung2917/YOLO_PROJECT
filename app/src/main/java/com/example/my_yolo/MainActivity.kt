package com.example.my_yolo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        btn_cam.setOnClickListener{ // 카메라 버튼 리스너
            val intent= Intent(this@MainActivity,CameraActivity::class.java)
            startActivity(intent)
        }
        btn_atc.setOnClickListener{ // 첨부버튼 버튼 리스너
            val intent= Intent(this@MainActivity,AttatchmentActivity::class.java)
            startActivity(intent)
        }
    }
}