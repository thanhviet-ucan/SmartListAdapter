package com.thanhviet.smartlistadapter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  private val noteRepository = NoteRepository()
  var dataList = noteRepository.instanceData
  private var noteAdapter = NoteAdapter() { position: Int ->
    deleteNote(position)
  }

  private fun deleteNote(position: Int) {
    dataList.removeAt(position)
    noteAdapter.notifyItemRemoved(position)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    noteAdapter.submitList(dataList)
    recycler_main.apply {
      layoutManager = LinearLayoutManager(this@MainActivity)
      adapter = noteAdapter
      addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }
    btn_forward.setOnClickListener {
      Toast.makeText(this, "Forward Page", Toast.LENGTH_SHORT).show()
      dataList = noteRepository.dataUpdate
      noteAdapter.submitList(dataList)
    }

    btn_back.setOnClickListener {
      Toast.makeText(this, "Back Page", Toast.LENGTH_SHORT).show()
      dataList = noteRepository.instanceData
      noteAdapter.submitList(dataList)
    }
  }
}
