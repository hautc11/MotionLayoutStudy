package hautc.study.samplemotionlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import androidx.core.view.GestureDetectorCompat

class AnimatorSampleActivity : AppCompatActivity() {

    private lateinit var mDetector: GestureDetectorCompat
    private val mSimpleGestureListener = SimpleGestureListener()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animator_sample)

        mSimpleGestureListener.setListener(object : SimpleGestureListener.Listener {
            override fun onScrollUp() {
                findViewById<ImageView>(R.id.ivBrightness).visibility = View.VISIBLE
                findViewById<ImageView>(R.id.ivBluetooth).visibility = View.VISIBLE
                findViewById<ImageView>(R.id.ivWallet).visibility = View.VISIBLE
            }

            override fun onScrollDown() {
                findViewById<ImageView>(R.id.ivBrightness).visibility = View.GONE
                findViewById<ImageView>(R.id.ivBluetooth).visibility = View.GONE
                findViewById<ImageView>(R.id.ivWallet).visibility = View.GONE

            }

        })

        mDetector = GestureDetectorCompat(this, mSimpleGestureListener)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        mDetector.onTouchEvent(event)
        return super.onTouchEvent(event)
    }
}