package com.example.room.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.room.APP
import com.example.room.databinding.ItemLayoutBinding
import com.example.room.model.NoteModel
import com.example.room.screens.StartScreen.StartFragment
import java.util.*
import kotlin.collections.ArrayList

class NoteAdapter: RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    var listNote = emptyList<NoteModel>()
    class NoteViewHolder(val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.binding.apply {
            itemTitle.text = listNote[position].title
            if(listNote[position].description.isNotEmpty()) {
                itemDesc.text = listNote[position].description
            } else {
                itemDesc.text = "No additional text"
            }
        }
    }

    override fun getItemCount(): Int {
        return listNote.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<NoteModel>) {
        listNote = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: NoteViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            StartFragment.onClick(listNote[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: NoteViewHolder) {
        holder.itemView.setOnClickListener(null)
    }

//    override fun getFilter(): Filter {
//        return object : Filter() {
//            override fun performFiltering(constraint: CharSequence?): FilterResults {
//                val charSearch = constraint.toString()
//                if (charSearch.isEmpty()) {
//                    setList(listNote)
//                } else {
//                    val filteredList = ArrayList<NoteModel>()
//                    for (note in listNote) {
//                        if (note.title.lowercase().contains(charSearch.lowercase()) ||
//                            note.description.lowercase().contains(charSearch.lowercase())) {
//                            filteredList.add(note)
//                        }
//                    }
//                    setList(filteredList)
//                }
//                val filterResults = FilterResults()
//                filterResults.values = listNote
//                return filterResults
//            }
//
//            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
//                listNote = results?.values as ArrayList<NoteModel>
//                notifyDataSetChanged()
//            }
//
//        }
//    }

}