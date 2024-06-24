package com.example.aqua_care.MediaPlayer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

@Composable
fun MediaContent(
    modifier: Modifier = Modifier,
    exoPlayer: ExoPlayer,
    mediaSource: MediaItem
) {
    LaunchedEffect(mediaSource) {
        exoPlayer.setMediaItem(mediaSource)
        exoPlayer.prepare()
    }
    
    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }

    Box(
        modifier = modifier
            .size(304.dp, 161.dp),
        contentAlignment = Alignment.Center
    ){
        AndroidView(factory = { ctx ->
            PlayerView(ctx).apply {
                player = exoPlayer
            }
        },
            modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    }

}