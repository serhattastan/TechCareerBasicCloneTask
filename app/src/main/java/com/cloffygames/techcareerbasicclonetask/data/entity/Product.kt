package com.cloffygames.techcareerbasicclonetask.data.entity

/**
 * Product veri sınıfı, uygulamada kullanılan ürün bilgilerini temsil eder.
 * Bu sınıf, bir ürüne ait temel bilgileri içerir ve veri modellemesi için kullanılır.
 *
 * @property id Ürünün benzersiz kimliği (Int).
 * @property name Ürünün adı (String).
 * @property categoryId Ürünün ait olduğu kategori kimliği (Int).
 * @property price Ürünün fiyatı (Double).
 * @property description Ürünün açıklaması, ürüne dair kısa bilgi (String).
 * @property imageURL Ürünü temsil eden görselin kaynak ID'si (Int).
 */
data class Product(
    val id: Int,           // Ürünün benzersiz kimliği
    val name: String,      // Ürünün adı
    val categoryId: Int,   // Ürünün ait olduğu kategori kimliği
    val price: Double,     // Ürünün fiyatı
    val description: String, // Ürünün kısa açıklaması
    val imageURL: Int      // Ürünü temsil eden görselin kaynak ID'si
)
