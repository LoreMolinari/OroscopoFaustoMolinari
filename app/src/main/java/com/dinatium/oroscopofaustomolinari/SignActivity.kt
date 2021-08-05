package com.dinatium.oroscopofaustomolinari


import android.annotation.SuppressLint
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import java.net.URL

class SignActivity : AppCompatActivity() {

    var sign: String? = "Ariete"
    private var signsuccessivo: String? = "Toro"
    private var signprecedente: String? = "Pesci"

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)

        val extras = intent.extras
        if (extras != null) {
            sign = extras.getString("sign").toString()
        }
        findViewById<TextView>(R.id.title).text = sign

        val nextSign: Button = findViewById(R.id.next)
        val previousSign: Button = findViewById(R.id.previous)
        val homeButton: Button = findViewById(R.id.home)

        when (sign) {
            "Ariete" -> {
                findViewById<ImageView>(R.id.signImg).setImageDrawable(getDrawable(R.drawable.ariessymbolw))
                signsuccessivo = "Toro"
                signprecedente = "Pesci"
            }
            "Toro" -> {
                findViewById<ImageView>(R.id.signImg).setImageDrawable(getDrawable(R.drawable.taurussymbolw))
                signsuccessivo = "Gemelli"
                signprecedente = "Ariete"
            }
            "Gemelli" -> {
                findViewById<ImageView>(R.id.signImg).setImageDrawable(getDrawable(R.drawable.geminisymbolw))
                signsuccessivo = "Cancro"
                signprecedente = "Toro"
            }
            "Cancro" -> {
                findViewById<ImageView>(R.id.signImg).setImageDrawable(getDrawable(R.drawable.cancersymbolw))
                signsuccessivo = "Leone"
                signprecedente = "Gemelli"
            }
            "Leone" -> {
                findViewById<ImageView>(R.id.signImg).setImageDrawable(getDrawable(R.drawable.leosymbolw))
                signsuccessivo = "Vergine"
                signprecedente = "Cancro"
            }
            "Vergine" -> {
                findViewById<ImageView>(R.id.signImg).setImageDrawable(getDrawable(R.drawable.virgosymbolw))
                signsuccessivo = "Bilancia"
                signprecedente = "Leone"
            }
            "Bilancia" -> {
                findViewById<ImageView>(R.id.signImg).setImageDrawable(getDrawable(R.drawable.librasymbolw))
                signsuccessivo = "Scorpione"
                signprecedente = "Vergine"
            }
            "Scorpione" -> {
                findViewById<ImageView>(R.id.signImg).setImageDrawable(getDrawable(R.drawable.scorpiosymbolw))
                signsuccessivo = "Sagittario"
                signprecedente = "Bilancia"
            }
            "Sagittario" -> {
                findViewById<ImageView>(R.id.signImg).setImageDrawable(getDrawable(R.drawable.sagittariussymbolw))
                signsuccessivo = "Capricorno"
                signprecedente = "Scorpione"
            }
            "Capricorno" -> {
                findViewById<ImageView>(R.id.signImg).setImageDrawable(getDrawable(R.drawable.capricornsymbolw))
                signsuccessivo = "Acquario"
                signprecedente = "Sagittario"
            }
            "Acquario" -> {
                findViewById<ImageView>(R.id.signImg).setImageDrawable(getDrawable(R.drawable.aquariussymbolw))
                signsuccessivo = "Pesci"
                signprecedente = "Capricorno"
            }
            "Pesci" -> {
                findViewById<ImageView>(R.id.signImg).setImageDrawable(getDrawable(R.drawable.piscessymbolw))
                signsuccessivo = "Ariete"
                signprecedente = "Acquario"
            }
            else -> {
                //Lascio tutto come è perchè vi è un errore
            }
        }

        homeButton.setOnClickListener {
            val i = Intent(applicationContext, MainActivity::class.java)
            startActivity(i)
        }

        nextSign.setOnClickListener {
            val i = Intent(applicationContext, SignActivity::class.java)
            i.putExtra("sign", signsuccessivo)
            startActivity(i)
        }

        previousSign.setOnClickListener {
            val i = Intent(applicationContext, SignActivity::class.java)
            i.putExtra("sign", signprecedente)
            startActivity(i)
        }

        LoadOroscopo().execute()
    }


    @SuppressLint("StaticFieldLeak")
    inner class LoadOroscopo : AsyncTask<String, Void, String>() {
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
                URL("https://www.faustomolinari.it/oroscopo/oroscopo.json").readText(
                    Charsets.UTF_8
                )
            } catch (e: Exception) {
                return null
            }

            return response
        }

        override fun onPostExecute(result: String?) {
            try {
                val jsonObj = JSONObject(result)
                val date = jsonObj.getString("date")
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

                findViewById<TextView>(R.id.date).text = "Ultimo aggiornamento: $date"
                if (name != null) {
                    findViewById<TextView>(R.id.title).text = name.uppercase()
                }
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