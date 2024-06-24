package com.example.aqua_care.ui.Presentation.Payment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aqua_care.Data.aquaButton
import com.example.aqua_care.Data.opensansbold
import com.example.aqua_care.Data.opensansregular
import com.example.aqua_care.Data.opensanssemibold
import com.example.aqua_care.Data.opensanstext
import com.example.aqua_care.Data.premiumData
import com.example.aqua_care.Navigation.navScreen
import com.example.aqua_care.R

@Composable
fun paymentDetail(
    modifier: Modifier = Modifier,
    paymentId : Int?,
    navController: NavController

) {
    val newPaymentList = premiumData.premiumList.filter {
        it.id == paymentId
    }
    var isClicked_1 by remember { mutableStateOf(false) }
    var isClicked_2 by remember { mutableStateOf(false) }
    var isClicked_3 by remember { mutableStateOf(false) }
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()

    ) {
        newPaymentList.forEach {

            Column(
                verticalArrangement = Arrangement.Top,
                modifier = modifier
                    .fillMaxSize()
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = modifier
                        .fillMaxWidth()
                        .height(86.dp)
                        .background(Color(0xFF246DBB))
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.icon_backarrow),
                            contentDescription = null,
                            modifier = modifier
                                .clickable {
                                    navController.navigate(navScreen.premiumCategory.route)
                                }
                        )
                        Spacer(modifier.width(10.dp))
                        opensanstext(
                            text = "Pembayaran",
                            size = 18.sp,
                            fontFamily = opensansbold,
                            onItemclicked = { },
                            color = Color.White
                        )
                    }
                }
                Spacer(
                    modifier.height(22.dp)
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier
                        .fillMaxSize()
                        .padding(12.dp)
                ) {
                    Card(
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFE2EDFD)),
                        shape = RoundedCornerShape(18.dp),
                        modifier = modifier
                            .fillMaxWidth()
                            .height(247.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.Start,
                            modifier = modifier
                                .padding(20.dp)
                                .fillMaxSize()
                        ) {

                            opensanstext(
                                text = "Premium ${it.title}",
                                size = 20.sp,
                                fontFamily = opensansbold,
                                onItemclicked = { },
                                color = Color(0xFF272727)
                            )
                            Spacer(
                                modifier.height(10.dp)
                            )
                            opensanstext(
                                text = it.length,
                                size = 18.sp,
                                fontFamily = opensansbold,
                                onItemclicked = { },
                                color = Color(0xFF272727)
                            )
                            Spacer(
                                modifier.height(15.dp)
                            )
                            opensanstext(
                                text = "Gratis Video Edukasi",
                                size = 12.sp,
                                fontFamily = opensanssemibold,
                                onItemclicked = { },
                                color = Color(0xFF272727)
                            )
                            Spacer(
                                modifier.height(10.dp)
                            )
                            opensanstext(
                                text = "Akses AquaScan",
                                size = 12.sp,
                                fontFamily = opensanssemibold,
                                onItemclicked = { },
                                color = Color(0xFF272727)
                            )
                            Spacer(
                                modifier.height(10.dp)
                            )
                            opensanstext(
                                text = "Akses AquaBot",
                                size = 12.sp,
                                fontFamily = opensanssemibold,
                                onItemclicked = { },
                                color = Color(0xFF272727)
                            )
                            Spacer(
                                modifier.height(20.dp)
                            )
                            Spacer(
                                modifier
                                    .fillMaxWidth()
                                    .height(1.dp)
                                    .background(Color(0xFFACACAC))
                            )
                            Spacer(
                                modifier.height(10.dp)
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = modifier
                                    .fillMaxWidth()
                            ) {
                                opensanstext(
                                    text = "Total",
                                    size = 18.sp,
                                    fontFamily = opensanssemibold,
                                    onItemclicked = { },
                                    color = Color(0xFF272727)
                                )
                                opensanstext(
                                    text = "Rp. ${it.price}",
                                    size = 18.sp,
                                    fontFamily = opensanssemibold,
                                    onItemclicked = { },
                                    color = Color(0xFF272727)
                                )
                            }
                        }
                    }
                    Spacer(
                        modifier.height(30.dp)
                    )
                    Card(
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFE2EDFD)),
                        shape = RoundedCornerShape(18.dp),
                        modifier = modifier
                            .fillMaxWidth()
                            .height(221.dp)

                    ) {
                        Column(
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.Start,
                            modifier = modifier
                                .fillMaxSize()
                                .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                        ) {
                            opensanstext(
                                text = "Pilih Metode Pembayaran",
                                size = 20.sp,
                                fontFamily = opensansbold,
                                onItemclicked = { },
                                color = Color(0xFF272727)
                            )
                            Spacer(
                                modifier
                                    .padding(top = 15.dp, bottom = 20.dp)
                                    .fillMaxWidth()
                                    .height(1.dp)
                                    .background(Color(0xFFACACAC))
                            )
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = modifier
                                    .fillMaxWidth()
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ovo_icon),
                                    contentDescription = null,
                                    modifier = modifier
                                        .size(45.dp)
                                )
                                Image(
                                    painter = painterResource(if (isClicked_1) R.drawable.box_checked else R.drawable.box_unchecked),
                                    contentDescription = null,
                                    modifier = modifier
                                        .size(45.dp)
                                        .clickable {
                                            isClicked_1 = true
                                            isClicked_2 = false
                                            isClicked_3 = false
                                        }
                                )
                            }
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = modifier
                                    .fillMaxWidth()
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.icon_dana),
                                    contentDescription = null,
                                    modifier = modifier
                                        .size(45.dp)
                                )
                                Image(
                                    painter = painterResource(if (isClicked_2) R.drawable.box_checked else R.drawable.box_unchecked),
                                    contentDescription = null,
                                    modifier = modifier
                                        .size(45.dp)
                                        .clickable {
                                            isClicked_1 = false
                                            isClicked_2 = true
                                            isClicked_3 = false
                                        }
                                )
                            }
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = modifier
                                    .fillMaxWidth()
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.icon_bca),
                                    contentDescription = null,
                                    modifier = modifier
                                        .size(45.dp)
                                )
                                Image(
                                    painter = painterResource(if (isClicked_3) R.drawable.box_checked else R.drawable.box_unchecked),
                                    contentDescription = null,
                                    modifier = modifier
                                        .size(45.dp)
                                        .clickable {
                                            isClicked_1 = false
                                            isClicked_2 = false
                                            isClicked_3 = true
                                        }
                                )
                            }
                        }
                    }
                    Spacer(
                        modifier.height(30.dp)
                    )
                    Card(
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFE2EDFD)),
                        shape = RoundedCornerShape(18.dp),
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(20.dp)
                        ) {
                            Column(
                                verticalArrangement = Arrangement.SpaceAround,
                                horizontalAlignment = Alignment.Start,
                            ) {
                                opensanstext(
                                    text = "Total Pembayaran",
                                    size = 14.sp,
                                    fontFamily = opensansregular,
                                    onItemclicked = { },
                                    color = Color(0xFF272727)
                                )
                                opensanstext(
                                    text = "Rp. ${it.price}",
                                    size = 18.sp,
                                    fontFamily = opensanssemibold,
                                    onItemclicked = { },
                                    color = Color(0xFF272727)
                                )
                            }
                            aquaButton(
                                color = Color.White,
                                width = 131.dp,
                                height = 42.dp,
                                textColor = Color(0xFF246DBB),
                                text = "Bayar",
                                fontFamily = opensansbold
                            ) {
                                navController.navigate(navScreen.bayarFeedback.route)
                            }
                        }
                    }
                }
            }
        }
    }
}