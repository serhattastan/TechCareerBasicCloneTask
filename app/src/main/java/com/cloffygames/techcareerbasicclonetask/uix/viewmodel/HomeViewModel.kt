package com.cloffygames.techcareerbasicclonetask.uix.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cloffygames.techcareerbasicclonetask.data.entity.Category
import com.cloffygames.techcareerbasicclonetask.data.entity.Product
import com.cloffygames.techcareerbasicclonetask.data.repository.CategoryRepository
import com.cloffygames.techcareerbasicclonetask.data.repository.ProductRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * HomeViewModel, uygulamanın ana sayfası için veri yönetimini gerçekleştiren ViewModel sınıfıdır.
 * Bu sınıf, kategoriler ve ürünlerle ilgili verileri yönetir ve UI bileşenlerine sunar.
 */
class HomeViewModel : ViewModel() {

    // Kategori ve ürün verilerini almak için repository'ler oluşturuluyor.
    private val categoryRepository = CategoryRepository()
    private val productRepository = ProductRepository()

    // UI bileşenlerine veri sağlamak için MutableLiveData nesneleri tanımlanıyor.
    val categories = MutableLiveData<List<Category>>()  // Kategorileri tutan LiveData
    val products = MutableLiveData<List<Product>>()    // Ürünleri tutan LiveData

    // ViewModel ilk oluşturulduğunda kategorileri ve ürünleri yüklemek için init bloğu kullanılıyor.
    init {
        getAllCategories()
        getAllProducts()
    }

    /**
     * Tüm kategorileri almak için kullanılan fonksiyon.
     * CoroutineScope kullanarak asenkron bir şekilde kategori verilerini yükler ve LiveData'ya atar.
     */
    fun getAllCategories() {
        CoroutineScope(Dispatchers.Main).launch {
            categories.value = categoryRepository.getAllCategories()
        }
    }

    /**
     * Tüm ürünleri almak için kullanılan fonksiyon.
     * CoroutineScope kullanarak asenkron bir şekilde ürün verilerini yükler ve LiveData'ya atar.
     */
    fun getAllProducts() {
        CoroutineScope(Dispatchers.Main).launch {
            products.value = productRepository.getAllProducts()
        }
    }

    /**
     * Belirli bir kategori ID'sine göre ürünleri filtreleyip almak için kullanılan fonksiyon.
     * CoroutineScope kullanarak asenkron bir şekilde ürünleri filtreler ve LiveData'ya atar.
     *
     * @param categoryId Filtreleme yapılacak kategori kimliği (Int).
     */
    fun getProductsByCategoryId(categoryId: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            products.value = productRepository.getAllProducts().filter { it.categoryId == categoryId }
        }
    }
}
