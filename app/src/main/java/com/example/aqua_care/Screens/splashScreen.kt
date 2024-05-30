package com.example.aqua_care.Screens

import android.provider.ContactsContract.Data
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.aqua_care.DataStore.UserPreferences
import com.example.aqua_care.MainViewModelFactory
import com.example.aqua_care.Navigation.navScreen
import com.example.aqua_care.ViewModel.DataStoreViewModel

@Composable
fun splashScreen(modifier: Modifier = Modifier, navController: NavController){
    val context = LocalContext.current
    val userPreferences = UserPreferences(context)
    val viewModelFactory = MainViewModelFactory(userPreferences)
    val viewModel:  DataStoreViewModel = viewModel(factory = viewModelFactory)
    val isLoggedIn by viewModel.isLoggedIn.collectAsState()
    LaunchedEffect(
        key1 = true,
        block = {
            if (isLoggedIn){
                navController.navigate(navScreen.homePage.route){
                    popUpTo(navScreen.Splash.route){
                        inclusive = true
                    }
                }
            }else{
                navController.navigate(navScreen.loginPage.route){
                    popUpTo(navScreen.Splash.route){
                        inclusive = true
                    }
                }
            }
        }
    )
}