package kure.guraburu_kyuen_tool

import android.annotation.SuppressLint
import android.content.Context
import android.support.v4.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_relief.*
import android.widget.ImageButton
import android.widget.Spinner
import kotlinx.android.synthetic.*
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import kure.guraburu_kyuen_tool.R.id.spinner




/**
 * 救援ページ
 *
 * Created by yuuma on 2017/11/11.
 */

class ReliefFragment : Fragment() {

    private var flg = true
 //  var item = "新召喚石マルチ"


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_relief, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onResume() {
        super.onResume()

        //初回起動時はマグナ星晶獣を、それ以外の時は以前選択したものを取得
        var shardPreferences =  activity.getPreferences(Context.MODE_PRIVATE)
        var item = shardPreferences.getString("item","マグナ星晶獣")

        //spinnetの初期表示変更
//        var index = changeSpinner(item)

        var index = 0

        var imagebutton1 = view!!.findViewById<ImageButton>(R.id.imageButton1)
        var imagebutton2 = view!!.findViewById<ImageButton>(R.id.imageButton2)
        var imagebutton3 = view!!.findViewById<ImageButton>(R.id.imageButton3)
        var imagebutton4 = view!!.findViewById<ImageButton>(R.id.imageButton4)
        var imagebutton5 = view!!.findViewById<ImageButton>(R.id.imageButton5)
        var imagebutton6 = view!!.findViewById<ImageButton>(R.id.imageButton6)
        var imagebutton7 = view!!.findViewById<ImageButton>(R.id.imageButton7)
        var listSpinner = view!!.findViewById<Spinner>(R.id.spinner)


        /*  スピナーの内部チェック用
        val count = listSpinner.count
        val adapter = listSpinner.adapter
        for(i in 0..count - 1) {
            Log.d("spinner_items${i}", "${adapter.getItem(i)}")
        }
        */

//        listSpinner.setSelection(index)
        // リスナーを登録
        listSpinner.onItemSelectedListener = object : OnItemSelectedListener {
            //　アイテムが選択された時
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {
                val spinner = parent as Spinner
                item = spinner.selectedItem as String
                changeImage(item)
            }

            //　アイテムが選択されなかった
            override fun onNothingSelected(parent: AdapterView<*>) {
                //
            }
        }

        //ToDo TwitterからIDを取ってくる。
        //ToDo ボタン７個ぶん作る
        imagebutton1.setOnClickListener(View.OnClickListener {
            when(item){
                "マグナ星晶獣" -> {

                }
                "旧召喚石マルチ" -> {

                }
                "新召喚石マルチ" -> {

                }
                "4大天司" -> {
                    
                }
                "マグナHL" -> {

                }
                "MAX6人HLバトル" -> {

                }
                "高難易度HL" -> {

                }
                "その他" -> {

                }
            }
        })
    }

