package com.anlyn.rxjavatutorial.rxjava.filter

import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Predicate
import io.reactivex.schedulers.Schedulers

object Filter {

    fun get(){
        Observable.create<Int> {
            it.onNext(30)
            it.onNext(32)
            it.onNext(34)
            it.onNext(36)
            it.onComplete()
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(object : Predicate<Int>{
            override fun test(t: Int): Boolean {
                return t%4 == 0
            }
        }).subscribe({
            Log.d(Filter::class.simpleName,it.toString())
                },{

                })
    }
}