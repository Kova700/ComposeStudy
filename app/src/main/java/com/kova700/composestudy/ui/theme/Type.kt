package com.kova700.composestudy.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kova700.composestudy.R

// Set of Material typography styles to start with
val doldamFont = FontFamily(Font(resId = R.font.hakgyoansim_doldam))

val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = doldamFont,
        fontSize = 50.sp,
        fontWeight = FontWeight.ExtraBold
    ),
    bodyLarge = TextStyle(
        fontFamily = doldamFont,
        fontSize = 50.sp,
        fontWeight = FontWeight.ExtraBold
    ),
    titleMedium = TextStyle(
        fontSize = 50.sp,
        fontWeight = FontWeight.Bold
    ),
    titleSmall = TextStyle(
        fontSize = 10.sp,
        fontWeight = FontWeight.SemiBold
    )
)