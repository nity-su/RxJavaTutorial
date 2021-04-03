package com.anlyn.rxjavatutorial.rxjava.flowable

import android.util.Log
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableEmitter
import io.reactivex.FlowableOnSubscribe
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

object Flowable{
    val TAG = Flowable::class.simpleName
    fun get(){
        val subscriber =object: Subscriber<String> {
            override fun onSubscribe(s: Subscription?) {
                //similar to Subscription
                s?.request(Long.MAX_VALUE)
                Log.d(TAG,"onSubscribe")
            }

            override fun onNext(t: String?) {
                Log.d(TAG,"onNext"+t)
            }

            override fun onError(t: Throwable?) {
                Log.d(TAG,"Throwable"+t.toString())
            }

            override fun onComplete() {
                Log.d(TAG,"onComplete")
            }
        }

        val flowable= Flowable.create<String>(object : FlowableOnSubscribe<String> {
            override fun subscribe(emitter: FlowableEmitter<String>) {
                for(i in 1..1000) {
                    if(emitter.isCancelled)
                        return
                    emitter.onNext(i.toString())
                }
                emitter.onComplete()
            }
        }, BackpressureStrategy.DROP)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())

        flowable.subscribe(subscriber)
    }
}