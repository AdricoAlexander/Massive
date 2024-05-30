package com.example.aqua_care.Screens

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.aqua_care.Data.aquaButton
import com.example.aqua_care.Data.aquatextfield
import com.example.aqua_care.Data.opensansbold
import com.example.aqua_care.Data.opensanslight
import com.example.aqua_care.Data.opensansregular
import com.example.aqua_care.Data.opensanstext
import com.example.aqua_care.Navigation.navScreen
import com.example.aqua_care.R

@Composable
fun signupPage(modifier: Modifier = Modifier, navController: NavController) {
    var text by remember { mutableStateOf("") }
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
    ){
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(20.dp)
        ){
            Spacer(modifier.height(40.dp)
            )
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = modifier
                    .fillMaxWidth()
            ){
                Image(
                    painter = painterResource(id = R.drawable.logo_blue),
                    contentDescription = "Logo",
                    Modifier
                        .size(50.dp)
                )
                Spacer(modifier.width(15.dp)
                )
                Column (
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceAround,
                    modifier = modifier
                ){
                    opensanstext(
                        text = "Aqua Care",
                        size = 18.sp,
                        fontFamily = opensansbold,
                        color = Color(0xFF272727),
                        onItemclicked = null
                    )
                    opensanstext(
                        text = "Air Bersih, Ikan Sehat, Sukses Terjaga",
                        size = 13.sp,
                        fontFamily = opensansregular,
                        color = Color(0xFF272727),
                        onItemclicked = null
                    )
                }
                Spacer(modifier.width(15.dp)
                )
            }
            Spacer(modifier.height(30.dp)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = modifier
                    .fillMaxSize()
            ) {
                opensanstext(
                    text = "Buat Akun",
                    size = 18.sp,
                    fontFamily = opensansbold,
                    color = Color(0xFF272727),
                    onItemclicked = null
                )
                Spacer(
                    modifier.height(20.dp)
                )
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top,
                    modifier = modifier
                        .padding(20.dp)
                ) {
                    opensanstext(
                        text = "Nama",
                        size = 14.sp,
                        fontFamily = opensansbold,
                        color = Color(0xFF272727),
                        onItemclicked = null
                    )
                    aquatextfield(
                        label = "Masukkan Nama",
                        image = painterResource(id = R.drawable.icon_person),
                        width = 313.dp,
                        height = 60.dp,
                        imageSize = 16.81.dp,
                        font = opensansregular,
                        fontSize = 12.sp,
                        text = text,
                        onChange = {
                            text = it
                        }
                    )
                    Spacer(
                        modifier.height(10.dp)
                    )
                    opensanstext(
                        text = "Email",
                        size = 14.sp,
                        fontFamily = opensansbold,
                        color = Color(0xFF272727),
                        onItemclicked = null
                    )
                    aquatextfield(
                        label = "Masukkan Email",
                        image = painterResource(id = R.drawable.icon_email),
                        width = 313.dp,
                        height = 60.dp,
                        imageSize = 16.81.dp,
                        font = opensansregular,
                        fontSize = 12.sp,
                        text = text,
                        onChange = {
                            text = it
                        }
                    )
                    Spacer(
                        modifier.height(10.dp)
                    )
                    opensanstext(
                        text = "Password",
                        size = 14.sp,
                        fontFamily = opensansbold,
                        color = Color(0xFF272727),
                        onItemclicked = null
                    )
                    aquatextfield(
                        label = "Masukkan Password",
                        image = painterResource(id = R.drawable.icon_locked),
                        width = 313.dp,
                        height = 60.dp,
                        imageSize = 16.81.dp,
                        font = opensansregular,
                        fontSize = 12.sp,
                        text = text,
                        onChange = {
                            text = it
                        }
                    )
                    Spacer(
                        modifier.height(10.dp)
                    )
                    opensanstext(
                        text = "Konfirmasi Password",
                        size = 14.sp,
                        fontFamily = opensansbold,
                        color = Color(0xFF272727),
                        onItemclicked = null
                    )
                    aquatextfield(
                        label = "Masukkan Ulang Password",
                        image = painterResource(id = R.drawable.icon_locked),
                        width = 313.dp,
                        height = 60.dp,
                        imageSize = 16.81.dp,
                        font = opensansregular,
                        fontSize = 12.sp,
                        text = text,
                        onChange = {
                            text = it
                        }
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Checkbox(
                        checked = false,
                        onCheckedChange = null,
                        modifier = modifier
                            .scale(0.5f)
                    )
                    opensanstext(
                        text = "Saya Menyetujui Syarat & Ketentuan",
                        size = 10.sp,
                        fontFamily = opensanslight,
                        color = Color(0xFF272727),
                        onItemclicked = null
                    )
                }
                Spacer(
                    modifier.height(10.dp)
                )
                aquaButton(
                    color = Color(0xFF246DBB),
                    width = 264.dp,
                    height = 35.dp,
                    text = "Daftar",
                    fontFamily = opensansbold,
                    textColor = Color.White
                ) {
                    navController.navigate(navScreen.loginPage.route)
                }
                Spacer(
                    modifier.height(10.dp)
                )
                opensanstext(
                    text = "Atau Daftar Dengan",
                    size = 10.sp,
                    fontFamily = opensansregular,
                    color = Color(0xFF272727),
                    onItemclicked = null
                )
                Spacer(
                    modifier.height(10.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.icon_google),
                    contentDescription = null,
                )
                Spacer(
                    modifier.height(10.dp)
                )
                Row (
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier
                        .fillMaxWidth()
                ){
                    opensanstext(
                        text = "Sudah Punya Akun?",
                        size = 10.sp,
                        fontFamily = opensansregular,
                        color = Color(0xFF272727),
                        onItemclicked = null
                    )
                    Spacer(modifier.width(10.dp))
                    opensanstext(
                        text = "Masuk",
                        size = 10.sp,
                        fontFamily = opensansregular,
                        color = Color(0xFF246DBB),
                        onItemclicked = { navController.navigate(navScreen.loginPage.route) }
                    )
                }
            }
        }
    }
}


