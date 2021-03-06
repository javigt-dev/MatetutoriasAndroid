package com.javier.matetutoriasandroid.ui.theme

import android.util.Log.d
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.javier.matetutoriasandroid.BottomMenuContent
import com.javier.matetutoriasandroid.Feature
import com.javier.matetutoriasandroid.R
import com.javier.matetutoriasandroid.standarQuadFromTo


@ExperimentalFoundationApi
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            GreetingSection()
            Favorites(favorites = listOf("Factorizacion", "Geometria", "Form. Notables"))
            agentClass()
            TemasPrincipales(
                features = listOf(
                    Feature(
                        title = "Geometria",
                        R.drawable.outline_subject_24,
                        BleuViolet1,
                        BleuViolet2,
                        BleuViolet3
                    ),
                    Feature(
                        title = "Algebra",
                        R.drawable.outline_subject_24,
                        LigthGreen1,
                        LigthGreen2,
                        LigthGreen3
                    ),
                    Feature(
                        title = "From. Notables",
                        R.drawable.outline_subject_24,
                        Beige1,
                        Beige2,
                        Beige3
                    ),
                    Feature(
                        title = "Trigonometria",
                        R.drawable.outline_subject_24,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    )
                )
            )
        }
        BottomMenu(
            items = listOf(
                BottomMenuContent(
                    title = "Inicio",
                    iconId = R.drawable.outline_home_24
                ),
                BottomMenuContent(
                    title = "Temas",
                    iconId = R.drawable.outline_list_alt_24
                ),
                BottomMenuContent(
                    title = "Logros",
                    iconId = R.drawable.outline_emoji_events_24
                ),
                BottomMenuContent(
                    title = "Perfil",
                    iconId = R.drawable.outline_account_circle_24
                ),
            ),
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighligthtColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighligthtColor = activeHighligthtColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor
            ) {
                selectedItemIndex = index

            }
        }
    }
}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighligthtColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighligthtColor else Color.Transparent)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if(isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = item.title,
            color = if (isSelected) activeTextColor else inactiveTextColor
        )
    }
}


@Composable
fun GreetingSection(
    name: String = "Javier"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Good Morning, $name",
                style = MaterialTheme.typography.h2
            )
            Text(
                text = "- Todo problema, tiene solucion -",
                style = MaterialTheme.typography.body1
            )
        }
        Icon(
            painter = painterResource(id = com.javier.matetutoriasandroid.R.drawable.outline_search_24),
            contentDescription = "Search",
            tint = TextWhite,
            modifier = Modifier.size(24.dp)
        )

    }
}

@Composable
fun Favorites(
    favorites: List<String>
){
    var selectedFavoriteIndex by remember{
        mutableStateOf(0)
    }
    LazyRow{
        items(favorites.size){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedFavoriteIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedFavoriteIndex == it) ButtonBlue
                        else DarkButtonBlue
                    )
                    .padding(15.dp)
            ){
                Text(text = favorites[it], color = TextWhite)
            }
        }
    }

}

@Composable
fun agentClass(
    color: Color = LightRed
){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ){
        Column {
            Text(
                text = "Agenda tu Clase",
                style = MaterialTheme.typography.h2
            )
            Text(
                text = "No pares de prepararte!!",
                style = MaterialTheme.typography.body1,
                color = TextWhite
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(10.dp)
        ){
            Icon(
                painter = painterResource(id = R.drawable.outline_edit_calendar_24),
                contentDescription = "Agenda tu cita",
                tint = Color.White,
                modifier = Modifier.size(16.dp)

            )
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun TemasPrincipales(features: List<Feature>){
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Temas Principales",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(15.dp)
        )
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ){
            items(features.size){
                featureItem(feature = features[it])
            }
        }
    }
}

@Composable
fun featureItem(
    feature: Feature
){
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        // Medium colored path
        val mediumColorPoint1 = Offset(0f, height * 0.3f)
        val mediumColorPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColorPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColorPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColorPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumColorPoint1.x, mediumColorPoint1.y)
            standarQuadFromTo(mediumColorPoint1, mediumColorPoint2)
            standarQuadFromTo(mediumColorPoint2, mediumColorPoint3)
            standarQuadFromTo(mediumColorPoint3, mediumColorPoint4)
            standarQuadFromTo(mediumColorPoint4, mediumColorPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        // Light colored path
        val lightColorPoint1 = Offset(0f, height * 0.35f)
        val lightColorPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightColorPoint3 = Offset(width * 0.3f, height * 0.05f)
        val lightColorPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightColorPoint5 = Offset(width * 1.4f, -height.toFloat() / 0.3f)

        val lightColoredPath = Path().apply {
            moveTo(lightColorPoint1.x, lightColorPoint1.y)
            standarQuadFromTo(lightColorPoint1, lightColorPoint2)
            standarQuadFromTo(lightColorPoint2, lightColorPoint3)
            standarQuadFromTo(lightColorPoint3, lightColorPoint4)
            standarQuadFromTo(lightColorPoint4, lightColorPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ){
            drawPath(
                path = mediumColoredPath,
                color = feature.mediumColor
            )
            drawPath(
                path = lightColoredPath,
                color = feature.lightColor
            )
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
        ){
            Text(
                text = feature.title,
                style = MaterialTheme.typography.h2,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(painter = painterResource(id = feature.iconId),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )
            Text(
                text = "Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {
                        //Accion por definir
                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp, horizontal = 15.dp)
            )
        }
    }
}





















