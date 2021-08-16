package com.chhotelalpal.recyleviewfirstapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// https://www.youtube.com/watch?v=XfKCP2sGxfo&list=PLgFdqEQxNY7QrarM3E-HHOs_nyIjl4I6b
class MainActivity : AppCompatActivity(), MyAdapter.CityAdapterEvents {
    private val myAdapter by lazy {
        MyAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val addView = findViewById<Button>(R.id.addView)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val person1 = Person(1, "Chhote Lal Pal", 33)
        val person2 = Person(2, "Anuj", 28)
        val person3 = Person(3, "Adi", 1)

        myAdapter.setData(listOf(person1, person2, person3))
        recyclerView.adapter = myAdapter

        addView.setOnClickListener {
            val person4 = Person(4, "Priyanka", 26)
            val person5 = Person(5, "Shivani", 28)
            val person6 = Person(6, "Shailesh", 35)

            myAdapter.setData(listOf(person1, person2, person3, person4, person5, person6))
        }


    }

    override fun onCityClick(cityinfo: Person) {

        Toast.makeText(
            applicationContext,
            "Name is :${cityinfo.name} ${cityinfo.id} ${cityinfo.age}",
            Toast.LENGTH_LONG
        ).show()
    }


}