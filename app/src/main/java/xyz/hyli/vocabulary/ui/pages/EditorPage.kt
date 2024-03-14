package xyz.hyli.vocabulary.ui.pages

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.outlined.Sort
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Sort
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import xyz.hyli.vocabulary.R
import xyz.hyli.vocabulary.datastore.WordListSerializer
import xyz.hyli.vocabulary.proto.WordProto
import xyz.hyli.vocabulary.ui.theme.HyLiVocabularyTheme
import xyz.hyli.vocabulary.ui.theme.HyLiVocabularyTypography

class EditorPage : ComponentActivity() {
    private val listId = intent.getIntExtra("listId", 0)
    private val datastore: DataStore<WordProto.WordList> by dataStore(
        fileName = "${listId}.pb",
        serializer = WordListSerializer
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.navigationBarColor = android.graphics.Color.TRANSPARENT
        window.statusBarColor = android.graphics.Color.TRANSPARENT
        WindowCompat.setDecorFitsSystemWindows(window, false)
        enableEdgeToEdge()

        setContent {
            HyLiVocabularyTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    topBar = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(24.dp)
                                    .clickable {
                                        finish()
                                    }
                            )
                            Text(
                                text = listId.toString(),
                                style = HyLiVocabularyTypography.titleMedium
                            )
                            Icon(
                                Icons.AutoMirrored.Outlined.Sort,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(24.dp)
                                    .clickable {
                                        { TODO("Sort") }
                                    }
                            )
                        }
                    }
                ) {
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .padding(it)) {
                        val scrollState = rememberScrollState()
                        Column(
                            modifier = Modifier
                                .padding(horizontal = 24.dp)
                                .verticalScroll(scrollState)
                        ) {

                        }
                    }
                }
            }
        }
    }
}
