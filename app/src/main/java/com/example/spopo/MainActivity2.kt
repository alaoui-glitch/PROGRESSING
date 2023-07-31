package com.example.spopo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spopo.ui.theme.SPOPOTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SPOPOTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    OnionCard()
                    TabLayoutDemo()                }
            }
        }
    }
}


@Composable
fun OnionCard() {
    Card(
        backgroundColor = Color(0xFF191970), // Midnight Blue color
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 4.dp,
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Onion",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Text(
                text = "Show IPA",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFCD5C5C), // Indian Red
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Text(
                text = "[ˈʌnjən]",
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TabLayoutDemo() {
    var selectedTabIndex by remember { mutableStateOf(0) }

    val tabs = listOf("Tab 1", "Tab 2", "Tab 3")

    Scaffold(

        content = {
            Column(modifier = Modifier.fillMaxSize()) {
                TabRow(
                    selectedTabIndex = selectedTabIndex,
                    backgroundColor = Color.White, // Set tab row background color
                    contentColor = Color.Black // Set tab content color
                ) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTabIndex == index,
                            onClick = { selectedTabIndex = index },
                            text = { Text(text = title) }
                        )
                    }
                }

                // Show different content based on the selected tab index
                when (selectedTabIndex) {
                    0 -> TabContent("Content for Tab 1")
                    1 -> TabContent("Content for Tab 2")
                    2 -> TabContent("Content for Tab 3")
                }
            }
        }
    )
}

@Composable
fun TabContent(content: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = content)
            Spacer(modifier = Modifier.height(8.dp))
            // You can add more content specific to each tab here
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SPOPOTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White), // Add a background color
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OnionCard()
            Spacer(modifier = Modifier.height(40.dp)) // Add some spacing between OnionCard and MyTabLayout
            TabLayoutDemo()        }
    }
}

