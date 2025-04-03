package com.bilalazzam.soduku


import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.bilalazzam.soduku.ui.theme.SodukuTheme
import kotlin.math.sqrt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SodukuTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SudokuGame(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun SudokuGame(modifier: Modifier = Modifier) {
    var boardSize by remember { mutableIntStateOf(9) }
    var subGridSize by remember { mutableIntStateOf(sqrt(boardSize.toDouble()).toInt()) }
    //  Use mutableStateListOf to ensure UI updates properly
    var boardState by remember(boardSize) {
        mutableStateOf(
            List(boardSize) { List(boardSize) { '-' } }
        )
    }
    // State for showing the alert dialogs
    var showDialog by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Text("Select Board Size: ", fontSize = 18.sp)
            DropdownMenuSize { size ->
                boardSize = size
                boardState = List(boardSize){List(boardSize) { '-' }}
                subGridSize = sqrt(boardSize.toDouble()).toInt()
            }
        }

        LazyColumn {
            items(boardSize) { row ->
                LazyRow {
                    items(boardSize) { col ->
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .border(1.dp, Color.Black)
                                .background(
                                    if (((row / subGridSize) + (col / subGridSize)) % 2 == 0) Color(0xFF00BCD4) else Color(0xFF4CAF50)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            if (row < boardState.size && col < boardState[row].size) {
                                var value by remember {
                                    mutableStateOf(boardState[row][col])
                                }
                                BasicTextField(
                                    value = if (value == '-') {
                                        ""
                                    } else {value.toString()},
                                    onValueChange = {
                                        value = if(it.isNotEmpty()) {it.first()} else {'-'}
                                        boardState = boardState.update(row, col, value)
                                        Log.d("TAG", "SudokuGame: $boardState")
                                    },
                                    singleLine = true,
                                    textStyle = MaterialTheme.typography.bodyLarge.copy(
                                        textAlign = TextAlign.Center
                                    ),
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                )
                            }

                        }
                    }
                }
            }
        }

        // Buttons for check validity and submit game
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Button(
                onClick = {
                    dialogMessage = if (Sudoku.isValidSudoku(boardState)) {
                        "Valid Sudoku"
                    } else {
                        "InValid Sudoku!"
                    }
                    showDialog = true

                },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Check Validity")
            }

            Button(
                onClick = {
                    dialogMessage = if (Sudoku.isSolved(boardState)) {
                        "Congratulations"
                    } else {
                        "Unfortnatly, You lose!"
                    }
                    showDialog = true
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Submit Game")
            }
        }

        // AlertDialog
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Result") },
                text = { Text(dialogMessage) },
                confirmButton = {
                    Button(onClick = { showDialog = false }) {
                        Text("OK")
                    }
                }
            )
        }
    }
}


@Composable
fun DropdownMenuSize(onSizeSelected: (Int) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("9×9") }

    Box(modifier = Modifier.wrapContentSize(Alignment.TopStart)) {
        Button(onClick = { expanded = true }) { Text(selectedText) }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            DropdownMenuItem(
                onClick = {
                    selectedText = "4x4"
                    expanded = false
                    onSizeSelected(4)
                },
                text = { Text("4x4") }
            )
            DropdownMenuItem(
                onClick = {
                    selectedText = "9x9"
                    expanded = false
                    onSizeSelected(9)
                },
                text = { Text("9x9") }
            )
            DropdownMenuItem(
                onClick = {
                    selectedText = "16x16"
                    expanded = false
                    onSizeSelected(16)
                },
                text = { Text("16x16") }
            )
        }
    }
}

