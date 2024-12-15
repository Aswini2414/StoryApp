package com.app.storyapp

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.squareup.picasso.Picasso

class Details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val sTitle = intent.getStringExtra("storyTitle")
        val sContent = intent.getStringExtra("storyContent")
        val sImage = intent.getStringExtra("storyImage")
        //val toolbar = findViewById<Toolbar>(R.id.tbHeader)

        //setSupportActionBar(toolbar)

        supportActionBar?.title = sTitle
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val storyImage = findViewById<ImageView>(R.id.ivStoryImage)
        Picasso.get().load(sImage).into(storyImage)
        val storyDetails = findViewById<TextView>(R.id.tvStoryDetails)
        storyDetails.text = sContent
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}