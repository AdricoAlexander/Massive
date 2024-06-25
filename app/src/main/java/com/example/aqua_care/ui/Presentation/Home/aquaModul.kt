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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.aqua_care.Data.Modul
import com.example.aqua_care.Data.opensansregular
import com.example.aqua_care.Data.opensanstext
import com.example.aqua_care.Navigation.navScreen
import com.example.aqua_care.R
import com.example.aqua_care.ViewModel.SearchViewModel

@Composable
fun aquaModul(
    modifier: Modifier = Modifier,
    navController: NavController
){
    val viewModel = viewModel<SearchViewModel>()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val modul by viewModel.modul.collectAsState()

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

            Spacer(modifier = Modifier.height(23.dp))
            OutlinedTextField(
                value = searchQuery,
                onValueChange =  viewModel::onSearchTextChange,
                trailingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.icon_search),
                        contentDescription = null,
                        modifier = Modifier.size(23.dp)
                    )
                },
                modifier = Modifier.size(305.dp, 50.dp),
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
            owned(navController = navController, modul = modul)
        }
    }
}



@Composable
fun owned(
    modifier: Modifier = Modifier,
    navController: NavController,
    modul: List<Modul>
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = modifier
                .fillMaxWidth()
        ) {
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
