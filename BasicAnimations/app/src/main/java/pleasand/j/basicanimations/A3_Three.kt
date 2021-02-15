package pleasand.j.basicanimations

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.concurrent.thread

class A3_Three : AppCompatActivity() {
    private lateinit var contentV: View
    private lateinit var loadingV: View
    private var shortAnimationDuration: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a3_three)

        /**
         * interpolator 속성
         * linear : 등속 (일정한 속도로 진행)
         * accelerate : 가속 (느리다가 빨라짐)
         * anticipate : 당김 (시작시 조금 당겼다가 시작)
         * bounce : 바운스 (마지막에 약간 통통 튐)
         * cycle : 순환 (진행이 끝나면 다시 역재생)
         * decelerate : 감속 (빠르다가 느려짐)
         * overshoot : 초과 (약간 더 진행되었다가 돌아옴)

         * accelerate_decelerate : 가속 + 감속
         * anticipate_overshoot : 당김 + 초과
         */

        contentV = findViewById(R.id.content)
        loadingV = findViewById(R.id.loading_spinner)

        contentV.visibility = View.GONE
        shortAnimationDuration = resources.getInteger(android.R.integer.config_shortAnimTime)

        thread(start = true) {
            Thread.sleep(2000)

            runOnUiThread {
                crossfade()
            }
        }

        val btn_a3 = findViewById<Button>(R.id.btn_a3)
        btn_a3.setOnClickListener {
            startActivity(Intent(this, A3_Three::class.java))
        }
    }

    private fun addItem() {
        val container = findViewById<ConstraintLayout>(R.id.container)
        val textV:Button = Button(this)
        textV.text = "버튼!"

        container.addView(textV, 0)
    }

    private fun crossfade() {
        contentV.apply {
            // Set the content view to 0% opacity but visible, so that it is visible
            // (but fully transparent) during the animation.
            alpha = 0f
            visibility = View.VISIBLE

            // Animate the content view to 100% opacity, and clear any animation
            // listener set on the view.
            animate()
                    .alpha(1f)
                    .setDuration(shortAnimationDuration.toLong())
                    .setListener(null)
        }
        // Animate the loading view to 0% opacity. After the animation ends,
        // set its visibility to GONE as an optimization step (it won't
        // participate in layout passes, etc.)
        loadingV.animate()
                .alpha(0f)
                .setDuration(shortAnimationDuration.toLong())
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        loadingV.visibility = View.GONE
                    }
                })
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}