package com.anlyn.rxjavatutorial.rxjava

import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

// limit event for prepared time and last item is emitted
object DebounceExample {
    fun get() {

        Observable.just(1,2,3)
                .debounce(1200, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    Log.d("debounce example:", it.toString())
                }, {

                })
    }
}