package com.example.aqua_care.ScanBot.utils

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

fun Uri.toFile(context: Context): File {
    val contentResolver = context.contentResolver
    val myFile = File.createTempFile("image", ".jpeg")

    val inputStream = contentResolver.openInputStream(this) as InputStream
    val outputStream = FileOutputStream(myFile)
    val buf = ByteArray(1024)
    var len: Int
    while (inputStream.read(buf).also { len = it } > 0) outputStream.write(buf, 0, len)
    outputStream.close()
    inputStream.close()

    return myFile
}

fun Bitmap.toFile(context: Context): File {
    val file = File(context.cacheDir, "${System.currentTimeMillis()}.jpg")
    file.outputStream().use {
        this.compress(Bitmap.CompressFormat.JPEG, 100, it)
    }
    return file
}
