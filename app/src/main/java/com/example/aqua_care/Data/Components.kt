package com.example.aqua_care.Data

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.aqua_care.DataStore.UserPreferences
import com.example.aqua_care.Navigation.navScreen
import com.example.aqua_care.R
import kotlinx.coroutines.launch

val opensansregular = FontFamily(Font(R.font.opensansregular))
val opensansbold = FontFamily(Font(R.font.opensansbold))
val opensanslight = FontFamily(Font(R.font.opensanslight))
val opensanssemibold = FontFamily(Font(R.font.opensanssemibold))
val opensansextrabold = FontFamily(Font(R.font.opensansextrabold))


@Composable
fun opensanstext(
    text : String,
    size : TextUnit,
    fontFamily : FontFamily,
    onItemclicked : (() -> Unit)? = null,
    color : Color,
    modifier : Modifier = Modifier
){
    Text(
        text = text,
        fontFamily = fontFamily,
        fontSize = size,
        modifier = Modifier
            .clickable { onItemclicked?.invoke() },
        color = color
        )
}

@Composable
fun aquaButton(
    color : Color,
    width : Dp,
    height : Dp,
    textColor : Color,
    text : String,
    fontFamily: FontFamily,
    onItemclicked: (() -> Unit)

){
    Button(
        onClick = onItemclicked ,
        colors = ButtonDefaults.buttonColors(containerColor = color),
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .size(width, height)
    ){
        Text(
            text = text,
            fontSize = 14.sp,
            fontFamily = fontFamily,
            color = textColor
        )
    }
}


@Composable
fun aquatextfield(
    label: String,
    image: Painter? = null,
    width: Dp = 260.dp,
    height: Dp = 56.dp,
    imageSize: Dp = 24.dp,
    font: androidx.compose.ui.text.font.FontFamily,
    fontSize: TextUnit,
    text: String,
    onChange: (String) -> Unit,
    visualTransformation: androidx.compose.ui.text.input.VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    isPassword: Boolean = false
) {

    val (passwordVisible, setPasswordVisible) = remember { mutableStateOf(false) }

    Column {
        OutlinedTextField(
            modifier = Modifier
                .width(width)
                .height(height),
            value = text,
            onValueChange = onChange,
            label = {
                Text(
                    text = label,
                    fontFamily = font,
                    fontSize = fontSize
                )
            },
            leadingIcon = {
                if (image != null) {
                    Image(
                        painter = image,
                        contentDescription = null,
                        modifier = Modifier.size(imageSize)
                    )
                }
            },
            placeholder = {
                Text(
                    text = label,
                    fontFamily = font,
                    fontSize = fontSize
                )
            },
            visualTransformation = if (isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = keyboardOptions,
            textStyle = TextStyle(fontFamily = font, fontSize = fontSize),
            trailingIcon = {
                if (isPassword) {
                    IconButton(
                        onClick = { setPasswordVisible(!passwordVisible) },
                        modifier = Modifier.clickable(onClick = {
                            setPasswordVisible(!passwordVisible)
                        })
                    ) {
                        Icon(
                            imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = if (passwordVisible) "Hide password" else "Show password"
                        )
                    }
                } else {
                    null
                }
            }
        )
    }
}



@Composable
fun navbarComponents(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavigationBar(
        modifier
            .height(65.dp)
            .fillMaxWidth(),

    ){
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val navigationItems = listOf(
            bottomBar(
                title = "Home",
                icon = painterResource(id = R.drawable.icon_home),
                selectedIcon = painterResource(id = R.drawable.icon_home_selected),
                screen = navScreen.homePage
            ),
            bottomBar(
                title = "Perencana Jadwal",
                icon = painterResource(id = R.drawable.icon_plan),
                selectedIcon = painterResource(id = R.drawable.icon_plan_selected),
                screen = navScreen.jadwalPage
            ),
            bottomBar(
                title = "Scan Ikan",
                icon = painterResource(id = R.drawable.icon_ikan,),
                selectedIcon = painterResource(id = R.drawable.icon_ikan),
                screen = navScreen.scanPage
            ),
            bottomBar(
                title = "Chat Bot",
                icon = painterResource(id = R.drawable.icon_bot),
                selectedIcon = painterResource(id = R.drawable.icon_bot_selected),
                screen =  navScreen.chatbotPage
            ),
            bottomBar(
                title = "Profile",
                icon = painterResource(id = R.drawable.icon_profile),
                selectedIcon = painterResource(id = R.drawable.icon_profile_selected),
                screen = navScreen.profilePage
            ),
        )
        navigationItems.forEachIndexed {index, item ->
            val selected = currentRoute == item.screen.route
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = {
                    if (index != 2) {
                        Image(
                            painter = if (selected) item.selectedIcon else item.icon,
                            contentDescription = item.title,
                            modifier = Modifier.size(25.dp)
                        )
                    } else {
                        Image(
                            painter = if (selected) item.selectedIcon else item.icon,
                            contentDescription = item.title
                        )
                    }
                },
                colors = NavigationBarItemDefaults.colors(Color(0xFF246DBB))
            )
        }
    }
}

