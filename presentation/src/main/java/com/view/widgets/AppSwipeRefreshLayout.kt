import android.content.Context
import android.support.v4.widget.SwipeRefreshLayout
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewConfiguration
import com.view.R

class AppSwipeRefreshLayout(context: Context, attrs: AttributeSet) : SwipeRefreshLayout(context,
                                                                                        attrs) {

    private val touchSlop: Int
    private var prevX: Float = 0.toFloat()

    init {
        setProgressViewEndTarget(true,
                                 resources.getDimension(R.dimen.swipe_refresh_end_offset).toInt())
        touchSlop = ViewConfiguration.get(context).scaledTouchSlop
    }

    fun setProgress(needShow: Boolean?): Boolean {
        if (isRefreshing) {
            if (needShow === java.lang.Boolean.FALSE) {
                isRefreshing = false
            }
            return true
        }
        return false
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> prevX = MotionEvent.obtain(event).x
            MotionEvent.ACTION_MOVE -> {
                val eventX = event.x
                val xDiff = Math.abs(eventX - prevX)
                if (xDiff > touchSlop) {
                    return false
                }
            }
        }
        return super.onInterceptTouchEvent(event)
    }

}