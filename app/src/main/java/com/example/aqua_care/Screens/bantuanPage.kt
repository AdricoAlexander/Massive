package com.example.aqua_care.Screens

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aqua_care.Data.opensansbold
import com.example.aqua_care.Data.opensansregular
import com.example.aqua_care.Data.opensanstext
import com.example.aqua_care.Navigation.navScreen
import com.example.aqua_care.R

@Composable
fun bantuanPage(
    modifier: Modifier = Modifier,
    navController: NavController
){
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ){
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 20.dp)
                .height(67.dp)
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = modifier
                    .fillMaxWidth()
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
                Spacer(modifier.width(28.dp)
                )
                opensanstext(
                    text = "Bantuan",
                    size = 18.sp,
                    fontFamily = opensansbold,
                    onItemclicked = {  },
                    color = Color(0xFF272727)
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.topline),
            contentDescription = null
        )
        Spacer(modifier.height(16.dp)
        )
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(20.dp)
        ){
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier
                    .fillMaxWidth()
            ){
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,
                    modifier = modifier
                        .fillMaxWidth()
                ){
                    opensanstext(
                        text = "Ada Masalah dan Memerlukan Bantuan?",
                        size = 14.sp,
                        fontFamily = opensansbold,
                        onItemclicked = {  },
                        color = Color(0xFF272727)
                    )
                    Spacer(modifier.height(8.dp)
                    )
                    opensanstext(
                        text = "Jangan ragu utuk menghubungi tim Customer Service kami.",
                        size = 12.sp,
                        fontFamily = opensansregular,
                        onItemclicked = {  },
                        color = Color(0xFF272727)
                    )
                }
            }
            Spacer(modifier.height(46.dp)
            )
            Card(
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.dp, Color(0xFFD9D9D9)),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = modifier
                    .size(323.dp, 110.dp)
            ){
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.Start,
                    modifier = modifier
                        .fillMaxSize()
                        .padding(start = 20.dp, end = 20.dp)
                ){
                    opensanstext(
                        text = "Whatsapp",
                        size = 14.sp,
                        fontFamily = opensansbold,
                        onItemclicked = {  },
                        color = Color(0xFF272727)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start,
                        modifier = modifier
                            .fillMaxWidth()
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.whatsapp_icon),
                            contentDescription = null,
                            modifier
                                .size(40.dp)
                        )
                        Spacer(modifier.width(15.dp)
                        )
                        opensanstext(
                            text = "Hubungi customer service kami lewat akun WhatsApp Anda.",
                            size = 12.sp,
                            fontFamily = opensansregular,
                            onItemclicked = {  },
                            color = Color(0xFF272727)
                        )
                    }
                }
            }
            Spacer(modifier.height(24.dp)
            )
            Card(
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.dp, Color(0xFFD9D9D9)),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = modifier
                    .size(323.dp, 110.dp)
            ){
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.Start,
                    modifier = modifier
                        .fillMaxSize()
                        .padding(start = 20.dp, end = 20.dp)
                ){
                    opensanstext(
                        text = "Pusat Bantuan",
                        size = 14.sp,
                        fontFamily = opensansbold,
                        onItemclicked = {  },
                        color = Color(0xFF272727)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start,
                        modifier = modifier
                            .fillMaxWidth()
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.help_icon),
                            contentDescription = null,
                            modifier
                                .size(40.dp)
                        )
                        Spacer(modifier.width(15.dp)
                        )
                        opensanstext(
                            text = "Hubungi customer service kami lewat akun WhatsApp Anda.",
                            size = 12.sp,
                            fontFamily = opensansregular,
                            onItemclicked = {  },
                            color = Color(0xFF272727)
                        )
                    }
                }
            }
        }
    }
}