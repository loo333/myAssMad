package com.example.assignment

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class room_management_cleaner : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.room_management_cleaner)

        val homeBtn = findViewById<Button>(R.id.homeBtn)

        homeBtn.setOnClickListener{
            //val intent = Intent(this,home::class.java)
            //startActivity(intent)
        }

        val notificationBtn = findViewById<Button>(R.id.notificationBtn)

        notificationBtn.setOnClickListener{
            //val intent = Intent(this,notification::class.java)
            //startActivity(intent)
        }


    }

}