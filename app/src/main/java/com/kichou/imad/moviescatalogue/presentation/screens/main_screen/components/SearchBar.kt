package com.kichou.imad.moviescatalogue.presentation.screens.main_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kichou.imad.moviescatalogue.presentation.ui.theme.Roboto
import com.kichou.imad.moviescatalogue.presentation.ui.theme.WhiteText


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    onValueChanged : (String) -> Unit
) {

    var searchField by remember{
        mutableStateOf("")
    }

    OutlinedTextField(value = searchField, onValueChange = {
        searchField = it
        onValueChanged(it)
    },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        shape = RoundedCornerShape(100.dp),
        maxLines = 1,
        textStyle = TextStyle(
            fontFamily = Roboto,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Start,
            fontSize = 14.sp
        ),
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search,
                contentDescription =null,
                modifier = Modifier
                    .size(16.dp),
                tint = Color.White)
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = WhiteText,
            containerColor = MaterialTheme.colorScheme.tertiary,
            cursorColor = WhiteText,

        )
    )

}