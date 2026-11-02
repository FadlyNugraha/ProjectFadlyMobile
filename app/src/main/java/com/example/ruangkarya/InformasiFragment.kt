package com.example.ruangkarya

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.ruangkarya.databinding.FragmentInformasiBinding
import com.google.android.material.snackbar.Snackbar

class InformasiFragment : Fragment(R.layout.fragment_informasi) {
    private var _binding: FragmentInformasiBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentInformasiBinding.bind(view)

        binding.btnHubungiAdmin.setOnClickListener {
            Snackbar.make(
                binding.root,
                "Silakan hubungi Admin RuangKarya.",
                Snackbar.LENGTH_LONG
            ).setAction("OK") { }.show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
