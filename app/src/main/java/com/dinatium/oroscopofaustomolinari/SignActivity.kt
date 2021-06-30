package com.dinatium.oroscopofaustomolinari

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import org.json.JSONObject
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*

class SignActivity : AppCompatActivity() {

    var sign: String? = "Ariete"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)

        val extras = intent.extras
        if (extras != null) {
            sign = extras.getString("sign").toString()
        }
        findViewById<TextView>(R.id.title).text = sign

        when (sign) {
            "Ariete" -> findViewById<ImageView>(R.id.signImg).setImageDrawable(getDrawable(R.drawable.ariessymbol))
            "Toro" -> findViewById<ImageView>(R.id.signImg).setImageDrawable(getDrawable(R.drawable.taurussymbol))
            "Gemelli" -> findViewById<ImageView>(R.id.signImg).setImageDrawable(getDrawable(R.drawable.geminisymbol))
            "Cancro" -> findViewById<ImageView>(R.id.signImg).setImageDrawable(getDrawable(R.drawable.cancersymbol))
            "Leone" -> findViewById<ImageView>(R.id.signImg).setImageDrawable(getDrawable(R.drawable.leosymbol))
            "Vergine" -> findViewById<ImageView>(R.id.signImg).setImageDrawable(getDrawable(R.drawable.virgosymbol))
            "Bilancia" -> findViewById<ImageView>(R.id.signImg).setImageDrawable(getDrawable(R.drawable.librasymbol))
            "Scorpione" -> findViewById<ImageView>(R.id.signImg).setImageDrawable(getDrawable(R.drawable.scorpiosymbol))
            "Sagittario" -> findViewById<ImageView>(R.id.signImg).setImageDrawable(getDrawable(R.drawable.sagittariussymbol))
            "Capricorno" -> findViewById<ImageView>(R.id.signImg).setImageDrawable(getDrawable(R.drawable.capricornsymbol))
            "Acquario" -> findViewById<ImageView>(R.id.signImg).setImageDrawable(getDrawable(R.drawable.aquariussymbol))
            "Pesci" -> findViewById<ImageView>(R.id.signImg).setImageDrawable(getDrawable(R.drawable.piscessymbol))
            else -> {
                //Lascio tutto come è perchè vi è un errore
            }
        }

        loadOroscopo().execute()
    }



    inner class loadOroscopo : AsyncTask<String, Void, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
            /* Showing the ProgressBar, Making the main design GONE */
            findViewById<ProgressBar>(R.id.caricamento).visibility = View.VISIBLE
            findViewById<LinearLayout>(R.id.titleContainer).visibility = View.GONE
            findViewById<LinearLayout>(R.id.bodyContainer).visibility = View.GONE
            findViewById<TextView>(R.id.errore).visibility = View.GONE
        }

        override fun doInBackground(vararg params: String?): String? {
            val response = try {
                URL("https://visualradio.altervista.org/oroscopo.json").readText(
                    Charsets.UTF_8
                )
            } catch (e: Exception) {
                Log.e("Error caricamento:", e.printStackTrace().toString())
                return null
            }

            Log.e("Error:", response)

            return response
        }

        override fun onPostExecute(result: String?) {
            try {
                val jsonObj = JSONObject(result)
                val author = jsonObj.getJSONObject("author")
                val date = jsonObj.getJSONObject("date")
                var name: String?
                var description: String?
                when (sign) {
                    "Ariete" -> {
                        name = jsonObj.getJSONArray("oroscopo").getJSONObject(0).getString("name")
                        description = jsonObj.getJSONArray("oroscopo").getJSONObject(0)
                            .getString("description")
                    }
                    "Toro" -> {
                        name = jsonObj.getJSONArray("oroscopo").getJSONObject(1).getString("name")
                        description = jsonObj.getJSONArray("oroscopo").getJSONObject(1)
                            .getString("description")
                    }
                    "Gemelli" -> {
                        name = jsonObj.getJSONArray("oroscopo").getJSONObject(2).getString("name")
                        description = jsonObj.getJSONArray("oroscopo").getJSONObject(2)
                            .getString("description")
                    }
                    "Cancro" -> {
                        name = jsonObj.getJSONArray("oroscopo").getJSONObject(3).getString("name")
                        description = jsonObj.getJSONArray("oroscopo").getJSONObject(3)
                            .getString("description")
                    }
                    "Leone" -> {
                        name = jsonObj.getJSONArray("oroscopo").getJSONObject(4).getString("name")
                        description = jsonObj.getJSONArray("oroscopo").getJSONObject(4)
                            .getString("description")
                    }
                    "Vergine" -> {
                        name = jsonObj.getJSONArray("oroscopo").getJSONObject(5).getString("name")
                        description = jsonObj.getJSONArray("oroscopo").getJSONObject(5)
                            .getString("description")
                    }
                    "Bilancia" -> {
                        name = jsonObj.getJSONArray("oroscopo").getJSONObject(6).getString("name")
                        description = jsonObj.getJSONArray("oroscopo").getJSONObject(6)
                            .getString("description")
                    }
                    "Scorpione" -> {
                        name = jsonObj.getJSONArray("oroscopo").getJSONObject(7).getString("name")
                        description = jsonObj.getJSONArray("oroscopo").getJSONObject(7)
                            .getString("description")
                    }
                    "Sagittario" -> {
                        name = jsonObj.getJSONArray("oroscopo").getJSONObject(8).getString("name")
                        description = jsonObj.getJSONArray("oroscopo").getJSONObject(8)
                            .getString("description")
                    }
                    "Capricorno" -> {
                        name = jsonObj.getJSONArray("oroscopo").getJSONObject(9).getString("name")
                        description = jsonObj.getJSONArray("oroscopo").getJSONObject(9)
                            .getString("description")
                    }
                    "Acquario" -> {
                        name = jsonObj.getJSONArray("oroscopo").getJSONObject(10).getString("name")
                        description = jsonObj.getJSONArray("oroscopo").getJSONObject(10)
                            .getString("description")
                    }
                    "Pesci" -> {
                        name = jsonObj.getJSONArray("oroscopo").getJSONObject(11).getString("name")
                        description = jsonObj.getJSONArray("oroscopo").getJSONObject(11)
                            .getString("description")
                    }
                    else -> {
                        name = "Errore"
                        description = "Impossibile recuperare le informazioni dell' oroscopo"
                    }
                }

                findViewById<TextView>(R.id.date).text = "Ultimo aggiornamento: " + date
                findViewById<TextView>(R.id.title).text = name
                findViewById<TextView>(R.id.signText).text = description

                findViewById<ProgressBar>(R.id.caricamento).visibility = View.GONE
                findViewById<LinearLayout>(R.id.titleContainer).visibility = View.VISIBLE
                findViewById<LinearLayout>(R.id.bodyContainer).visibility = View.VISIBLE

            } catch (e: Exception) {
                findViewById<ProgressBar>(R.id.caricamento).visibility = View.GONE
                findViewById<TextView>(R.id.errore).append("/n" + e.printStackTrace().toString())
                findViewById<TextView>(R.id.errore).visibility = View.VISIBLE
            }
        }
    }
}