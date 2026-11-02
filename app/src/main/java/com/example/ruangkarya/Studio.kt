package com.example.ruangkarya

data class Studio(
    val id: Int,
    val nama: String,
    val fasilitas: String,
    val kapasitas: String,
    val deskripsi: String,
    val tarif: Int
)

object DataStudio {
    val daftar = listOf(
        Studio(1, "Studio Vokal", "Mikrofon", "4 orang",
            "Ruang rekaman suara dengan peredam.", 65000),
        Studio(2, "Studio Foto", "Lampu", "6 orang",
            "Ruang foto dengan pencahayaan dasar.", 95000),
        Studio(3, "Studio Animasi", "Pen tablet", "3 orang",
            "Ruang produksi animasi digital.", 85000),
        Studio(4, "Studio Podcast", "Mixer", "4 orang",
            "Ruang diskusi dengan perangkat audio.", 75000),
        Studio(5, "Studio Tari", "Cermin", "8 orang",
            "Ruang latihan gerak dengan cermin lebar.", 55000)
    )
}

fun formatRupiah(nilai: Int): String {
    return "Rp" + "%,d".format(nilai).replace(',', '.')
}
