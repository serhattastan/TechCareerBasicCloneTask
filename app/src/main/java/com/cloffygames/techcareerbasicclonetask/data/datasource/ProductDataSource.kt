package com.cloffygames.techcareerbasicclonetask.data.datasource

import com.cloffygames.techcareerbasicclonetask.R
import com.cloffygames.techcareerbasicclonetask.data.entity.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * ProductDataSource sınıfı, uygulama içerisindeki ürün verilerini sağlayan bir veri kaynağıdır.
 * Bu sınıf, ürünleri asenkron olarak sağlar ve IO işlemlerini arka planda yürütür.
 */
class ProductDataSource {

    /**
     * Tüm ürünleri döndüren asenkron bir fonksiyon.
     * Bu fonksiyon, IO dispatcher kullanarak arka planda çalışır ve ürün listesini döndürür.
     *
     * @return List<Product> Ürünlerin bulunduğu bir listeyi döndürür.
     */
    suspend fun getAllProducts(): List<Product> = withContext(Dispatchers.IO) {
        // Ürünlerin listesi oluşturuluyor. Her bir ürün, Product veri sınıfı ile temsil ediliyor.
        val products = listOf(
            // Emlak kategorisi ürünleri
            Product(1, "Ankara Evleri 3+1", 1, 1000000.0, "Ankara Evlerinde kaçırılmayacak fırsat!!!", R.drawable.image_apartment),
            Product(2, "İstanbul Konut Projeleri", 1, 1500000.0, "İstanbul'da lüks konut projelerinde yerinizi alın.", R.drawable.image_home),

            // Vasıta kategorisi ürünleri
            Product(3, "SUV Arazi Aracı", 2, 200000.0, "Sağlam ve dayanıklı SUV, her türlü arazi için uygun.", R.drawable.image_suv),
            Product(4, "Spor Motosiklet", 2, 50000.0, "Yüksek performanslı spor motosiklet, hız tutkunları için.", R.drawable.image_bicycle),

            // Yedek Parça kategorisi ürünleri
            Product(5, "Otomobil Yedek Parça Seti", 3, 5000.0, "Otomobiliniz için komple yedek parça seti.", R.drawable.image_spare_part),
            Product(6, "Motosiklet Zinciri", 3, 1000.0, "Dayanıklı motosiklet zinciri, uzun ömürlü kullanım.", R.drawable.image_chain),

            // İkinci El ve Sıfır Alışveriş kategorisi ürünleri
            Product(7, "Apple iPhone 13", 4, 20000.0, "Sıfır iPhone 13, kutusunda ve garantili.", R.drawable.image_iphone),
            Product(8, "Canon DSLR Fotoğraf Makinesi", 4, 7500.0, "Profesyonel fotoğrafçılar için ideal Canon DSLR kamera.", R.drawable.image_canon),

            // İş Makineleri & Sanayi kategorisi ürünleri
            Product(9, "Kepçe - İş Makinesi", 5, 300000.0, "İnşaat işlerinde kullanıma uygun, güçlü kepçe.", R.drawable.image_digger),
            Product(10, "Tarım Traktörü", 5, 150000.0, "Yüksek performanslı, dayanıklı tarım traktörü.", R.drawable.image_tractor),

            // Ustalar ve Hizmetler kategorisi ürünleri
            Product(11, "Ev Tadilat Hizmeti", 6, 25000.0, "Ev yenileme ve tadilat hizmeti, profesyonel ekip.", R.drawable.image_worker),
            Product(12, "Araç Servis & Bakım", 6, 5000.0, "Aracınız için periyodik bakım ve servis hizmeti.", R.drawable.image_mechanic),

            // Özel Ders Verenler kategorisi ürünleri
            Product(13, "Matematik Özel Dersi", 7, 200.0, "Lise ve üniversite öğrencilerine özel matematik dersi.", R.drawable.image_math),
            Product(14, "Yabancı Dil Kursu", 7, 300.0, "Yabancı dil öğrenmek isteyenler için birebir kurs.", R.drawable.image_language),

            // İş İlanları kategorisi ürünleri
            Product(15, "Avukatlık Hizmeti", 8, 500.0, "Hukuki danışmanlık ve avukatlık hizmetleri.", R.drawable.image_law),
            Product(16, "Eğitim Danışmanlığı", 8, 400.0, "Öğrencilere eğitim ve kariyer danışmanlık hizmeti.", R.drawable.image_education),

            // Yardımcı Arayanlar kategorisi ürünleri
            Product(17, "Bebek Bakıcısı", 9, 2500.0, "Deneyimli bebek bakıcısı, referanslı.", R.drawable.image_babysitter),
            Product(18, "Temizlik Hizmeti", 9, 1500.0, "Ev ve ofisler için temizlik hizmeti.", R.drawable.image_cleaner),

            // Hayvanlar Alemi kategorisi ürünleri
            Product(19, "Golden Retriever Yavrusu", 10, 4000.0, "Safkan Golden Retriever yavruları, sağlık garantili.", R.drawable.image_golden),
            Product(20, "Akvaryum Balıkları Seti", 10, 500.0, "Akvaryumunuz için renkli ve sağlıklı balıklar.", R.drawable.image_fish)
        )

        // Ürün listesi geri döndürülüyor
        return@withContext products
    }
}
