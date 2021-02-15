package pleasand.j.basicanimations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView

class A2_Two : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a2_two)

        //이동 애니메이션
        val translateImg = findViewById<ImageView>(R.id.translateImg)
        val animTranslate = AnimationUtils.loadAnimation(this, R.anim.translate_ani)
        translateImg.apply {
            startAnimation(animTranslate)
        }

        //투명 애니메이션
        val alphaImg = findViewById<ImageView>(R.id.alphaImg)
        val animAlpha = AnimationUtils.loadAnimation(this, R.anim.alpha_ani)
        alphaImg.apply {
            startAnimation(animAlpha)
        }

        //회전 애니메이션
        val rotateImg = findViewById<ImageView>(R.id.rotateImg)
        val animLotate = AnimationUtils.loadAnimation(this, R.anim.rotate_ani)
        rotateImg.apply {
            startAnimation(animLotate)
        }

        //확장 애니메이션
        val scaleImg = findViewById<ImageView>(R.id.scaleImg)
        val animScale = AnimationUtils.loadAnimation(this, R.anim.scale_ani)
        scaleImg.apply {
            startAnimation(animScale)
        }

        //Set 애니메이션
        val setImg = findViewById<ImageView>(R.id.setImg)
        val animSet = AnimationUtils.loadAnimation(this, R.anim.set_ani)
        setImg.apply {
            startAnimation(animSet)
        }
    }
}