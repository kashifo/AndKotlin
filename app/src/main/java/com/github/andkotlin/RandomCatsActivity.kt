package com.github.andkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_random_cats.*
import kotlin.random.Random
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import java.lang.Exception


class RandomCatsActivity : AppCompatActivity() {

    val TAG = javaClass.simpleName
    val catUrl = "https://aws.random.cat/meow"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_cats)
        Log.e(TAG, "onCreate")
        showRandomCat()

        btnNextCat.setOnClickListener{
            showRandomCat()
        }
    }

    fun showRandomCat(){

        val requestCat = StringRequest(Request.Method.GET, catUrl, Response.Listener { response ->

            try{
                val jsonObject = JSONObject(response)
                val file = jsonObject.getString("file")

                if(!file.isNullOrEmpty()){
                    Glide.with(this).load( file ).placeholder(R.drawable.loading).error(R.drawable.ic_warning).into( imgCat )
                    tvUrl.text = file
                }else{
                    showEmpty()
                }
            }catch (e: Exception){
                e.printStackTrace()
                showEmpty()
            }

        }, Response.ErrorListener { error ->
            Log.e(TAG, "onErrorResponse=${error?.message}")
            showEmpty()
        } )

        Volley.newRequestQueue(this).add(requestCat)

    }

    fun showEmpty(){
        tvUrl.text = "Something Error"
        Glide.with(this).load(R.drawable.ic_warning).into( imgCat )
    }

}
