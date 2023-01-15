package com.example.room.screens.DetailNoteScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.room.APP
import com.example.room.R
import com.example.room.databinding.FragmentDetailNoteBinding
import com.example.room.model.NoteModel

class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailNoteBinding
    lateinit var currentNote: NoteModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailNoteBinding.inflate(layoutInflater, container, false)
        @Suppress("DEPRECATION")
        currentNote = arguments?.getSerializable("note") as NoteModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[DetailViewModel::class.java]

        binding.noteTitle.text = currentNote.title
        binding.noteDescription.setText(currentNote.description)

        binding.buttonBack.setOnClickListener {
            if (binding.noteDescription.text.toString() != currentNote.description) {
                APP.alertDialogBuilder.setTitle("Alert")
                    .setMessage("Do you really want to edit note?")
                    .setPositiveButton("Yes") { dialog, which ->
                        currentNote.description = binding.noteDescription.text.toString()
                        viewModel.update(currentNote) {}
                        APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
                    }
                    .setNegativeButton("No") { dialog, which -> }
                    .show()
            } else {
                APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
            }
        }
        binding.buttonDel.setOnClickListener {
            APP.alertDialogBuilder.setTitle("Alert")
                .setMessage("Do you really want to delete this note?")
                .setPositiveButton("Yes") { dialog, which ->
                    viewModel.delete(currentNote) {}
                    APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
                }
                .setNegativeButton("No") { dialog, which -> }
                .show()
        }
    }
}