package com.example.musicapihomework.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.musicapihomework.R
import com.example.musicapihomework.model.view.MusicResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_detail.view.*

class FragmentDetail: Fragment() {

    companion object {
        val KEY_FRAGMENT_DETAIL = "KEY_FRAGMENT_DETAIL"
        fun createFragmentDetail(dataItem: MusicResponse)
                : FragmentDetail {
            val fragment = FragmentDetail()
            val bundle = Bundle()
            bundle.putParcelable(
                KEY_FRAGMENT_DETAIL, dataItem)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(
            R.layout.fragment_detail,
            container,
            false)

        arguments?.getParcelable<MusicResponse>(KEY_FRAGMENT_DETAIL)
            ?.let {
                bindData(view, it)
            }
        return view

    }

    private fun bindData(view: View,
                         dataItem: MusicResponse
    ){
        view.tv_music_name_detail.text = dataItem.collectionName
        view.tv_music_track_detail.text = dataItem.trackPrice.toString()
        view.tv_music_preview_detail.text = dataItem.previewUrl
        Picasso.get().load(dataItem.artworkUrl100).into(iv_music_artwork_detail)
        //view.tv_movie_rating_detail.text = dataItem.artworkUrl100
    }
}