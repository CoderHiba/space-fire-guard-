package com.spacefireguard.presentation.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FireRiskCalculator() {
    var material by remember { mutableStateOf("Wood") }
    var oxygen by remember { mutableStateOf(21f) }

    val risk = when {
        oxygen >= 40 -> "HIGH RISK 🔴"
        oxygen >= 30 -> "MEDIUM RISK 🟠"
        else -> "LOW RISK 🟢"
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Space Fire Guard", style = MaterialTheme.typography.headlineMedium)
        Text("Detect fires to protect lives on Earth and in space!")
        Spacer(modifier = Modifier.height(16.dp))

        Text("Material: $material")
        Row {
            Button(onClick = { material = "Wood" }) { Text("Wood") }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { material = "Plastic" }) { Text("Plastic") }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text("Oxygen: ${oxygen.toInt()}%")
        Slider(value = oxygen, onValueChange = { oxygen = it }, valueRange = 0f..100f)

        Spacer(modifier = Modifier.height(16.dp))
        Text(risk, style = MaterialTheme.typography.headlineSmall)
        Text("Material: $material - Oxygen ${oxygen.toInt()}%")
    }
}