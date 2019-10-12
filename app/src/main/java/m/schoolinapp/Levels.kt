package m.schoolinapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

/*
This page is for choosing level. It proceeds to exercise page and saves Level value as integer
 */
class Levels : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_levels)
    }


    private var lvl = Level


    fun ChooseExercise(v: View){
        val intent = Intent(this, Exercise::class.java)
        startActivity(intent)
    }

    fun btLevelOne(v: View) {
        lvl.setLvl(1)
        ChooseExercise(v)
    }

    fun btLevelTwo(v: View) {
        lvl.setLvl(2)
        ChooseExercise(v)
    }

    fun btLevelThree(v: View) {
        lvl.setLvl(3)
        ChooseExercise(v)
    }

    fun btLevelFour(v: View) {
        lvl.setLvl(4)
        ChooseExercise(v)
    }

    fun btLevelFive(v: View) {
        lvl.setLvl(5)
        ChooseExercise(v)
    }
}