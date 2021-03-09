package com.example.mytech

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TechDetail : AppCompatActivity() {

    companion object {
        const val name = "name"
        const val detail = "detail"
        const val photo = "photo"
        const val price = "price"
        const val titledetail = "title"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_row_techdetail)

        //retrieving data
        val nameReceiver: TextView = findViewById(R.id.detail_name)
        val detailReceiver: TextView = findViewById(R.id.detail_detail)
        val photoReceiver: ImageView = findViewById(R.id.img_item_photo_detail)
        val priceReceiver: TextView = findViewById(R.id.detail_harga)


        val nameIntent = intent.getStringExtra(name)
        val detailIntent = intent.getStringExtra(detail)
        val photoIntent = intent.getIntExtra(photo,0)
        val priceIntent = intent.getStringExtra(price)
        val title = intent.getStringExtra(titledetail)


        nameReceiver.text = nameIntent.toString()
        detailReceiver.text = detailIntent.toString()
        priceReceiver.text = priceIntent.toString()
        photoReceiver.setImageResource(photoIntent)



//        title?.let { setActionBarTitle(it) }
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

