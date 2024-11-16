package com.alyazah.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alyazah.quran.databinding.ItemSurahBinding

class SurahAdapter(private val surahs: List<Surah>) : RecyclerView.Adapter<SurahAdapter.SurahViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurahViewHolder {
        val binding = ItemSurahBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SurahViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SurahViewHolder, position: Int) {
        val surah = surahs[position]
        holder.bind(surah)
    }

    override fun getItemCount(): Int = surahs.size

    class SurahViewHolder(private val binding: ItemSurahBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(surah: Surah) {
            binding.englishName.text = surah.englishName
            binding.arabicName.text = surah.name
            binding.englishNameTranslation.text = surah.englishNameTranslation
        }
    }
}
