package com.example.aqua_care.ui.Presentation.Splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.aqua_care.DataStore.UserPreferences
import com.example.aqua_care.Navigation.navScreen
import kotlinx.coroutines.delay

@Composable
fun splashScreen(modifier: Modifier = Modifier, navController: NavController){
    val context = LocalContext.current
    val dataStore = UserPreferences(context)
    val getStatusLoggedIn = dataStore.getStatusLogin.collectAsState(initial = false)
    val isFirstTimeLaunch = dataStore.getFirstLaunch.collectAsState(initial = true)
    LaunchedEffect(
        key1 = true,
        block = {
            delay(2000L)
            if (isFirstTimeLaunch.value) {
                navController.navigate(navScreen.landingPage_1.route) {
                    popUpTo(navScreen.Splash.route) {
                        inclusive = true
                    }
                }
                dataStore.setFirstTimeLaunch(false)
            } else if (getStatusLoggedIn.value) {
                navController.navigate(navScreen.homePage.route) {
                    popUpTo(navScreen.Splash.route) {
                        inclusive = true
                    }
                }
            } else {
                navController.navigate(navScreen.loginPage.route) {
                    popUpTo(navScreen.Splash.route) {
                        inclusive = true
                    }
                }
            }
        }
    )
}