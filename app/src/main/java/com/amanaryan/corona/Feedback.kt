package com.amanaryan.corona

//import com.google.firebase.storage.FirebaseStorage
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.activity_feedback.*
import kotlinx.android.synthetic.main.feedback_row.view.*

class Feedback : AppCompatActivity() {
  //
     lateinit var feederName:String
    lateinit var feeddesc:String
    val DATABASE_VERION=1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)
//        val adapter= GroupAdapter<GroupieViewHolder>()
//        recycleview_feedback.adapter=adapter
//        adapter.add(FeedItems(Feeddata("qamar","gguwgjqhfuyqdv")))
//        adapter.add(FeedItems(Feeddata("qamar","gguwgjqhfuyqdv")))
//        adapter.add(FeedItems(Feeddata("qamar","gguwgjqhfuyqdv")))
        fetchdata()
       // val datreadcls=Datareadjavafile()
     //   feederName=datreadcls.readName()
        feed_send_button.setOnClickListener {
            feeddesc=feed_content_et.text.toString()
            feederName=feeder_name.text.toString()
           //readName()
            Toast.makeText(this,"username $feederName",Toast.LENGTH_SHORT).show()
            uploadFeed()


        }

    }
    fun fetchdata(){
        val ref = FirebaseDatabase.getInstance().getReference("/Feedback")
        ref.addListenerForSingleValueEvent(object: ValueEventListener {

            override fun onDataChange(p0: DataSnapshot) {
                val adapter = GroupAdapter<GroupieViewHolder>()

                p0.children.forEach {
                    Log.d("NewMessage", it.toString())
                    val feeds = it.getValue(Feeddata::class.java)
                    if (feeds != null) {
                        adapter.add(FeedItems(feeds))
                    }
                }
                recycleview_feedback.adapter = adapter
            }

            override fun onCancelled(p0: DatabaseError) {

            }
        })
    }

    fun uploadFeed(){
        val uid= FirebaseAuth.getInstance().uid?:""
        val feeddata=Feeddata(feederName,feeddesc)
        val ref=FirebaseDatabase.getInstance().getReference("/Feedback/").push()
        ref.setValue(feeddata)
                .addOnSuccessListener {
           Log.d("Main","user detail is uploaded")
                    feed_content_et.text.clear()
                    feeder_name.text.clear()

       }

               .addOnFailureListener {
                   Log.d("Main","details re not uploaded :try again")
                   Toast.makeText(this,"users detail not uploaded",Toast.LENGTH_SHORT).show()

               }
    }

}
//class DatabasHelper(context: Context):SQLiteOpenHelper(context,"db",1,null){
//    override fun onCreate(p0: SQLiteDatabase?) {
//        val userTable="CREATE TABLE"+"db"+("+")
//
//    }
//}
class FeedItems(val feeds:Feeddata):Item<GroupieViewHolder>(){
    override fun getLayout(): Int {
        return R.layout.feedback_row
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.feed_user_name.text = feeds.name
        viewHolder.itemView.user_feed_tv.text = feeds.feedcontents
    }

}
class Feeddata(val name:String,val feedcontents:String){
    constructor():this("","")

}