package com.santiyunikas.myintentapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_move.*

class MoveActivity : AppCompatActivity(), View.OnClickListener{

    companion object{
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_OBJECT = "extra_object"
        const val REQUEST_CODE = "extra_request_code"
        const val EXTRA_RESULT = "extra_result"
    }

    var result = "defaultValue"
    get() = field
    set(value) {field = value}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move)
        val tvMove: TextView = findViewById(R.id.tvMove)

        val name = intent.getStringExtra(MoveActivity.EXTRA_NAME)
        val age = intent.getIntExtra(MoveActivity.EXTRA_AGE, 0)

        val itObject = intent.getSerializableExtra(MoveActivity.EXTRA_OBJECT) as MainActivity?

        val requestCode = intent.getIntExtra(MoveActivity.REQUEST_CODE, 0)

        val lineLayInside: LinearLayout = findViewById(R.id.line_lay_inside)
        lineLayInside.visibility = View.INVISIBLE
        val radBtn10: RadioButton = findViewById(R.id.radioButton10)
        val radBtn20: RadioButton = findViewById(R.id.radioButton20)
        val radBtn30: RadioButton = findViewById(R.id.radioButton30)
        val btnResult: Button = findViewById(R.id.btn_result)
        btnResult.setOnClickListener(this)

        if (name != null && age != null){
            tvMove.text = """Name: $name
            Age: $age
        """.trimIndent()
        }else if (itObject != null){
            tvMove.text = """Name: ${itObject.objectName}
                |Age: ${itObject.objectAge}
            """.trimMargin()
        }else if (requestCode == 1){
            lineLayInside.visibility = View.VISIBLE
        }
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                radioButton10.id ->
                    if (checked) {
                        this.result = radioButton10.text.toString().trim()
                    }
                radioButton20.id ->
                    if (checked) {
                        this.result = radioButton20.text.toString().trim()
                    }
                radioButton30.id ->{
                    if (checked) {
                        this.result = radioButton30.text.toString().trim()
                    }
                }
            }
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_result ->{
                val resultIntent = Intent(this@MoveActivity, MainActivity::class.java)
                resultIntent.putExtra(MoveActivity.EXTRA_RESULT, this.result)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
        }
    }


}
