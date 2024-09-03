package com.cloffygames.techcareerbasicclonetask.data.repository

import com.cloffygames.techcareerbasicclonetask.data.datasource.ProductDataSource
import com.cloffygames.techcareerbasicclonetask.data.entity.Product

/**
 * ProductRepository, uygulamanın veri katmanında ürün verilerini yönetmek için kullanılan bir sınıftır.
 * Bu sınıf, veri kaynağından (ProductDataSource) gelen verileri almak için bir arayüz sağlar.
 */
class ProductRepository {

    // ProductDataSource sınıfından bir örnek oluşturuluyor.
    private val productDataSource: ProductDataSource = ProductDataSource()

    /**
     * Tüm ürünleri döndüren bir fonksiyon.
     * Bu fonksiyon, ProductDataSource sınıfındaki getAllProducts() fonksiyonunu çağırır.
     *
     * @return List<Product> Tüm ürünlerin bulunduğu bir listeyi döndürür.
     */
    suspend fun getAllProducts(): List<Product> = productDataSource.getAllProducts()

}
