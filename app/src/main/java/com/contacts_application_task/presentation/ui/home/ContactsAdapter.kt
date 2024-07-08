package com.contacts_application_task.presentation.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.contacts_application_task.domain.models.Contact
import com.contacts_application_task.R

class ContactsAdapter(var list : MutableList<Contact>?= mutableListOf()) : Adapter<ContactsAdapter.ViewHolder>() {
    class ViewHolder(itemView : View ) : RecyclerView.ViewHolder(itemView){
        var userName : TextView = itemView.findViewById(R.id.text_name)
        var userPhone : TextView = itemView.findViewById(R.id.text_phone)
        var dialog : ImageView = itemView.findViewById(R.id.dialog)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_rv,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.userName.text = list!![position].name
        holder.userPhone.text = list!![position].number
        holder.dialog.setOnClickListener {
            onItemClickListener?.onItemClick(position,list!![position])
        }
        holder.itemView.setOnClickListener {
            onAllItemClickListener?.onItemClick(position,list!![position])
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(listUp: List<Contact>) {
        this.list = listUp.toMutableList()
        notifyDataSetChanged()
    }

    fun clearContactDeleted(contact: Contact) {
        list?.remove(contact)
        notifyDataSetChanged()
    }

var onAllItemClickListener : OnItemClickListener?= null
    var onItemClickListener : OnItemClickListener?= null
interface OnItemClickListener{
    fun onItemClick(position:Int , contact : Contact)
}

}