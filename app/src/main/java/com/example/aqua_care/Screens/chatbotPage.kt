package com.example.aqua_care.Screens

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.aqua_care.Data.aquatextfield
import com.example.aqua_care.Data.chatIcon
import com.example.aqua_care.Data.chatLayout
import com.example.aqua_care.Data.opensansbold
import com.example.aqua_care.Data.opensanssemibold
import com.example.aqua_care.Data.opensanstext
import com.example.aqua_care.Data.outlinetext
import com.example.aqua_care.R

@Composable
fun chatbotPage(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center

    ){
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 17.dp, vertical = 25.dp)
        ){
            opensanstext(
                text = "AquaBot",
                size = 18.sp,
                fontFamily = opensansbold,
                onItemclicked = {  },
                color = Color(0xFF246DBB)
            )
            Spacer(modifier.height(26.dp)
            )
            Column(
                verticalArrangement = Arrangement.Top,
                modifier = modifier
                    .verticalScroll(rememberScrollState())
            ){
                Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.Start,
                    modifier = modifier
                        .fillMaxSize()

                ){
                    chatIcon(icon = R.drawable.icon_logonavbar)
                    Spacer(modifier.width(8.dp)
                    )
                    Column(){
                        chatLayout(
                            sender = "AquaBot"
                            , text = "Hallo! Ada yang bisa Aqua Care bantu?",
                            topStart = 0.dp,
                            topEnd = 11.dp
                        )
                        Spacer(modifier.height(7.dp)
                        )
                        opensanstext(
                            text = "13.21",
                            size = 6.sp,
                            fontFamily = opensansbold,
                            onItemclicked = {  },
                            color = Color(0xFF272727)
                        )
                    }
                }
                Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.End,
                    modifier = modifier
                        .fillMaxWidth()
                ){
                    Column(){
                        chatLayout(
                            sender = "Sugi"
                            , text = "Bagaimana cara merawat ikan nila?",
                            topStart = 11.dp,
                            topEnd = 0.dp
                        )
                        Spacer(modifier.height(7.dp)
                        )
                        opensanstext(
                            text = "13.21",
                            size = 6.sp,
                            fontFamily = opensansbold,
                            onItemclicked = {  },
                            color = Color(0xFF272727)
                        )
                    }
                    Spacer(modifier.width(8.dp)
                    )
                    chatIcon(icon = R.drawable.icon_s)
                }
                Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.Start,
                    modifier = modifier
                        .fillMaxSize()

                ){
                    chatIcon(icon = R.drawable.icon_logonavbar)
                    Spacer(modifier.width(8.dp)
                    )
                    Column(){
                        chatLayout(
                            sender = "AquaBot"
                            , text = "Untuk merawat ikan nila, pastikan akuariumnya bersih dengan melakukan pergantian air secara teratur. Berikan makanan yang sesuai dengan jenisnya, seperti pelet ikan nila atau serangga hidup. Periksa kesehatan ikan secara rutin dan tanggapi perubahan perilaku atau ...",
                            topStart = 0.dp,
                            topEnd = 11.dp
                        )
                        Spacer(modifier.height(7.dp)
                        )
                        opensanstext(
                            text = "13.21",
                            size = 6.sp,
                            fontFamily = opensansbold,
                            onItemclicked = {  },
                            color = Color(0xFF272727)
                        )
                    }
                }
                Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.End,
                    modifier = modifier
                        .fillMaxWidth()
                ){
                    Column(){
                        chatLayout(
                            sender = "Sugi",
                            text = "Terimakasih",
                            topStart = 11.dp,
                            topEnd = 0.dp
                        )
                        Spacer(modifier.height(7.dp)
                        )
                        opensanstext(
                            text = "13.21",
                            size = 6.sp,
                            fontFamily = opensansbold,
                            onItemclicked = {  },
                            color = Color(0xFF272727)
                        )
                    }
                    Spacer(modifier.width(8.dp)
                    )
                    chatIcon(icon = R.drawable.icon_s)
                }
            }
            Spacer(modifier.height(72.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = modifier
                    .fillMaxWidth()
            ){
                var text by remember { mutableStateOf(TextFieldValue("")) }
                OutlinedTextField(
                    value = text,
                    onValueChange = {
                        text = it
                    },
                    label = {
                        opensanstext(
                            text = "Ketikan Pesan",
                            size = 14.sp,
                            fontFamily = opensanssemibold,
                            onItemclicked = { },
                            color = Color(0xFF246DBB)
                        )
                    },
                    shape = RoundedCornerShape(20.dp)
                )
                chatIcon(icon = R.drawable.send_icon
                )
            }
        }
    }
}

@Preview
@Composable
private fun preview() {
    chatbotPage()
}