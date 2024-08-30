package com.example.FundamentalJetpackCompose

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstcompose.R
import kotlinx.coroutines.launch


////////////////////

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

//                MyText(text.value)

//                EditField("hi");

//                OutLineTextField();

//                OutLineTextField2();

//                MyButton();

//                MyRadioButton();

//                MyFAB();

//                MyProgress();
//
//                MyAlertDialog();
//
//                MyRow();

//                MyColumn()

//                MyBox(modifier = Modifier);

//            MySurface();
//            MyScaffold();

//            MyScrollingVertical();
//            MyScrollingHorizontal();

//            MyLazyFun();

        }
    }

    @Composable
    fun MyText(text: String) {
        Text(
            text = text,
            color = DarkGray,
            fontSize = 25.sp
        )


    }

    @Composable
    fun TextField(text: String) {
        val textValue = remember {

            mutableStateOf("")
        }
        TextField(
            value = textValue.value,
            onValueChange = { text ->

                textValue.value = text
            },
            label = { Text(text = "Y Name") }

        )


    }


    @Composable
    fun OutLineTextField() {


        val textValue = remember {
            mutableStateOf("")

        }


        OutlinedTextField(
            value = textValue.value,
            onValueChange = { text ->
                textValue.value = text
            },

            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password
            ),


            )


    }


    @Composable
    fun OutLineTextField2() {
        var text by rememberSaveable(stateSaver = TextFieldValue.Saver) {
            mutableStateOf(TextFieldValue("examble", TextRange(5)))
        }
        OutlinedTextField(
            value = text, onValueChange = { it ->
                text = it
            },
            label = { Text("welcome") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = DarkGray,
                unfocusedBorderColor = Red,
            ),
            textStyle = TextStyle(color = Red, fontSize = 20.sp),
            keyboardOptions = KeyboardOptions.Default.copy(
                capitalization = KeyboardCapitalization.Words,
                keyboardType = KeyboardType.Text
            )


        )


    }

    val text = mutableStateOf("")

    @Composable
    fun MyButton() {

        Button(
            onClick = { text.value = "hi all " },

            border = BorderStroke(2.dp, Red),
            colors = ButtonDefaults.buttonColors(Red)
        ) {
            Text(
                text = stringResource(id = R.string.myButton),
                color = colorResource(id = R.color.white)
            )

        }
    }

    @Composable
    fun MyRadioButton() {
        val radioButtonChoice = listOf(0, 1, 2)
        val selectedRadioButton = remember {
            mutableIntStateOf(radioButtonChoice.first())
        }


        radioButtonChoice.forEach { index ->
            val isSelected = index == selectedRadioButton.intValue
            RadioButton(selected = isSelected, onClick = { selectedRadioButton.intValue = index })

        }
    }

    @Composable
    fun MyFAB() {

        FloatingActionButton(
            onClick = { /*TODO*/ },
            content = {
                Icon(Icons.Filled.AddCircle, "fab")
                colorResource(id = R.color.purple_700)

            },
            containerColor = Red,


            )
    }


    @Composable
    fun MyProgress() {
        CircularProgressIndicator(color = Red)
        LinearProgressIndicator(color = Yellow)


    }


    @Composable
    fun MyAlertDialog() {
        val showDialog = remember {
            mutableStateOf(true)
        }

        if (showDialog.value) {
            AlertDialog(

                onDismissRequest = { showDialog.value = false },

                confirmButton = {
                    Button(onClick = { showDialog.value = false }) {
                        Text(text = "Confirem")
                    }
                },
                title = { Text(text = "Download") },
                text = { Text(text = " continue to Download") },
                dismissButton = {
                    Button(onClick = { showDialog.value = false }) {
                        Text(text = "Cancel")
                    }
                }


            )


        }


    }


    @Composable
    fun MyRow() {

        Row(
            modifier = Modifier.background(Yellow),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            MyText(text = "User 1")
            MyText(text = "User 2")
            MyText(text = "User 3")

        }

    }

}

@Composable
fun MyImage() {

    Image(Icons.Filled.AccountCircle, contentDescription = "img")

}

@Composable
fun MyColumn() {

    Column(

        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(text = "User 1", Modifier.background(Yellow))
        Text(text = "User 2", Modifier.background(Red))
        Text(text = "User 3", Modifier.background(Green))

    }


}


@Composable
fun MyBox(modifier: Modifier) {

    Box {
        Text(
            "TopStart", modifier = Modifier
                .align(Alignment.TopStart)
                .background(Red), fontSize = 20.sp
        )
        Text(
            "TopCenter",
            Modifier
                .align(Alignment.TopCenter)
                .background(Yellow), fontSize = 20.sp
        )
        Text(
            "TopEnd",
            Modifier
                .align(Alignment.TopEnd)
                .background(Green), fontSize = 20.sp
        )

    }
}


@Composable
fun MySurface() {

    Surface(

        modifier = Modifier
            .background(Green)
            .size(500.dp), onClick = { /*TODO*/ }) {

        MyColumn()

    }

}


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyScaffold() {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    Scaffold {


        ModalNavigationDrawer(
            drawerContent = {
                ModalDrawerSheet {
                    for (i in 0..5) {

                        NavigationDrawerItem(
                            label = { Text("John Doe  ") },
                            selected = true,
                            onClick = { Green })

                    }

                }

            },
            drawerState = drawerState
        ) {
//                Scaffold {
            TopAppBar(

                title = { Text(text = "Title") },

                navigationIcon = {

                    IconButton(onClick = {
                        scope.launch { drawerState.open() }
                    }


                    ) {
                        Icon(imageVector = Icons.Filled.Menu, contentDescription = "ws")
                    }

                }
            )
//                }


        }
    }
}

