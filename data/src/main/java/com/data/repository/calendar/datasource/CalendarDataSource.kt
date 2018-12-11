package com.data.repository.calendar.datasource

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.provider.CalendarContract
import android.support.v4.content.ContextCompat
import android.text.TextUtils
import com.data.R
import com.domain.models.EventDto
import java.util.*

class CalendarDataSource(context: Context) {

    private val mContext: Context = context
    private val calendarName: String = mContext.getString(R.string.app_name)

    fun addEventToCalendar(event: EventDto) {
        var calendarId: Long = getCalendarId()
        if (calendarId.compareTo(-1) == 0) {
            createCalendar()
            calendarId = getCalendarId()
        }
        addEventToCalendar(event, calendarId)
    }

    @SuppressLint("MissingPermission")
    private fun getCalendarId(): Long {
        var calendarId: Long = -1
        val cursor = mContext.contentResolver.query(CalendarContract.Calendars.CONTENT_URI, null, null, null, null)
        if (cursor != null) {
            while (cursor.moveToNext()) {
                val itemCalendarName = cursor.getString(cursor.getColumnIndex(CalendarContract.Calendars.CALENDAR_DISPLAY_NAME))
                if (!TextUtils.isEmpty(itemCalendarName) && itemCalendarName == calendarName) {
                    calendarId = cursor.getLong(cursor.getColumnIndex(CalendarContract.Calendars._ID))
                    break
                }
            }
            cursor.close()
        }
        return calendarId
    }

    private fun createCalendar() {
        val accountCalendarName = mContext.getString(R.string.app_name)
        val uri = CalendarContract.Calendars.CONTENT_URI.buildUpon()
                .appendQueryParameter(CalendarContract.CALLER_IS_SYNCADAPTER, "true")
                .appendQueryParameter(CalendarContract.Calendars.ACCOUNT_NAME, accountCalendarName)
                .appendQueryParameter(CalendarContract.Calendars.ACCOUNT_TYPE, CalendarContract.ACCOUNT_TYPE_LOCAL)
                .build()
        val values = ContentValues()
        values.put(CalendarContract.Calendars.NAME, calendarName)
        values.put(CalendarContract.Calendars.CALENDAR_DISPLAY_NAME, calendarName)
        values.put(CalendarContract.Calendars.ACCOUNT_TYPE, CalendarContract.ACCOUNT_TYPE_LOCAL)
        values.put(CalendarContract.Calendars.ACCOUNT_NAME, accountCalendarName)
        values.put(CalendarContract.Calendars.OWNER_ACCOUNT, accountCalendarName)
        values.put(CalendarContract.Calendars.CALENDAR_COLOR, ContextCompat.getColor(mContext, R.color.abc_color_highlight_material))
        values.put(CalendarContract.Calendars.CALENDAR_ACCESS_LEVEL, CalendarContract.Calendars.CAL_ACCESS_OWNER)
        values.put(CalendarContract.Calendars.VISIBLE, 1)
        values.put(CalendarContract.Calendars.SYNC_EVENTS, 1)
        mContext.contentResolver.insert(uri, values)
    }

    @SuppressLint("MissingPermission")
    private fun addEventToCalendar(event: EventDto, calendarId: Long) {
        val values = ContentValues()
        values.put(CalendarContract.Events.CALENDAR_ID, calendarId.toString())
//        values.put(CalendarContract.Events.TITLE, event.listing.title)
//        values.put(CalendarContract.Events.DESCRIPTION, event.listing.description)
//        values.put(CalendarContract.Events.EVENT_LOCATION, event.listing.getFullAddress())
//        val calendar = DateUtils.utcStringToLocalCalendar(event.date, DateUtils.FORMAT_DATE_TIME)
        values.put(CalendarContract.Events.TITLE, "test")
        values.put(CalendarContract.Events.DESCRIPTION, "descr test")
        values.put(CalendarContract.Events.EVENT_LOCATION, "location test")
        val calendar = Calendar.getInstance()
        values.put(CalendarContract.Events.DTSTART, calendar.timeInMillis)
        values.put(CalendarContract.Events.DTEND, calendar.timeInMillis)
        values.put(CalendarContract.Events.EVENT_TIMEZONE, calendar.timeZone.id)
        values.put(CalendarContract.Events.ALL_DAY, 0)
        values.put(CalendarContract.Events.HAS_ALARM, 1)
        mContext.contentResolver.insert(CalendarContract.Events.CONTENT_URI, values)
    }
}