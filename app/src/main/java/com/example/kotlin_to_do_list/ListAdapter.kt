package com.example.kotlin_to_do_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_to_do_list.model.Entity
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var todoList = emptyList<Entity>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row,parent,false))
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = todoList[position]
        holder.itemView.id_text.text = currentItem.id.toString()
        holder.itemView.tassk.text = currentItem.title

        holder.itemView.todo_row.setOnClickListener{

        }
    }

    fun deleteTodo(){
        //todo
    }
    fun setData(todo: List<Entity>){
        this.todoList = todo
        notifyDataSetChanged()
    }
}