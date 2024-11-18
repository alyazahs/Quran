package com.alyazah.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alyazah.quran.databinding.ItemAyahBinding

class AyahAdapter(private val ayahs: List<Ayah>) : RecyclerView.Adapter<AyahAdapter.AyahViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AyahViewHolder {
        val binding = ItemAyahBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AyahViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AyahViewHolder, position: Int) {
        val ayah = ayahs[position]
        holder.bind(ayah)
    }

    override fun getItemCount(): Int = ayahs.size

    class AyahViewHolder(private val binding: ItemAyahBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(ayah: Ayah) {
            binding.ayahText.text = ayah.text
        }
    }
}