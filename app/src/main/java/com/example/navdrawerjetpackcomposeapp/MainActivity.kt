package com.example.navdrawerjetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.navdrawerjetpackcomposeapp.ui.theme.NavDrawerJetpackComposeAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavDrawerJetpackComposeAppTheme {
                // A surface container using the 'background' color from the theme

                val scaffoldState = rememberScaffoldState()

                val scope = rememberCoroutineScope()



                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        AppBar(onNavigationIconClick = {

                            scope.launch {

                                scaffoldState.drawerState.open()

                            }


                        })
                    },
                    drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
                    drawerContent = {
                        DrawerHeader()
                        DrawerBody(items = listOf(
                            MenuItem(
                                id = "home",
                                title = "Home",
                                contentDescription = "Go to home Screen",
                                icon = Icons.Default.Home
                            ),

                            MenuItem(
                                id = "settings",
                                title = "Settings",
                                contentDescription = "Go to settings Screen",
                                icon = Icons.Default.Settings
                            ),


                            MenuItem(
                                id = "help",
                                title = "Help",
                                contentDescription = "Go to help Screen",
                                icon = Icons.Default.Info
                            ),

                            ),
                            onItemClick = {


                                println("Clicked on ${it.title}")
                            })


                    }){

                    println("$it")

                }
            }
        }
    }
}

