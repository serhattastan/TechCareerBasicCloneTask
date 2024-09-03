package com.cloffygames.techcareerbasicclonetask.data.repository

import com.cloffygames.techcareerbasicclonetask.data.datasource.CategoryDataSource
import com.cloffygames.techcareerbasicclonetask.data.entity.Category

/**
 * CategoryRepository, uygulamanın veri katmanında kategori verilerini yönetmek için kullanılan bir sınıftır.
 * Bu sınıf, veri kaynağından (CategoryDataSource) gelen verileri almak için bir arayüz sağlar.
 */
class CategoryRepository {

    // CategoryDataSource sınıfından bir örnek oluşturuluyor.
    private val categoryDataSource: CategoryDataSource = CategoryDataSource()

    /**
     * Tüm kategorileri döndüren bir fonksiyon.
     * Bu fonksiyon, CategoryDataSource sınıfındaki getAllCategories() fonksiyonunu çağırır.
     *
     * @return List<Category> Tüm kategorilerin bulunduğu bir listeyi döndürür.
     */
    suspend fun getAllCategories(): List<Category> = categoryDataSource.getAllCategories()
}
