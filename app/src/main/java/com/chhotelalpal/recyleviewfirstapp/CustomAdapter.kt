package com.chhotelalpal.recyleviewfirstapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

// https://www.sim plifiedcoding.net/kotlin-recyclerview-example/

class CustomAdapter(var cityAdapterEvents: CityAdapterEvents, val userlist: ArrayList<Cityinfo>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(userlist[position])

    }

    override fun getItemCount(): Int {
        return userlist.size
    }

    // the class is holding the listView
    inner class ViewHolder(

        itemView: View
    ) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener, View.OnLongClickListener {
        fun bindItems(user: Cityinfo) {
            val textViewname = itemView.findViewById<TextView>(R.id.textViewname)
            val textViewUsername = itemView.findViewById<TextView>(R.id.textViewUsername)
            val textViewAddress = itemView.findViewById<TextView>(R.id.textViewAddress)
            textViewname.text = user.name
            textViewAddress.text = user.cityName
            textViewUsername.text = user.stateName

        }

        init {
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)

        }


        override fun onClick(v: View) {
            val position: Int = adapterPosition

            cityAdapterEvents.onCityClick(userlist.get(position))

        }

        override fun onLongClick(p: View?): Boolean {

            if (p != null) {
                val position: Int = adapterPosition
                Toast.makeText(
                    p.context,
                    "\"Deleted this Information\"${userlist.get(position).stateName}",
                    Toast.LENGTH_LONG
                )
                    .show()
            }
            deleteItem(position)
            return true
        }

    }


    private fun remove(position: Int) {
        userlist.removeAt(position)
        /*notifyItemChanged(position)
        notifyItemRangeRemoved(position, 1)*/
        notifyDataSetChanged()
    }

    private fun deleteItem(position: Int) {
        userlist.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, userlist.size)

    }

    interface CityAdapterEvents {
        fun onCityClick(cityinfo: Cityinfo)
    }


}


