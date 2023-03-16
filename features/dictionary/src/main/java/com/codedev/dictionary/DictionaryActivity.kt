package com.codedev.dictionary

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.compose.runtime.Composable
import androidx.activity.compose.setContent
import com.codedev.base.BaseAppTheme

class DictionaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaseAppTheme {
                DictionaryGraph()
            }
        }

    }
}