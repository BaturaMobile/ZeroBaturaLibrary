package app.baturamobile.com.designsystem

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_bottomsheet.*

class BottomNavigationDrawerFragment: BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bottomsheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navigation_view.setNavigationItemSelectedListener { menuItem ->
            // Bottom Navigation Drawer menu item clicks
            when (menuItem!!.itemId) {
                R.id.nav1 -> context!!.toast(getString(R.string.nav1_clicked))
                R.id.nav2 -> context!!.toast(getString(R.string.nav2_clicked))
                R.id.nav3 -> context!!.toast(getString(R.string.nav3_clicked))
            }
            true
        }
    }
}

fun Context.toast(text : String){
    Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
}