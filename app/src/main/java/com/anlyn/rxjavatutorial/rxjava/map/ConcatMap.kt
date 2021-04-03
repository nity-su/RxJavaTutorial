package com.anlyn.rxjavatutorial.rxjava.map

import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlin.random.Random

object ConcatMap{
    fun get(){
        Observable.fromIterable(65..68)
                .subscribeOn(Schedulers.io())
                .concatMap {
                    randomNumber(it)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d(FlatMap::class.simpleName,it.toString())
                },{
                    Log.d(FlatMap::class.simpleName,it.toString())
                })
    }

    private fun randomNumber(num:Int):Observable<Char>{
        val result = num.toChar()
        Log.d(FlatMap::class.simpleName,Thread.currentThread().name)
        return Observable.just(result).subscribeOn(Schedulers.io()).map {
            val ran = (Random.nextInt(5)+1)*1000
            Thread.sleep(ran.toLong())
            it
        }
    }
}