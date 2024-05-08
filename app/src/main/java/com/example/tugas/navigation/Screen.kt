package com.example.tugas.navigation

sealed class Screen(val route : String){
    object Home : Screen("home")
    object Photo : Screen("photo")
    object About : Screen("about")
    object Detail : Screen("detail_club")
    object Detail2 : Screen("detail_sepatu")
    object Detail3 : Screen("detail_photo")
}
