package com.cloffygames.techcareerbasicclonetask.uix.view.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cloffygames.techcareerbasicclonetask.data.entity.Product

/**
 * ProductItem, belirli bir ürünü görüntülemek için kullanılan Composable fonksiyonudur.
 * Bu fonksiyon, bir kart içinde ürünün adı ve görselini gösterir.
 *
 * @param product Product, gösterilecek olan ürün verisini temsil eder.
 */
@Composable
fun ProductItem(product: Product) {
    // Ürünü kart biçiminde görüntülemek için Card composable kullanılıyor.
    Card(
        modifier = Modifier
            .padding(8.dp)  // Kartın çevresine dolgu ekleniyor
            .width(150.dp)  // Kartın genişliği ayarlanıyor
            .height(150.dp),  // Kartın yüksekliği ayarlanıyor
        shape = RoundedCornerShape(8.dp)  // Kartın köşeleri yuvarlatılıyor
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,  // İçeriği yatayda ortalar
            verticalArrangement = Arrangement.Center,  // İçeriği dikeyde ortalar
            modifier = Modifier.padding(8.dp)  // Sütunun çevresine dolgu ekleniyor
        ) {
            // Ürün resmi gösteriliyor
            Image(
                painter = painterResource(id = product.imageURL),  // Resim kaynağı yükleniyor
                contentDescription = product.name,  // Resmin açıklaması, erişilebilirlik için kullanılır
                modifier = Modifier
                    .size(width = 150.dp, height = 100.dp)  // Resmin boyutu ayarlanıyor
                    .clip(RoundedCornerShape(8.dp))  // Resmin köşeleri yuvarlatılıyor
                    .align(Alignment.CenterHorizontally),  // Resim yatayda ortalanıyor
                contentScale = ContentScale.Crop  // Resmin ölçekleme biçimi ayarlanıyor
            )
            Spacer(modifier = Modifier.height(8.dp))  // Resim ve metin arasına boşluk ekleniyor
            // Ürün adı metni gösteriliyor
            Text(
                text = product.name,  // Ürün adı gösteriliyor
                fontWeight = FontWeight.Bold,  // Metin kalınlaştırılıyor
                fontSize = 14.sp,  // Metin boyutu ayarlanıyor
                color = Color.Black,  // Metin rengi siyah olarak ayarlanıyor
                maxLines = 1,  // Metin tek satırla sınırlı
                modifier = Modifier.align(Alignment.CenterHorizontally)  // Metin yatayda ortalanıyor
            )
        }
    }
}