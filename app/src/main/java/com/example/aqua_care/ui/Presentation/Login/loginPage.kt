@file:Suppress("DEPRECATION")

package com.example.aqua_care.ui.Presentation.Login

import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.aqua_care.Data.aquaButton
import com.example.aqua_care.Data.aquatextfield
import com.example.aqua_care.Data.opensansbold
import com.example.aqua_care.Data.opensansregular
import com.example.aqua_care.Data.opensanstext
import com.example.aqua_care.DataStore.SharedPreferencesManager
import com.example.aqua_care.DataStore.UserPreferences
import com.example.aqua_care.Navigation.navScreen
import com.example.aqua_care.R
import com.example.aqua_care.ViewModel.FirebaseViewModel
import kotlinx.coroutines.launch

@Composable
fun loginpage(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: FirebaseViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val state by viewModel.state.collectAsState(initial = null)
    val dataStore = remember { UserPreferences(context) }
    val sharedPreferencesManager = remember { SharedPreferencesManager(context) }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var showEmailDialog by remember { mutableStateOf(false) }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_blue),
                    contentDescription = "Logo",
                    Modifier.size(50.dp)
                )
                Spacer(modifier = Modifier.width(15.dp))
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceAround,
                    modifier = modifier
                ) {
                    opensanstext(
                        text = "Aqua Care",
                        size = 18.sp,
                        fontFamily = opensansbold,
                        color = Color(0xFF272727),
                        onItemclicked = null
                    )
                    opensanstext(
                        text = "Air Bersih, Ikan Sehat, Sukses Terjaga",
                        size = 13.sp,
                        fontFamily = opensansregular,
                        color = Color(0xFF272727),
                        onItemclicked = null
                    )
                }
                Spacer(modifier = Modifier.width(15.dp))
            }
            Spacer(modifier = Modifier.height(30.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = modifier.fillMaxSize()
            ) {
                opensanstext(
                    text = "Masukkan Akun",
                    size = 18.sp,
                    fontFamily = opensansbold,
                    color = Color(0xFF272727),
                    onItemclicked = null
                )
                Spacer(modifier = Modifier.height(20.dp))
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top,
                    modifier = modifier.padding(20.dp)
                ) {
                    opensanstext(
                        text = "Email",
                        size = 14.sp,
                        fontFamily = opensansbold,
                        color = Color(0xFF272727),
                        onItemclicked = null
                    )
                    aquatextfield(
                        label = "Masukkan Email",
                        image = painterResource(id = R.drawable.icon_email),
                        width = 313.dp,
                        height = 60.dp,
                        imageSize = 16.81.dp,
                        font = opensansregular,
                        fontSize = 12.sp,
                        text = email,
                        onChange = { email = it }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    opensanstext(
                        text = "Password",
                        size = 14.sp,
                        fontFamily = opensansbold,
                        color = Color(0xFF272727),
                        onItemclicked = null
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        aquatextfield(
                            label = "Masukan Password",
                            image = painterResource(id = R.drawable.icon_locked),
                            width = 313.dp,
                            height = 60.dp,
                            imageSize = 16.81.dp,
                            font = opensansregular,
                            fontSize = 12.sp,
                            text = password,
                            onChange = { password = it },
                            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            isPassword = true
                        )
                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End,
                    modifier = modifier.fillMaxWidth().padding(end = 20.dp)
                ) {
                    opensanstext(
                        text = "Lupa Password ?",
                        size = 10.sp,
                        fontFamily = opensansregular,
                        onItemclicked = {
                            showEmailDialog = true
                        },
                        color = Color(0xFF272727)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                aquaButton(
                    color = Color(0xFF246DBB),
                    width = 264.dp,
                    height = 35.dp,
                    text = "Masuk",
                    fontFamily = opensansbold,
                    textColor = Color.White
                ) {
                    coroutineScope.launch {
                        if (email.isBlank() || password.isBlank()) {
                            Toast.makeText(context, "Email dan password harus diisi", Toast.LENGTH_SHORT).show()
                        } else {
                            viewModel.loginUser(email, password) { success ->
                                if (success) {
                                    coroutineScope.launch {
                                        dataStore.saveStatus(true)
                                        sharedPreferencesManager.name = email
                                        sharedPreferencesManager.password = password
                                    }
                                    navController.navigate(navScreen.homePage.route) {
                                        popUpTo(navScreen.Splash.route) {
                                            inclusive = true
                                        }
                                    }
                                } else {
                                    Toast.makeText(context, "Email atau password salah", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier.fillMaxWidth()
                ) {
                    opensanstext(
                        text = "Belum punya akun?",
                        size = 10.sp,
                        fontFamily = opensansregular,
                        color = Color(0xFF272727),
                        onItemclicked = null
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    opensanstext(
                        text = "Daftar",
                        size = 10.sp,
                        fontFamily = opensansregular,
                        color = Color(0xFF246DBB),
                        onItemclicked = {
                            navController.navigate(navScreen.signupPage.route)
                        }
                    )
                }
            }
        }
    }
    if (showEmailDialog) {
        EmailConfirmationDialog(
            onDismiss = { showEmailDialog = false },
            onVerify = { dialogEmail ->
                coroutineScope.launch {
                    viewModel.resetPassword(dialogEmail){
                        if (it) {
                            Toast.makeText(context, "Password reset email sent", Toast.LENGTH_SHORT).show()
                            showEmailDialog = false
                        } else {
                            Toast.makeText(context, "Email not found", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        )
    }
}
