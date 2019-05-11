package m.schoolinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import kotlin.math.round

class Vocabulary : AppCompatActivity() {
/*
    var Images1 = arrayOf(R.drawable.award, R.drawable.apple, R.drawable.banana, R.drawable.bird, R.drawable.cat, R.drawable.cheesecake, R.drawable.cherries, R.drawable.computer,
        R.drawable.cupcake, R.drawable.dog, R.drawable.fruits, R.drawable.glassofwater, R.drawable.herb, R.drawable.orange, R.drawable.pear, R.drawable.avocado, R.drawable.ball,
        R.drawable.beetroot)
    var Words1 = arrayOf("award", "apple","banana","bird", "cat", "cheesecake", "cherries", "computer", "cupcake", "dog", "fruits", "glass of water", "herb", "orange",
        "pear", "avocado", "ball", "beetroot")
    var Images2 = arrayOf(R.drawable.book, R.drawable.car, R.drawable.house, R.drawable.leaves, R.drawable.nest, R.drawable.pencil, R.drawable.penguin, R.drawable.pepper,
        R.drawable.plants, R.drawable.potato, R.drawable.rocks, R.drawable.soup, R.drawable.star, R.drawable.tail, R.drawable.umbrella, R.drawable.vegetables,
        R.drawable.watermelon, R.drawable.whiskers, R.drawable.eraser)
    var Words2 = arrayOf("book", "car", "house", "leaves", "nest", "pencil", "penguin", "pepper", "plants", "potato", "rocks", "soup", "star",
        "tail", "umbrella", "vegetables", "watermelon", "whiskers", "eraser")
*/

    var Images1 = arrayOf(R.drawable.apple, R.drawable.avocado, R.drawable.award, R.drawable.ball, R.drawable.banana, R.drawable.bird, R.drawable.book, R.drawable.car, R.drawable.cat,
        R.drawable.cheesecake, R.drawable.cherries, R.drawable.computer, R.drawable.cupcake, R.drawable.dog, R.drawable.whiskers)

    var Words1 = arrayOf("apple", "avocado", "award", "ball", "banana", "bird", "book", "car", "cat", "cheesecake", "cherries", "computer", "cupcake", "dog", "whiskers")

    var Images2 = arrayOf(R.drawable.apple1, R.drawable.avocado1, R.drawable.award1, R.drawable.ball1, R.drawable.banana1, R.drawable.bird1, R.drawable.book1, R.drawable.car1,
        R.drawable.cat1, R.drawable.cheesecake1, R.drawable.cherries1, R.drawable.computer1, R.drawable.cupcake1, R.drawable.dog1, R.drawable.whiskers1)

    var Words2 = arrayOf("apple", "avocado", "award", "ball", "banana", "bird", "book", "car", "cat", "cheesecake", "cherries", "computer", "cupcake", "dog", "whiskers")


    var Images = arrayOf(0)
    var Words = arrayOf(" ")


    var clicked = -1
    var shouldBeClicked = -2
    var answered = 0.toDouble()
    var answers = 0.toDouble()
    var minScore = 80.toDouble()
    var score = 0.toDouble()
    var i = 0



    fun Initialize(){
        val lvl = Level
        when(lvl.getLvl()){
            1 ->{ Words = Words1; Images = Images1 }
            2 ->{ Words = Words2; Images = Images2 }
        }
        i = Images.size
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vocabulary)
    }


    var imgButton1: ImageButton
        get() = findViewById(R.id.ButtonImage1)
        set(value) = TODO()

    var imgButton2: ImageButton
        get() = findViewById(R.id.ButtonImage2)
        set(value) = TODO()

    var imgButton3: ImageButton
        get() = findViewById(R.id.ButtonImage3)
        set(value) = TODO()

    var imgButton4: ImageButton
        get() = findViewById(R.id.ButtonImage4)
        set(value) = TODO()

    var Word: TextView
        get() = findViewById(R.id.Word)
        set(value) = TODO()

    var Answer: TextView
        get() = findViewById(R.id.Answer)
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

    var ScoreView: TextView
        get() = findViewById(R.id.Score)
        set(value) = TODO()

    fun ClickShuffle() {
        val n = ((0..(i-1)).shuffled()).toIntArray()
        val m = ((0..3).shuffled().first())
        shouldBeClicked = m
        imgButton1.setImageResource(Images[n[0]])
        imgButton2.setImageResource(Images[n[1]])
        imgButton3.setImageResource(Images[n[2]])
        imgButton4.setImageResource(Images[n[3]])
        Word.setText(Words[n[m]])
    }

    fun Click()
    {
        answers++
        if(clicked == shouldBeClicked)
        {
            Answer.setText("Correct!")
            TryAgainButton.visibility = View.GONE
            NextButton.visibility = View.VISIBLE
            answered++
            if(answers >= 10 && score >= minScore)nextLevel()
        }
        else
        {
            Answer.setText("Try Again... :(")
            NextButton.visibility = View.GONE
            TryAgainButton.visibility = View.VISIBLE
        }
        NotClickable()
        score = round(answered/answers*100)
        ScoreView.setText(score.toString())
    }

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
        Answer.setText("")
        NextButton.visibility = View.GONE
        ClickShuffle()
        Clickable()
    }

    fun ClickTryAgain(v: View)
    {
        Answer.setText("")
        TryAgainButton.visibility = View.GONE
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
        Answer.setText("")
        Word.setText("")
        NextButton.visibility = View.GONE
        TryAgainButton.visibility = View.GONE
        NextLevelText.visibility = View.VISIBLE
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
}
