package com.example.lemonadek

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.painter.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.res.*
import androidx.compose.ui.unit.*
import com.example.lemonadek.ui.theme.LemonadekTheme

class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent {
            var count by remember {
                mutableStateOf(1)
            }
            var painterImage by remember {
                mutableStateOf(R.drawable.lemon_tree)
            }
            var imageDescription by remember {
                mutableStateOf(R.string.lemon_tree_text)
            }
            
            
            LemonadekTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                )
                {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center,) {
    
                        Button(onClick = {
                            count++
                            /*
                             when(count){
                                1 -> {
                                    painterImage = R.drawable.lemon_tree
                                    imageDescription = R.string.lemon_tree_text
                                }
                                2 -> {
                                    painterImage = R.drawable.lemon_squeeze
                                    imageDescription = R.string.lemon_text
    
                                }
                                6 -> {
                                    painterImage = R.drawable.lemon_drink
                                    imageDescription = R.string.lemonade_text
    
                                }
                                7 -> {
                                    painterImage = R.drawable.empty_glass
                                    imageDescription = R.string.empty_glass_text
    
                                }
//
                            
                            }
                             */
                            if(count == 1){
                                painterImage = R.drawable.lemon_tree
                                imageDescription = R.string.lemon_tree_text
                            }else if(count == 2){
                                painterImage = R.drawable.lemon_squeeze
                                imageDescription = R.string.lemon_text
                            }else if(count  == 10 ){
                                painterImage = R.drawable.lemon_drink
                                imageDescription = R.string.lemonade_text
                            }else if(count == 11){
                                painterImage = R.drawable.empty_glass
                                imageDescription = R.string.empty_glass_text
                            }else if (count > 11){
                                painterImage = R.drawable.lemon_tree
                                imageDescription = R.string.lemon_tree_text
                                count = 1
                            }
                            
                        }, modifier = Modifier.fillMaxSize(), colors = ButtonDefaults.buttonColors(Color.Transparent)) {
        
                        }
                        Interface(
                                modifier = Modifier,
                                text = stringResource(id = imageDescription),
                                painter = painterResource(
                                      id = painterImage
                                ),
                        )
    
                       
                    }

                }
            }
        }
    }
}

@Composable
fun LemonTree(modifier: Modifier){
    
}

@Composable
fun Interface(modifier: Modifier,text : String,painter : Painter){
    Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
    ) {
        Text(text = text, fontSize = 16.sp)
        
        Image(
                painter = painter,
                contentDescription = text,
                modifier = Modifier
                        .padding(16.dp)
                        .border(
                                3.dp,
                                Color(0xFF00B4D8),
                                shape = RectangleShape
                        )
                        .padding(1.dp)
                        .fillMaxHeight(0.5f)
                        .fillMaxWidth(0.7f)
                ,
                
                contentScale = ContentScale.Crop
        )
    }
}