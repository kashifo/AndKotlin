package com.github.andkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val TAG = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e(TAG, "onCreate")

        btnRandomCats.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        Log.e(TAG, "onClick-${v?.id}")

        if( v?.id == R.id.btnRandomCats ){
            val intent = Intent(this, RandomCatsActivity::class.java)
            startActivity(intent)
        }

    }

}
