package com.techvd.constraintlayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation


class TryAgain : Fragment() {

    private lateinit var tryAgainButton : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rowView = inflater.inflate(R.layout.fragment_try_again, container, false)

        tryAgainButton = rowView.findViewById(R.id.try_again_button)
        tryAgainButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_tryAgain_to_exerciseFragment2))

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name)
        return rowView
    }

}