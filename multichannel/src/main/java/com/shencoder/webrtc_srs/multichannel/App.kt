package com.shencoder.webrtc_srs.multichannel

import android.app.Application
import com.shencoder.mvvmkit.ext.globalInit
import com.shencoder.webrtc_srs.multichannel.di.appModule
import org.koin.android.java.KoinAndroidApplication
import org.koin.core.logger.Level
import org.webrtc.PeerConnectionFactory

/**
 *
 * @author  ShenBen
 * @date    2021/9/10 15:22
 * @email   714081644@qq.com
 */
class App :Application() {

    override fun onCreate() {
        super.onCreate()
        PeerConnectionFactory.initialize(
            PeerConnectionFactory.InitializationOptions
                .builder(applicationContext).createInitializationOptions()
        )
        val koinApplication =
            KoinAndroidApplication
                .create(
                    this,
                    if (BuildConfig.DEBUG) Level.DEBUG else Level.ERROR
                )
                .modules(appModule)
        globalInit(BuildConfig.DEBUG, "WebRTC-SRS", koinApplication)
    }
}