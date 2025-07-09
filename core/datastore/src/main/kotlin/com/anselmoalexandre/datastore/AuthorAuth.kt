package com.anselmoalexandre.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class AuthorAuth(private val dataStore: DataStore<Preferences>) {
    private object PreferenceKeys {
        val IS_AUTHENTICATED = booleanPreferencesKey("has-authenticated")
    }

    val isAuthenticated: Flow<Boolean> = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else throw exception
        }
        .map { preferences ->
            preferences[PreferenceKeys.IS_AUTHENTICATED] ?: false
        }

    suspend fun storeAuth(auth: Boolean = false) {
        dataStore.edit { preferences ->
            preferences[PreferenceKeys.IS_AUTHENTICATED] = auth
        }
    }

    companion object {
        const val AUTHENTICATED_KEY = "pref"
    }
}
