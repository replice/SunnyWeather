package com.sunnyweather.android

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



open class SampleRecyclerAdapter(protected var mCount: Int) :
    RecyclerView.Adapter<SampleRecyclerAdapter.TextViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        return TextViewHolder.createViewHolder(parent)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.bindView(position)
    }

    override fun getItemCount(): Int {
        return mCount
    }

    fun add() {
        val position = mCount
        mCount++
        notifyItemInserted(position)
    }

    fun remove() {
        if (mCount == 0) {
            return
        }
        mCount--
        val position = mCount
        notifyItemRemoved(position)
    }

    class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
/*        private val random = Random()*/
        fun bindView(position: Int) {
            val textView = itemView as TextView
       /*     textView.text = (position + 1).toString()*/
          /*  textView.setBackgroundColor(-0x1000000 or random.nextInt(0x00ffffff))*/
        }

        companion object {
            fun createViewHolder(parent: ViewGroup): TextViewHolder {
                val textView = TextView(parent.context)
                textView.gravity = Gravity.CENTER
                textView.setTextColor(Color.WHITE)
                textView.textSize = 48f
                textView.layoutParams = RecyclerView.LayoutParams(
                    RecyclerView.LayoutParams.MATCH_PARENT,
                    RecyclerView.LayoutParams.MATCH_PARENT
                )
                return TextViewHolder(textView)
            }
        }
    }
}






