package app.baturamobile.com.designsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.baturamobile.utils.collapsePanels
import com.baturamobile.utils.expandNotificationPanel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        colors.setOnClickListener {
            startActivity(Intent(this,TypeColorActivity::class.java))
        }
        buttons.setOnClickListener {
            startActivity(Intent(this,Buttons::class.java))
        }

        texts.setOnClickListener {
            startActivity(Intent (this,LettersActivity::class.java))
        }

        topbar.setOnClickListener {
            startActivity(Intent (this,Toolbar::class.java))
        }
        bottomBar.setOnClickListener {
            startActivity(Intent (this,BottomBar::class.java))
        }

        bottomNavigation.setOnClickListener {
            startActivity(Intent(this,BottomNavigationActivity::class.java))
        }

        toast.setOnClickListener {
            startActivity(Intent(this,ToastActivity::class.java))
        }
        forms.setOnClickListener {
            startActivity(Intent(this,FormsActivity::class.java))
        }

        lists.setOnClickListener {
            startActivity(Intent(this,ListsActivity::class.java))
        }

        dialogs.setOnClickListener {
            expandNotificationPanel()
            handler.postDelayed({
                collapsePanels()
            },1000)
            //startActivity(Intent(this,Dialogs::class.java))
        }



    }
}
