package com.example.happybirthday

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    //color = MaterialTheme.colorScheme.background
                ) {
                    //texto que se mostrara en la aplicación
                    GreetingImage(
                        message = "¡Feliz Cumpleaños Miriam!",
                        from = "De Luis",
                        //modifier=Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}
@Composable
fun GreetingText(message: String,from:String,modifier: Modifier=Modifier){
   //ajustar texto función parecida a la que se emplea en flutter dart
    Column(     //centrar saludo
        verticalArrangement =Arrangement.Center,
        //dp es padding
        modifier=modifier
    ) {

        Text(
            //texto
            text = message,
            //fuente se ajusta de acuerdo al tamaño del texto se emplea sp para aumentar el tamaño de la letra
            fontSize = 100.sp,
            //linea de salto
            lineHeight = 116.sp,
            //Ajustar texto al inicio
            textAlign = TextAlign.Center

        )
        Text(
            text = from,
            fontSize = 36.sp,
                    modifier = Modifier
                    .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}
@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box(modifier){
        Image(
        painter = image,
        contentDescription = null,
            contentScale = ContentScale.Crop,
            //cambiar opacidad de la imagen
            alpha= 0.5F
    )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }

}


// Como práctica recomendada, las funciones siempre deben tener un nombre que describa su funcionalidad.
@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
      //  Greeting("Luis")
        //texto para la visualización del diseño en tiempo real
        GreetingImage(
            message = "¡Feliz Cumpleaños Miriam!",
            from = "De Luis"
        )
    }
}
