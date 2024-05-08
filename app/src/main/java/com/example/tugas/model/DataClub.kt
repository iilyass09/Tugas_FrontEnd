package com.example.tugas.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tugas.R
import com.example.tugas.model.DataClub.clubList
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update


class ClubViewModel : ViewModel(){
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _clubs = MutableStateFlow(clubList)
    val clubs2 = searchText
        .debounce(1000L)
        .onEach { _isSearching.update { true } }
        .combine(_clubs) { text,clubs ->
            if (text.isBlank()){
                clubs
            } else {
                delay(1500L)
                clubs.filter {
                    it.doesMatchSearchQuery(text)
                }
            }
        }
        .onEach { _isSearching.update { false } }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _clubs.value
        )

    fun onSearchTextChange(text : String){
        _searchText.value = text
    }
}

data class Club(
    val id: Int,
    val name: String,
    val description : String,
    val image : Int = 0
) {
  fun doesMatchSearchQuery(query: String):Boolean{
      val matchingCombinations = listOf(
          "$name",
      )
      return matchingCombinations.any{
          it.contains(query, ignoreCase = true)
      }
  }
}

object DataClub {
    val clubList = listOf(
        Club(
            id = 1,
            name = "AJAX AMSTERDAM",
            description  = "Amsterdamsche Football Club Ajax (Dutch pronunciation: [ˈaːjɑks]), also known as AFC Ajax, Ajax Amsterdam, or commonly Ajax, is a Dutch professional football club based in Amsterdam, that plays in the Eredivisie, the top tier in Dutch football. Historically, Ajax (named after the legendary Greek hero) is the most successful club in the Netherlands, with 36 Eredivisie titles and 20 KNVB Cups. It has continuously played in the Eredivisie since the league's inception in 1956, and along with Feyenoord and PSV Eindhoven, it is one of the country's big three clubs that have dominated that competition.",
            image = R.drawable.ajax
        ),
        Club(
            id = 2,
            name = "CHELSEA FC",
            description  = "Chelsea Football Club is an English professional football club based in Fulham, West London. Founded in 1905, the team play their home games at Stamford Bridge. The club competes in the Premier League, the top division of English football. It won its first major honour, the League championship, in 1955. The club won the FA Cup for the first time in 1970, their first European honour, the Cup Winners' Cup, in 1971, and became the third English club to win the Club World Cup in 2022.",
            image = R.drawable.chelsea
        ),
        Club(
            id = 3,
            name = "MANCHESTER UNITED",
            description  = "Manchester United Football Club, commonly referred to as Man United (often stylised as Man Utd), or simply United, is a professional football club based in Old Trafford, Greater Manchester, England. The club competes in the Premier League, the top division in the English football league system. Nicknamed the Red Devils, they were founded as Newton Heath LYR Football Club in 1878, but changed their name to Manchester United in 1902. After a spell playing in Clayton, Manchester.",
            image = R.drawable.manutd
        ),
        Club(
            id = 4,
            name = "MANCHESTER CITY",
            description  = "Manchester City Football Club is a professional football club based in Manchester, England, that competes in the Premier League, the top flight of English football. Founded in 1880 as St. Mark's (West Gorton), they became Ardwick Association Football Club in 1887 and Manchester City in 1894. The club's home ground is the City of Manchester Stadium in east Manchester, to which they moved in 2003, having played at Maine Road since 1923. Manchester City adopted their sky blue home shirts in 1894.",
            image = R.drawable.mancity
        ),
        Club(
            id = 5,
            name = "BARCELONA",
            description  = "Futbol Club Barcelona, commonly known as Barcelona and familiarly as Barça, is a professional football club based in Barcelona, Catalonia, Spain, that competes in La Liga, the top flight of Spanish football. Founded in 1899 by a group of Swiss, Catalan, German, and English footballers led by Joan Gamper, the club has become a symbol of Catalan culture and Catalanism, hence the motto Més que un club (More than a club).",
            image = R.drawable.barcelona
        ),
        Club(
            id = 6,
            name = "BAYERN MUNCHEN",
            description  = "Fußball-Club Bayern München e. V. Bayern Munich, or simply Bayern, is a German professional sports club based in Munich, Bavaria. It is best known for its professional men's association football team, which plays in the Bundesliga, the top tier of the German football league system. Bayern is the most successful club in German football history, having won a record 33 national titles, including eleven consecutively from 2013 to 2023, and 20 national cups, along with numerous European honours.",
            image = R.drawable.munich
        ),
        Club(
            id = 7,
            name = "DORTMUND",
            description  = "Ballspielverein Borussia 09 e. V. Dortmund, commonly known as Borussia Dortmund BVB, or simply Dortmund, is a German professional sports club based in Dortmund, North Rhine-Westphalia. It is best known for its men's professional football team, which plays in the Bundesliga, the top tier of the German football league system. The club have won eight league championships, five DFB-Pokals, one UEFA Champions League, one Intercontinental Cup, and one UEFA Cup Winners' Cup.",
            image = R.drawable.dortmund
        ),
        Club(
            id = 8,
            name = "INTER MILAN",
            description  = "Football Club Internazionale Milano, commonly referred to as Internazionale or simply Inter, and colloquially known as Inter Milan in English-speaking countries, is an Italian professional football club based in Milan, Lombardy. Inter is the only Italian side to have always competed in the top flight of Italian football since its debut in 1909.",
            image = R.drawable.inter
        ),
        Club(
            id = 9,
            name = "AC MILAN",
            description  = "Associazione Calcio Milan, commonly referred to as AC Milan or simply Milan, is an Italian professional football club based in Milan, Lombardy. Founded in 1899, the club competes in the Serie A, the top tier of Italian football, and has spent its entire history there with the exception of the 1980–81 and 1982–83 seasons.",
            image = R.drawable.milan
        ),
        Club(
            id = 10,
            name = "WESTHAM UNITED",
            description  = "Chelsea Football Club is an English professional football club based in Fulham, West London. Founded in 1905, the team play their home games at Stamford Bridge.[5] The club competes in the Premier League, the top division of English football. It won its first major honour, the League championship, in 1955. The club won the FA Cup for the first time in 1970, their first European honour, the Cup Winners' Cup, in 1971, and became the third English club to win the Club World Cup in 2022.",
            image = R.drawable.westham
        ),
    )
}