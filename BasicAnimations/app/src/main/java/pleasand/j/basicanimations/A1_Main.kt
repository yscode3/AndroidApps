package pleasand.j.basicanimations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class A1_Main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a1_main)

        /**
         * 트윈 애니메이션
         * 이동, 투명, 확장, 회전
         *
         * 반복 설정
         * repatcount = "infinite" -> 무한으로 반복
         * repeatMode = "restart" -> 반복 모드를 restart
         * repeatMode = "reverse" -> 회전 방향을 바꿈
         */

        val goBasic = findViewById<Button>(R.id.goBasic)
        goBasic.setOnClickListener {
            startActivity(Intent(this, A2_Two::class.java))
        }

        val goInterpolator = findViewById<Button>(R.id.goInterpolator)
        goInterpolator.setOnClickListener {
            startActivity(Intent(this, A3_Three::class.java))
        }
    }
}