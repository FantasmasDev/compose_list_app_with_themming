package com.fantasmas_dev.compose_list_app_with_themming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fantasmas_dev.compose_list_app_with_themming.data.Dog
import com.fantasmas_dev.compose_list_app_with_themming.ui.theme.Compose_list_app_with_themmingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose_list_app_with_themmingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        Greeting(
                            name = "Android",
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun AppHeader(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_woof_logo),
            contentDescription = null,
        )
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier
                .padding(start = 8.dp)
        )
    }
}

//fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
//    Card(modifier = modifier) {
//        Column {
//            Image(
//                painter = painterResource(id = affirmation.imagerResourceId),
//                contentDescription = stringResource(id = affirmation.stringResourceId),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(194.dp),
//                contentScale = ContentScale.Crop
//            )
//            Text(
//                text = LocalContext.current.getString(affirmation.stringResourceId),
//                modifier = Modifier.padding(16.dp),
//                style = MaterialTheme.typography.headlineSmall
//            )
//        }
//    }
//}

@Composable
fun DogCard(dog: Dog, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = 8.dp,
                end = 8.dp
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box {
                Image(
                    painter = painterResource(id = dog.imageResourceId),
                    contentDescription = stringResource(id = dog.name),
                    modifier = Modifier
                        .size(width = 68.dp, height = 68.dp)
                        .aspectRatio(1f)
                        .padding(start = 8.dp),
                    contentScale = ContentScale.Crop
                )


            }
            Column(
                modifier = Modifier
                    .padding(
                        top = 16.dp,
                        end = 16.dp,
                        start = 16.dp,
                        bottom = 16.dp
                    )
            ) {
                Text(
                    text = stringResource(id = dog.name),
                    maxLines = 1
                )
                Text(
                    text = dog.age.toString(),
                    maxLines = 1,
                    modifier = Modifier
                        .padding(
                            top = 16.dp,
                        )
                )
            }
        }


    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    AppHeader()
    DogCard(dog = Dog(R.drawable.koda, R.string.dog_name_1, 2, R.string.dog_description_1))
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    Compose_list_app_with_themmingTheme {
        Greeting("Android")
    }
}