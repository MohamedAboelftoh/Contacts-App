package com.contacts_application_task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class RV_Adapter () : Adapter<RV_Adapter.View_Holder>() {
    lateinit var mListener : OnItemClickListener
    lateinit var list : List<DataClass_RV>
interface OnItemClickListener{
    fun onItemClick(position : Int)
}
    fun setOnItemClickListener(listener:OnItemClickListener){
        mListener = listener
    }
    constructor(list: List<DataClass_RV>) : this() {
        this.list = list
    }
    class View_Holder(itemView: View , listener:OnItemClickListener) : ViewHolder(itemView) {
      val name : TextView = itemView.findViewById(R.id.text_name)
      val phone : TextView = itemView.findViewById(R.id.text_phone)
      init {
          itemView.setOnClickListener {
              listener.onItemClick(adapterPosition)
          }
      }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): View_Holder {
       val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_rv,parent,false)
        val VH : View_Holder = View_Holder(view,mListener)
        return VH
    }
    override fun getItemCount(): Int {
      return list.size
    }
    override fun onBindViewHolder(holder: View_Holder, position: Int) {
        val item = list[position]
        holder.name.setText(item.userName)
        holder.phone.setText(item.userPhone)
    }
}