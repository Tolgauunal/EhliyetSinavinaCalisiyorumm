package com.unallapps.ehliyetsinavinacalisiyorum.data

import android.os.Parcelable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.unallapps.ehliyetsinavinacalisiyorum.R
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.InformationCards
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.InformationCardsInfo
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestlerEntity
import kotlinx.parcelize.Parcelize
import javax.annotation.concurrent.Immutable

data class Lesson(val id: Int, val name: String, val icon: Int)

@Parcelize
data class Subject(val id: Int, val name: String, val icon: Int) : Parcelable


@Immutable
object DatabaseLesson {
    val derslerList = mutableListOf(
        Lesson(0, "İlk Yardım", R.drawable.ilkyardimm),
        Lesson(1, "Trafik", R.drawable.carr),
        Lesson(2, "Motor", R.drawable.enginee)
    )
}

@Immutable
object DatabaseSubject {
    val subjectLists = mutableListOf(
        Subject(0, "Genel İlk Yardım Bilgileri", R.drawable.ilkyardim),
        Subject(0, "Hasta, Yaralının ve Olay Yerinin Değerlendirilmesi", R.drawable.ilkyardimbir),
        Subject(0, "Temel Yaşam Desteği", R.drawable.ilkyardimiki),
        Subject(0, "Kanamalarda İlk Yardım", R.drawable.ilkyardimuc),
        Subject(0, "Yaralanmalarda İlk Yardım", R.drawable.ilkyardimdort),
        Subject(0, "Yaralı Taşıma Teknikleri", R.drawable.ilkyardimalti),
        Subject(1, "Tanımlar", R.drawable.trafikbir),
        Subject(1, "Trafik Polisinin Hareketleri ve Trafik Işıkları", R.drawable.trafikiki),
        Subject(1, "Yol Çizgileri", R.drawable.trafikuc),
        Subject(1, "Karayolunun Kullanılması Kuralları", R.drawable.trafikbes),
        Subject(1, "Hız Kuralları", R.drawable.trafikalti),
        Subject(1, "Sollama", R.drawable.trafikdort),
        Subject(1, "Geçiş Üstünlüğü", R.drawable.trafikyedi),
        Subject(1, "Duraklama ve Parketme", R.drawable.trafikdokuz),
        Subject(1, "Sis, Kısa ve Uzun Farlar", R.drawable.trafikon),
        Subject(1, "Arızalı Araçların Çekilmesi", R.drawable.trafikonbir),
        Subject(1, "Tehlikeli Madde Taşınması", R.drawable.trafikonik),
        Subject(1, "Okul Taşıtları", R.drawable.trafikonuc),
        Subject(1, "Otoyol Kuralları", R.drawable.trafikondort),
        Subject(1, "Trafik Tescil İşlemleri", R.drawable.car),
        Subject(1, "Araç Muayenesi", R.drawable.trafikonbes),
        Subject(1, "Asli Kusurlar", R.drawable.trafiksekiz),
        Subject(1, "Trafik İşaret Levhaları", R.drawable.trafikonbes),
        Subject(2, "Motor Bilgisi", R.drawable.motorbir),
        Subject(2, "Araç gösterge paneli işaretleri ve anlamları", R.drawable.motoriki),
        Subject(2, "Dizel partikül filtresi nedir?", R.drawable.motoruc),
        Subject(2, "Kızdırma bujisi", R.drawable.motordort),
        Subject(2, "Diferansiyel nedir?", R.drawable.motoralti),
        Subject(2, "Motorun Parçaları ve Görevleri", R.drawable.motorbes),
        Subject(2, "Motor nasıl çalışır?", R.drawable.motoryedi),
        Subject(2, "Silindir kapağı", R.drawable.motorsekiz),
        Subject(2, "Silindir gömleği", R.drawable.motoronalit),
        Subject(2, "Silindir kapak contası", R.drawable.motordokuz),
        Subject(2, "Segman", R.drawable.motoron),
        Subject(2, "Volan", R.drawable.motoronbir),
        Subject(2, "Biyel Kolu", R.drawable.motoronik),
        Subject(2, "Hava filtresi", R.drawable.motoronuc),
        Subject(2, "Piston", R.drawable.motorondort),
        Subject(2, "Krank mili nedir? ne işe yarar?", R.drawable.motoronbes)
    )
}

val fontFamily = FontFamily(
    Font(R.font.nunitosans)
)

