package com.example.aqua_care.ui.Presentation.Chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.aqua_care.Data.ChatBotTextField
import com.example.aqua_care.Data.opensansregular
import com.example.aqua_care.Data.opensanssemibold
import com.example.aqua_care.Data.opensanstext
import com.example.aqua_care.DataStore.SharedPreferencesManager
import com.example.aqua_care.R
import com.example.aqua_care.ViewModel.ChatMessage
import com.example.aqua_care.ViewModel.ChatViewModel

@Composable
fun chatbotPage(modifier: Modifier = Modifier) {

    val chatViewModel: ChatViewModel = viewModel()
    val context = LocalContext.current
    var text by remember { mutableStateOf("") }
    val messages by chatViewModel.messages.collectAsState()
    val loading by chatViewModel.loading.collectAsState()
    val sharedPreferencesManager = remember { SharedPreferencesManager(context) }
    val name = sharedPreferencesManager.name ?: ""

    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp)
    ){
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(8.dp)
        ) {
            items(messages) { message ->
                chatBubble(message = message, name = name)
            }
        }
        if (loading){
            CircularProgressIndicator(
                modifier
                    .padding(8.dp)
                    .size(30.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
           ChatBotTextField(
               label = "Masukan Kata Kunci",
               image = painterResource(id = R.drawable.send_icon),
               width = 250.dp,
               height = 63.dp,
               imageSize = 18.dp,
               font = opensansregular,
               fontSize = 12.sp,
               text = text
           ) {
                   text = it
           }
            Box(
                modifier = modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .clickable {
                        if (text.isNotBlank()) {
                            chatViewModel.sendMessage(text)
                            text = ""
                        }
                    }
                    .background(Color(0xFF246DBB)),
                contentAlignment = Alignment.Center
            ){
                Image(painter = painterResource(id = R.drawable.send_icon),
                    contentDescription = null,
                    modifier
                        .size(18.dp)
                )
            }
        }
    }
}
@Composable
fun chatBubble(
    modifier: Modifier = Modifier,
    message: ChatMessage,
    name : String
) {
    if (message.isUser){
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp)
        ){
            Box(
                modifier = modifier
                    .background(
                        Color(0xFFA8DAF8),
                        RoundedCornerShape(topStart = 10.dp, bottomEnd = 10.dp, bottomStart = 10.dp)
                    )
                    .padding(10.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 10.dp,
                            bottomEnd = 10.dp,
                            bottomStart = 10.dp
                        )
                    )
            ){
                Column(
                    verticalArrangement = Arrangement.spacedBy(7.dp),
                    horizontalAlignment = Alignment.End
                ){
                    opensanstext(
                        text = name,
                        size = 12.sp,
                        fontFamily = opensanssemibold,
                        onItemclicked = {  },
                        color = Color(0xFF272727)
                    )
                    opensanstext(
                        text = message.text,
                        size = 12.sp,
                        fontFamily = opensanssemibold,
                        onItemclicked = {  },
                        color = Color(0xFF272727)
                    )
                }
            }
        }
    } else {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp)
        ){
            Box(
                modifier = modifier
                    .background(
                        Color(0xFFE6EFFD),
                        RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp, bottomStart = 10.dp)
                    )
                    .padding(10.dp)
                    .clip(
                        RoundedCornerShape(
                            topEnd = 10.dp,
                            bottomEnd = 10.dp,
                            bottomStart = 10.dp
                        )
                    )
            ){
                Column(
                    verticalArrangement = Arrangement.spacedBy(7.dp),
                    horizontalAlignment = Alignment.Start
                ){
                    opensanstext(
                        text = "Aqua Bot",
                        size = 12.sp,
                        fontFamily = opensanssemibold,
                        onItemclicked = {  },
                        color = Color(0xFF272727)
                    )
                    opensanstext(
                        text = message.text,
                        size = 12.sp,
                        fontFamily = opensanssemibold,
                        onItemclicked = {  },
                        color = Color(0xFF272727)
                    )
                }
            }
        }
    }
}