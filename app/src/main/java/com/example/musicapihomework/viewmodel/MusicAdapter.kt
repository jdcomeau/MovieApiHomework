package com.example.musicapihomework.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicapihomework.R
import com.example.musicapihomework.model.view.MusicResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_layout.view.*

class MusicAdapter(val dataSet: List<MusicResponse>,
                   val listener: (dataItem: MusicResponse) -> Unit)
    : RecyclerView.Adapter<MusicAdapter.MusicViewHolder> (){


    class MusicViewHolder(val musicView: View)
        : RecyclerView.ViewHolder(musicView){
        fun onBind(dataItem: MusicResponse,
                   listener: (dataItem: MusicResponse)->Unit){
            musicView.tv_item_music_title.text = dataItem.collectionName
            itemView.setOnClickListener {
                listener.invoke(dataItem)
            }
            Picasso.get().load(dataItem.artworkUrl100)
                .into(musicView.iv_item_music_poster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        /**
         * Creates the ViewHolder defined in the generic type.
         */
        return MusicViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout,
                parent, false)
        )
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        /**
         * Connect the data with the ViewHolder views.
         */
        holder.onBind(dataSet[position], listener)
    }

    /**
     * render N items has this function returns.
     */

    override fun getItemCount(): Int {
        return dataSet.size
    }
}