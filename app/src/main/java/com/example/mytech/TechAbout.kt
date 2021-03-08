package com.example.mytech

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TechAbout : AppCompatActivity() {
    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_BAR = "extra_bar"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_row_about)

        //data being received
        val nameReceiver: TextView = findViewById(R.id.nama)
        val emailReceiver: TextView = findViewById(R.id.email)

        val name = intent.getStringExtra(EXTRA_NAME)
        val email = intent.getStringExtra(EXTRA_EMAIL)
        val title = intent.getStringExtra(EXTRA_BAR)

        nameReceiver.text = name
        emailReceiver.text = email
        if (title != null) {
            setActionBarTitle(title)
        }



    }

    private fun setActionBarTitle(title: String){
        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = title
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}