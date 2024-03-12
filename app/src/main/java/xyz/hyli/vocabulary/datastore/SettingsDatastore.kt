package xyz.hyli.vocabulary.datastore

import android.util.Log
import kotlinx.coroutines.runBlocking

object SettingsDatastore : DataStoreOwner("settings") {
    // val ... by ...Preference(...)
    val last_run_version_code by intPreference(0)

    init {
        runBlocking {
            // if (...) ...reset()
        }
    }

    suspend fun resetAll() {
        // ...reset()
        Log.i("PreferencesDataStore", "All preferences reset")
    }
}