@Composable
fun topdetailBar(
    modifier: Modifier = Modifier,
    navController : NavController,
    onItemclicked: () -> Unit
){
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = modifier
            .fillMaxWidth()
            .height(83.dp)
            .background(Color(0xFF246DBB))
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom,
            modifier = modifier
                .fillMaxWidth()
                .height(83.dp)
                .padding(start = 15.dp, end = 15.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.icon_backarrow),
                contentDescription = null,
                modifier
                    .size(44.dp, 52.dp)
                    .clickable {
                        onItemclicked()
                    }
            )
            Image(
                painter = painterResource(id = R.drawable.icon_logonavbar),
                contentDescription = null,
                modifier
                    .size(44.dp, 52.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.icon_notification),
                contentDescription = null,
                modifier
                    .size(44.dp, 52.dp)
                    .clickable {
                        navController.navigate(navScreen.notification.route)
                    }
            )
        }
    }
}

@Composable
fun MainTopBar(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    Box(
        modifier
            .fillMaxWidth()
            .background(Color(0xFF246DBB))
            .height(83.dp)
    ){
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = modifier
                .fillMaxWidth()
                .height(83.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.icon_logonavbar),
                contentDescription = null,
                modifier
                    .size(44.dp, 52.dp)
            )
        }
        Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = modifier
                .fillMaxWidth()
                .height(83.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.icon_notification),
                contentDescription = null,
                modifier
                    .size(44.dp, 52.dp)
                    .offset(x = -15.dp)
                    .clickable {
                        navController.navigate(navScreen.notification.route)
                    }
            )
        }
    }
}




