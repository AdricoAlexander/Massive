package com.example.aqua_care.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aqua_care.Data.aquaButton
import com.example.aqua_care.Data.myBottomSheet
import com.example.aqua_care.Data.opensansbold
import com.example.aqua_care.Data.opensansregular
import com.example.aqua_care.Data.opensanstext
import com.example.aqua_care.Data.profileCard
import com.example.aqua_care.DataStore.SharedPreferencesManager
import com.example.aqua_care.Navigation.navScreen
import com.example.aqua_care.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun profilePage(
    modifier: Modifier = Modifier,
    navController: NavController
){
    val  scope = rememberCoroutineScope()
    var isBottomSheetVisible by rememberSaveable { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    val context = LocalContext.current
    val sharedPreferencesManager = remember { SharedPreferencesManager(context) }
    val name = sharedPreferencesManager.name ?: ""

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ){
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .fillMaxWidth()
                .height(215.dp)
                .background(Color(0xFF246DBB))
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround,
                modifier = modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ){
                opensanstext(
                    text = "Profile",
                    size = 20.sp,
                    fontFamily = opensansbold,
                    onItemclicked = {  },
                    color = Color.White
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = modifier
                        .fillMaxWidth()
                ){
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        opensanstext(
                            text = "User",
                            size = 18.sp,
                            fontFamily = opensansbold,
                            onItemclicked = {  },
                            color = Color.White
                        )
                        Image(
                            painter = painterResource(id = R.drawable.icon_person),
                            contentDescription = null,
                            modifier = Modifier
                                .size(70.dp)
                                .padding(10.dp)
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.SpaceAround,
                        horizontalAlignment = Alignment.Start,

                    ){
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.email_icon),
                                contentDescription = null,
                                modifier = modifier
                                    .size(29.dp)
                                    .padding(10.dp)
                            )
                            opensanstext(
                                text = name,
                                size = 11.sp,
                                fontFamily = opensansregular,
                                onItemclicked = {  },
                                color = Color.White
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.telephone_icon),
                                contentDescription = null,
                                modifier = modifier
                                    .size(29.dp)
                                    .padding(10.dp)
                            )
                            opensanstext(
                                text = "089220651213",
                                size = 11.sp,
                                fontFamily = opensansregular,
                                onItemclicked = {  },
                                color = Color.White
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.marker_icon),
                                contentDescription = null,
                                modifier = modifier
                                    .size(29.dp)
                                    .padding(10.dp)
                            )
                            opensanstext(
                                text = "Bandung Barat Daya",
                                size = 11.sp,
                                fontFamily = opensansregular,
                                onItemclicked = {  },
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
        Spacer(modifier.height(40.dp)
        )
        profileCard(
            onItemclicked = {
                            navController.navigate(navScreen.premiumCategory.route)
            },
            image = painterResource(id = R.drawable.premium_1),
            text = "Premium"
        )
        Spacer(modifier.height(25.dp)
        )
        profileCard(
            onItemclicked = {
                            navController.navigate(navScreen.bantuanPage.route)
            },
            image = painterResource(id = R.drawable.icon_question),
            text = "Bantuan"
        )
        Spacer(modifier.height(25.dp)
        )
        profileCard(
            onItemclicked = {
                scope.launch {
                    isBottomSheetVisible = true
                    sheetState.expand()
                }
            },
            image = painterResource(id = R.drawable.icon_quit),
            text = "Keluar"
        )
        Spacer(modifier.height(144.dp)
        )
        aquaButton(
            color = Color(0xFF246DBB),
            width = 169.dp,
            height = 45.dp,
            textColor = Color.White,
            text = "Profile Settings",
            fontFamily = opensansbold,
        ){
            navController.navigate(navScreen.profilEdit.route)
        }
    }
    myBottomSheet(
        isBottomSheetVisible = isBottomSheetVisible,
        sheetState = sheetState,
        onDismiss = { scope.launch { sheetState.hide()}.invokeOnCompletion { isBottomSheetVisible = false }
        },
        navController = navController
    )
}