package com.techvd.constraintlayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import pl.droidsonroids.gif.GifImageView
import kotlin.math.min

class ExerciseFragment : Fragment() {
    data class Exercise(
        val exerciseType: String, val count: Int
    )

    private val exercises: MutableList<Exercise> = mutableListOf(
        Exercise("gif_one", 10),
        Exercise("gif_two", 8),
        Exercise("gif_three", 6),
        Exercise("gif_four", 5),
        Exercise("gif_five", 12)
    )
    private var exerciseIndex = 0
    private var exerciseSize = min((exercises.size + 1) / 2, 3)

    private lateinit var gif: GifImageView
    private lateinit var countText: TextView
    private lateinit var exitButton: Button
    private lateinit var nextButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val rowView = inflater.inflate(R.layout.fragment_exercise, container, false)

        gif = rowView.findViewById(R.id.gifImageView)
        countText = rowView.findViewById(R.id.count_text)
        exitButton = rowView.findViewById(R.id.exitButton)
        nextButton = rowView.findViewById(R.id.nextButton)

        randomExercise()
        nextButton.setOnClickListener {
            exerciseIndex++
            if (exerciseIndex < exerciseSize) {
                setExercise()
            } else {
                view?.findNavController()?.navigate(R.id.action_exerciseFragment_to_wellDone)
            }
        }

        exitButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_exerciseFragment_to_tryAgain))
        return rowView
    }

    private fun randomExercise() {
        exercises.shuffle()
        setExercise()
    }

    private fun setExercise() {
        val currentExercise = exercises[exerciseIndex]
        gif.setImageResource(
            resources.getIdentifier(
                currentExercise.exerciseType, "drawable",
                (activity as AppCompatActivity).packageName
            )
        )
        countText.text = String.format(getString(R.string.count_text, currentExercise.count))
        (activity as AppCompatActivity).supportActionBar?.title =
            String.format(getString(R.string.action_bar), exerciseIndex + 1, exerciseSize)

    }
}