package com.example.colorfinder2point0

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.SurfaceView
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.*


import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter





class MainActivity : AppCompatActivity() {

    var store1 = intArrayOf(0, 0, 0)
    var store2 = intArrayOf(0, 0, 0)
    var store3 = intArrayOf(0, 0, 0)
    var redValue = 0
    var greenValue = 0
    var blueValue = 0
    var save1: Boolean? = null
    var save2: Boolean? = null
    var save3: Boolean? = null
    var nsave1: Boolean? = null
    var nsave2: Boolean? = null  //populate spinner with an adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        toolbar.setLogo(R.drawable.diamond)


        val textRed = this.findViewById<TextView>(R.id.redText)
        val textBlue = this.findViewById<TextView>(R.id.blueText)
        val textGreen = this.findViewById<TextView>(R.id.greenText)
        val seekBar = this.findViewById<SeekBar>(R.id.redBar)
        val seekBarBlue = this.findViewById<SeekBar>(R.id.blueBar)
        val seekBarGreen = this.findViewById<SeekBar>(R.id.greenBar)
        val loader1 = this.findViewById<Button>(R.id.load1)
        val loader2 = this.findViewById<Button>(R.id.load2)
        val loader3 = this.findViewById<Button>(R.id.load3)
        val save = this.findViewById<Button>(R.id.Confirm)

        var surface = this.findViewById<SurfaceView>(R.id.mirror)

        seekBar.progress = redValue
        seekBarBlue.progress = blueValue
        seekBarGreen.progress = greenValue
        textRed.text = redValue.toString()
        textBlue.text = blueValue.toString()
        textGreen.text = greenValue.toString()
        surface.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue))




        
        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }


            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                redValue = i
                textRed.text = "Red: $redValue"
                val surface:SurfaceView = findViewById(R.id.mirror)

                surface.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue))

            }

        })
        

        loader1.setOnClickListener{
            surface.setBackgroundColor(Color.rgb(store1[0], store1[1], store1[2]))
            seekBar.progress = store1[0]
            seekBarGreen.progress = store1[1]
            seekBarBlue.progress = store1[2]
        }

        loader2.setOnClickListener{
            surface.setBackgroundColor(Color.rgb(store2[0], store2[1], store2[2]))
            seekBar.progress = store2[0]
            seekBarGreen.progress = store2[1]
            seekBarBlue.progress = store2[2]
        }

        loader3.setOnClickListener{
            surface.setBackgroundColor(Color.rgb(store3[0], store3[1], store3[2]))
            seekBar.progress = store3[0]
            seekBarGreen.progress = store3[1]
            seekBarBlue.progress = store3[2]
        }

        save.setOnClickListener{
            if(nsave1 != true) {
                var text1 = txtOut.text
                load1.text = "$text1"
                nsave1 = true
            } else if (nsave2 != true){
                var text2 = txtOut.text
                load2.text = "$text2"
                nsave2 = true
            }else{
                var text3 = txtOut.text
                load3.text = "$text3"
            }
            save.visibility = INVISIBLE
            txtOut.visibility = INVISIBLE
        }


        seekBarBlue.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBarBlue: SeekBar?) {
            }

            override fun onStartTrackingTouch(seekBarBlue: SeekBar?) {
            }


            override fun onProgressChanged(seekBarBlue: SeekBar, i: Int, b: Boolean) {
                blueValue = i
                textBlue.text = "Blue: $blueValue"
                surface.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue))

            }

        })



        seekBarGreen.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBarGreen: SeekBar?) {
            }

            override fun onStartTrackingTouch(seekBarGreen: SeekBar?) {
            }


            override fun onProgressChanged(seekBarGreen: SeekBar, i: Int, b: Boolean) {
                greenValue = i
                textGreen.text = "Green: $greenValue"
                surface.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue))

            }

        })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }



    override fun onOptionsItemSelected(item: MenuItem)= when(item.itemId) {

            R.id.action_store-> {


                if(save1 == true){
                    load1.visibility = VISIBLE
                }
                if(save2 == true){
                    load2.visibility = VISIBLE
                }
                if(save3 == true){
                    load3.visibility = VISIBLE
                }




                true}
            R.id.action_save-> {

                txtOut.visibility = VISIBLE
                Confirm.visibility = VISIBLE

                if(save1 != true) {
                    store1[0] = redValue
                    store1[1] = greenValue
                    store1[2] = blueValue
                    save1 = true


                }else if(save2 != true){
                    store2[0] = redValue
                    store2[1] = greenValue
                    store2[2] = blueValue
                    save2 = true
                }else{
                    store3[0] = redValue
                    store3[1] = greenValue
                    store3[2] = blueValue
                    save3 = true
                }

                val coast= Toast.makeText(applicationContext, "Red: $redValue, Green: $greenValue, Blue: $blueValue ", Toast.LENGTH_LONG)
                coast.show()
                true
            }

        else -> {
            super.onOptionsItemSelected(item)
        }

    }
}
