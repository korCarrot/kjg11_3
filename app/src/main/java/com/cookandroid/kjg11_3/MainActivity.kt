package com.cookandroid.kjg11_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "스피너 테스트"

        var movie = arrayOf("쿵푸팬더", "짱구는 못말려",
            "아저씨", "아바타", "대부", "국가대표", "토이스토리3",
            "마당을 나온 암탉", "죽은 시인의 사회", "서유기")

        var spinner = findViewById<Spinner>(R.id.spinner1)
        var imageView = findViewById<ImageView>(R.id.ivPoster)

        var adapter: ArrayAdapter<String>
        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, movie)
        spinner.adapter = adapter

      spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
          override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
              val selectedItem=p0?.getItemAtPosition(p2).toString()
              val drawableId = getImageId(selectedItem)
              if (drawableId != 0) {
                  imageView.setImageResource(drawableId)
              }
              Toast.makeText(applicationContext, "Selected: $selectedItem", Toast.LENGTH_SHORT).show()
          }

          override fun onNothingSelected(p0: AdapterView<*>?) {

          }
      }
    }

    private fun getImageId(item:String):Int{
        return when (item){
            "쿵푸팬더" -> R.drawable.mov21
                "짱구는 못말려" -> R.drawable.mov22
                "아저씨" -> R.drawable.mov23
                "아바타" -> R.drawable.mov24
                "대부" -> R.drawable.mov25
                "국가대표" -> R.drawable.mov26
                "토이스토리3" -> R.drawable.mov27
                "마당을 나온 암탉" -> R.drawable.mov28
                "죽은 시인의 사회" -> R.drawable.mov29
                "서유기" -> R.drawable.mov30
            else -> 0
        }
    }
}

