package com.example.music_player

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.music_player.databinding.MusicViewBinding

class MusicAdapter(private val context: Context, private val musicList: ArrayList<String>) : RecyclerView.Adapter<MusicAdapter.Myholder>(){
    class Myholder(binding: MusicViewBinding) : RecyclerView.ViewHolder(binding.root) {
        val title = binding.songNameMV
        val album = binding.songAlbumMV
        val image = binding.imageMV
        val duration = binding.songDuration
        val root = binding.root

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myholder {
        return Myholder(MusicViewBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: Myholder, position: Int) {

        holder.title.text = musicList[position]


    }

    override fun getItemCount(): Int {
        return musicList.size
    }


}