@Immutable
object DatabaseInformationCard {
    val informationCardData = mutableListOf(
        InformationCards(
            id = 0, "Araç gösterge paneli işaretleri ve anlamları",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    1,
                    "Ön sis lambalarınızın açık olduğunu gösteren ikaz ışığıdır."
                ),
                InformationCardsInfo(
                    2,
                    "Arka sis lambalarınızın açık olduğunu gösteren ikaz ışığıdır."
                ),
                InformationCardsInfo(
                    3,
                    "Sağa ya da sola sinyal verdiğinizi gösteren ikaz ışığıdır."
                ),
                InformationCardsInfo(
                    4,
                    "Uzun farlarınızın açık olduğunu gösteren ikaz ışığıdır."
                ),
                InformationCardsInfo(
                    5,
                    "Kısa farlar, sinyal ve stop lambalarının birinin açık ya da arızalı olduğunu gösteren ikaz ışığıdır."
                ),
                InformationCardsInfo(
                    6,
                    "Arabanızdaki far ya da lambalardan herhangi birinin arızalı olduğunu gösteren ikaz ışığıdır."
                ),
                InformationCardsInfo(
                    7,
                    "Arabanızdaki fren lambalarından birinin ampulünün arızalı olduğunu gösteren ikaz ışığıdır."
                ),
                InformationCardsInfo(
                    8,
                    "Adaptif ışık sisteminin arızalı olduğunu gösteren ikaz ışığıdır."
                ),
                InformationCardsInfo(
                    9,
                    "Aracınızın far seviye kontrol sisteminde sorun olduğunu gösteren ikaz ışığıdır."
                ),
                InformationCardsInfo(
                    10,
                    "Kısa farların açık olması durumunda yanan ikaz ışığıdır."
                ),
                InformationCardsInfo(
                    11,
                    "Akünün arızalı olması, akünün bitmesi, şarj dinamosu arızası gibi durumlarda yanan ikaz ışığıdır."
                ),
                InformationCardsInfo(
                    12,
                    "Motorun çalışması için marşla beraber fren pedalına basmanız gerektiği gösteren ikaz ışığıdır.",
                    "Bu özellik genelde son model arabalarda oluyor. Frene basmadan marşa basarsanız araba çalışmıyor."
                ),
                InformationCardsInfo(
                    13,
                    "Partikül filtresinin kurumla dolduğunu gösteren ikaz ışığıdır.",
                    "Bu ikaz ışığı yanan araçların motorları kendilerini korumaya alarak belli bir hızın üzerine çıkmanıza izin vermiyor. Bu durumda yapmanız gereken aracınızı en yakın yetkili servise götürmektir."
                ),
                InformationCardsInfo(
                    14,
                    "Katalizör sisteminde arıza olması durumunda yanan ikaz ışığıdır.",
                    "Bu sistem egzozdan çıkan zararlı gazları çevre için zararsız hale getirir."
                ),
                InformationCardsInfo(
                    15, "Yakıt filtresindeki su seviyesinin arttığını gösterir.",
                    "Genelde kalitesiz yakıt alan sürücüler bu durumla karşılaşırlar. Bu ikaz ışığı ile karşılaşmanız durumunda yakıt filtresinde su, filtrenin alt kısmındaki tahliye musluğu açılarak boşaltılmalıdır."
                ),
                InformationCardsInfo(
                    16,
                    "Motor hava filtresinin kirli ya da eskimiş olduğunu gösteren ikaz ışığıdır.",
                    "Bu ikaz ışığı yandığında en kısa zamanda hava filtresinin temizlenmesi ya da değişmesi gerekir."
                ),
                InformationCardsInfo(
                    17,
                    "Motor soğutma sıvısının fazla ısındığını gösteren ikaz ışığıdır.",
                    "Bu ikaz ışığı yandığında motoru hemen stop edip, motorun soğumasını beklemeniz gerekir."
                ),
                InformationCardsInfo(
                    18,
                    "Yakıt filtresinin kirli ya da eskimiş olduğunu gösteren ikaz ışığıdır.",
                    "En kısa zamanda yakıt filtresini temizletmeniz ya da değiştirmeniz gerekir."
                ),
                InformationCardsInfo(
                    19,
                    "Yakıt seviyesinin azaldığını gösteren ikaz ışığıdır."
                ),
                InformationCardsInfo(
                    20, "Yağ seviyesinin azaldığını gösteren ikaz ışığıdır.",
                    "Bu durumda yapmanız gereken aracınızın yağ seviyesini kontrol etmek ve eksik olan yağı tamamlamaktır."
                ),
                InformationCardsInfo(
                    21, "Motor arızası olduğunu gösteren ikaz ışığıdır.",
                    "Bu gösterge aracınızı çalıştırırken yanar ve söner. Eğer aracınız çalıştıktan sonra bu ikaz ışığı sönmüyorsa aracınızı acilen servise götürmeniz gerekir. Ciddi bir motor arızası olabilir."
                ),
                InformationCardsInfo(
                    22, "Fren balatalarının aşındığını gösteren ikaz ışığıdır.",
                    "En yakın zamanda fren balatalarını değiştirmeniz gerekmektedir."
                ),
                InformationCardsInfo(
                    23,
                    "Otomatik vitesli araçlarda görülen bu ikaz ışığı, vites kolunu oynatabilmek için frene basmanız gerektiğini gösterir."
                ),
                InformationCardsInfo(24, "Hava süspansiyon ikaz ışığı"),
                InformationCardsInfo(
                    25,
                    "Süspansiyon sisteminin arızalandığını gösteren ikaz ışığıdır."
                ),
                InformationCardsInfo(
                    26,
                    "Otomatik vitesin arızalandığını gösteren ikaz ışığıdır."
                ),
                InformationCardsInfo(
                    27,
                    "Dışarıdaki hava durumunu gösteren ikaz ışığıdır."
                ),
                InformationCardsInfo(
                    28,
                    "Aydınlık ve yağmur sensörünü gösteren ikaz ışığıdır."
                ),
                InformationCardsInfo(
                    29,
                    "Ön camın buz çözme özelliğinin aktif olduğunu gösteren ikaz ışığıdır."
                ),
                InformationCardsInfo(
                    30,
                    "Arka camın buz çözme özelliğinin aktif olduğunu gösteren ikaz ışığıdır."
                ),
                InformationCardsInfo(
                    31,

                    "Yağmur sensörünün aktif olduğunu gösteren ikaz ışığıdır."
                ),
                InformationCardsInfo(
                    32,
                    "Otomatik cam sileceğinin aktif olduğunu gösteren ikaz ışığıdır."
                ),
                InformationCardsInfo(
                    33,
                    "Dizel motorlarda bulunan ısıtma bujilerini gösteren ikaz ışığıdır.",
                    "Kızdırma bujilerinin ikaz ışığı sönmeden marşa basılmamalıdır."
                ),
                InformationCardsInfo(
                    34,
                    "Buzlu ve kaygan yollarda kullanılması gereken kış modu butonu.",
                    "Bu özellik bazı araçlarda bulunmamaktadır."
                ),
                InformationCardsInfo(
                    35, "Takip mesafesi ikaz ışığıdır.",
                    "Bu özellik bazı araçlarda bulunmamaktadır."
                ),
                InformationCardsInfo(
                    36, "Hız sınırının aşıldığını gösteren ikaz ışığıdır.",
                    "Bu özellik bazı araçlarda bulunmamaktadır."
                ),
                InformationCardsInfo(
                    37,
                    "Sinyal vermeden şerit değiştirmeniz durumunda yanan ikaz ışığıdır.",
                    "Bu özellik bütün araçlarda bulunmamaktadır."
                ),
                InformationCardsInfo(
                    38,
                    "Kapılardan birinin açık olduğunu gösteren ikaz ışığıdır."
                ),
                InformationCardsInfo(
                    39,
                    "Emniyet kemerlerinden birinin takılı olmadığını gösteren ikaz ışığıdır."
                ),
                InformationCardsInfo(
                    40,
                    "Lastik basıncının düşük olması durumunda yanan ikaz ışığıdır."
                ),
                InformationCardsInfo(
                    41, "Anahtarın arabada olmadığını gösteren ikaz ışığıdır.",
                    "Bu özellik yalnızca anahtarsız çalışan araçlarda bulunmaktadır."
                ),
                InformationCardsInfo(
                    42,
                    "Park lambasının aktif olduğunu gösteren ikaz ışığıdır."
                ),
                InformationCardsInfo(
                    43,
                    "Park etme yardım sisteminin aktif olduğunu gösteren ikaz ışığıdır."
                ),
                InformationCardsInfo(44, "Direksiyon kilidi arıza uyarısı.")
            )
        ),
        InformationCards(
            id = 1,
            lessonName = "Araç Muayenesi",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Hususi otomobiller ile bunların her türlü römorkları: Trafiğe çıkarılışından sonra ilk 3 yaş sonunda ve devamında her 2 yılda bir.",
                    details = null
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Resmi ve ticari plakalı e bunların her türlü römorkları: İlk trafiğe çıkışından itibaren ilk 2 yaş sonunda devamında yılda 1.",
                    details = null
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Lastik tekerlekli traktörler ve bunların her türlü römorkları: İlk trafiğe çıkışından itibaren ilk 3 yaş sonunda ve devamında her 3 yılda bir.",
                    details = null
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Diğer bütün motorlu araçlar ile bunların her türlü römorkları: ilk bir yaş sonunda ve devamında her yıl periyodik muayeneye tabi tutulur.",
                    details = null
                ),
                InformationCardsInfo(
                    id = 5,
                    description = "Motorlu taşıtın muayene süresi dolmamış olsa bile; Kazaya karışması sonucu yetkili zabıtaca muayenesi görülen araçlar, Üzerinde değişiklik yapılan araçlar ayrıca özel muayeneye tabi tutulurlar.",
                    details = null
                ),
                InformationCardsInfo(
                    id = 6,
                    description = "Araç üzerinde yönetmelikte belirtilen şekilde yapılacak her türlü değişikliğin araç sahibi tarafından 30 gün içinde yetkili tescil kuruluşuna bildirilmesi mecburidir.",
                    details = null
                ),
                InformationCardsInfo(
                    id = 7,
                    description = "Uyuşturucu ve keyif verici maddeleri almış olanlar: Derhal araç kullanmaktan men olurlar.",
                    details = null
                ),
                InformationCardsInfo(
                    id = 8,
                    description = "Uyuşturucu ve keyif verici maddeleri almış olanlar: Mahkeme kararıyla para ve hapis cezası ile cezalandırılır, sürücü belgesi süresiz olarak geri alınır.",
                    details = null
                )
            )
        ),
        InformationCards(
            id = 2,
            lessonName = "Arızalı Araçların Çekilmesi",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Freni arızalı olmayan araçların çekilmesi",
                    details = "Çekme halatı, çekme zinciri veya çekme demiri ile çekilir. Çekme halatının uzunluğu en fazla 5m. olmalıdır. Halatın uzunluğu 2,5m. geçerse kırmızı yansıtıcı bağlanmalı. Hız saatte 20km olmalı."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Freni arızalı olan araçların çekilmesi",
                    details = "Çeki demiri ile çekilmeli. Demir uzunluğu en fazla 1m. olmalı. Hız saatte 15km. geçmemeli."
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "NOT",
                    details = "Her iki durumda da yolcu ve yük taşınmamalı."
                )
            )
        ),
        InformationCards(
            id = 3,
            lessonName = "Asli Kusurlar",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Kırmızı ışıkta geçmek ve Trafik polisinin dur ikazına uymamak.",
                    details = null
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Şeride tecavüz etmek.",
                    details = null
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Bir araca arkadan çarpmak.",
                    details = null
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Karşı yönden gelen şerit ve yol bölümünden gitmek.",
                    details = null
                ),
                InformationCardsInfo(
                    id = 5,
                    description = "Sollama kurallarına uymadan araç sollamak.",
                    details = null
                ),
                InformationCardsInfo(
                    id = 6,
                    description = "Dönüş kurallarına uymamak.",
                    details = null
                ),
                InformationCardsInfo(
                    id = 7,
                    description = "Daralan yollarda öncelik hakkına uymamak.",
                    details = null
                ),
                InformationCardsInfo(
                    id = 8,
                    description = "Şehirler arası yollarda park yapmak.",
                    details = null
                ),
                InformationCardsInfo(
                    id = 9,
                    description = "NOT: Alkollü araç kullanmak, hız limitini aşarak araç kullanmak, ehliyetsiz araç kullanmak ASLİ KUSUR DEĞİLDİR.",
                    details = null
                )
            )
        ),
        InformationCards(
            id = 4,
            lessonName = "Biyel Kolu",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Biyel kolu, yatay eksende yerleşmiş krank mili ve pistonu dikey eksende birbirine bağlayan metal parçadır.",
                    details = "Bujilerin ateşleme yaptıktan sonra oluşan enerjiyi hareket enerjisine çeviren pistonların silindirin açık yüzeyinde kalan kısmı biyel kolunun üst kısmı ile bağlantılıdır. Krank mili ise dairesel boşluklu olarak tasarlanmış piston kolunun içerisinde yerleşmiştir."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Biyel kolu ne işe yarar?",
                    details = "Bir ucu pistona diğer ucu krank miline mafsallı olarak bağlı olan biyel kolu, piston hareket ettikçe dikey eksende hareket edip krank milinin dairesel eksende hareket etmesini sağlamaktadır. Temelde piston hareketleriyle hareket kazanan biyel kolu doğrusal hareketi dairesel harekete çevirmektedir. Aynı zamanda bağlantı noktaları oluşturmaktadır."
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Piston kolu hangi malzemeden üretilir?",
                    details = "Hareket mekanizmasının bağlantı noktasını oluşturan piston kolu, deformasyon, kırılma, bozulma gibi durumlara açık bir parçadır. Bu nedenle dökme demir kullanılır. Dökme demirler deformasyona karşı dirençli olup, mukavemet gücü diğer malzemelere oranla yüksektir. Yeni biyel kolları fabrikalarda ısıl işlem görüp dövülerek üretilir, bu işlem dayanıklılık gücünü artırır."
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Biyel kolunun özellikleri",
                    details = "Bazı biyel kollarının üst ölü nokta kısmında küçük dairesel bir delik bulunmaktadır. Bu delik yağ püskürterek krank milinin daha verimli şekilde aşınma meydana getirmeden dönmesini sağlar. Yağsızlık veya yağın verimsizliği biyel kolu arızalarının temel nedenidir. Ortalama 400 saat çalışan bir motorun deposundaki yağın değiştirilmesi gerekir, aksi takdirde yağın verimi düşer ve piston ile krank milinde aşınmalar meydana gelir."
                )
            )
        ),
        InformationCards(
            id = 5,
            lessonName = "Diferansiyel nedir",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Diferansiyel nedir?",
                    details = "Araçların dönüşü esnasında devreye giren diferansiyel, araçların virajlarda devrilmesini engelleyerek daha güvenli bir sürüş sağlar. Bir aracın olmazsa olmaz parçalarından biridir."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Diferansiyel nedir? – ne işe yarar?",
                    details = "Bir araç viraja girdiğinde içteki tekerin yavaş, dıştaki tekerin ise hızlı dönmesini sağlar. Motordan gelen hareket, baskı balatası ile vites kutusuna, oradan da diferansiyele iletilir. Diferansiyel, tekerleri farklı hızlarda döndürerek aracın kaymasını ve savrulmasını önler."
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Diferansiyel nerededir?",
                    details = "Önden çekişli araçlarda ön kısımda, arkadan çekişli araçlarda ise arka aksın ortasında bulunur. 4X4 araçlarda ise ön, arka ve aktarma şaftında olmak üzere toplam 3 diferansiyel bulunur."
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Diferansiyel Çeşitleri",
                    details = "Diferansiyel çeşitleri şunlardır:\n" +
                        "1. Klasik Diferansiyel: Her iki tekeri farklı hızlarda döndürür. Binek otomobillerde yaygın olarak bulunur.\n" +
                        "2. Kilitli Diferansiyel: Her iki tekeri aynı hızda döndürür. Patinaja düşen tekerler için kullanılır.\n" +
                        "3. Sınırlı Kaymalı - Elektrik Kontrollü Sınırlı Kaymalı Diferansiyel: Tekerler arasındaki dönüş farkını belirli bir oranı geçtiğinde devreye girer ve aks millerini birbirine kitleyerek kaymayı önler.\n" +
                        "4. Dinamik Tork Kontrollü Diferansiyel: 4 tekere giden torku ayrı ayrı kontrol eder ve ihtiyaca göre dağıtır."
                ),
                InformationCardsInfo(
                    id = 5,
                    description = "Diferansiyel Bakımı",
                    details = "Dişli çarklardan oluşan diferansiyel sisteminin yağlanması çok önemlidir. Diferansiyel yağ değişimi düzenli olarak yapılmalı, yağ seviyesi kontrol edilmelidir."
                )
            )
        ),
        InformationCards(
            id = 6,
            lessonName = "Dizel partikül filtresi nedir?",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Dizel Partikül Filtresi",
                    details = "Dizel yakıtın yanması sonucu ortaya çıkan zararlı gazları ve partikülleri azaltmak için kullanılan bir filtredir. Karbonmonoksit, hidrokarbonlar ve azot oksit gibi zararlı maddeleri çevre ve insan sağlığı için minimuma indirir."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Euro 5 ve Euro 6 nedir?",
                    details = "Euro emisyon standartları, Avrupa Birliği ülkelerinde egzozdan çıkan zararlı gaz ve partikülleri sınırlandıran standartlardır. Bu standartlara uymayan araçlar cezalara çarptırılabilir. (Örnek: Volkswagen emisyon değerlerini manipüle ettiği için ceza aldı.)"
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Partikül Filtresi Rejenerasyonu",
                    details = "Partikül filtresindeki zararlı gazlar zamanla birikir ve tıkanmalara yol açar. Kritik seviyeye ulaşıldığında ve uygun koşullar sağlandığında partiküller temizlenir. Bu işleme rejenerasyon denir."
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Partikül Filtresi Arızası",
                    details = "Rejenerasyon işlemi egzoz sıcaklığı 600 °C'ye ulaştığında başlar. Eğer sıcaklık bu seviyeye ulaşmazsa rejenerasyon işlemi başlamaz ve partikül filtresi ikaz ışığı yanar. Araç bu durumda hızlanmayabilir."
                ),
                InformationCardsInfo(
                    id = 5,
                    description = "Partikül Filtresi Arızasının Nedenleri",
                    details = "Arıza nedenleri şunlar olabilir:\n" +
                        "- Düşük kaliteli yakıt\n" +
                        "- Düşük hızlarda uzun süreli araç kullanımı\n" +
                        "- Rölantide uzun süreli araç çalıştırma"
                ),
                InformationCardsInfo(
                    id = 6,
                    description = "Partikül Filtresi Temizliği",
                    details = "Partikül filtresi temizliği için iki seçenek vardır:\n" +
                        "1. Aracınızı yarım saat boyunca yüksek devirde kullanmak. 3000 devirin üzerinde 3. veya 4. viteste saatte 50 km hızla araç kullanılması önerilir.\n" +
                        "2. Sorun devam ederse, aracı teknik servise götürmek ve bilgisayar yardımıyla temizleme işlemi yaptırmak."
                )
            )
        ),
        InformationCards(
            id = 7,
            lessonName = "Duraklama ve Parketme",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Duraklamanın Yasak Olduğu Yerler",
                    details = "1- Duraklamanın yasaklandığının bir trafik işaretiyle belirtilmiş olduğu yerlerde.\n" +
                        "2- Sol şeritte (raylı sistemin bulunduğu yollar hariç).\n" +
                        "3- Yaya ve okul geçitleri ile diğer geçitlerde.\n" +
                        "4- Kavşaklar, tüneller, rampalar ve bağlantı yollarında ve buralarda yerleşim merkezleri içinde 5 metre, yerleşim merkezleri dışında 100 metre mesafede.\n" +
                        "5- Görüşün yeterli olmadığı tepe üstlerine yakın yerlerde ve dönemeçlerde.\n" +
                        "6- Duraklayan veya park eden araçların yanında.\n" +
                        "7- Otobüs ve taksi duraklarında.\n" +
                        "8- İşaret levhalarına, yaklaşım yönünde ve park izni verilen yerler dışında, yerleşim birimi içinde 15 metre, yerleşim birimi dışında 100 metre mesafede.\n" +
                        "9- Zorunlu haller dışında, yerleşim yerleri dışındaki karayollarında, taşıt yolu üzerinde duraklamak yasaktır."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Not",
                    details = "Duraklamanın yasak olduğu her yerde park etmek de yasaktır."
                )
            )
        ),
        InformationCards(
            id = 8,
            lessonName = "Geçiş Üstünlüğü",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Geçiş Üstünlüğü Tanımı",
                    details = "Görev sırasında, belirli araç sürücülerinin, can ve mal güvenliğini tehlikeye sokmamak şartıyla, trafik kısıtlama ve yasaklamalarına bağlı olmamalarına denir."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Geçiş Üstünlüğüne Sahip Araçlar",
                    details = "1- Ambulanslar\n2- İtfaiye araçları\n3- Polis araçları\n4- Sivil savunma araçları\n5- Koruyan ve korunan araçlar"
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Not 1",
                    details = "Geçiş üstünlüğüne sahip araçların 150 metreden görülür lambaları olmalıdır. 150 metreden duyulur sirenleri olmalıdır."
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Not 2",
                    details = "Sarı tepeli lambalı araçlar geçiş üstünlüğüne sahip değildir. Sarı tepe lambası araçlara kendilerini belli etmek için takarlar, diğer araç kullananlar da daha dikkatli araç kullanırlar."
                )
            )
        ),
        InformationCards(
            id = 9,
            lessonName = "Hasta, Yaralının ve Olay Yerinin Değerlendirilmesi",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "İlkyardımcının insan vücudu, yapısı ve işleyişi konusunda bazı temel kavramları bilmesi, ilkyardımcı olarak yapacağı müdahalelerde bilinçli olmasını kolaylaştırır."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Hareket sistemi: Vücudun hareket etmesini, desteklenmesini sağlar ve koruyucu görev yapar. Hareket sistemi şu yapılardan oluşur:",
                    details = "Kemikler, Eklemler, Kaslar"
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Dolaşım sistemi: Vücut dokularının oksijen, besin, hormon, bağışıklık elemanı ve benzeri elemanları taşır ve yeniden geriye toplar. Dolaşım sistemi şu yapılardan oluşur:",
                    details = "Kalp, Kan damarları, Kan"
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Sinir sistemi: Bilinç, anlama, düşünme, algılama, hareketlerinin uyumu, dengesi ve solunum ile dolaşımı sağlar. Sinir sistemi şu yapılardan oluşur:",
                    details = "Beyin, Beyincik, Omurilik, Omurilik soğanı"
                ),
                InformationCardsInfo(
                    id = 5,
                    description = "Solunum sistemi: Vücuda gerekli olan gaz alışverişi görevini yaparak hücre ve dokuların oksijenlenmesini sağlar. Solunum sistemi şu organlardan oluşur:",
                    details = "Solunum yolları, Akciğerler"
                ),
                InformationCardsInfo(
                    id = 6,
                    description = "Boşaltım sistemi: Kanı süzerek gerekli maddelerin vücutta tutulması, zararlı olanların atılması görevlerini yaparak vücutta iç dengeyi korur. Boşaltım sistemi şu organlardan oluşur:",
                    details = "İdrar borusu, İdrar kesesi, İdrar kanalları, Böbrekler"
                ),
                InformationCardsInfo(
                    id = 7,
                    description = "Sindirim sistemi: Ağızdan alınan besinlerin öğütülerek sindirilmesi ve kan dolaşımı vasıtasıyla vücuda dağıtılmasını sağlar. Sindirim sistemi şu organlardan oluşur:",
                    details = "Dil ve dişler, Yemek borusu, Mide, Safra kesesi, Pankreas, Bağırsaklar"
                ),
                InformationCardsInfo(
                    id = 8,
                    description = "Yaşam Bulguları İle İlgili Önemli Göstergeler Nelerdir? Hasta/yaralıyı değerlendirmeden önce yaşam bulgularının anlamlarının bilinmesi gerekmektedir."
                ),
                InformationCardsInfo(
                    id = 9,
                    description = "Bilinç Durumunun Değerlendirilmesi: Öncelikle, hasta/yaralının bilinç durumu değerlendirilir.",
                    details = "Bilinç düzeyleri: Kişinin bilinci yerinde ise, 1 Derece Bilinç Kaybı, 2 Derece Bilinç Kaybı, 3 Derece Bilinç Kaybı"
                ),
                InformationCardsInfo(
                    id = 10,
                    description = "Solunum Değerlendirilmesi: Hasta/yaralının solunumu değerlendirilirken solunum sıklığına, Solunum aralıklarının eşitliğine, Solunum derinliği’ne bakılır.",
                    details = "Sağlıklı yetişkin bir kişide dakikada solunum sayısı 12–20, Çocuklarda 16–22, Bebeklerde 18-24"
                ),
                InformationCardsInfo(
                    id = 11,
                    description = "Kan Basıncının Değerlendirilmesi: Hasta/yaralı değerlendirilirken kan basıncı kontrol edilmez.",
                    details = "Normal değeri 100/50- 140/100 mm Hg’dir."
                ),
                InformationCardsInfo(
                    id = 12,
                    description = "Nabız Değerlendirilmesi: Kalp atımlarının atardamar duvarına yaptığı basıncın damar duvarında parmak uçlarıyla hissedilmesine nabız denmektedir.",
                    details = "Yetişkin bir kişide normal nabız sayısı dakikada 60–100, Çocuklarda 100–120, Bebeklerde 100-140"
                ),
                InformationCardsInfo(
                    id = 13,
                    description = "Vücutta nabız alınabilen bölgeler nelerdir?",
                    details = "Şah damarı, Ön-kol damarı, Bacak damarı, Kol damarı"
                ),
                InformationCardsInfo(
                    id = 14,
                    description = "Vücut Isısının Değerlendirilmesi: İlkyardımda vücut ısısı koltuk altından ölçülmelidir.",
                    details = "Normal vücut ısısı 36,5 C’dir. 41–42 C üstü ve 34,5 C tehlike, 31.0 C ve altı ölümcül."
                ),
                InformationCardsInfo(
                    id = 15,
                    description = "Hasta/yaralının değerlendirilmesinin amacı nedir?",
                    details = "Hastalık ya da yaralanmanın ciddiyetinin değerlendirmesi, İlkyardım önceliklerinin belirlenmesi, Yapılacak ilkyardım yönteminin belirlenmesi, Güvenli bir müdahale sağlanması."
                ),
                InformationCardsInfo(
                    id = 16,
                    description = "Hasta/yaralının ilk değerlendirilme aşamaları nelerdir?",
                    details = "Havayolu açıklığının değerlendirilmesi, Solunumun değerlendirilmesi, Dolaşımın değerlendirilmesi."
                ),
                InformationCardsInfo(
                    id = 17,
                    description = "Olay yerini değerlendirmenin amacı nedir?",
                    details = "Olay yerinde tekrar kaza olma riskinin ortadan kaldırılması, Olay yerindeki hasta/yaralı sayısının ve türlerinin belirlenmesidir."
                ),
                InformationCardsInfo(
                    id = 18,
                    description = "Olay yerinin değerlendirilmesinde yapılacak işler nelerdir?",
                    details = "Kazaya uğrayan araç güvenli bir alana alınmalı, Olay yeri işaretlenmeli, Meraklı kişiler uzaklaştırılmalı, Sigara içilmemeli, Gaz varlığı durumunda önlemler alınmalı."
                )
            )
        ),
        InformationCards(
            id = 10,
            lessonName = "Hız Kuralları",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Otomobillerde yerleşim yerlerinde hız sınırı: 50km/s, yerleşim yeri dışında: 90km/s"
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Otobüs, minibüs, kamyon ve kamyonetlerde yerleşim yerlerinde hız sınırı: 50km/s, yerleşim yeri dışında: 80km/s"
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Arazi taşıtlarıyla motosikletlerde yerleşim yerlerinde hız sınırı: 50km/s, yerleşim yeri dışında: 70km/s"
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Tehlikeli madde taşıyıcılar ve özel yük taşıma izni belgesiyle karayoluna çıkan araçlarda yerleşim yerlerinde hız sınırı: 30km/s, yerleşim yeri dışında: 50km/s"
                ),
                InformationCardsInfo(
                    id = 5,
                    description = "Motorlu bisiklet ve bisikletlerde yerleşim yerlerinde hız sınırı: 30km/s, yerleşim yeri dışında: 50km/s"
                ),
                InformationCardsInfo(
                    id = 6,
                    description = "Traktör, arızalı bir aracı çeken araçlar ve iş makinelerinde hız sınırı: 20km/s (hem yerleşim yerlerinde hem de yerleşim yeri dışında)"
                ),
                InformationCardsInfo(
                    id = 7,
                    description = "Römorksuz bir araca römork takılırsa, aracın hızı saatte 10 km daha düşük olmalıdır."
                ),
                InformationCardsInfo(
                    id = 8,
                    description = "Takip mesafesi: Hareket halindeki iki araç arasındaki mesafedir. Takip mesafesi hızın yarısı kadar mesafedir. Örneğin, hızı 90km/s olan bir aracın takip mesafesi 45m olmalıdır."
                ),
                InformationCardsInfo(
                    id = 9,
                    description = "Bir aracın 2 saniyede kat ettiği yol, takip mesafesi kadardır."
                )
            )
        ),
        InformationCards(
            id = 11,
            lessonName = "Genel İlk Yardım Bilgileri",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Genel İlk Yardım Bilgileri",
                    details = "Herhangi bir kaza veya yaşamı tehlikeye düşüren bir durumda, sağlık görevlilerinin yardımı sağlanıncaya kadar, hayatın kurtarılması ya da durumun kötüye gitmesini önleyebilmek amacı ile olay yerinde, tıbbi araç gereç aranmaksızın, mevcut araç ve gereçlerle yapılan ilaçsız uygulamalardır."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Acil tedavi nedir?",
                    details = "Acil tedavi ünitelerinde, hasta/yaralılara doktor ve sağlık personeli tarafından yapılan tıbbi müdahalelerdir."
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "İlkyardım ve acil tedavi arasındaki fark nedir?",
                    details = "Acil tedavi bu konuda ehliyetli kişilerce gerekli donanımla yapılan müdahale olmasına karşın, ilkyardım bu konuda eğitim almış herkesin olayın olduğu yerde bulabildiği malzemeleri kullanarak yaptığı hayat kurtarıcı müdahaledir."
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "İlkyardımcı kimdir?",
                    details = "İlkyardım tanımında belirtilen amaç doğrultusunda hasta veya yaralıya tıbbi araç gereç aranmaksızın mevcut araç gereçlerle, ilaçsız uygulamaları yapan eğitim almış kişi ya da kişilerdir."
                ),
                InformationCardsInfo(
                    id = 5,
                    description = "İlkyardımın öncelikli amaçları nelerdir?",
                    details = "Hayati tehlikenin ortadan kaldırılması, Yaşamsal fonksiyonların sürdürülmesinin sağlanması, Hasta/yaralının durumunun kötüleşmesinin önlenmesi, İyileşmenin kolaylaştırılması."
                ),
                InformationCardsInfo(
                    id = 6,
                    description = "İlkyardımın temel uygulamaları nelerdir?",
                    details = "İlkyardım temel uygulamaları Koruma, Bildirme, Kurtarma (KBK) olarak ifade edilir."
                ),
                InformationCardsInfo(
                    id = 7,
                    description = "Koruma",
                    details = "Kaza sonuçlarının ağırlaşmasını önlemek için olay yerinin değerlendirilmesini kapsar. En önemli işlem olay yerinde oluşabilecek tehlikeleri belirleyerek güvenli bir çevre oluşturmaktır."
                ),
                InformationCardsInfo(
                    id = 8,
                    description = "Bildirme",
                    details = "Olay / kaza mümkün olduğu kadar hızlı bir şekilde telefon veya diğer kişiler aracılığı ile gerekli yardım kuruluşlarına bildirilmelidir. Türkiye’de ilkyardım gerektiren her durumda telefon iletişimleri, 112 acil telefon numarası üzerinden gerçekleştirilir."
                ),
                InformationCardsInfo(
                    id = 9,
                    description = "112’nin aranması sırasında nelere dikkat edilmelidir?",
                    details = "Sakin olunmalı ya da sakin olan bir kişinin araması sağlanmalı, 112 merkezi tarafından sorulan sorulara net bir şekilde cevap verilmeli, Kesin yer ve adres bilgileri verilirken, olayın olduğu yere yakın bir caddenin ya da çok bilinen bir yerin adı verilmelidir, Kimin, hangi numaradan aradığı bildirilmeli, Hasta/yaralı(lar)ın adı ve olayın tanımı yapılmalı, Hasta/yaralı sayısı ve durumu bildirilmeli, Eğer herhangi bir ilkyardım uygulaması yapıldıysa nasıl bir yardım verildiği belirtilmeli, 112 hattında bilgi alan kişi, gerekli olan tüm bilgileri aldığını söyleyinceye kadar telefon kapatılmamalıdır."
                ),
                InformationCardsInfo(
                    id = 10,
                    description = "Kurtarma (Müdahale)",
                    details = "Olay yerinde hasta / yaralılara müdahale hızlı ancak sakin bir şekilde yapılmalıdır."
                ),
                InformationCardsInfo(
                    id = 11,
                    description = "İlkyardımcının müdahale ile ilgili öncelikli yapması gerekenler nelerdir?",
                    details = "Hasta / yaralıların durumu değerlendirilir (ABC) ve öncelikli müdahale edilecekler belirlenir, Hasta/yaralının korku ve endişeleri giderilir, Hasta/yaralıya müdahalede yardımcı olacak kişiler organize edilir, Hasta/yaralının durumunun ağırlaşmasını önlemek için kendi kişisel olanakları ile gerekli müdahalelerde bulunulur, Kırıklara yerinde müdahale edilir, Hasta/yaralı sıcak tutulur, Hasta/yaralının yarasını görmesine izin verilmez, Hasta/yaralıyı hareket ettirmeden müdahale yapılır, Hasta/yaralının en uygun yöntemlerle en yakın sağlık kuruluşuna sevki sağlanır (112) (Ancak, ağır hasta/yaralı bir kişi hayati tehlikede olmadığı sürece asla yerinden kıpırdatılmamalıdır)."
                ),
                InformationCardsInfo(
                    id = 12,
                    description = "İlkyardımcının özellikleri nasıl olmalıdır?",
                    details = "Olay yeri genellikle insanların telaşlı ve heyecanlı oldukları ortamlardır. Bu durumda ilkyardımcı sakin ve kararlı bir şekilde olayın sorumluluğunu alarak gerekli müdahaleleri doğru olarak yapmalıdır. Bunun için bir ilkyardımcıda aşağıdaki özelliklerin olması gerekmektedir: İnsan vücudu ile ilgili temel bilgilere sahip olmalı, Önce kendi can güvenliğini korumalı, Sakin, kendine güvenli ve pratik olmalı, Eldeki olanakları değerlendirebilmeli, Olayı anında ve doğru olarak haber vermeli (112’yi aramak), Çevredeki kişileri organize edebilmeli ve onlardan yararlanabilmeli, İyi bir iletişim becerisine sahip olmalıdır."
                ),
                InformationCardsInfo(
                    id = 13,
                    description = "Hayat kurtarma zinciri nedir?",
                    details = "Hayat kurtarma zinciri 4 halkadan oluşur. Son iki halka ileri yaşam desteğine aittir ve ilkyardımcının görevi değildir. 1. Halka – Sağlık kuruluşuna haber verilmesi, 2.Halka – Olay yerinde Temel Yaşam Desteği yapılması, 3.Halka – Ambulans ekiplerince müdahaleler yapılması, 4.Halka – Hastane acil servislerinde müdahale yapılmasıdır."
                ),
                InformationCardsInfo(
                    id = 14,
                    description = "İlkyardımın ABC si nedir?",
                    details = "Bilinç kontrol edilmeli, bilinç kapalı ise aşağıdakiler hızla değerlendirilmelidir: A. Hava yolu açıklığının değerlendirilmesi, B. Solunumun değerlendirilmesi (Bak-Dinle-Hisset), C. Dolaşımın değerlendirilmesi (Şah damarından 5 saniye nabız alınarak yapılır)"
                )
            )
        ),
        InformationCards(
            id = 12,
            lessonName = "Karayolunun Kullanılması Kuralları",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Araçlarını, durumun elverdiği oranda gidiş yönüne göre yolun en sağından sürmek."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Yol çok şeritli ise, trafik durumuna göre hızının gerektirdiği şeritten gitmek."
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Şerit değiştirmeden önce, gideceği şeritte araçların güvenle geçişlerinin tamamlamalarını beklemek."
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Trafiği aksatacak ya da tehlikeye sokacak şekilde şerit değiştirmemek."
                ),
                InformationCardsInfo(
                    id = 5,
                    description = "Gidişe ayrılan yol bölümünün en sol şeridini sürekli olarak işgal etmemek."
                ),
                InformationCardsInfo(
                    id = 6,
                    description = "İki yönlü, dört veya daha fazla şeritli yollarda, motosiklet, otomobil, kamyonet, minibüs ve otobüs dışındaki araçları sürenler, geçme ve dönme dışında en sağ şeridi izlemek zorundadırlar."
                ),
                InformationCardsInfo(
                    id = 7,
                    description = "Geçme, durma, duraklama, dönme ve park etme gibi haller dışında şerit değiştirmeleri yasaktır."
                ),
                InformationCardsInfo(
                    id = 8,
                    description = "İki şeridi birden kullanmaları yasaktır."
                ),
                InformationCardsInfo(
                    id = 9,
                    description = "Araçların cinsine ve hızına uygun olmayan şeritten gitmeleri yasaktır."
                ),
                InformationCardsInfo(
                    id = 10,
                    description = "Kavşaklara yaklaşırken, yerleşim yerleri içinde 30 metre, dışında 150 metre mesafe içinde şerit değiştirmeleri yasaktır."
                )
            )
        ),
        InformationCards(
            id = 13,
            lessonName = "Kızdırma bujisi",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Dizel motorlarda hava yakıt karışımı bujiler vasıtasıyla değil, sıkıştırılan ve ısınan havanın üzerine enjektörler vasıtasıyla yakıt püskürtülmesiyle yanar.",
                    details = "Mazot, yanma odasındaki sıkıştırılmış havanın üzerine püskürtüldüğünde yanması için sıcak havanın 700-900 °C'lik bir sıcaklığa sahip olması gerekir."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Motor çalışmadan önce yanma odasını ısıtan parçaya kızdırma bujisi (ısıtma bujisi) denir.",
                    details = "Kızdırma bujisi, aracın ilk çalıştırılması esnasında soğuk olan yanma odasını ısıtarak motorun daha kolay çalışmasını sağlar."
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Kızdırma bujilerinin ortalama 100.000 km ömrü vardır.",
                    details = "Ancak bu, aracı çalıştırma alışkanlıklarına bağlı olarak değişebilir. Örneğin, kızdırma ikaz ışığı sönmeden aracı çalıştırmak, bujinin ömrünü kısaltabilir."
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Kızdırma bujisi arızası nasıl anlaşılır?",
                    details = "Arıza belirtileri: \n- Kızdırma bujisi arıza lambası yanmışsa \n- Araç ilk marşta çalışmıyorsa \n- Araç yazın kolay, kışın zor çalışıyorsa"
                ),
                InformationCardsInfo(
                    id = 5,
                    description = "Kızdırma bujisi neden bozulur?",
                    details = "Bozulma nedenleri: \n- Kızdırma ikaz ışığı sönmeden marşa basmak \n- Kontağı uzun süre açık bırakmak \n- Zayıf akü ile uzun süre marş basmak"
                )
            )
        ),
        InformationCards(
            id = 14,
            lessonName = "Krank mili nedir",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Krank mili, pistonların hareketine bağlı olarak hareket eden bir parçadır. Biyel kolu pistona ve krank miline bağlıdır.",
                    details = "Yatay eksende yerleşmiş bir parça olup U harfi biçimindeki çıkıntılardan oluşur. Pistonlar bu çıkıntılara bağlıdır."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Krank mili, hareket mekanizmasının en önemli parçalarından biridir. Pistonların hareketini dairesel harekete çevirir.",
                    details = "Biyel kolları krank milinin çıkıntılarına bağlı olarak hareket eder ve hareket mekanizmasını tamamlar."
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Krank mili, Sfero demir veya çelik alaşımından üretilir. Titanyum kaplama işlemi de uygulanabilir.",
                    details = "Titanyum kaplama, motorun yüksek devir kapasitesiyle uyumlu performans sağlar ve korozyona karşı dayanıklılığı artırır."
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Krank milinin yağlama ve soğutma işlemleri önemlidir. Yağ kanalları ve vakumlu yağ pompası kullanılır.",
                    details = "Yağlama yetersizliği, krank milinde deformasyona ve arızalara neden olabilir. Yağ yoğunluğu ve kalitesi önemlidir."
                ),
                InformationCardsInfo(
                    id = 5,
                    description = "Krank milinin arızaları genellikle kırılma, korozyon veya deformasyon şeklinde görülür.",
                    details = "Yağ kanallarında tıkanma veya ince yağ kullanımı bu arızalara yol açabilir. Arıza tespiti önemlidir."
                ),
                InformationCardsInfo(
                    id = 6,
                    description = "Krank milindeki arızalar motorun kullanımını etkiler ve aracın tamamen devre dışı kalmasına neden olabilir.",
                    details = "Arıza tespit edilirse, hemen bir servise götürülmelidir. Bakımlar düzenli olarak yapılmalıdır."
                )
            )
        ),
        InformationCards(
            id = 15,
            lessonName = "Motor Bilgisi",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Motor Çeşitleri",
                    details = "Motorlar çeşitli kriterlere göre sınıflandırılabilir."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "1. Motor Çeşitleri",
                    details = null
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "1.1 Zamanlarına Göre",
                    details = "Dört zamanlı motorlar, İki zamanlı motorlar"
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "1.2 Kullanılan Yakıtlara Göre",
                    details = "Benzinli motorlar, Dizel motorlar, LPG motorlar"
                ),
                InformationCardsInfo(
                    id = 5,
                    description = "1.3 Yakıtın Yanma Yerine Göre",
                    details = "İçten yanmalı motorlar, Dıştan yanmalı motorlar"
                ),
                InformationCardsInfo(
                    id = 6,
                    description = "1.4 Yapım Özelliklerine Göre",
                    details = "Sıra tipi, Birbirlerinin karşılarına yatık (Düz, hafif eğik, boksör tipi), Sıra halinde bir açı ile birleştirilmiş (V tipi), Daire şeklinde (Yıldız tipi)"
                ),
                InformationCardsInfo(
                    id = 7,
                    description = "1.5 Silindir Sayılarına Göre",
                    details = "Tek silindirli, Çok silindirli"
                ),
                InformationCardsInfo(
                    id = 8,
                    description = "1.6 Soğutma Sistemlerine Göre",
                    details = "Su soğutmalı, Hava soğutmalı"
                ),
                InformationCardsInfo(
                    id = 9,
                    description = "2. Motorun Parçaları",
                    details = "Motorun parçaları iç ve dış olarak iki gruba ayrılabilir."
                ),
                InformationCardsInfo(
                    id = 10,
                    description = "Motorun İçindeki Parçalar",
                    details = null
                ),
                InformationCardsInfo(
                    id = 11,
                    description = "Silindir Bloğu",
                    details = "İçinde silindirlerin bulunduğu ve motor parçalarını üzerinde taşıyan ana parçadır."
                ),
                InformationCardsInfo(
                    id = 12,
                    description = "Silindir Kapağı",
                    details = "Silindir bloğu üzerini kapatan ve yanma odalarını meydana getiren kapaktır."
                ),
                InformationCardsInfo(
                    id = 13,
                    description = "Karter",
                    details = "Motor yağına depoluk görevi gören, silindir bloğunun altındaki parçadır."
                ),
                InformationCardsInfo(
                    id = 14,
                    description = "Supap Kapağı",
                    details = "Motor üzerindeki supap mekanizmasını dış etkilerden korur."
                ),
                InformationCardsInfo(
                    id = 15,
                    description = "Radyatör",
                    details = "Soğutma suyunun bulunduğu depo."
                ),
                InformationCardsInfo(
                    id = 16,
                    description = "Karbüratör",
                    details = "Benzin-hava karışımını sağlayan parça."
                ),
                InformationCardsInfo(
                    id = 17,
                    description = "Hava Filtresi",
                    details = "Silindirlere giren havayı temizler."
                ),
                InformationCardsInfo(
                    id = 18,
                    description = "Manifoldlar (Emme-Egzot)",
                    details = "Hava yakıt karışımını silindirlere, yanmış gazları dışarıya taşıyan borulardır."
                ),
                InformationCardsInfo(
                    id = 19,
                    description = "Yağ Filtresi",
                    details = "Motor yağı içindeki yabancı maddeleri temizler."
                ),
                InformationCardsInfo(
                    id = 20,
                    description = "Endüksiyon Bobini (Ateşleme)",
                    details = "Aküden gelen akımı 15.000 – 25.000 volta yükselten parçadır."
                ),
                InformationCardsInfo(
                    id = 21,
                    description = "Buji",
                    details = "Benzin-hava karışımını tutuşturan parçadır."
                ),
                InformationCardsInfo(
                    id = 22,
                    description = "Konjektör (Regülatör)",
                    details = "Şarj dinamosunun ürettiği elektriği doğru akıma çeviren ve 12 volt değerinde düzenleyen parçadır."
                ),
                InformationCardsInfo(
                    id = 23,
                    description = "Enjektör",
                    details = "Dizel motorlarda yakıt püskürten parçadır."
                ),
                InformationCardsInfo(
                    id = 24,
                    description = "Krank Mili",
                    details = "Pistonların bağlı olduğu, motorun çalışması sonucu elde edilen hareketin ve gücün motordan alınmasına yarayan mildir."
                ),
                InformationCardsInfo(
                    id = 25,
                    description = "Piston",
                    details = "Silindir içerisinde hareket eden ve hareketi krank miline iletmesine yardımcı olan parçadır."
                ),
                InformationCardsInfo(
                    id = 26,
                    description = "Piston (Biyel) Kolu",
                    details = "Pistonun doğrusal hareketini krank miline ileten parçadır."
                ),
                InformationCardsInfo(
                    id = 27,
                    description = "Yağ Pompası",
                    details = "Karterdeki yağı basınçla hareketli parçalara gönderir."
                ),
                InformationCardsInfo(
                    id = 28,
                    description = "Yakıt Pompası (Benzin Otomatiği)",
                    details = "Yakıtı basınçla karbüratöre gönderen parça."
                ),
                InformationCardsInfo(
                    id = 29,
                    description = "Distribütör",
                    details = "Benzinli motorlarda ateşleme sırasına göre bujilere elektrik enerjisi gönderen parçadır."
                ),
                InformationCardsInfo(
                    id = 30,
                    description = "Marş Motoru",
                    details = "Motora ilk hareket veren parçadır. Elektrik enerjisini hareket enerjisine çevirir."
                ),
                InformationCardsInfo(
                    id = 31,
                    description = "Alternatör (Şarj Dinamosu)",
                    details = "Araç için gerekli elektrik enerjisini üreten parçadır. Hareket enerjisini elektrik enerjisine çevirir."
                ),
                InformationCardsInfo(
                    id = 32,
                    description = "Su Pompası (Devirdaim)",
                    details = "Suyun silindir içindeki kanallarda dolaşmasını sağlar."
                ),
                InformationCardsInfo(
                    id = 33,
                    description = "Enjektör Pompası",
                    details = "Dizel motorlarda yakıtı basınçla enjektörlere gönderen parçadır."
                ),
                InformationCardsInfo(
                    id = 34,
                    description = "Enjektör",
                    details = "Yakıtı toz halinde (pülverize) silindire gönderen parça."
                ),
                InformationCardsInfo(
                    id = 35,
                    description = "Kam (Eksantrik) Mili",
                    details = "Krank milinden aldığı hareketle bazı motor sistemlerinin çalışmasını sağlayan parçadır."
                ),
                InformationCardsInfo(
                    id = 36,
                    description = "Supaplar",
                    details = "Yakıtın silindirlere alınmasını (emme), egzoz gazlarının silindirden atılmasını sağlayan parçadır (egzoz)."
                ),
                InformationCardsInfo(
                    id = 37,
                    description = "Besleme Pompası",
                    details = "Dizel motorlarda mazotu enjektör pompasına ileten parçadır."
                ),
                InformationCardsInfo(
                    id = 38,
                    description = "Motorun Dışındaki Parçalar",
                    details = "Motorun dışındaki parçalar yardım eden sistemlerdir ve yardımına göre isim alır. Ateşleme, yakıt, soğutma, yağlama, şarj ve marş gibi yardımları yaparlar."
                ),
                InformationCardsInfo(
                    id = 39,
                    description = "Radyatör",
                    details = "Su soğutma motorlarda soğutma suyuna depoluk eder, sistemde ısınan suyun soğumasına yardımcı olur."
                ),
                InformationCardsInfo(
                    id = 40,
                    description = "Karbüratör",
                    details = "Motora gerekli olan benzin, hava karışımını şartlara-göre 1/15 (benzin – hava) oranında karıştıran elemandır. Emme manifoldunun üzerinde bulunur."
                ),
                InformationCardsInfo(
                    id = 41,
                    description = "Hava Filtresi",
                    details = "Dışardan motor içerisine alınacak olan havayı temizleyip karbüratöre veya emme manifolduna gönderen parçadır."
                ),
                InformationCardsInfo(
                    id = 42,
                    description = "Yağ Filtresi",
                    details = "Motor yağı içerisindeki kirleticileri arındıran parçadır."
                ),
                InformationCardsInfo(
                    id = 43,
                    description = "Enjektör",
                    details = "Dizel motorlarda yakıtın silindire püskürtülmesini sağlayan parçadır."
                ),
                InformationCardsInfo(
                    id = 44,
                    description = "Marş Motoru",
                    details = "Elektrik motorudur, motorun ilk hareketini sağlayarak çalışmasını sağlar."
                ),
                InformationCardsInfo(
                    id = 45,
                    description = "Şarj Dinamosu",
                    details = "Aracın elektrik ihtiyacını karşılayan ve akünün şarjını sağlayan bir parçadır."
                ),
                InformationCardsInfo(
                    id = 46,
                    description = "Distribütör",
                    details = "Benzinli motorlarda buji ateşlemesini sağlayan parça."
                ),
                InformationCardsInfo(
                    id = 47,
                    description = "Ateşleme Sistemi",
                    details = "Motorun ateşleme işlemlerini kontrol eden sistemdir."
                ),
                InformationCardsInfo(
                    id = 48,
                    description = "Yağ Pompası",
                    details = "Motor yağını sirküle eden ve yağ basıncını sağlayan parçadır."
                ),
                InformationCardsInfo(
                    id = 49,
                    description = "Radyatör",
                    details = "Soğutma suyunu motorun etrafında dolaştırarak soğutmaya yarar."
                ),
                InformationCardsInfo(
                    id = 50,
                    description = "Hava Filtresi",
                    details = "Hava kirliliğinden arındırılmış hava motor içerisine gönderir."
                ),
                InformationCardsInfo(
                    id = 51,
                    description = "Yağ Filtresi",
                    details = "Motor yağındaki kirleticileri temizler."
                ),
                InformationCardsInfo(
                    id = 52,
                    description = "Enjektör",
                    details = "Yakıtın motorun silindire doğru bir şekilde püskürtülmesini sağlar."
                ),
                InformationCardsInfo(
                    id = 53,
                    description = "Marş Motoru",
                    details = "Motora ilk hareketi verir ve motorun çalışmasını sağlar."
                ),
                InformationCardsInfo(
                    id = 54,
                    description = "Şarj Dinamosu",
                    details = "Aküye elektrik sağlar ve aracın elektrikli sistemlerini çalıştırır."
                )
            )
        ),
        InformationCards(
            id = 16,
            lessonName = "Motor nasıl çalışır?",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Kontağın çevrilmesi",
                    details = "Arabanın motorunu çalıştırabilmek için anahtarı kontağa takmanız gerekir. Kontak göbeği, direksiyon kilidini pasif hale getirir."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Kızdırma Bujilerinin Devreye Girmesi",
                    details = "Dizel araçlarda, kontak çevrildiğinde kızdırma bujileri devreye girer ve yanma odasını 700-900 °C sıcaklığa getirir."
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Marşa Basılması ve Marş Motorunun Pistonlara İlk Hareketini Vermesi",
                    details = "Marş motoruna elektrik akımı gönderilir ve marş dişlisi, volan dişlisini döndürerek krank milini hareket ettirir. Bu hareket, pistonların yukarı doğru hareket etmesine ve yanma odasındaki havanın sıkışmasına neden olur."
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Emme-Sıkıştırma-Patlama-Egzoz Zamanlarının Devreye Girmesi",
                    details = "Pistonlar, emme zamanında aşağı yönlü hareket ederek hava alır. Sıkıştırma zamanında, hava sıkışır ve yüksek sıcaklıkta yakıt püskürtülür. Patlama sonucu pistona enerji aktarılır ve egzoz gazları egzoz subaplarından dışarı atılır."
                ),
                InformationCardsInfo(
                    id = 5,
                    description = "Motordan Gelen Dönme Hareketinin Vites Kutusuna İletilmesi",
                    details = "Volan dişlisinden gelen hareket, vites kutusuna iletilir. Debriyaj pedalına basıldığında, volan dişlisi ile vites kutusu arasındaki irtibat kesilir ve vitese geçildikten sonra debriyaj pedalını bırakınca hareket vites kutusuna iletilir."
                ),
                InformationCardsInfo(
                    id = 6,
                    description = "Vites Kutusuna Gelen Hareketin Diferansiyele ve Akslara İletilmesi",
                    details = "Vites kutusunun çıkışında gelen hareket, şaft vasıtasıyla diferansiyele iletilir. Diferansiyel, bu hareketi akslara ve tekerlere ileterek aracın hareket etmesini sağlar."
                )
            )
        ),
        InformationCards(
            id = 17,
            lessonName = "Motorun Parçaları ve Görevleri",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Motor Bloğu",
                    details = "Piston, silindir, biyel kolu gibi motor parçalarının takıldığı motorun orta kısmıdır. Pistonlar, motor bloğundaki silindirlerde aşağı-yukarı yönlü hareket ederler."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Silindir Kapağı",
                    details = "Silindir kapağının görevi, silindirlerin üst tarafını kapatarak yanma odalarını oluşturmak ve motorun hareketli parçalarına yataklık etmektir. Motor bloğu ve silindir kapağı arasındaki sızdırmazlık aralarına conta konularak sağlanır. Silindir kapakları yüksek basınç ve sıcaklığa dayanacak şekilde imal edilmektedir. Silindir kapağının üzerinde; emme ve egzoz sübapları, eksantrik miller, dizel motorlarda enjektörler, benzinli motorlarda bujiler, yakıtın çekilmesi ve atık gazların uzaklaştırılması için hava kanalları bulunmaktadır."
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Üst Kapak (Külbütör Kapağı)",
                    details = "Aracın kaputunu açtığımızda motora baktığımızda gördüğümüz kapaktır. Silindir kapağının üzerindeki sübapları ve külbütörü koruyan genelde sac malzemeden imal edilen ve üzerinde motora yağ doldurmaya yaran deliği de bulunan bir koruyucudur."
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Emme Manifoldu",
                    details = "Yanma için gerekli olan havayı silindirlerin içine eşit olarak dağıtan parçadır."
                ),
                InformationCardsInfo(
                    id = 5,
                    description = "Egzoz Manifoldu",
                    details = "Yanma zamanı sonunda ortaya çıkan gazların motordan uzaklaştırıldığı borudur."
                ),
                InformationCardsInfo(
                    id = 6,
                    description = "Karter",
                    details = "Motorun alt kısmında bulunan yağ tankıdır. Karterde biriken motor yağı, yağ pompası vasıtası ile çekilir ve basınçlı olarak hareketli motor parçaları yağlanır."
                ),
                InformationCardsInfo(
                    id = 7,
                    description = "Piston",
                    details = "Yanma zamanında oluşan basıncın etkisiyle silindir içerisinde hareket eden parçadır. Üzerinde yağlamayı sağlayan yağ segmanı ve yanma odasının sızdırmazlığını sağlayan kompresyon segmanı bulunur."
                ),
                InformationCardsInfo(
                    id = 8,
                    description = "Biyel Kolu",
                    details = "Piston ile krank mili arasındaki bağlantıyı sağlayan parçadır. Pistonun hareketi biyel aracılığı ile krank miline iletilir."
                ),
                InformationCardsInfo(
                    id = 9,
                    description = "Krank Mili",
                    details = "Biyel kolundan gelen doğrusal hareketi dairesel harekete çeviren motor parçasıdır. Krank milinin dairesel hareketi volan dişlisine ve oradan da aktarma organlarına aktarılır."
                ),
                InformationCardsInfo(
                    id = 10,
                    description = "Volan Dişlisi",
                    details = "Krank milinden gelen dönme hareketini kavrama ve vites kutusuna ileten parçadır."
                ),
                InformationCardsInfo(
                    id = 11,
                    description = "Eksantrik Mil (Kam Mili)",
                    details = "Hareketini krank milinden alan ve zamanlama işlemi gören bir parçadır. Emme subabının ve egzoz subabının açılacağı zamanı belirler. Krank mili ile arasındaki bağlantı triger kayışı vasıtasıyla yapılır."
                ),
                InformationCardsInfo(
                    id = 12,
                    description = "Emme Subabı (Emme Valfi)",
                    details = "Silindir kapağında bulunan bu parça, emme manifoldundan gelen havayı uygun zamanlarda açılarak yanma odasına gönderir."
                ),
                InformationCardsInfo(
                    id = 13,
                    description = "Egzoz Subabı (Egzoz Valfi)",
                    details = "Yanma zamanı sonunda ortaya çıkan gazları uygun zamanda açılarak egzoz manifolduna gönderen parçadır."
                )
            )
        ),
        InformationCards(
            id = 18,
            lessonName = "Okul Taşıtları",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Okul taşıtının DUR işareti yakıldığında, diğer bütün araçlar duracak, öğrenci indirme bindirme işlemi bitinceye kadar okul taşıtı geçilmeyecektir."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "DUR işareti sadece öğrenci indirme bindirme işlemi sırasında yakılacak, bu ışık frene basıldığında yanan ışıkla birlikte yanmayacak."
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Okul taşıtlarına, taşıma sınırını aşacak sayıda öğrenci bindirilmeyecektir."
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Taşıt içi düzenini sağlamak ve taşıta iniş ve binişlerde öğrenciye yardımcı olmak üzere okul taşıtında bir rehber öğretmen veya kişi bulunacaktır."
                ),
                InformationCardsInfo(
                    id = 5,
                    description = "Öğrencilerin kolayca yetiştiği cam ve pencereler sabit olacaktır."
                ),
                InformationCardsInfo(
                    id = 6,
                    description = "Okul taşıtlarının arkasında 30cm çapında kırmızı dur lambası olmalıdır."
                ),
                InformationCardsInfo(
                    id = 7,
                    description = "Hatalı park olursa parasını araç sürücüsü ya da sahibi öder."
                ),
                InformationCardsInfo(
                    id = 8,
                    description = "Şehir merkezinde kamyon, otobüs ve traktör park yapamaz."
                )
            )
        ),
        InformationCards(
            id = 19,
            lessonName = "Otoyol Kuralları",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Erişme kontrollü karayolu: Özellikle transit trafiğe tahsis edilen, belirli yerler ve şartlar dışında giriş ve çıkışın yasaklandığı, yaya, hayvan ve motorsuz araçların giremediği, ancak izin verilen motorlu araçların yararlandığı ve trafiğin özel kontrole tabi tutulduğu karayoludur."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Otoyola her yerden giriş veya çıkış yasaklanmıştır. Buralara ancak özel yerlerden girilir veya çıkılır; girişte hizalanma şeridi, çıkışta ise yavaşlama şeridi bulunur."
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Duraklamak, park etmek, geri gitmek, geri dönüş YASAKTIR."
                )
            )
        ),
        InformationCards(
            id = 20,
            lessonName = "Piston",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Piston nedir? - ne işe yarar?",
                    details = "Motorlarda bulunan silindirin bir ucu dairesel biçimde bir alan içerir. Bu alandan silindir içerisine yerleştirilmiş pistonlar, yakıt mekanizması ile açığa çıkan enerji tarafından aşağı yukarı doğru hareket ettirilerek enerjinin harekete dönüşümünü sağlamaktadır."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Pistonlar silindir içerisinde hassasiyetle yerleştirilmektedir.",
                    details = "Arabadaki silindir sayısına göre 4 ve 8 arasında piston bulunmaktadır. Silindirin içerisinde yerleşmiş olan bu parça yine silindir biçiminde olup metalik bir maddeden imal edilmektedir."
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Pistonlar biyel kolları ile alt yüzeyden bağlantılıdır.",
                    details = "Biyel kolunun bir kolu pistonlarda iken diğer kolu alt kısımda hareketi sağlayan krank miline etki etmektedir. Bujiler ateşlemeyi başlattıktan sonra açığa çıkan enerji pistonları hareket ettirir."
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Pistonların dayanıklılığı arttırılmaktadır.",
                    details = "Günümüz teknolojisi ile üretilen enjeksiyonlu motorlar hızlı devinim gücüne sahip olduğundan alüminyum alaşımı ya da karbon çelik alaşımını dahi zaman içerisinde deforme edebilmektedir. Bu durumu önlemek amacıyla var olan en sert metal kaplama yapılmaktadır."
                ),
                InformationCardsInfo(
                    id = 5,
                    description = "Titanyum kaplama pistonlar daha maliyetli olmaktadır.",
                    details = "Yaklaşık olarak 50.000 - 90.000 km aralığında değişim yapılması gereken alüminyum pistonların maliyeti zaman içerisinde daha da artış göstermektedir."
                ),
                InformationCardsInfo(
                    id = 6,
                    description = "Pistonlar, iç yüzeyinden kendisine bağlı olan biyel kollarını çevirerek hareket mekanizmasını başlatır.",
                    details = "Bu temel parçadaki sürekli hareket durumu her ne kadar sert maddeyle kaplanırsa kaplansın korozyonu önlenemeyecektir. Ancak korozyon durumu geciktirilebilir."
                ),
                InformationCardsInfo(
                    id = 7,
                    description = "Segman parçalar pistonun yüzeyinde de bulunmaktadır.",
                    details = "Segmanların piston yüzeyinde bulunmasının temel sebebi silindir içerisine hava ve yağların dolmasını engeller. Bir silindirin içerisine yağ ya da hava sürekli dolup boşaltıldığı zaman silindir içerisinde tortulaşmaya neden olur."
                ),
                InformationCardsInfo(
                    id = 8,
                    description = "Pistonların önemi ve çalışma mekanizması.",
                    details = "Piston ateşlemeli, patlamalı motorlarda bulunan hayati bir parça olduğundan eksikliği durumunda silindir de üretilen enerji harekete dönüştürülemez ve araç çalışmaz."
                ),
                InformationCardsInfo(
                    id = 9,
                    description = "Pistonun görevleri.",
                    details = "Piston yazımızda belirtildiği üzere yanmalı motorlarda silindirde oluşan enerjiyi hareket enerjisine dönüştürmektedir. Bu hareket enerjisine dönüştürme işlemi pistonun asıl görevidir."
                ),
                InformationCardsInfo(
                    id = 10,
                    description = "Piston Çeşitleri",
                    details = "Benzin motorlarında kullanılan piston çeşitleri; düz etekli pistonlar, düz yarı diyagonal pistonlar, T yarıklı pistonlar, U yarıklı pistonlar ve Termik pistonlar şeklinde ifade edilebilir."
                ),
                InformationCardsInfo(
                    id = 11,
                    description = "Piston hasarlarının tanınması ve giderilmesi.",
                    details = "Pistonlar çok küçük parçalar olmalarına rağmen birçok arıza türü mevcuttur. Bu arıza türlerini; Piston eteğinde meydana gelen arızalar, Piston başında meydana gelen krapaj arızaları, Segmanlarda meydana gelen arızalar, Piston piminde meydana gelen arızalar ve krapajlar, Silindir ve gömleklerde meydana gelen arızalar biçiminde sıralayabiliriz."
                ),
                InformationCardsInfo(
                    id = 12,
                    description = "Yağ Boşluğunun yetersiz olmasından kaynaklanan krapaj arızaları",
                    details = "Bir piston silindir içerisinde 1000’de 7 oranında boşluk olacak şekilde yerleştirilmelidir. Bu boşluk sürtünmeden dolayı meydana gelecek termik hasarı önlemek adına oluşturulmuş yağ boşluğudur."
                ),
                InformationCardsInfo(
                    id = 13,
                    description = "Yanma bozuklukları",
                    details = "Buji ve... (devamı yapılacak)"
                )
            )
        ),
        InformationCards(
            id = 21,
            lessonName = "Segman",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Segman; motordaki hava ve yakıtın karışması sürecinde sızdırmazlık sağladıkları için kompresyon kalitesini yükselten motor elemanlarıdır.",
                    details = "Makineye ait çeşitli bölümlerde ve özellikle motorlarda bulunan halka biçimindeki parçalara segman denir. Segmanlar piston ve silindir arasındaki gaz ve çeşitli kimyasalların sızdırmasını engellemekle beraber motor içindeki yanma odalarında bulunan yanmış gazın kartere dolmasını da önlemektedir."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Segmanların önemi",
                    details = "Mukavemet gücü yüksek olması açısından genelde çelik alaşım kullanılarak imal edilen segmanların deformasyonu ya da motorda kullanılmaması durumunda sızdırma gerçekleşeceğinden yakıt emme zamanında hava-yakıt karışımının silindire verimsiz bir şekilde dolma durumu söz konusu olacaktır. Kompres zamanında piston alt ölü noktadan üst ölü noktaya yükselirken silindirde yer alan karışımdan bir miktar kartere dolar ve kompresin verimsiz bir şekilde gerçekleşmesine neden olur. İmal edildiği çelik alaşımlar motorda meydana gelen yüksek sıcaklık ve basıncı soğurur. Bu sayede uzun bir süre esneklik özelliklerini yitirmeden görevlerini gerçekleştirirler. Soğurma işlemi özellikle ateş segmanı adı verilen üst kör nokta kompresyon segmanında gerçekleştiğinden bu parça molibden elementi ile kaplanmaktadır."
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Segmanın görevi",
                    details = "Motordaki hava ve yakıtın karışması sürecinde sızdırmazlık sağladıkları için kompresyon kalitesini yükselten motor elemanlarıdır. Pistonlu makinelerde kullanıldığından pistonda gerçekleşen ısı enerjisini silindire aktararak ısınmadan kaynaklı motor performans düşüklüğünü de engellemektedirler. Kompresyon ve yağ segmanları olmak üzere iki türü bulunmaktadır."
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Yağ segmanları",
                    details = "Yağ segmanları piston ve silindir arasındaki sürtünme kuvvetinin azaltılması esasına dayalı çalışmaktadır. Sürtünme kuvvetinin azalması ile yağın gereksiz ve verimsiz kullanımını önlemiş olurlar."
                ),
                InformationCardsInfo(
                    id = 5,
                    description = "Kompresyon segmanları",
                    details = "Kompresyon segmanları ise pistonun yüzeyi ve silindir kapağı arasına takılmakta olup havanın kartere dolmasını önler, bu sayede kompresyon verimini arttırmaya yönelik kullanılırlar. Ayrıca kompresyon segmanları belirtildiği üzere ısı aktarımı yaparak pistonun soğumasını sağlar. Kullanıldıkları motorlarda hayati bir önem arz eden segmanlar makinenin türüne göre hidrolik ekipmanlarda da kullanılmaktadır."
                ),
                InformationCardsInfo(
                    id = 6,
                    description = "Segmanlar nasıl takılır?",
                    details = "Segmanlar segman pensesi adı verilen baş kısmı 45 derecelik eğime sahip sivri uçlu manuel el aleti ile takılmaktadır. Halka biçiminde olan bu parçaların uç kısmında bulunan daire kesimi pensenin sivri ucuyla anahtar kilit uyumu sağlayarak parçanın gerilmesini sağlar. Segman penseleri standart penselere göre zıt bir mekanizmaya sahiptir. Sıkıldığında açılan gevşetildiğinde kapanan bu mekanizma dayanıklı segmanların gerilmesini kolaylaştırmaktadır."
                )
            )
        ),
        InformationCards(
            id = 22,
            lessonName = "Silindir gömleği",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Silindir gömleği, pistonların içerisinde hareket ettiği ve yanma olayının gerçekleştiği bir elemandır. Halk arasında motor gömleği olarak da bilinir.",
                    details = "Benzinli motorlar için su ve hava soğutmalı silindir gömleği, dizel motorlar içinse sulu ve kuru silindir gömleği bulunmaktadır. Silindir gömleği ya da diğer adıyla motor gömleği, silindir boşluklarının içinde pistonların aşağı yukarı yönlü hareketlerinde dış çerçeveyi oluşturan parçadır. Pistonlar biyel kolu vasıtası ile silindir gömleğinin içerisinde hareket eder. Pistonların üst kısmı yanma odasına, alt kısmı ise kartere bakar. Pistonların her aşağı yönlü hareketinde pistonlar yağlanmış olur. Pistonların yağlama işlemi esnasında ve patlama esnasında sızdırmazlığın sağlanması gerekir. Bu sızdırmazlığı sağlayan pistonların etrafına bilezik gibi takılan segmanlardır."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Silindir gömleği iç yüzeyi, yanma odası ve karter arasındaki sızdırmazlığı sağlayan segmanların sürtündüğü yüzeydir."
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Motor gömlek değişimi",
                    details = "Motorun çalışması, yanma odasında gerçekleşen patlamalar sonucu ısı enerjisinin mekanik enerjiye dönüşümü şeklinde gerçekleşir. Yanma odasının çerçevesini de silindir gömleği oluşturduğu için, gömlek çok yoğun ısı ve basınca maruz kalır. Aracın bakımına dikkat edilmemesi, yağının ve suyunun düzenli aralıklarla kontrol edilip eksiğinin tamamlanmaması da maruz kalınan ısı ve basıncı daha da artırır. Bu tür hatalı kullanımlar gömlekte kalıcı deformasyona neden olur ve segmanlar artık sızdırmazlığı sağlayamaz hale gelir. Bunun sonucunda motor yağ yakmaya başlar. Gömlek değişimi titizlik ve profesyonellik gerektiren bir işlemdir. Hatalı yapılan gömlek değişimi motorunuzda daha ciddi sorunların çıkmasına neden olabilir. Gömlek değişimini mutlaka güvendiğiniz bir serviste yaptırınız."
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Silindir gömleğinde deformasyona neden olan etkenler",
                    details = "1. Aracın motoruna uygun olmayan yağ kullanılması, yağın zamanında değiştirilmemesi.\n2. Motor soğutma sıvısı eksildiğinde tamamlanmaması, soğutma sıvısına antifriz katılmaması.\n3. Kalitesiz yakıt kullanılması."
                )
            )
        ),
        InformationCards(
            id = 23,
            lessonName = "Silindir kapak contası",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Silindir kapak contası; silindir bloğu ile silindir kapağı arasındaki sızdırmazlığı sağlayan parçadır. Yandığı zaman büyük sorunlara neden olan silindir kapak contası, motor için hayati öneme sahiptir.",
                    details = "Silindir kapak contasının ne işe yaradığını anlatabilmek için silindir kapağı, silindir bloğunu ve karterin ne olduğuna kısaca değinelim."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Silindir kapağı; üzerinde eksantrik mili, sübaplar, bujiler ve enjektörlerin yer aldığı ve yanma odasının üst kısmını oluşturan kapaktır."
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Silindir bloğu; krank miline yataklık yapan zamanlama dişlileri, piston gibi parçaları da üzerinde bulunduran motorun orta kısmını oluşturan gövdedir."
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Karter; silindir bloğunun alt kısmında bulunan ve motor yağının depolanmasını sağlayan bir parçadır. Silindir kapağı, silindir bloğunun üst kısmını kapatırken, karter de silindir bloğunun alt kısmını kapatarak motoru kapalı bir sistem haline getirir."
                ),
                InformationCardsInfo(
                    id = 5,
                    description = "Motorun çalışabilmesi için gerekli olan patlama reaksiyonları yanma odasında gerçekleşir. Yanma odası dediğimiz bölüm silindir kapağı ile silindir bloğu arasında kalan bir bölgededir. Ayrıca motorun çalışması esnasında motor parçalarının ısı ve sürtünmeden dolayı zarar görmesini önlemek için motor yağı ile yağlanması gerekir. Motorun yağlanması esnasında ve patlama reaksiyonlarının gerçekleşmesi esnasında silindir bloğu ile silindir kapağı arasında tam bir sızdırmazlık olmak zorundadır. Çünkü sızıntı olması durumunda yanma odasının içerisine su ve yağ dolacaktır."
                ),
                InformationCardsInfo(
                    id = 6,
                    description = "Silindir kapak contası neden yanar?",
                    details = "1. Aracınızın hararet yapması durumunda silindir kapak contası ısıya daha fazla dayanamayarak erir ve silindir kapağı ile silindir bloğunun kenarlarına yapışır.\n2. Motorun soğutma sıvısı olarak yalnızca musluk suyu kullanmak silindir bloğuna asidik ortam oluşturarak contanın zamanla aşınmasına neden olur. Motorumuzun soğutma sıvısına yaz kış mutlaka uygun oranlarda antifriz ilave etmeliyiz.\n3. Silindir kapağı ve karterdeki çatlaklar da conta yakmanıza neden olur.\n4. Motor sıcakken radyatör kapağının açılması. Çalışan motordaki suyun sıcaklığı 110 derece civarındadır ancak motor bloğu kapalı olduğu ve içindeki su yüksek basınç altında olduğu için 110 derece sıcaklıktaki su kaynamaz. Ancak siz radyatör kapağını açtığınızda motorun içindeki suyun basıncı aniden düşer ve motordaki suyun kaynamasına neden olur. Kaynama esnasında silindir kapak contası ile suyun teması anlık kesilirse conta yanabilir."
                ),
                InformationCardsInfo(
                    id = 7,
                    description = "Silindir kapak contası yandığında ne olur?",
                    details = "1. Motor suyu ile motor yağı karışmaya başlar. Motor yağı su ile karışıp özelliğini kaybedeceğinden motorun yağlanan hareketli parçaları sürtünmenin artmasından dolayı aşınmalar artacaktır.\n2. Radyatör ve hortumlarda kaçak olmadığı halde motor su eksiltir.\n3. Motor suyu silindirlere dolduğundan ilk çalıştırma esnasında aracınız daha zor çalışacaktır.\n4. Aracınızın çekişi düşer çünkü yakıta su karışmıştır.\n5. Egzozdan beyaz duman çıkar veya egzoz su atar.\n6. Aracınız hararet yapmaya başlayacaktır."
                ),
                InformationCardsInfo(
                    id = 8,
                    description = "Motorun conta yaktığı nasıl anlaşılır?",
                    details = "1. Aracınız sürekli su eksiltiyorsa ve radyatör ile hortumlarda kaçak yoksa aracınız mutlaka conta yakmıştır.\n2. Aracınızı ilk çalıştırdığınızda radyatör kapağı ve yedek su bidonunun kapağını açın. Eğer suyun dışarı fışkırdığını ya da fışkırmaya çalıştığını görürseniz contanız yanmış demektir.\n3. Motor yağ çubuğunu çıkarıp yağın rengine baktığınızda motor yağının renginde bir değişiklik görüyorsanız aracınız conta yakmış ve motor yağına su karışmıştır."
                )
            )
        ),
        InformationCards(
            id = 24,
            lessonName = "Sis, Kısa ve Uzun Farlar",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Araç Işıklarının Kullanılması",
                    details = "a) Uzağı gösteren ışıklar (uzun hüzmeli farlar): Yerleşim birimleri dışındaki karayollarında geceleri seyrederken, yeterince aydınlatılmamış tünellere girerken, benzeri yer ve hallerde uzağı gösteren ışıkların yakılması zorunludur."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "b) Yakını gösteren ışıklar (kısa hüzmeli farlar): Geceleri, yerleşim birimleri dışında karayollarındaki karşılaşmalarda bir aracı takip ederken, bir aracı geçerken yan yana gelinceye kadar ve yerleşim birimleri içinde, gündüzleri ise görüşü azaltan sisli, yağışlı ve benzeri havalarda yakını gösteren ışıkların yakılması mecburidir."
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "NOT: Kısa farla 25 m., uzun farlar 100 m. ileriyi aydınlatır."
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Işıkların kullanılmasına ilişkin esaslar:",
                    details = "1. Dönüş ışıklarının geç anlamında kullanılması.\n2. Sadece park ışıkları yakılarak araç sürülmesi.\n3. Karşılaşmalarda ışıkların söndürülmesi.\n4. Yönetmeliklerde gösterilen esaslara aykırı ışık takılması ve kullanılması.\n5. Sis ışıklarının; sis, kar, şiddetli yağmur halleri dışında ve geceleri yakını ve uzağı gösteren ışıklarla aynı zamanda kullanılması.\n6. Yönetmelik esaslarına uygun olarak takılan ışıkların da amaç dışında ve gereksiz kullanılması yasaktır."
                )
            )
        ),
        InformationCards(
            id = 25,
            lessonName = "Sollama ve Dönüş Kuralları",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Sürücülerin önlerinde giden aracı geçmeleri için:",
                    details = "1. Arkasından gelen bir başka sürücünün geçmeye başlamamış olmasına,\n2. Önünde giden sürücünün bir başka aracı geçme niyetini belirten uyarma işaretini vermemiş bulunmasına.\n3. Geçeceği aracın hızıyla, geçme esnasındaki kendi hızını da dikkate alarak, iki yolarda da karşıdan gelen trafik dahil, yolu kullananların tümü için tehlike veya engel yapmadan geçme için kullanacağı şeridin yeteri kadar ilerisinin görüşe açık ve boş olmasına,\n4. Geçişin, geçilen araçlar için bir güçlük yaratmayacak şekilde ve araçlarının bu geçişe uygun durumda bulunmasına dikkat etmeleri mecburidir."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "ÖNDEKİ ARACI GEÇMENİN YASAK OLDUĞU YERLER",
                    details = "Sürücüler;\n1. Geçmenin herhangi bir trafik işaretiyle yasaklandığı yerlerde\n2. Köprülerde, tünellerde, kavşaklarda, demiryolu geçitlerinde, görüşün yetersiz olduğu tepe üstü ve virajlarda, önlerindeki araçları geçmeleri yasaktır."
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Sağa dönüşler:",
                    details = "1. Dönüş işareti vermeye,\n2. Sağ şeride veya işaretle dönüş izni verilen şeride girmeye,\n3. Hızını azaltmaya,\n4. Dar bir kavisle dönüş yapmaya mecburdurlar."
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Sola dönüşler:",
                    details = "1. Dönüş işareti vermeye,\n2. Yolun gidişe ayrılmış olan kısmının soluna yanaşmaya,\n3. Hızını azaltmaya,\n4. Dönüşe başlamadan, varsa sağdan gelen taşıtlara ilk geçiş hakkını vermeye,\n5. Dönüş sırasında, karşıdan gelen ve emniyetle duramayacak kadar kavşağa olan araçların geçmesini beklemeye,\n6. Gireceği yolun gidişe ayrılan kısmına girmek üzere, arkadan gelen ve sola dönecek diğer taşıtları engellememek için dönüşünü geniş kavisle yapmaya,\n7. Dönüş sırasında ilk geçiş hakkını, kurallara uygun olarak karşıya geçen yayalara, varsa bisiklet yolundaki bisikletlere vermeye mecburdurlar."
                ),
                InformationCardsInfo(
                    id = 5,
                    description = "Araç sürücülerinin:",
                    details = "1. Bağlantı yollarında geri gitmeleri,\n2. Tek yönlü yollarda, duraklama veya park manevrası dışında geri gitmeleri,\n3. İki aracın emniyetle geçemeyeceği kadar dar olan iki yönlü yol kesimlerinde, karşılama ve geçiş kolaylığı dışında, geri gitmeleri,\n4. Daha geniş yollarda geriye giderken manevra dışında şerit değiştirmeleri,\n5. Trafiği yoğun olan yollarda geriye dönmeleri yasaktır."
                ),
                InformationCardsInfo(
                    id = 6,
                    description = "Trafik polisi, ışıklı trafik işaret cihazları veya trafik işaret levhaları bulunmayan kavşaklarda:",
                    details = "1. Bütün araçlar geçiş üstünlüğüne sahip araçlara görev anındayken öncelik verir.\n2. Bütün sürücüler doğru geçmekte olan tramvay hattı bulunan yoldan geçen araçlara,\n3. Bölünmüş yola çıkan sürücüler bu yoldan geçen araçlara,\n4. Tali yoldan çıkan sürücüler ana yoldaki sürücülere,\n5. Dönel kavşak dışındaki sürücüler, dönel kavşak içindeki araçlara,\n6. Bir iz veya mülkten karayoluna çıkan sürücüler, karayolundaki araçlara ilk geçiş hakkını vermek zorundadır."
                )
            )
        ),
        InformationCards(
            id = 26,
            lessonName = "Tanımlar",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Trafik:",
                    details = "Yayaların ve araçların karayolları üzerindeki hal ve hareketleridir."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Karayolu (Yol):",
                    details = "Trafik için, kamunun yararlanmasına açık olan arazi şeridi, köprüler ve alanlardır."
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Geçiş Üstünlüğü:",
                    details = "Görev sırasında, belirli araç sürücülerinin can ve mal güvenliğini tehlikeye sokmamak şartı ile trafik kısıtlama ve yasaklarına bağlı olmamalarıdır."
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Geçiş Hakkı:",
                    details = "Yayaların veya araç kullananların, yolu kullanmak sırasındaki öncelik hakkıdır."
                ),
                InformationCardsInfo(
                    id = 5,
                    description = "Durma:",
                    details = "Her türlü trafik zorunlulukları dışında araçların insan indirmek ve bindirmek, eşya yüklemek, boşaltmak veya beklemek amacıyla kısa süre için durdurulmasıdır."
                ),
                InformationCardsInfo(
                    id = 6,
                    description = "Park etme:",
                    details = "Araçların, durdurma ve duraklaması gereken haller dışında bırakılmasıdır."
                ),
                InformationCardsInfo(
                    id = 7,
                    description = "İki Yönlü Karayolu:",
                    details = "Taşıt yolunun her iki yöndeki taşıt trafiği için kullanıldığı karayoludur."
                ),
                InformationCardsInfo(
                    id = 8,
                    description = "Tek Yönlü Karayolu:",
                    details = "Taşıt yolunun yalnızca bir yöndeki taşıt trafiği için kullanıldığı karayoludur."
                ),
                InformationCardsInfo(
                    id = 9,
                    description = "Bölünmüş Karayolu:",
                    details = "Bir yöndeki trafiğe ait taşıt yolunun bir ayırıcı ile belirli şekilde diğer taşıt yolundan ayrılması ile meydana gelen karayoludur."
                ),
                InformationCardsInfo(
                    id = 10,
                    description = "Erişme Kontrollü Karayolu (Otoyol – Ekspresyol):",
                    details = "Özellikle transit trafiğe tahsis edilen, belirli yerle ve şartlar dışında giriş ve çıkışın yasaklandığı, yaya, hayvan ve motorsuz araçların giremediği, ancak izinli motorlu araçların yararlandığı ve trafiğin özel kontrole tabi tutulduğu karayoludur."
                ),
                InformationCardsInfo(
                    id = 11,
                    description = "Geçiş Yolu:",
                    details = "Araçların bir mülke girip çıkması için yapılmış olan karayolu üzerinde bulunan kısmıdır."
                ),
                InformationCardsInfo(
                    id = 12,
                    description = "Bağlantı Yolu:",
                    details = "Bir kavşak yakınında karayolu taşıt yollarının birbirine bağlanmasını sağlayan, kavşak alanı dışında bulunan karayoludur."
                ),
                InformationCardsInfo(
                    id = 13,
                    description = "Banket:",
                    details = "Yaya yolu ayrılmamış karayolunda, taşıt yolu kenarı ile şevbaşı veya hendek iç üst kenarı arasında kalan ve olağan olarak yayaların ve hayvanların kullanacağı, zorunlu hallerde de araçların faydalanabileceği kısımdır."
                ),
                InformationCardsInfo(
                    id = 14,
                    description = "Platform:",
                    details = "Karayolunun, taşıt yolu (kaplama) ile yaya yolu (kaldırım) veya banketinden oluşan kısmıdır."
                ),
                InformationCardsInfo(
                    id = 15,
                    description = "Kavşak:",
                    details = "İki veya daha fazla karayolunun kesişmesi veya birleşmesi ile oluşan ortak alandır."
                ),
                InformationCardsInfo(
                    id = 16,
                    description = "Tali Yol:",
                    details = "Genel olarak üzerindeki trafik yoğunluğu bakımından bağlandığı yoldan daha az önemde olan yoldur."
                ),
                InformationCardsInfo(
                    id = 17,
                    description = "Anayol:",
                    details = "Ana trafiğe açık olan ve bunu kesen karayolundaki trafiğin bu yolu geçerken veya bu yola girerken, ilk geçiş hakkını vermesi gerektiği işaretlerle belirlenmiş karayoludur."
                ),
                InformationCardsInfo(
                    id = 18,
                    description = "Okul Geçidi:",
                    details = "Genel olarak okul öncesi, ilk öğretim ve orta dereceli okulların çevresinde özellikle öğrencilerin geçmesi için taşıt yolundan ayrılmış ve trafik işaretiyle belirlenmiş alandır."
                ),
                InformationCardsInfo(
                    id = 19,
                    description = "Demiryolu Geçidi (Hemzemin Geçit):",
                    details = "Karayolu ile demiryolunun aynı seviyede kesiştiği bariyerli veya bariyersiz geçitlerdir."
                ),
                InformationCardsInfo(
                    id = 20,
                    description = "Otomobil:",
                    details = "Yapısı itibariyle, sürücüsünden başka en çok yedi oturma yeri olan ve insan taşımak için imal edilmiş bulunan motorlu taşıttır. Bunlardan taksimetre veya tarife ile yolcu taşıyanlara taksi otomobil, adam başına ücretle yolcu taşıyanlara dolmuş otomobil denir."
                ),
                InformationCardsInfo(
                    id = 21,
                    description = "Minibüs:",
                    details = "Yapısı itibariyle, sürücüsünden başka sekiz ile on dört oturma yeri olan ve insan taşımak için imal edilmiş bulunan motorlu taşıttır."
                ),
                InformationCardsInfo(
                    id = 22,
                    description = "Otobüs:",
                    details = "Yapısı itibariyle, sürücüsünden başka en az on beş oturma yeri olan ve insan taşımak için imal edilmiş bulunan motorlu taşıttır. Troleybüsler de bu sınıfa girer."
                ),
                InformationCardsInfo(
                    id = 23,
                    description = "Kamyonet:",
                    details = "İzin verilebilen azami yüklü ağırlığı 3500 kg'ı geçmeyen ve yük taşımak için imal edilmiş motorlu taşıttır."
                ),
                InformationCardsInfo(
                    id = 24,
                    description = "Kamyon:",
                    details = "İzin verilebilen azami yüklü ağırlığı 3500 kg'dan fazla olan ve yük taşımak için imal edilmiş motorlu taşıtlardır."
                ),
                InformationCardsInfo(
                    id = 25,
                    description = "Çekici:",
                    details = "Romörk ve yarı romörkleri çekmek için imal edilmiş olan ve yük taşımayan motorlu taşıtlardır."
                ),
                InformationCardsInfo(
                    id = 26,
                    description = "Arazi Taşıtı:",
                    details = "Karayollarında yolcu ve yük taşıyabilecek şekilde imal edilmiş olmakla beraber, bütün tekerlekleri motordan güç alan motorlu taşıttır."
                ),
                InformationCardsInfo(
                    id = 27,
                    description = "Gabari:",
                    details = "Araçların, yüklü veya yüksüz olarak karayolunda güvenli seyirlerini temin amacı ile uzunluk, genişlik ve yüksekliklerini belirleyen ölçüdür. (Genişlik: 2.5 m; Yükseklik: 4 m)"
                ),
                InformationCardsInfo(
                    id = 28,
                    description = "Azami Ağırlık:",
                    details = "Taşıtın güvenle taşıyabileceği azami yüklü ağırlığı."
                ),
                InformationCardsInfo(
                    id = 29,
                    description = "Dingil Ağırlığı:",
                    details = "Araçta aynı dingile bağlı tekerleklerden, karayolu yapısına aktarılan ağırlıktır. (Tek dingil: 10 ton; İki dingil: 18 ton)"
                )
            )
        ),
        InformationCards(
            id = 27,
            lessonName = "Tehlikeli Madde Taşınması",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Tehlikeli madde taşıyan araçlar, şehir içerisinde 30km/s, şehir dışında 50km/s hızla gidebilir.",
                    details = "Eğer araç boşsa, kendi sınıfının hızı ile hareket edebilir."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Dolum veya boşaltım sırasında kıvılcım çıkaran nesnelere en fazla 30m yaklaşılabilir.",
                    details = "Park anında 20m takip mesafesi ve 50m güvenlik mesafesi sağlanmalıdır."
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Tehlikeli madde taşıyan araçlarda 6kg kapasiteli iki adet yangın söndürme cihazı bulunmalıdır.",
                    details = "Temizlik sırasında tanker içindeki aydınlatma fenerinin 6 voltluk pil ile çalışması gerekmektedir."
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Arıza anında araçta başka bir gözcü bulunmalıdır."
                )
            )
        ),
        InformationCards(
            id = 28,
            lessonName = "Trafik ve Karayolu Tanımları",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Trafik:",
                    details = "Yayaların ve araçların karayolları üzerindeki hal ve hareketleridir."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Karayolu (Yol):",
                    details = "Trafik için, kamunun yararlanmasına açık olan arazi şeridi, köprüler ve alanlardır."
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Geçiş Üstünlüğü:",
                    details = "Görev sırasında, belirli araç sürücülerinin can ve mal güvenliğini tehlikeye sokmamak şartı ile trafik kısıtlama ve yasaklarına bağlı olmamalarıdır."
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Geçiş Hakkı:",
                    details = "Yayaların veya araç kullananların, yolu kullanmak sırasındaki öncelik hakkıdır."
                ),
                InformationCardsInfo(
                    id = 5,
                    description = "Durma:",
                    details = "Her türlü trafik zorunlulukları dışında araçların insan indirmek ve bindirmek, eşya yüklemek, boşaltmak veya beklemek amacıyla kısa süre için durdurulmasıdır."
                ),
                InformationCardsInfo(
                    id = 6,
                    description = "Park etme:",
                    details = "Araçların, durdurma ve duraklaması gereken haller dışında bırakılmasıdır."
                ),
                InformationCardsInfo(
                    id = 7,
                    description = "İki Yönlü Karayolu:",
                    details = "Taşıt yolunun her iki yöndeki taşıt trafiği için kullanıldığı karayoludur."
                ),
                InformationCardsInfo(
                    id = 8,
                    description = "Tek Yönlü Karayolu:",
                    details = "Taşıt yolunun yalnızca bir yöndeki taşıt trafiği için kullanıldığı karayoludur."
                ),
                InformationCardsInfo(
                    id = 9,
                    description = "Bölünmüş Karayolu:",
                    details = "Bir yöndeki trafiğe ait taşıt yolunun bir ayırıcı ile belirli şekilde diğer taşıt yolundan ayrılması ile meydana gelen karayoludur."
                ),
                InformationCardsInfo(
                    id = 10,
                    description = "Erişme Kontrollü Karayolu (Otoyol – Ekspresyol):",
                    details = "Özellikle transit trafiğe tahsis edilen, belirli yerle ve şartlar dışında giriş ve çıkışın yasaklandığı, yaya, hayvan ve motorsuz araçların giremediği, ancak izinli motorlu araçların yararlandığı ve trafiğin özel kontrole tabi tutulduğu karayoludur."
                ),
                InformationCardsInfo(
                    id = 11,
                    description = "Geçiş Yolu:",
                    details = "Araçların bir mülke girip çıkması için yapılmış olan karayolu üzerinde bulunan kısmıdır."
                ),
                InformationCardsInfo(
                    id = 12,
                    description = "Bağlantı Yolu:",
                    details = "Bir kavşak yakınında karayolu taşıt yollarının birbirine bağlanmasını sağlayan, kavşak alanı dışında bulunan karayoludur."
                ),
                InformationCardsInfo(
                    id = 13,
                    description = "Banket:",
                    details = "Yaya yolu ayrılmamış karayolunda, taşıt yolu kenarı ile şevbaşı veya hendek iç üst kenarı arasında kalan ve olağan olarak yayaların ve hayvanların kullanacağı, zorunlu hallerde de araçların faydalanabileceği kısımdır."
                ),
                InformationCardsInfo(
                    id = 14,
                    description = "Platform:",
                    details = "Karayolunun, taşıt yolu (kaplama) ile yaya yolu (kaldırım) veya banketinden oluşan kısmıdır."
                ),
                InformationCardsInfo(
                    id = 15,
                    description = "Kavşak:",
                    details = "İki veya daha fazla karayolunun kesişmesi veya birleşmesi ile oluşan ortak alandır."
                ),
                InformationCardsInfo(
                    id = 16,
                    description = "Tali Yol:",
                    details = "Genel olarak üzerindeki trafik yoğunluğu bakımından bağlandığı yoldan daha az önemde olan yoldur."
                ),
                InformationCardsInfo(
                    id = 17,
                    description = "Anayol:",
                    details = "Ana trafiğe açık olan ve bunu kesen karayolundaki trafiğin bu yolu geçerken veya bu yola girerken, ilk geçiş hakkını vermesi gerektiği işaretlerle belirlenmiş karayoludur."
                ),
                InformationCardsInfo(
                    id = 18,
                    description = "Okul Geçidi:",
                    details = "Genel olarak okul öncesi, ilk öğretim ve orta dereceli okulların çevresinde özellikle öğrencilerin geçmesi için taşıt yolundan ayrılmış ve trafik işaretiyle belirlenmiş alandır."
                ),
                InformationCardsInfo(
                    id = 19,
                    description = "Demiryolu Geçidi (Hemzemin Geçit):",
                    details = "Karayolu ile demiryolunun aynı seviyede kesiştiği bariyerli veya bariyersiz geçitlerdir."
                ),
                InformationCardsInfo(
                    id = 20,
                    description = "Otomobil:",
                    details = "Yapısı itibariyle, sürücüsünden başka en çok yedi oturma yeri olan ve insan taşımak için imal edilmiş bulunan motorlu taşıttır. Bunlardan taksimetre veya tarife ile yolcu taşıyanlara taksi otomobil, adam başına ücretle yolcu taşıyanlara dolmuş otomobil denir."
                ),
                InformationCardsInfo(
                    id = 21,
                    description = "Minibüs:",
                    details = "Yapısı itibariyle, sürücüsünden başka sekiz ile on dört oturma yeri olan ve insan taşımak için imal edilmiş bulunan motorlu taşıttır."
                ),
                InformationCardsInfo(
                    id = 22,
                    description = "Otobüs:",
                    details = "Yapısı itibariyle, sürücüsünden başka en az on beş oturma yeri olan ve insan taşımak için imal edilmiş bulunan motorlu taşıttır. Troleybüsler de bu sınıfa girer."
                ),
                InformationCardsInfo(
                    id = 23,
                    description = "Kamyonet:",
                    details = "İzin verilebilen azami yüklü ağırlığı 3500 kg'ı geçmeyen ve yük taşımak için imal edilmiş motorlu taşıttır."
                ),
                InformationCardsInfo(
                    id = 24,
                    description = "Kamyon:",
                    details = "İzin verilebilen azami yüklü ağırlığı 3500 kg'dan fazla olan ve yük taşımak için imal edilmiş motorlu taşıtlardır."
                ),
                InformationCardsInfo(
                    id = 25,
                    description = "Çekici:",
                    details = "Romörk ve yarı romörkleri çekmek için imal edilmiş olan ve yük taşımayan motorlu taşıtlardır."
                ),
                InformationCardsInfo(
                    id = 26,
                    description = "Arazi Taşıtı:",
                    details = "Karayollarında yolcu ve yük taşıyabilecek şekilde imal edilmiş olmakla beraber, bütün tekerlekleri motordan güç alan motorlu taşıttır."
                ),
                InformationCardsInfo(
                    id = 27,
                    description = "Gabari:",
                    details = "Araçların, yüklü veya yüksüz olarak karayolunda güvenli seyirlerini temin amacı ile uzunluk, genişlik ve yüksekliklerini belirleyen ölçüdür. (Genişlik: 2.5 m; Yükseklik: 4 m)"
                ),
                InformationCardsInfo(
                    id = 28,
                    description = "Azami Ağırlık:",
                    details = "Taşıtın güvenle taşıyabileceği azami yüklü ağırlığı."
                ),
                InformationCardsInfo(
                    id = 29,
                    description = "Dingil Ağırlığı:",
                    details = "Araçta aynı dingile bağlı tekerleklerden, karayolu yapısına aktarılan ağırlıktır. (Tek dingil: 10 ton; İki dingil: 18 ton)"
                )
            )
        ),
        InformationCards(
            id = 29,
            lessonName = "Trafik İşaret Levhaları",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Trafik İşaret Levhaları",
                    details = "Bu yol işaretleri araç sürücülerini olması muhtemel trafik kazalarına ve tehlikelerine karşın bilgilendirmek amaçlı olarak geliştirilen trafik levhalarıdır. Olması muhtemel kazaları engellemek için trafikte hayati önem taşırlar ve bu işaretleri takip etmek çok önemlidir. Toplamda 52 adet işaretten oluşmaktadır. Bunlardan en sık rastladığımız levhalar başlıca sağa viraj, sola viraj, u dönüşü, sağa dönüş yasak, sola dönüş yasak vb. olarak gösterilebilir."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "TRAFİK TANZİM İŞARETLERİ",
                    details = "Bu grupta yer alan trafik levhaları daha çok trafikte düzeni sağlamak ve sürücüyü bilgilendirmek amaçlı geliştirilmişlerdir. Bu grupta toplam 69 adet farklı yol işaret levhası bulunur. Bu levhaları takip edersek trafik kurallarına daha çok riayet etmiş oluruz ve trafikte gideceğimiz yönleri daha iyi tayin ederiz. Bu işaretlerden başlıcalarıda yükseklik ve ağırlık limitlerini gösteren tabelalar, mecburi yön tabelaları, maksimum genişlik gösteren tabelaları ve giriş ve dönüş kısıtlaması ve yasakları tabelalarıdır."
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "BİLGİ İŞARETLERİ",
                    details = "Bu grupta yer alan tabelalarda daha çok sürücüye yol hakkında bilgiler veren ve yol üzerinde bulunan yerleşim yerleri, kurumlar, il sınırları gibi bilgileri içeren tabelalardır. Bu grupta toplam 112 adet yol işaret levhası bulunur. Bu tabelalardan başlıcalarıda il sınırı ve il sınırı bitişi, hastane, petrol, kamp yerleri, otopark, hız sınırı gibi tabelalardır."
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "DURMA ve PARKETME İŞARETLERİ",
                    details = "Bu gruptaki trafik işaretleri sürücüye nerede park edebileceği, nerede durup nerede duramayacağı gibi bilgiler veren trafik levhalarıdır. Bu grupta toplam 10 adet levha vardır. Bu levhalar daha çok park levhalarından oluşmaktadır."
                ),
                InformationCardsInfo(
                    id = 5,
                    description = "YATAY İŞARETLEME",
                    details = "Bu gruptaki işaretler trafik işaret levhası halinde değil, yol üzerinde bulunan ve sürücülere bilgi veren işaretlerdir. Toplamda 23 farklı işaretten oluşur."
                )
            )
        ),
        InformationCards(
            id = 30,
            lessonName = "Trafik Polisinin Hareketleri ve Trafik Işıkları",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Trafik Polisinin Duruşu ve Pozisyonu",
                    details = "Trafik polisinin duruş ve pozisyonuna göre, polis hazırolda veya kollarını açmış ise trafik polisinin ön ve arka kısmı trafiğe kapalı, sağ ve sol tarafı trafiğe açıktır."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Trafik Polisinin El Hareketleri",
                    details = "Trafik polisi elinin birini havaya kaldırmışsa bütün yollar trafiğe kapalıdır."
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Işıklı Trafik İşaret Cihazları",
                    details = "Işıklı trafik işaret cihazları, aşağıdaki şekilde çalışır:"
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Kırmızı Işık",
                    details = "Yolun trafiğe kapalı olduğunu gösterir. Aksine bir işaret yoksa, durup beklenir."
                ),
                InformationCardsInfo(
                    id = 5,
                    description = "Sarı Işık",
                    details = "Uyarı anlamındadır. Kırmızı ışıkla birlikte yanarsa hazırlan yol trafiğe açılmak üzeredir. Yeşil ışıkla birlikte yanarsa yol trafiğe kapanmak üzeredir."
                ),
                InformationCardsInfo(
                    id = 6,
                    description = "Yeşil Işık",
                    details = "Yolun trafiğe açık olduğunu gösterir."
                ),
                InformationCardsInfo(
                    id = 7,
                    description = "Fasılalı Işık",
                    details = "Kırmızı ise dur, sarı ise dikkatli geç anlamındadır."
                ),
                InformationCardsInfo(
                    id = 8,
                    description = "Yazılı ve Sesli Işık",
                    details = "Araç trafiğine göre yaya trafiğini düzenler ve yayalara hitap eder."
                )
            )
        ),
        InformationCards(
            id = 31,
            lessonName = "Trafik Tescil İşlemleri",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Araç Tescili",
                    details = "Araç sahipleri araçlarını yönetmelikte belirtilen esaslara göre yetkili tescil kuruluşuna tescil ettirmek ve tescil belgesi almak zorundadır."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Yeni Araç Tescili",
                    details = "Tescili zorunlu olan ve daha önce tescili yapılmamış bir aracı satın alan veya gümrükten çeken araç sahipleri, satın alma veya gümrükten çekme tarihinden itibaren üç ay içinde gerekli bilgi ve belgelerle birlikte yazılı olarak yetkili tescil kuruluşuna müracaat etmek zorundadırlar."
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Noter Senedi ile Araç Alımı",
                    details = "Tescili araçları NOTER senediyle satın veya devir alan araç sürücüleri, aracı adına tescil ettirmek üzere gerekli bilgi ve belgelerle birlikte bir ay içinde yetkili tescil kuruluşuna müracaat etmek zorundadırlar."
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Trafik Belgesi ve Tescil Plakaları",
                    details = "Tescil edilerek tescil belgesi alınan araçların karayoluna çıkabilmesi için ayrıca TRAFİK BELGESİ ve TESCİL PLAKALARI'nı alması gerekir."
                ),
                InformationCardsInfo(
                    id = 5,
                    description = "Araç Üzerinde Tescil Belgeleri",
                    details = "Tescil belgesi, trafik belgesi ve tescil plakaları araç üzerinde hazır ve uygun durumda bulundurmadan araç trafiğe çıkamaz."
                ),
                InformationCardsInfo(
                    id = 6,
                    description = "Geçici Trafik Belgesi ve Plakaları",
                    details = "Tescil işlemleri geciken araçların geçici olarak trafiğe çıkarılıp karayolunda kullanılması için geçici trafik belgesi ve geçici trafik plakaları alınması mecburidir."
                ),
                InformationCardsInfo(
                    id = 7,
                    description = "Plakaların Durumu",
                    details = "Tescil plakalarının araç üzerinde ve uygun durumda bulundurulması yanında ışıkların yakılması ile birlikte arka plakaların 20 metre mesafeden okunabilecek şekilde aydınlatılmış ve temiz olmalıdır."
                ),
                InformationCardsInfo(
                    id = 8,
                    description = "Mali Sorumluluk Sigortası",
                    details = "Motorlu bir aracın işletilmesi ve herhangi bir kazaya karışması gibi durumlara karşı mali sorumluluk sigortası yaptırması zorunludur."
                ),
                InformationCardsInfo(
                    id = 9,
                    description = "Denetim Sırasında Gerekli Belgeler",
                    details = "Motorlu araç sürücüleri trafik zabıtası (polisi) tarafından yapılacak denetim ve kontrol sırasında, sürücü belgesini, tescil belgelerini, trafik belgesini, mali sorumluluk sigorta poliçesini ve tescil plakalarını göstermek zorundadır."
                ),
                InformationCardsInfo(
                    id = 10,
                    description = "Hurdaya Ayrılan Araçların Tescili",
                    details = "Araç sahipleri ekonomik ömrünün dolması, kaza, yangın, tahrip edilme veya benzeri sebeplerle hurdaya ayırdıkları araçların tescilinin silinmesi için hurdaya ayırma tarihinden itibaren 1 ay içinde ilgili tescil kuruluşuna dilekçe ile müracaat etmek zorundadır."
                )
            )
        ),
        InformationCards(
            id = 32,
            lessonName = "Volan",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Volan Dişlisi",
                    details = "Kökeni Fransızca bir kelime olan Volant kelimesinden gelen Volan dişlisi, içten yanmalı motorlarda, marş motorundan üretilen hareketi (tork) motorun devrini başlatan ve sürdüren bütün mekanizmaya aktaran ve düzenli işleyişini kontrol edilebilir hale getirmeye yarayan önemli bir parçadır."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Volan Dişlisinin Çalışma Prensibi",
                    details = "Volan dişlisi marş motorunun dişlisi ile entegre biçimdedir. Araçta marşa basıldığı an, marş motoru devreye girer ve marş motoru dişilisi hareket ederek volan dişlisi ile var olan bağlantısı nedeniyle üretilen torku buraya aktarmaktadır. Hareketi devralan volan dişlisi bundan sonraki süreçte bu hareketi krank miline aktarır. Volan merkezine entegre halde çalışan krank mili, hareket etmesiyle birlikte motordaki devir daimin kilit noktası olan pistonları aşağı ve yukarı yönlü hareket ettirir. Bunun akabinde motorun ateşleme ve yakıt sistemi kendiliğinden devreye girerek motorun kusursuz bir şekilde işlemesi sağlanır. Motor çalışmaya başladıktan sonra, pistonlar aşağı yukarı hareket ederek, bu defa krank milini, krank miline sabit olan volan dişlisini çevirir. Volan dişlisinin debriyaj balatasına bakan zımparayı andıran yüzü, manuel şanzımanlı araçlarda debriyaj pedalına basıldığında ayrık, pedal bırakıldığında ise şanzıman balatasına yapışır ve bu bağlantı hareketin şanzımana ve sonrasında tekerleklere aktarılmasını sağlar. Otomatik şanzımanlı araçlarda ise debriyaj balatası olmadığından tekerleklere hareketi aktarma görevini tork konvertörü yerine getirmektedir."
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Volan Dişlisinin Bozulma Sebepleri",
                    details = "Volan dişlisi bütün motor mekanizması içerisinde kritik bir öneme sahiptir. Bu önem nedeniyle motorun devrinin gerçekleşmesinde üstlendiği görev, onu bu mekanizmanın en önemli parçası yapmaktadır. Volan dişlisinin bozulması, marş motoru dişlisinden sağlanan bağlantısının zamanla aşınarak hareket aktarma kabiliyetinin zayıflaması veya dişlilerin zamanla eskimeye bağlı olarak kırılması şeklinde meydana gelebilir. Genel olarak volan dişlisinin en sık rastlanan bozulma sebepleri, araç çalışırken marşa basılması, aracın vurdurularak çalıştırılması, marş dinamosuna bağlı bozulmalar, eskimeye bağlı bozulmalar sayılabilir."
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Volan Dişlisi Bozulursa Ne Olur?",
                    details = "Volan dişlisi arızasında aracın performansı büyük ölçüde etkilenir. Çünkü arızalı volan tork aktarma görevini olması gerektiği gibi yerine getiremez. Bu durumda araç özellikle düşük devirlerde aşırı cansız olur. Volan dişlisi arızalı olan araç yokuşlarda hissedilir bir biçimde performans kaybı yaşamaktadır. Çok sık karşılaşılan durumlardan biri de volan dişlisinin bozulması halinde motorun gaz hareketlerine anormal tepkiler vermesidir."
                ),
                InformationCardsInfo(
                    id = 5,
                    description = "Volan Dişlisi Nasıl Değiştirilir?",
                    details = "Aracın şanzıman ve motorun birleştiği noktada bulunan volan dişlisi, arızalanması durumunda değiştirilerek yenisi takılır. Değiştirme işlemi yapılırken şanzıman indirilir yani yerinden sökülür. Bu işlemde şanzımanın içi açılmaz. İndirilen şanzımanın üzerinde bulunan volan dişlisi, bağlantı noktalarından araçlar yardımıyla sökülür ve yenisiyle değiştirilir. Oldukça zahmetli ve uzun sürmesi nedeniyle volan dişlisi değişimi pahalı bir işlemdir. Aynı zamanda hassasiyet gerektiren bir işlem olduğundan, sadece yetkili servislerde ve güvenilir noktalarda gerçekleştirilmesi önerilir."
                )
            )
        ),
        InformationCards(
            id = 33,
            lessonName = "Yaralanmalarda İlk Yardım",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Bir travma sonucu deri yada mukozanın bütünlüğünün bozulmasıdır. Aynı zamanda kan damarları, adale ve sinir gibi yapılar etkilenebilir. Derinin koruma özelliği bozulacağından enfeksiyon riski artar."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Kaç çeşit yara vardır?",
                    details = "Kesik yaralar, Ezikli yaralar, Delici yaralar, Parçalı yaralar, Enfekte yaralar."
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Kesik yaralar",
                    details = "Bıçak, çakı, cam gibi kesici aletlerle oluşur. Genellikle basit yaralardır. Derinlikleri kolay belirlenir."
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Ezikli yaralar",
                    details = "Taş, yumruk ya da sopa gibi etkenlerin şiddetli olarak çarpması ile oluşan yaralardır. Yara kenarları eziktir. Çok fazla kanama olmaz, ancak doku zedelenmesi ve hassasiyet vardır."
                ),
                InformationCardsInfo(
                    id = 5,
                    description = "Delici yaralar",
                    details = "Uzun ve sivri aletlerle oluşan yaralardır. Yüzey üzerinde derinlik hakimdir. Aldatıcı olabilir tetanos tehlikesi vardır."
                ),
                InformationCardsInfo(
                    id = 6,
                    description = "Parçalı yaralar",
                    details = "Dokular üzerinde bir çekme etkisi ile meydana gelir. Doku ile ilgili tüm organ, saçlı deride zarar görebilir."
                ),
                InformationCardsInfo(
                    id = 7,
                    description = "Enfekte yaralar",
                    details = "Mikrop kapma ihtimali olan yaralardır. Enfeksiyon riski yüksek yaralar şunlardır: Gecikmiş yaralar (6 saatten fazla), Dikişleri ayrılmış yaralar, Kenarları muntazam olmayan yaralar, Çok kirli ve derin yaralar, Ateşli silah yaraları, Isırma ve sokma ile oluşan yaralar."
                ),
                InformationCardsInfo(
                    id = 8,
                    description = "Yaraların ortak belirtileri nelerdir?",
                    details = "Ağrı, Kanama, Yara kenarının ayrılması."
                ),
                InformationCardsInfo(
                    id = 9,
                    description = "Yaralanmalarda ilk yardım nasıl olmalıdır?",
                    details = "Yaşam bulguları değerlendirilir (ABC), Yara yeri değerlendirilir: Oluş şekli, Süresi, Yabancı cisim varlığı, Kanama vb. Kanama durdurulur, Üzeri kapatılır, Sağlık kuruluşuna gitmesi sağlanır, Tetanos konusunda uyarıda bulunulur, Yaradaki yabancı cisimlere dokunulmamalıdır! Yara eğer kirli ise toz veya toprak benzeri bir şeyler varsa 5 dakika süreyle yara yıkanmalıdır."
                ),
                InformationCardsInfo(
                    id = 10,
                    description = "Ciddi yaralanmalar nelerdir?",
                    details = "Kenarları birleşmeyen veya 2-3 cm olan yaralar, Kanaması durdurulamayan yaralar, Kas veya kemiğin göründüğü yaralar, Delici aletlerle oluşan yaralar, Yabancı cisim saplanmış olan yaralar, İnsan veya hayvan ısırıkları, Görünürde iz bırakma ihtimali olan yaralar."
                ),
                InformationCardsInfo(
                    id = 11,
                    description = "Ciddi yaralanmalarda ilk yardım",
                    details = "Yaraya saplanan yabancı cisimler çıkarılmaz, Yarada kanama varsa durdurulur, Yara içi kurcalanmamalıdır, Yara temiz bir bezle örtülür (nemli bir bez), Yara üzerine bandaj uygulanır, Tıbbi yardım istenir (112)."
                ),
                InformationCardsInfo(
                    id = 12,
                    description = "Delici göğüs yaralanmalarında ne gibi sorunlar görülebilir?",
                    details = "Göğsün içine giren cisim, akciğer zarı ve akciğeri yaralar. Bunun sonucunda şu belirtiler görülebilir: Yoğun ağrı, Solunum zorluğu, Morarma, Kan tükürme, Açık pnömotoraks (Göğüsteki yarada nefes alıyor görüntüsü)."
                ),
                InformationCardsInfo(
                    id = 13,
                    description = "Delici göğüs yaralanmalarında ilk yardım",
                    details = "Hasta/yaralının bilinç kontrolü yapılır, Hasta/yaralının yaşam bulguları değerlendirilir (ABC), Yara üzerine plastik poşet naylon vb. sarılmış bir bezle kapatılır, Nefes alma sırasında yaraya hava girmesini engellemek, nefes verme sırasında havanın dışarı çıkmasını sağlamak için yara üzerine konan bezin bir ucu açık bırakılır, Hasta/yaralı bilinci açık ise yarı oturur pozisyonda oturtulur, Ağızdan hiçbir şey verilmez, Yaşam bulguları sık sık kontrol edilir, Açık pnömotoraksta şok ihtimali çok yüksektir. Bu nedenle şok önlemleri alınmalıdır, Tıbbi yardım istenir (112)."
                ),
                InformationCardsInfo(
                    id = 14,
                    description = "Delici karın yaralanmalarında ne gibi sorunlar olabilir?",
                    details = "Karın bölgesindeki organlar zarar görebilir, İç ve dış kanama ve buna bağlı şok oluşabilir, Karın tahta gibi sert ve çok ağrılı ise durum ciddidir, Bağırsaklar dışarı çıkabilir."
                ),
                InformationCardsInfo(
                    id = 15,
                    description = "Delici karın yaralanmalarında ilk yardım",
                    details = "Hasta/yaralının bilinç kontrolü yapılır, Hasta/yaralının yaşam bulguları kontrol edilir, Dışarı çıkan organlar içeri sokulmaya çalışılmaz, üzerine geniş ve nemli temiz bir bez örtülür, Bilinç yerinde ise sırt üstü pozisyonda bacaklar bükülmüş olarak yatırılır, ısı kaybını önlemek için üzeri örtülür, Şoka karşı önlem alınır, Ağızdan yiyecek ya da içecek bir şey verilmez, Yaşam bulguları sık sık izlenir, Tıbbi yardım istenir (112)."
                ),
                InformationCardsInfo(
                    id = 16,
                    description = "Kafatası ve omurga yaralanmaları neden önemlidir?",
                    details = "Darbenin şiddetine bağlı olarak kafatası boşluğunda yer alan merkezi sinir sistemi etkilenebilir. Bel kemiğindeki yaralanmalarda omurgada ani sıkışma ya da ayrılma meydana gelebilir. Bunun sonucunda sinir sistemi etkilenerek bazı olumsuz sonuçlar oluşabilir. Trafik kazalarında ölümlerin % 80’i kafatası ve omurga yaralanmalarından olmaktadır."
                ),
                InformationCardsInfo(
                    id = 17,
                    description = "Kafatası yaralanmaları çeşitleri nelerdir?",
                    details = "Saçlı deride yaralanmalar: Saç derisi kafatası yüzeyi üzerinde kolaylıkla yer değiştirebilir ve herhangi bir darbe sonucu kolayca ayrılabilir. Bu durumda çok fazla miktarda kanama olur, bu nedenle öncelikle kanamanın durdurulması gereklidir. Kafatası kırıkları: Kafatası kırıklarında beyin zedelenmesi, kemiğin kırılmasından daha önemlidir. Bu nedenle beyin hasarı bulguları değerlendirilmelidir. Yüz yaralanmaları: Ağız ve burun yaralanmalarında solunum ciddi şekilde etkilenebilir ve duyu organları zarar görebilir. Bir yüz yaralanması sonucunda burun, çene kemiği kemiklerinde yaralanma görülebilir. Omurga (bel kemiği) yaralanmaları: En çok zarar gören bölge bel ve boyun bölgesidir ve çok ağrılıdır. Kazalarda en çok boyun etkilenir."
                ),
                InformationCardsInfo(
                    id = 18,
                    description = "Kafatası yaralanmalarında ilk yardım",
                    details = "Hasta/yaralının bilinç kontrolü yapılır, Hasta/yaralının yaşam bulguları değerlendirilir (ABC), Kafatası yaralanmasında öncelikle kanamanın durdurulması gerekir, Kanama varsa temiz bir bezle kanama bölgesine basınç yapılır, Kanama durmazsa hasta/yaralı başı daha yüksek bir pozisyona getirilir, Kafatasında açık bir yaradan beyin akıntısı geliyorsa temiz bir bezle kapatılır, Şoka karşı önlem alınır, Ağızdan herhangi bir şey verilmez, Tıbbi yardım istenir (112)."
                )
            )
        ),
        InformationCards(
            id = 35,
            lessonName = "Yol Çizgileri",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Kesik yol çizgileri",
                    details = "Trafik kurallarına uymak şartıyla sürücülerin, yol ve trafik durumuna uygun olduğunda, öndeki araçları geçmek için şerit değiştirebileceğini gösterir."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Devamlı ve kesik yol çizgileri",
                    details = "Yanyana çizilmiş devamlı ve kesik yol çizgilerinin bulunduğu yerlerde sürücüler, manevra başlangıcında kendilerine en yakın olan çizginin anlamına göre davranırlar."
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Yanyana iki devamlı çizgi",
                    details = "Bu çizgi, yolu bölünmüş yol durumuna getirdiğinden, bu çizgi boyunca karşı yönün kullandığı şeritlere girilmez."
                )
            )
        ),
        InformationCards(
            id = 36,
            lessonName = "Temel Yaşam Desteği",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Solunum durması",
                    details = "Solunum hareketlerinin durması nedeniyle vücudun yaşamak için ihtiyacı olan oksijenden yoksun kalmasıdır. Hemen yapay solunuma başlanmazsa bir süre sonra kalp durması meydana gelir."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Kalp durması",
                    details = "Bilinci kapalı kişide büyük arterlerden nabız alınamaması durumudur. Kalp durmasına 5 dakika içinde müdahale edilmezse dokuların oksijenlenmesi bozulacağı için beyin hasarı oluşur."
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Temel Yaşam Desteği nedir?",
                    details = "Hayat kurtarmak amacıyla hava yolu açıklığı sağlandıktan sonra, solunumu ve/veya kalbi durmuş kişiye yapay solunum ile akciğerlerine oksijen gitmesini, dış kalp masajı ile de kalpten kan pompalanmasını sağlamak üzere yapılan ilaçsız müdahalelerdir."
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Hava yolunu açmak için Bas-Çene pozisyonu nasıl verilir?",
                    details = "Bilinci kapalı bütün hasta/yaralılarda solunum yolu kontrol edilmelidir. Dil geriye kayabilir ya da herhangi bir yabancı madde solunum yolunu tıkayabilir. Ağız içi kontrol edilerek temizlendikten sonra hastaya Bas-Çene pozisyonu verilir.\n" +
                        "Bunun için ;\n" +
                        "1. Bir el alına yerleştirilir,\n" +
                        "2. Diğer elin iki parmağı çeneye yerleştirilir,\n" +
                        "3. Baş geriye doğru itilerek hava yolu açıklığı sağlanır."
                ),
                InformationCardsInfo(
                    id = 5,
                    description = "Yapay solunum nasıl yapılır?",
                    details = "Hasta/yaralının hava yolu açıldıktan sonra, solunum Bak-Dinle-Hisset yöntemi ile değerlendirilir. Solunum yoksa tıbbi yardım istenir (112). Hemen yapay solunuma başlanır. Yapay solunuma başlamadan önce solunumun olmadığından kesinlikle emin olunmalıdır.\n" +
                        "Ağızdan ağıza teknik için hasta/yaralıya Bas-Çene pozisyonu verilir.\n" +
                        "1. Bir elin baş ve işaret parmakları ile burun kanatları hava çıkmayacak şekilde kapatılır,\n" +
                        "2. İlkyardımcı, hasta/yaralının ağzını hava çıkmayacak şekilde kendi ağzı ile kavrar,\n" +
                        "3. Hasta akciğerine 400-600 ml hava gidecek şekilde ağızdan iki kez üflenir,\n" +
                        "4. Şah damarı üzerinden 5 saniye süre ile nabız kontrolü yapılır. Nabız varsa dakikada 15-20 kez olacak şekilde yapay solunuma devam edilir. 1 yaşın altındaki bebeklerde 20-25 kez olacak şekilde hava verilir. (Eğer nabız alınamıyorsa suni solunum ile birlikte kalp masajına da başlanır),\n" +
                        "5. Bu şekilde verilen hava hayati organları koruyacak yeterli oksijene (%16-18) sahiptir,\n" +
                        "6. Bebeklerde ve çene kilitlenmesi gibi durumlarda yetişkinlerde, yapay solunum ağızdan buruna hava verilerek yapılmalıdır,\n" +
                        "7. Yapay solunumun etkili olup olmadığı Bak-Dinle-Hisset yöntemi ile her 10 üflemede bir kontrol edilmelidir,\n" +
                        "8. Nabız olup olmadığı şah damarı üzerinden kontrol edilmelidir,\n" +
                        "9. İlkyardımcı kendini korumak için yapay solunum sırasında ince bir tülbent, gazlı bez gibi araçlar kullanabilir."
                ),
                InformationCardsInfo(
                    id = 6,
                    description = "Dış kalp masajı nasıl yapılır?",
                    details = "Yapay solunum sırasında şah damarı üzerinden 5 saniye süre ile nabız kontrolü yapılır, nabız yoksa dış kalp masajına başlanır. Kalp masajına başlamadan önce kalbin tamamen durduğundan kesinlikle emin olunmalıdır.\n" +
                        "1. Temel yaşam desteğine başlarken eğer çevrede biri varsa hemen 112 aranmalıdır. Boğulma ve travmalarda ilkyardımcı yalnız ise 1 siklüsden sonra kendisi yardım çağırmalıdır. Bebek ve çocuklarda, ilk önce iki solunum yapılır, ardından 112 aranır.\n" +
                        "2. Alttaki kaburgalar elle tespit edilir, eller kaydırılarak göğüs kemiğinin alt ucu belirlenir.\n" +
                        "3. Her iki kaburganın birleştiği noktaya (sternum ucu) iki parmak konur ve üstüne diğer el topu yerleştirilerek bası noktası tespit edilir. Bu elin üzerine diğer el yerleştirilir.\n" +
                        "4. Her iki el parmakları birbirine geçirilir ve hastaya temas etmemesine dikkat edilir. Eller sabit tutulmalıdır. Dirsekler ve omuz düz ve hasta/yaralının vücuduna dik tutulacak şekilde tutulmalıdır.\n" +
                        "5. Vücut ağırlığı ile kaburga kemikleri 4-5 cm içe çökecek şekilde (yandan bakıldığında göğüs yüksekliğinin 1/3’ü kadar) ritmik olarak sıkıştırma-gevşetme şeklinde bası uygulanır. Yetişkinlerde dakikada 100 bası uygulanmalıdır.\n" +
                        "6. Dış kalp masajı 1 yaşın altındaki bebeklerde göğüs kemiği alt ucuna iki parmakla, göğüs kemiği 1-1,5 cm içe çökecek şekilde dakikada 100 bası olarak yapılır. 1-8 yaşına kadar çocuklarda tek elle 2.5-5 cm çökecek şekilde yapılmalıdır (yandan bakıldığında göğüs yüksekliğinin 1/3’ü kadar).\n" +
                        "7. Yapay solunum ve dış kalp masajı birlikte uygulandığında, yetişkinlerde tek ya da iki ilkyardımcı ya da iki ilkyardımcı ile 15/2 olarak uygulanır. (Bebek ve 1-8 yaş çocuklarda ise 5/1 olarak uygulanır.)\n" +
                        "8. Her siklusta hasta/yaralının solunumu ve şah damarı üzerinden nabzı 5 saniye süre ile kontrol edilmelidir (1 siklus: 15 kalp masajı ve 2 yapay solunum uygulamasının 4 kez tekrarlanmasıdır).\n" +
                        "9. Temel yaşam desteğine bu konuda eğitim almış bir sağlık personeli gelinceye kadar devam edilmelidir."
                ),
                InformationCardsInfo(
                    id = 7,
                    description = "Çocuklarda (1-8 yaş) Temel Yaşam Desteği nasıl yapılır?",
                    details = "1. Çocuğun hava yolu açıldıktan sonra, solunum Bak-Dinle-Hisset yöntemi ile değerlendirilir,\n" +
                        "2. Solunum yoksa tıbbi yardım istenir (112),\n" +
                        "3. Çocuğa önce Bas-Çene pozisyonu verilir,\n" +
                        "4. Hemen yapay solunuma başlanır. Yapay solunuma başlamadan önce solunumun olmadığından kesinlikle emin olunmalıdır!\n" +
                        "5. Yapay solunum ağızdan ağıza ya da ağızdan ağıza ve buruna tekniği ile çocuğun yaşı ve yüzünün büyüklüğüne göre gerçekleştirilir,\n" +
                        "6. Yapay solunuma iki kez hava üflenerek başlanır ve tıbbi yardım istenir (112),\n" +
                        "7. Yapay solunum dakikada 15-20 olacak şekilde yapılır,\n" +
                        "8. Nabız kontrolü yetişkinlerdeki gibidir (şah damarı üzerinden 5 saniye süreyle kontrol edilir),\n" +
                        "9. Nabızın alınamadığından yani kalbin atmadığından kesin olarak emin olduktan sonra kalp masajına başlanmalıdır!\n" +
                        "10. Kalp masajı tek elle basılarak yapılır,\n" +
                        "11. Kalp masajı dakikada 100 bası olacak şekilde uygulanır,\n" +
                        "12. Yapay solunum ve kalp masajı birlikte uygulanır (5/1) oranında, her siklusta hasta/yaralının solunumu ve şah damarı üzerinden nabzı 5 saniye süre ile kontrol edilmelidir."
                ),
                InformationCardsInfo(
                    id = 8,
                    description = "Temel Yaşam Desteği sırasında ilkyardımcı kendini nasıl korur?",
                    details = "1. Eldiven, maske, gözlük gibi koruyucu ekipman kullanmalıdır,\n" +
                        "2. Hastanın vücut sıvıları ile temasından korunmalıdır,\n" +
                        "3. Sıkı ve koruyucu kıyafetler giymelidir.\n" +
                        "4. Sadece açık hava alanlarında yapay solunum yapılmalı, hasta/yaralının solunum yolunda yabancı madde olup olmadığı kontrol edilmelidir."
                ),
                InformationCardsInfo(
                    id = 9,
                    description = "Yapay solunum ve dış kalp masajı uygulamaları hangi durumlarda yapılır?",
                    details = "1. Bilinç kapalı ise,\n" +
                        "2. Solunum yoksa,\n" +
                        "3. Nabız alınamıyorsa yapılmalıdır.\n" +
                        "Yapay solunum ve dış kalp masajı uygulamaları bilinçli, solunumu olan ve nabzı olan kişilere yapılmamalıdır."
                ),
                InformationCardsInfo(
                    id = 10,
                    description = "Yapay solunum ve dış kalp masajı yaparken dikkat edilmesi gerekenler",
                    details = "1. Solunumun yokluğundan ve kalbin tamamen durduğundan emin olunmalıdır,\n" +
                        "2. Çevre güvenliğinin sağlandığından emin olunmalıdır,\n" +
                        "3. Temel yaşam desteği doğru yapılmalıdır,\n" +
                        "4. İki solunum ve 15 dış kalp masajı 4 kez tekrarlanarak 1 siklus yapılmalıdır,\n" +
                        "5. Solunum ve nabız durumu her siklusta 5 saniye süre ile kontrol edilmelidir,\n" +
                        "6. Temel yaşam desteğine sağlık personeli gelinceye kadar devam edilmelidir."
                )
            )
        ),
        InformationCards(
            id = 37, "Kanamalarda İlk Yardım",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Kanama, damar bütünlüğünün bozulması sonucu kanın damar dışına doğru akmasıdır.",
                    details = "Kanamanın ciddiyeti, kanamanın hızı, vücutta kanın aktığı bölge, kanama miktarı ve kişinin fiziksel durumu ve yaşı gibi faktörlere bağlıdır."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Dış Kanamalar",
                    details = "Kanama yaradan vücut dışına doğru olur."
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "İç Kanamalar",
                    details = "Kanama vücut içine olduğu için gözle görülemez."
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Doğal Deliklerden Olan Kanamalar",
                    details = "Kulak, burun, ağız, anüs, üreme organlarından olan kanamalardır."
                ),
                InformationCardsInfo(
                    id = 5,
                    description = "Damar Tipine Göre Kanama Türleri",
                    details = """
                - Arter Kanaması (Atardamar): Kalp atımları ile uyumlu olarak kesik kesik akar ve açık renklidir.
                - Ven Kanaması (Toplardamar): Koyu renkli ve sızıntı şeklindedir.
                - Kılcal Damar Kanaması: Küçük kabarcıklar şeklindedir.
            """
                ),
                InformationCardsInfo(
                    id = 6,
                    description = "Baskı Uygulanacak Noktalar",
                    details = """
                - Boyun: Şah damarı baskı yeri
                - Köprücük Kemiği Üzeri: Kol atardamarı baskı yeri
                - Koltukaltı: Kol atardamarı baskı yeri
                - Kolun Üst Bölümü: Kol atardamarı baskı yeri
                - Kasık: Bacak atardamarı baskı yeri
                - Uyluk: Bacak atardamarı baskı yeri
            """
                ),
                InformationCardsInfo(
                    id = 7,
                    description = "Dış Kanamalarda İlkyardım",
                    details = """
                1. İlkyardımcı kendini tanıtır ve hasta yaralı sakinleştirilir.
                2. Hasta/yaralı sırt üstü yatırılır.
                3. Durum değerlendirilir (ABC).
                4. Tıbbi yardım istenir (112).
                5. Yara veya kanama değerlendirilir.
                6. Kanayan yer üzerine temiz bir bezle bastırılır.
                7. Kanama durmazsa ikinci bir bez koyarak basıncı arttırılır.
                8. Gerekirse bandaj ile sararak basınç uygulanır.
                9. Kanayan yere en yakın basınç noktasına baskı uygulanır.
                10. Kanayan bölge yukarı kaldırılır.
                11. Tek ilkyardımcı varsa, yaralı güç koşullarda bir yere taşınacaksa ve/veya baskı noktalarına baskı uygulamak yeterli olmuyorsa boğucu sargı (turnike) uygulanır.
                12. Kanayan bölge dışarıda kalacak şekilde hasta/yaralının üstü örtülür.
                13. Şok pozisyonu verilir.
                14. Yapılan uygulamalar ile ilgili bilgiler (boğucu sargı uygulaması gibi) hasta/yaralının üzerine yazılır.
                15. Yaşam bulguları sık aralıklarla (2-3 dakikada bir) değerlendirilir.
                16. Hızla sevk edilmesi sağlanır.
            """
                ),
                InformationCardsInfo(
                    id = 8,
                    description = "İç Kanamalarda İlkyardım",
                    details = """
                1. Hasta/yaralının bilinci ve ABC’si değerlendirilir.
                2. Tıbbi yardım istenir (112).
                3. Üzeri örtülerek ayakları 30 cm yukarı kaldırılır.
                4. Asla yiyecek ve içecek verilmez.
                5. Hareket ettirilmez (özellikle kırık varsa).
                6. Yaşamsal bulguları incelenir.
                7. Sağlık kuruluşuna sevk sağlanır.
            """
                ),
                InformationCardsInfo(
                    id = 9,
                    description = "Boğucu Sargı (Turnike) Uygulanması Gereken Durumlar",
                    details = """
                1. Çok sayıda yaralının bulunduğu bir ortamda tek ilkyardımcı varsa.
                2. Yaralı güç koşullarda bir yere taşınacaksa.
                3. Uzuv kopması varsa.
                4. Baskı noktalarına baskı uygulamak yeterli olmuyorsa.
            """
                ),
                InformationCardsInfo(
                    id = 10,
                    description = "Boğucu Sargı (Turnike) Uygulamasında Dikkat Edilecek Hususlar",
                    details = """
                1. Kullanılacak malzemelerin genişliği en az 8–10 cm olmalı.
                2. İp, tel gibi kesici malzemeler kullanılmamalı.
                3. Sıkmak için tahta parçası, kalem gibi malzemeler kullanılabilir.
                4. Kanama duruncaya kadar sıkılır, kanama durduktan sonra daha fazla sıkılmaz.
                5. Üzerine hiçbir şey örtülmez.
                6. Uygulama saati bir kağıda yazılmalı ve yaralının üzerine asılmalı.
                7. Uzun süreli kanamalarda 15-20 dakikada bir gevşetilmeli.
                8. Kol ve uyluk gibi tek kemikli bölgelere uygulanır; önkol ve bacağa uygulanmamalıdır.
            """
                ),
                InformationCardsInfo(
                    id = 11,
                    description = "Boğucu Sargı (Turnike) Uygulama Tekniği",
                    details = """
                1. Geniş, kuvvetli ve esnemeyen bir sargı alınır.
                2. Şerit yarı uzunluğunda katlanır, uzuv etrafına sarılır.
                3. Bir ucu halkadan geçirip çekilir, iki ucu bir araya getirilir.
                4. Kanamayı durduracak yeterlikte sıkı bir bağ atılır.
                   - Sargının içinden sert cisim (kalem gibi) geçirilir ve uzva paralel konuma getirilir.
                   - Kanama durana kadar sert cisim döndürülür.
                5. Sert cisim uzva dik konuma getirilerek sargı çözülmeyecek şekilde tespit edilir.
                6. Hasta/yaralının elbisesinin üzerine, adı ve turnikenin uygulandığı zaman (saat ve dakika) yazılı bir kart iğnelenir.
                7. Çok sayıda yaralı olduğunda, yaralının alnına rujla veya sabit kalemle “turnike” veya “T” harfi yazılır.
                8. Hasta/yaralının üstü örtülür ve battaniye ile sarılır.
                9. Turnike 15-20 dakika aralıklarla gevşetilir, sonra tekrar sıkılır.
            """
                ),
                InformationCardsInfo(
                    id = 12,
                    description = "Uzuv Kopması Durumunda",
                    details = """
                1. Kopan parça temiz su geçirmez ağzı kapalı bir plastik torbaya yerleştirilir.
                2. Torba buz içeren ikinci bir torbanın içine konur.
                3. Torba, 1 ölçek suya 2 ölçek buz konulmuş ikinci bir torbaya ya da kovaya konulur.
                4. Torba hasta/yaralı ile aynı vasıtaya konur, üzerine hastanın adı ve soyadı yazılır, en geç 6 saat içinde sağlık kuruluşuna sevk edilir.
                5. Tıbbi birimler haberdar edilir (112).
            """
                ),
                InformationCardsInfo(
                    id = 13,
                    description = "Şok Nedir?",
                    details = "Şok, kalp-damar sisteminin yaşamsal organlara uygun oranda kanlanma yapamaması nedeniyle ortaya çıkan ve tansiyon düşüklüğü ile seyreden bir akut dolaşım yetmezliğidir."
                ),
                InformationCardsInfo(
                    id = 14,
                    description = "Şok Türleri",
                    details = """
                1. Kardiyojenik Şok (Kalp kökenli)
                2. Hipovolemik Şok (Sıvı eksikliği)
                3. Toksik Şok (Zehirlenme ile ilgili)
                4. Anaflaktik Şok (Alerjik)
            """
                ),
                InformationCardsInfo(
                    id = 15,
                    description = "Şok Belirtileri",
                    details = """
                1. Bilinç kaybı veya kafa karışıklığı
                2. Yüzde solukluk
                3. Hızlı kalp atışı
                4. Düşük tansiyon
                5. Hızlı, yüzeysel nefes
                6. Soğuk, nemli ve solgun cilt
            """
                ),
                InformationCardsInfo(
                    id = 16,
                    description = "Şokta İlkyardım",
                    details = """
                1. Bilinci kontrol edilir ve varsa yardım istenir.
                2. Hasta/yaralı sırt üstü yatırılır ve ayakları 30 cm yukarı kaldırılır.
                3. Gerekirse yapay solunum yapılır.
                4. Sıcak tutulur (battaniye ile).
                5. Yapay solunum, kalp masajı yapılırsa 112 çağrılır.
                6. Hasta/yaralının üstü örtülür.
            """
                ),
                InformationCardsInfo(
                    id = 17,
                    description = "Doğal Deliklerden Kanama İlkyardımı",
                    details = """
                - **Kulaktan Kanama:**
                  1. Hasta/yaralı sakinleştirilir.
                  2. Baş pozisyonu değiştirilir, kanamanın engellenmesi sağlanır.
                  3. Kulak temizlenir.
                  4. 112 aranır, sağlık kuruluşuna başvurulması sağlanır.

                - **Ağızdan Kanama:**
                  1. Hasta/yaralı sakinleştirilir.
                  2. Ağız temizlenir.
                  3. Kanama durdurulacak şekilde tedavi sağlanır.
                  4. Hasta/yaralının başı öne eğilir, boğulma riski azaltılır.
                  5. Sağlık kuruluşuna sevk sağlanır.

                - **Anüs ve Üreme Organlarından Kanama:**
                  1. Kanama varsa hasta/yaralı rahatlatılır.
                  2. Kanama bölgesi temizlenir.
                  3. Sağlık kuruluşuna başvurulması sağlanır.
            """
                ),
                InformationCardsInfo(
                    id = 18,
                    description = "Yaraların Türlerine Göre İlkyardım",
                    details = """
                - **Kesik Yaralar:** Deri ve altındaki doku tabakalarının kesilmesiyle oluşur. Kanama yoğun olabilir.
                - **Sıyrıklar:** Cildin üst tabakasının kazınmasıyla oluşur. Kanama genellikle azdır.
                - **Delici Yaralar:** Derin bir şekilde iç organlara ulaşma riski taşır. Kanama ve enfeksiyon riski yüksektir.
                - **Yaralanmalar:** Çeşitli şekillerde cilt ve altındaki dokuların hasar görmesidir. İlkyardım hemen uygulanmalıdır.
            """
                )
            )
        ),
        InformationCards(
            id = 38,
            lessonName = "Yaralı Taşıma Teknikleri",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Hasta/yaralı taşınmasında ilkyardımcı kendi sağlığını riske sokmamalıdır.",
                    details = "Gereksiz zorlama ve yaralanmalara engel olmak için çeşitli kurallar uygulanmalıdır."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Hasta/yaralı taşınırken aşağıdaki kurallara uyulmalıdır:",
                    details = """
                - Hasta/yaralıya yakın mesafede çalışılmalı.
                - Daha uzun ve kuvvetli kas grupları kullanılmalı.
                - Sırtın gerginliğini korumak için dizler ve kalçalar bükülmeli.
                - Yerden destek alacak şekilde her iki ayağı da kullanarak biri diğerinden biraz öne yerleştirilmeli.
                - Kalkarken ağırlığı kalça kaslarına vererek dizler en uygun biçimde doğrultulmalı.
                - Baş her zaman düz tutulmalı ve homojen bir şekilde hareket ettirilmeli.
                - Yavaş ve düzgün adımlarla yürünmeli ve adımlar omuzdan daha geniş olmamalı.
                - Ağırlık kaldırırken karın muntazam tutulup kalça kasılmalı.
                - Omuzlar leğen kemiğinin ve omuriliğin hizasında tutulmalı.
                - Yön değiştirirken ani dönme ve bükülmelerden kaçınılmalı.
                - Hasta/yaralı mümkün olduğunca az hareket ettirilmeli.
                - Hasta/yaralı baş-boyun-gövde ekseni esas alınarak en az 6 destek noktasından kavranmalı.
                - Tüm hareketleri yönlendirecek sorumlu bir kişi olmalı.
                - Mükemmel bir ekip çalışması gerekmektedir.
            """
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Acil taşıma teknikleri nelerdir?",
                    details = """
                - Hasta/yaralının yeri değiştirilmemeli ve dokunulmamalıdır.
                - Olağanüstü bir tehlike söz konusuysa, taşıma zorunludur.
                - En kısa sürede yaralılar güvenli bir yere taşınmalıdır.
            """
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Araç içindeki yaralıyı (Rentek Manevrası) taşıma",
                    details = """
                - Kaza ortamı değerlendirilir, patlama ve yangın tehlikesi belirlenir.
                - Bilinci kontrol edilir, çevrede biri varsa 112 aratılır.
                - Solunum yapıp yapmadığı gözlemlenir.
                - Ayakların pedala sıkışmadığından emin olunur.
                - Omuzlardan ve çeneden kavranarak baş-boyun-gövde hizası korunur.
                - Yavaşça yere veya sedyeye yerleştirilir.
            """
                ),
                InformationCardsInfo(
                    id = 5,
                    description = "Sürükleme yöntemleri",
                    details = """
                - Ayak bileklerinden sürükleme.
                - Koltuk altından tutarak sürükleme.
            """
                ),
                InformationCardsInfo(
                    id = 6,
                    description = "Kısa mesafede süratli taşıma teknikleri",
                    details = """
                - Kucakta taşıma: Bilinci açık olan çocuklar ve hafif yetişkinler için.
                - İlkyardımcının omzundan destek alma: Hafif yaralı ve yürüyebilecek durumdaki kişiler için.
                - Sırtta taşıma: Bilinçli hastaları taşımada.
                - Omuzda taşıma (İtfaiyeci yöntemi): Yürüyemeyen ya da bilinci kapalı kişiler için.
                - İki ilkyardımcı ile ellerin üzerinde taşıma (Altın Beşik Yöntemi): Yaralının ciddi bir yaralanması yoksa.
                - İki kişinin birbiriyle birleşmesi (Sandviç Yöntemi): Yaralı yere dikkatlice indirilir ve iki kişi tarafından taşınır.
                - Tek başına vücut desteği (Meksika Yöntemi): Tek başına taşıma yöntemleri.
                - Taşıma Öne/Arkaya: İki ilkyardımcı tarafından gerçekleştirilir.
                - İki ilkyardımcı ile sürükleme: Daha geniş alanlarda taşınabilir.
                - Kol ve bacakların desteklenmesi: Tek ilkyardımcı tarafından kullanılan etkili bir yöntemdir.
            """
                ),
                InformationCardsInfo(
                    id = 7,
                    description = "Yaralı taşıma tekniklerinin temel kriterleri",
                    details = """
                - Güvenlik: İlkyardımcı kendi sağlığını korumalı.
                - Sağlamlık: Taşıma yöntemleri seçilirken yaralının durumu göz önünde bulundurulmalı.
                - Dikkat: Yaraların ve kırıkların olduğu bölgeler korunmalı.
                - Destek: Ekip desteği sağlanmalı.
                - Teknik: En uygun ve etkili taşıma yöntemi seçilmeli.
            """
                )
            )
        ),
        InformationCards(
            id = 39,
            lessonName = "Sollama",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Önde giden aracı geçerken dikkat edilmesi gereken kurallar",
                    details = """
                1. Arkasından gelen başka bir sürücünün geçmeye başlamadığından emin olunmalıdır.
                2. Önündeki sürücünün geçme niyetini belirten işaret vermemiş olmasına dikkat edilmelidir.
                3. Geçeceğiniz aracın hızını ve geçiş esnasındaki hızınızı dikkate alarak, karşıdan gelen trafiği de göz önünde bulundurarak geçiş şeridinin yeterince boş ve görüşe açık olduğundan emin olunmalıdır.
                4. Geçişin geçilen araçlar için güçlük yaratmaması sağlanmalı ve araçlar geçişe uygun durumda olmalıdır.
            """
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Öndeki aracı geçmenin yasak olduğu yerler",
                    details = """
                1. Geçmenin trafik işaretiyle yasaklandığı yerlerde.
                2. Köprülerde, tünellerde, kavşaklarda, demiryolu geçitlerinde, tepe üstü ve virajlarda görüşün yetersiz olduğu yerlerde.
            """
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Sağa dönüş kuralları",
                    details = """
                1. Dönüş işareti verilmelidir.
                2. Sağ şeride veya işaretle dönüş izni verilen şeride girilmelidir.
                3. Hız azaltılmalıdır.
                4. Dar bir kavisle dönüş yapılmalıdır.
            """
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Sola dönüş kuralları",
                    details = """
                1. Dönüş işareti verilmelidir.
                2. Yolun sol kısmına yanaşılmalıdır.
                3. Hız azaltılmalıdır.
                4. Dönüş başlamadan, varsa sağdan gelen taşıtlara geçiş hakkı verilmelidir.
                5. Dönüş sırasında, karşıdan gelen ve emniyetle duramayacak kadar kavşağa olan araçların geçmesi beklenmelidir.
                6. Gireceğiniz yolun gidişe ayrılan kısmına girmek üzere, arkadan gelen ve sola dönecek diğer taşıtları engellememek için dönüş geniş kavisle yapılmalıdır.
                7. Dönüş sırasında ilk geçiş hakkı, kurallara uygun olarak karşıya geçen yayalara ve bisiklet yolundaki bisikletçilere verilmelidir.
            """
                ),
                InformationCardsInfo(
                    id = 5,
                    description = "Geri gitme ve manevra kuralları",
                    details = """
                1. Bağlantı yollarında geri gitmek yasaktır.
                2. Tek yönlü yollarda, duraklama veya park manevrası dışında geri gitmek yasaktır.
                3. İki aracın emniyetle geçemeyeceği kadar dar iki yönlü yol kesimlerinde geri gitmek yasaktır.
                4. Daha geniş yollarda geriye giderken manevra dışında şerit değiştirmek yasaktır.
                5. Trafiği yoğun olan yollarda geriye dönmek yasaktır.
            """
                ),
                InformationCardsInfo(
                    id = 6,
                    description = "Kavşaklarda geçiş hakkı kuralları",
                    details = """
                Trafik polisi, ışıklı trafik işaret cihazları veya trafik işaret levhaları bulunmayan kavşaklarda:
                1. Bütün araçlar geçiş üstünlüğüne sahip araçlara öncelik verir.
                2. Doğru geçmekte olan tramvay hattı bulunan yoldan geçen araçlara öncelik verilir.
                3. Bölünmüş yola çıkan sürücüler bu yoldan geçen araçlara öncelik verir.
                4. Tali yoldan çıkan sürücüler ana yoldaki sürücülere öncelik verir.
                5. Dönel kavşak dışındaki sürücüler, dönel kavşak içindeki araçlara öncelik verir.
                6. Bir iz veya mülkten karayoluna çıkan sürücüler, karayolundaki araçlara ilk geçiş hakkını vermek zorundadır.
            """
                )
            )
        ),
        InformationCards(
            id = 40,
            lessonName = "Silindir kapağı",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Silindir kapağı nedir?",
                    details = "Silindir kapağı, motor bloğunun üst kısmını kapatarak yanma odasını oluşturan ve motorun hareketli parçalarına yataklık eden bir parçadır. Üst kapak diye de bilinir. Kaputu açtığınızda gördüğünüz külbütör kapağının hemen altında bulunur."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Silindir kapağı üzerinde bulunan parçalar",
                    details = "Silindir kapağı üzerinde bulunan parçalar şunlardır:\n- Emme ve egzoz manifoldu\n- Emme ve egzoz kanalı\n- Eksantirik Mil\n- Buji ve enjektör yuvaları\n- Subap yuvaları\n- Subap kılavuzu\n- Subap yayları\n- Su kanalları\n- Yanma odaları"
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Silindir kapağı çatlaması",
                    details = "Genellikle kış aylarında görülen bu arıza, motordaki suyun donmasından kaynaklanır. Su donduğunda genleşir ve silindir kapağının çatlamasına neden olur. Ayrıca, motor çok sıcakken radyatöre soğuk su ilave edilmesi de bu arızayı tetikleyebilir. Önlem olarak motora antifriz ilave edilmelidir."
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Yanma odalarının kurum bağlaması",
                    details = "Yanma odalarında sürekli patlama işlemi gerçekleştiği için zamanla kurum (is) bağlanabilir. Bu durum, yanma odalarının hacmini azaltır ve motorun torkunun düşmesine, parçaların ömrünün kısalmasına neden olur. Kurum bağlamış yanma odaları mutlaka temizlenmelidir."
                ),
                InformationCardsInfo(
                    id = 5,
                    description = "Silindir kapak contasının yanması",
                    details = "Hararet yapıldığında ilk olarak silindir kapak contası yanar. Bu conta, silindir kapağı ile motor bloğu arasındaki sızdırmazlığı sağlar. Conta yandığında sızdırmazlık sağlanamaz ve yanma odasından sızma meydana gelir. Bu durum motorun diğer parçalarına zarar verebilir. Conta yandığında aracınızı hemen yetkili servise çektirin ve contayı değiştirin."
                )
            )
        ),
        InformationCards(
            id = 41,
            lessonName = "Hava filtresi",
            lessonInformationCards = listOf(
                InformationCardsInfo(
                    id = 1,
                    description = "Hava filtresi nedir?",
                    details = "Hava filtresi, motorun çalışması ve yakıtın yakılabilmesi için gerekli olan oksijeni sağlayan bir parçadır. Motor sistemleri dışarıdaki havayı temizleyip silindire alabilmek için hava filtresine ihtiyaç duyar."
                ),
                InformationCardsInfo(
                    id = 2,
                    description = "Hava filtresi ne işe yarar?",
                    details = "Hava filtresi, motor dışındaki havayı temizleyip bujilerin kıvılcım atacağı mekanizmanın içerisine alır ve içerideki havayı dışarı atar. Hava filtresi, motorun çekiş gücü üzerinde de etkilidir. Yetersiz hava filtresi, silindirlerin randıman vermemesine ve daha fazla yakıt tüketimine neden olabilir."
                ),
                InformationCardsInfo(
                    id = 3,
                    description = "Hava filtresi arızası",
                    details = "Fiziki zarar görmüş hava filtresi doğrudan yeni bir parça ile değiştirilmelidir. Tıkanma durumunda ise hava filtresi kolayca değiştirilebilir. Kaputu açıp 4 vida ile bağlanmış filtreyi çıkararak tıkanıklığı kontrol edebilir ve temizleyebilirsiniz."
                ),
                InformationCardsInfo(
                    id = 4,
                    description = "Hava filtresinin önemi",
                    details = "Yeni nesil dizel araçlarda 1 litre yakıt tüketiminde yaklaşık 14 bin litre hava gereklidir. Bu havanın doğrudan yakıt için kullanılması motorun kısa vadede bozulmasına neden olabilir. Filtreleme sisteminin kötü olması ise zamanla silindirde arızalara yol açar. Motor aşınması ve performans düşüklüğü problemlerini engellemek için kaliteli filtreler kullanılmalıdır."
                )
            )
        )
    )
}

