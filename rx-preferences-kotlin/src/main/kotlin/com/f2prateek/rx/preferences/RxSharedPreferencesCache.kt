package com.f2prateek.rx.preferences

import android.content.SharedPreferences
import java.util.concurrent.ConcurrentHashMap

object RxSharedPreferencesCache {
    val cache: MutableMap<SharedPreferences, RxSharedPreferences> = ConcurrentHashMap()

    fun get(sharedPreferences: SharedPreferences): RxSharedPreferences {
        if (!cache.containsKey(sharedPreferences)) {
            cache[sharedPreferences] = RxSharedPreferences.create(sharedPreferences)
        }
        return cache[sharedPreferences] as RxSharedPreferences
    }
}
