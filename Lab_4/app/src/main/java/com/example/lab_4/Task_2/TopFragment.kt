package com.example.lab_4.Task_2

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.lab_4.R

class TopFragment: Fragment(R.layout.fragment_second_task_top) {

    private lateinit var buttonAdd: Button
    private lateinit var buttonDelete: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buttonAdd = view.findViewById(R.id.bnAdd)
        buttonDelete = view.findViewById(R.id.bnDelete)
        setButtonsListeners()
    }

    private fun setButtonsListeners() {
        buttonAdd.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.fcBottom, BottomFragment())
                .addToBackStack(null)
                .commit()

        }
        buttonDelete.setOnClickListener {
            parentFragmentManager.popBackStack("FirstFragment", 0)
        }
    }
}