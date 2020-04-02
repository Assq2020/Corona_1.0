package com.amanaryan.corona

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_resistrationform.*

class Resistrationform : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resistrationform)
         val sex:String
        val sexPopupBtn=findViewById<Button>(R.id.sex_popup_button_resister)
         sexPopupBtn.setOnClickListener {
//             val popupMenu=PopupMenu(this,sexPopupBtn)
//             popupMenu.menuInflater.inflate(R.menu.sex_popup_menu,popupMenu.menu)
//             popupMenu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener{
//                 override fun onMenuItemClick(p0: MenuItem?): Boolean {
//                     when (item!!.itemId) {
//                         R.id.male_id ->
//                             Toast.makeText(this@Resistrationform, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
//                         R.id.female_id ->
//                             Toast.makeText(this@Resistrationform, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
//                         R.id.Other_id ->
//                             Toast.makeText(this@Resistrationform, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
//                     }
//                     true
//                 }
//             })
//             popupMenu.show()
         }
    }
}
