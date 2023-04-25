package co.datadome.sample.samplesdkappjetpack

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.datadome.sample.samplesdkappjetpack.ui.theme.SampleSDKAppJetPackTheme
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val dataDomeViewModel: DataDomeViewModel by viewModels<DataDomeViewModel>()
    //private var response = mutableStateOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleSDKAppJetPackTheme {
                var response = remember {
                    mutableStateOf("")
                }
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Greeting()
                    Column(
                        // on below line we are adding a modifier to it
                        // and setting max size, max height and max width
                        modifier = Modifier
                            .fillMaxSize()
                            .fillMaxHeight()
                            .fillMaxWidth(),
                        // on below line we are adding vertical
                        // arrangement and horizontal alignment.
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // on below line we are adding spacer
                        Spacer(modifier = Modifier.height(10.dp))
                        // on below line we are creating a button
                        Button(
                            onClick = {
                                // on below line we are calling make payment method to update data.
                                response.value = dataDomeViewModel.data.value
                               // response = dataDomeViewModel.data
                                Log.d("Response", response.value)
                            },
                            // on below line we are adding modifier to our button.
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            // on below line we are adding text for our button
                            Text(text = "Make request", modifier = Modifier.padding(8.dp))
                        }
                        // on below line we are adding a spacer.
                        Spacer(modifier = Modifier.height(20.dp))
                        // on below line we are creating a text for displaying a response.
                        Text(
                            text = "response: ${response.value}",
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold, modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SampleSDKAppJetPackTheme {
        Greeting("Android")
    }
}