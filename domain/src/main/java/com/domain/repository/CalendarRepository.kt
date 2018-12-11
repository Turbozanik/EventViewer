package com.domain.repository

import com.domain.models.EventDto
import io.reactivex.Flowable

interface CalendarRepository {

    fun addEventToCalendar(eventDto: EventDto): Flowable<Any>

}