package com.example.music_player

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(private  val context: Activity, private val  arrayList: ArrayList<User>): ArrayAdapter<User>(context,
R.layout.activity_listview, arrayList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate((R.layout.activity_listview), null)


        val songpic: ImageView = view.findViewById(R.id.songpic)
        val songname:TextView = view.findViewById(R.id.songname)
        val descrip:TextView = view.findViewById(R.id.descrip)
        val duration: TextView = view.findViewById(R.id.duration)

        songpic.setImageResource(arrayList[position].Imageid)
        songname.text=arrayList[position].name
        descrip.text=arrayList[position].lastMessage
        duration.text=arrayList[position].LastmessageTime


        return view
    }


}