@Composable
fun modulLayout(
    modifier: Modifier = Modifier,
    modul : menuModul
){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFE2EDFD)
        ),
        modifier = modifier
            .size(205.dp, 124.dp)
            .padding(10.dp)
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(10.dp),
                clip = false
            )
            .then(
                modifier
                    .shadow(
                        elevation = 10.dp,
                        shape = RoundedCornerShape(10.dp),
                        clip = false
                    )
                    .offset(y = -8.dp)
            )
    ){
        Box(
            modifier
                .fillMaxSize()
                .padding(top = 10.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .fillMaxSize()
            ){
                Row(
                    modifier
                        .fillMaxWidth()
                        .height(19.dp)
                ) {
                    Row() {
                        Image(
                            painter = painterResource(id = R.drawable.icon_strip),
                            contentDescription = null
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Start,
                        modifier = modifier
                            .fillMaxSize()
                            .padding(start = 5.dp)
                    ) {
                        opensanstext(
                            text = modul.title,
                            size = 14.sp,
                            fontFamily = opensansextrabold,
                            onItemclicked = { },
                            color = Color(0xFF424373)
                        )
                    }
                }
                Spacer(modifier.height(16.dp)
                )
                opensanstext(
                    text = modul.description,
                    size = 10.sp,
                    fontFamily = opensansextrabold,
                    onItemclicked = {  },
                    color = Color(0xFF757575)
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun homeNavigator(
    modifier: Modifier = Modifier,
    image : Int = 0,
    text: String,
    onItemclicked: () -> Unit

){
    Card(onClick = { onItemclicked() },
        modifier = modifier
            .size(162.dp, 90.dp)
            .shadow(10.dp, RoundedCornerShape(10.dp)),
        border = BorderStroke(1.dp, Color(0xFF246DBB)),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ){
        Column(
            horizontalAlignment  = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxSize()
        ){
            Image(
                painter = painterResource(id = image),
                contentDescription = null
            )
            opensanstext(
                text = text,
                size = 13.sp,
                fontFamily = opensanssemibold,
                onItemclicked = {  },
                color = Color(0xFF246DBB)
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun beritaLayout(
    modifier: Modifier = Modifier,
    berita: berita,
    onItemClicked: (Int) -> Unit
){
    Card(
        onClick = { onItemClicked(berita.id) },
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F6F6)),
        modifier = modifier
            .size(248.dp)
            .shadow(10.dp, RoundedCornerShape(10.dp))
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp)
        ){
            Image(
                painter = painterResource(id = berita.image),
                contentScale = ContentScale.Crop,
                contentDescription = berita.title,
                modifier = modifier
                    .height(100.dp)
                    .width(200.dp)
                    .padding(bottom = 5.dp)
                    .clip(RoundedCornerShape(5.dp))
            )
            opensanstext(
                text = berita.title,
                size = 8.sp,
                fontFamily = opensanssemibold,
                onItemclicked = {  },
                color = Color(0xFF111111)
            )
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .fillMaxWidth()
            ){
                opensanstext(
                    text = berita.date,
                    size = 8.sp,
                    fontFamily = opensanssemibold,
                    onItemclicked = {  },
                    color = Color(0xFF969696)
                )
                Image(
                    painter = painterResource(id = R.drawable.forward_arrow),
                    contentDescription = null,
                    modifier
                        .size(20.dp)
                )
            }
        }
    }
}

@Composable
fun notif(
    modifier: Modifier = Modifier,
    image1 : Int = 0,
    image2 : Int = 0,
    title : String,
    description : String,
) {
    Card(
        modifier
            .size(323.dp , 60.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F6F6)),
        border = BorderStroke(1.dp, Color(0xFFD9D9D9))
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = modifier
                .fillMaxSize()
        ){
            Image(
                painter = painterResource(id = image1),
                contentDescription = null,
                modifier
                    .size(25.dp)
            )
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceAround,
            ){
                opensanstext(
                    text = title,
                    size = 16.sp,
                    fontFamily = opensansextrabold,
                    onItemclicked = {  },
                    color = Color(0xFF272727)
                )
                opensanstext(
                    text = description,
                    size = 9.sp,
                    fontFamily = opensansregular,
                    onItemclicked = {  },
                    color = Color(0xFF272727)
                )
            }
            Image(
                painter = painterResource(id = image2),
                contentDescription = null,
                modifier
                    .size(16.dp)
            )
        }
    }
}


@Composable
fun switch(
    modifier: Modifier = Modifier,
    onItemclickedFirstBox:  () -> Unit,
    onItemclickedSecondBox: () -> Unit

){
    var clickedFirstBox by remember { mutableStateOf(true) }
    var clickedSecondBox by remember { mutableStateOf(false) }
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(220.dp, 41.dp)
            .background(Color.White, RoundedCornerShape(5.dp))
            .border(1.dp, Color(0xFF246DBB), RoundedCornerShape(5.dp))
    ){
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxSize()
        ){
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier
                    .size(110.dp, 41.dp)
                    .padding(3.dp)
                    .background(
                        if (clickedFirstBox) Color(0xFF246DBB) else Color.White,
                        RoundedCornerShape(5.dp)
                    )
                    .clickable {
                        clickedFirstBox = true
                        clickedSecondBox = false
                        onItemclickedFirstBox()
                    }
            ){
                opensanstext(
                    text = "Dimiliki",
                    size = 12.sp,
                    fontFamily = opensansregular,
                    onItemclicked = {
                        clickedFirstBox = true
                        clickedSecondBox = false
                        onItemclickedFirstBox()
                    },
                    color = if (clickedFirstBox) Color(0xFFFFFFFF) else Color(0xFF246DBB)
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier
                    .size(110.dp, 41.dp)
                    .padding(3.dp)
                    .background(
                        if (clickedSecondBox) Color(0xFF246DBB) else Color.White,
                        RoundedCornerShape(5.dp)
                    )
                    .clickable {
                        clickedFirstBox = false
                        clickedSecondBox = true
                        onItemclickedSecondBox()
                    }
            ){
                opensanstext(
                    text = "Belum Dimiliki",
                    size = 12.sp,
                    fontFamily = opensansregular,
                    onItemclicked = {
                        clickedFirstBox = false
                        clickedSecondBox = true
                        onItemclickedSecondBox()
                    },
                    color = if (clickedSecondBox) Color(0xFFFFFFFF) else Color(0xFF246DBB)
                )
            }
        }
    }
}


