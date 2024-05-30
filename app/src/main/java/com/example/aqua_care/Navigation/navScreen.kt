package com.example.aqua_care.Navigation

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.aqua_care.Data.navbarComponents
import com.example.aqua_care.Screens.*
import com.example.aqua_care.ViewModel.DataStoreViewModel

sealed class navScreen(val route: String) {
    object landingPage_1 : navScreen("landingPage_1")
    object landingPage_2 : navScreen("landingPage_2")
    object landingPage_3 : navScreen("landingPage_3")
    object signupPage : navScreen("signupPage")
    object loginPage : navScreen("loginPage")
    object homePage : navScreen("homePage")
    object jadwalPage : navScreen("jadwalPage")
    object scanPage : navScreen("scanPage")
    object chatbotPage : navScreen("chatbotPage")
    object profilePage : navScreen("profilePage")
    object detailBerita : navScreen("detailBerita")
    object notification : navScreen("notification")
    object aquaModul : navScreen("aquaModul")
    object premiumCategory : navScreen("premiumCategory")
    object paymentDetail : navScreen("paymentDetail")
    object bayarFeedback : navScreen("bayarFeedback")
    object detailModulowned : navScreen("detailModulowned")
    object detailmodulnotOwned : navScreen("detailmodulnotOwned")
    object profilEdit : navScreen("profileEdit")
    object bantuanPage : navScreen("bantuanPage")
    object scanningResult : navScreen("scanningResult")
    object detailJadwal : navScreen("detailJadwal")
    object Splash : navScreen("SplashScreen")
}


@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    context: Context,
    viewModel: DataStoreViewModel
){
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            AnimatedVisibility(visible = currentRoute.BottomBar()){
                Box(
                    modifier
                        .border(
                            border = BorderStroke(1.5.dp, Color(0xFF246DBB)),
                            shape = RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp)
                        )
                ) {
                    navbarComponents(navController = navController)
                }
            }
        },
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = navScreen.Splash.route,
            modifier = Modifier.padding(contentPadding)
        ) {
            composable(route = navScreen.Splash.route){
                splashScreen(navController = navController)
            }
            composable(route = navScreen.signupPage.route) {
                signupPage(navController = navController)
            }
            composable(route = navScreen.loginPage.route) {
                loginpage(navController = navController,
                    viewModel = viewModel)
            }

            composable(route = navScreen.homePage.route) {
                homePage(navController = navController)
            }
            composable(route = navScreen.jadwalPage.route) {
                jadwalPage(navController = navController)
            }
            composable(route = navScreen.scanPage.route) {
                scanPage(navController = navController, context = context)
            }
            composable(route = navScreen.chatbotPage.route) {
                chatbotPage()
            }
            composable(route = navScreen.profilePage.route) {
                profilePage(navController = navController,
                    viewModel = viewModel)
            }
            composable(route = navScreen.aquaModul.route) {
                aquaModul(navController = navController)
            }
            composable(route = navScreen.notification.route) {
                notification(navController = navController)
            }
            composable(route = navScreen.detailBerita.route) {
                detailBerita(navController = navController)
            }
            composable(route = navScreen.premiumCategory.route) {
                premiumCategory(navController = navController)
            }
            composable(route = navScreen.paymentDetail.route + "/{itemId}",
                arguments = listOf(navArgument("itemId"){type = NavType.IntType})
            ){navBackStackEntry ->
                paymentDetail(paymentId = navBackStackEntry.arguments?.getInt("itemId"), navController = navController)
            }
            composable(route = navScreen.bayarFeedback.route){
                bayarFeedback(navController = navController)
            }
            composable(route = navScreen.detailModulowned.route){
                detailModulowned(navController = navController)
            }
            composable(route = navScreen.detailmodulnotOwned.route){
                detailmodulnotOwned(navController = navController)
            }
            composable(route = navScreen.landingPage_1.route){
                landingPage_1(navController = navController)
            }
            composable(route = navScreen.landingPage_2.route){
                landingPage_2(navController = navController)
            }
            composable(route = navScreen.landingPage_3.route){
                landingPage_3(navController = navController)
            }
            composable(route = navScreen.profilEdit.route){
                profileEdit(navController = navController)
            }
            composable(route = navScreen.bantuanPage.route){
                bantuanPage(navController = navController)
            }
            composable(route = navScreen.scanningResult.route){
                scanningResult(navController = navController, context = context)
            }
            composable(route = navScreen.detailJadwal.route + "/{isFeedEnabled}",
                arguments = listOf(navArgument("isFeedEnabled"){ type = NavType.BoolType})
            ){navBackStackEntry ->
                detailJadwal(navController = navController, isFeedEnabled = navBackStackEntry.arguments?.getBoolean("isFeedEnabled") ?:false)
            }
    }
}
}
