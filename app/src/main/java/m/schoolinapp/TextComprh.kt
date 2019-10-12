package m.schoolinapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class TextComprh : AppCompatActivity() {

    var radioLevelOne = arrayOf(0, 1, 0, 0, 0)
    var radioLevelTwo = arrayOf(0, 0, 1, 0, 1)
    var radioLevelThree = arrayOf(0, 1, 1, 1, 0)
    var radioLevelFour = arrayOf(1, 0, 1, 1, 1)
    var radioLevelFive = arrayOf(0, 1, 0, 1, 1)
    lateinit var radioAnswers: Array<Int>
    var questionsLevelOne = arrayOf("There are no animals vegetarians.", "Lemurs are endangered animals.", "The biggest animal on earth is a chimpanzee.",
        "Lemur is a domestic animal.", "Elephants don't eat leaves")
    var questionsLevelTwo = arrayOf("Turkish cuisine does not have many different food.", "Europe and Anatolia played a big role in Turkish Cuisine.",
        "They have different foods for different events.", "Seljuk and Ottoman interaction developed new tastes.", "Soup consists of olive oil and pasta dishes.")
    var questionsLevelThree = arrayOf("“Baduk” is called the game of “Go” all over the world.", "“Baduk” can teach both logic and self-control.", "It is a competitive game.",
        "The game is popular for its tactics and strategies.", "“Baduk” is played in less than 60 countries.")
    var questionsLevelFour = arrayOf("Chinese culture plays a big role in influencing other cultures.", "Chinese writing system is not different Western countries.","The English language is gaining popularity in China.",
        "Knowing English grammar can help you learn Chinese.", "You can meet Chinese people all around the world.")
    var questionsLevelFive = arrayOf("According to statistics, an adult spends less than 85 hours on the phone.", "The first wireless telephone calls was a huge stepping stone in the sphere.",
        "Radio telephones allowed users to make more than 3 calls per week.", "The first handheld cellular phone was introduced by Motorola.", "Smartphones are versatile.")
    var questions = arrayOf("")
    var correct = 0
    var questionNr = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_comprh)
        Initialize()
    }

    var inputStream: InputStream? = null
    var topic: String? = null

    private fun Initialize(){
        val lvl = Level
        inputStream = resources.openRawResource(R.raw.error)
        when(lvl.getLvl()){
            1 -> {
                inputStream = resources.openRawResource(R.raw.level1)
                radioAnswers = radioLevelOne
                questions = questionsLevelOne}

            2 -> {
                inputStream = resources.openRawResource(R.raw.level2)
                radioAnswers = radioLevelTwo
                questions = questionsLevelTwo}
            3 -> {
                inputStream = resources.openRawResource(R.raw.level3)
                radioAnswers = radioLevelThree
                questions = questionsLevelThree}
            4 -> {
                inputStream = resources.openRawResource(R.raw.level4)
                radioAnswers = radioLevelFour
                questions = questionsLevelFour}
            5 -> {
                inputStream = resources.openRawResource(R.raw.level5)
                radioAnswers = radioLevelFive
                questions = questionsLevelFive}
        }
    }

    var tview: TextView
        get() = findViewById(R.id.textComprView)
        set(value) = TODO()

    var topicView: TextView
        get() = findViewById(R.id.topicView)
        set(value) = TODO()

    var buttonPlay: ImageButton
        get() = findViewById(R.id.buttonPlayText)
        set(value) = TODO()

    var toQuestions: TextView
        get() = findViewById(R.id.readTC)
        set(value) = TODO()

    var buttonNext: ImageButton
        get() = findViewById(R.id.buttonTextRead)
        set(value) = TODO()

    var question: TextView
        get() = findViewById(R.id.question)
        set(value) = TODO()

    var btRadio: RadioGroup
        get() = findViewById(R.id.buttonsGroup)
        set(value) = TODO()

    var radioButtonTrue: RadioButton
        get() = findViewById(R.id.radioTrue1)
        set(value) = TODO()

    var radioButtonFalse: RadioButton
        get() = findViewById(R.id.radioFalse1)
        set(value) = TODO()

    var TCInfo: TextView
        get() = findViewById(R.id.tcInfo)
        set(value) = TODO()

    var back: ImageButton
        get() = findViewById(R.id.backToLevels)
        set(value) = TODO()

    var home: ImageButton
        get() = findViewById(R.id.buttonHome)
        set(value) = TODO()

    //This is code is almost copy-paste from
    //https://www.javatpoint.com/kotlin-android-read-and-write-internal-storage

    fun ClickClick(v: View) {
        var inputStreamReader: InputStreamReader = InputStreamReader(inputStream)
        val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
        val stringBuilder: StringBuilder = StringBuilder()
        var text: String? = null
        topic = bufferedReader.readLine()
        while({text = bufferedReader.readLine(); text }() != null){
            stringBuilder.append(text)
        }
        topicView.setText(topic)
        tview.setText(stringBuilder.toString()).toString()
        buttonPlay.visibility = View.GONE
        TCInfo.visibility = View.GONE
        toQuestions.visibility = View.VISIBLE
        buttonNext.visibility = View.VISIBLE
    }

    fun btTextRead(v: View) {
        buttonNext.visibility = View.GONE
        toQuestions.visibility = View.GONE
        tview.visibility = View.GONE
        topicView.visibility = View.GONE
        question.visibility = View.VISIBLE
        btRadio.visibility = View.VISIBLE
        question.setText(questions[0])
    }

    fun answerClicked(v: View) {
        if(v is RadioButton) {
            var checked = v.isChecked

            when (v.getId()) {
                R.id.radioTrue1 -> if (checked) {
                    if (radioAnswers[questionNr] == 1) correct++
                }
                R.id.radioFalse1 -> if (checked) {
                    if (radioAnswers[questionNr] == 0) correct++
                }
            }
            questionNr++
            if (questionNr < 5) { question.setText(questions[questionNr]) }
            CheckCorrectAnswers()
            btRadio.clearCheck()
        }

    }

    fun CheckCorrectAnswers() {
        if (correct == 5 && questionNr == 5) {
            question.setText(R.string.LevelCompleted)
            btRadio.visibility = View.GONE
            back.visibility = View.VISIBLE
            home.visibility = View.VISIBLE
        }
        else if (questionNr == 5 && correct != 5) {
            question.setText(R.string.LevelFailed)
            btRadio.visibility = View.GONE
            back.visibility = View.VISIBLE
            home.visibility = View.VISIBLE
        }
    }

    fun goBack(v:  View) {
        val intent = Intent(this, Levels::class.java)
        startActivity(intent)
    }

    fun goHome(v: View)
    {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
