package com.example.aqua_care.Screens

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aqua_care.Data.aquaButton
import com.example.aqua_care.Data.datatext
import com.example.aqua_care.Data.opensansbold
import com.example.aqua_care.Data.opensanstext
import com.example.aqua_care.Navigation.navScreen
import com.example.aqua_care.R

@Composable
fun profileEdit(
    modifier: Modifier = Modifier,
    navController: NavController,
){
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.icon_backarrow),
            contentDescription = null,
            modifier = modifier
                .size(30.dp)
                .clickable {
                    navController.navigate(navScreen.profilePage.route)
                }
        )
        Spacer(modifier.height(10.dp)
        )
        opensanstext(
            text = "Pengaturan Profile",
            size = 24.sp,
            fontFamily = opensansbold,
            onItemclicked = {  },
            color = Color(0xFF272727)
        )
        Spacer(modifier.height(30.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = modifier
                .fillMaxWidth()
        ){
            Image(
                painter = painterResource(id = R.drawable.pak_sugi),
                contentDescription = null,
                modifier = modifier
                    .size(58.dp)
                    .padding(10.dp)
            )
            opensanstext(
                text = "Pasang Foto Baru",
                size = 18.sp,
                fontFamily = opensansbold,
                onItemclicked = {  },
                color = Color(0xFF272727)
            )
        }
        Spacer(modifier.height(28.dp)
        )
        opensanstext(
            text = "Nama Lengkap",
            size = 14.sp,
            fontFamily = opensansbold,
            onItemclicked = {  },
            color = Color(0xFF272727)
        )
        Spacer(modifier.height(11.dp)
        )
        datatext(
            value = "Sugiono",
            width = 352.dp,
            height = 50.dp
        )
        Spacer(modifier.height(11.dp)
        )
        opensanstext(
            text = "Username",
            size = 14.sp,
            fontFamily = opensansbold,
            onItemclicked = {  },
            color = Color(0xFF272727)
        )
        Spacer(modifier.height(11.dp)
        )
        datatext(
            value = "Sugi",
            width = 352.dp,
            height = 50.dp
        )
        Spacer(modifier.height(11.dp)
        )
        opensanstext(
            text = "Email",
            size = 14.sp,
            fontFamily = opensansbold,
            onItemclicked = {  },
            color = Color(0xFF272727)
        )
        Spacer(modifier.height(11.dp)
        )
        datatext(
            value = "Sugi123@gmail.com",
            width = 352.dp,
            height = 50.dp
        )
        Spacer(modifier.height(11.dp)
        )
        opensanstext(
            text = "Nomor Telepon",
            size = 14.sp,
            fontFamily = opensansbold,
            onItemclicked = {  },
            color = Color(0xFF272727)
        )
        Spacer(modifier.height(11.dp)
        )
        datatext(
            value = "089220651213",
            width = 352.dp,
            height = 50.dp

        )
        Spacer(modifier.height(11.dp)
        )
        opensanstext(
            text = "Alamat",
            size = 14.sp,
            fontFamily = opensansbold,
            onItemclicked = {  },
            color = Color(0xFF272727)
        )
        Spacer(modifier.height(11.dp)
        )
        datatext(
            value = "Bandung Barat Daya",
            width = 352.dp,
            height = 50.dp

        )
        Spacer(modifier.height(30.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxWidth()
        ){
            aquaButton(
                color = Color(0xFF246DBB),
                width = 264.dp,
                height = 35.dp,
                textColor = Color.White,
                text = "Simpan",
                fontFamily = opensansbold
            ){
                navController.navigate(navScreen.profilePage.route)
            }
        }
    }
}

