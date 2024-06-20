package com.example.aqua_care.Camera

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Matrix
import android.util.Log
import androidx.camera.core.ImageCapture.OnImageCapturedCallback
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.ImageProxy
import androidx.camera.view.LifecycleCameraController
import androidx.core.content.ContextCompat

fun takePhoto(
    controller : LifecycleCameraController,
    onPhotoTaken : (Bitmap) -> Unit,
    context: Context,
    onCameraOff : () -> Unit
){
    controller.takePicture(
        ContextCompat.getMainExecutor(context),
        object : OnImageCapturedCallback(){
            override fun onCaptureSuccess(image: ImageProxy) {
                super.onCaptureSuccess(image)
                val matrix = Matrix().apply {
                    postRotate(image.imageInfo.rotationDegrees.toFloat())
                    postScale(-1f, 1f)
                }
                val rotatedBitmap = Bitmap.createBitmap(
                    image.toBitmap(),
                     0,
                     0,
                    image.width,
                    image.height,
                    matrix,
                    true
                )
                onPhotoTaken(rotatedBitmap)
                onCameraOff()
            }

            override fun onError(exception: ImageCaptureException) {
                super.onError(exception)
                Log.e("Camera", "Cannot Take Photo", exception)
            }
        }
    )
}