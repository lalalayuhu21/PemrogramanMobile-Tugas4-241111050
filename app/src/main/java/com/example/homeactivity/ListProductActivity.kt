package com.example.homeactivity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar

class ListProductActivity : AppCompatActivity() {

    private val productList = listOf(
        Product(1, "Laptop ASUS ROG", "Elektronik", 5, 15000000.0),
        Product(2, "Smartphone Samsung S23", "Elektronik", 10, 12000000.0),
        Product(3, "Meja Kerja Minimalis", "Furniture", 15, 750000.0),
        Product(4, "Kursi Gaming Secretlab", "Furniture", 8, 5000000.0),
        Product(5, "Headset Sony WH-1000XM5", "Aksesoris", 12, 4500000.0),
        Product(6, "Mouse Logitech G Pro", "Aksesoris", 20, 1500000.0),
        Product(7, "Monitor Dell Ultrasharp", "Elektronik", 7, 6000000.0)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_product)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val rvProducts = findViewById<RecyclerView>(R.id.rvProducts)
        rvProducts.layoutManager = LinearLayoutManager(this)
        
        val adapter = ProductAdapter(productList) { product ->
            Toast.makeText(this, "Detail: ${product.name}", Toast.LENGTH_SHORT).show()
        }
        rvProducts.adapter = adapter
    }
}
