package com.cloffygames.techcareerbasicclonetask.uix.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Message
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.cloffygames.techcareerbasicclonetask.ui.theme.CustomLightBlue
import com.cloffygames.techcareerbasicclonetask.uix.viewmodel.UserMenuViewModel

/**
 * UserMenuScreen, kullanıcı menüsünü oluşturan ekranın composable fonksiyonudur.
 * Bu ekran, kullanıcıya çeşitli hesap ayarları ve işlemler sunar.
 *
 * @param userMenuViewModel Kullanıcı menüsü ekranının verilerini yöneten ViewModel.
 * @param navController Ekranlar arasında gezinmeyi yöneten NavController.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserMenuScreen(userMenuViewModel: UserMenuViewModel, navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Sol üst köşede home butonu
                        IconButton(onClick = { navController.navigate("homeScreen") }) {
                            Icon(Icons.Filled.Home, contentDescription = "Home", tint = Color.White)
                        }

                        // Ortada kullanıcı ismi
                        Text(text = "Serhat Taştan", color = Color.White)

                        // Sağ tarafa mesajlar ve profil butonları
                        Row {
                            IconButton(onClick = { navController.navigate("messageScreen") }) {
                                Icon(Icons.Filled.Message, contentDescription = "Mesajlar", tint = Color.White)
                            }
                            IconButton(onClick = { navController.navigate("userMenuScreen") }) {
                                Icon(Icons.Filled.AccountCircle, contentDescription = "Profil", tint = Color.White)
                            }
                        }
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = CustomLightBlue)
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item {
                // İlan Yönetimi başlığı altında listelenen menü öğeleri
                MenuSection("İLAN YÖNETİMİ", listOf("Yayında Olanlar (0)", "Yayında Olmayanlar (1)", "İlana QR Kod ile Fotoğraf Ekleme"))
            }
            item {
                // Mesajlar ve Bilgilendirmeler başlığı altında listelenen menü öğeleri
                MenuSection("MESAJLAR VE BİLGİLENDİRMELER", listOf("İlan Mesajları", "GeT Mesajları", "Bilgilendirmeler (15)", "Ürün Tekliflerim"))
            }
            item {
                // Favoriler başlığı altında listelenen menü öğeleri
                MenuSection("FAVORİLER", listOf("Size Özel İlanlar", "Favori İlanlar", "Favori Aramalar", "Favori Satıcılar", "Karşılaştırma Listesi"))
            }
            item {
                // Alışveriş İşlemlerim başlığı altında listelenen menü öğeleri
                MenuSection("ALIŞVERİŞ İŞLEMLERİM", listOf("S - Param Güvende", "Güvenli E-Ticaret"))
            }
            item {
                // Hesabım başlığı altında listelenen menü öğeleri
                MenuSection("HESABIM", listOf("Hesap Bilgilerim", "Kayıtlı Kartlarım", "İzinlerim"))
            }
            item {
                // Diğer başlığı altında listelenen menü öğeleri
                MenuSection("DİĞER", listOf("Yardım ve İşlem Rehberi", "Sorun / Öneri Bildirimi", "Hakkında", "Kişisel Verilerin Korunması", "Çerezler", "Dil Tercihi"))
            }
            item {
                // Çıkış Yap butonu
                Spacer(modifier = Modifier.height(16.dp))
                LogoutButton()
            }
        }
    }
}

/**
 * MenuSection, bir başlık altında menü öğelerini listelemek için kullanılan composable fonksiyonudur.
 *
 * @param title Menü başlığı.
 * @param items Menü öğelerinin listesini temsil eder.
 */
@Composable
fun MenuSection(title: String, items: List<String>) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth() // Kartın genişliği tam ekranı kaplar
            .padding(8.dp) // Kartın çevresine dolgu eklenir
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Menü başlığı
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = CustomLightBlue
            )
            Spacer(modifier = Modifier.height(8.dp))
            // Menü öğeleri listelenir
            items.forEach { item ->
                Text(text = item, fontSize = 16.sp, modifier = Modifier.padding(vertical = 4.dp))
            }
        }
    }
}

/**
 * LogoutButton, çıkış yapma işlemi için kullanılan bir butonun composable fonksiyonudur.
 */
@Composable
fun LogoutButton() {
    Button(
        onClick = { /* Çıkış işlemi */ },
        modifier = Modifier
            .fillMaxWidth() // Butonun genişliği tam ekranı kaplar
            .padding(horizontal = 8.dp), // Butonun yanlarına dolgu eklenir
        colors = ButtonDefaults.buttonColors(containerColor = Color.Red) // Butonun arka plan rengi kırmızı olarak ayarlanır
    ) {
        Text(text = "ÇIKIŞ YAP", color = Color.White) // Buton metni beyaz renkte gösterilir
    }
}
