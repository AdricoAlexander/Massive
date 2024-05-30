package com.example.aqua_care.Screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
import com.example.aqua_care.ViewModel.DataStoreViewModel
import kotlinx.coroutines.launch

@Composable
fun loginpage(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: DataStoreViewModel
){
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val dataStore = UserPreferences(context)
    val sharedPreferencesManager = remember { SharedPreferencesManager(context) }
    var name by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
    ){
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(20.dp)
        ){
            Spacer(modifier.height(40.dp)
            )
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = modifier
                    .fillMaxWidth()
            ){
                Image(
                    painter = painterResource(id = R.drawable.logo_blue),
                    contentDescription = "Logo",
                    Modifier
                        .size(50.dp)
                )
                Spacer(modifier.width(15.dp)
                )
                Column (
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceAround,
                    modifier = modifier
                ){
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
                Spacer(modifier.width(15.dp)
                )
            }
            Spacer(modifier.height(30.dp)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = modifier
                    .fillMaxSize()
            ) {
                opensanstext(
                    text = "Masukkan Akun",
                    size = 18.sp,
                    fontFamily = opensansbold,
                    color = Color(0xFF272727),
                    onItemclicked = null
                )
                Spacer(
                    modifier.height(20.dp)
                )
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top,
                    modifier = modifier
                        .padding(20.dp)
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
                        text = name,
                        onChange = {
                            name = it
                        }
                    )
                    Spacer(
                        modifier.height(10.dp)
                    )
                    opensanstext(
                        text = "Password",
                        size = 14.sp,
                        fontFamily = opensansbold,
                        color = Color(0xFF272727),
                        onItemclicked = null
                    )
                    aquatextfield(
                        label = "Masukkan Password",
                        image = painterResource(id = R.drawable.icon_locked),
                        width = 313.dp,
                        height = 60.dp,
                        imageSize = 16.81.dp,
                        font = opensansregular,
                        fontSize = 12.sp,
                        text = password,
                        onChange = {
                            password = it
                        }
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(end = 20.dp)
                ) {
                    opensanstext(
                        text = "Lupa Password ?",
                        size = 10.sp,
                        fontFamily = opensansregular,
                        onItemclicked = null,
                        color = Color(0xFF272727)
                    )
                }
                Spacer(
                    modifier.height(20.dp)
                )
                aquaButton(
                    color = Color(0xFF246DBB),
                    width = 264.dp,
                    height = 35.dp,
                    text = "Masuk",
                    fontFamily = opensansbold,
                    textColor = Color.White
                ) {
                    if (name.isBlank() || password.isBlank()){
                        Toast.makeText(context, "Nama Dan Password Wajib Diisi", Toast.LENGTH_SHORT).show()
                    }else {
                        sharedPreferencesManager.name = name
                        sharedPreferencesManager.password = password
                        scope.launch {
                            viewModel.login()
                            navController.navigate(navScreen.homePage.route) {
                                popUpTo(navScreen.Splash.route) {
                                    inclusive = true
                        }

                            }
                        }
                    }
                }
                Spacer(
                    modifier.height(10.dp)
                )
                opensanstext(
                    text = "Atau Daftar Dengan",
                    size = 10.sp,
                    fontFamily = opensansregular,
                    color = Color(0xFF272727),
                    onItemclicked = null
                )
                Spacer(
                    modifier.height(10.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.icon_google),
                    contentDescription = null,
                )
                Spacer(
                    modifier.height(10.dp)
                )
                Row (
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier
                        .fillMaxWidth()
                ){
                    opensanstext(
                        text = "Belum punya akun?",
                        size = 10.sp,
                        fontFamily = opensansregular,
                        color = Color(0xFF272727),
                        onItemclicked = null
                    )
                    Spacer(modifier.width(10.dp))
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
}

