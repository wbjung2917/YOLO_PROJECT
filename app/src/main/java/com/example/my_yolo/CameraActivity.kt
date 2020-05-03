package com.example.my_yolo

import android.content.Context
import android.content.Intent
import android.hardware.Camera
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_camera.*
import java.io.IOException

private var mCamera: Camera = Camera.open();
private lateinit var cameraPreview: CameraPreview;

class CameraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        to_result.setOnClickListener{ // 클릭 이벤트 리스너
            var intent= Intent(this,ResultActivity::class.java) // 인텐객체 생성
            startActivity(intent) // 인텐트 전송
            finish() // 현재 액티비티 종료
        }
        setupCamera();
    }

    private fun setupCamera(){
        if(mCamera==null)
        {
            mCamera=Camera.open();
        }

        cameraPreview=CameraPreview(this,mCamera)
        cameraFrame.addView(cameraPreview)
    }
}

class CameraPreview(context: Context, private val mCamera: Camera) : SurfaceView(context), SurfaceHolder.Callback{
    private val mHolder: SurfaceHolder = this.holder.apply{
        addCallback(this@CameraPreview)
        setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS)
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        mCamera.apply{
            try{
                setDisplayOrientation(90)
                setPreviewDisplay(holder)
                startPreview()
            } catch (e: IOException){
                Toast.makeText(context,"$e",Toast.LENGTH_LONG).show()
                Log.d("Error","Error setting camera preview: ${e.message}")
            }
        }
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, w: Int, h: Int) {
        if(mHolder.surface==null){
            return
        }

        try{
            mCamera.stopPreview()
        } catch (e: Exception){

        }

        mCamera.apply{
            try {
                setPreviewDisplay(mHolder)
                startPreview()
            } catch (e: Exception){
                Log.d("Error","Error starting camera preview: ${e.message}")
            }
        }
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {}
}
