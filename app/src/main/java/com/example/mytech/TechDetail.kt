package com.example.mytech

import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TechDetail : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val name = "name"
        const val detail = "detail"
        const val photo = "photo"
        const val price = "price"
        const val garansi = "garansi"
        const val titledetail = "title"
        const val cicilan = "cicilan"
        const val link = "link"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_row_techdetail)

        //retrieving data
        val nameReceiver: TextView = findViewById(R.id.detail_name)
        val detailReceiver: TextView = findViewById(R.id.detail_detail)
        val photoReceiver: ImageView = findViewById(R.id.img_item_photo_detail)
        val priceReceiver: TextView = findViewById(R.id.detail_harga)
        val garansiReceiver: TextView = findViewById(R.id.detail_garansi)
        val cicilanReceiver: TextView = findViewById(R.id.detail_cicilan)


        val nameIntent = intent.getStringExtra(name)
        val detailIntent = intent.getStringExtra(detail)
        val photoIntent = intent.getIntExtra(photo, 0)
        val priceIntent = intent.getStringExtra(price)
        val garansiIntent = intent.getStringExtra(garansi)
        val title = intent.getStringExtra(titledetail)
        val cicilanIntent = intent.getStringExtra(cicilan)
        val linkIntent = intent.getStringExtra(link)


        nameReceiver.text = nameIntent.toString()
        detailReceiver.text = detailIntent.toString()
        priceReceiver.text = priceIntent.toString()
        photoReceiver.setImageResource(photoIntent)
        garansiReceiver.text = garansiIntent.toString()
        cicilanReceiver.text = cicilanIntent.toString()


//        title?.let { setActionBarTitle(it) }
        if (title != null) {
            setActionBarTitle(title)
        }

        val linButton: Button = findViewById(R.id.webBrowse)
        linButton.setOnClickListener(this)

    }

    private fun setActionBarTitle(title: String) {
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


    override fun onClick(v: View?) {
        val linkIntent = intent.getStringExtra(link)
        when (v?.id) {
            R.id.webBrowse -> {
                val link = linkIntent
                val browse = Intent(Intent.ACTION_VIEW, Uri.parse(link))
                startActivity(browse)
            }
        }
    }

}

