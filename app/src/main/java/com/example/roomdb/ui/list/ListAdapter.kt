package com.example.roomdb.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdb.R
import com.example.roomdb.data.User
import kotlinx.android.synthetic.main.custom_row.view.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textfirst_name: TextView = itemView.findViewById(R.id.textfirst_name)
        val textLast_name: TextView = itemView.findViewById(R.id.textLast_name)
        val textAge: TextView = itemView.findViewById(R.id.TextAge)
        val textIndex: TextView = itemView.findViewById(R.id.textIndex)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.textIndex.text = currentItem.id.toString()
        holder.textfirst_name.text = currentItem.firstName
        holder.textLast_name.text = currentItem.lastName
        holder.textAge.text = currentItem.age.toString()
    }

    override fun getItemCount(): Int {
        return  userList.size
    }

    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }
}