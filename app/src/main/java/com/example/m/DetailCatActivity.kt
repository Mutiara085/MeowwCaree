package com.example.m

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.m.data.CatData
import com.example.m.databinding.ActivityDetailCatBinding
import com.example.m.model.Cat

class DetailCatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailCatBinding
    private var currentCat: Cat? = null

    companion object {
        const val EXTRA_CAT_ID = "EXTRA_CAT_ID"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailCatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.detailMain) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val catId = intent.getIntExtra(EXTRA_CAT_ID, 1)
        currentCat = CatData.getCatById(catId)

        currentCat?.let { cat ->
            binding.ivDetailCat.setImageResource(cat.imageResId)
            binding.tvDetailName.text = cat.name
            binding.tvDetailBreed.text = cat.breed
            binding.tvAgeValue.text = cat.age
            binding.tvGenderValue.text = cat.gender
            binding.tvConditionValue.text = cat.condition
            binding.tvAboutTitle.text = "Tentang ${cat.name}"
            binding.tvAboutDesc.text = cat.description

            updateFavoriteIcon(cat.isFavorite)

            binding.ibFavorite.setOnClickListener {
                cat.isFavorite = !cat.isFavorite
                updateFavoriteIcon(cat.isFavorite)
            }
        }

        binding.ibBack.setOnClickListener {
            finish()
        }

        binding.btnAdoptNow.setOnClickListener {
            val intent = Intent(this, AdoptionFormActivity::class.java).apply {
                putExtra(EXTRA_CAT_ID, catId)
            }
            startActivity(intent)
        }
    }

    private fun updateFavoriteIcon(isFavorite: Boolean) {
        val iconRes = if (isFavorite) R.drawable.ic_heart_filled else R.drawable.ic_heart_outline
        binding.ibFavorite.setImageResource(iconRes)
    }
}