@Immutable
object DatabaseTestList {
    val Motor = mutableListOf(
        TestlerEntity(
            idTest = 1,
            content = "Aşağıdaki hangi araç kontrol paneli işareti doğru tanımlanmıştır?",
            imageTest = R.drawable.test,
            atest = "Arka sis lambası işareti",
            btest = "Ön sis lambası işareti",
            ctest = "Kısa far işareti",
            dtest = "Uzun far işareti",
            correct = "Arka sis lambası işareti",
        ),
        TestlerEntity(
            idTest = 2,
            content = "Araçlarda yakıt göstergesi hangi işaretle belirtilir?",
            imageTest = R.drawable.test,
            atest = "Yağ seviyesinin azaldığını gösterir",
            btest = "Yakıt seviyesinin azaldığını gösterir",
            ctest = "Fren balatalarının aşındığını gösterir",
            dtest = "Motor arızasını gösterir",
            correct = "Fren balatalarının aşındığını gösterir",
        ),
        TestlerEntity(
            idTest = 3,
            content = "Aşağıdakilerden hangisi hava filtresinin görevlerinden biridir?",
            imageTest = R.drawable.test,
            atest = "Motorun fazla ısınmasını engeller",
            btest = "Hava akışını temizler ve motorun verimliliğini artırır",
            ctest = "Yakıt sistemini temizler",
            dtest = "Fren sistemini korur",
            correct = "Fren sistemini korur",
        )
    )
}