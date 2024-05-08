package com.example.tugas.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tugas.R
import com.example.tugas.ui.theme.poppins

@Composable
fun AboutScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(horizontal = 10.dp)
    ) {
        Box(modifier = Modifier.weight(1f)) {
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
                        AboutMe()
                    }
                }
            }
        }
    }
}

@Composable
fun AboutMe() {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Spacer(modifier = Modifier.height(80.dp))
        Image(
            painter = painterResource(id = R.drawable.ilyas),
            contentDescription = null,
            modifier = Modifier
                .size(300.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Hi, Im Ilyas",
            fontSize = 40.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = poppins
        )
        Text(
            text = "m.ilyasalfadlih@gmail.com",
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = poppins
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier
                .width(250.dp),
            text = "I,m a Android Developer & UI/UX Design",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = poppins,
            textAlign = TextAlign.Center,
            lineHeight = 30.sp
        )
        Spacer(modifier = Modifier.height(50.dp))
        Image(
            painter = painterResource(id = R.drawable.bottom),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(70.dp))
        Text(
            modifier = Modifier
                .width(380.dp),
            text = "Hi, I'm Muhammad Ilyas Al-Fadhlih from Bandung, I come from the Bandung National Institute of Technology majoring in Informatics Engineering, I'm currently in my 6th semester and taking part in the Independent Campus program, namely independent study with Infinite Learning partners, I'm taking part in the Android Developer and UI UX Design programs.",
            textAlign = TextAlign.Center,
            fontSize = 17.sp,
        )
        Spacer(modifier = Modifier.height(100.dp))
    }
}