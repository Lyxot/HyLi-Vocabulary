package xyz.hyli.vocabulary.ui.viewmodel

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class HyLiVocabularyViewmodel: ViewModel() {
    val currentSelect = mutableIntStateOf(0)
}


class HyLiVocabularyViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HyLiVocabularyViewmodel() as T
    }
}