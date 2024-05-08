package com.example.tugas.model

import com.example.tugas.R

data class Photo(
    val id: Int,
    val name: String,
    val description : String,
    val image : Int = 0
)

object DataPhoto {
    val photoList = listOf(
        Photo(
            id = 1,
            name = "GUNUNG MERBABU",
            description  = "Gunung Merbabu adalah gunung api yang bertipe Stratovulcano yang terletak secara geografis pada 7,5° LS dan 110,4° BT. Secara administratif gunung ini berada di wilayah Kabupaten Magelang di lereng sebelah barat dan Kabupaten Boyolali di lereng sebelah timur dan selatan, Kabupaten Semarang di lereng sebelah utara, Provinsi Jawa Tengah.",
            image = R.drawable.merbabu
        ),
        Photo(
            id = 2,
            name = "GUNUNG SEMERU",
            description  = "Gunung Semeru atau Gunung Meru adalah sebuah gunung berapi kerucut di Jawa Timur, Indonesia. Gunung Semeru merupakan gunung tertinggi di Pulau Jawa, dengan puncaknya Mahameru, 3.676 meter dari permukaan laut (mdpl). Gunung ini terbentuk akibat subduksi Lempeng Indo-Australia kebawah Lempeng Eurasia.",
            image = R.drawable.semeru
        ),
        Photo(
            id = 3,
            name = "GUNUNG SINDORO",
            description  = "Gunung Sindoro atau Gunung Sundoro (puncak ketinggian 3.153 mdpl) merupakan sebuah gunung volkano aktif yang terletak di Jawa Tengah, Indonesia, dengan Temanggung sebagai kota terdekat. Gunung Sindoro terletak berdampingan dengan Gunung Sumbing. Gunung sindara dapat terlihat jelas dari puncak sikunir dieng",
            image = R.drawable.sindoro
        ),
        Photo(
            id = 4,
            name = "GUNUNG SUMBING",
            description  = "Gunung Sumbing adalah gunung api yang terdapat di Jawa Tengah, Indonesia. (Ketinggian puncak 3.371 mdpl), gunung Sumbing merupakan gunung tertinggi ketiga di Pulau Jawa setelah Gunung Semeru dan Gunung Slamet. Gunung ini secara administratif terletak di tiga wilayah kabupaten, yaitu Kabupaten Magelang; Kabupaten Temanggung; dan Kabupaten Wonosobo. ",
            image = R.drawable.sumbing
        ),
        Photo(
            id = 5,
            name = "GUNUNG RINJANI",
            description  = "Gunung Rinjani adalah gunung yang berlokasi di Pulau Lombok, Nusa Tenggara Barat. Gunung yang merupakan gunung berapi kedua tertinggi di Indonesia dengan ketinggian 3.726 mdpl serta terletak pada lintang 8º25' LS dan 116º28' BT ini merupakan gunung favorit bagi pendaki Indonesia karena keindahan pemandangannya.",
            image = R.drawable.rinjani
        ),
        Photo(
            id = 6,
            name = "GUNUNG KERINCI",
            description  = "Gunung Kerinci (juga dieja dengan \"Kerintji\") adalah gunung tertinggi di pulau Sumatra dan gunung berapi tertinggi di Indonesia juga Asia Tenggara. Gunung Kerinci terletak di perbatasan Kabupaten Kerinci, Jambi dan Kabupaten Solok Selatan, Sumatera Barat, di Pegunungan Bukit Barisan dengan ketinggian 3.805 mdpl. ",
            image = R.drawable.kerinci
        ),
        Photo(
            id = 7,
            name = "GUNUNG MERAPI",
            description  = "Gunung Merapi (ketinggian puncak 2.930 mdpl, per 2010) adalah gunung berapi di bagian tengah Pulau Jawa dan merupakan salah satu gunung api teraktif di Indonesia. Lereng sisi selatan berada dalam administrasi Kabupaten Sleman, Daerah Istimewa Yogyakarta,",
            image = R.drawable.merapi
        ),
        Photo(
            id = 8,
            name = "GUNUNG GEDE",
            description  = "Gunung Prau adalah salah satu gunung di Dataran Tinggi Dieng, Jawa Tengah, Indonesia memiliki ketinggian puncak 2.590 mdpl terletak pada koordinat 7°11′13″S 109°55′22″E. Gunung ini merupakan tapal batas empat kabupaten di Jawa Tengah, yaitu Kabupaten Batang, Kabupaten Kendal, Kabupaten Temanggung dan Kabupaten Wonosobo.",
            image = R.drawable.gede
        ),
        Photo(
            id = 9,
            name = "GUNUNG PRAU",
            description  = "Gunung Gede merupakan sebuah gunung berapi kerucut yang berada di bagian barat Pulau Jawa, Indonesia. Gunung Gede berada dalam ruang lingkup Taman Nasional Gede Pangrango, yang merupakan salah satu dari lima taman nasional yang pertama kali diumumkan di Indonesia pada tahun 1980.",
            image = R.drawable.prau
        ),
        Photo(
            id = 10,
            name = "GUNUNG SLAMET",
            description  = "Gunung Slamet adalah sebuah gunung berapi kerucut tipe A yang berada di Jawa Tengah, Indonesia, dan merupakan gunung tunggal yang terpisah dari pegunungan. Gunung Slamet memiliki ketinggian 3.432 mdpl[1] dan terletak di antara 5 kabupaten, yaitu Kabupaten Banyumas, Kabupaten Purbalingga, Kabupaten Pemalang, Kabupaten Tegal dan Kabupaten Brebes",
            image = R.drawable.slamet
        )
    )
}