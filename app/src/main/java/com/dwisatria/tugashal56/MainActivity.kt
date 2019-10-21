package com.dwisatria.tugashal56

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*
import android.widget.CheckBox
import android.widget.RadioButton

class MainActivity : AppCompatActivity() {
        var edDate: EditText?=null
        var cal=Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            edDate = this.dateRelease

            val dateSetListener = object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(
                    view: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int
                ) {
                    cal.set(Calendar.YEAR, year)
                    cal.set(Calendar.MONTH, monthOfYear)
                    cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    updateDateInView()
                }
            }

            edDate!!.setOnClickListener(object : View.OnClickListener {
                override fun onClick(view: View) {
                    DatePickerDialog(
                        this@MainActivity,
                        dateSetListener,
                        cal.get(Calendar.YEAR),
                        cal.get(Calendar.MONTH),
                        cal.get(Calendar.DAY_OF_MONTH)
                    ).show()
                }
            })

            lateinit var btnproses: Button
            lateinit var title: EditText
            lateinit var directed: EditText
            lateinit var production: EditText
            lateinit var checkBox1: CheckBox
            lateinit var checkBox2: CheckBox
            lateinit var checkBox3: CheckBox
            lateinit var checkBox4: CheckBox
            lateinit var checkBox5: CheckBox
            lateinit var checkBox6: CheckBox
            lateinit var radioButton1: RadioButton
            lateinit var radioButton2: RadioButton
            lateinit var radioButton3: RadioButton
            lateinit var country: Spinner
            lateinit var dateRelease: EditText

            btnproses = findViewById(R.id.btnproses)
            title = findViewById(R.id.title)
            directed = findViewById(R.id.directed)
            production = findViewById(R.id.production)
            checkBox1 = findViewById(R.id.checkBox1)
            checkBox2 = findViewById(R.id.checkBox2)
            checkBox3 = findViewById(R.id.checkBox3)
            checkBox4 = findViewById(R.id.checkBox4)
            checkBox5 = findViewById(R.id.checkBox5)
            checkBox6 = findViewById(R.id.checkBox6)
            radioButton1 = findViewById(R.id.radioButton1)
            radioButton2 = findViewById(R.id.radioButton2)
            radioButton3 = findViewById(R.id.radioButton3)
            country = findViewById(R.id.country)
            dateRelease = findViewById(R.id.dateRelease)

            btnproses.setOnClickListener{
                val title = title.text.toString()
                val directed = directed.text.toString()
                val production = production.text.toString()
                val checkBox1 = checkBox1.isChecked
                val checkBox2 = checkBox2.isChecked
                val checkBox3 = checkBox3.isChecked
                val checkBox4 = checkBox4.isChecked
                val checkBox5 = checkBox5.isChecked
                val checkBox6 = checkBox6.isChecked
                val radioButton1 = radioButton1.isChecked
                val radioButton2 = radioButton2.isChecked
                val radioButton3 = radioButton3.isChecked
                var ageRes = ""
                var checkBoxs1 = ""
                var checkBoxs2 = ""
                var checkBoxs3 = ""
                var checkBoxs4 = ""
                var checkBoxs5 = ""
                var checkBoxs6 = ""
                if (radioButton1) {
                    ageRes = " Under 13th "
                }
                if (radioButton2) {
                    ageRes = " 13th Until 18th "
                }
                if (radioButton3) {
                    ageRes = " 18th and Above "
                }
                if (checkBox1) {
                   checkBoxs1 = " Horror "
                }
                if (checkBox2) {
                    checkBoxs2 = " Thriller "
                }
                if (checkBox3) {
                    checkBoxs3 = " Comedy "
                }
                if (checkBox4) {
                    checkBoxs4 = " Romance "
                }
                if (checkBox5) {
                    checkBoxs5 = " Action "
                }
                if (checkBox6) {
                    checkBoxs6 = " Fantasy "
                }
                var country = country.selectedItem.toString()
                var dateRelease = dateRelease.text.toString()

                val intent = Intent(this@MainActivity, ActivityKedua::class.java)
                // start your next activity
                intent.putExtra("title", title)
                intent.putExtra("directed", directed)
                intent.putExtra("production", production)
                intent.putExtra("checkBox1", checkBoxs1)
                intent.putExtra("checkBox2", checkBoxs2)
                intent.putExtra("checkBox3", checkBoxs3)
                intent.putExtra("checkBox4", checkBoxs4)
                intent.putExtra("checkBox5", checkBoxs5)
                intent.putExtra("checkBox6", checkBoxs6)
                intent.putExtra("ageRes", ageRes)
                intent.putExtra("country", country)
                intent.putExtra("dateRelease", dateRelease)
                startActivity(intent)
            }
    }
        private fun updateDateInView(){
            val myFormat = "MM/dd/yyyy"
            val sdf = SimpleDateFormat(myFormat, Locale.US)

            edDate!!.setText(sdf.format(cal.getTime()))
        }
}