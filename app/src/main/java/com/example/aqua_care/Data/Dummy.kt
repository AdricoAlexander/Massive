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

object beritaData {
    val beritaList = listOf(
        berita(
            id = 1,
            title = "Purwakarta perkuat posisi sebagai\n" +
                    "daerah penghasil ikan air tawar.",
            image = R.drawable.berita_1,
            date = "20 Mei 2024",
            website = "Elshinta.com"

        ),
        berita(
            id = 2,
            title = "Cerita Petani Ikan Air Tawar di\n" +
                    "Halmahera.",
            image = R.drawable.berita_2,
            date = "05 Mei 2024",
            website = "Elshinta.com"

        ),
        berita(
            id = 3,
            title = "Produksi ikan air tawar Mukomuko\n" +
                    " lebih dari target tahun 2023",
            image = R.drawable.berita_3,
            date = "03 Mei 2024",
            website = "Elshinta.com"

        ),
        berita(
            id = 4,
            title = "Budi daya ikan air tawar soroti\n" +
                    " kearifan pertanian tradisional    ",
            image = R.drawable.berita_4,
            date = "02 Mei 2024",
            website = "Elshinta.com"
        ),
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