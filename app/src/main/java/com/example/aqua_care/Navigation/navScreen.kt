package com.example.aqua_care.Navigation

import BeritaViewModel
import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.aqua_care.Berita.Retrofit.BeritaRepository
import com.example.aqua_care.Data.navbarComponents
import com.example.aqua_care.DataStore.AlarmRepository
import com.example.aqua_care.ViewModel.BeritaViewModelFactory
import com.example.aqua_care.ui.Presentation.Chat.chatbotPage
import com.example.aqua_care.ui.Presentation.Home.ModulConnect
import com.example.aqua_care.ui.Presentation.Home.aquaModul
import com.example.aqua_care.ui.Presentation.Home.homePage
import com.example.aqua_care.ui.Presentation.Jadwal.AlarmConnector
import com.example.aqua_care.ui.Presentation.Jadwal.JadwalPage
import com.example.aqua_care.ui.Presentation.Login.loginpage
import com.example.aqua_care.ui.Presentation.Notification.notification
import com.example.aqua_care.ui.Presentation.Onboarding.landingPage_1
import com.example.aqua_care.ui.Presentation.Onboarding.landingPage_2
import com.example.aqua_care.ui.Presentation.Onboarding.landingPage_3
import com.example.aqua_care.ui.Presentation.Payment.bayarFeedback
import com.example.aqua_care.ui.Presentation.Payment.paymentDetail
import com.example.aqua_care.ui.Presentation.Payment.premiumCategory
import com.example.aqua_care.ui.Presentation.Profile.bantuanPage
import com.example.aqua_care.ui.Presentation.Profile.profileEdit
import com.example.aqua_care.ui.Presentation.Profile.profilePage
import com.example.aqua_care.ui.Presentation.Register.signupPage
import com.example.aqua_care.ui.Presentation.Scan.scanPage
import com.example.aqua_care.ui.Presentation.Splash.splashScreen
import scanningResult


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
    object notification : navScreen("notification")
    object aquaModul : navScreen("aquaModul")
    object premiumCategory : navScreen("premiumCategory")
    object paymentDetail : navScreen("paymentDetail")
    object bayarFeedback : navScreen("bayarFeedback")
    object detailModulowned : navScreen("detailModulowned")
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
    alarmRepository: AlarmRepository
){

    val navController = rememberNavController()
    val repository = BeritaRepository()
    // Create ViewModel instance using the factory
    val viewModel: BeritaViewModel = viewModel(
        factory = BeritaViewModelFactory(repository)
    )


    Scaffold(
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            AnimatedVisibility(visible = currentRoute.BottomBar()){
                navbarComponents(navController = navController)
            }
        },
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = navScreen.Splash.route,
            modifier = Modifier.padding(contentPadding)
        ) {
            composable(route = navScreen.Splash.route) {
                splashScreen(navController = navController)
            }
            composable(route = navScreen.signupPage.route) {
                signupPage(navController = navController)
            }
            composable(route = navScreen.loginPage.route) {
                loginpage(navController = navController)
            }

            composable(route = navScreen.homePage.route) {
                homePage(navController = navController, viewModel = viewModel)
            }
            composable(route = navScreen.jadwalPage.route) {
                JadwalPage(navController = navController, alarmRepository = alarmRepository)
            }
            composable(route = navScreen.scanPage.route) {
                scanPage(navController = navController)
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
            composable(route = navScreen.premiumCategory.route) {
                premiumCategory(navController = navController)
            }
            composable(
                route = navScreen.paymentDetail.route + "/{itemId}",
                arguments = listOf(navArgument("itemId") { type = NavType.IntType })
            ) { navBackStackEntry ->
                paymentDetail(
                    paymentId = navBackStackEntry.arguments?.getInt("itemId"),
                    navController = navController
                )
            }
            composable(route = navScreen.bayarFeedback.route) {
                bayarFeedback(navController = navController)
            }
            composable(route = navScreen.detailModulowned.route + "/{modulId}",
                arguments = listOf(navArgument("modulId"){ type = NavType.IntType})
            ) { navBackStackEntry ->
                ModulConnect(
                    modulId = navBackStackEntry.arguments?.getInt("modulId"),
                    navController = navController
                )
            }
            composable(route = navScreen.landingPage_1.route) {
                landingPage_1(navController = navController)
            }
            composable(route = navScreen.landingPage_2.route) {
                landingPage_2(navController = navController)
            }
            composable(route = navScreen.landingPage_3.route) {
                landingPage_3(navController = navController)
            }
            composable(route = navScreen.profilEdit.route) {
                profileEdit(navController = navController)
            }
            composable(route = navScreen.bantuanPage.route) {
                bantuanPage(navController = navController)
            }
            composable(route = navScreen.scanningResult.route) {
                scanningResult(context = context, navController = navController)
            }
            composable(
                route = navScreen.detailJadwal.route + "/{alarmId}",
                arguments = listOf(navArgument("alarmId") { type = NavType.IntType })
            ) { navBackStackEntry ->
                AlarmConnector(
                    alarmId = navBackStackEntry.arguments?.getInt("alarmId"),
                    navController = navController,
                    alarmRepository = alarmRepository
                )
            }
        }
    }
}
