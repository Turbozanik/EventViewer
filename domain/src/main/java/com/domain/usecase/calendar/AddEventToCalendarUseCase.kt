package com.domain.usecase.calendar

import com.domain.models.EventDto
import com.domain.repository.CalendarRepository
import com.domain.usecase.UseCase
import io.reactivex.Flowable

class AddEventToCalendarUseCase(calendarRepository: CalendarRepository) : UseCase<EventDto, Any>() {

    private val mCalendarRepository: CalendarRepository = calendarRepository

    override fun buildFlowable(params: EventDto?): Flowable<Any> {
        params?.let {
            return mCalendarRepository.addEventToCalendar(params)
        }
    }

    override val isParamsRequired: Boolean
        get() = true
}