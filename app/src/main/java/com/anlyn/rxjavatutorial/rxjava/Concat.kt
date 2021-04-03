package com.anlyn.rxjavatutorial.rxjava

import android.util.Log
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object Concat {

    fun get() {
        Observable.concat(oddObservable(), evenObservable())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d("number:", it.toString())
                }, {

                })
    }

}
    private fun oddObservable():Observable<Int>{
        val list = listOf<Int>(1,3,5,7)
        return Observable.create<Int> { emitter->
            for(i in list){
                emitter.onNext(i)
            }
            if(!emitter.isDisposed){
                emitter.onComplete()
            }
        }
        }


    private fun evenObservable():Observable<Int>{
        val list = listOf<Int>(2,4,6,8)
        return Observable.create<Int> { emitter->
            for(i in list){
                emitter.onNext(i)
            }
            if(!emitter.isDisposed){
                emitter.onComplete()
            }
        }
    }
