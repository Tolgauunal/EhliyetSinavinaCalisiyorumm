package com.unallapps.ehliyetsinavinacalisiyorum

import android.graphics.drawable.Icon

data class Dersler(val id: Int, val name: String, val icon: Int)

data class Konular(val id: Int, val name: String, val icon: Int)
object DatabaseDersler {
    val derslerList = mutableListOf<Dersler>(Dersler(0, "Ders1", R.drawable.home),
        Dersler(0, "Ders2", R.drawable.home),
        Dersler(0, "Ders3", R.drawable.home),
        Dersler(0, "Ders4", R.drawable.home))
}

object DatabaseKonular {
    val konularList = mutableListOf<Dersler>(Dersler(0, "Konular1", R.drawable.home),
        Dersler(0, "Konular2", R.drawable.home),
        Dersler(0, "Konular3", R.drawable.home),
        Dersler(0, "Konular4", R.drawable.home),
        Dersler(1, "Konular1", R.drawable.home),
        Dersler(2, "Konular2", R.drawable.home),
        Dersler(2, "Konular3", R.drawable.home),
        Dersler(2, "Konular4", R.drawable.home),
        Dersler(2, "Konular1", R.drawable.home),
        Dersler(2, "Konular2", R.drawable.home),
        Dersler(2, "Konular3", R.drawable.home),
        Dersler(2, "Konular4", R.drawable.home),
        )
}