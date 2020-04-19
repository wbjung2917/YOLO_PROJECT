package com.example.my_yolo

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.hardware.Camera
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_camera.*
import kotlinx.android.synthetic.main.activity_camera.view.*
import java.io.IOException
import java.lang.Exception


/*
class CameraPreview(context:Context,private var mCamera:Camera):SurfaceView(context),SurfaceHolder.Callback{
    private val mHolder: SurfaceHolder=this.holder.apply{
        addCallback(this@CameraPreview)
        setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS)
    }
    override fun surfaceCreated(holder: SurfaceHolder){
        mCamera.apply{
            try{
                setDisplayOrientation(90)
                setPreviewDisplay(holder)
                startPreview()
            } catch(e: IOException){
                Toast.makeText(context,"$e",Toast.LENGTH_LONG).show()
                Log.d("Error","Error setting camera preview: ${e.message}")
            }
        }
    }
    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        if(mHolder.surface==null)
            return

        try{
            mCamera.stopPreview()
        } catch(e: Exception){

        }

        mCamera.apply{
            try{
                setPreviewDisplay(mHolder)
                startPreview()
            } catch(e: Exception)
            {
                Log.d("Error","Error starting camera preview: ${e.message}")
            }
        }
    }

    override fun surfaceDestroyed(p0: SurfaceHolder) {}
}
*/
class CameraActivity : AppCompatActivity() {
    val PERMISSONS_REQUEST_CODE=100;
    var REQUIRE_PERMISSIONS=arrayOf(Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE)
    //private lateinit var mCamera:Camera;
    //private lateinit var cameraPreview:CameraPreview;

    private fun setupCamera()
    {
        /*
        if(mCamera==null){
            mCamera=Camera.open()
        }
        cameraPreview=CameraPreview(this, mCamera!!)
        cameraFrame.addView(cameraPreview)
         */
        Toast.makeText(this,"카메라 실행 함수입니다.",Toast.LENGTH_LONG).show()
    }

    private fun permissionCheck(){
        var cameraPermission : Int=ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
        var writeExternalStragePermission : Int=ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)

        if(cameraPermission==PackageManager.PERMISSION_GRANTED && writeExternalStragePermission==PackageManager.PERMISSION_GRANTED){
            setupCamera()
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
        if(requestCode==PERMISSONS_REQUEST_CODE && grantResults[0]==PackageManager.PERMISSION_GRANTED&&grantResults[1]==PackageManager.PERMISSION_GRANTED)
        {
            setupCamera()
        }
        else
        {
            Toast.makeText(this,"permissions are not granted",Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        permissionCheck()
        setContentView(R.layout.activity_camera)

        to_result.setOnClickListener{ // 클릭 이벤트 리스너
            var intent= Intent(this,ResultActivity::class.java) // 인텐객체 생성
            startActivity(intent) // 인텐트 전송
            finish() // 현재 액티비티 종료
        }
    }
}
