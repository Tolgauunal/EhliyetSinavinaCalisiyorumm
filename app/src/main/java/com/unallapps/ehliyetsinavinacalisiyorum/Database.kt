package com.unallapps.ehliyetsinavinacalisiyorum

data class Dersler(val id: Int, val name: String, val icon: Int)

data class Konular(val id: Int, val name: String, val icon: Int)
object DatabaseDersler {
    val derslerList = mutableListOf<Dersler>(
        Dersler(0, "İlk Yardım", R.drawable.ilkyardim),
        Dersler(1, "Trafik", R.drawable.car),
        Dersler(2, "Motor", R.drawable.engine))
}

object DatabaseKonular {
    val konularList = mutableListOf<Dersler>(Dersler(0, "Genel İlk Yardım Bilgileri", R.drawable.home),
        Dersler(0, "Hasta / Yaralının ve Olay Yerinin Değerlendirilmesi", R.drawable.home),
        Dersler(0, "Temel Yaşam Desteği", R.drawable.home),
        Dersler(0, "Kanamalarda İlkYardım", R.drawable.home),
        Dersler(0, "Yaralanmalarda İlkYardım", R.drawable.home),
        Dersler(0, "Yaralı Taşıma Teknikleri", R.drawable.home),
        Dersler(1, "Tanımlar", R.drawable.home),
        Dersler(1, "Trafik Polisinin Hareketleri ve Trafik Işıkları", R.drawable.home),
        Dersler(1, "Yol Çizgileri", R.drawable.home),
        Dersler(1, "Karayolunun Kullanılması Kuralları", R.drawable.home),
        Dersler(1, "Hız Kuralları", R.drawable.home),
        Dersler(1, "Sollama", R.drawable.home),
        Dersler(1, "Geçiş Üstünlüğü", R.drawable.home),
        Dersler(1, "Duraklama ve Parketme", R.drawable.home),
        Dersler(1, "Sis, Kısa ve Uzun Farlar", R.drawable.home),
        Dersler(1, "Arızalı Araçların Çekilmesi", R.drawable.home),
        Dersler(1, "ehlikeli Madde Taşınması", R.drawable.home),
        Dersler(1, "Okul Taşıtları", R.drawable.home),
        Dersler(1, "Otoyol Kuralları", R.drawable.home),
        Dersler(1, "Trafik Tescil İşlemleri", R.drawable.home),
        Dersler(1, "Araç Muayenesi", R.drawable.home),
        Dersler(1, "Asli Kusurlar", R.drawable.home),
        Dersler(2, "Motor Bilgisi", R.drawable.home),
        Dersler(2, "Araç gösterge paneli işaretleri ve anlamları", R.drawable.home),
        Dersler(2, "Dizel partikül filtresi nedir?", R.drawable.home),
        Dersler(2, "Kızdırma bujisi", R.drawable.home),
        Dersler(2, "Diferansiyel nedir?", R.drawable.home),
        Dersler(2, "Motor Konu Anlatımı Ders 2: Motorun Parçaları ve Görevleri", R.drawable.home),
        Dersler(2, "Motor nasıl çalışır?", R.drawable.home),
        Dersler(2, "Silindir kapağı", R.drawable.home),
        Dersler(2, "Silindir gömleği", R.drawable.home),
        Dersler(2, "Silindir kapak contası", R.drawable.home),
        Dersler(2, "Segman", R.drawable.home),
        Dersler(2, "Volan", R.drawable.home),
        Dersler(2, "Biyel Kolu", R.drawable.home),
        Dersler(2, "Hava filtresi", R.drawable.home),
        Dersler(2, "Piston", R.drawable.home),
        Dersler(2, "Krank mili nedir? ne işe yarar?", R.drawable.home)
        )
}