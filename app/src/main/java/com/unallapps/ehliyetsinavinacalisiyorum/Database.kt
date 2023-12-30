package com.unallapps.ehliyetsinavinacalisiyorum

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class Dersler(val id: Int, val name: String, val icon: Int)

@Parcelize
data class Konular(val id: Int, val name: String, val icon: Int) : Parcelable
object DatabaseDersler {
    val derslerList = mutableListOf(
        Dersler(0, "İlk Yardım", R.drawable.ilkyardim),
        Dersler(1, "Trafik", R.drawable.car),
        Dersler(2, "Motor", R.drawable.engine))
}

object DatabaseKonular {
    val konularList = mutableListOf(Konular(0, "Genel İlk Yardım Bilgileri", R.drawable.ilkyardim),
        Konular(0, "Hasta / Yaralının ve Olay Yerinin Değerlendirilmesi", R.drawable.ilkyardimbir),
        Konular(0, "Temel Yaşam Desteği", R.drawable.ilkyardimiki),
        Konular(0, "Kanamalarda İlkYardım", R.drawable.ilkyardimuc),
        Konular(0, "Yaralanmalarda İlkYardım", R.drawable.ilkyardimdort),
        Konular(0, "Yaralı Taşıma Teknikleri", R.drawable.ilkyardimalti),
        Konular(1, "Tanımlar", R.drawable.trafikbir),
        Konular(1, "Trafik Polisinin Hareketleri ve Trafik Işıkları", R.drawable.trafikiki),
        Konular(1, "Yol Çizgileri", R.drawable.trafikuc),
        Konular(1, "Karayolunun Kullanılması Kuralları", R.drawable.trafikbes),
        Konular(1, "Hız Kuralları", R.drawable.trafikalti),
        Konular(1, "Sollama", R.drawable.trafikdort),
        Konular(1, "Geçiş Üstünlüğü", R.drawable.trafikyedi),
        Konular(1, "Duraklama ve Parketme", R.drawable.trafikdokuz),
        Konular(1, "Sis, Kısa ve Uzun Farlar", R.drawable.trafikon),
        Konular(1, "Arızalı Araçların Çekilmesi", R.drawable.trafikonbir),
        Konular(1, "Tehlikeli Madde Taşınması", R.drawable.trafikonik),
        Konular(1, "Okul Taşıtları", R.drawable.trafikonuc),
        Konular(1, "Otoyol Kuralları", R.drawable.trafikondort),
        Konular(1, "Trafik Tescil İşlemleri", R.drawable.car),
        Konular(1, "Araç Muayenesi", R.drawable.trafikonbes),
        Konular(1, "Asli Kusurlar", R.drawable.trafiksekiz),
        Konular(2, "Motor Bilgisi", R.drawable.motorbir),
        Konular(2, "Araç gösterge paneli işaretleri ve anlamları", R.drawable.motoriki),
        Konular(2, "Dizel partikül filtresi nedir?", R.drawable.motoruc),
        Konular(2, "Kızdırma bujisi", R.drawable.motordort),
        Konular(2, "Diferansiyel nedir?", R.drawable.motoralti),
        Konular(2, "Motorun Parçaları ve Görevleri", R.drawable.motorbes),
        Konular(2, "Motor nasıl çalışır?", R.drawable.motoryedi),
        Konular(2, "Silindir kapağı", R.drawable.motorsekiz),
        Konular(2, "Silindir gömleği", R.drawable.motoronalit),
        Konular(2, "Silindir kapak contası", R.drawable.motordokuz),
        Konular(2, "Segman", R.drawable.motoron),
        Konular(2, "Volan", R.drawable.motoronbir),
        Konular(2, "Biyel Kolu", R.drawable.motoronik),
        Konular(2, "Hava filtresi", R.drawable.motoronuc),
        Konular(2, "Piston", R.drawable.motorondort),
        Konular(2, "Krank mili nedir? ne işe yarar?", R.drawable.motoronbes)
        )
}