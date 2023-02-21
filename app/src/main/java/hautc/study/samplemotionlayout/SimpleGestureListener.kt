package hautc.study.samplemotionlayout

import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import kotlin.math.atan2

class SimpleGestureListener : GestureDetector.SimpleOnGestureListener() {
    private var mListener: Listener? = null
    override fun onDown(e: MotionEvent): Boolean {
        return true
    }

    override fun onScroll(
        e1: MotionEvent,
        e2: MotionEvent,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        if (mListener == null) return true
        val angle = Math.toDegrees(atan2((e1.y - e2.y).toDouble(), (e2.x - e1.x).toDouble()))
        if (angle < -45 && angle >= -135) {
            Log.d("xxx", "onScroll: UP")
            mListener!!.onScrollUp()
            return true
        }

        if (angle > 45 && angle <= 135) {
            Log.d("xxx", "onScroll: DOWN")
            mListener!!.onScrollDown()
            return true
        }
        return false
    }

    fun setListener(mListener: Listener?) {
        this.mListener = mListener
    }

    interface Listener {
        fun onScrollUp()

        fun onScrollDown()
    }
}