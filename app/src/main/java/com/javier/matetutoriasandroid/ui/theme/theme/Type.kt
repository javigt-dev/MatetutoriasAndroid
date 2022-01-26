package com.javier.matetutoriasandroid.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.javier.matetutoriasandroid.R

// Set of Material typography styles to start with
//val Typography = Typography(
//    body1 = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp
//    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )

)
 */

val mateFuente = FontFamily(
    listOf(
        Font(R.font.balsamiqsans_bold, FontWeight.Bold),
        Font(R.font.balsamiqsans_bolditalic, FontWeight.ExtraBold),
        Font(R.font.balsamiqsans_italic, FontWeight.SemiBold),
        Font(R.font.balsamiqsans_bold, FontWeight.Normal)
    )
)

val TypoMatetuto = Typography(
    body1 = TextStyle(
        color = AquaBlue,
        fontFamily = mateFuente,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    h1 = TextStyle(
        color = TextWhite,
        fontFamily = mateFuente,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    h2 = TextStyle(
        color = TextWhite,
        fontFamily = mateFuente,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )
)