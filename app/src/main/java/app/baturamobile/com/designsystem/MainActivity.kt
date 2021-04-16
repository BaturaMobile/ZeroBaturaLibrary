package app.baturamobile.com.designsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.annotation.DrawableRes
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_component_layout.view.*

class MainActivity : AppCompatActivity() {

    val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        textView68.setOnClickListener {
            startActivity(Intent (this,BottomBar::class.java))
        }
        setComponent(R.drawable.ic_icon_overview_type,"Type").setOnClickListener {
            startActivity(Intent (this,LettersActivity::class.java))
        }
        setComponent(R.drawable.ic_icon_overview_color,"Color").setOnClickListener {
            startActivity(Intent(this,TypeColorActivity::class.java))
        }
        setComponent(R.drawable.ic_icon_overview_button,"Button").setOnClickListener {
            startActivity(Intent(this,Buttons::class.java))
        }
        setComponent(R.drawable.ic_icon_overview_top_bar,"TopBar").setOnClickListener {
            startActivity(Intent (this,Toolbar::class.java))
        }
        setComponent(R.drawable.ic_icon_overview_bottom_bar,"BottomBar").setOnClickListener {
            startActivity(Intent (this,BottomNavigationActivity::class.java))
        }
        setComponent(R.drawable.ic_icon_overview_search_bar,"SearchBar").setOnClickListener {
            startActivity(Intent (this,Toolbar::class.java))
        }
        setComponent(R.drawable.ic_icon_overview_form,"TextField").setOnClickListener {
            startActivity(Intent (this,FormsActivity::class.java))
        }
        setComponent(R.drawable.ic_icon_overview_snackbar,"SnackBar").setOnClickListener {
            startActivity(Intent(this,ToastActivity::class.java))
        }
        setComponent(R.drawable.ic_icon_overview_banner,"Banner").setOnClickListener {
            banner.iconDrawableRes = null
           banner.show()
        }
        setComponent(R.drawable.ic_icon_overview_dialog,"Dialog").setOnClickListener {
            startActivity(Intent(this,Dialogs::class.java))
        }
        setComponent(R.drawable.ic_icon_overview_list,"List").setOnClickListener {
            startActivity(Intent(this,ListsActivity::class.java))
        }
        setComponent(R.drawable.ic_icon_overview_chip,"Chip").setOnClickListener {
            startActivity(Intent(this,ChipsActivity::class.java))

        }
        setComponent(R.drawable.ic_icon_overview_selection,"SelectionControl").setOnClickListener {
            startActivity(Intent(this,Selections::class.java))
        }
        setComponent(R.drawable.ic_icon_overview_sheets,"BottomSheets").setOnClickListener {
            val bottomNavDrawerFragment = BottomNavigationDrawerFragment()
            bottomNavDrawerFragment.show(supportFragmentManager, bottomNavDrawerFragment.tag)
        }
        setComponent(R.drawable.ic_icon_overview_empty,"EmptyState").setOnClickListener {
            startActivity(Intent(this,EmptyStateActivity::class.java))
        }
        /*colors.setOnClickListener {
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
        }*/

        banner.setRightButtonAction {
            banner.dismiss()
        }

    }

    fun setComponent(@DrawableRes iconRes : Int, text : String) : View {
        val view = View.inflate(this,R.layout.main_component_layout,null)
        view.mcl_image.setImageResource(iconRes)

        view.mcl_text.text = text
        container.addView(view)

        return view;
    }
}
