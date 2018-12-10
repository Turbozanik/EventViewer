package com.data.repository.calendar

import android.content.Context
import com.data.R
import com.data.repository.pojo.Event
import io.reactivex.Flowable

class CalendarDataSource constructor(private val mContext: Context) {

    private val calendarName: String = mContext.getString(R.string.app_name)

    fun addShowingToCalendar(showing: Event): Flowable<Any> {
//        return Flowable.create(object : Observable.OnSubscribe<Any>() {
//            fun call(subscriber: Subscriber<in Any>) {
//                var calendarId = getCalendarId()
//                if (calendarId == -1) {
//                    createCalendar()
//                    calendarId = getCalendarId()
//                }
//                addShowingToCalendar(showing, calendarId)
//                subscriber.onNext(null)
//                subscriber.onCompleted()
//            }
//        })
        return Flowable.just("");
    }

    private fun getCalendarId(): Long {
//        var calendarId: Long = -1
//        val cursor = context.contentResolver.query(CalendarContract.Calendars.CONTENT_URI, null, null, null, null)
//        if (cursor != null) {
//            while (cursor.moveToNext()) {
//                val itemCalendarName = cursor.getString(cursor.getColumnIndex(CalendarContract.Calendars.CALENDAR_DISPLAY_NAME))
//                if (!TextUtils.isEmpty(itemCalendarName) && itemCalendarName == calendarName) {
//                    calendarId = cursor.getLong(cursor.getColumnIndex(CalendarContract.Calendars._ID))
//                    break
//                }
//            }
//            cursor.close()
//        }
//        return calendarId
        return 1
    }

    private fun createCalendar() {
//        val accountCalendarName = context.getString(R.string.account_calendar_name)
//        val uri = CalendarContract.Calendars.CONTENT_URI.buildUpon()
//                .appendQueryParameter(CalendarContract.CALLER_IS_SYNCADAPTER, "true")
//                .appendQueryParameter(CalendarContract.Calendars.ACCOUNT_NAME, accountCalendarName)
//                .appendQueryParameter(CalendarContract.Calendars.ACCOUNT_TYPE, CalendarContract.ACCOUNT_TYPE_LOCAL)
//                .build()
//        val values = ContentValues()
//        values.put(CalendarContract.Calendars.NAME, calendarName)
//        values.put(CalendarContract.Calendars.CALENDAR_DISPLAY_NAME, calendarName)
//        values.put(CalendarContract.Calendars.ACCOUNT_TYPE, CalendarContract.ACCOUNT_TYPE_LOCAL)
//        values.put(CalendarContract.Calendars.ACCOUNT_NAME, accountCalendarName)
//        values.put(CalendarContract.Calendars.OWNER_ACCOUNT, accountCalendarName)
//        values.put(CalendarContract.Calendars.CALENDAR_COLOR, ContextCompat.getColor(context, R.color.black))
//        values.put(CalendarContract.Calendars.CALENDAR_ACCESS_LEVEL, CalendarContract.Calendars.CAL_ACCESS_OWNER)
//        values.put(CalendarContract.Calendars.VISIBLE, 1)
//        values.put(CalendarContract.Calendars.SYNC_EVENTS, 1)
//        context.contentResolver.insert(uri, values)
    }

    private fun addShowingToCalendar(showing: Event, calendarId: Long) {
//        val values = ContentValues()
//        values.put(CalendarContract.Events.CALENDAR_ID, calendarId.toString())
//        values.put(CalendarContract.Events.TITLE, showing.listing.title)
//        values.put(CalendarContract.Events.DESCRIPTION, showing.listing.description)
//        values.put(CalendarContract.Events.EVENT_LOCATION, showing.listing.getFullAddress())
//        val calendar = DateUtils.utcStringToLocalCalendar(showing.date, DateUtils.FORMAT_DATE_TIME)
//        values.put(CalendarContract.Events.DTSTART, calendar.getTimeInMillis())
//        values.put(CalendarContract.Events.DTEND, calendar.getTimeInMillis())
//        values.put(CalendarContract.Events.EVENT_TIMEZONE, calendar.getTimeZone().getID())
//        values.put(CalendarContract.Events.ALL_DAY, 0)
//        values.put(CalendarContract.Events.HAS_ALARM, 1)
//        context.contentResolver.insert(CalendarContract.Events.CONTENT_URI, values)
    }
}