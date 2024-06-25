package com.example.aqua_care.ui.Presentation.Home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aqua_care.Data.Video
import com.example.aqua_care.Data.opensansextrabold
import com.example.aqua_care.Data.opensanstext
import com.example.aqua_care.R

@Composable
fun VideoLayout(
    modifier: Modifier = Modifier,
    video: Video,
    onClick: (Video) -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color(0xFFACACAC)),
        modifier = modifier
            .fillMaxWidth()
            .height(39.dp)
            .clickable {
                onClick(video)
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .fillMaxSize()
                .padding(11.dp)
        ) {
            opensanstext(
                text = video.title,
                size = 11.sp,
                fontFamily = opensansextrabold,
                onItemclicked = { },
                color = Color(0xFF272727)
            )
            Image(
                painter = painterResource(id = R.drawable.forward_arrow),
                contentDescription = null,
                modifier = modifier
                    .size(17.dp)
            )
        }
    }
}