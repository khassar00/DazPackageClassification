// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.



import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

import util.Zip

import java.io.File
import java.util.*
import javax.swing.JPanel


@Composable
@Preview
fun App() {

    var text by remember { mutableStateOf("Hello, World!") }

    var untreatedfile=Hashtable<String,String>()
    MaterialTheme {
        Button(onClick = {



        }) {

            Text("TEST")

        }

    }


}



fun main() = application {
    val icon = painterResource("icon.png")
    Window(onCloseRequest = ::exitApplication
    ,icon = icon)
    {

        App()

    }
}
