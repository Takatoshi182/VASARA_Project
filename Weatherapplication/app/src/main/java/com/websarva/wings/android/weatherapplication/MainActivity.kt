package com.websarva.wings.android.weatherapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SimpleAdapter
import com.websarva.wings.android.weatherapplication.PlaceConfirmDialogFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //ListViewオブジェクトを取得
        val lvMenu = findViewById<ListView>(R.id.lvMenu)
        //MutableListオブジェクトを用意
        val menuList:MutableList<MutableMap<String,String>> =mutableListOf()
        //リストビューに表示するリストデータを作成
        var menu = mutableMapOf("name" to "札幌","place" to "北海道")
        menuList.add(menu)
         menu = mutableMapOf("name" to "仙台","place" to "宮城県")
        menuList.add(menu)
         menu = mutableMapOf("name" to "東京","place" to "東京都")
        menuList.add(menu)
         menu = mutableMapOf("name" to "名古屋","place" to "愛知県")
        menuList.add(menu)
         menu = mutableMapOf("name" to "大阪","place" to "大阪府")
        menuList.add(menu)
         menu = mutableMapOf("name" to "広島","place" to "広島県")
        menuList.add(menu)
         menu = mutableMapOf("name" to "高松","place" to "香川県")
        menuList.add(menu)
         menu = mutableMapOf("name" to "福岡","place" to "福岡県")
        menuList.add(menu)
        //SimpleAdapter第4引数from用データの用意
        val from = arrayOf("name","place")
        //SimpleAdapter第5引数to用データの用意
        val to = intArrayOf(android.R.id.text1,android.R.id.text2)
        //SimpleAdapter生成
        val adapter = SimpleAdapter(this@MainActivity,menuList,android.R.layout.simple_list_item_2,from,to)
        //アダプタオブジェクトを生成
        //val adapter = ArrayAdapter(this@MainActivity,android.R.layout.simple_list_item_1,menuList)
        //リストビューにアダプタaブジェクトを設定
        lvMenu.adapter = adapter
        //リストビューにリスナを設定
        lvMenu.onItemClickListener=ListItemClickListener()
    }
    //リストがタップされたときの処理が記述されたメンバクラス
    private inner class ListItemClickListener: AdapterView.OnItemClickListener{
        override fun onItemClick(parent:AdapterView<*>, view: View, position:Int, id:Long) {
            //注文確認ダイアログフラグメントオブジェクトを生成
            val dialogFragment = PlaceConfirmDialogFragment()
            //ダイアログ表示
            dialogFragment.show(supportFragmentManager, "PlaceConfirmDialogFragment")
        }
    }
}