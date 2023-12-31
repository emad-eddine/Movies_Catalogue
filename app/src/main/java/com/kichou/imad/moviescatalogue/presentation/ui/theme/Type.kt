package com.kichou.imad.moviescatalogue.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kichou.imad.moviescatalogue.R


// add roboto font

val Roboto = FontFamily(
    listOf(
        Font(R.font.roboto_bold , FontWeight.Bold),
        Font(R.font.roboto_black , FontWeight.Black),
        Font(R.font.roboto_medium , FontWeight.Medium),
        Font(R.font.roboto_regular , FontWeight.Normal),
        Font(R.font.roboto_thin , FontWeight.Thin)
    )
)



// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    displayMedium = TextStyle(
        fontFamily = Roboto
    )


    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)