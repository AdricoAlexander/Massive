package com.example.aqua_care.Screens

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.aqua_care.Data.aquatextfield
import com.example.aqua_care.Data.opensansregular
import com.example.aqua_care.Data.opensanssemibold
import com.example.aqua_care.R
import com.example.aqua_care.ViewModel.ChatMessage
import com.example.aqua_care.ViewModel.ChatViewModel

@Composable
fun chatbotPage(modifier: Modifier = Modifier) {
    val chatViewModel: ChatViewModel = hiltViewModel()
    var text by remember { mutableStateOf("") }
    val messages by chatViewModel.messages.collectAsState()

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(8.dp)
        ) {
            items(messages) { message ->
                chatBubble(message = message)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            aquatextfield(
                label = "Masukkan Kata Kunci",
                image = painterResource(id = R.drawable.send_icon),
                width = 295.dp,
                height = 63.dp,
                imageSize = 18.dp,
                font = opensansregular,
                fontSize = 16.sp,
                text = text,
                onChange = {
                    text = it
                },
            )
            SendButton(
                onClick = {
                    if (text.isNotBlank()) {
                        chatViewModel.sendMessage(text)
                        text = ""
                    }
                }
            )
        }
    }
}

@Composable
fun SendButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(50.dp)
            .clip(CircleShape)
            .clickable(onClick = onClick)
            .background(Color(0xFF246DBB)),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.Send,
            contentDescription = "Send",
            tint = Color.White,
            modifier = Modifier.size(18.dp)
        )
    }
}

@Composable
fun chatBubble(
    message: ChatMessage
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 5.dp)
    ) {
        Image(
            painter = if (message.isUser) painterResource(id = R.drawable.pak_sugi) else painterResource(id = R.drawable.splash_logo),
            contentDescription = if (message.isUser) "User" else "Aqua Bot",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(7.dp),
            horizontalAlignment = if (message.isUser) Alignment.End else Alignment.Start,
            modifier = Modifier
                .padding(start = 10.dp)
                .clip(RoundedCornerShape(
                    topStart = if (message.isUser) 10.dp else 0.dp,
                    topEnd = if (!message.isUser) 10.dp else 0.dp,
                    bottomEnd = 10.dp,
                    bottomStart = 10.dp
                ))
                .background(if (message.isUser) Color(0xFFA8DAF8) else Color(0xFFE6EFFD))
                .padding(10.dp)
        ) {
            Text(
                text = if (message.isUser) "User" else "Aqua Bot",
                fontSize = 12.sp,
                fontFamily = opensanssemibold,
                color = Color(0xFF272727)
            )
            Text(
                text = message.text,
                fontSize = 12.sp,
                fontFamily = opensanssemibold,
                color = Color(0xFF272727)
            )
        }
    }
}



