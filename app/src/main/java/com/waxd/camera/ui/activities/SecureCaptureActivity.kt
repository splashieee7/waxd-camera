package com.waxd.camera.ui.activities

import android.content.SharedPreferences
import com.waxd.camera.util.EphemeralSharedPrefsNamespace
import com.waxd.camera.util.getPrefs

class SecureCaptureActivity : CaptureActivity(), SecureActivity {
    val ephemeralPrefsNamespace = EphemeralSharedPrefsNamespace()

    override fun getSharedPreferences(name: String, mode: Int): SharedPreferences {
        return ephemeralPrefsNamespace.getPrefs(this, name, mode, cloneOriginal = true)
    }
}
