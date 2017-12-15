package com.example.psyche.reminder

/**
 * Created by shunki on 2017/12/15.
 */

class ScheduleManager {
    val sl = ScheduleList()

    fun getScheduleTitle(year: Int, month: Int, day: Int): String {
        val schedule = sl.getSchedule(year, month, day)
        if (schedule is Schedule) {
            return schedule.title
        }else{
            return ""
        }
    }

    fun setSchedule(title: String, year: Int, month: Int, day: Int){
        val schedule = Schedule(year, month, day, title)
        val scheduleIndex: Int? = sl.indexOfSchedule(year, month, day)
        if (scheduleIndex is Int) {
            sl.changeScheduleTitle(scheduleIndex, title)
        }else{
            sl.addSchedule(schedule)
        }
    }
}