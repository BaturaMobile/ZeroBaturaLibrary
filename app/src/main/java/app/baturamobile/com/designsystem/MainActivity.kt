package app.baturamobile.com.designsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        colors.setOnClickListener {
            startActivity(Intent(this,TypeColorActivity::class.java))
        }
        buttons.setOnClickListener {
            startActivity(Intent(this,Buttons::class.java))
        }
    }
}
