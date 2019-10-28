package app.baturamobile.com.designsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bottom_navigation.*

class BottomNavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        bottom_navigation.getOrCreateBadge(R.id.app_bar_mail)

        bottom_navigation.getOrCreateBadge(R.id.app_bar_delete)?.number = 99

        bottom_navigation.getOrCreateBadge(R.id.app_bar_archieve)?.number = 1200
    }
}
