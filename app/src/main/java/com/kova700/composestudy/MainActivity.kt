@file:OptIn(ExperimentalMaterial3Api::class)

package com.kova700.composestudy

import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.kova700.composestudy.ui.theme.ComposeStudyTheme
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeStudyTheme {
    }
}

@Composable
fun APITest(url: String) {
    val coroutineScope = rememberCoroutineScope()
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Button(
            onClick = {
                coroutineScope.launch {
                    val response = ktorClient.get(url)
                    Log.d("로그", "MainActivity: requestApi() - response : ${response.body<String>()}")
                }
            }
        ) {
            Text(text = "Call API")
        }
    }
}

@Composable
fun MyGridScreen(navHostController: NavHostController) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.padding(20.dp),
    ) {
        items(15) { number ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .border(1.dp, Color.Black)
                    .clickable {
                        navHostController.navigate("myNumberScreen/$number")
                    }
            ) {
                Text(
                    text = number.toString(),
                    fontSize = 30.sp
                )
            }
        }
    }
}

@Composable
fun MyNumberScreen(number: String?) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = number.toString(),
            fontSize = 70.sp
        )
    }
}

@Composable
fun MyNumNav(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "myGridScreen") {
        composable("myGridScreen") {
            MyGridScreen(navHostController = navHostController)
        }
        composable("myNumberScreen/{number}") { navBackstackEntry ->
            MyNumberScreen(number = navBackstackEntry.arguments?.getString("number"))
        }
    }
}

@Composable
fun MyScreen1(navHostController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "화면1",
            fontSize = 50.sp
        )
        Button(
            onClick = {
                navHostController.navigate("myScreen2")
            }
        ) {
            Text(
                text = "2번 화면으로 가기",
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun MyScreen2(navHostController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "화면2",
            fontSize = 50.sp
        )
        Button(
            onClick = {
                navHostController.navigate("myScreen3")
            }
        ) {
            Text(
                text = "3번 화면으로 가기",
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun MyScreen3(navHostController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "화면3",
            fontSize = 50.sp
        )
        Button(
            onClick = {
                navHostController.navigate("myScreen1")
            }
        ) {
            Text(
                text = "1번 화면으로 가기",
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun MyNav() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "myScreen1") {
        composable("myScreen1") {
            MyScreen1(navHostController = navController)
        }
        composable("myScreen2") {
            MyScreen2(navHostController = navController)
        }
        composable("myScreen3") {
            MyScreen3(navHostController = navController)
        }
    }
}

@Composable
fun ShowAndHideTest() {
    var isVisible by remember {
        mutableStateOf(
            false
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                isVisible = !isVisible
                Log.d("로그", ": ShowAndHideTest() - isButtonVisible : $isVisible")
            }
        ) {
            Text(
                text = if (isVisible) "숨기기" else "보이기"
            )
        }

        Spacer(modifier = Modifier.size(50.dp))

        if (isVisible) {
            Text(
                text = "TextView",
            )
        }
    }

}


@Composable
fun ShowAndHideTest2() {
    var switchState by remember {
        mutableStateOf(
            false
        )
    }
    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        Switch(
            checked = switchState,
            onCheckedChange = { checked ->
                switchState = checked
            }
        )

        Text(
            text = if (switchState) "On" else "Off",
            fontSize = 50.sp
        )

        if (switchState) {
            Button(onClick = { }) {
                Text(
                    text = "얍얍",
                    fontSize = 30.sp
                )
            }
        }
    }
}

@Composable
fun MyTextArea1() {
    Column {
        Text(
            text = "안녕",
            fontSize = 100.sp,
            color = Color.Blue
        )
        Text(
            text = "안녕",
            fontSize = 100.sp,
            color = Color.Green
        )
        Text(
            text = "안녕",
            fontSize = 100.sp,
            color = Color.Gray
        )
    }
}


@Composable
fun MyTextArea2() {
    Column {
        MyTextFormat1(text = "안녕", fontSize = 100.sp, color = Color.Blue)
        MyTextFormat1(text = "하세요", fontSize = 100.sp, color = Color.Green)
        MyTextFormat1(text = "여러분", fontSize = 100.sp, color = Color.Gray)
    }
}

@Composable
fun MyTextFormat1(text: String, fontSize: TextUnit, color: Color) {
    Text(
        text = text,
        fontSize = fontSize,
        color = color
    )
}

@Composable
fun MyTextArea3() {
    MyTextFormat2 {
        Text(
            text = "안녕",
            fontSize = 100.sp,
            color = Color.Green
        )
    }
}

@Composable
fun MyTextFormat2(content: @Composable () -> Unit) {
    Column {
        (1..3).onEach {
            content()
        }
    }
}

@Composable
fun ProgressIndicatorTest() {
    var progress by remember { mutableStateOf(0.0f) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                progress = if (progress < 1f) progress + 0.1f else progress
            }
        ) {
            Text(
                text = "분노 게이지",
                fontSize = 30.sp
            )
        }

        Spacer(modifier = Modifier.size(30.dp))

        LinearProgressIndicator(
            progress = progress,
            modifier = Modifier.height(10.dp),
            color = Color.Red,
            trackColor = Color.Cyan
        )

        Spacer(modifier = Modifier.size(30.dp))

        CircularProgressIndicator(
            progress = progress,
            color = Color.Red
        )
    }
}