    @SuppressLint("ApplySharedPref")
    fun changeImage(item:String) {
        val shardPreference = activity.getPreferences(Context.MODE_PRIVATE)
        val shardEditor = shardPreference.edit()
        imageButton5.layoutParams.height = 200
        imageButton5.isEnabled = true
        imageButton6.layoutParams.height = 200
        imageButton6.isEnabled = true
        imageButton7.layoutParams.height = 0
        imageButton7.isEnabled = false
        return when (item) {
            "マグナ星晶獣" -> {
                println("マグナ")
                shardEditor.putString("item","マグナ星晶獣").commit()
                imageButton1.setImageResource(R.drawable.corossasu_maguna)
                imageButton2.setImageResource(R.drawable.rivaiasan_maguna)
                imageButton3.setImageResource(R.drawable.texiamato_maguna)
                imageButton4.setImageResource(R.drawable.yugudorasiru_maguna)
                imageButton5.setImageResource(R.drawable.shubarie_maguna)
                imageButton6.setImageResource(R.drawable.ceresuto_maguna)
            }
            "旧召喚石マルチ" -> {
                shardEditor.putString("item","旧召喚石マルチ").commit()
                imageButton1.setImageResource(R.drawable.huramu)
                imageButton2.setImageResource(R.drawable.makyura_mariusu)
                imageButton3.setImageResource(R.drawable.nataku)
                imageButton4.setImageResource(R.drawable.medusa)
                imageButton5.setImageResource(R.drawable.aporon)
                imageButton6.setImageResource(R.drawable.d_engel_orivie)
            }
            "新召喚石マルチ" -> {
                shardEditor.putString("item","新召喚石マルチ").commit()
                imageButton1.setImageResource(R.drawable.athena)
                imageButton2.setImageResource(R.drawable.gurani)
                imageButton3.setImageResource(R.drawable.garuda)
                imageButton4.setImageResource(R.drawable.baal)
                imageButton5.setImageResource(R.drawable.odin)
                imageButton6.setImageResource(R.drawable.richi)
            }
            "4大天司" -> {
                shardEditor.putString("item","4大天司").commit()
                imageButton1.setImageResource(R.drawable.micaeru)
                imageButton2.setImageResource(R.drawable.gabriel)
                imageButton3.setImageResource(R.drawable.raphaeru)
                imageButton4.setImageResource(R.drawable.uriel)
                imageButton5.layoutParams.height = 0
                imageButton5.isEnabled = false
                imageButton6.layoutParams.height = 0
                imageButton6.isEnabled = false

            }
            "マグナHL" -> {
                shardEditor.putString("item","マグナHL").commit()
                imageButton1.setImageResource(R.drawable.corossasu_hi)
                imageButton2.setImageResource(R.drawable.rivaiasan_hi)
                imageButton3.setImageResource(R.drawable.texiamato_hi)
                imageButton4.setImageResource(R.drawable.yugudorasiru_hi)
                imageButton5.setImageResource(R.drawable.shubarie_hi)
                imageButton6.setImageResource(R.drawable.ceresuto_hi)
            }
            "MAX6人HLバトル" -> {
                shardEditor.putString("item","MAX6人HLバトル").commit()
                imageButton1.setImageResource(R.drawable.huramu_hi)
                imageButton2.setImageResource(R.drawable.makyura_hi)
                imageButton3.setImageResource(R.drawable.nataku_hi)
                imageButton4.setImageResource(R.drawable.medusa_hi)
                imageButton5.setImageResource(R.drawable.aporon_hi)
                imageButton6.setImageResource(R.drawable.d_engel_orivie_hi)
                imageButton7.setImageResource(R.drawable.losequeen_hi)
                imageButton7.layoutParams.height = 300
                imageButton7.isEnabled = true
            }
            "高難易度HL" -> {
                shardEditor.putString("item","高難易度HL").commit()
                imageButton1.setImageResource(R.drawable.prometheus_hi)
                imageButton2.setImageResource(R.drawable.ca_ong_hi)
                imageButton3.setImageResource(R.drawable.vaivukaha_hi)
                imageButton4.setImageResource(R.drawable.girugameshu_hi)
                imageButton5.setImageResource(R.drawable.hector_hi)
                imageButton6.setImageResource(R.drawable.anubisu_hi)
            }
            "その他" -> {
                shardEditor.putString("item","その他").commit()
                imageButton1.setImageResource(R.drawable.purotobahamuto)
                imageButton2.setImageResource(R.drawable.purotobahamute_hi)
                imageButton3.setImageResource(R.drawable.ultimate_bahamute)
                imageButton4.setImageResource(R.drawable.ultimate_bahamuto_hi)
                imageButton5.setImageResource(R.drawable.kiryuu)
                imageButton6.setImageResource(R.drawable.kurokilin)
                imageButton7.setImageResource(R.drawable.zi_oda_gurande)
                imageButton7.layoutParams.height = 300
                imageButton7.isEnabled = true
            }
            else -> {
                println("バグ")
            }
        }
    }

    fun changeSpinner(item:String):Int {
        when(item){
            "マグナ星晶獣" -> {
                return 0
            }
            "旧召喚石マルチ" -> {
                return 1
            }
            "新召喚石マルチ" -> {
                return 2
            }
            "4大天司" -> {
                return 3
            }
            "マグナHL" -> {
                return 4
            }
            "MAX6人HLバトル" -> {
                return 5
            }
            "高難易度HL" -> {
                return 6
            }
            "その他" -> {
                return 7
            }
        }
        return 0
    }
}


