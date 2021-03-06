package com.example.mytech

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity(), View.OnClickListener {
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

        val btnDialPhone: Button = findViewById(R.id.calling)
        btnDialPhone.setOnClickListener(this)

    }

    //set Title
    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun showTechsList() {
        rvTechs.layoutManager = LinearLayoutManager(this)
        val listTechAdapter = ListTechAdapter(list)
        rvTechs.adapter = listTechAdapter

        listTechAdapter.setOnItemClickCallback(object : ListTechAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Tech) {
                showSelectedTech(data)
            }
        })
    }

    private fun showSelectedTech(tech: Tech) {
        Toast.makeText(this, "You've choosen : " + tech.name, Toast.LENGTH_SHORT).show()
        Timer().schedule(1000) {
            val move = Intent(this@MainActivity, TechDetail::class.java)
            move.putExtra(TechDetail.name, tech.name)
            move.putExtra(TechDetail.detail, tech.detail)
            move.putExtra(TechDetail.photo, tech.photo)
            move.putExtra(TechDetail.price, tech.price)
            move.putExtra(TechDetail.garansi, tech.garansi)
            move.putExtra(TechDetail.cicilan, tech.cicilan)
            move.putExtra(TechDetail.link, tech.link)
            move.putExtra(TechDetail.titledetail, "Detail Tech")
            startActivity(move)
        }

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
                move.putExtra(TechAbout.EXTRA_CAMPUS, "Politeknik Caltex Riau")
                startActivity(move)
            }

        }
        setActionBarTitle(title)
    }

    override fun onClick(v: View?) {
        val phoneNumber = "+62 878 9997 7621"
        val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
        startActivity(dialPhoneIntent)
    }

}