package com.josehumaneshumanes.canvasdemo.ui.screen

import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.josehumaneshumanes.canvasdemo.ui.components.BasicTopBar
import com.josehumaneshumanes.canvasdemo.ui.navigation.Navigation
import com.josehumaneshumanes.canvasdemo.ui.navigation.NavigationDrawer
import kotlinx.coroutines.launch

@Composable
fun BaseScreen(
    modifier: Modifier = Modifier
) {
    val scaffoldState = rememberScaffoldState(
        drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    )
    val scope = rememberCoroutineScope()
    val navHostController = rememberNavController()
    val viewModel: BaseViewModel = viewModel(
        viewModelStoreOwner = checkNotNull(LocalViewModelStoreOwner.current)
    )
    val title by remember { viewModel.title }

    Scaffold(
        scaffoldState = scaffoldState,
        modifier = modifier,
        topBar = {
            BasicTopBar(
                title = title,
                onIconClicked = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerContent = {
            NavigationDrawer(onNavItemClicked = { navItem ->
                navHostController.navigate(navItem.route)
                scope.launch {
                    scaffoldState.drawerState.close()
                }
            })
        },
        drawerGesturesEnabled = true,
    ) {
        Navigation(navHostController)
    }
}
