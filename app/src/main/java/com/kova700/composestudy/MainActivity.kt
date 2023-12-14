@file:OptIn(ExperimentalMaterial3Api::class)

package com.kova700.composestudy

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.draw.clip
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
                Column {
                    CardTest("1")
                    CardTest("2")
                    CardTest("3")
                    CardTest("4")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeStudyTheme {
        Column {
            CardTest("1")
            CardTest("2")
            CardTest("3")
            CardTest("4")
        }
    }
}

@Composable
fun CardTest(text: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(10.dp),
        shape = RoundedCornerShape(50.dp),
//        border = BorderStroke(1.dp, Color.Black),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = text,
                fontSize = 30.sp
            )
        }
    }
}


@Composable
fun ColumnRowTest() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(Color.Gray)
    ) {
        Text(
            text = "안녕하세요",
            color = Color.Blue,
            fontSize = 20.sp
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
//            horizontalArrangement = Arrangement.SpaceAround,
//            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = "왼쪽")
            Text(text = "중앙")
            Text(text = "오른쪽")
        }
        Text(
            text = "반갑습니다.",
            color = Color.Red,
            fontSize = 20.sp
        )
    }
}

@Composable
fun ColumnRowTest2() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(Color.Cyan)
            .border(
                border = BorderStroke(5.dp, color = Color.Blue)
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .padding(20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.cat_sleep_img),
                contentDescription = "catImage",
                modifier = Modifier
                    .padding(100.dp)
                    .clip(RoundedCornerShape(200.dp))
            )
        }
        Text(
            text = "고앵히",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 50.dp)
        )
        Text(
            text = "Developer",
            fontSize = 15.sp,
            modifier = Modifier.padding(top = 10.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "이메일",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )

            Text(
                text = "blak1002@gmain.com",
                fontSize = 15.sp,
                modifier = Modifier.padding(10.dp),
                color = Color.Blue
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "연락처",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )

            Text(
                text = "010-1234-5678",
                fontSize = 15.sp,
                modifier = Modifier.padding(10.dp),
            )
        }
    }

}

@Composable
fun RowTest() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        horizontalArrangement = Arrangement.SpaceEvenly, //가로로 동일한 간격
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "text1",
            style = TextStyle(background = Color.Blue),
            fontSize = 30.sp
        )
        Text(
            text = "text2",
            style = TextStyle(background = Color.Red),
            fontSize = 30.sp
        )
        Text(
            text = "text3",
            style = TextStyle(background = Color.Green),
            fontSize = 30.sp
        )
    }
}


@Composable
fun BoxTest() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Red)
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(color = Color.Blue)
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Text(
                text = "왼쪽 위",
                color = Color.White,
            )
        }
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(color = Color.Green)
                .padding(16.dp)
                .align(Alignment.TopCenter)
        ) {
            Text(
                text = "중앙 위",
                color = Color.White,
            )
        }
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(color = Color.Gray)
                .padding(16.dp)
                .align(Alignment.TopEnd)
        ) {
            Text(
                text = "오른쪽 위",
                color = Color.White,
            )
        }

        Button(
            onClick = {},
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Text(text = "중앙 왼쪽")
        }

        Button(
            onClick = {},
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(text = "중앙 중앙")
        }

        Button(
            onClick = {},
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Text(text = "중앙 오른쪽")
        }

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(color = Color.Blue)
                .padding(16.dp)
                .align(Alignment.BottomStart)
        ) {
            Text(
                text = "왼쪽 아래",
                color = Color.White,
            )
        }
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(color = Color.Green)
                .padding(16.dp)
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = "중앙 아래",
                color = Color.White,
            )
        }
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(color = Color.Gray)
                .padding(16.dp)
                .align(Alignment.BottomEnd)
        ) {
            Text(
                text = "오른쪽 아래",
                color = Color.White,
            )
        }

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
