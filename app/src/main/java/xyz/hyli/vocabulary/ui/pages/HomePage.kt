package xyz.hyli.vocabulary.ui.pages

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import xyz.hyli.vocabulary.ui.theme.HyLiVocabularyTypography
import xyz.hyli.vocabulary.ui.viewmodel.HyLiVocabularyViewmodel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(viewmodel: HyLiVocabularyViewmodel, navController: NavController, paddingValues: PaddingValues = PaddingValues(0.dp)) {
    val context = LocalContext.current
    val currentSelect = viewmodel.currentSelect
    currentSelect.intValue = 0

    Surface(modifier = Modifier.padding(paddingValues)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(
                modifier = Modifier
                    .size(24.dp)
            )
            Text(
                text = " ",
                style = HyLiVocabularyTypography.titleMedium
            )
            Icon(
                Icons.Filled.Add,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        context.startActivity(Intent(context, EditorPage::class.java))
                    }
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {

        }
    }
}