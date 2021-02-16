package pleasand.j.aboutframelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * FramLayout
         * 하위 뷰를 중첩으로 배치, 하나의 뷰를 최상위에 보여줌.
         * ViewPager 및 TabLayout 에 대표적으로 사용됨.
         *
         * 이때, 터치 이벤트를 처리해주지 않으면, 하위 뷰까지 전달될 수 있음.
         * onTouchEventListener 를 설정해주면 됨.
         */

        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        imageView2.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                //true 로 설정하면, 하위 레이아웃에 이벤트를 전달하지 않음
                return true
            }
        })
    }
}