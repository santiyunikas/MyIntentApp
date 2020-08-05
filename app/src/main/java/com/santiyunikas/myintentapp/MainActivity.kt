package com.santiyunikas.myintentapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable
import kotlin.math.log


class MainActivity : AppCompatActivity(), View.OnClickListener, Serializable {

    var objectName: String = ""
    var objectAge: Int = 0

        get() = field

        set(value) {
        field = value
        }

    companion object{
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_OBJECT = "extra_object"
        const val REQUEST_CODE = "extra_request_code"
        const val EXTRA_RESULT = "extra_result"
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

        val btnMoveActivityWithObject: Button = findViewById(R.id.btn_move_activity_w_object)
        btnMoveActivityWithObject.setOnClickListener(this)

        val btnMoveActivityForResult: Button = findViewById(R.id.btn_move_activity_for_result)
        btnMoveActivityForResult.setOnClickListener(this)

        val tvResult: TextView = findViewById(R.id.tv_result)
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
            R.id.btn_move_activity_w_object ->{
                val moveWithObjectIntent = Intent(this@MainActivity, MoveActivity::class.java)
                val itObject: MainActivity = MainActivity()
                itObject.objectName = "Object Santi"
                itObject.objectAge = 22
                moveWithObjectIntent.putExtra(MainActivity.EXTRA_OBJECT, itObject)
                startActivity(moveWithObjectIntent)
            }
            R.id.btn_move_activity_for_result ->{
                val moveActivityForResult = Intent(this@MainActivity, MoveActivity::class.java)
                moveActivityForResult.putExtra(MainActivity.REQUEST_CODE, 1)
                startActivityForResult(moveActivityForResult, 1)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode === 1) {
            if (resultCode === Activity.RESULT_OK) {
                val result = data?.getStringExtra(MainActivity.EXTRA_RESULT)
                tv_result.text = result
            }
            if (resultCode === Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }
}



