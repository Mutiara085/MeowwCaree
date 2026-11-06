# 🐱 MeowCare - Aplikasi Adopsi Kucing

**MeowCare** (*Adopt • Love • Care*) adalah aplikasi Android berbasis Kotlin yang dirancang untuk memfasilitasi proses adopsi kucing domestik secara mudah, interaktif, dan intuitif. Aplikasi ini dilengkapi dengan fitur pencarian real-time, manajemen favorit, tampilan detail kucing, serta alur pengajuan adopsi yang interaktif.

---

## 📸 Tampilan Tampilan Utama

| Beranda (List Kucing) | Detail Kucing | Pengajuan Adopsi | Pengajuan Berhasil |
| :---: | :---: | :---: | :---: |
| Tampilan daftar kucing dengan search bar & bottom navigation | Informasi lengkap usia, gender, kondisi, dan tombol adopsi | Konfirmasi sebelum mengajukan adopsi | Tampilan konfirmasi sukses pengajuan adopsi |

---

## ✨ Fitur Utama

- 🔍 **Pencarian Real-Time (Search Bar):** Cari kucing berdasarkan nama atau ras kucing secara cepat dengan mekanisme *debouncing*.
- 📋 **Daftar Kucing (Card Item):** Menampilkan foto, nama, jenis kelamin, usia, dan tombol detail.
- 📄 **Detail Kucing:** Informasi spesifik mengenai usia, kelamin, kondisi kesehatan, dan cerita/tentang kucing.
- ❤️ **Manajemen Favorit:** Tandai kucing impian sebagai favorit dan lihat daftarnya melalui tab Favorit.
- 📝 **Alur Pengajuan Adopsi:** Alur konfirmasi pengajuan adopsi hingga layar konfirmasi sukses.
- 🧭 **Bottom Navigation Bar:** Navigasi mudah antar halaman Beranda, Favorit, dan Informasi Aplikasi.

---

## 🛠️ Teknologi & Fitur Teknis

- **Bahasa Pemrograman:** Kotlin
- **UI Framework:** Android View System (XML Layouts, Material Design 3)
- **Arsitektur Layout:** ConstraintLayout, MaterialCardView, ShapeableImageView
- **Daftar & Performa:** `RecyclerView` + `ListAdapter` + `DiffUtil` (efisiensi rendering)
- **View Binding:** Digunakan di seluruh Activity & Adapter untuk *type-safe view access*
- **Penanganan Inset:** `Edge-To-Edge` & `WindowInsetsCompat` untuk tampilan modern tanpa bezel

---

## 📁 Struktur Proyek

```
app/src/main/
├── java/com/example/m/
│   ├── adapter/
│   │   └── CatAdapter.kt            # Adapter RecyclerView dengan DiffUtil
│   ├── data/
│   │   └── CatData.kt               # Repository data dummy kucing
│   ├── model/
│   │   └── Cat.kt                   # Data Model Kucing
│   ├── util/
│   │   └── SingleClickListener.kt   # Guard pencegah double-click
│   ├── MainActivity.kt              # Halaman Beranda (List & Navigation)
│   ├── DetailCatActivity.kt         # Halaman Detail Kucing
│   ├── AdoptionFormActivity.kt      # Halaman Form Konfirmasi Adopsi
│   └── SuccessActivity.kt           # Halaman Pengajuan Berhasil
└── res/
    ├── drawable/                    # Ilustrasi Vector & Icon
    ├── layout/                      # Layout XML Halaman & Card
    ├── menu/                        # Bottom Navigation Menu
    └── values/                      # Colors, Strings, & Themes
```

---

## 🚀 Cara Menjalankan Aplikasi

1. **Clone/Buka Proyek:**
   Buka folder proyek ini di **Android Studio**.
2. **Gradle Sync:**
   Lakukan *Sync Project with Gradle Files* untuk mengunduh dependensi dan me-generate *ViewBinding*.
3. **Run Application:**
   Pilih emulator (minimal API 24 / Android 7.0) atau perangkat fisik Android, lalu klik **Run 'app'** (`Shift + F10`).

---

## 📄 Lisensi

Proyek ini dikembangkan untuk keperluan demonstrasi dan pembelajaran pengembangan aplikasi Android native dengan Kotlin.
