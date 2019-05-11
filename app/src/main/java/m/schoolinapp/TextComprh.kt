package m.schoolinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.StringBuilder

class TextComprh : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_comprh)
    }

    var tview: TextView
        get() = findViewById(R.id.TextViewTEST)
        set(value) = TODO()



/*
    val bufferedReader: BufferedReader = File("text.txt").bufferedReader()

    val content: String = bufferedReader.use { it.readText() }
*/
/*
    val file = File("src/app/text.txt")

    var content = file.readText()
*/

    //This is code is almost copy-paste from
    //https://www.javatpoint.com/kotlin-android-read-and-write-internal-storage

    fun ClickClick(v: View) {
        var inputStream: InputStream = resources.openRawResource(R.raw.text)
        var inputStreamReader: InputStreamReader = InputStreamReader(inputStream)
        val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
        val stringBuilder: StringBuilder = StringBuilder()
        var text: String? = null
        while({text = bufferedReader.readLine(); text }() != null){
            stringBuilder.append(text)
        }
        tview.setText(stringBuilder.toString()).toString()
    }
}
