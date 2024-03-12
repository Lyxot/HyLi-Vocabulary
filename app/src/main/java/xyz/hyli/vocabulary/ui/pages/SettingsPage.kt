package xyz.hyli.vocabulary.ui.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import xyz.hyli.vocabulary.ui.viewmodel.HyLiVocabularyViewmodel

@Composable
fun SettingsPage(viewmodel: HyLiVocabularyViewmodel, navController: NavController, paddingValues: PaddingValues = PaddingValues(0.dp)) {
    val currentSelect = viewmodel.currentSelect
    currentSelect.intValue = 2

    Column(modifier = Modifier.padding(paddingValues)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {

        }
    }
}