package app.baturamobile.com.designsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_toast.*

class ToastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)


        normal_snakbar.setOnClickListener {
            Snackbar.make(toast_container,"Greyhound divisively hello",Snackbar.LENGTH_SHORT).show()
        }
        two_lines_snackbar.setOnClickListener {
            Snackbar.make(toast_container,"Greyhound divisively hello coldly wonderfully marginally far upon excluding.",Snackbar.LENGTH_SHORT).show()
        }
        button_snackbar.setOnClickListener {
            Snackbar.make(toast_container,"Greyhound divisively hello coldly wonderfully marginally far upon.",Snackbar.LENGTH_SHORT)
                .setAction("Button", View.OnClickListener {

                }).show()
        }

        twolines_button_snackbar.setOnClickListener {

            Snackbar.make(toast_container,"Greyhound divisively hello coldly wonderfully marginally far upon.",Snackbar.LENGTH_SHORT)
                .setAction("Button", View.OnClickListener {

                }).show()
        }


    }
}
