package com.josehumaneshumanes.canvasdemo.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.josehumaneshumanes.canvasdemo.R

private sealed class DrawerItem(
    @StringRes val titleResId:
    Int, val navItem: NavItem
) {
    object BasicShapes : DrawerItem(R.string.basic_shapes, NavItem.BasicShapes)
    object BallClicker : DrawerItem(R.string.ball_clicker, NavItem.BallClicker)
    object DrawText : DrawerItem(R.string.draw_text, NavItem.DrawText)
    object WeightPicker : DrawerItem(R.string.weight_picker, NavItem.WeightPicker)
    object Clock : DrawerItem(R.string.clock, NavItem.Clock)
    object PathDemo : DrawerItem(R.string.path_demo, NavItem.PathDemo)
    object PathBasics : DrawerItem(R.string.path_basics, NavItem.PathBasics)
    object PathOperations : DrawerItem(R.string.path_operations, NavItem.PathOperations)
    object AnimatingPathLine : DrawerItem(R.string.animating_path_line, NavItem.AnimatingPathLine)
    object AnimatingArrow : DrawerItem(R.string.animating_arrow, NavItem.AnimatingArrow)
    object TransformingClipping : DrawerItem(R.string.animating_arrow, NavItem.TransformingClipping)
    object PathEffects : DrawerItem(R.string.path_effects, NavItem.PathEffects)
    object TextPath : DrawerItem(R.string.path_effects, NavItem.TextPath)
    object GenderPicker : DrawerItem(R.string.gender_picker, NavItem.GenderPicker)
    object Tictactoe : DrawerItem(R.string.tictactoe, NavItem.Tictactoe)
    object Images : DrawerItem(R.string.images, NavItem.Images)
    object ImageReveal : DrawerItem(R.string.image_reveal, NavItem.ImageReveal)
}

private val drawerItems = listOf(
    DrawerItem.BasicShapes,
    DrawerItem.BallClicker,
    DrawerItem.DrawText,
    DrawerItem.WeightPicker,
    DrawerItem.Clock,
    DrawerItem.PathDemo,
    DrawerItem.PathBasics,
    DrawerItem.PathOperations,
    DrawerItem.AnimatingPathLine,
    DrawerItem.AnimatingArrow,
    DrawerItem.TransformingClipping,
    DrawerItem.PathEffects,
    DrawerItem.TextPath,
    DrawerItem.GenderPicker,
    DrawerItem.Tictactoe,
    DrawerItem.Images,
    DrawerItem.ImageReveal,
)

@Composable
fun NavigationDrawer(
    onNavItemClicked: (NavItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.secondaryVariant)
            .padding(horizontal = 8.dp, vertical = 8.dp)
    ) {

        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h4
        )

        LazyColumn() {
            items(drawerItems) {
                    item ->
                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onNavItemClicked(item.navItem)
                        },
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(id = item.titleResId),
                        style = MaterialTheme.typography.body1
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null,
                        modifier = Modifier.size(25.dp),
                        tint = MaterialTheme.colors.onSecondary
                    )
                }
            }
        }
    }
}
