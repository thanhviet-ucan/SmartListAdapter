package com.thanhviet.smartlistadapter

import android.os.SystemClock
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
class NoteAdapter(
    val clickListener: (Int) -> Unit) : ListAdapter<Note, NoteAdapter.NoteVH>(NoteDiffCallBack()) {
  override fun onBindViewHolder(holder: NoteVH, position: Int) {

    holder.bindData(getItem(position), clickListener)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteVH {
    val inflater = LayoutInflater.from(parent.context)
    return NoteVH(inflater.inflate(R.layout.item_note, parent, false))
  }

  class NoteVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val title: TextView = itemView.findViewById(R.id.title)
    private val trash: ImageView = itemView.findViewById(R.id.btn_delete)

    fun bindData(note: Note, clickListener: (Int) -> Unit) {
      title.text = note.title
      var mLastClickTime: Long = 0
      trash.setOnClickListener(object : View.OnClickListener {
        override fun onClick(view: View) {
          if (SystemClock.elapsedRealtime() - mLastClickTime < 1000)
            return

          clickListener(adapterPosition)
          mLastClickTime = SystemClock.elapsedRealtime()

        }
      })
    }
  }
}