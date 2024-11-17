package com.alyazah.quran

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class AyahActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayah)

        val surahNumber = intent.getIntExtra("SURAH_NUMBER", 1)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewAyah)
        recyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            val quran = RetrofitInstance.retrofitService.getQuran("quran.simple")
            val surah = quran.data.surahs.find { it.number == surahNumber }

            surah?.let {
                val ayahAdapter = AyahAdapter(it.ayahs)
                recyclerView.adapter = ayahAdapter
            }
        }
    }
}
