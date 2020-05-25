package com.example.my_yolo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Constraints
import androidx.core.view.ViewCompat
import com.google.android.material.card.MaterialCardView

class ResultActivity : AppCompatActivity() {

    val arr=arrayOf(arrayOf("Sodium","10mcg","50%"),arrayOf("Protein","20g","90%"),arrayOf("Vitamin","10mg","100%"))
    fun printArray(vararg arrays:Array<String>){
        for(array in arrays)
        {
            for(str in array)
            {
                Log.d("ValCheck",str)
            }
        }
    }
    fun makeCard(vararg arrays:Array<String>)
    {
        val myLayout:ConstraintLayout=findViewById(R.id.result_activity_layout)
        var i=0;
        var id=0;
        for(arr in arrays)
        {
            val cardView=MaterialCardView(this)
            val cl:ConstraintLayout=ConstraintLayout(this)

            cardView.id= ViewCompat.generateViewId()
            val params:ConstraintLayout.LayoutParams=ConstraintLayout.LayoutParams(1000,150)
            params.leftToLeft=ConstraintLayout.LayoutParams.PARENT_ID
            params.rightToRight=ConstraintLayout.LayoutParams.PARENT_ID
            if(i!=0)
            {
                params.topToBottom=id
            }
            params.setMargins(10,10,10,10)
            cardView.layoutParams=params

            val textView1=TextView(this)
            val params1:ConstraintLayout.LayoutParams=ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT,ConstraintLayout.LayoutParams.WRAP_CONTENT)
            params1.leftToLeft=ConstraintLayout.LayoutParams.PARENT_ID
            params1.topToTop=ConstraintLayout.LayoutParams.PARENT_ID
            textView1.text=arr[0]
            textView1.layoutParams=params1
            textView1.setTextSize(24.0F)
            cl.addView(textView1)

            val textView2=TextView(this)
            val params2:ConstraintLayout.LayoutParams=ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT,ConstraintLayout.LayoutParams.WRAP_CONTENT)
            params2.leftToLeft=ConstraintLayout.LayoutParams.PARENT_ID
            params2.bottomToBottom=ConstraintLayout.LayoutParams.PARENT_ID
            textView2.text=arr[1]
            textView2.layoutParams=params2
            textView2.setTextSize(20.0F)
            cl.addView(textView2)

            val textView3=TextView(this)
            val params3:ConstraintLayout.LayoutParams=ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT,ConstraintLayout.LayoutParams.WRAP_CONTENT)
            params3.rightToRight=ConstraintLayout.LayoutParams.PARENT_ID
            params3.topToTop=ConstraintLayout.LayoutParams.PARENT_ID
            params3.bottomToBottom=ConstraintLayout.LayoutParams.PARENT_ID
            textView3.text=arr[2]
            textView3.layoutParams=params3
            textView3.setTextSize(36.0F)
            cl.addView(textView3)

            i=1
            id=cardView.getId()
            cardView.addView(cl)
            myLayout.addView(cardView)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        makeCard(*arr)
        printArray(*arr)
    }
}
