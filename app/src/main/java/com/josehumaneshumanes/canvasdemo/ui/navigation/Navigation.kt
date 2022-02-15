package com.josehumaneshumanes.canvasdemo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.josehumaneshumanes.canvasdemo.ui.screen.ball_clicker.BallClickerScreen
import com.josehumaneshumanes.canvasdemo.ui.screen.basic_shapes.BasicShapesScreen
import com.josehumaneshumanes.canvasdemo.ui.screen.clock.ClockScreen
import com.josehumaneshumanes.canvasdemo.ui.screen.draw_text.DrawTextScreen
import com.josehumaneshumanes.canvasdemo.ui.screen.path_basics.PathBasicsScreen
import com.josehumaneshumanes.canvasdemo.ui.screen.path_demo.PathDemoScreen
import com.josehumaneshumanes.canvasdemo.ui.screen.path_operations.PathOperationsScreen
import com.josehumaneshumanes.canvasdemo.ui.screen.weight_picker.WeightPickerScreen

@Composable
fun Navigation(navHostController: NavHostController) {
    val viewModelStoreOwner = checkNotNull(LocalViewModelStoreOwner.current)

    NavHost(
        navController = navHostController,
        startDestination = NavItem.BasicShapes.route
    ) {
        composable(NavItem.BasicShapes) {
            CompositionLocalProvider(
                LocalViewModelStoreOwner provides viewModelStoreOwner
            ) {
                BasicShapesScreen()
            }
        }

        composable(NavItem.BallClicker) {
            CompositionLocalProvider(
                LocalViewModelStoreOwner provides viewModelStoreOwner
            ) {
                BallClickerScreen()
            }
        }

        composable(NavItem.DrawText) {
            CompositionLocalProvider(
                LocalViewModelStoreOwner provides viewModelStoreOwner
            ) {
                DrawTextScreen()
            }
        }

        composable(NavItem.WeightPicker) {
            CompositionLocalProvider(
                LocalViewModelStoreOwner provides viewModelStoreOwner
            ) {
                WeightPickerScreen()
            }
        }

        composable(NavItem.Clock) {
            CompositionLocalProvider(
                LocalViewModelStoreOwner provides viewModelStoreOwner
            ) {
                ClockScreen()
            }
        }

        composable(NavItem.PathDemo) {
            CompositionLocalProvider(
                LocalViewModelStoreOwner provides viewModelStoreOwner
            ) {
                PathDemoScreen()
            }
        }

        composable(NavItem.PathBasics) {
            CompositionLocalProvider(
                LocalViewModelStoreOwner provides viewModelStoreOwner
            ) {
                PathBasicsScreen()
            }
        }

        composable(NavItem.PathOperations) {
            CompositionLocalProvider(
                LocalViewModelStoreOwner provides viewModelStoreOwner
            ) {
                PathOperationsScreen()
            }
        }
    }
}

private fun NavGraphBuilder.composable(
    navItem: NavItem,
    content: @Composable (NavBackStackEntry) -> Unit
) {

    composable(route = navItem.route, arguments = navItem.args) {
        content(it)
    }
}

private inline fun <reified T> NavBackStackEntry.findArgs(navArg: NavArg): T {
    val value = arguments?.get(navArg.key)
    requireNotNull(value)
    return value as T
}
