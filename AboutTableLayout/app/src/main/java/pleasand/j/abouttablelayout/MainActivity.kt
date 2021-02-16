package pleasand.j.abouttablelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * 표, TableLayout.
         * 격자로 뷰를 정렬, 배치할 수 있으며,
         * 하위 뷰는 layout_span 또는 layout_colum 으로 위치를 결정할 수 있음.
         * TableLayout 의 stretchColumns 은 하위 뷰의 총 개수를 지정가능.
         */
    }
}