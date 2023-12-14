@file:OptIn(ExperimentalMaterial3Api::class)

package com.kova700.composestudy

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.kova700.composestudy.ui.theme.ComposeStudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
//                MyImageTest()
                MyImageTest2()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeStudyTheme {
//        MyImageTest()
        MyImageTest2()
    }
}

@Composable
fun MyImageTest() {
    Image(
        painter = painterResource(id = R.drawable.cat_sleep_img),
        contentDescription = "catImage"
    )
}

@Composable
fun MyImageTest2() {
    AsyncImage(
        model = "https://molo17.com/wp-content/uploads/2021/11/StudioCompose10.jpg",
        contentDescription = "composeImage",
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun MyTextField() {
    var textState by remember {
        mutableStateOf("Hello")
    }

    TextField(
        value = textState,
        //사용자가 입력하는 값을 옵저빙하고 textState에 할당
        onValueChange = { textState = it },
        label = {
            Text(text = "입력하는 공간")
        }
    )
}


@Composable
fun MyTextField2() {
    var textState by remember {
        mutableStateOf("Hello")
    }

    //TextField외부에 OutLine이 생김
    OutlinedTextField(
        value = textState,
        onValueChange = { textState = it },
        label = {
            Text(text = "입력하는 공간")
        }
    )
}


@Composable
fun MyTextField3() {
    //입력한 부분
    var textState by remember {
        mutableStateOf("")
    }
    //결과값 부분
    var resultText by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,           //수직 중앙정렬
        horizontalAlignment = Alignment.CenterHorizontally  //수평 중앙정렬
    ) {

        //텍스트 기본값 = textState
        TextField(
            value = textState,
            //사용자가 입력하는값 textState에 할당
            onValueChange = { textState = it },
            modifier = Modifier.fillMaxWidth()
        )

        //누르면 resultText에 textState값을 할당
        Button(
            onClick = {
                resultText = textState
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "입력하기")
        }

        //resultText를 바라보고 있음
        Text(
            text = "결과값 : $resultText"
        )
    }
}

@Composable
fun ColumnTest1() {
    Text(
        text = "Hi",
        fontSize = 30.sp
    )
    Text(
        text = "Hi2",
        fontSize = 30.sp,
        modifier = Modifier.padding(top = 50.dp)
    )
    Text(
        text = "Hi3",
        fontSize = 30.sp,
        modifier = Modifier.padding(top = 100.dp)
    )
}


@Composable
fun ColumnTest2() {
    Column(
        modifier = Modifier.padding(30.dp)
    ) {
        Text(
            text = "Hello",
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.padding(30.dp))
        Divider(
            thickness = 4.dp,
            color = Color.Blue
        )
        Text(
            text = "Hello2",
            fontSize = 30.sp
        )
        Text(
            text = "Hello3",
            fontSize = 30.sp
        )

    }
}

@Composable
fun SimpleCounterBtn() {
    var count by remember {
        mutableStateOf(0)
    }

    Button(
        onClick = {
            count++
        },
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Count : $count",
            fontSize = 50.sp
        )
    }
}

@Composable
fun MyTextEx() {
    Text(
        text = "Text Example",
        fontSize = 30.sp,
        color = Color.Red,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(30.dp),
        style = TextStyle(background = Color.Blue)
    )
}

@Composable
fun MyButton() {
    val context = LocalContext.current
    Button(
        onClick = {
            Log.d("로그", ": myButton() - called")
            Toast.makeText(context, "MyButton is clicked", Toast.LENGTH_SHORT).show()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Yellow,
            contentColor = Color.Blue
        ),
        modifier = Modifier
            .width(200.dp)
            .height(100.dp),

        ) {
        Text(
            text = "This is Button",
            lineHeight = 30.sp,
            fontSize = 20.sp,
            color = Color.Red
        )
    }
}
