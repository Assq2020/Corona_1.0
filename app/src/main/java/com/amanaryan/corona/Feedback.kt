package com.amanaryan.corona

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_feedback.*

class Feedback : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)
        val title=findViewById<EditText>(R.id.head_et_help)
        val feedback=findViewById<EditText>(R.id.feed_desription_feedback)
        submit_btn_feedback.setOnClickListener {
            Toast.makeText(this,"feedback work is not fully devoloped ",Toast.LENGTH_SHORT).show()
        }
    }
}