package com.example.assignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val roomList :List<roomCleaningView>) :RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val roomStateView = LayoutInflater.from(parent.context).inflate(R.layout.room_status_view,parent,false)
        return MyViewHolder(roomStateView)
    }

    override fun getItemCount(): Int {
        return roomList.size
    }



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem =roomList[position]

        holder.roomIdTV .setText(roomList[position].roomNo)
        holder.acceptBtn .setOnClickListener() {
            //roomList[position].roomCleanStatus.set
            MainActivity().myRef.child(roomList[position].roomNo).child("roomCleanStatus").setValue(false)
            //MainActivity().myRoomNoList.remove(roomList[position])
        }

    }

    class MyViewHolder(roomState:View):RecyclerView.ViewHolder(roomState) {

        val roomIdTV: TextView = roomState.findViewById(R.id.roomIdTV)
        val acceptBtn: Button = roomState.findViewById(R.id.acceptBtn)

    }
}