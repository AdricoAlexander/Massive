package com.example.aqua_care.Navigation

fun String?.BottomBar(): Boolean {
    return this in  setOf(
        navScreen.homePage.route,
        navScreen.jadwalPage.route,
        navScreen.chatbotPage.route,
        navScreen.profilePage.route
    )
}