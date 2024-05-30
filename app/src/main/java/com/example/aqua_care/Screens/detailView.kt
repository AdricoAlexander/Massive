package com.example.aqua_care.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aqua_care.Data.opensansextrabold
import com.example.aqua_care.Data.opensanssemibold
import com.example.aqua_care.Data.opensanstext
import com.example.aqua_care.Data.topdetailBar
import com.example.aqua_care.Navigation.navScreen
import com.example.aqua_care.R

@Composable
fun detailBerita(
    modifier: Modifier = Modifier,
    navController: NavController
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
    ){
        Column(
             modifier
                .fillMaxSize()
        ){
            topdetailBar(navController = navController, onItemclicked = {
                navController.navigate(navScreen.homePage.route)
            })
            Column(
                modifier
                    .fillMaxSize()
                    .padding(20.dp)
                    .verticalScroll(rememberScrollState())
            ){
                opensanstext(
                    text = "Purwakarta Perkuat Posisi sebagai \n" +
                            "daerah penghasil ikan air tawar.",
                    size = 16.sp,
                    fontFamily = opensansextrabold,
                    onItemclicked = {  },
                    color = Color(0xFF424373)
                )
                Spacer(modifier.height(31.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.berita_1),
                    contentDescription = null,
                    modifier
                        .fillMaxWidth()
                )
                Spacer(modifier.height(15.dp)
                )
                opensanstext(
                    text = "Elshinta.com - Pemerintah Kabupaten Purwakarta, Jabar, memperkuat posisinya sebagai salah satu daerah penghasil ikan air tawar di Provinsi Jawa Barat menyusul terbukanya peluang pasar ikan air tawar di tingkat nasional.",
                    size = 8.sp,
                    fontFamily = opensanssemibold,
                    onItemclicked = {  },
                    color = Color(0xFF111111)
                )
                Spacer(modifier.height(15.dp)
                )
                opensanstext(
                    text = "\u2028\"Kami terus mendorong peningkatan produksi budidaya perikanan air tawar. Penjabat (Pj) Bupati Purwakarta Benni Irwan juga meminta agar posisi Purwakarta sebagai penghasil utama ikan air tawar di Jawa Barat terus diperkuat,\" kata Kepala Dinas Komunikasi dan Informatika Purwakarta Rudi Hartono, di Purwakarta, Kamis.\u2028Ia menyampaikan posisi Purwakarta sebagai salah satu daerah utama penghasil ikan air tawar di Jawa Barat ditopang dengan keberadaan budidaya ikan air tawar di Waduk Jatiluhur dan Cirata. Menurut dia, produksi ikan air tawar di daerahnya harus dipertahankan dan jika perlu ditingkatkan. Sebab masih terbuka peluang pasar ikan air tawar secara nasional.",
                    size = 8.sp,
                    fontFamily = opensanssemibold,
                    onItemclicked = {  },
                    color = Color(0xFF111111)
                )
                Spacer(modifier.height(15.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.berita_5),
                    contentDescription = null
                )
                Spacer(modifier.height(15.dp)
                )
                opensanstext(
                    text = "Sementara itu, Kepala Dinas Peternakan dan Perikanan Purwakarta, Siti Ida Hamidah mengatakan, sejumlah langkah telah disiapkan agar Purwakarta mampu memperkuat posisinya sebagai daerah penghasil utama ikan air tawar di Jawa Barat. Langkah-langkah yang dilakukan di antaranya dengan melakukan pembinaan dan pelatihan secara intensif para pelaku usaha dan petani ikan air tawar.",
                    size = 8.sp,
                    fontFamily = opensanssemibold,
                    onItemclicked = {  },
                    color = Color(0xFF111111)
                )
                Spacer(modifier.height(15.dp)
                )
                opensanstext(
                    text = "\u2028Ia menyebutkan, saat ini kapasitas produksi ikan air tawar Purwakarta mencapai 108.475 ribu ton per tahun. Produksi ikan itu dihasilkan dari budidaya ikan air tawar Keramba Jaring Apung di Waduk Jatiluhur dan Waduk Cirata, budidaya Kolam Air Deras serta dari Kolam Air Tenang.\u2028Untuk budidaya perikanan Kolam Air Deras dan Kolam Air Tenang pengelolaannya tersebar di 17 kecamatan di seluruh Purwakarta.",
                    size = 8.sp,
                    fontFamily = opensanssemibold,
                    onItemclicked = {  },
                    color = Color(0xFF111111)
                )
                Spacer(modifier.height(15.dp)
                )
                opensanstext(
                    text = "\"Kedua jenis budidaya itu dikelola oleh 123 kelompok petani ikan air tawar. Kondisi ini akan kita kembangkan terus, sehingga kelompok masyarakat yang terlibat dalam budidaya ikan air tawar terus meningkat,\" katanya.\u2028Ida mengatakan, dari total produksi 108.475 ribu ton, kapasitas produksi terbesar ikan air tawar terbanyak masih dihasilkan melalui Kolam Jaring Apung Waduk Jatiluhur dan Waduk Cirata, mencapai 106.155 ribu ton. Kemudian produksi dari Kolam Air Tenang sebanyak 1.887,50 ton dan Kolam Air Deras mencapai 432,87 ton. ",
                    size = 8.sp,
                    fontFamily = opensanssemibold,
                    onItemclicked = {  },
                    color = Color(0xFF111111)
                )
            }
        }
    }
}

