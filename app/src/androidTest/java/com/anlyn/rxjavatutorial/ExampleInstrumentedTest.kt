package com.anlyn.rxjavatutorial

import android.os.Looper
import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.anlyn.rxjavatutorial.rxjava.Concat
import com.anlyn.rxjavatutorial.rxjava.DebounceExample
import com.anlyn.rxjavatutorial.rxjava.Merge
import com.anlyn.rxjavatutorial.rxjava.filter.Filter
import com.anlyn.rxjavatutorial.rxjava.map.ConcatMap
import com.anlyn.rxjavatutorial.rxjava.map.FlatMap
import com.anlyn.rxjavatutorial.rxjava.map.Map
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    val TAG = ExampleInstrumentedTest::class.simpleName
    @Before
    fun before(){
            ConcatMap.get()
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Looper.prepare()

        Looper.loop()
        assertEquals("com.anlyn.rxjavatutorial", appContext.packageName)
    }
}