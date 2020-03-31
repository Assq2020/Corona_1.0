package com.amanaryan.corona

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import de.hdodenhof.circleimageview.CircleImageView

class splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val anim :Animation = AnimationUtils.loadAnimation(this,R.anim.clockwise)

        val icon=findViewById<CircleImageView>(R.id.circleImageView) as CircleImageView
        icon.startAnimation(anim)
        Handler().postDelayed({
            startActivity(Intent(this,Language::class.java))

        },3000)
    }
}
