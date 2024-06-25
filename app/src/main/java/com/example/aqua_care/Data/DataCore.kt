package com.example.aqua_care.Data

import com.example.aqua_care.R

object modulData {
    val modulList = listOf(
        menuModul(
            id = 1,
            title = "AquaModul",
            description = "Meningkatkan Kesejahteraan\n" +
                    "Ikan Air Tawar Melalui \n" +
                    "AquaModul !"
        ),
        menuModul(
            id = 2,
            title = "AquaSentry",
            description = "Optimalkan kualitas Ikan \n" +
                    "Air tawar dengan penjadwalan\n" +
                    "Otomotasi"
        ),
        menuModul(
            id = 3,
            title = "AquaScan",
            description = "Pindai kesehatan Ikan Air Tawar\n" +
                    "Melalui AquaScan"
        ),
        menuModul(
            id = 4,
            title = "AquaBot",
            description = "Diskusikan Permasalahan \n" +
                    "pertambakan melalui AquaBot"
        )
    )
}

object premiumData {
    val premiumList =
        listOf(
            premium(
                id = 1,
                title = "Standar",
                price = "29.000",
                length = "1 Bulan"
            ),
            premium(
                id = 2,
                title = "Super",
                price = "90.000",
                length = "6 Bulan"
            ),
            premium(
                id = 3,
                title = "Combo",
                price = "179.000",
                length = "12 Bulan"
            )
        )
}

object aquamodulData {
    val modulList = listOf(
        Modul(
            id = 1,
            title = "Perawatan serta Manajemen dasar budidaya Ikan !",
            video = listOf(
                Video(
                    id = 1,
                    title = "Solusi Cerdas untuk Manajemen Perikanan",
                    link = "https://firebasestorage.googleapis.com/v0/b/aqua-care.appspot.com/o/Aqua%20Care%20Solusi%20Cerdas%20untuk%20Manajemen%20Perikanan%20Modern.mp4?alt=media&token=0e2166c7-3303-4a94-b749-f117dbcc6408"

                ),
                Video(
                    id = 2,
                    title = "Cara Menjaga Kualitas Air Kolam Ikan Lele",
                    link = "https://firebasestorage.googleapis.com/v0/b/aqua-care.appspot.com/o/Aqua%20Care%20Jaga%20Kualitas%20Air%20Kolam%20Ikan%20Lele.mp4?alt=media&token=8d032f61-af33-4142-8654-b884a95fa878"
                )
            ),
            description = "Modul ini membantu para pembudidaya dalam \n" +
                    "\"Menjaga kualitas Air kolam ikan Lele agar panen\n" +
                    "\"yang dihasilkan lebih berkualitas !",
            image = R.drawable.image_example,
            videoamount = "2 Video",
            writtername = "Adrico Alexander",
            profilepic = R.drawable.alex_ganten
        ),
        Modul(
            id = 2,
            title = "Tata Cara Perawatan Ikan untuk Budidaya",
            video = listOf(
                Video(
                    id = 1,
                    title = "Cara Merawat Kolam Ikan Air Tawar",
                    link = "https://firebasestorage.googleapis.com/v0/b/aqua-care.appspot.com/o/CARA%20MERAWAT%20AIR%20KOLAM%20LELE%20-%20MENJAGA%20KUALITAS%20AIR%20LELE.mp4?alt=media&token=c55ee801-dcf0-41d1-bcd0-89eb9b1b8a6b",
                ),
                Video(
                    id = 2,
                    title = "Cara Sukses Budidaya Pembenihan Lele",
                    link = "https://firebasestorage.googleapis.com/v0/b/aqua-care.appspot.com/o/CARA%20SUKSES%20BUDIDAYA%20PEMBENIHAN%20LELE%20UNTUK%20PEMULA%20-%20PEMIJAHAN%20LELE%20ALAMI.mp4?alt=media&token=5064ca53-3ea5-4e2c-8980-a46cb2ecab78"
                ),
                Video(
                    id = 3,
                    title = "Sukses Atasi Benih Lele Mengagtung",
                    link = "https://firebasestorage.googleapis.com/v0/b/aqua-care.appspot.com/o/SUKSES%20ATASI%20BENIH%20LELE%20MENGAGTUNG%20DENGAN%20CEPAT.mp4?alt=media&token=3d6dc427-2941-4598-b264-9a0810beefb5"
                )
            ),
            description = "kolam lele, K sahabat kali ini saya akan memberikan cara merawat air kolam lele agar airnya sehat tetab hijau dan bebas dari bau\n" +
                    "Naha untuk cara mengatasinya sendiri itu caranya sangat mudah yah jadi kalo mau air kolam lele kita tetap sehat bebas dari bau pertama jangan menebar bibit yang berlebihan 2 jangan memberi makan yang berlebihan 3 harus sering menguras air dasar kolam agar sisa sia pakan yang mengendap di dasar kolam itu hilang 4 setelah air kolam di kuras kita harus menambah probiotik untuk menetralkan airnya lagi ",
            image = R.drawable.image_example_2,
            videoamount = "3 Video",
            writtername = "SIKUMIS",
            profilepic = R.drawable.sikumis_foto
        ),
        Modul(
            id = 3,
            title = "Pengetahuan Dasar Pertambakan",
            video = listOf(
                Video(
                    id = 1,
                    title = "Cara Mencegah Penyakit Menyerang Ternak Nila",
                    link = "https://firebasestorage.googleapis.com/v0/b/aqua-care.appspot.com/o/CARA%20MENCEGAH%20PENYAKIT%20MENYERANG%20TERNAK%20IKAN%20NILA.mp4?alt=media&token=4c6238db-d2e4-4b54-aef8-ef85f7845be6"
                ),
                Video(
                    id = 2,
                    title = "Penyebab Kegagalan Budidaya Ikan Nila Waspada",
                    link = "https://firebasestorage.googleapis.com/v0/b/aqua-care.appspot.com/o/PENYEBAB%20KEGAGALAN%20BUDIDAYA%20IKAN%20NILA%20WASPADA%20BIBIT%20NILA%20MATI%20SETIAP%20HARI.mp4?alt=media&token=553a3e62-266c-4fc9-9021-cfa057e5a0a9"
                )
            ),
            description = "membahas tentang berbagai macam teknik budidaya, pertanian, peternakan, perikanan serta tips dan trik jitu untuk mendapatkan ide bisnis dan peluang usaha.\n" +
                    "\n" +
                    "DISCLAIMER: Semua informasi, metode, tips dan trik yang disajikan belum tentu memberikan hasil yang sama karena ada banyak faktor yang mempengaruhi aktivitas budidaya, peternakan atau pertanian",
            videoamount = "2 Video",
            image = R.drawable.premiumimage_2,
            writtername = "Hasil Daya",
            profilepic = R.drawable.hasildaya_foto
        )
    )
}