@Composable
fun MyScrollingVertical(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .verticalScroll(
                rememberScrollState()
            )
    ) {

        Text(
            text = "Where does it come from?\n" +

                    "\tparagraphs\n" +
                    "\twords\n" +
                    "\tbytes\n" +
                    "\tlists\n" +
                    "\tStart with 'Lorem\n" +
                    "ipsum dolor sit amet...'\n", fontSize = 22.sp
        )
        Text(
            text = "Where does it come from?\n" +

                    "\tparagraphs\n" +
                    "\twords\n" +
                    "\tbytes\n" +
                    "\tlists\n" +
                    "\tStart with 'Lorem\n" +
                    "ipsum dolor sit amet...'\n", fontSize = 22.sp
        )
        Text(
            text = "Where does it come from?\n" +

                    "\tparagraphs\n" +
                    "\twords\n" +
                    "\tbytes\n" +
                    "\tlists\n" +
                    "\tStart with 'Lorem\n" +
                    "ipsum dolor sit amet...'\n", fontSize = 22.sp
        )
        Text(
            text = "Where does it come from?\n" +

                    "\tparagraphs\n" +
                    "\twords\n" +
                    "\tbytes\n" +
                    "\tlists\n" +
                    "\tStart with 'Lorem\n" +
                    "ipsum dolor sit amet...'\n", fontSize = 22.sp
        )
        Text(
            text = "Where does it come from?\n" +

                    "\tparagraphs\n" +
                    "\twords\n" +
                    "\tbytes\n" +
                    "\tlists\n" +
                    "\tStart with 'Lorem\n" +
                    "ipsum dolor sit amet...'\n", fontSize = 22.sp
        )

        Text(
            text = "Where does it come from?\n" +

                    "\tparagraphs\n" +
                    "\twords\n" +
                    "\tbytes\n" +
                    "\tlists\n" +
                    "\tStart with 'Lorem\n" +
                    "ipsum dolor sit amet...'\n", fontSize = 22.sp
        )


    }
}

@Composable
fun MyScrollingHorizontal(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .padding(20.dp)
            .horizontalScroll(
                rememberScrollState()
            )
    ) {

        Text(
            text = "---------------------------------------------------------------------" +
                    "Where does it come from?\n" +

                    "\tparagraphs\n" +
                    "\twords\n" +
                    "\tbytes\n" +
                    "\tlists\n" +
                    "\tStart with 'Lorem\n" +
                    "ipsum dolor sit amet...'\n", fontSize = 22.sp
        )
        Text(
            text = "Where does it come from?\n" +

                    "\tparagraphs\n" +
                    "\twords\n" +
                    "\tbytes\n" +
                    "\tlists\n" +
                    "\tStart with 'Lorem\n" +
                    "ipsum dolor sit amet...'\n", fontSize = 22.sp
        )
        Text(
            text = "Where does it come from?\n" +

                    "\tparagraphs\n" +
                    "\twords\n" +
                    "\tbytes\n" +
                    "\tlists\n" +
                    "\tStart with 'Lorem\n" +
                    "ipsum dolor sit amet...'\n", fontSize = 22.sp
        )
        Text(
            text = "Where does it come from?\n" +

                    "\tparagraphs\n" +
                    "\twords\n" +
                    "\tbytes\n" +
                    "\tlists\n" +
                    "\tStart with 'Lorem\n" +
                    "ipsum dolor sit amet...'\n", fontSize = 22.sp
        )
        Text(
            text = "Where does it come from?\n" +

                    "\tparagraphs\n" +
                    "\twords\n" +
                    "\tbytes\n" +
                    "\tlists\n" +
                    "\tStart with 'Lorem\n" +
                    "ipsum dolor sit amet...'\n", fontSize = 22.sp
        )

        Text(
            text = "Where does it come from?\n" +

                    "\tparagraphs\n" +
                    "\twords\n" +
                    "\tbytes\n" +
                    "\tlists\n" +
                    "\tStart with 'Lorem\n" +
                    "ipsum dolor sit amet..-----------------------------------------------------------------.'\n",
            fontSize = 22.sp
        )


    }
}

@Composable
fun MyLazyFun(modifier: Modifier = Modifier) {

    LazyColumn {
        items(lazyList) {

            ListLayout(it)
        }
    }

}

val lazyList = listOf(
    dataList(R.drawable.img, "seward"),
    dataList(R.drawable.soward, "seward"),
    dataList(R.drawable.img, "seward"),
    dataList(R.drawable.soward, "seward"),
    dataList(R.drawable.img, "seward"),
    dataList(R.drawable.soward, "seward"),
    dataList(R.drawable.img, "seward"),
    dataList(R.drawable.soward, "seward"),
    dataList(R.drawable.img, "seward"),
    dataList(R.drawable.soward, "seward"),
    dataList(R.drawable.img, "seward"),
    dataList(R.drawable.soward, "seward"),


    )


data class dataList(val img: Int, val name: String)

@Composable
fun ListLayout(dataList: dataList) {

    Row {
        Image(painter = painterResource(id = dataList.img), contentDescription = "")
        Text(text = dataList.name)

    }
}























