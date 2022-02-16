package com.josehumaneshumanes.canvasdemo.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

enum class NavArg(
    val key: String,
    val navType: NavType<*>
) {
    Id(key = "id", navType = NavType.IntType)
}

sealed class NavItem(
    val baseRoute: String,
    private val navArgs: List<NavArg> = emptyList()
) {
    object BasicShapes : NavItem(baseRoute = "basic-shapes")
    object BallClicker : NavItem(baseRoute = "ball-clicker")
    object DrawText : NavItem(baseRoute = "draw-text")
    object WeightPicker : NavItem(baseRoute = "weight-picker")
    object Clock : NavItem(baseRoute = "clock")
    object PathDemo : NavItem(baseRoute = "path-demo")
    object PathBasics : NavItem(baseRoute = "path-basics")
    object PathOperations : NavItem(baseRoute = "path-operations")
    object AnimatingPathLine : NavItem(baseRoute = "animating-path-line")
    object AnimatingArrow : NavItem(baseRoute = "animating-arrow")
    object TransformingClipping : NavItem(baseRoute = "transforming-clipping")
    object PathEffects : NavItem(baseRoute = "path-effects")
    object TextPath : NavItem(baseRoute = "text-path")
    object GenderPicker : NavItem(baseRoute = "gender-picker")
    object Tictactoe : NavItem(baseRoute = "tic-tac-toe")
    object Images : NavItem(baseRoute = "images")
    object ImageReveal : NavItem(baseRoute = "image-reveal")

    val route = run {
        val argKeys = navArgs.map { "{${it.key}}" }
        listOf(baseRoute)
            .plus(argKeys)
            .joinToString("/")
    }

    val args = navArgs.map {
        navArgument(it.key) { type = it.navType }
    }
}
