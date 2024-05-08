package com.example.tugas

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.navigation.NavController
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tugas.navigation.NavigationItem
import com.example.tugas.navigation.Screen
import com.example.tugas.screen.AboutScreen
import com.example.tugas.screen.DetailClubScreen
import com.example.tugas.screen.DetailPhotoScreen
import com.example.tugas.screen.DetailSepatuScreen
import com.example.tugas.screen.HomeScreen
import com.example.tugas.screen.PhotoScreen
import com.example.tugas.ui.theme.Gray2
import com.example.tugas.ui.theme.poppins

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Tugas(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        containerColor = Gray2,
        topBar = {
            val currentRoute = currentRoute(navController = navController)
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (currentRoute in listOf(Screen.Detail.route + "/{clubId}", Screen.Detail2.route + "/{sepatuId}", Screen.Detail3.route + "/{photoId}")) {
                            IconButton(onClick = { navController.popBackStack() }) {
                                Icon(
                                    modifier = Modifier.offset(x = (-5).dp),
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = stringResource(id = R.string.menu_share),
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = getTitleForRoute(route = currentRoute),
                            fontFamily = poppins,
                            modifier = Modifier
                                .padding(top = 4.dp)
                                .offset(x = (-5).dp)
                        )
                    }
                }
            )
        },
        bottomBar = {
            val currentRoute = currentRoute(navController = navController)
            if (currentRoute !in listOf(Screen.Detail2.route + "/{sepatuId}", Screen.Detail.route + "/{clubId}")) {
                BottomBar(navController)
            }

        },
        modifier = modifier
    ) { contentPadding->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(contentPadding)
        ) {
            composable(Screen.Home.route){
                HomeScreen(navController)
            }
            composable(Screen.Photo.route){
                PhotoScreen(navController)
            }
            composable(Screen.About.route){
                AboutScreen(navController)
            }
            composable(
                Screen.Detail2.route + "/{sepatuId}",
                arguments = listOf(navArgument("sepatuId") { type = NavType.IntType})
            ) { navBackStackEntry ->
                DetailSepatuScreen(
                    navController = navController,
                    sepatusId = navBackStackEntry.arguments?.getInt("sepatuId"))
            }
            composable(
                Screen.Detail.route + "/{clubId}",
                arguments = listOf(navArgument("clubId") { type = NavType.IntType})
            ) { navBackStackEntry ->
                DetailClubScreen(
                    navController = navController,
                    clubsId = navBackStackEntry.arguments?.getInt("clubId"))
            }
            composable(
                Screen.Detail3.route + "/{photoId}",
                arguments = listOf(navArgument("photoId") { type = NavType.IntType})
            ) { navBackStackEntry ->
                DetailPhotoScreen(
                    navController = navController,
                    photosId = navBackStackEntry.arguments?.getInt("photoId"))
            }
        }
    }
}


@Composable
fun BottomBar(
    navController : NavController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = Modifier,
        containerColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_home),
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_photo),
                icon = Icons.Default.Face,
                screen = Screen.Photo
        ),
            NavigationItem(
                title = stringResource(id = R.string.menu_about),
                icon = Icons.Default.AccountCircle,
                screen = Screen.About
            )
        )
        navigationItems.map { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route){
                        popUpTo(navController.graph.findStartDestination().id){
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(
                        text = item.title
                    )
                }
            )
        }
    }
}

@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

@Composable
fun getTitleForRoute(route: String?): String {
    return when (route) {
        Screen.Home.route -> stringResource(id = R.string.menu_home)
        Screen.Photo.route -> stringResource(id = R.string.menu_photo)
        Screen.About.route -> stringResource(id = R.string.menu_about)
        else -> {
            if (route?.startsWith(Screen.Detail.route) == true) {
                stringResource(id = R.string.menu_klub)
            } else if (route?.startsWith(Screen.Detail2.route) == true) {
                stringResource(id = R.string.menu_sepatu)
            } else if (route?.startsWith(Screen.Detail3.route) == true) {
                stringResource(id = R.string.menu_gunung)
            }else {
                stringResource(id = R.string.app_name)
            }
        }
    }

}