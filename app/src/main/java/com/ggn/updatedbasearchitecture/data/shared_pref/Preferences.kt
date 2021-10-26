package com.ggn.updatedbasearchitecture.data.shared_pref

import android.content.SharedPreferences
import com.ggn.updatedbasearchitecture.common.SharedPref
import com.ggn.updatedbasearchitecture.domain.repository.PreferencesHelper
import javax.inject.Inject

class Preferences @Inject constructor(private val sharedPreferences: SharedPreferences) : PreferencesHelper {

    override fun getUserId(): String {
        return load(SharedPref.USER_ID, "user id")
    }

    private inline fun <reified T : Any> save(key: String, value: T) {
        sharedPreferences.edit().apply { putValue(key, value) }.apply()
    }
    private inline fun <reified T : Any> load(key: String, defaultValue: T): T {
        return sharedPreferences.getValue(key, defaultValue)
    }
    private fun isSaved(key: String): Boolean {
        return sharedPreferences.contains(key)
    }
    private fun remove(key: String) {
        sharedPreferences.edit().remove(key).apply()
    }
}


inline fun <reified T : Any> SharedPreferences.Editor.putValue(key: String, value: T) {
    when (T::class) {
        Boolean::class -> putBoolean(key, value as Boolean)
        Int::class -> putInt(key, value as Int)
        Long::class -> putLong(key, value as Long)
        Float::class -> putFloat(key, value as Float)
        String::class -> putString(key, value as String)
        else -> throw UnsupportedOperationException("not supported preferences type")
    }
}


inline fun <reified T : Any> SharedPreferences.getValue(key: String, defaultValue: T): T {
    return when (T::class) {
        Boolean::class -> getBoolean(key, defaultValue as Boolean) as T
        Int::class -> getInt(key, defaultValue as Int) as T
        Long::class -> getLong(key, defaultValue as Long) as T
        Float::class -> getFloat(key, defaultValue as Float) as T
        String::class -> getString(key, defaultValue as String) as T
        else -> throw UnsupportedOperationException("not supported preferences type")
    }
}
