package com.example.homeworkseven

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.appcompat.widget.AppCompatEditText
import com.example.homeworkseven.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAddField.setOnClickListener {
            if(binding.etEnterFieldName.text.toString().isEmpty()){
                showConfirmationDialog(binding.cbNumeric)

            }else{
                addField(binding.etEnterFieldName.text.toString(), binding.cbNumeric)

            }
        }

    }
    private fun showConfirmationDialog(checkbox: AppCompatCheckBox) {
        val builder = AlertDialog.Builder(this)

        builder.setTitle("Confirmation")
            .setMessage("Are you sure you want to add a field without name?")
            .setPositiveButton("Yes") { dialog: DialogInterface?, _: Int ->
                addField("", checkbox)
                dialog?.dismiss()
            }
            .setNegativeButton("No") { dialog: DialogInterface?, _: Int ->

                dialog?.dismiss()
            }

        val dialog = builder.create()
        dialog.show()
    }

    private fun addField(input: String, checkbox: AppCompatCheckBox){
        val newEditText = AppCompatEditText(this)
        newEditText.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        if(checkbox.isChecked){
            newEditText.inputType = InputType.TYPE_CLASS_NUMBER
        }
        newEditText.hint = input
        binding.layoutLinear.addView(newEditText)
    }
}