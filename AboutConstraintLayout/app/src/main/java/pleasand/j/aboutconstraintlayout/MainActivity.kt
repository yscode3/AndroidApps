package pleasand.j.aboutconstraintlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * RelativeLayout 보다 유연하면서도 중첩없이 더 복잡한 레이아웃을 만들 수 있음
         * 규칙
         * 1. 모든 보기에는 가로/세로 하나씩 두 개 이상의 제약조건이 필요
         * 2. 같은 평면을 공유하는 제약조건 핸들과 앵커 포인트 사이에만 제약조건을 만들 수 있음
         * 따라서 보기의 세로 평면은 다른 세로 평면으로만 제한될 수 있으며, 기준은 다른 기준으로 제한될 수 있음
         * 3. 각 제약조건 핸들은 하나의 제약조건에만 사용할 수 있지만, 동일한 앵커 포인트에 여러 개의 제약조건을 만들 수 있음.
         */


    }
}