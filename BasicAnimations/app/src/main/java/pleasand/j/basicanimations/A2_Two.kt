package pleasand.j.basicanimations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.*
import android.widget.*
import kotlin.math.exp

class A2_Two : AppCompatActivity() {
    private lateinit var interpolator:Interpolator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a2_two)

        val spinnerData = resources.getStringArray(R.array.interpolator)
        val spinnerAdpater = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinnerData)
        val spinner = findViewById<Spinner>(R.id.interpolateSpinner)
        spinner.adapter = spinnerAdpater

        /**
         * interpolator 속성
         * linear : 등속 (일정한 속도로 진행)
         * accelerate : 가속 (시작지점에서 가속)
         * anticipate : 당김 (시작시 조금 당겼다가 시작)
         * bounce : 바운스 (종료시점에 공이 튀듯이 약간 통통 튐)
         * cycle : 순환 (종료시점에 다시 시작지점에서 종료시점으로 이동)
         * decelerate : 감속 (종료시점에 가속)
         * overshoot : 초과 (약간 더 진행되었다가 돌아옴)
         * accelerate_decelerate : 점차 빨라지다가 종료시점에 감소
         * anticipate_overshoot : 당김 + 초과
         */

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when(position) {
                    0 -> setInterPolator(LinearInterpolator(), "일정한 속도로 진행")
                    1 -> setInterPolator(AccelerateInterpolator(), "점점 가속")
                    2 -> setInterPolator(AnticipateInterpolator(), "시작지점에서 조금 당겼다가 시작")
                    3 -> setInterPolator(BounceInterpolator(), "종료시점에 공이 튀듯이 통통 튐")
                    4 -> setInterPolator(CycleInterpolator(1f), "종료시점에 다시 시작지점에서 종료시점으로 이동")
                    5 -> setInterPolator(DecelerateInterpolator(), "종료시점에 감속")
                    6 -> setInterPolator(OvershootInterpolator(), "약간 더 진행되었다가 돌아옴")
                    7 -> setInterPolator(AccelerateDecelerateInterpolator(), "점차 빨라지다가 종료시점에 감소")
                    8 -> setInterPolator(AnticipateOvershootInterpolator(), "당김 + 초과")
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                setInterPolator(LinearInterpolator(), "종료시점에 공이 튀듯이 통통 튐")
            }
        }
    }

    private fun setInterPolator(polator: Interpolator, _explain: String) {
        val explain = findViewById<TextView>(R.id.explain)
        explain.text = _explain
        interpolator = polator
    }

    //이동 애니메이션
    fun translateStart(view: View) {
        val translateImg = findViewById<ImageView>(R.id.translateImg)
        val animTranslate = AnimationUtils.loadAnimation(this, R.anim.translate_ani)
        animTranslate.interpolator = interpolator
        translateImg.apply {
            startAnimation(animTranslate)
        }
    }

    //투명 애니메이션
    fun alphaStart(view: View) {
        val alphaImg = findViewById<ImageView>(R.id.alphaImg)
        val animAlpha = AnimationUtils.loadAnimation(this, R.anim.alpha_ani)
        animAlpha.interpolator = interpolator
        alphaImg.apply {
            startAnimation(animAlpha)
        }
    }

    //회전 애니메이션
    fun rotateStart(view: View) {
        val rotateImg = findViewById<ImageView>(R.id.rotateImg)
        val animLotate = AnimationUtils.loadAnimation(this, R.anim.rotate_ani)
        animLotate.interpolator = interpolator
        rotateImg.apply {
            startAnimation(animLotate)
        }
    }

    //확장 애니메이션
    fun scaleStart(view: View) {
        val scaleImg = findViewById<ImageView>(R.id.scaleImg)
        val animScale = AnimationUtils.loadAnimation(this, R.anim.scale_ani)
        animScale.interpolator = interpolator
        scaleImg.apply {
            startAnimation(animScale)
        }
    }

    //Set 애니메이션
    fun setStart(view: View) {
        val setImg = findViewById<ImageView>(R.id.setImg)
        val animSet = AnimationUtils.loadAnimation(this, R.anim.set_ani)
        animSet.interpolator = interpolator
        setImg.apply {
            startAnimation(animSet)
        }
    }
}