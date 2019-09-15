package com.example.turismo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFunc()
    }

    private fun initFunc(){
        //implement button action
        btn_scan.setOnClickListener{
            initScan()
        }
    }

    private fun initScan(){
        IntentIntegrator(this).initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data )

        if(result != null){
            if(result.contents == null){
                Toast.makeText(this,"The data is empty", Toast.LENGTH_LONG).show()
            }else{
                et_value.setText(result.contents.toString())
            }
        }else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
