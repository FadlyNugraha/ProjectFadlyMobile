package com.example.ruangkarya

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.ruangkarya.databinding.FragmentStudioBinding
import com.google.android.material.snackbar.Snackbar

class StudioFragment : Fragment(R.layout.fragment_studio) {
    private var _binding: FragmentStudioBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentStudioBinding.bind(view)

        val adapter = StudioAdapter(requireContext(), DataStudio.daftar)
        binding.listStudio.adapter = adapter

        binding.listStudio.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                val studio = DataStudio.daftar[position]
                Toast.makeText(
                    requireContext(),
                    "${studio.nama} - ${formatRupiah(studio.tarif)} / jam",
                    Toast.LENGTH_SHORT
                ).show()
            }

        binding.listStudio.setOnItemLongClickListener { itemView, _, position, _ ->
            val studio = DataStudio.daftar[position]
            Snackbar.make(itemView, "${studio.nama} dipilih", Snackbar.LENGTH_LONG)
                .setAction("BATAL") { }
                .show()
            true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
