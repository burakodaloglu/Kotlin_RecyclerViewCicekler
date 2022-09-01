package com.burakkodaloglu.cicek_bahcesi

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cicek_karti.view.*

class MainActivity : AppCompatActivity() {
    var constList=ArrayList<Cicekler>()
                var adapter:CiceklerAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        constList.add(Cicekler("Gül","Isparta'nın Gülüüüü",R.drawable.gul))
        constList.add(Cicekler("Kasımpatı","Kasımpatı diye bir çiçek",R.drawable.kasimpati))
        constList.add(Cicekler("Lale","Lale devriii çocuklarıyız biz nınınınnı :)",R.drawable.lale))
        constList.add(Cicekler("Menekşe","Menekşe çiçeki",R.drawable.menekse))
        constList.add(Cicekler("Nergiz","Nergiz diye bir çiçek",R.drawable.nergiz))
        constList.add(Cicekler("Orkide","Orkide yağlar pahalı",R.drawable.orkide))
        constList.add(Cicekler("Ortanca","Ortanca Çiçekiii",R.drawable.ortanca))
        constList.add(Cicekler("Papatya","Papatya oleeeyyy",R.drawable.papatya))

        adapter= CiceklerAdapter(this,constList)
        listview.adapter=adapter
    }
    class CiceklerAdapter: BaseAdapter {
        var constList=ArrayList<Cicekler>()
        var context:Context?=null

        constructor(context: Context,ConstList:ArrayList<Cicekler>):super(){
            this.constList=ConstList
            this.context=context
        }
        override fun getCount(): Int {
            return constList.size
        }

        override fun getItem(position: Int): Any {
            return constList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var posCicekler=constList[position]
            var inflator=context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var cicekkarti=inflator.inflate(R.layout.cicek_karti,null)
            cicekkarti.KartAdi.text=posCicekler.constAdi
            cicekkarti.KartAciklama.text=posCicekler.constAciklama
            cicekkarti.KartResim.setImageResource(posCicekler.constResim!!)

            cicekkarti.cicekKart.setOnClickListener{
                var intent=Intent(context,CiceklerDetay::class.java)
                intent.putExtra("constAdi",posCicekler.constAdi)
                intent.putExtra("constAciklama",posCicekler.constAciklama)
                intent.putExtra("constResim",posCicekler.constResim)
                context!!.startActivity(intent)
            }

            return cicekkarti

        }

    }
}