package com.burakkodaloglu.cicek_bahcesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cicekler_detay.*

class CiceklerDetay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cicekler_detay)

        var bundle:Bundle= intent.extras!!
        var adi=bundle.getString("constAdi")
        var aciklama=bundle.getString("constAciklama")
        var resim=bundle.getInt("constResim")


        detayAdi.text=adi
        detayAciklama.text=aciklama
        detayResim.setImageResource(resim)

    }
}