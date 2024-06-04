package com.example.aqua_care.Navigation

import android.app.Activity.RESULT_OK
import android.content.Context
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.aqua_care.Data.navbarComponents
import com.example.aqua_care.Screens.*
import com.google.android.gms.auth.api.identity.Identity
import kotlinx.coroutines.launch


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
    context: Context
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
                loginpage(navController = navController)
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
                profilePage(navController = navController)
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
