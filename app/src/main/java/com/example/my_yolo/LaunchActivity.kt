package com.example.my_yolo

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_launch.*

class LaunchActivity : AppCompatActivity() {

    val PERMISSONS_REQUEST_CODE=100;
    var REQUIRE_PERMISSIONS=arrayOf(Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE)
    private fun permissionCheck(){
        var cameraPermission : Int= ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
        var writeExternalStragePermission : Int= ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)

        if(cameraPermission== PackageManager.PERMISSION_GRANTED && writeExternalStragePermission== PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this,"permissions granted", Toast.LENGTH_LONG).show()
        }
        else
        {
            ActivityCompat.requestPermissions(this,REQUIRE_PERMISSIONS,PERMISSONS_REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==PERMISSONS_REQUEST_CODE && grantResults[0]== PackageManager.PERMISSION_GRANTED&&grantResults[1]== PackageManager.PERMISSION_GRANTED)
        {
            Toast.makeText(this,"permissions granted", Toast.LENGTH_LONG).show()
        }
        else
        {
            Toast.makeText(this,"permissions are not granted", Toast.LENGTH_LONG).show()
        }
    }

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
