package com.example.musicapihomework.view

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicapihomework.R
import com.example.musicapihomework.model.view.MusicDataSet
import com.example.musicapihomework.model.view.MusicResponse

class FragmentDisplay : Fragment() {

    lateinit var listener: (data: MusicResponse) -> Unit

    override fun onAttach(context: Context) {
        super.onAttach(context)

        //listener = (context as MainActivity)::createDetailedFragment
    }

    companion object{
        val KEY_FRAGMENT_DISPLAY = "KEY_FRAGMENT_DISPLAY"

        fun createFragmentDisplay(dataSet: List<MusicResponse>)
                : FragmentDisplay {
            //todo create fragment
            //todo create bundle
            //todo assign the bundle to the Fragment
            //todo return the fragment
            val fragmentDisplay = FragmentDisplay()
            val bundle = Bundle()
            val parcelableDataSet = MusicDataSet(dataSet
                    as ArrayList<MusicResponse>)

            bundle.putParcelableArrayList(
                KEY_FRAGMENT_DISPLAY,
                dataSet as java.util.ArrayList<out Parcelable>)
            fragmentDisplay.arguments = bundle
            return fragmentDisplay
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(
            R.layout.fragment_display,
            container,
            false)
        arguments?.getParcelableArrayList<MusicResponse>(KEY_FRAGMENT_DISPLAY)
            ?.let {
                inflateRecyclerView(it, view)
            }
        return view
    }

    private fun inflateRecyclerView(dataSet: ArrayList<MusicResponse>, view: View){
        val linearLayoutManager =
            LinearLayoutManager(activity)

        //view.recyclerview.layoutManager = linearLayoutManager
        //view.recyclerview.adapter = MusicAdapter(dataSet,
        // listener)
    }

}