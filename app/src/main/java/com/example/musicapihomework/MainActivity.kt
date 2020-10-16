package com.example.musicapihomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.musicapihomework.R

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}