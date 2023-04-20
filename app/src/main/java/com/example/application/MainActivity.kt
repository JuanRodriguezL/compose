package com.example.application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDirection.Companion.Content
import androidx.compose.ui.tooling.preview.Preview

import com.example.application.ui.theme.ApplicationTheme
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApplicationTheme {
                 ContentMain()
            }
        }
    }

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun ContentMain() {
        Scaffold(modifier=Modifier.fillMaxSize(),
            backgroundColor = MaterialTheme.colors.background,
            bottomBar = {
                BottomAppBar() {

                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                    Spacer(modifier = Modifier.weight(1f, true))
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.MoreVert, contentDescription = "Opciones")

                    }
                }
            },
         floatingActionButton = {
             FloatingActionButton(onClick = { /*TODO*/ }) {
                 Icon(Icons.Filled.Add , contentDescription = null)
             }
         }, floatingActionButtonPosition = FabPosition.Center,
            isFloatingActionButtonDocked = true

            ) { padding -> Content(Modifier.padding(padding))

        }
    }
}





