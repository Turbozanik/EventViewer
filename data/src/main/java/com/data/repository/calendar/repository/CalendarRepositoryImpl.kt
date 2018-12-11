package com.data.repository.calendar.repository

import com.data.repository.calendar.datasource.CalendarDataSource
import com.domain.models.EventDto
import com.domain.repository.CalendarRepository
import io.reactivex.Flowable

class CalendarRepositoryImpl(calendarDataSource: CalendarDataSource) : CalendarRepository {

    private val mCalendarDataSource: CalendarDataSource = calendarDataSource

    override fun addEventToCalendar(eventDto: EventDto): Flowable<Any> {
        return Flowable.just(mCalendarDataSource.addEventToCalendar(eventDto))
    }

}