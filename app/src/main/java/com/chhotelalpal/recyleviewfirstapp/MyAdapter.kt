package com.chhotelalpal.recyleviewfirstapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

// https://www.youtube.com/watch?v=cppys4VYyvA


class MyAdapter : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private var oldPersonList = emptyList<Person>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(oldPersonList[position])

    }

    override fun getItemCount(): Int {
        return oldPersonList.size
    }

    // the class is holding the listView
    inner class ViewHolder(

        itemView: View
    ) :
        RecyclerView.ViewHolder(itemView) {
        fun bindItems(user: Person) {
            val id = itemView.findViewById<TextView>(R.id.id)
            val name = itemView.findViewById<TextView>(R.id.name)
            val age = itemView.findViewById<TextView>(R.id.age)
            name.text = user.name
            id.text = user.id.toString()
            age.text = user.age.toString()

        }


    }


    interface CityAdapterEvents {
        fun onCityClick(cityinfo: Person)
    }

    fun setData(newPersonList: List<Person>) {
        val diffUtill = MyDiffUtil(oldPersonList, newPersonList)
        val diffResults = DiffUtil.calculateDiff(diffUtill)
        oldPersonList=newPersonList
        diffResults.dispatchUpdatesTo(this)
    }

}


