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
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fantasmas_dev.compose_list_app_with_themming.data.Dog
import com.fantasmas_dev.compose_list_app_with_themming.data.dogs
import com.fantasmas_dev.compose_list_app_with_themming.ui.theme.Compose_list_app_with_theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose_list_app_with_theme {
                DogsApp()
            }
        }
    }
}

@Composable
fun AppHeader(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
        ,
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

@Composable
fun DogCard(dog: Dog, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = 8.dp,
                end = 8.dp
            )
            .clip(MaterialTheme.shapes.medium)
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
                        .padding(start = 8.dp)
                        .clip(MaterialTheme.shapes.small),
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
                    ),
            ) {
                Text(
                    text = stringResource(id = dog.name),
                    maxLines = 1
                )
                Text(
                    text = dog.age.toString(),
                    maxLines = 1,
                    modifier = Modifier
                )
            }
        }


    }
}

@Composable
fun DogsList(dogList: List<Dog>, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { AppHeader() }
    ) {
        padding ->
        LazyColumn(modifier = modifier, contentPadding = padding) {
        items(dogList) { dog ->
            DogCard(
                dog = dog,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
    }
}


@Composable
fun DogsApp() {
    val layoutDirection = LocalLayoutDirection.current
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                start = WindowInsets.safeDrawing
                    .asPaddingValues()
                    .calculateStartPadding(layoutDirection),
                end = WindowInsets.safeDrawing
                    .asPaddingValues()
                    .calculateEndPadding(layoutDirection)
            )
    ) {
        Column {
            DogsList(dogList = dogs)
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun AppPreview() {
    Compose_list_app_with_theme {
        DogsApp()
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun DarkThemeAppPreview() {
    Compose_list_app_with_theme(darkTheme = true) {
        DogsApp()
    }
}