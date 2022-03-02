package com.techvd.constraintlayout

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI


class GoFragment : Fragment() {

    private lateinit var goButton : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val rowView = inflater.inflate(R.layout.fragment_go, container, false)

        goButton = rowView.findViewById(R.id.go_button)

        goButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_goFragment_to_exerciseFragment)
        )

        setHasOptionsMenu(true)

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name)
        return rowView

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(
            R.menu.overflow_menu,
            menu
        )
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,view!!.findNavController()) ||
                super.onOptionsItemSelected(item)
    }
}
