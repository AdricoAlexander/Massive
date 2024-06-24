package com.example.aqua_care.ui.Presentation.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aqua_care.Data.aquamodulData
import com.example.aqua_care.Data.cardPremium
import com.example.aqua_care.Data.opensansbold
import com.example.aqua_care.Data.opensansregular
import com.example.aqua_care.Data.opensanstext
import com.example.aqua_care.Data.switch
import com.example.aqua_care.Navigation.navScreen
import com.example.aqua_care.R

@Composable
fun aquaModul(
    modifier: Modifier = Modifier,
    navController: NavController
){
    val text = remember { mutableStateOf("") }
    val selectedItem = remember { mutableStateOf(1) }

    Box(
        modifier = modifier.fillMaxSize()
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxSize()
        ){
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = modifier
                    .fillMaxWidth()
                    .background(Color(0xFF246DBB))
                    .padding(horizontal = 15.dp)
                    .height(83.dp)
            ){
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = modifier.fillMaxWidth()
                ){
                    Image(
                        painter = painterResource(id = R.drawable.icon_backarrow),
                        contentDescription = null,
                        modifier = Modifier
                            .size(44.dp, 52.dp)
                            .clickable {
                                navController.navigate(navScreen.homePage.route)
                            }
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = modifier.fillMaxWidth()
                ){
                    Image(
                        painter = painterResource(id = R.drawable.icon_logonavbar),
                        contentDescription = null,
                        modifier = Modifier.size(44.dp, 52.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(11.dp))

            switch(
                onItemclickedFirstBox = { selectedItem.value = 1 },
                onItemclickedSecondBox = { selectedItem.value = 2 }
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = text.value,
                onValueChange = { text.value = it },
                trailingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.icon_search),
                        contentDescription = null,
                        modifier = Modifier.size(23.dp)
                    )
                },
                modifier = Modifier.size(305.dp, 42.dp),
                shape = RoundedCornerShape(20.dp),
                placeholder = {
                    opensanstext(
                        text = "Cari modul atau video pembelajaran",
                        size = 8.sp,
                        fontFamily = opensansregular,
                        onItemclicked = {  },
                        color = Color(0xFF969696)
                    )
                }
            )

            Spacer(modifier = Modifier.height(20.dp))

            when (selectedItem.value) {
                1 -> owned(navController = navController)
                2 -> notowned(navController = navController)
                else -> Unit
            }
        }
    }
}



@Composable
fun owned(
    modifier: Modifier = Modifier,
    navController: NavController
){
    val modul = remember { aquamodulData.modulList }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        cardPremium {
            navController.navigate(navScreen.premiumCategory.route)
        }
        Spacer(
            modifier.height(32.dp)
        )
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = modifier
                .fillMaxWidth()
        ) {
            opensanstext(
                text = "Modul yang dimilki (2)",
                size = 13.sp,
                fontFamily = opensansbold,
                onItemclicked = { },
                color = Color(0xFF272727)
            )
            Spacer(
                modifier.height(16.dp)
            )

            LazyColumn(
                modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(
                    items = modul, key = { it.id },
                    itemContent = {
                        ModulLayout(modul = it) { modulId ->
                            navController.navigate(navScreen.detailModulowned.route + "/$modulId")
                        }
                    }
                )
            }
        }
    }
}


@Composable
fun notowned(
    modifier: Modifier = Modifier,
    navController: NavController
){
    val premiumModul = remember { aquamodulData.premiumModulList }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
    ){
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(
                items = premiumModul,
                key = { it.id }
            ) { premiumModul ->
                PremiumModulLayout(
                    premiumModul = premiumModul,
                    onClicked = { premModulId ->
                        navController.navigate(navScreen.detailmodulnotOwned.route + "/$premModulId")
                    }
                )
            }
        }
    }
}