@Composable
fun LazyRowTest() {
    val textList = ('A'..'Z').toList().map { it.toString() }

    LazyRow {
        items(textList) { item ->
            Text(
                text = item,
                fontSize = 100.sp,
                modifier = Modifier.clickable {
                    Log.d("로그", ": LazyRowTest() - Clicked item : $item")
                }
            )
        }
    }
}

@Composable
fun LazyColumnTest() {
    val textList = ('A'..'Z').toList().map { it.toString() }

    LazyColumn {
        items(textList) { item ->
            Text(
                text = item,
                fontSize = 60.sp,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun ScaffoldTest() {
    Scaffold(
        topBar = { ScaffoldTestTopBar() },
        floatingActionButton = {
            ScaffoldTestFloatingActionButton()
        },
        bottomBar = {
            ScaffoldTestBottomBar()
        }
    ) { paddingValues ->
        // paddingValues = Topbar부분에 가려지는걸 방지하기 위해서 content부분을 padding으로 밀어줌
        // paddingValues가 없으면 TopBar에 가려서 글자가 보이지 않음
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Text(text = "This is Content")
        }
    }
}

@Composable
fun ScaffoldTestTopBar() {
    TopAppBar(
        title = { Text(text = "MainTopBar") },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(Icons.Default.Add, contentDescription = "add")
            }
        },
        actions = {
            Button(onClick = {}) {
                Text(text = "Btn")
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(Color.Red)
    )
}

@Composable
fun ScaffoldTestFloatingActionButton() {
    FloatingActionButton(onClick = { /*TODO*/ }) {
        Icon(Icons.Default.Menu, contentDescription = "Menu")
    }
}

@Composable
fun ScaffoldTestBottomBar() {
    BottomAppBar(
        containerColor = Color.Red
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.Home, contentDescription = "Home")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.Favorite, contentDescription = "Favorite")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.Settings, contentDescription = "Settings")
            }
        }
    }
}

@Composable
fun SurfaceTest() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        color = Color.Red,
        shape = RoundedCornerShape(20.dp),
        shadowElevation = 20.dp
    ) {
        Button(
            onClick = {},
            colors = ButtonDefaults.outlinedButtonColors( //바깥쪽 컬러와 버튼 컬러 통일
                contentColor = Color.Green //버튼 안에 있는 컨텐츠 컬러 설정
            )
        ) {
            Text(text = "클릭해보세요")
        }
    }
}

@Composable
fun SurfaceTest2() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.LightGray,
        border = BorderStroke(2.dp, Color.Red),
        contentColor = Color.Blue
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = Modifier.size(200.dp),
                color = Color.Red
            ) {
                Text(text = "This is Jetpack Compose")
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "This is Jetpack Compose EX"
            )
        }
    }
}


@Composable
fun WebViewTest(url: String) {
    AndroidView(factory = {
        WebView(it).apply {
            loadUrl(url)
        }
    }
    )
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
