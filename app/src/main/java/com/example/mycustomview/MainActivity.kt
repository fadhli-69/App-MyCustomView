package com.example.mycustomview

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mycustomview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout with View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set initial button state
        setMyButtonEnable()

        // Add text watcher to EditText
        binding.myEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }
            override fun afterTextChanged(s: Editable) {}
        })

        // Set button click listener
        binding.myButton.setOnClickListener {
            Toast.makeText(this@MainActivity, binding.myEditText.text, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setMyButtonEnable() {
        val result = binding.myEditText.text
        binding.myButton.isEnabled = result != null && result.toString().isNotEmpty()
    }
}
