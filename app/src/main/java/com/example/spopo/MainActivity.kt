package com.example.spopo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spopo.ui.theme.SPOPOTheme
import androidx.compose.ui.graphics.Color


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SPOPOTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                }
            }
        }
    }
}


@Composable
fun MyImageComposable() {
    Image(
        painter = painterResource(id = R.drawable.myimage),
        contentDescription = "My image",
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 6.dp)
            .height(300.dp) // Adjust the height as needed
    )
}

@Composable
fun TheTitle() {
    Text(
        text = "Dictionary",
        fontSize = 50.sp,
        modifier = Modifier.padding(top = 32.dp, start = 90.dp)
    )
}

@Composable
fun SubTitle() {
    Text(
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp,
        text = "Find your definition, synonyms, antonyms",
        modifier = Modifier.padding(top = 8.dp, start = 65.dp)
    )
}

@Composable
fun TextField() {
    var textValue by remember { mutableStateOf("") }

    TextField(
        value = textValue,
        onValueChange = { textValue = it },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Text
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                // Perform an action when the user presses the Done/Enter button on the keyboard
            }
        ),
        singleLine = true,
        placeholder = { Text("Enter text here...") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 6.dp, end = 4.dp)
            .height(50.dp) // Adjust the height as needed
            .border(width = 2.dp, color = Color.Blue, shape = MaterialTheme.shapes.medium)
    )
}

@Composable
fun SimpleButtonScreen() {
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 6.dp, end = 4.dp)
    ) {
        Text(text = "Click me!")
    }
}

@Preview(showBackground = true)
@Composable
fun MyImageComposablePreview() {
    SPOPOTheme {
        Column(Modifier.fillMaxSize()) {
            MyImageComposable()
            TheTitle()
            SubTitle()
            TextField()
            SimpleButtonScreen()
        }
    }
}


