package com.example.psyche.reminder

/**
 * Created by shunki on 2017/12/14.
 */

class Schedule(y:Int, m:Int, d:Int, title:String) {
    var year = y
    var month = m
    var day = d
    var title: String = title

    fun checkDate(yCheck:Int, mCheck:Int, dCheck:Int): Boolean {
       if (year == yCheck && month == mCheck && day == dCheck) {
           return true
       }else{
           return false
       }
    }

    fun setScheduleTitle(t:String){
        title = t
    }
}