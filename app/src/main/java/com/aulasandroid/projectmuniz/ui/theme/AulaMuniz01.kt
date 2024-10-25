package com.aulasandroid.projectmuniz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aulasandroid.projectmuniz.ui.theme.ProjectMunizTheme

class AulaMuniz01 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectMunizTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Exercicio53(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
/**
 * Escreva um algoritmo para imprimir os números de 1 (inclusive) a 10 (inclusive) em ordem
 * crescente.
 */
@Composable
fun Exercicio50(modifier: Modifier) {
    val total = 10

    Row {
        for (i in 1 .. 10) {
            Text(text = " ${i}")
        }
    }
}


/**
 * Escreva um algoritmo para imprimir os números de 1 (inclusive) a 10 (inclusive) em ordem
 * decrescente.
 */
@Composable
fun Exercicio51(modifier: Modifier) {
    val total = 10

    Row {
        for(i in 10 downTo 1) {
            Text(text = " ${i}")
        }
    }
}


/**
 * Escreva um algoritmo para imprimir os 10 primeiros números inteiros maiores que 100.
 */
@Composable
fun Exercicio52(modifier: Modifier) {
    val final = 101 + 10

    Column {
        for(i in 101..final) {
            Text(text = "${i}")
        }
    }
}


/**
 * Ler um valor N e imprimir todos os valores inteiros entre 1 (inclusive) e N (inclusive). Considere
 * que o N será sempre maior que ZERO.
 */
@Composable
fun Exercicio53(modifier: Modifier) {
    var numeroInformadoPeloUsuario by remember { mutableStateOf("5") }     // Esse aqui é o numero que o usuario informou na tela
    var limite by remember { mutableStateOf(10) }   // Esse aqui vai ser o numero que vamos utilizar como limite no for para imprimir os numeros
    val localFocusManager = LocalFocusManager.current   // Esse carinha de retorna quem tem o foco atual, por meio dele eu posso esconder o teclado por exemplo
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp    // Largura da tela do device

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .pointerInput(Unit) {
                detectTapGestures {
                    localFocusManager.clearFocus()
                }
            }
    ) {
        Text(
            text = "Ler um valor N e imprimir todos os valores inteiros entre 1 (inclusive) e N (inclusive).\n Considere que o N será sempre maior que ZERO.",
            modifier = modifier.padding(horizontal = 16.dp),
            textAlign = TextAlign.Left
        )

        OutlinedTextField(
            value = numeroInformadoPeloUsuario,
            onValueChange = { numeroInformadoPeloUsuario = it },  // O onValueChange() é a função que será executada quando o valor do input mudar, ele ira atualizar a variavel text
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = modifier
                .padding(horizontal = 16.dp)
                .width(screenWidth),
        )

        Button(onClick = {
            // Dissmiss (Acao de esconder) no Teclado
            localFocusManager.clearFocus()

            if(numeroInformadoPeloUsuario.isNotEmpty()) {
                limite  = Integer.parseInt(numeroInformadoPeloUsuario)
            }
        }, modifier = Modifier.padding(all = 16.dp)) {
            Text(text = "Calcular")
        }

        Text("Resultado: ", modifier = Modifier.padding(horizontal = 16.dp))
        if(limite > 0) {
            Row {
                Column {
                    for(i in 1..limite) {
                        Text(text = "${i}", modifier = Modifier.padding(horizontal = 16.dp))
                    }
                }
            }
        }
    }
}


@Composable
fun ExemploDeUsoDeColunasELinhas() {
    val total = 4

    Row {
        Column(modifier = Modifier.background(Color.Blue)) {
            for(i in 0..total) {
                Text(text = " ${i}")
            }
        }

        Column(modifier = Modifier.background(Color.Red)) {
            for(i in 0..total) {
                Text(text = " ${i}")
            }
        }

        Column(modifier = Modifier.background(Color.Red)) {
            for(i in 0..total) {
                Text(text = " ${i}", color = Color.Green)
            }
        }

        Column(modifier = Modifier.background(Color.Gray)) {
            for(i in 0..total) {
                Text(text = " ${i}")
            }
        }

        Column(modifier = Modifier.background(Color.Magenta)) {
            for(i in 0..total) {
                Text(text = " ${i}")
            }
        }

        Column(modifier = Modifier.background(Color.Black)) {
            for(i in 0..total) {
                Text(text = " ${i}", color = Color.White)
            }
        }
    }
}

@Composable
fun Escadinha() {
    Column {
        Degrau()
    }
}

@Composable
fun Degrau() {
    // Quinto Degrau
    Row {
        Text("----")
        Column {
            Text(",")

            // Quarto Degrau
            Row {
                Text("----")
                Column {
                    Text(",")

                    // Terceiro Degrau
                    Row {
                        Text("----")
                        Column {
                            Text(",")

                            // Segundo Degrau
                            Row {
                                Text("----")
                                Column {
                                    Text(",")

                                    // Primeiro Degrau
                                    Row {
                                        Text("----")
                                        Column {
                                            Text(",")
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Nova () {
    Text(text = "André Gonçalves Lemes Leal")
}



@Preview(showBackground = true)

@Composable
fun Teste() {
    ProjectMunizTheme {
 //       Exercicio51(modifier = Modifier)
 //       ExemploDeUsoDeColunasELinhas()
//        Escadinha()
//        Exercicio52(modifier = Modifier)
          Nova()
//        Exercicio53(modifier = Modifier.padding())
    }
}

