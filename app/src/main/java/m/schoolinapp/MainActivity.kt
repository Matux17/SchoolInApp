package m.schoolinapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner

/*
This is the main screen
* Text (???)
* Background (???)
* Start button (Go to Levels page)
* Credits button (Go to Credits page)
* Copyright
 */
//class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener
class MainActivity : AppCompatActivity() {

    private var language = Language

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Lang()
    }

    //Start button

    fun btStart(v: View) {
        val intent = Intent(this, Levels::class.java)
        startActivity(intent)
    }

    //Credits button

    fun openCredits(v: View) {
        val intent = Intent(this, Credits::class.java)
        startActivity(intent)
    }

    //Spinner
    fun Lang(){
        val langArray = arrayOf<String>("Lithuanian", "Polish", "Turkish", "Albanian")
        val spinner: Spinner = findViewById(R.id.languageSpinner)
        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, langArray)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
                var selectedLanguage = spinner.getItemAtPosition(pos)
                if (selectedLanguage == "Lithuanian") language.setLang(1)
                else if (selectedLanguage == "Polish") language.setLang(2)
                else if (selectedLanguage == "Turkish") language.setLang(3)
                else if (selectedLanguage == "Albanian") language.setLang(4)
            }

            override fun onNothingSelected(parent: AdapterView<*>) { language.setLang(1) }
        }

    }


}
