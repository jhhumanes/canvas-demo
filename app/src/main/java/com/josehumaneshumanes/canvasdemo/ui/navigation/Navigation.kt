package com.josehumaneshumanes.canvasdemo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.josehumaneshumanes.canvasdemo.ui.screen.animating_arrow.AnimatingArrowScreen
import com.josehumaneshumanes.canvasdemo.ui.screen.animating_path_line.AnimatingPathLineScreen
import com.josehumaneshumanes.canvasdemo.ui.screen.ball_clicker.BallClickerScreen
import com.josehumaneshumanes.canvasdemo.ui.screen.basic_shapes.BasicShapesScreen
import com.josehumaneshumanes.canvasdemo.ui.screen.clock.ClockScreen
import com.josehumaneshumanes.canvasdemo.ui.screen.draw_text.DrawTextScreen
import com.josehumaneshumanes.canvasdemo.ui.screen.gender_picker.GenderPickerScreen
import com.josehumaneshumanes.canvasdemo.ui.screen.image_reveal.ImageRevealScreen
import com.josehumaneshumanes.canvasdemo.ui.screen.images.ImagesScreen
import com.josehumaneshumanes.canvasdemo.ui.screen.path_basics.PathBasicsScreen
import com.josehumaneshumanes.canvasdemo.ui.screen.path_demo.PathDemoScreen
import com.josehumaneshumanes.canvasdemo.ui.screen.path_effects.PathEffectsScreen
import com.josehumaneshumanes.canvasdemo.ui.screen.path_operations.PathOperationsScreen
import com.josehumaneshumanes.canvasdemo.ui.screen.text_path.TextPathScreen
import com.josehumaneshumanes.canvasdemo.ui.screen.tictactoe.TictactoeScreen
import com.josehumaneshumanes.canvasdemo.ui.screen.transforming_clipping.TranformingClippingScreen
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

        composable(NavItem.AnimatingPathLine) {
            CompositionLocalProvider(
                LocalViewModelStoreOwner provides viewModelStoreOwner
            ) {
                AnimatingPathLineScreen()
            }
        }

        composable(NavItem.AnimatingArrow) {
            CompositionLocalProvider(
                LocalViewModelStoreOwner provides viewModelStoreOwner
            ) {
                AnimatingArrowScreen()
            }
        }

        composable(NavItem.TransformingClipping) {
            CompositionLocalProvider(
                LocalViewModelStoreOwner provides viewModelStoreOwner
            ) {
                TranformingClippingScreen()
            }
        }

        composable(NavItem.PathEffects) {
            CompositionLocalProvider(
                LocalViewModelStoreOwner provides viewModelStoreOwner
            ) {
                PathEffectsScreen()
            }
        }

        composable(NavItem.TextPath) {
            CompositionLocalProvider(
                LocalViewModelStoreOwner provides viewModelStoreOwner
            ) {
                TextPathScreen()
            }
        }

        composable(NavItem.GenderPicker) {
            CompositionLocalProvider(
                LocalViewModelStoreOwner provides viewModelStoreOwner
            ) {
                GenderPickerScreen()
            }
        }

        composable(NavItem.Tictactoe) {
            CompositionLocalProvider(
                LocalViewModelStoreOwner provides viewModelStoreOwner
            ) {
                TictactoeScreen()
            }
        }

        composable(NavItem.Images) {
            CompositionLocalProvider(
                LocalViewModelStoreOwner provides viewModelStoreOwner
            ) {
                ImagesScreen()
            }
        }

        composable(NavItem.ImageReveal) {
            CompositionLocalProvider(
                LocalViewModelStoreOwner provides viewModelStoreOwner
            ) {
                ImageRevealScreen()
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
