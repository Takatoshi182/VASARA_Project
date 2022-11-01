package com.websarva.wings.android.insentsample2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //画面部品ListViewを取得
        val lvSelect = findViewById<ListView>(R.id.lvSelect)
        //SimpleAdapterで試用する「MutableListオブジェクトを用意
        val menuSelect: MutableList<MutableMap<String, String>> = mutableListOf()
        //リストビューに表示するリストデータを作成
        var select = mutableMapOf("city" to "札幌", "place" to "北海道")
        menuSelect.add(select)
        select = mutableMapOf("city" to "仙台", "place" to "宮城県")
        menuSelect.add(select)
        select = mutableMapOf("city" to "東京", "place" to "東京都")
        menuSelect.add(select)
        select = mutableMapOf("city" to "名古屋", "place" to "愛知県")
        menuSelect.add(select)
        select = mutableMapOf("city" to "大阪", "place" to "大阪府")
        menuSelect.add(select)
        select = mutableMapOf("city" to "広島", "place" to "広島県")
        menuSelect.add(select)
        select = mutableMapOf("city" to "高松", "place" to "香川県")
        menuSelect.add(select)
        select = mutableMapOf("city" to "福岡", "place" to "福岡県")
        menuSelect.add(select)

        //SimpleAdapter第4引数from用のデータ用意
        val from = arrayOf("city", "place")
        //SimpleAdapter第５引数to用のデータ用意
        val to = intArrayOf(android.R.id.text1, android.R.id.text2)
        //SimpleAdapterを作成
        val adapter = SimpleAdapter(
            this@MainActivity, menuSelect,
            android.R.layout.simple_list_item_2, from, to
        )
        //アダプタの登録
        lvSelect.adapter = adapter
        //リストタップのリスナクラス登録
        lvSelect.onItemClickListener = ListItemClickListener()
    }
    //リストがタップされあた時の処理が記述されたメンバクラス
    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            //タップされた行のデータを取得
            val item = parent.getItemAtPosition(position) as MutableMap<String, String>
            //市名と県名を取得
            val menuCity = item["city"]
            val menuPlace = item["place"]
            //インテントオブジェクトを生成
            val intent2SelectPlace = Intent(
                this@MainActivity,
                SelectPlaceActivity::class.java
            )
            //第２画面に送るデータを格納"menuPlace"
            intent2SelectPlace.putExtra("menuCity", menuCity)
            intent2SelectPlace.putExtra("menuPlace", menuPlace)
            //第２画面起動
            startActivity(intent2SelectPlace)
        }
    }
}


