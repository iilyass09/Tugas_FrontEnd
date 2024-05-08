package com.example.tugas.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.tugas.R
import com.example.tugas.model.Club
import com.example.tugas.model.ClubViewModel
import com.example.tugas.model.DataClub
import com.example.tugas.model.DataSepatu
import com.example.tugas.model.Sepatu
import com.example.tugas.model.SepatuViewModel
import com.example.tugas.navigation.Screen
import com.example.tugas.ui.theme.componentsShapes

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    sepatus : List<Sepatu> = DataSepatu.sepatuList
) {
    val viewModel = viewModel<ClubViewModel>()
    val isSearching by viewModel.isSearching.collectAsState()
    val clubs by viewModel.clubs2.collectAsState()
    val viewModel2 = viewModel<SepatuViewModel>()
    val isSearching2 by viewModel2.isSearching2.collectAsState()
    val sepatus by viewModel2.sepatus2.collectAsState()

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
    ) {
        item {
            SearchBar2()
            LazyRow(
                modifier =Modifier.offset(y = (-30).dp),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(sepatus, key = { it.id }) {
                    SepatuItem(sepatu = it) { sepatuId ->
                        navController.navigate(Screen.Detail2.route + "/$sepatuId")
                    }
                    modifier.padding(horizontal = 16.dp)
                }
            }
            SearchBar()
        }
        items(clubs, key = { it.id }) {
            ClubItem(club = it) { clubId ->
                navController.navigate(Screen.Detail.route + "/$clubId")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    val viewModel = viewModel<ClubViewModel>()
    val isSearching by viewModel.isSearching.collectAsState()
    val clubs by viewModel.clubs2.collectAsState()
    val searchText by viewModel.searchText.collectAsState()
    Column (
        modifier = Modifier.fillMaxSize().offset(y = (-20).dp)
    ) {
        val textFieldModifier = Modifier
            .fillMaxWidth()
            .clip(componentsShapes.small)
            .padding(16.dp)

        OutlinedTextField(
            value = searchText,
            onValueChange = viewModel::onSearchTextChange,
            modifier = textFieldModifier,
            placeholder = { Text(text = "Cari Klub")},
            shape = RoundedCornerShape(20),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Black,
                focusedLabelColor = Color.Black,
                cursorColor = Color.Black,
            )
        )

        if (isSearching) {
            Spacer(modifier = Modifier.height(10.dp))
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar2() {
    val viewModel2 = viewModel<SepatuViewModel>()
    val isSearching2 by viewModel2.isSearching2.collectAsState()
    val sepatus by viewModel2.sepatus2.collectAsState()
    val searchText2 by viewModel2.searchText2.collectAsState()
    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        val textFieldModifier = Modifier
            .fillMaxWidth()
            .clip(componentsShapes.small)
            .padding(16.dp)

        OutlinedTextField(
            value = searchText2,
            onValueChange = viewModel2::onSearchTextChange,
            modifier = textFieldModifier,
            placeholder = { Text(text = "Cari Sepatu")},
            shape = RoundedCornerShape(20),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Black,
                focusedLabelColor = Color.Black,
                cursorColor = Color.Black,
            )
        )

        if (isSearching2) {
            Spacer(modifier = Modifier.height(10.dp))
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}


@Composable
fun ClubItem(
    club: Club,
    modifier: Modifier = Modifier,
    onItemClicked : (Int) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .offset(y = (-20).dp)
            .clickable {
            onItemClicked(club.id)
        }
    ) {
        Row {
        Image(
            painter = painterResource(id = club.image),
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .padding(8.dp)
                .size(84.dp)
        )
            Column {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = club.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    )
                Text(
                    text = "Lihat Detail",
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
fun SepatuItem(
    sepatu: Sepatu,
    modifier: Modifier = Modifier,
    onItemClicked2 : (Int) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable {
            onItemClicked2(sepatu.id)
        }
    ) {
        Image(
            painter = painterResource(id = sepatu.image),
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .padding(8.dp)
                .size(120.dp)
        )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = sepatu.name,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Lihat Detail",
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
    }
}
