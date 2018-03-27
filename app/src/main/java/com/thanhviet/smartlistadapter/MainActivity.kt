package com.thanhviet.smartlistadapter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  private val noteRepository = NoteRepository()
  private var noteAdapter = NoteAdapter(noteRepository.instanceData) { position: Int ->
    deleteNote(position)
  }

  private fun deleteNote(position: Int) {
    noteAdapter.listNote.removeAt(position)
    noteAdapter.notifyItemRemoved(position)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    recycler_main.apply {
      layoutManager = LinearLayoutManager(this@MainActivity)
      adapter = noteAdapter
      addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }
    plus_btn.setOnClickListener {
      noteAdapter.submitList(noteRepository.dataUpdate)
    }
  }

}
