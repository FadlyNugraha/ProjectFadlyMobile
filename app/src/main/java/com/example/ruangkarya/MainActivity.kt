package com.example.ruangkarya

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.ruangkarya.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            showFragment(StudioFragment())
            binding.bottomNavigation.selectedItemId = R.id.menu_studio
        }

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_studio -> showFragment(StudioFragment())
                R.id.menu_ringkasan -> showFragment(RingkasanFragment())
                R.id.menu_informasi -> showFragment(InformasiFragment())
            }
            true
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    fun bukaTabStudio() {
        binding.bottomNavigation.selectedItemId = R.id.menu_studio
    }
}
