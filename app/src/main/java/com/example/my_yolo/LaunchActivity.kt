package com.example.my_yolo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_launch.*

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        btn_main.setOnClickListener{ // 클릭 이벤트 리스너
            var intent= Intent(this,MainActivity::class.java) // 인텐객체 생성
            startActivity(intent) // 인텐트 전송
            finish() // 현재 액티비티 종료
        }
    }
}
