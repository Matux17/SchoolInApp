package m.schoolinapp

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class Credits : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credits)

        val mediaPlayer = MediaPlayer.create(this, R.raw.apptheme)
        mediaPlayer.start()
    }
}
