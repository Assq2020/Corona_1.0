package com.amanaryan.corona.newsbox

import android.content.ClipData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.amanaryan.corona.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.activity_newslist.*
import kotlinx.android.synthetic.main.news_row.view.*

class Newslist : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newslist)
        fetchNews()

        }
    companion object {
        val USER_KEY = "USER_KEY"
    }

    private fun fetchNews() {
        val ref = FirebaseDatabase.getInstance().getReference("/News")
        Log.d("fetch news","fire base work $ref")
        ref.addListenerForSingleValueEvent(object: ValueEventListener {

            override fun onDataChange(p0: DataSnapshot) {
                val adapter = GroupAdapter<GroupieViewHolder>()

                p0.children.forEach {
                    Log.d("NewMessage", it.toString())
                    val news = it.getValue(News::class.java)
                    Log.d("fetch news","fire base work ${news?.link}")
                    if (news != null) {

                        adapter.add(NewsAdaptor(news))
                    }

                }

                adapter.setOnItemClickListener { item, view ->
                  //  Toast.makeText(this@Newslist,"this work is under construction",Toast.LENGTH_SHORT).show()
                    val userItem = item as NewsAdaptor

                    val intent = Intent(view.context, WebNews::class.java)
         // intent.putExtra(USER_KEY,  userItem.news.link)
                    intent.putExtra(USER_KEY, userItem.news)
                    startActivity(intent)

                   finish()

                }

                recyvleview_newmessegge.adapter = adapter


            }

            override fun onCancelled(p0: DatabaseError) {

            }
        })
    }
}

class NewsAdaptor(val news: News): Item<GroupieViewHolder>(){
    override fun getLayout(): Int {
        return R.layout.news_row

    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
         viewHolder.itemView.tv_list_news.text=news.link

    }

}
