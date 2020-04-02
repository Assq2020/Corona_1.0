package com.amanaryan.corona

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Aboutus : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aboutus)
        toast()
    }
    fun toast(){

        Toast.makeText(this,"Toast aaya Toast aaya",Toast.LENGTH_LONG).show()

    }
}
