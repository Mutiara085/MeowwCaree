package com.example.m

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.m.adapter.CatAdapter
import com.example.m.data.CatData
import com.example.m.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var catAdapter: CatAdapter
    private val searchHandler = Handler(Looper.getMainLooper())
    private var searchRunnable: Runnable? = null
    private var currentQuery: String = ""
    private var isFavoriteMode: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        setupRecyclerView()
        setupSearch()
        setupBottomNavigation()
    }

    override fun onResume() {
        super.onResume()
        filterList(currentQuery)
    }

    private fun setupRecyclerView() {
        catAdapter = CatAdapter { selectedCat ->
            val intent = Intent(this, DetailCatActivity::class.java).apply {
                putExtra(DetailCatActivity.EXTRA_CAT_ID, selectedCat.id)
            }
            startActivity(intent)
        }

        binding.rvCats.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = catAdapter
            setHasFixedSize(true)
        }

        filterList("")
    }

    private fun setupSearch() {
        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                searchRunnable?.let { searchHandler.removeCallbacks(it) }
                searchRunnable = Runnable {
                    currentQuery = s?.toString()?.trim() ?: ""
                    filterList(currentQuery)
                }
                searchHandler.postDelayed(searchRunnable!!, 200)
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    isFavoriteMode = false
                    binding.tvMainTitle.text = "Meet Our Cats"
                    binding.tvMainSubtitle.text = "Find your purrfect friend 🐾"
                    filterList(currentQuery)
                    true
                }
                R.id.nav_favorite -> {
                    isFavoriteMode = true
                    binding.tvMainTitle.text = "Kucing Favorit"
                    binding.tvMainSubtitle.text = "Kucing impian yang Anda sukai 💖"
                    filterList(currentQuery)
                    true
                }
                R.id.nav_about -> {
                    showAboutDialog()
                    false
                }
                else -> false
            }
        }
    }

    private fun filterList(query: String) {
        var baseList = if (isFavoriteMode) {
            CatData.listCats.filter { it.isFavorite }
        } else {
            CatData.listCats
        }

        if (query.isNotEmpty()) {
            baseList = baseList.filter {
                it.name.contains(query, ignoreCase = true) ||
                        it.breed.contains(query, ignoreCase = true)
            }
        }

        catAdapter.submitList(baseList.toList()) {
            if (baseList.isEmpty()) {
                binding.tvEmpty.text = if (isFavoriteMode) {
                    "Belum ada kucing favorit 🐾"
                } else {
                    "Kucing tidak ditemukan 🐾"
                }
                binding.tvEmpty.visibility = View.VISIBLE
                binding.rvCats.visibility = View.GONE
            } else {
                binding.tvEmpty.visibility = View.GONE
                binding.rvCats.visibility = View.VISIBLE
            }
        }
    }

    private fun showAboutDialog() {
        AlertDialog.Builder(this)
            .setTitle("🐱 Tentang MeowCare")
            .setMessage("MeowCare v1.0\nAdopt • Love • Care\n\nAplikasi adopsi kucing untuk membantu kucing domestik menemukan rumah baru yang penuh kasih sayang.")
            .setPositiveButton("Tutup", null)
            .show()
    }

    override fun onDestroy() {
        super.onDestroy()
        searchRunnable?.let { searchHandler.removeCallbacks(it) }
    }
}