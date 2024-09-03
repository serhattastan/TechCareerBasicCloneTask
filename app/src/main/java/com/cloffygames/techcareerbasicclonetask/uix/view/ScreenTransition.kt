package com.cloffygames.techcareerbasicclonetask.uix.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cloffygames.techcareerbasicclonetask.uix.viewmodel.HomeViewModel
import com.cloffygames.techcareerbasicclonetask.uix.viewmodel.MessageViewModel
import com.cloffygames.techcareerbasicclonetask.uix.viewmodel.UserMenuViewModel

/**
 * ScreenTransition composable fonksiyonu, uygulamanın farklı ekranlar arasında geçiş yapmasını sağlar.
 * Bu fonksiyon, NavController kullanarak navigasyon işlemlerini yönetir ve farklı ekranları tanımlar.
 *
 * @param homeViewModel Home ekranının verilerini yöneten ViewModel.
 * @param messageViewModel Mesajlar ekranının verilerini yöneten ViewModel.
 * @param userMenuViewModel Kullanıcı menüsü ekranının verilerini yöneten ViewModel.
 */
@Composable
fun ScreenTransition(
    homeViewModel: HomeViewModel,
    messageViewModel: MessageViewModel,
    userMenuViewModel: UserMenuViewModel
) {
    // NavController, ekranlar arasında gezinmeyi yönetmek için kullanılır
    val navController = rememberNavController()

    // NavHost, farklı ekranları (composables) barındıran kapsayıcıdır ve başlangıç ekranını belirtir
    NavHost(navController = navController, startDestination = "homeScreen") {

        // HomeScreen composable'ı, başlangıç ekranı olarak tanımlanır
        composable("homeScreen") {
            HomeScreen(homeViewModel, navController)
        }

        // MessageScreen composable'ı, mesajlar ekranı olarak tanımlanır
        composable("messageScreen") {
            MessageScreen(messageViewModel, navController)
        }

        // UserMenuScreen composable'ı, kullanıcı menüsü ekranı olarak tanımlanır
        composable("userMenuScreen") {
            UserMenuScreen(userMenuViewModel, navController)
        }
    }
}
