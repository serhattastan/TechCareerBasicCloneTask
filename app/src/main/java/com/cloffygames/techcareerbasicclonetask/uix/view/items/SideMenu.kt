package com.cloffygames.techcareerbasicclonetask.uix.view.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cloffygames.techcareerbasicclonetask.R
import com.cloffygames.techcareerbasicclonetask.ui.theme.CustomLightBlue

/**
 * SideMenu, uygulamanın yan menüsünü oluşturan composable fonksiyonudur.
 * Bu menü, özel menü öğeleri ve kategori öğeleri içerir.
 */
@Composable
fun SideMenu() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize() // Menünün tüm ekranı kaplaması sağlanır
            .background(Color.White) // Menünün arka plan rengi beyaz olarak ayarlanır
    ) {
        item {
            // Özel menü öğeleri sıralanır
            SpecialMenuItem(icon = R.drawable.icon_sahibinden_logo, title = "Anasayfa", 40.dp, 40.dp, null)
            SpecialMenuItem(icon = R.drawable.icon_user, title = "Bana Özel", 40.dp, 40.dp, Color.White)
            SpecialMenuItem(icon = R.drawable.icon_plus, title = "İlan Ver", 40.dp, 40.dp, Color.White)
            SpecialMenuItem(icon = R.drawable.icon_otobid, title = "ile Aracını Sat", 120.dp, 40.dp, null, 2.dp)
            SpecialMenuItem(icon = R.drawable.icon_360, title = "Servisler", 40.dp, 40.dp, Color.White)

            // Menü öğeleri sıralanır
            MenuItem(icon = R.drawable.icon_home, title = "Emlak")
            Divider() // Menü öğeleri arasında çizgi eklenir
            MenuItem(icon = R.drawable.icon_car, title = "Vasıta")
            Divider()
            MenuItem(icon = R.drawable.icon_mas, title = "Yedek Parça")
            Divider()
            MenuItem(icon = R.drawable.icon_cart, title = "İkinci El ve Sıfır Alışveriş")
            Divider()
            MenuItem(icon = R.drawable.icon_tractor, title = "İş Makineleri ve Sanayi")
            Divider()
            MenuItem(icon = R.drawable.icon_service, title = "Ustalar ve Hizmetler")
            Divider()
            MenuItem(icon = R.drawable.icon_education, title = "Özel Ders Verenler")
            Divider()
            MenuItem(icon = R.drawable.icon_law, title = "İş İlanları")
        }
    }
}

/**
 * SpecialMenuItem, yan menüdeki özel menü öğelerini temsil eden composable fonksiyonudur.
 * Bu öğeler, ikon, başlık ve sağda bir ileri ok simgesi içerir.
 *
 * @param icon İkon kaynağının ID'si.
 * @param title Menünün başlığı.
 * @param iconWidt İkonun genişliği.
 * @param iconHeight İkonun yüksekliği.
 * @param iconColor İkonun rengi, null olursa varsayılan rengi kullanır.
 * @param textPadding Metin ile ikon arasındaki boşluk.
 */
@Composable
fun SpecialMenuItem(
    icon: Int,
    title: String,
    iconWidt : Dp,
    iconHeight : Dp,
    iconColor: Color?,
    textPadding : Dp = 16.dp
) {
    Row(
        modifier = Modifier
            .fillMaxWidth() // Satırın genişliğini tam olarak doldurur
            .background(CustomLightBlue), // Arka plan rengi mavi olarak ayarlanır
        verticalAlignment = Alignment.CenterVertically // İçerik dikeyde ortalanır
    ) {
        Image(
            painter = painterResource(id = icon), // İkon kaynağı yüklenir
            contentDescription = "", // Erişilebilirlik açıklaması boş bırakılır
            modifier = Modifier
                .size(width = iconWidt, height = iconHeight) // İkon boyutu ayarlanır
                .padding(start = 16.dp), // İkona soldan dolgu eklenir
            colorFilter = if (iconColor != null) androidx.compose.ui.graphics.ColorFilter.tint(iconColor) else null // İkon rengi uygulanır
        )
        Spacer(modifier = Modifier
            .width(8.dp)
            .height(70.dp)) // İkon ile metin arasına boşluk eklenir
        Text(
            text = title,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier.padding(start = textPadding) // Metin ile ikon arasına dolgu eklenir
        )
        Spacer(modifier = Modifier.weight(1f)) // Sağ tarafa boşluk bırakılır
        Icon(
            imageVector = Icons.Filled.ArrowForwardIos,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.padding(end = 16.dp) // Ok simgesine sağdan dolgu eklenir
        )
    }
}

/**
 * MenuItem, yan menüdeki kategori öğelerini temsil eden composable fonksiyonudur.
 * Bu öğeler, ikon ve başlık içerir.
 *
 * @param icon İkon kaynağının ID'si.
 * @param title Menünün başlığı.
 */
@Composable
fun MenuItem(icon: Int, title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth() // Satırın genişliğini tam olarak doldurur
            .padding(16.dp), // Satırın çevresine dolgu eklenir
        verticalAlignment = Alignment.CenterVertically // İçerik dikeyde ortalanır
    ) {
        Image(
            painter = painterResource(id = icon), // İkon kaynağı yüklenir
            contentDescription = "", // Erişilebilirlik açıklaması boş bırakılır
            modifier = Modifier.size(40.dp) // İkon boyutu ayarlanır
        )
        Spacer(modifier = Modifier.width(16.dp)) // İkon ile metin arasına boşluk eklenir
        Text(
            text = title,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = Color.Black // Metin rengi siyah olarak ayarlanır
        )
    }
}
