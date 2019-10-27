package com.example.service

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_play -> {
                audiopaly(posLagu)
            }
            R.id.btn_previous -> {
                audioprev()
            }
            R.id.btn_next -> {
                audionext()
            }
        }
    }

    val daftar_judul= arrayOf("I love U 3000","spongebob gagak","seek up to")
    val daftar_Lagu= intArrayOf(R.raw.love300,R.raw.sponbob,R.raw.upkick)
    val daftar_cover= intArrayOf(R.drawable.linda,R.drawable.cover,R.drawable.spongebob)



    var posLagu=0

    lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mediaPlayer= MediaPlayer()
        btn_play.setOnClickListener(this)
        btn_previous.setOnClickListener(this)
        btn_next.setOnClickListener(this)

        btn_fb.setOnClickListener({
            val i=Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.facebook.com/rendra.yusri"))
            startActivity(i)
        })

        btn_ig.setOnClickListener({
            val i=Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.instagram.com/rendra.ym/"))
            startActivity(i)
        })
    }
    fun audiopaly(Pos:Int){
        if(mediaPlayer.isPlaying){
            mediaPlayer.stop()

        }
        else {
            mediaPlayer = MediaPlayer.create(this, daftar_Lagu[Pos])
            cover.setImageResource(daftar_cover[Pos])
            Txt_Judul.setText(daftar_judul[Pos])
            mediaPlayer.start()
        }
    }

    fun audionext(){
        if(mediaPlayer.isPlaying)mediaPlayer.stop()
        if(posLagu<daftar_Lagu.size-1){
            posLagu++
        }else{
            posLagu=0
        }
        audiopaly(posLagu)
    }

    fun audioprev(){
        if(mediaPlayer.isPlaying)mediaPlayer.stop()
        if (posLagu>0){
            posLagu--
        }
        else{
            posLagu=daftar_Lagu.size-1
        }
        audiopaly(posLagu)
    }
}
