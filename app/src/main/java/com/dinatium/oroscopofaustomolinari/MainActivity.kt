package com.dinatium.oroscopofaustomolinari

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mAdView = findViewById<AdView>(R.id.adView)

        MobileAds.initialize(this) {}

        // Create an ad request.
        val adRequest = AdRequest.Builder().build()

        // Start loading the ad in the background.
        val adView = AdView(this)
        adView.adSize = AdSize.BANNER
        adView.adUnitId = "ca-app-pub-9907554154077581/6922271738"

        mAdView.loadAd(adRequest)


        val arieteEvent: Button = findViewById(R.id.arieteButton)
        arieteEvent.setOnClickListener {
            val i = Intent(applicationContext, SignActivity::class.java)
            i.putExtra("sign", "Ariete")
            startActivity(i)
        }
        val toroEvent: Button = findViewById(R.id.toroButton)
        toroEvent.setOnClickListener {
            val i = Intent(applicationContext, SignActivity::class.java)
            i.putExtra("sign", "Toro")
            startActivity(i)
        }
        val gemelliEvent: Button = findViewById(R.id.gemelliButton)
        gemelliEvent.setOnClickListener {
            val i = Intent(applicationContext, SignActivity::class.java)
            i.putExtra("sign", "Gemelli")
            startActivity(i)
        }

        val cancroEvent: Button = findViewById(R.id.cancroButton)
        cancroEvent.setOnClickListener {
            val i = Intent(applicationContext, SignActivity::class.java)
            i.putExtra("sign", "Cancro")
            startActivity(i)
        }
        val leoneEvent: Button = findViewById(R.id.leoneButton)
        leoneEvent.setOnClickListener {
            val i = Intent(applicationContext, SignActivity::class.java)
            i.putExtra("sign", "Leone")
            startActivity(i)
        }
        val vergineEvent: Button = findViewById(R.id.vergineButton)
        vergineEvent.setOnClickListener {
            val i = Intent(applicationContext, SignActivity::class.java)
            i.putExtra("sign", "Vergine")
            startActivity(i)
        }

        val bilanciaEvent: Button = findViewById(R.id.bilanciaButton)
        bilanciaEvent.setOnClickListener {
            val i = Intent(applicationContext, SignActivity::class.java)
            i.putExtra("sign", "Bilancia")
            startActivity(i)
        }
        val scorpioneEvent: Button = findViewById(R.id.scorpioneButton)
        scorpioneEvent.setOnClickListener {
            val i = Intent(applicationContext, SignActivity::class.java)
            i.putExtra("sign", "Scorpione")
            startActivity(i)
        }
        val sagittarioEvent: Button = findViewById(R.id.sagittarioButton)
        sagittarioEvent.setOnClickListener {
            val i = Intent(applicationContext, SignActivity::class.java)
            i.putExtra("sign", "Sagittario")
            startActivity(i)
        }

        val capricornoEvent: Button = findViewById(R.id.capricornoButton)
        capricornoEvent.setOnClickListener {
            val i = Intent(applicationContext, SignActivity::class.java)
            i.putExtra("sign", "Capricorno")
            startActivity(i)
        }
        val acquarioEvent: Button = findViewById(R.id.acquarioButton)
        acquarioEvent.setOnClickListener {
            val i = Intent(applicationContext, SignActivity::class.java)
            i.putExtra("sign", "Acquario")
            startActivity(i)
        }
        val pesciEvent: Button = findViewById(R.id.pesciButton)
        pesciEvent.setOnClickListener {
            val i = Intent(applicationContext, SignActivity::class.java)
            i.putExtra("sign", "Pesci")
            startActivity(i)
        }

        val openWebSite: Button = findViewById(R.id.webLink)
        openWebSite.setOnClickListener {
            val i = Intent()
            i.action = Intent.ACTION_VIEW
            i.addCategory(Intent.CATEGORY_BROWSABLE)
            i.setData(Uri.parse("https://www.faustomolinari.it/"))
            startActivity(i)
        }

    }
}