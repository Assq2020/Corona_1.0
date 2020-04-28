package com.amanaryan.corona

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_contactus.*

class Contactus : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactus)
        about_us_btn.setOnClickListener {
            val intent= Intent(this,Aboutus::class.java)
            startActivity(intent)

        }
        contact_us_button.setOnClickListener {
            val intent=Intent(this,Connectus::class.java)
            startActivity(intent)
            // Toast.makeText(this,"contact us clicked",Toast.LENGTH_SHORT).show()
        }

        feedback_btn.setOnClickListener {
            val intent= Intent(this,Feedback::class.java)
            startActivity(intent)

        }


    }
}
