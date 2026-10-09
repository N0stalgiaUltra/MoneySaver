package com.example.moneysaver.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.moneysaver.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainScreen : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main_screen, container, false)

        val testBtn = view.findViewById<FloatingActionButton>(R.id.fab_add)
        testBtn.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_mainScreen_to_addExpense)
        }


        return view
    }


}