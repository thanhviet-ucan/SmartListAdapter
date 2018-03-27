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

  private var dataNew = mutableListOf<Note>(
      Note(1, "Tom is new friend"),
      Note(2, "Must married"),
      Note(3, "Kiss a new friend"),
      Note(4, "Sleep"),
      Note(5, "Enjoy new car"),
      Note(6, "Buy a big house")
  )

  val instanceData: MutableList<Note> get() = data

  val dataUpdate: MutableList<Note> get() = dataNew
//    data.set(3, Note(3, "Do morning exercise"))
}