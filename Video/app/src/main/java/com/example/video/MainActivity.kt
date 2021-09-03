package com.example.video

import android.app.ProgressDialog
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.jarvanmo.exoplayerview.media.ExoMediaSource.Quality
import com.jarvanmo.exoplayerview.media.SimpleMediaSource
import com.jarvanmo.exoplayerview.ui.ExoVideoView
import java.lang.Exception


class MainActivity : AppCompatActivity(), View.OnClickListener {
    val urlString ="https://www.scorebat.com/embed/g/994245/?s=2"
    lateinit var mDioalog: ProgressDialog
    lateinit var videoView: VideoView
    lateinit var btnPlay: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        videoView = findViewById(R.id.videoView)
        btnPlay = findViewById(R.id.btn_play)
        btnPlay.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        mDioalog = ProgressDialog(this)
        mDioalog.setMessage("Please wait..")
        mDioalog.setCanceledOnTouchOutside(false)
        mDioalog.show()

        try {
            if (videoView.isPlaying){
                val url = Uri.parse(urlString)
                videoView.setVideoURI(url)
                videoView.setOnCompletionListener {
                    btnPlay.setImageResource(R.drawable.ic_baseline_play_arrow_24)
                }
            }
            else{
                videoView.pause()
                btnPlay.setImageResource(R.drawable.ic_baseline_play_arrow_24)
            }
        }
        catch (e: Exception){
            Toast.makeText(this, " " + e.toString(),Toast.LENGTH_SHORT).show()
        }

        videoView.requestFocus()
        videoView.setOnCompletionListener {
            mDioalog.dismiss()
            videoView.start()
        }
    }
}