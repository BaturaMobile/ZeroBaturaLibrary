package app.baturamobile.com.designsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.empty_state_activity.*

class EmptyStateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.empty_state_activity)

        esa_empty.getButton().setOnClickListener {
            Log.d("TAG","Empty Clicked")
        }


    }
}