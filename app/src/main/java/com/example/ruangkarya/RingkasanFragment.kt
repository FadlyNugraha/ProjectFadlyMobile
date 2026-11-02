package com.example.ruangkarya

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.ruangkarya.databinding.FragmentRingkasanBinding

class RingkasanFragment : Fragment(R.layout.fragment_ringkasan) {
    private var _binding: FragmentRingkasanBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRingkasanBinding.bind(view)

        val termurah = DataStudio.daftar.minByOrNull { it.tarif }!!
        val termahal = DataStudio.daftar.maxByOrNull { it.tarif }!!

        binding.tvNamaTermurah.text = termurah.nama
        binding.tvTarifTermurah.text = "${formatRupiah(termurah.tarif)} / jam"
        binding.tvNamaTermahal.text = termahal.nama
        binding.tvTarifTermahal.text = "${formatRupiah(termahal.tarif)} / jam"

        binding.btnLihatDaftar.setOnClickListener {
            (activity as? MainActivity)?.bukaTabStudio()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
