package com.example.tugas.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tugas.model.DataSepatu
import com.example.tugas.model.Sepatu
import com.example.tugas.ui.theme.poppins

@Composable
fun DetailSepatuScreen(
    modifier : Modifier = Modifier,
    navController: NavController,
    sepatusId : Int?
) {
    val newSepatusList = DataSepatu.sepatuList.filter { sepatu ->
        sepatu.id == sepatusId
    }
    Column(
        modifier = modifier
    ) {
        DetailSepatuContent(newSepatusList = newSepatusList)
    }
}

@Composable
private fun DetailSepatuContent(
    newSepatusList : List<Sepatu>,
    modifier : Modifier = Modifier
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier.padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .size(300.dp)
                    .fillMaxWidth(),
                painter = painterResource(id = newSepatusList[0].image),
                contentDescription = null
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = newSepatusList[0].name,
                textAlign = TextAlign.Start,
                fontFamily = poppins,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = newSepatusList[0].description,
                textAlign = TextAlign.Start,
                fontFamily = poppins,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp
            )
        }
    }
}