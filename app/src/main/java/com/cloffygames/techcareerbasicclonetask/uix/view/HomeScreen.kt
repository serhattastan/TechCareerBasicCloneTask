package com.cloffygames.techcareerbasicclonetask.uix.view

import CategoryItem
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CameraEnhance
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Message
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.cloffygames.techcareerbasicclonetask.ui.theme.*
import com.cloffygames.techcareerbasicclonetask.uix.view.items.ProductItem
import com.cloffygames.techcareerbasicclonetask.uix.view.items.SearchBar
import com.cloffygames.techcareerbasicclonetask.uix.view.items.SideMenu
import com.cloffygames.techcareerbasicclonetask.uix.viewmodel.HomeViewModel
import kotlinx.coroutines.launch

/**
 * HomeScreen, uygulamanın ana ekranını oluşturan composable fonksiyonudur.
 * Bu ekran, kategoriler, ürünler ve diğer UI bileşenleri ile kullanıcıya içerik sunar.
 *
 * @param homeViewModel HomeViewModel, ekran verilerini sağlayan ViewModel.
 * @param navController NavController, farklı ekranlar arasında gezinmek için kullanılır.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(homeViewModel: HomeViewModel, navController: NavController) {

    // Yan menüyü kontrol etmek için DrawerState ve CoroutineScope kullanılıyor.
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    // ViewModel'den kategoriler ve ürünler LiveData olarak alınıyor.
    val categories by homeViewModel.categories.observeAsState(listOf())
    val products by homeViewModel.products.observeAsState(listOf())

    // Yan menü bileşeni
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                SideMenu()
            }
        }
    ) {
        // Scaffold, uygulamanın üst çubuğu ve ana içeriğini yerleştirmek için kullanılıyor.
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            // Sol tarafa yana açılır menü butonu
                            IconButton(onClick = {
                                scope.launch {
                                    drawerState.open() // Yan menüyü açmak için
                                }
                            }) {
                                Icon(Icons.Filled.Menu, contentDescription = "Menu", tint = Color.White)
                            }

                            // Ortada sahibinden.com yazısı
                            Text(text = "sahibinden.com", color = Color.White)

                            // Sağ tarafa mesajlar, profil ve kamera butonları
                            Row {
                                IconButton(onClick = { navController.navigate("messageScreen") }) {
                                    Icon(Icons.Filled.Message, contentDescription = "Mesajlar", tint = Color.White)
                                }
                                IconButton(onClick = { navController.navigate("userMenuScreen") }) {
                                    Icon(Icons.Filled.AccountCircle, contentDescription = "Profil", tint = Color.White)
                                }
                                IconButton(onClick = { /* Kamera tıklama işlemi */ }) {
                                    Icon(Icons.Filled.CameraEnhance, contentDescription = "Kamera", tint = Color.White)
                                }
                            }
                        }
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = CustomLightBlue)
                )
            }
        ) { paddingValues ->
            // Ana içerik alanı, LazyColumn ile oluşturuluyor.
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                item {
                    // Arama çubuğu
                    SearchBar()
                    Divider(
                        modifier = Modifier
                            .background(CustomLightGray)
                            .height(8.dp)
                    )
                }
                // Kategorileri listeleme
                items(categories) { category ->
                    CategoryItem(category)
                }
                item {
                    Divider(
                        modifier = Modifier
                            .background(CustomLightGray)
                            .height(8.dp)
                    )

                    // Anasayfa vitrini için başlık
                    Text(
                        text = "Anasayfa Vitrin",
                        color = Color.Gray,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .background(Color.LightGray)
                            .fillMaxWidth()
                            .padding(start = 8.dp)
                    )
                }
                item {
                    // Ürünleri yatay olarak listeleme
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.padding(horizontal = 8.dp)
                    ) {
                        items(products.chunked(2)) { productGroup ->
                            Column {
                                Row {
                                    productGroup.take(1).forEach { product ->
                                        ProductItem(product) // Ürünleri sırasıyla gösterme
                                    }
                                }
                                Row {
                                    productGroup.drop(1).forEach { product ->
                                        ProductItem(product) // Ürünleri sırasıyla gösterme
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
