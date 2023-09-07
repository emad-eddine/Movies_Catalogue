package com.kichou.imad.moviescatalogue.presentation.screens.main_screen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kichou.imad.moviescatalogue.R
import com.kichou.imad.moviescatalogue.presentation.ui.theme.Roboto
import com.kichou.imad.moviescatalogue.presentation.ui.theme.WhiteText


@Composable
fun TopSection(
    modifier : Modifier = Modifier,
    modifier2 : Modifier = Modifier,
) {

    Text(
        text = stringResource(id = R.string.welcome),
        style = TextStyle(
            fontFamily = Roboto,
            fontWeight = FontWeight.Thin,
            fontSize = 18.sp
        ),
        color = WhiteText,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        textAlign = TextAlign.Start
    )

    Text(
        text = stringResource(id = R.string.new_releases),
        style = TextStyle(
            fontFamily = Roboto,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        ),
        color = WhiteText,
        modifier = modifier2
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp),
        textAlign = TextAlign.Start
    )

}