package com.anlyn.rxjavatutorial.rxjava.map

import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlin.random.Random

// flatMap return Observable<T>
object FlatMap{
    fun get(){
        Observable.fromIterable(65..75)
                .subscribeOn(Schedulers.io())
                .flatMap {
                    randomNumber(it)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Char>{
                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(t: Char) {
                        Log.d(FlatMap::class.simpleName,t.toString())
                    }

                    override fun onError(e: Throwable) {

                    }

                    override fun onComplete() {

                    }
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