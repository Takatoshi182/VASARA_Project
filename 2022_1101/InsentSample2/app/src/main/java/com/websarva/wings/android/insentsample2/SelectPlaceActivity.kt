package com.websarva.wings.android.insentsample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class SelectPlaceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_place)
        //リスト画面から渡されたデータを取得
        val menuCity=intent.getStringExtra("menuCity")
        val menuPlace=intent.getStringExtra("menuPlace")
        //市名と県名を表示させるTextViewを取得
        val tvCityName=findViewById<TextView>(R.id.tvCityName)
        val tvPlaceName =findViewById<TextView>(R.id.tvPlaceName)
        //TextViewに市名と県名を表示
        tvCityName.text = menuCity
        tvPlaceName.text = menuPlace
    }
    //戻るボタンを押したときの処理
    fun onBackButtonClick(view: View) {
        finish()
    }
}