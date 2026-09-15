package com.waxd.camera.ui.activities

import android.content.SharedPreferences
import android.os.Bundle
import com.waxd.camera.AutoFinishOnSleep
import com.waxd.camera.CapturedItem
import com.waxd.camera.util.EphemeralSharedPrefsNamespace
import com.waxd.camera.util.getPrefs

open class SecureMainActivity : MainActivity(), SecureActivity {
    val capturedItems = ArrayList<CapturedItem>()
    val ephemeralPrefsNamespace = EphemeralSharedPrefsNamespace()

    private val autoFinisher = AutoFinishOnSleep(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        autoFinisher.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        autoFinisher.stop()
    }

    override fun getSharedPreferences(name: String, mode: Int): SharedPreferences {
        return ephemeralPrefsNamespace.getPrefs(this, name, mode, cloneOriginal = true)
    }
}
