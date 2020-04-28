package com.amanaryan.corona

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.net.Uri.*
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amanaryan.corona.login.number
import kotlinx.android.synthetic.main.activity_emergency_section.*
import kotlinx.android.synthetic.main.emergency_row.view.*
import java.net.URLEncoder


class EmergencySection : AppCompatActivity() {
 var number:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergency_section)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation=LinearLayoutManager.VERTICAL
        recycleview_emergency_section.layoutManager=layoutManager

        val adapter=HobbiesAdapter(this, EmergencyModel.supplier.hobbies)
        recycleview_emergency_section.adapter=adapter

    }



fun makecall(){ val intent = Intent(Intent.ACTION_DIAL, parse("tel:" + encode(number)))
                startActivity(intent)
    }

}

class HobbiesAdapter(val context: Context, val hobbies:List<EmergencyModel.Choice>) : RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewtype: Int): MyViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.emergency_row,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, possition: Int) {
        val hobby=hobbies[possition]
        holder.SetData(hobby,possition)

    }
    companion object{
        val USER_KEY = "USER_KEY"
    }
    inner class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var currentHobby:EmergencyModel.Choice?=null

        var curretPossition:Int=0
        init {
//            itemView.setOnClickListener{
//                val emergency=EmergencySection()
//                number =currentHobby!!.phoneNo
//                Log.d("callint",number)
//                 emergency.makecall()
//
//
//            }
            itemView.row_call.setOnClickListener {
                val emergency=EmergencySection()
                number =currentHobby!!.phoneNo
                Log.d("callint",number)
//    Toast.makeText(context,"button clicked",Toast.LENGTH_SHORT).show()
              val intent = Intent(Intent.ACTION_DIAL, parse("tel:" + encode(number)))
               context.startActivity(intent)
            }

//
        }

        fun SetData(hobby: EmergencyModel.Choice?,poss:Int){

            itemView.state_name.text=hobby!!.title
         //   itemView.state_no_tv.text=hobby!!.phoneNo
            this.currentHobby=hobby
            this.curretPossition=poss

        }

        }

}



