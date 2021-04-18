package com.example.assignment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class MainActivity : AppCompatActivity() {

    var myRoomNoList = ArrayList<roomCleaningView>()
    val database = FirebaseDatabase.getInstance()
    val myRef = database.getReference("Room")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.room_management_cleaner)

        val recycleView: RecyclerView = findViewById(R.id.recyclerView2)
        recycleView.adapter = MyAdapter(myRoomNoList)
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.setHasFixedSize(true)

        var adapter = MyAdapter(myRoomNoList)
        recycleView.setAdapter(adapter)

        //MyAdapterCleaner = RecyclerAdapter(posts, applicationContext)



        var getData = object: ValueEventListener {

            override fun onCancelled(error: DatabaseError) {

           }
            override fun onDataChange(snapshot: DataSnapshot) {
                for(s in snapshot.children){
                    val roomNo:String = s.child("roomNo").getValue().toString()
                    val roomCleanStatus:String = s.child("roomCleanStatus").getValue().toString()
                    addData(roomNo,roomCleanStatus)
                    //deleteData(roomNo,roomCleanStatus)
                }

            }
        }

      myRef.addListenerForSingleValueEvent(getData)


    }
    fun addData(roomNo:String,roomCleanStatus:String){

        val room = roomCleaningView(roomNo,roomCleanStatus)

          if (room.roomCleanStatus=="true"){
              myRoomNoList.add(room)
          }
    }
}