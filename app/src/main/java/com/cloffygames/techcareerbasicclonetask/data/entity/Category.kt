package com.cloffygames.techcareerbasicclonetask.data.entity

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Category veri sınıfı, uygulamada kullanılan kategori bilgilerini temsil eder.
 * Bu sınıf, bir kategoriye ait temel bilgileri içerir ve veri modellemesi için kullanılır.
 *
 * @property id Kategorinin benzersiz kimliği (Int).
 * @property title Kategorinin başlığı, yani adı (String).
 * @property description Kategorinin açıklaması, bu kategoriye dair kısa bir bilgi (String).
 * @property icon Kategoriye ait ikonun kaynağını belirten kaynak ID'si (Int).
 * @property color Kategorinin arka plan rengini temsil eden Color nesnesi.
 */
data class Category(
    val id: Int,          // Kategorinin benzersiz kimliği
    val title: String,    // Kategorinin başlığı
    val description: String, // Kategorinin kısa açıklaması
    val icon: Int,        // Kategoriyi temsil eden ikonun kaynak ID'si
    val color: Color      // Kategoriyi temsil eden renk
)
