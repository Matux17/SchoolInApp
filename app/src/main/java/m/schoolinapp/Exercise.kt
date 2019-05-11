package m.schoolinapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

/*
This page is for choosing
 */
class Exercise : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
    }

    fun btVocabulary(v: View) {
        val intent = Intent(this, Vocabulary::class.java)
        startActivity(intent)
    }

    fun btTextComp(v: View) {
        val intent2 = Intent(this, TextComprh::class.java)
        startActivity(intent2)
    }
}
