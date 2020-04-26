package com.example.my_yolo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_camera.*

class CameraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        to_result.setOnClickListener{ // 클릭 이벤트 리스너
            var intent= Intent(this,ResultActivity::class.java) // 인텐객체 생성
            startActivity(intent) // 인텐트 전송
            finish() // 현재 액티비티 종료
        }
    }
}
