package xyz.hyli.vocabulary

import android.app.Application
import android.content.Context

open class HyLiVocabulary: Application() {
    companion object {
        private lateinit var me: HyLiVocabulary
    }

    override fun onCreate() {
        me = this
        super.onCreate()
    }

    fun getContext(): Context {
        return me.applicationContext
    }
}