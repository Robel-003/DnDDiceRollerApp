package com.example.dicerollerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dicerollerapp.ui.theme.DiceRollerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DiceRollerApp()
                }
            }
        }
    }
}



@Composable
// by passing the modifier with a default value,
// you don't need to give a value when calling this function
//.wrapContentSize(Alignment.Center) this aligns the content in the center
// spacer (Spacer(modifier = Modifier.height(26.dp))) composable adds spacing between components in a UI
fun DiceWithButtonAndImage(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)) {

    // if result value changes, mutableStateOf will trigger a recomposition for the updated value
    var result by remember { mutableStateOf(1) }

    val imageResource = when (result) {
        1 -> R.drawable.d20_1
        2 -> R.drawable.d20_2
        3 -> R.drawable.d20_3
        4 -> R.drawable.d20_4
        5 -> R.drawable.d20_5
        6 -> R.drawable.d20_6
        7 -> R.drawable.d20_7
        8 -> R.drawable.d20_8
        9 -> R.drawable.d20_9
        10 -> R.drawable.d20_10
        11 -> R.drawable.d20_11
        12 -> R.drawable.d20_12
        13 -> R.drawable.d20_13
        14 -> R.drawable.d20_14
        15 -> R.drawable.d20_15
        16 -> R.drawable.d20_16
        17 -> R.drawable.d20_17
        18 -> R.drawable.d20_18
        19 -> R.drawable.d20_19
        else -> R.drawable.d20_20
    }

    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = result.toString()
        )
        Spacer(modifier = Modifier.height(26.dp))
        Button(onClick = {
            result = (1..20).random()
        }) {
            Text(text = stringResource(R.string.roll))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage()
}