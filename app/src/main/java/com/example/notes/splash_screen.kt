package com.example.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

private lateinit var img:ImageView
private lateinit var txt:TextView


class splash_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        img=findViewById(R.id.img)
        txt=findViewById(R.id.txt)

        img.visibility= View.VISIBLE
        txt.visibility= View.VISIBLE

img.startAnimation(AnimationUtils.loadAnimation(this@splash_screen,android.R.anim.fade_out))
        txt.startAnimation(AnimationUtils.loadAnimation(this@splash_screen,android.R.anim.fade_out))

        Handler().postDelayed(
            {
                startActivity(Intent(this@splash_screen, MainActivity::class.java))
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
                finish()
            },2000
        )

    }
}