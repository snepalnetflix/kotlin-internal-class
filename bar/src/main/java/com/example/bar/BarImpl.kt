package com.example.bar

import android.content.Context
import android.content.Intent
import com.example.foo.HomeActivity

class Bar {
    fun getHomeActivityIntent(context: Context): Intent {
        return Intent(context, HomeActivity::class.java)
    }
}
