package com.example.homeactivity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar

class ListCategoryActivity : AppCompatActivity() {

    private val categoryList = listOf(
        Category(1, "Elektronik", "Perangkat keras, gadget, dan peralatan listrik.", 25),
        Category(2, "Furniture", "Meja, kursi, lemari, dan perlengkapan kantor.", 12),
        Category(3, "Aksesoris", "Komponen pendukung dan hiasan peralatan.", 40),
        Category(4, "Software", "Lisensi aplikasi dan sistem operasi.", 8),
        Category(5, "Stationery", "Alat tulis kantor dan perlengkapan administrasi.", 50)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_category)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val rvCategories = findViewById<RecyclerView>(R.id.rvCategories)
        rvCategories.layoutManager = LinearLayoutManager(this)

        val adapter = CategoryAdapter(categoryList) { category ->
            Toast.makeText(this, "Kategori: ${category.name}", Toast.LENGTH_SHORT).show()
        }
        rvCategories.adapter = adapter
    }
}
