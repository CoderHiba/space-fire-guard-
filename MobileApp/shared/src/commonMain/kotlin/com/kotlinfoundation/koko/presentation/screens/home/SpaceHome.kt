package com.kotlinfoundation.koko.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SpaceHome() {
    var isSpace by remember { mutableStateOf(true) }

    val bgColor = if (isSpace) Color(0xFF0B0B2A) else Color(0xFFF6F1E7)
    val titleColor = if (isSpace) Color.White else Color(0xFF1A1A1A)
    val accent = if (isSpace) Color(0xFF7C5CFF) else Color(0xFFFF7A1A)

    Column(
        modifier = Modifier.fillMaxSize().background(bgColor).padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text("🔥 Space Fire Guard", color = titleColor, fontSize = 26.sp, fontWeight = FontWeight.Bold)
        Text(
            "Where do you want to protect today?",
            color = if (isSpace) Color(0xFFB8B8D0) else Color.Gray,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(20.dp))

        // SPACE | EARTH  
        Row(
            modifier = Modifier.fillMaxWidth().height(54.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(if (isSpace) Color(0xFF1E1E45) else Color.White),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.weight(1f).fillMaxHeight()
                    .clip(RoundedCornerShape(30.dp))
                    .background(if (isSpace) accent else Color.Transparent)
                    .clickable { isSpace = true },
                contentAlignment = Alignment.Center
            ) { Text("🚀 SPACE", color = Color.White, fontWeight = FontWeight.Bold) }

            Box(
                modifier = Modifier.weight(1f).fillMaxHeight()
                    .clip(RoundedCornerShape(30.dp))
                    .background(if (!isSpace) accent else Color.Transparent)
                    .clickable { isSpace = false },
                contentAlignment = Alignment.Center
            ) { Text("🌍 EARTH", color = if (!isSpace) Color.White else Color.Gray, fontWeight = FontWeight.Bold) }
        }
           )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier.fillMaxWidth().height(140.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(if (isSpace) Color(0xFF1E1E45) else Color.White)
                .padding(16.dp)
        ) {
            Column {
                Text(if (isSpace) "🛰️ Satellite Shield" else "🏠 Home Shield", color = titleColor, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    if (isSpace) "Protecting satellites from fire risks in orbit." else "Protecting your home from fire risks on Earth.",
                    color = if (isSpace) Color(0xFFB8B8D0) else Color.Gray, fontSize = 13.sp
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text("Check Status →", color = accent, fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier.fillMaxWidth().height(70.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(accent),
            contentAlignment = Alignment.Center
        ) {
            Text("Start Protection 🔥", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}