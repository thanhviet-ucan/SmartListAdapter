package com.thanhviet.smartlistadapter

import android.support.v7.util.DiffUtil

/**
 * Created by FRAMGIA\bui.dinh.viet on 27/03/2018.
 */
class NoteDiffCallBack : DiffUtil.ItemCallback<Note>() {
  override fun areItemsTheSame(oldItem: Note?, newItem: Note?): Boolean {
    return oldItem?.id == newItem?.id
  }

  override fun areContentsTheSame(oldItem: Note?, newItem: Note?): Boolean {
    return oldItem == newItem
  }

}