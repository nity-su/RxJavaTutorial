package com.anlyn.rxjavatutorial.rxjava.map

import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.functions.Function

object Map{
    private fun numberList():List<Int>{
        return listOf<Int>(65,66,67)
    }

    fun get(){
        Observable.fromCallable { numberList() }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                //Function reactive Function<T,R>
               .map(object : Function<List<Int>,List<Int>>{
                   override fun apply(t: List<Int>): List<Int> {
                       var list = mutableListOf<Int>()
                       for(i in t){
                           var value = i
                           if(i%5==0)
                               value+=5
                           list.add(value)
                       }
                      return list.filter { it>66 }
                   }
               }).subscribe({
                   Log.d(Map::class.simpleName,it.toString())
                },{

                })
    }
}