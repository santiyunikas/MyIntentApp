package com.santiyunikas.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object{
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveActivityWithData: Button = findViewById(R.id.btn_move_activity_w_data)
        btnMoveActivityWithData.setOnClickListener(this)

        val btnDialANumber: Button = findViewById(R.id.dial_a_number)
        btnDialANumber.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_move_activity ->{
               val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_activity_w_data ->{
                val moveWithDataIntent = Intent(this@MainActivity, MoveActivity::class.java)
                moveWithDataIntent.putExtra(MainActivity.EXTRA_NAME, "Santi Yunika Sufiana")
                moveWithDataIntent.putExtra(MainActivity.EXTRA_AGE, 22)
                startActivity(moveWithDataIntent)
            }
            R.id.dial_a_number ->{
                val phoneNumber: String = "08221234567890"
                val moveDialANumberIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel: $phoneNumber"))
                startActivity(moveDialANumberIntent)
            }
        }
    }
}
