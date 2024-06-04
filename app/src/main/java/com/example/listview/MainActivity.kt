package com.example.listview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        val itemList = listOf(
            ItemList("NAHIDA", "Karakter dari game Genshin Impact. Jika ditanya apa arti keindahan, kebaikan, kebijaksanaan jawabannya adalah nahida.",
                "https://i.pinimg.com/736x/a3/00/79/a30079b832a1323affe401e0e7624c27.jpg"),
            ItemList("FIREFLY", "Karakter dari game Honkai Star Rail. Dibalik wajahnya yang lucu ada kamen rider yang siap meninju.",
                "https://i.pinimg.com/736x/fa/d2/df/fad2df92809c3a226637aad6f0dad99b.jpg"),
            ItemList("ENCORE", "Karakter dari game Wuthering Wave. Karakter imut, lucu, dan gemesin yang selalu ditemani 2 boneka domba yang menyeramkan.",
                "https://i.pinimg.com/736x/d2/39/34/d2393414d430f3f2a039246a4850408d.jpg"),
        )
        val adapter = AdapterList(itemList)
        recyclerView.adapter = adapter
    }
}