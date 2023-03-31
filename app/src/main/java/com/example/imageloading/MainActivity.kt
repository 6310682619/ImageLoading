ipackage com.example.imageloading

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.imageloading.ui.theme.ImageLoadingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageLoadingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column() {
                        Row() {
                            DisplayImage(src = "https://selectkennels.ca/wp-content/uploads/2022/04/IMG_2827.jpg")
                            DisplayImage(src = "https://i.imgur.com/erkff32.jpeg")
                        }
                        Row() {
                            DisplayImage(src = "https://i.imgur.com/4nusSJC.jpeg")
                            DisplayImage(src = "https://i.imgur.com/22hjQd1.jpeg")
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun DisplayImage(src: String,modifier: Modifier = Modifier) {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(src)
                    .crossfade(true)
                    .build(),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.clip(CircleShape).width(210.dp).height(420.dp)
            )

}

