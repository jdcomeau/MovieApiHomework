package com.example.musicapihomework.model.view

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


data class itunesApiResults(
    val resultCount: Int,
    val results:ArrayList<MusicResponse>
)

@Parcelize
data class MusicResponse(
    val collectionName: String,
    val artworkUrl100: String,
    val trackPrice: Double,
    val previewUrl: String
) : Parcelable

@Parcelize
data class MusicDataSet(
    val dataSet: ArrayList<MusicResponse>
): Parcelable

@Parcelize
data class MusicDetail(
    val data: MusicResponse
): Parcelable