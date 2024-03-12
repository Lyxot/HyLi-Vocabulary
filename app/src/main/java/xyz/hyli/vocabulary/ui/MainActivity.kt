package xyz.hyli.vocabulary.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import xyz.hyli.vocabulary.ui.navigation.CompactScreen
import xyz.hyli.vocabulary.ui.theme.HyLiVocabularyTheme
import xyz.hyli.vocabulary.ui.viewmodel.HyLiVocabularyViewModelFactory
import xyz.hyli.vocabulary.ui.viewmodel.HyLiVocabularyViewmodel

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: HyLiVocabularyViewmodel
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, HyLiVocabularyViewModelFactory())[HyLiVocabularyViewmodel::class.java]

        setContent {
            HyLiVocabularyTheme {
                val widthSizeClass = calculateWindowSizeClass(this).widthSizeClass
                MainScreen(widthSizeClass = widthSizeClass, viewModel = viewModel)
            }
        }
    }
}

@Composable
private fun MainScreen(widthSizeClass: WindowWidthSizeClass, viewModel: HyLiVocabularyViewmodel) {
    val navController = rememberNavController()
    CompactScreen(viewModel = viewModel, navController = navController)
}