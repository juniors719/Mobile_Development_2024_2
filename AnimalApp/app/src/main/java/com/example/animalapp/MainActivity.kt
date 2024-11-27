package com.example.animalapp

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.widget.VideoView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.animalapp.ui.theme.AnimalAppTheme
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument



@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimalAppTheme {
                AnimalApp()
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

// Menu três pontinhos
@Composable
fun AnimalAppMenu(onOptionSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    IconButton(onClick = { expanded = true }) {
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "Menu"
        )
    }

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        DropdownMenuItem(
            text = { Text("Dog") },
            onClick = {
                expanded = false
                onOptionSelected("Dog")
            }
        )
        DropdownMenuItem(
            text = { Text("Cat") },
            onClick = {
                expanded = false
                onOptionSelected("Cat")
            }
        )
        DropdownMenuItem(
            text = { Text("Cow") },
            onClick = {
                expanded = false
                onOptionSelected("Cow")
            }
        )
    }
}

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(onAnimalSelected: (String) -> Unit) {
    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text("Animal App") },
                actions = {
                    AnimalAppMenu(onOptionSelected = onAnimalSelected)
                }
            )
        }
    ) {
        paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Text("Home Screen")
        }
    }
}

@Composable
fun AnimalScreen(animalName: String) {
    val context = LocalContext.current
    val imageRes = if (animalName == "Dog") R.drawable.dog_image else if (animalName == "Cat") R.drawable.cat_image else R.drawable.cow_image
    val soundRes = if (animalName == "Dog") R.raw.dog_sound else if (animalName == "Cat") R.raw.cat_sound else R.raw.cow_sound
    val videoRes = if (animalName == "Dog") R.raw.dog_video else if (animalName == "Cat") R.raw.cat_video else R.raw.cow_video

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Mostrar a imagem do animal
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "$animalName Image",
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Botão para tocar o áudio
        Button(
            onClick = {
                try {
                    val mediaPlayer = MediaPlayer.create(context, soundRes)
                    if(mediaPlayer != null) {
                        mediaPlayer.start()
                        mediaPlayer.setOnCompletionListener {
                            mediaPlayer.release()
                        }
                    } else {
                        println("Erro: MediaPlayer não pode ser criado")
                    }
                } catch (e: Exception) {
                    println("Erro: ${e.message}")
                }
            }
        ) {
            Text("Reproduzir som do animal")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botão para tocar o vídeo
        Button(
            onClick = {
                val intent = Intent(context, VideoPlayerActivity::class.java)
                intent.putExtra("videoRes", videoRes)
                context.startActivity(intent)
            }
        ) {
            Text("Reproduzir vídeo do animal")
        }


    }
}

class VideoPlayerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val videoRes = intent.getIntExtra("videoRes", R.raw.dog_video)
            AndroidView(
                factory = { context ->
                    VideoView(context).apply {
                        setVideoURI(Uri.parse("android.resource://${packageName}/$videoRes"))
                        start()
                    }
                },
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun AnimalApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(onAnimalSelected = { animal ->
                navController.navigate("animal/$animal")
            })
        }
        composable(
            "animal/{animal}",
            arguments = listOf(navArgument("animal") { type = NavType.StringType })
        ) { backStackEntry ->
            val animal = backStackEntry.arguments?.getString("animal") ?: "Dog"
            AnimalScreen(animal)
        }
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}