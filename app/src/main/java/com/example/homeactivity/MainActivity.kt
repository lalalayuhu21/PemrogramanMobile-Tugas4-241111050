package com.example.homeactivity

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvUsername = findViewById<TextView>(R.id.tvUsername)
        val username = intent.getStringExtra("username") ?: "Irfan"
        tvUsername.text = username

        val cardProduk = findViewById<CardView>(R.id.cardProduk)
        cardProduk.setOnClickListener {
            val intent = Intent(this, ListProductActivity::class.java)
            startActivity(intent)
        }

        // Adding another menu for "Categories" as required (minimal 2 list activities)
        val cardCategory = findViewById<CardView>(R.id.cardCategory)
        cardCategory.setOnClickListener {
            val intent = Intent(this, ListCategoryActivity::class.java)
            startActivity(intent)
        }
    }
}
