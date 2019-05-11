package m.schoolinapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

/*
This is the main screen
* Text (???)
* Background (???)
* Start button (Go to Levels page)
* Credits button (Go to Credits page)
* Copyright
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //Start button

    fun btStart(v: View) {
        val intent = Intent(this, Levels::class.java)
        startActivity(intent)
    }
}
