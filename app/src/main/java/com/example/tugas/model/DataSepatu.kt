package com.example.tugas.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tugas.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class SepatuViewModel : ViewModel(){
    private val _searchText2 = MutableStateFlow("")
    val searchText2 = _searchText2.asStateFlow()

    private val _isSearching2 = MutableStateFlow(false)
    val isSearching2 = _isSearching2.asStateFlow()

    private val _sepatus = MutableStateFlow(DataSepatu.sepatuList)
    val sepatus2 = searchText2
        .debounce(1000L)
        .onEach { _isSearching2.update { true } }
        .combine(_sepatus) { text,sepatus ->
            if (text.isBlank()){
                sepatus
            } else {
                delay(1500L)
                sepatus.filter {
                    it.doesMatchSearchQuery2(text)
                }
            }
        }
        .onEach { _isSearching2.update { false } }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _sepatus.value
        )

    fun onSearchTextChange(text : String){
        _searchText2.value = text
    }
}

data class Sepatu(
    val id: Int,
    val name: String,
    val description : String,
    val image : Int = 0
) {
    fun doesMatchSearchQuery2(query: String):Boolean{
        val matchingCombinations = listOf(
            "$name",
        )
        return matchingCombinations.any{
            it.contains(query, ignoreCase = true)
        }
    }
}

object DataSepatu {
    val sepatuList = listOf(
        Sepatu(
            id = 1,
            name = "SPEZIAL 1",
            description  = "The adidas Handball Spezial Collegiate Green Burgundy is a stylish and iconic shoe designed for handball and other indoor sports. With its vibrant green color and burgundy accents, this shoe is sure to make a statement on and off the court. Made by adidas, a trusted and renowned brand in athletic footwear, these shoes are built for performance and durability. Whether you're playing a game or just want to rock a cool pair of sneakers, the adidas Handball Spezial Collegiate Green Burgundy is the perfect choice.",
            image = R.drawable.spezial
        ),
        Sepatu(
            id = 2,
            name = "SPEZIAL 2",
            description  = "The adidas Handball Spezial Black Orange is a stylish and durable shoe perfect for any indoor or outdoor sports activities. With its sleek black design and striking orange accents, it is a must-have for athletes who want to make a statement. The shoe features exceptional grip and stability, ensuring optimum performance on the court or field. Trust the adidas brand for quality and style.",
            image = R.drawable.spezial2
        ),
        Sepatu(
            id = 3,
            name = "TRAINER 1",
            description  = "Chronicling Blackpool, Brighton and Cleethorpes – the ‘Seaside Series’ is a celebration of seaside tradition. Boasting a loud and proud colourway, the yellow and red silhouette commemorates a North West seaside town – Blackpool. Nodding specifically to the iconic Tower Ballroom, this shoe also nods to the local football team on the colouring of the second lace. On the underside of the left tongue, there’s the start of the postcode in shiny gold, while this tone carries onto the lateral sidewall branding. With the staple 3-Stripes, Trefoils and sticky rubber soles, this is a classic adidas silhouette with a fun nod to a celebrated English seaside town.",
            image = R.drawable.trainer
        ),
        Sepatu(
            id = 4,
            name = "TRAINER 2",
            description  = "The Adidas BC Trainer Cleethorpes Seaside Series Exclusive GY9861 is a limited-edition sneaker inspired by the seaside town of Cleethorpes in England. It features a turquoise suede upper with white accents, a gum rubber outsole, and a leather lining. The shoe is comfortable and stylish, and is perfect for everyday wear. It is currently available for sure.",
            image = R.drawable.trainer2
        ),
        Sepatu(
            id = 5,
            name = "HOCHELAGA",
            description  = "FIntroducing the adidas Hochelaga SPZL Indigo Solar Yellow sneakers. Crafted by adidas, these sneakers combine style and comfort. With a sleek design and vibrant indigo and solar yellow colors, these shoes are perfect for any casual or sporty outfit. Elevate your footwear game with these adidas sneakers.",
            image = R.drawable.hochelaga
        ),
        Sepatu(
            id = 6,
            name = "MUNCHEN",
            description  = "Elevate your style and comfort with the adidas Munchen 'City Series' FV1190 sneakers. Crafted with premium materials and featuring an eye-catching design inspired by vibrant cityscapes, these sneakers are both stylish and durable. The responsive cushioning ensures all-day comfort, while the high-traction outsole provides stability on any surface. Perfect for urban explorers and casual wear enthusiasts, the Munchen 'City Series' FV1190 combines functionality and modern flair. Step into a world of comfort and style with these must-have sneakers.",
            image = R.drawable.munchen1
        ),
        Sepatu(
            id = 7,
            name = "MUNCHEN 2",
            description  = "Step out in style with the adidas Munchen Scarlet Gum FX5665 sneaker. This iconic design from adidas features a bold scarlet colorway and a durable gum sole perfect for adding a pop of color to your everyday look. Ideal for sneaker enthusiasts looking to make a statement.",
            image = R.drawable.munchen2
        ),
        Sepatu(
            id = 8,
            name = "GAZELLE",
            description  = "From football fans in the ’60s and ’70s to skaters and indie rockers in the ’90s, the adidas Gazelle shoes have traversed the cultural landscape and the globe. They’ve become a true staple with plenty of personality. These trainers are a one-to-one reissue of the 1991 Gazelle, with the same materials, proportions and textures as the original. A suede upper with tonal serrated 3-Stripes and the classic T-toe adds timeless style to every look.",
            image = R.drawable.gazelle
        ),
        Sepatu(
            id = 9,
            name = "GAZELLE 2",
            description  = "The adidas Gazelle Collegiate Green Hazy Sky sneakers are a stylish and comfortable choice for any sneakerhead. Featuring a trendy green colorway and a sleek design, these sneakers are perfect for everyday wear. Made by adidas, a trusted and renowned brand in the sneaker world, you can trust in the quality and durability of these shoes. Whether you're hitting the streets or running errands, these adidas Gazelle sneakers will keep you looking and feeling great.",
            image = R.drawable.gazelle2
        ),
        Sepatu(
            id = 10,
            name = "SAMBA",
            description  = "Elevate your street style with adidas Samba OG 'Black Gum'. The iconic silhouette, dressed in sleek black with a gum sole, exudes classic urban charm. Crafted for comfort and versatility, these sneakers effortlessly blend athletic heritage with contemporary fashion, making them a staple for trendsetters and sneaker enthusiasts alike.",
            image = R.drawable.samba
        ),
    )
}