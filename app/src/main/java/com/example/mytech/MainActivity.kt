package com.example.mytech

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvTechs: RecyclerView
    private var list: ArrayList<Tech> = arrayListOf()
    var title: String = "My Tech"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)
        rvTechs = findViewById(R.id.rv_techs)
        rvTechs.setHasFixedSize(true)

        list.addAll(TechsData.listData)
        showTechsList()
    }

    //set Title
    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    private fun showTechsList() {
        rvTechs.layoutManager = LinearLayoutManager(this)
        val listTechAdapter = ListTechAdapter(list)
        rvTechs.adapter = listTechAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.about -> {
                val move = Intent(this@MainActivity, TechAbout::class.java)
                move.putExtra(TechAbout.EXTRA_NAME, "M. Albar Fikri")
                move.putExtra(TechAbout.EXTRA_EMAIL, "a1221580@bangkit.academy")
                move.putExtra(TechAbout.EXTRA_BAR, "About")
                startActivity(move)
            }

        }
        setActionBarTitle(title)
    }

}