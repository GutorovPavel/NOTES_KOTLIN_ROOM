package com.example.room.screens.AddNoteScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.room.APP
import com.example.room.R
import com.example.room.databinding.FragmentAddNoteBinding
import com.example.room.model.NoteModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AddNoteFragment : Fragment() {

    lateinit var binding: FragmentAddNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {

        val viewModel = ViewModelProvider(this)[AddNoteViewModel::class.java]

        binding.buttonBack.setOnClickListener {
            APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)
        }
        binding.buttonAdd.setOnClickListener {

            val title = binding.editTitle.text.toString()
            val description = binding.editDescription.text.toString()
            if (title.isNotEmpty()) {
                viewModel.insert(NoteModel(title = title, description = description)) {}
            }
            APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)
        }
    }
}