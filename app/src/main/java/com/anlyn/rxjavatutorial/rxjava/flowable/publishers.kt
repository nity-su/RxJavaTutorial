package com.anlyn.rxjavatutorial.rxjava.flowable

import io.reactivex.Flowable
import org.reactivestreams.Publisher
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
 // source of event
object publishers{
    fun get(){
        val publisher:Publisher<Int> = Flowable.just(1)
        publisher.subscribe(object : Subscriber<Int>{
            override fun onSubscribe(s: Subscription?) {
                TODO("Not yet implemented")
            }

            override fun onNext(t: Int?) {
                TODO("Not yet implemented")
            }

            override fun onError(t: Throwable?) {
                TODO("Not yet implemented")
            }

            override fun onComplete() {
                TODO("Not yet implemented")
            }
        })
    }

}