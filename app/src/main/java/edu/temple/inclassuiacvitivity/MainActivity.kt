package edu.temple.inclassuiacvitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val displayTextView = findViewById<TextView>(R.id.textDisplay)

        /* Step 1: Populate this array */
        val numberArray = Array<Int>(50){ (it + 10)}

        /* Step 2: Create adapter to display items from array in Spinner */
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, numberArray)


        // Step 3: Change TextView's text size to the number selected in the Spinner */
        spinner.onItemSelectedListener = object: OnItemSelectedListener,
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                p0?.run {
                    val size= getItemAtPosition(p2).toString()

                    displayTextView.textSize= size.toFloat()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {            }
            override fun onNavigationItemSelected(item: MenuItem): Boolean {            }
        }

    }
}