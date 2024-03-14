package xyz.hyli.vocabulary.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import xyz.hyli.vocabulary.R
import xyz.hyli.vocabulary.ui.pages.HomePage
import xyz.hyli.vocabulary.ui.pages.RecitationPage
import xyz.hyli.vocabulary.ui.pages.SettingsPage
import xyz.hyli.vocabulary.ui.viewmodel.HyLiVocabularyViewmodel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CompactScreen(viewModel: HyLiVocabularyViewmodel, navController: NavHostController) {
    val currentSelect = viewModel.currentSelect
    Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
        NavigationBar(modifier = Modifier.navigationBarsPadding()) {
            NavigationBarItem(
                icon = { Icon(if (currentSelect.intValue != 0) Icons.Outlined.Home else Icons.Filled.Home, contentDescription = null) },
                label = { Text(stringResource(id = R.string.page_home)) },
                selected = currentSelect.intValue == 0,
                onClick = {
                    currentSelect.intValue = 0
                    navController.navigate("HomePage") {
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
            NavigationBarItem(
                icon = { Icon(if (currentSelect.intValue != 1) Icons.Outlined.Book else Icons.Filled.Book, contentDescription = null) },
                label = { Text(stringResource(id = R.string.page_recitation)) },
                selected = currentSelect.intValue == 1,
                onClick = {
                    currentSelect.intValue = 1
                    navController.navigate("RecitationPage") {
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
            NavigationBarItem(
                icon = { Icon(if (currentSelect.intValue != 2) Icons.Outlined.Settings else Icons.Filled.Settings, contentDescription = null) },
                label = { Text(stringResource(id = R.string.page_settings)) },
                selected = currentSelect.intValue == 2,
                onClick = {
                    currentSelect.intValue = 2
                    navController.navigate("SettingsPage") {
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }, content = { innerPadding ->
        AnimatedNavHost(
            navController = navController,
            startDestination = "HomePage",
            enterTransition = { fadeIn(animationSpec = tween(400)) },
            exitTransition = { fadeOut(animationSpec = tween(400)) },
            popEnterTransition = { fadeIn(animationSpec = tween(400)) },
            popExitTransition = { fadeOut(animationSpec = tween(400)) }
        ) {
            composable("HomePage") { HomePage(viewModel, navController, innerPadding) }
            composable("RecitationPage") { RecitationPage(viewModel, navController, innerPadding) }
            composable("SettingsPage") { SettingsPage(viewModel, navController, innerPadding) }
        }
    })
}