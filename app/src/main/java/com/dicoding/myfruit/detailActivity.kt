package com.dicoding.myfruit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView


class detailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val myfruit = intent.getParcelableExtra(MainActivity.INTENT_PARCELABLE)

        val photo = findViewById<ImageView>(R.id.detail_image_fruit)
        val name = findViewById<TextView>(R.id.tv_detail_name)
        val description = findViewById<TextView>(R.id.tv_detail_DescFruit)
        val khasiat = findViewById<TextView>(R.id.tv_detail_khasiat)

        photo.setImageResource(myfruit.photo)

        intent.getParcelableArrayListExtra(EXTRA_PERSON, myfruit::class.java)
    }

//    class intent {
//        class getParcelableExtra<T>(
//            val name: String,
//            val description: String,
//            val photo: Int?,
//            val khasiat: String
//        )
//    }
}