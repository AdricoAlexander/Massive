package com.example.aqua_care.ui.Presentation.Profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.aqua_care.Data.aquaButton
import com.example.aqua_care.Data.datatext
import com.example.aqua_care.Data.opensansbold
import com.example.aqua_care.Data.opensanstext
import com.example.aqua_care.DataStore.SharedPreferencesManager
import com.example.aqua_care.Navigation.navScreen
import com.example.aqua_care.R
import com.example.aqua_care.ViewModel.FirebaseViewModel

@Composable
fun profileEdit(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel : FirebaseViewModel = hiltViewModel()
){
    val context = LocalContext.current
    val sharedPreferencesManager = remember { SharedPreferencesManager(context) }
    val state by viewModel.state.collectAsState(initial = null)
    var newName by remember { mutableStateOf(sharedPreferencesManager.name ?: "") }

    var editResult by remember { mutableStateOf<Boolean?>(null) }
    
    LaunchedEffect(newName) {
        sharedPreferencesManager.name = newName
    }
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.icon_backarrow),
            contentDescription = null,
            modifier = modifier
                .size(30.dp)
                .clickable {
                    navController.navigate(navScreen.profilePage.route)
                }
        )
        Spacer(modifier.height(10.dp)
        )
        opensanstext(
            text = "Pengaturan Profile",
            size = 24.sp,
            fontFamily = opensansbold,
            onItemclicked = {  },
            color = Color(0xFF272727)
        )
        Spacer(modifier.height(28.dp)
        )
        opensanstext(
            text = "Nama Lengkap",
            size = 14.sp,
            fontFamily = opensansbold,
            onItemclicked = {  },
            color = Color(0xFF272727)
        )
        Spacer(modifier.height(11.dp)
        )
        datatext(
            value = "",
            width = 352.dp,
            height = 50.dp,
            onChangeValue = {}
        )
        Spacer(modifier.height(11.dp)
        )
        opensanstext(
            text = "Username",
            size = 14.sp,
            fontFamily = opensansbold,
            onItemclicked = {  },
            color = Color(0xFF272727)
        )
        Spacer(modifier.height(11.dp)
        )
        datatext(
            value = "",
            width = 352.dp,
            height = 50.dp,
            onChangeValue = {}
        )
        Spacer(modifier.height(11.dp)
        )
        opensanstext(
            text = "Email",
            size = 14.sp,
            fontFamily = opensansbold,
            onItemclicked = {  },
            color = Color(0xFF272727)
        )
        Spacer(modifier.height(11.dp)
        )
        datatext(
            value = newName,
            width = 352.dp,
            height = 50.dp,
            onChangeValue = {
                newName = it
            }
        )
        Spacer(modifier.height(11.dp)
        )
        opensanstext(
            text = "Nomor Telepon",
            size = 14.sp,
            fontFamily = opensansbold,
            onItemclicked = {  },
            color = Color(0xFF272727)
        )
        Spacer(modifier.height(11.dp)
        )
        datatext(
            value = "089220651213",
            width = 352.dp,
            height = 50.dp,
            onChangeValue = {}

        )
        Spacer(modifier.height(11.dp)
        )
        opensanstext(
            text = "Alamat",
            size = 14.sp,
            fontFamily = opensansbold,
            onItemclicked = {  },
            color = Color(0xFF272727)
        )
        Spacer(modifier.height(11.dp)
        )
        datatext(
            value = "Bandung Barat Daya",
            width = 352.dp,
            height = 50.dp,
            onChangeValue = {}

        )
        Spacer(modifier.height(30.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxWidth()
        ){
            aquaButton(
                color = Color(0xFF246DBB),
                width = 264.dp,
                height = 35.dp,
                textColor = Color.White,
                text = "Simpan",
                fontFamily = opensansbold
            ) {
                navController.navigate(navScreen.profilePage.route)
            }
        }
    }
}

