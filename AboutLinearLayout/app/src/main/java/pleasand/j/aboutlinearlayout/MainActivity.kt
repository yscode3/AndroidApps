package pleasand.j.aboutlinearlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
         * 선형 레이아웃, LinearLayout
         * 세로 또는 가로 방향으로 모든 하위 요소를 정렬하는 그룹.
         * 가중치(Weight) 가 존재, 높을 수록 더 많은 영역을 차지.
         */
    }
}