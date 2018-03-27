package com.thanhviet.smartlistadapter

/**
 * Created by FRAMGIA\bui.dinh.viet on 27/03/2018.
 */
class NoteRepository {
  private var data = mutableListOf<Note>(
      Note(1, "Go village"),
      Note(2, "Study Math"),
      Note(3, "Talk with girlfriend"),
      Note(4, "Eat breakfast"),
      Note(5, "Listen music"),
      Note(6, "Play football")
  )

  val instanceData: MutableList<Note> get() = data

  val dataUpdate: MutableList<Note> get() {
    data.set(3, Note(3, "Do morning exercise"))
    return data
  }
}