package com.dicoding.myfruit

import android.annotation.SuppressLint
import android.content.ClipData.Item
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    companion object {
        val INTENT_PARCELABLE = "OBJECT.INTENT"
    }

    private lateinit var rvFruites: RecyclerView
    private val list = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFruites = findViewById(R.id.rv_fruites)
        rvFruites.setHasFixedSize(true)

        list.addAll(getListFruites())
        showRecyclerList()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvFruites.layoutManager = LinearLayoutManager(this)
            }

            R.id.action_grid -> {
                rvFruites.layoutManager = GridLayoutManager(this, 2)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListFruites(): ArrayList<Fruit> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataKhasiat = resources.getStringArray(R.array.data_khasiat)

        val listFruit = ArrayList<Fruit>()
        for (i in dataName.indices) {
            val fruit = Fruit(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataKhasiat[i] )
            listFruit.add(fruit)
        }
        return listFruit
    }


    private fun showRecyclerList() {
        rvFruites.layoutManager = LinearLayoutManager(this)
        val listFruitAdapter = ListFruitAdapter(list)
        rvFruites.adapter = listFruitAdapter

        listFruitAdapter.setOnItemClickCallback(object : ListFruitAdapter.OnItemClickCallback {
            @SuppressLint("MissingInflatedId")
            override fun onItemClicked(fruit: Fruit) {
                setContentView(R.layout.activity_detail)

                val activityDetail : TextView = findViewById(R.id.tv_item_name)
                activityDetail.setOnClickListener(this)
            }

        })
    }
    private fun showSelectedHero(fruit: Fruit) {
        Toast.makeText(this, "Kamu memilih " + fruit.name, Toast.LENGTH_SHORT).show()
    }
}

private fun View?.setOnClickListener(onItemClickCallback: ListFruitAdapter.OnItemClickCallback) {

}

private fun <E> ArrayList<E>.add(element: Unit) {

}

