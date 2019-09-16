package com.github.andkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val tv = findViewById<TextView>(R.id.tvTitle)
        tv.setText("Bismillah")

        val etName = findViewById<EditText>(R.id.editText)
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)

        findViewById<Button>(R.id.btnWelcome).setOnClickListener {
            val name = etName.text.toString()
            tvWelcome.setText(name)
        }

        tvWelcome.setOnClickListener(this)

        val btn2 = findViewById<Button>(R.id.goto2)
        btn2.setOnClickListener(this)


    }

    fun welcome(v: View){
        val tv: TextView = v as TextView
        Toast.makeText(this, tv.text, Toast.LENGTH_SHORT ).show()
    }

    override fun onClick(v: View?) {
        Toast.makeText(this, "onClick", Toast.LENGTH_SHORT ).show()

        if (v != null) {

            if(v.id == R.id.goto2){
                intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("args", "Hi")
                startActivity(intent)
            }

        }

    }
}
