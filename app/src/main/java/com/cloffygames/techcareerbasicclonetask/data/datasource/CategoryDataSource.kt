package com.cloffygames.techcareerbasicclonetask.data.datasource

import com.cloffygames.techcareerbasicclonetask.R
import com.cloffygames.techcareerbasicclonetask.data.entity.Category
import com.cloffygames.techcareerbasicclonetask.ui.theme.CustomAqua
import com.cloffygames.techcareerbasicclonetask.ui.theme.CustomBrown
import com.cloffygames.techcareerbasicclonetask.ui.theme.CustomGreen
import com.cloffygames.techcareerbasicclonetask.ui.theme.CustomLightBlue
import com.cloffygames.techcareerbasicclonetask.ui.theme.CustomOrange
import com.cloffygames.techcareerbasicclonetask.ui.theme.CustomPurple
import com.cloffygames.techcareerbasicclonetask.ui.theme.CustomRed
import com.cloffygames.techcareerbasicclonetask.ui.theme.CustomYellow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * CategoryDataSource sınıfı, uygulama içerisinde kullanılacak kategorileri sağlayan bir veri kaynağıdır.
 * Bu sınıf, kategori verilerini asenkron olarak sağlar ve IO işlemlerini arka planda yürütür.
 */
class CategoryDataSource {

    /**
     * Tüm kategorileri döndüren asenkron bir fonksiyon.
     * Bu fonksiyon, IO dispatcher kullanarak arka planda çalışır ve kategori listesini döndürür.
     *
     * @return List<Category> Kategorilerin bulunduğu bir listeyi döndürür.
     */
    suspend fun getAllCategories(): List<Category> = withContext(Dispatchers.IO) {
        // Kategorilerin listesi oluşturuluyor. Her bir kategori, Category veri sınıfı ile temsil ediliyor.
        val categories = listOf(
            // Category nesnesi oluşturulurken id, başlık, açıklama, ikon kaynağı ve renk belirtiliyor.
            Category(1, "Emlak", "Konut, İş Yeri, Arsa, Konut Projeleri, Bina, Devre Mülk...", R.drawable.icon_home, CustomYellow),
            Category(2, "Vasıta", "Otomobil, Arazi, SUV & Pickup, Motosiklet...", R.drawable.icon_car, CustomRed),
            Category(3, "Yedek Parça", "Otomotiv Ekipmanları, Motosiklet Ekipmanları...", R.drawable.icon_mas, CustomGreen),
            Category(4, "İkinci El ve Sıfır Alışveriş", "Bilgisayar, Cep Telefonu, Fotoğraf & Kamera...", R.drawable.icon_cart, CustomLightBlue),
            Category(5, "İş Makineleri & Sanayi", "İş Makineleri, Tarım Makineleri, Sanayi, Elektrik...", R.drawable.icon_tractor, CustomPurple),
            Category(6, "Ustalar ve Hizmetler", "Ev Tadilat & Dekorasyon, Nakliye, Araç Servis & Bakım...", R.drawable.icon_service, CustomAqua),
            Category(7, "Özel Ders Verenler", "Lise & Üniversite, İlkokul & Ortaokul, Yabancı Dil...", R.drawable.icon_education, CustomGreen),
            Category(8, "İş İlanları", "Avukatlık & Hukuki Danışmanlık, Eğitim, Eğlence & Spor...", R.drawable.icon_law, CustomBrown),
            Category(9, "Yardımcı Arayanlar", "Bebek & Çocuk Bakıcısı, Yaşlı & Hasta Bakıcısı, Temizlik...", R.drawable.icon_baby, CustomOrange),
            Category(10, "Hayvanlar Alemi", "Evcil Hayvanlar, Akvaryum Balıkları, Aksesuarlar...", R.drawable.icon_pet, CustomLightBlue)
        )
        // Kategori listesi geri döndürülüyor
        return@withContext categories
    }
}
