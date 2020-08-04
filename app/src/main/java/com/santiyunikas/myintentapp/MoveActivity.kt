package com.santiyunikas.myintentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move)

        val name = intent.getStringExtra(MoveActivity.EXTRA_NAME)
        val age = intent.getIntExtra(MoveActivity.EXTRA_AGE, 0)

        val tvMove: TextView = findViewById(R.id.tvMove)

        if (name != null && age != null)
            tvMove.text = """Name: $name
            Age: $age
        """.trimIndent()
    }

}
