package com.example.ruangkarya

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.ruangkarya.databinding.ItemStudioBinding

class StudioAdapter(
    private val context: Context,
    private val data: List<Studio>
) : BaseAdapter() {

    override fun getCount(): Int = data.size
    override fun getItem(position: Int): Studio = data[position]
    override fun getItemId(position: Int): Long = data[position].id.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = if (convertView == null) {
            ItemStudioBinding.inflate(LayoutInflater.from(context), parent, false)
        } else {
            ItemStudioBinding.bind(convertView)
        }

        val studio = getItem(position)
        binding.tvNamaStudio.text = studio.nama
        binding.tvFasilitas.text = "Fasilitas: ${studio.fasilitas} • ${studio.kapasitas}"
        binding.tvTarif.text = "${formatRupiah(studio.tarif)} / jam"
        return binding.root
    }
}
