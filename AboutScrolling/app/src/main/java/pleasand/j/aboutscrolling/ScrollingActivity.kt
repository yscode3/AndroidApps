package pleasand.j.aboutscrolling

import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = title
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        /**
         * CollapsingToolbarLayout scrollFlags 속성
         * NestedScrollView 에서 스크롤 상태를 CollapsingToolbarLayout 에 알려줌
         *
         * scroll | enterAlwaysCollapsed : 맨위로 스크롤 뒨 후에만 확장됨
         * scroll | enterAlways : 스크롤이 어디에 있든 스크롤 다운 시 바로 확장되며 툴바가 사라짐(전체화면으로 전환)
         * scroll | exitUntilCollapsed 툴바가 상단에 유지되고 스크롤시 사라지지 않음
         * 맨 위에 도달하면 툴바만 확장함 (enterAlwaysCollapsed 와 비슷하게 동작)
         */

        /**
         * CollapsingToolbarLayout 에 들어가는 요소의 속성
         * app:layout_collapseMode="parallax"
         * none -> 일반 View처럼 작동
         * parallax -> AppBar 가 줄어드는 동안 작동
         * pin -> 상단에 고정
         *
         * collapseParallaxMultiplier 와 조합해서 사용가능, 기본값 0.5
         */

        /**
         * AppBarLayout 속성
         * fitsSystemWindows : 뷰가 차지할 수 있는 영역을 상태바 및 소프트키 영역을 제외한 영역까지 확장해줌
         */

        /**
         * Contents 가 되는 Root Layout 은 androidx.core.widget.NestedScrollView 여야 한다.
         * app:layout_behavior="@string/appbar_scrolling_view_behavior" 속성 정의 (필수)
         */

        //리싸이클러뷰
        val adapterForTheList = TheListAdapter()
        with(adapterForTheList) {
            addProfile(TheListData("김응수", R.drawable.ic_alt24, "마포대교는 무너졌냐 이새끼야?"))
            addProfile(TheListData("김혜수", R.drawable.ic_alt24, "나 이화여대 나온 여자야~!"))
            addProfile(TheListData("나영석", R.drawable.ic_dissatisfied24, "땡!"))
            addProfile(TheListData("마동석", R.drawable.ic_alt24, "진실의 방으로"))
            addProfile(TheListData("장윤정", R.drawable.ic_dissatisfied24, "어머나 이러지마세요~"))
            addProfile(TheListData("조승우", R.drawable.ic_alt24, "왜이래 아마추어 같이?"))
            addProfile(TheListData("신세경", R.drawable.ic_dissatisfied24, "어려우니까 풀고 싶고, 모르니까 알고 싶고"))
            addProfile(TheListData("박찬호", R.drawable.ic_alt24, "제가 LA에 있었던 일부터 말씀드려야 겠네요."))
            addProfile(TheListData("강호동", R.drawable.ic_alt24, "무슨129?? 안절거워"))
            addProfile(TheListData("유재석", R.drawable.ic_alt24, "광수야 너 왜 예능회비 안내냐?"))
            addProfile(TheListData("장동민", R.drawable.ic_alt24, "이건 이길 수 없는 게임이야"))
            addProfile(TheListData("조규현", R.drawable.ic_dissatisfied24, "내 별명은 조정뱅이 젠장"))
            addProfile(TheListData("피오", R.drawable.ic_alt24, "화내지마"))
            addProfile(TheListData("이수근", R.drawable.ic_alt24, "집에 온다 했잖아요~"))
            addProfile(TheListData("은지원", R.drawable.ic_alt24, "야 너 겜 좀 하냐?"))
            addProfile(TheListData("한효주", R.drawable.ic_dissatisfied24, "망했다"))
        }

        //검색 바 & 이미지 박기
        val theList = findViewById<RecyclerView>(R.id.theList)
        val linearLayout = LinearLayoutManager(this)
        theList.adapter = adapterForTheList
        theList.layoutManager = linearLayout
        adapterForTheList.notifyDataSetChanged()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}