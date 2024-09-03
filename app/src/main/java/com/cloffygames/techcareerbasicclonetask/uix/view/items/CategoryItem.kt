import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cloffygames.techcareerbasicclonetask.data.entity.Category

/**
 * CategoryItem, belirli bir kategoriyi görüntülemek için kullanılan Composable fonksiyonudur.
 * Bu fonksiyon, kategori başlığını, açıklamasını ve ikonunu yatay bir sırada gösterir.
 *
 * @param category Category, gösterilecek olan kategori verisini temsil eder.
 */
@Composable
fun CategoryItem(category: Category) {
    // Yatay bir sıralama düzeninde kategori içeriği gösteriliyor
    Row(
        modifier = Modifier
            .fillMaxWidth()  // Satırın genişliğini tam olarak doldurur
            .padding(vertical = 8.dp, horizontal = 16.dp),  // Satıra dikey ve yatay dolgu ekler
        verticalAlignment = Alignment.CenterVertically  // İçeriği dikeyde ortalar
    ) {
        // Kategori ikonu görüntüleniyor
        Image(
            painter = painterResource(id = category.icon),  // İkon kaynağı yükleniyor
            contentDescription = category.title,  // İkonun açıklaması, erişilebilirlik için kullanılır
            modifier = Modifier.size(40.dp)  // İkonun boyutu ayarlanıyor
        )
        Spacer(modifier = Modifier.width(16.dp))  // İkon ve metin arasına boşluk ekleniyor
        Column {
            // Kategori başlığı görüntüleniyor
            Text(text = category.title, fontWeight = FontWeight.Medium, fontSize = 16.sp)
            // Kategori açıklaması görüntüleniyor, gri renkte ve tek satırla sınırlı
            Text(text = category.description, fontSize = 12.sp, color = androidx.compose.ui.graphics.Color.Gray, maxLines = 1)
        }
    }
}
