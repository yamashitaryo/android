package com.example.psyche.reminder

import android.util.Log

/**
 * Created by shunki on 2017/12/14.
 */

class ScheduleList {
    val scheduleList: MutableList<Schedule> = mutableListOf()

    fun addSchedule(schedule: Schedule){
        scheduleList.add(schedule)
    }

    fun getSchedule(year: Int, month: Int, day: Int): Schedule?{
        val index: Int? = indexOfSchedule(year, month, day)
        if (index is Int){
            return scheduleList[index]
        }else{
            return null
        }
    }

    fun changeScheduleTitle(index: Int, title: String){
        scheduleList[index].setScheduleTitle(title)
    }

    fun indexOfSchedule(year: Int, month: Int, day: Int): Int?{
        var i = 0
        while (i < scheduleList.size) {
            if (scheduleList[i].checkDate(year, month, day)){
                return i
            }
            i++
        }
        return null
    }
}