@Composable
fun cardPremium(
    modifier: Modifier = Modifier,
    onItemclicked: () -> Unit
){
    Card(
        modifier = modifier
            .shadow(5.dp, RoundedCornerShape((15.dp)))
            .size(318.dp, 137.dp),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE2EDFD))
    ){
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(20.dp)
        ){
            opensanstext(
                text = "Ingin Mendalami ilmu budidaya ikan air tawar \n" +
                        "lebih dalam ? Beli Premium untuk melihat video pembelajaran sesuai kebutuhan",
                size = 12.sp,
                fontFamily = opensansregular,
                onItemclicked = {  },
                color = Color(0xFF434343)
            )
            aquaButton(
                color = Color(0xFF246DBB),
                width = 270.dp,
                height = 36.dp,
                text = "Beli Premium",
                fontFamily = opensansbold,
                textColor = Color.White
            ){
                onItemclicked()
            }
        }
    }
}

@Composable
fun moduleCard(
    modifier: Modifier = Modifier,
    image : Int = 0,
    text: String,
    title: String,
    profilepic : Int = 0,
    name : String,
    description: String,
    onItemClicked : () -> Unit



){
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(322.dp, 151.dp)
            .background(
                Color(0xFFFFFFFF),
                RoundedCornerShape(10.dp)
            )
            .border(
                1.dp, Color(0xFFD9D9D9), RoundedCornerShape(10.dp)
            )
            .clickable {
                onItemClicked()
            }
    ) {
        Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = modifier
                .fillMaxSize()
                .padding(5.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.archive),
                contentDescription = null
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = modifier
                    .fillMaxHeight()
            ){
                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    modifier = modifier
                        .size(82.dp, 102.dp)
                )
                opensanstext(
                    text = text,
                    size = 6.sp,
                    fontFamily = opensansbold,
                    onItemclicked = {  },
                    color = Color(0xFF828282)
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .fillMaxSize()

            ){
                opensanstext(
                    text = title,
                    size = 10.sp,
                    fontFamily = opensansbold,
                    onItemclicked = {  },
                    color = Color(0xFF272727)
                )
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(start = 40.dp, top = 10.dp)
                ){
                    Image(
                        painter = painterResource(id = profilepic),
                        contentDescription = null,
                        modifier = modifier
                            .size(26.dp)
                            .padding(end = 5.dp),
                    )
                    opensanstext(
                        text = name,
                        size = 8.sp,
                        fontFamily = opensansbold,
                        onItemclicked = {  },
                        color = Color(0xFF737272)
                    )

                }
                opensanstext(
                    text = description,
                    size = 8.sp,
                    fontFamily = opensansbold,
                    onItemclicked = {  },
                    color = Color(0xFF737272)
                )
            }
        }
    }
}


