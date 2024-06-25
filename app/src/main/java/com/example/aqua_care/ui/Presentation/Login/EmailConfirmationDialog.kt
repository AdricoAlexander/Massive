package com.example.aqua_care.ui.Presentation.Login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun EmailConfirmationDialog(
    onDismiss: () -> Unit,
    onVerify: (String) -> Unit
) {
    var email by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = {
            Text(text = "Konfirmasi Email")
        },
        text = {
            Column {
                Text(text = "Masukkan Email")
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Button(
                onClick = { onVerify(email) }
            ) {
                Text("Verify")
            }
        },
        dismissButton = {
            Button(
                onClick = { onDismiss() }
            ) {
                Text("Cancel")
            }
        }
    )
}
