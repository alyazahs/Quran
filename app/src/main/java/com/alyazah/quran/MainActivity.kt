package com.alyazah.quran

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

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

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewSurah)
        recyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            val quran = RetrofitInstance.retrofitService.getQuran("quran.simple")
            val surahs = quran.data.surahs
            for (surah in surahs) {
                Log.d(
                    "Quran", "Surah: ${surah.englishName} (${surah.englishNameTranslation}) - ${surah.name}"
                )

                recyclerView.adapter = SurahAdapter(surahs)
            }
        }
    }
}