package m.schoolinapp

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class Vocabulary : AppCompatActivity() {


    var Words1EN = arrayOf("endangered", "species", "wild", "elephant", "leaves")
    var Words1LT = arrayOf("nykstanti", "rūšys", "laukinis", "dramblys", "lapai")
    var Words1PL = arrayOf("zagrożony", "gatunki", "dziki", "słoń", "liście")
    var Words1TR = arrayOf("tehlike altında", "tür", "Vahşi", "fil", "Yaprak -ları")
    var Words1AL = arrayOf("rrezikuara", "lloj", "i egër", "elefant", "lë")

    var Words2EN = arrayOf("kitchen", "soup", "food", "beverages", "meat")
    var Words2LT = arrayOf("virtuvė", "sriuba", "maistas", "gėrimai", "mėsa")
    var Words2PL = arrayOf("kuchnia", "zupa", "jedzenie", "napoje", "mięso")
    var Words2TR = arrayOf("mutfak", "Çorba", "yemek", "içkiler", "et")
    var Words2AL = arrayOf("kuzhinë", "supë", "ushqim", "pije", "mish")

    var Words3EN = arrayOf("game", "dice", "ancient", "future", "country")
    var Words3LT = arrayOf("žaidimas", "kauliukas", "senovinis", "ateitis", "šalis")
    var Words3PL = arrayOf("gra", "kostka", "starożytny", "przyszłość", "kraj")
    var Words3TR = arrayOf("oyun", "zar", "Çok eski", "gelecek", "ülke")
    var Words3AL = arrayOf("loje", "kocke", "E vjeter", "ardhmeria", "shteti")

    var Words4EN = arrayOf("shop", "street", "skyscraper", "city", "world")
    var Words4LT = arrayOf("parduotuvė", "gatvė", "dangoraižis", "miestas", "pasaulis")
    var Words4PL = arrayOf("sklep", "ulica", "wieżowiec", "miasto", "świat")
    var Words4TR = arrayOf("dükkan", "sokak", "gökdelen", "şehir", "dünya")
    var Words4AL = arrayOf("dyqan", "rrugë", "rrokaqiell", "qytet", "botë")

    var Words5EN = arrayOf("cell phone", "conversation", "communicate", "quality", "invent")
    var Words5LT = arrayOf("mobilus telefonas", "pokalbis", "bendrauti", "kokybė", "išrasti")
    var Words5PL = arrayOf("telefon komórkowy", "konwersacji", "komunikowaćsię", "jakości", "wymyślić")
    var Words5TR = arrayOf("cep telefonu", "konuşma", "iletişim kur", "kalite", "icat")
    var Words5AL = arrayOf("celular", "bisedë", "komunikoj", "cilësi", "shpik")

    var Words1 = Words1EN
    var Words2 = Words2EN
    var Words3 = Words3EN
    var Words4 = Words4EN
    var Words5 = Words5EN

    var Words = Words1EN
    var WordsEN = Words1EN

    var WordOL = ""
    var WordEN = ""
    var WordsENrandom: Array<String> = arrayOf("")

    var clicked = 0
    var shouldBeClicked = 0
    var answered = 0.toDouble()
    var answers = 0.toDouble()
    var minScore = 80.toDouble()
    var score = 0.toDouble()
    var i = WordsEN.size
    var n: IntArray = (0..1).shuffled().toIntArray()
    var m = 1
    var index = (0..i-1).toList().toIntArray()



    fun Initialize() {
        val lang = Language
        when(lang.getLang()){
            1 -> {
                Words1 = Words1LT
                Words2 = Words2LT
                Words3 = Words3LT
                Words4 = Words4LT
                Words5 = Words5LT}
            2 -> {
                Words1 = Words1PL
                Words2 = Words2PL
                Words3 = Words3PL
                Words4 = Words4PL
                Words5 = Words5PL}
            3 -> {
                Words1 = Words1TR
                Words2 = Words2TR
                Words3 = Words3TR
                Words4 = Words4TR
                Words5 = Words5TR}
            4 -> {
                Words1 = Words1AL
                Words2 = Words2AL
                Words3 = Words3AL
                Words4 = Words4AL
                Words5 = Words5AL}
        }
        val lvl = Level
        when(lvl.getLvl()){
            1 ->{   Words = Words1
                WordsEN = Words1EN}
            2 ->{   Words = Words2
                WordsEN = Words2EN}
            3 ->{   Words = Words3
                WordsEN = Words3EN}
            4 ->{   Words = Words4
                WordsEN = Words4EN}
            5 ->{   Words = Words5
                WordsEN = Words5EN}
        }
        i = WordsEN.size
        index = (0..i-1).toList().toIntArray()

        Word.setBackgroundResource(R.drawable.border)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vocabulary)
    }


    var imgButton1: Button
        get() = findViewById(R.id.ButtonImage1)
        set(value) = TODO()

    var imgButton2: Button
        get() = findViewById(R.id.ButtonImage2)
        set(value) = TODO()

    var imgButton3: Button
        get() = findViewById(R.id.ButtonImage3)
        set(value) = TODO()

    var imgButton4: Button
        get() = findViewById(R.id.ButtonImage4)
        set(value) = TODO()

    var Word: TextView
        get() = findViewById(R.id.Word)
        set(value) = TODO()

    var NextButton: ImageButton
        get() = findViewById(R.id.Next)
        set(value) = TODO()

    var TryAgainButton: ImageButton
        get() = findViewById(R.id.TryAgain)
        set(value) = TODO()

    var PlayButton: ImageButton
        get() = findViewById(R.id.Play)
        set(value) = TODO()

    var NextLevelText: TextView
        get() = findViewById(R.id.NextLevelWarning)
        set(value) = TODO()

    var back: ImageButton
        get() = findViewById(R.id.backToLevels)
        set(value) = TODO()

    var home: ImageButton
        get() = findViewById(R.id.buttonHome)
        set(value) = TODO()

    fun Click1(v: View) {
        clicked = 0
        Click()
    }

    fun Click2(v: View) {
        clicked = 1
        Click()
    }

    fun Click3(v: View) {
        clicked = 2
        Click()
    }

    fun Click4(v: View) {
        clicked = 3
        Click()
    }

    fun ClickNext(v: View)
    {
        NextButton.visibility = View.GONE
        ClickShuffle()
        Clickable()
    }

    fun ClickTryAgain(v: View)
    {
        TryAgainButton.visibility = View.GONE
        ClickShuffle()
        Clickable()
    }

    fun ClickPlay(v: View)
    {
        Initialize()
        PlayButton.visibility = View.GONE
        imgButton1.visibility = View.VISIBLE
        imgButton2.visibility = View.VISIBLE
        imgButton3.visibility = View.VISIBLE
        imgButton4.visibility = View.VISIBLE
        ClickShuffle()
    }

    fun nextLevel()
    {
        imgButton1.visibility = View.GONE
        imgButton2.visibility = View.GONE
        imgButton3.visibility = View.GONE
        imgButton4.visibility = View.GONE
        Word.visibility = View.GONE
        NextButton.visibility = View.GONE
        TryAgainButton.visibility = View.GONE
        NextLevelText.visibility = View.VISIBLE
        back.visibility = View.VISIBLE
        home.visibility = View.VISIBLE
    }

    fun NotClickable()
    {
        imgButton1.isClickable = false
        imgButton2.isClickable = false
        imgButton3.isClickable = false
        imgButton4.isClickable = false
    }

    fun Clickable()
    {
        imgButton1.isClickable = true
        imgButton2.isClickable = true
        imgButton3.isClickable = true
        imgButton4.isClickable = true
    }

    fun goBack(v:  View)
    {
        val intent = Intent(this, Levels::class.java)
        startActivity(intent)
    }

    fun goHome(v: View)
    {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun ClickShuffle() {
        var arraySize = Words.size
        if (arraySize > 0)
        {
            pick(Words, WordsEN)
            Word.setText(WordOL)
            imgButton1.setText(WordsENrandom[0])
            imgButton2.setText(WordsENrandom[1])
            imgButton3.setText(WordsENrandom[2])
            imgButton4.setText(WordsENrandom[3])
        }
        else nextLevel()
    }

    fun pick(arr1: Array<String>, arr2: Array<String>) {
        i = (0..((arr1.size)-1)).shuffled().first()

        WordOL = arr1[i]
        WordEN = arr2[index[i]]
        var temp = arr2.toList()
        WordsENrandom = temp.shuffled().take(4).toTypedArray()

        when (WordEN) {
            !in WordsENrandom -> {
                i = (0..3).shuffled().first()
                WordsENrandom[i] = WordEN
            }
        }

    }

    private fun find(a: String, b: Array<String>): Int {
        for (x in b.indices) {
            if (a == b[x]) return x
        }
        return -1
    }

    private fun RemoveString(a: Array<String>) :Array<String>
    {
        val temp = a
        val temp1 = temp.toList().take(i) + temp.toList().takeLast(a.size-i-1)
        return temp1.toTypedArray()
    }

    private fun RemoveInt(a: IntArray) :IntArray
    {
        val temp = a
        val temp1 = temp.toList().take(i) + temp.toList().takeLast(a.size-i-1)
        return temp1.toIntArray()
    }

    fun Click() {
        var guess = WordsENrandom[clicked]
        if (guess == WordEN) {
            i = find(WordOL, Words)
            Words = RemoveString(Words)
            index = RemoveInt(index)
            TryAgainButton.visibility = View.GONE
            NextButton.visibility = View.VISIBLE
        } else {
            NextButton.visibility = View.GONE
            TryAgainButton.visibility = View.VISIBLE
        }
        NotClickable()
    }
}
