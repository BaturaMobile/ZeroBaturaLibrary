package app.baturamobile.com.designsystem

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_bottom_bar.*
import kotlinx.android.synthetic.main.activity_bottom_bar_container.*
import kotlinx.android.synthetic.main.fragment_bottomsheet.*
import app.baturamobile.com.designsystem.R.drawable.*
import app.baturamobile.com.designsystem.R.menu.bottomappbar_menu_primary
import app.baturamobile.com.designsystem.R.menu.bottomappbar_menu_secondary
import com.google.android.material.floatingactionbutton.FloatingActionButton


class BottomBar : AppCompatActivity() {

    private var currentFabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_bar)

        setSupportActionBar(bottom_app_bar)

        val addVisibilityChanged: FloatingActionButton.OnVisibilityChangedListener = object : FloatingActionButton.OnVisibilityChangedListener() {
            override fun onHidden(fab: FloatingActionButton?) {
                super.onHidden(fab)
                bottom_app_bar.toggleFabAlignment()
                bottom_app_bar.replaceMenu(
                    if(currentFabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER) bottomappbar_menu_secondary
                    else bottomappbar_menu_primary
                )
                fab?.setImageDrawable(
                    if(currentFabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER) getDrawable(baseline_reply_white_24)
                    else getDrawable(baseline_add_white_24)
                )
                fab?.show()
            }
        }

        toggle_fab_alignment_button.setOnClickListener {
            fab.hide(addVisibilityChanged)
            invalidateOptionsMenu()
            bottom_app_bar.navigationIcon = if (bottom_app_bar.navigationIcon != null) null
            else getDrawable(baseline_menu_white_24)
            when(screen_label.text) {
                getString(R.string.primary_screen_text) -> screen_label.text = getString(R.string.secondary_sceen_text)
                getString(R.string.secondary_sceen_text) -> screen_label.text = getString(R.string.primary_screen_text)
            }
        }

        fab.setOnClickListener {
            displayMaterialSnackBar()
        }


    }


    private fun BottomAppBar.toggleFabAlignment() {
        currentFabAlignmentMode = fabAlignmentMode
        fabAlignmentMode = currentFabAlignmentMode.xor(1)
    }

    private fun displayMaterialSnackBar() {
        val marginSide = 0
        val marginBottom = 550
        val snackbar = Snackbar.make(
            coordinatorLayout2,
            "FAB Clicked",
            Snackbar.LENGTH_LONG
        ).setAction("UNDO") {  }
        // Changing message text color
        snackbar.setActionTextColor(ContextCompat.getColor(this, R.color.colorSnackbarButton))
        val snackbarView = snackbar.view
        val params = snackbarView.layoutParams as CoordinatorLayout.LayoutParams

        params.setMargins(
            params.leftMargin + marginSide,
            params.topMargin,
            params.rightMargin + marginSide,
            params.bottomMargin + marginBottom
        )

        snackbarView.layoutParams = params
        snackbar.show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.bottomappbar_menu_primary, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            android.R.id.home -> {
                val bottomNavDrawerFragment = BottomNavigationDrawerFragment()
                bottomNavDrawerFragment.show(supportFragmentManager, bottomNavDrawerFragment.tag)
            }
        }
        return true
    }


}
