package app.baturamobile.com.designsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
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
        bottomBar.setOnClickListener{
            val bottomNavDrawerFragment = BottomNavigationDrawerFragment()
            bottomNavDrawerFragment.show(supportFragmentManager, bottomNavDrawerFragment.tag)
           // startActivity(Intent (this,BottomBar::class.java))
        }

        bottomNavigation.setOnClickListener {
            startActivity(Intent(this, BottomNavigationActivity::class.java))
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
            startActivity(Intent(this,Dialogs::class.java))
        }
        bannerButton.setOnClickListener {
            banner.iconDrawableRes = null
            banner.show()
        }
        bannerImageButton.setOnClickListener {
            banner.iconDrawableRes = getDrawable(R.drawable.avatar_40)
            banner.show()
        }
        chips.setOnClickListener {
            startActivity(Intent(this,ChipsActivity::class.java))
        }

        selections.setOnClickListener {
            startActivity(Intent(this,Selections::class.java))
        }

        empty.setOnClickListener {
            startActivity(Intent(this,EmptyStateActivity::class.java))
        }

        banner.setRightButtonAction {
            banner.dismiss()
        }

    }
}
