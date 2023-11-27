package com.example.music_player

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.music_player.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var userArrayList: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        requestRuntimePermission()

        setContentView(binding.root)

        //song pic
        val imageId = intArrayOf(

            R.drawable.selena,R.drawable.onedirection,R.drawable.billieeilish
        )

        //song name
         val name = arrayOf(
             "We dont Talk Anymore","Steal My Girl","Therefore I Am"
         )

        //song description
        val lastMessage = arrayOf(
            "By Selena Gomez annd Charlie Puth","One Direction","Billie Eilish"
        )

        //song duration
        val LastmessageTime = arrayOf(
            "03:34","03:00","02:24"
        )
        val songs = arrayOf(
            R.raw.wdta,R.raw.stealmygirl,R.raw.thereforeiam

        )

        userArrayList = ArrayList()

        for(i in  name.indices)
        {
            val user = User(name[i],lastMessage[i],LastmessageTime[i],imageId[i],songs[i])
            userArrayList.add(user)
        }


        binding.listview.isClickable = true
        binding.listview.adapter = MyAdapter(this, userArrayList)
        binding.listview.setOnItemClickListener { parent, view, position, id ->

            val name = name[position]
            val lastMessage = lastMessage[position]
            val LastmessageTime = LastmessageTime[position]
            val imageId = imageId[position]
            val songs = songs[position]

            val i = Intent(this, player1Activity::class.java)
            i.putExtra("name", name)
            i.putExtra("lastMessage",lastMessage)
            i.putExtra("LastmessageTime", LastmessageTime)
            i.putExtra("imageId", imageId)
            i.putExtra("songs",songs)
            startActivity(i)

        }

        binding.like.setOnClickListener {
            val intent = Intent(this, LikeActivity::class.java)
            startActivity(intent)
        }

        binding.shuffle.setOnClickListener {
            val intent = Intent(this, player1Activity::class.java)
            startActivity(intent)
        }

    }
    private fun requestRuntimePermission(){
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), 3)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 3)
        {
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
            else
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),3)

        }
    }
}