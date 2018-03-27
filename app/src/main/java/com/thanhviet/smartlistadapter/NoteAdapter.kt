package com.thanhviet.smartlistadapter

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by FRAMGIA\bui.dinh.viet on 27/03/2018.
 */
class NoteAdapter(var listNote: MutableList<Note>,
    val clickListener: (Int) -> Unit) : ListAdapter<Note, NoteAdapter.NoteVH>(NoteDiffCallBack()) {
  override fun onBindViewHolder(holder: NoteVH, position: Int) {
    holder.bindData(listNote?.get(position), clickListener)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteVH {
    val inflater = LayoutInflater.from(parent.context)
    return NoteVH(inflater.inflate(R.layout.item_note, parent, false))
  }

  override fun getItemCount() = listNote.size

  class NoteVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val title: TextView = itemView.findViewById(R.id.title)
    private val trash: ImageView = itemView.findViewById(R.id.btn_delete)

    fun bindData(note: Note, clickListener: (Int) -> Unit) {
      title.text = note.title
      trash.setOnClickListener { clickListener(adapterPosition) }
    }
  }
}