package com.amanaryan.corona

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_resistrationform.*

class Resistrationform : AppCompatActivity() {
     // var pateintOcupation:String?=null
     // var patientState:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resistrationform)
        Log.d("resister","resister work")

        val name=findViewById<EditText>(R.id.fullname_et_resistration)
        val email=findViewById<EditText>(R.id.email_et_resistration)
        val city=findViewById<EditText>(R.id.city_adres_et_resister)
        val healthHistoryRes=findViewById<EditText>(R.id.health_history_res)
        val stateSpin = findViewById<Spinner>(R.id.state_adres_et_resister)
        val occupation=findViewById<Spinner>(R.id.occupation_resister)

        val states=arrayOf("Select Occupation","Uttar Pradesh","Maharashtra","Bihar","West Bengal","Madhya Pradesh","Tamil Nadu","Rajasthan","Karnataka","Gujarat","Andhra Pradesh","Odisha","Telangana","Jharkhand","Assam","Punjab", "Kerala","Chhattisgarh","Haryana","Uttarakhand","Himachal Pradesh","Tripura","Meghalaya","Manipur","Nagaland","Goa","Arunachal Pradesh","Mizoram","Sikkim","Delhi","Jammu and Kashmir","Puducherry","Chandigarh","Dadra and Nagar Haveli and Daman and Diu","Andaman and Nicobar Islands","Ladakh", "Lakshadweep")

        val statesarrAdp= ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,states)
        stateSpin.adapter=statesarrAdp
        stateSpin.onItemSelectedListener=object :


                AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
              // patientState=states[p2]
                Toast.makeText(this@Resistrationform,states[p2],Toast.LENGTH_SHORT).show()

            }


        }
        val occupationlist= arrayOf("Select Occupation","Doctor/Nurse/paramedic","Police/Officer/Law Enforcement","Delivery","Chemist/Farmacy","Wholesalar/Groceries","Industry/Manufacturur","Retailer","None of these")

        val arrayAdp= ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,occupationlist)
        occupation.adapter=arrayAdp
        occupation.onItemSelectedListener=object :


                AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
              //  pateintOcupation=occupationlist[p2]
                Toast.makeText(this@Resistrationform,occupationlist[p2],Toast.LENGTH_SHORT).show()
            }


        }

         }
    }

