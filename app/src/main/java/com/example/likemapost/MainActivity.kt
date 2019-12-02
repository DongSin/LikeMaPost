package com.example.likemapost

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.prefs.AbstractPreferences

class MainActivity : AppCompatActivity() {

    var like: Int = 0
    var dislike: Int = 0
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("MainActivity","onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //getPreference
        sharedPreferences = this.getPreferences(Context.MODE_PRIVATE)


        imageViewLike.setOnClickListener{
            likeClicked()
        }

        imageViewDislike.setOnClickListener {
            dislikeClicked()
        }
    }

    private fun dislikeClicked() {

        dislike++
        textViewDislike.text = dislike.toString()
    }

    private fun likeClicked() {
        like++
        textViewLike.text = like.toString()
    }

    override fun onStart() {
        Log.d("MainActivity","onStart")

        super.onStart()
    }

    override fun onResume() {
        Log.d("MainActivity","onResume")

        like = sharedPreferences.getInt(getString(R.string.like),0)
        dislike = sharedPreferences.getInt(getString(R.string.dislike),0)
        textViewLike.text = like.toString()
        textViewDislike.text = dislike.toString()

        super.onResume()
    }

    override fun onPause() {
        Log.d("MainActivity","onPause")

        like = textViewLike.text.toString().toInt()
        dislike = textViewDislike.text.toString().toInt()

        with(sharedPreferences.edit()){
            putInt(getString(R.string.like),like)
            putInt(getString(R.string.dislike),dislike)
            commit()
        }
        super.onPause()

    }

    override fun onStop() {
        Log.d("MainActivity","onStop")

        super.onStop()
    }

    override fun onDestroy() {
        Log.d("MainActivity","onDestroy")

        super.onDestroy()
    }
}
