package com.techvd.constraintlayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation


class WellDone : Fragment() {

    private lateinit var nextExerciseButton: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rowView = inflater.inflate(R.layout.fragment_well_done, container, false)

        nextExerciseButton = rowView.findViewById(R.id.next_exercise_button)

        nextExerciseButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_wellDone_to_exerciseFragment2))

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name)
        return rowView
    }


    }
