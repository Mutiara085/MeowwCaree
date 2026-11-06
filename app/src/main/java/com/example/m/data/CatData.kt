package com.example.m.data

import com.example.m.R
import com.example.m.model.Cat

object CatData {
    val listCats = mutableListOf(
        Cat(
            id = 1,
            name = "Milo",
            breed = "Kucing Domestik",
            gender = "Jantan",
            age = "3 bulan",
            condition = "Sehat",
            description = "Milo adalah anak kucing yang aktif, manja, dan suka bermain. Ia sedang mencari keluarga baru yang penuh kasih sayang.",
            imageResId = R.drawable.img_milo
        ),
        Cat(
            id = 2,
            name = "Mochi",
            breed = "Kucing Domestik",
            gender = "Betina",
            age = "4 bulan",
            condition = "Sehat",
            description = "Mochi adalah kucing berbulu putih yang manis dan lembut. Ia memiliki karakter tenang dan senang berada di dekat manusia. Mochi cocok untuk calon pemilik yang menyukai kucing dengan sifat kalem.",
            imageResId = R.drawable.img_mochi
        ),
        Cat(
            id = 3,
            name = "Luna",
            breed = "Kucing Domestik",
            gender = "Betina",
            age = "6 bulan",
            condition = "Sehat",
            description = "Luna adalah kucing yang aktif dan penuh rasa ingin tahu. Ia senang mengeksplorasi lingkungan serta bermain dengan mainan. Luna cocok untuk pemilik yang ingin memiliki teman bermain yang ceria.",
            imageResId = R.drawable.img_luna
        ),
        Cat(
            id = 4,
            name = "Oreo",
            breed = "Kucing Domestik",
            gender = "Jantan",
            age = "3 bulan",
            condition = "Sehat",
            description = "Oreo memiliki pola bulu hitam-putih yang unik. Ia adalah anak kucing yang ramah dan suka bermain. Oreo cocok untuk calon pemilik yang menginginkan teman kecil yang aktif dan menghibur.",
            imageResId = R.drawable.img_oreo
        )
    )

    fun getCatById(id: Int): Cat? {
        return listCats.find { it.id == id }
    }
}