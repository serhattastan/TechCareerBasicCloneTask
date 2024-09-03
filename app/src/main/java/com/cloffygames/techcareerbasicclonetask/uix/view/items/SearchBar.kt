package com.cloffygames.techcareerbasicclonetask.uix.view.items

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * SearchBar, bir arama çubuğunu temsil eden Composable fonksiyonudur.
 * Bu arama çubuğu, kullanıcıdan metin girişi alır ve arama, sesli arama, QR kod tarama ikonları içerir.
 */
@Composable
fun SearchBar() {
    OutlinedTextField(
        value = "",  // Kullanıcıdan alınan arama metni, burada boş olarak tanımlanmış
        onValueChange = {},  // Kullanıcı metin girişini değiştirdiğinde çağrılır, şu an boş bırakılmış
        modifier = Modifier
            .fillMaxWidth()  // Arama çubuğu ekranın genişliğini doldurur
            .padding(12.dp),  // Arama çubuğuna çevresel dolgu eklenir
        placeholder = { Text(text = "Kelime veya ilan No. ile ara") },  // Kullanıcı metin girmediğinde gösterilen yer tutucu metin
        leadingIcon = {
            Icon(Icons.Filled.Search, contentDescription = "Search")  // Arama ikonu, kullanıcının arama yapması için sol tarafa yerleştirilir
        },
        trailingIcon = {
            Row {
                Icon(Icons.Filled.Mic, contentDescription = "Voice Search")  // Sesli arama ikonu, sağ tarafa yerleştirilir
                Spacer(modifier = Modifier.width(8.dp))  // İki ikon arasına boşluk eklenir
                Icon(
                    Icons.Filled.QrCodeScanner,
                    contentDescription = "QR Code",
                    modifier = Modifier.padding(end = 8.dp)  // QR kod tarama ikonu, sağda yerleştirilir ve dışarıdan dolgu eklenir
                )
            }
        }
    )
}
