package app.baturamobile.com.designsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import kotlinx.android.synthetic.main.activity_toolbar.*
import android.widget.ArrayAdapter
import android.R.id
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.SearchAutoComplete



class Toolbar : AppCompatActivity() {

    val data = arrayOf(
        "Emmanuel",
        "Olayemi",
        "Henrry",
        "Mark",
        "Steve",
        "Ayomide",
        "David",
        "Anthony",
        "Adekola",
        "Adenuga"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)

        setSupportActionBar(toolbar)

        //Botón atras activado
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.first_menu,menu) //Pintado del menú


        //Sacamos el componentes SearcbAutoComplete
        val search = menu.findItem(R.id.action_search).actionView as SearchView

        val searchAutoComplete =
            search.findViewById(androidx.appcompat.R.id.search_src_text) as SearchAutoComplete

        val dataAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, data)
        //Injectamos el adaptador con el layout correspondiente
        searchAutoComplete.setAdapter(dataAdapter)
        return true
    }
}
