package com.example.foo

import android.content.Context
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.example.bar.Bar
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class FooImplTest {
    @Test
    fun onCreate() {
        Bar().getHomeActivityIntent(getApplicationContext())
        FooImpl().print()
    }
}