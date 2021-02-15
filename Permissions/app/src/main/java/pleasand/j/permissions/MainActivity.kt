package pleasand.j.permissions

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * 설치시간 권한
         * 일반 권한, 서명 권한
         * 일반 권한 - 사용자 개인 정보 보호와 다른 앱의 작업에 거의 영향이 미치지 않음
         * 서명 권한 - 앱에서 다른 앱이 정의한 서명 권한을 선언하고 두 앱이 동일한 인증서로 서명되었다면, 시스템에서 설치 시간에 첫 번째 앱에 권한을 부여함.
         */

        /**
         * 런타임 권한 (위험 권한)
         * 제한된 데이터에 추가로 액세스하고, 다른 앱에 조금 더 큰 영향을 미치는 작업을 실행.
         * 사용자에게 런타임 권한 요청을 함.
         */

        /**
         * 특별 권한
         * 특정 앱 작업에 상응함.
         * 플랫폼과 OEM만이 특별 권한을 정의할 수 있음.
         * 일반적으로 다른 앱 위에 그리기와 같이 특히 강력한 작업에 대한 액세스를 보호하기 위해 권한을 정의.
         */

        /** 코드에서 위험권한 처리하기
         * 1단계 : 권한에 대한 사용자 승인 확인 (이전에 승인했는지)
         * 2단계 : 사용자에게 승인 요청
         * 3단계 : 사용자 승인 후 처리
         */

        val btnCamera = findViewById<Button>(R.id.btnCamera)
        btnCamera.setOnClickListener {
            checkPermission()
        }
    }

    //권한 확인
    fun checkPermission() {
        val cameraPermission = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
        if (cameraPermission == PackageManager.PERMISSION_GRANTED) {
            //승인된 상태일 경우 진행
            startProcess()
        }
        else {
            //승인되지 않았다면 권한 요청 프로세스 진행
            requestPermission()
        }
    }

    //카메라 실행
    private fun startProcess() {
        Toast.makeText(this, "카메라를 실행합니다", Toast.LENGTH_SHORT).show()
    }

    //권한 요청
    private fun requestPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), 99)
    }

    //권한 처리
    //다중 권한 처리
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            99 -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startProcess()
                }
                else {
                    Log.d("HOME", "권한 없음")

                }
            }
        }
    }
}