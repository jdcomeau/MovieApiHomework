package com.example.musicapihomework.view

import com.example.musicapihomework.model.view.MusicResponse

interface ViewFragmentDisplay {
    fun displayData(dataSet: List<MusicResponse>)
    fun displayDetails(dataItem: MusicResponse)
    fun unBind()
    fun onBind()
}