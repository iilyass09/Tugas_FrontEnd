package com.example.tugas.screen

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tugas.model.DataPhoto
import com.example.tugas.model.Photo
import com.example.tugas.ui.theme.poppins

@Composable
fun DetailPhotoScreen(
    modifier : Modifier = Modifier,
    navController: NavController,
    photosId : Int?
) {
    val newPhotosList = DataPhoto.photoList.filter { photo ->
        photo.id == photosId
    }
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .padding(horizontal = 10.dp)
            ) {
                DetailPhotoContent(newPhotosList = newPhotosList)
            }
        }
    }
}

@Composable
private fun DetailPhotoContent(
    newPhotosList : List<Photo>,
    modifier : Modifier = Modifier,
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
                    .fillMaxWidth()
                    .height(500.dp),
                painter = painterResource(id = newPhotosList[0].image),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = newPhotosList[0].name,
                textAlign = TextAlign.Start,
                fontFamily = poppins,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = newPhotosList[0].description,
                textAlign = TextAlign.Start,
                fontFamily = poppins,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp
            )
        }
    }
}