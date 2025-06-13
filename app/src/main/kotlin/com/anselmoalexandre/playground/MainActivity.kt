package com.anselmoalexandre.playground

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.anselmoalexandre.playground.ui.component.PlaygroundRadioButton
import com.anselmoalexandre.playground.ui.theme.PlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlaygroundTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->
                    Content(
                        modifier = Modifier.padding(
                            paddingValues = innerPadding,
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun Content(
    modifier: Modifier = Modifier,
) {
    var selected by rememberSaveable { mutableStateOf(true) }

    Surface(
        color = Color.Transparent.copy(alpha = .5f),
        shape = RectangleShape,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
    ) {
        PlaygroundRadioButton(
            icon = android.R.drawable.ic_menu_share,
            selected = selected,
            onSelectedChange = { state ->
                selected = state
                Log.d("RadioButton", "$selected")
            },
            enabled = false,
            modifier = modifier,
        )
    }
}

@Composable
fun Loader(
    modifier: Modifier = Modifier
) {
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(
            resId = R.raw.loader
        )
    )

    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever,
    )

    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = Modifier
            .requiredSize(
                width = 48.dp,
                height = 48.dp
            ),
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PlaygroundTheme {
        Content()
    }
}