@Composable
fun premiummoduleCard(
    modifier: Modifier = Modifier,
    image : Int = 0,
    text: String,
    title: String,
    profilepic : Int = 0,
    name : String,
    description: String,
    onItemclicked: () -> Unit



) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(322.dp, 151.dp)
            .background(
                Color(0xFFFFFFFF),
                RoundedCornerShape(10.dp)
            )
            .border(
                1.dp, Color(0xFFD9D9D9), RoundedCornerShape(10.dp)
            )
            .clickable {
                onItemclicked()
            }
    ) {
        Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = modifier
                .fillMaxSize()
                .padding(5.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.locked),
                contentDescription = null
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = modifier
                    .fillMaxHeight()
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    modifier = modifier
                        .size(82.dp, 102.dp)
                )
                opensanstext(
                    text = text,
                    size = 6.sp,
                    fontFamily = opensansbold,
                    onItemclicked = { },
                    color = Color(0xFF828282)
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .fillMaxSize()

            ) {
                opensanstext(
                    text = title,
                    size = 10.sp,
                    fontFamily = opensansbold,
                    onItemclicked = { },
                    color = Color(0xFF272727)
                )
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(start = 40.dp, top = 10.dp)
                ) {
                    Image(
                        painter = painterResource(id = profilepic),
                        contentDescription = null,
                        modifier = modifier
                            .size(26.dp)
                            .padding(end = 5.dp),
                    )
                    opensanstext(
                        text = name,
                        size = 8.sp,
                        fontFamily = opensansbold,
                        onItemclicked = { },
                        color = Color(0xFF737272)
                    )

                }
                opensanstext(
                    text = description,
                    size = 8.sp,
                    fontFamily = opensansbold,
                    onItemclicked = { },
                    color = Color(0xFF737272)
                )
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(start = 40.dp, top = 10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.premium_1),
                        contentDescription = null,
                        modifier = modifier
                            .size(26.dp)
                            .padding(end = 5.dp),
                    )
                    opensanstext(
                        text = "Premium",
                        size = 11.sp,
                        fontFamily = opensansregular,
                        onItemclicked = { },
                        color = Color(0xFF272727)
                    )

                }
            }
        }
    }
}

    @Composable
    fun paymentCard(
        modifier: Modifier = Modifier,
        premium: premium,
        onItemclicked: (Int) -> Unit


    ) {
        Card(
            modifier = modifier
                .size(362.dp, 273.dp)
                .padding(10.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFE2EDFD)),
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top,
                modifier = modifier
                    .fillMaxSize()
                    .padding(
                        vertical = 20.dp,
                        horizontal = 12.dp
                    )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = modifier
                        .fillMaxWidth()
                        .height(59.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.SpaceAround,
                        horizontalAlignment = Alignment.Start,
                        modifier = modifier
                            .height(59.dp)
                    ) {
                        opensanstext(
                            text = premium.title,
                            size = 16.sp,
                            fontFamily = opensanssemibold,
                            onItemclicked = { },
                            color = Color(0xFF272727)
                        )
                        opensanstext(
                            text = premium.price,
                            size = 18.sp,
                            fontFamily = opensansbold,
                            onItemclicked = { },
                            color = Color(0xFF272727)
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.SpaceAround,
                        horizontalAlignment = Alignment.Start,
                        modifier = modifier
                            .height(59.dp)
                    ) {
                        opensanstext(
                            text = premium.length,
                            size = 16.sp,
                            fontFamily = opensansbold,
                            onItemclicked = { },
                            color = Color(0xFF272727)
                        )
                        opensanstext(
                            text = "Akses ke semua fitur",
                            size = 13.sp,
                            fontFamily = opensanssemibold,
                            onItemclicked = { },
                            color = Color(0xFF272727)
                        )
                    }
                }
                Spacer(
                    modifier.height(30.dp)
                )
                Row(
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.check_icon),
                        contentDescription = null,
                        modifier = modifier
                            .size(20.dp)
                    )
                    Spacer(
                        modifier.width(5.dp)
                    )
                    opensanstext(
                        text = "Gratis Video Edukasi",
                        size = 12.sp,
                        fontFamily = opensanssemibold,
                        onItemclicked = {},
                        color = Color(0xFF272727)
                    )
                }
                Spacer(
                    modifier.height(6.dp)
                )
                Row(
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.check_icon),
                        contentDescription = null,
                        modifier = modifier
                            .size(20.dp)
                    )
                    Spacer(
                        modifier.width(5.dp)
                    )
                    opensanstext(
                        text = "Akses Aqua Scan",
                        size = 12.sp,
                        fontFamily = opensanssemibold,
                        onItemclicked = {},
                        color = Color(0xFF272727)
                    )
                }
                Spacer(
                    modifier.height(6.dp)
                )
                Row(
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.check_icon),
                        contentDescription = null,
                        modifier = modifier
                            .size(20.dp)
                    )
                    Spacer(
                        modifier.width(5.dp)
                    )
                    opensanstext(
                        text = "Akses AquaBot",
                        size = 12.sp,
                        fontFamily = opensanssemibold,
                        onItemclicked = {},
                        color = Color(0xFF272727)
                    )
                }
                Spacer(
                    modifier.height(6.dp)
                )
                Box(
                    contentAlignment = Alignment.BottomCenter,
                    modifier = modifier
                        .fillMaxSize()
                ) {
                    aquaButton(
                        color = Color(0xFF246DBB),
                        width = 264.dp,
                        height = 36.dp,
                        text = "Mulai Berlangganan",
                        fontFamily = opensansbold,
                        textColor = Color.White
                    ) {
                        onItemclicked(premium.id)
                    }
                }
            }
        }
    }


    @Composable
    fun chatIcon(
        modifier: Modifier = Modifier,
        icon: Int = 0
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .size(35.dp)
                .background(Color(0xFF246DBB), RoundedCornerShape(50.dp))
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = modifier
                    .size(20.dp, 23.84.dp)
            )
        }
    }

    @Composable
    fun chatLayout(
        modifier: Modifier = Modifier,
        sender: String,
        text: String,
        topStart: Dp,
        topEnd: Dp

    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .background(
                    Color(0xFFA8DAF8),
                    RoundedCornerShape(
                        topStart = topStart,
                        topEnd = topEnd,
                        bottomStart = 11.dp,
                        bottomEnd = 11.dp
                    )
                )
                .padding(7.dp)
                .fillMaxWidth(0.5f)
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = modifier
            ) {
                opensanstext(
                    text = sender,
                    size = 12.sp,
                    fontFamily = opensansbold,
                    onItemclicked = { },
                    color = Color(0xFF272727)
                )
                Spacer(
                    modifier.height(3.dp)
                )
                opensanstext(
                    text = text,
                    size = 12.sp,
                    fontFamily = opensansregular,
                    onItemclicked = { },
                    color = Color(0xFF272727)
                )
            }
        }
    }


    @Composable
    fun cardType(
        modifier: Modifier = Modifier,
        image: Painter,
        text: String

    ) {
        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFFE6EEF7)),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(1.dp, Color(0xFFB2B2B2)),
            modifier = modifier
                .shadow(5.dp, RoundedCornerShape(10.dp))
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .padding(7.dp)
            ) {
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = modifier
                        .size(20.dp)
                )
                Spacer(modifier.width(3.dp))
                opensanstext(
                    text = text,
                    size = 12.sp,
                    fontFamily = opensansregular,
                    onItemclicked = { },
                    color = Color(0xFF246DBB)
                )
            }
        }
    }


    @Composable
    fun profileCard(
        modifier: Modifier = Modifier,
        onItemclicked: () -> Unit,
        image: Painter,
        text: String
    ) {
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, Color(0xFFACACAC)),
            modifier = modifier
                .size(288.dp, 43.dp)
                .shadow(5.dp)
                .clickable {
                    onItemclicked()
                }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = modifier
                    .fillMaxSize()
                    .padding(13.dp)
            ) {
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = modifier
                        .size(18.dp)
                )
                Spacer(
                    modifier.width(17.dp)
                )
                opensanstext(
                    text = text,
                    size = 14.sp,
                    fontFamily = opensansregular,
                    onItemclicked = { },
                    color = Color(0xFF272727)
                )
            }
        }
    }


    @Composable
    fun datatext(
        modifier: Modifier = Modifier,
        value: String,
        width: Dp,
        height: Dp,
    ) {
        var text by remember { mutableStateOf(value) }
        OutlinedTextField(
            value = text,
            onValueChange = { newValue ->
                text = newValue
            },
            modifier = modifier
                .size(width, height)
                .border(1.dp, Color(0xFFD9D9D9), RoundedCornerShape(5.dp))
                .background(Color.White, RoundedCornerShape(5.dp))
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun myBottomSheet(
        modifier: Modifier = Modifier,
        isBottomSheetVisible: Boolean,
        sheetState: SheetState,
        onDismiss: () -> Unit,
        navController: NavController,
    ) {
        val context = LocalContext.current
        val coroutineScope = rememberCoroutineScope()
        val dataStore = UserPreferences(context)
        if (isBottomSheetVisible) {
            ModalBottomSheet(
                onDismissRequest = onDismiss,
                sheetState = sheetState,
                containerColor = Color.White,
                contentColor = MaterialTheme.colorScheme.onSurface,
                shape = RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp),
                dragHandle = null,
                scrimColor = Color.Black.copy(alpha = .5f),
                windowInsets = WindowInsets(0, 0, 0, 0)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .height(162.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = modifier
                            .fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.topshotline),
                            contentDescription = null,
                            modifier
                                .size(34.dp, 4.dp)
                        )
                        Spacer(
                            modifier.height(32.dp)
                        )
                        opensanstext(
                            text = "Apakah kamu yakin ingin keluar ?",
                            size = 18.sp,
                            fontFamily = opensansbold,
                            onItemclicked = { },
                            color = Color(0xFF272727)
                        )
                        Spacer(
                            modifier.height(24.dp)
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround,
                            modifier = modifier
                                .fillMaxWidth()
                        ) {
                            aquaButton(
                                color = Color(0xFF246DBB),
                                width = 91.dp,
                                height = 33.dp,
                                textColor = Color.White,
                                text = "YA",
                                fontFamily = opensansbold
                            ) {
                                coroutineScope.launch {
                                    dataStore.clearStatus()
                                }
                                navController.navigate(navScreen.loginPage.route) {
                                    popUpTo(navScreen.Splash.route) {
                                        inclusive = true
                                    }
                                }
                            }
                            aquaButton(
                                color = Color.White,
                                width = 91.dp,
                                height = 33.dp,
                                textColor = Color(0xFF246DBB),
                                text = "TIDAK",
                                fontFamily = opensansbold
                            ) {
                                onDismiss()
                            }
                        }
                        Spacer(
                            modifier.height(24.dp)
                        )
                    }
                }
            }
        }
    }

@Composable
fun ChatBotTextField(
    modifier: Modifier = Modifier,
    label: String,
    width: Dp,
    height: Dp,
    imageSize: Dp,
    font: FontFamily,
    fontSize: TextUnit,
    text: String,
    onChange: (String) -> Unit
) {

    Row(
        modifier = Modifier
            .width(width)
            .height(height)
            .background(Color.Transparent),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = onChange,
            label = { Text(label) },
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = height)
                .weight(1f),
            textStyle = TextStyle(fontFamily = font, fontSize = fontSize),
            maxLines = Int.MAX_VALUE,
            singleLine = false
        )
    }
}