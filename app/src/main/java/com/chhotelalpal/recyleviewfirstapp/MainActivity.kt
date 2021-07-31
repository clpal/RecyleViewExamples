package com.chhotelalpal.recyleviewfirstapp

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// https://www.youtube.com/watch?v=XfKCP2sGxfo&list=PLgFdqEQxNY7QrarM3E-HHOs_nyIjl4I6b
class MainActivity : AppCompatActivity() , CustomAdapter.CityAdapterEvents {

    var userlist: ArrayList<Cityinfo> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      val recyclerView=  findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        userlist= ArrayList<Cityinfo>()
        userlist.add(Cityinfo("Chhote Lal Pal","Fatehpur","Uttar Pradesh"))
        userlist.add(Cityinfo("Mragendra Singh Senger","Bhopal","Madhya Pradesh"))
        userlist.add(Cityinfo("Amit","RaiPur","Rajasthan"))
        userlist.add(Cityinfo("Akash","sant Nagar","Himanchal"))
        userlist.add(Cityinfo("Praven","Pratabgarh","Mumbai"))
        userlist.add(Cityinfo("Ameen","Udaipur","Utrakhand"))



      val adapter=  CustomAdapter(this,userlist)
        recyclerView.adapter=adapter

    }

 override fun onCityClick(cityinfo: Cityinfo) {

  Toast.makeText(applicationContext, "Name is :${cityinfo.name} ${cityinfo.cityName} ${cityinfo.stateName}", Toast.LENGTH_LONG).show()
 }


}