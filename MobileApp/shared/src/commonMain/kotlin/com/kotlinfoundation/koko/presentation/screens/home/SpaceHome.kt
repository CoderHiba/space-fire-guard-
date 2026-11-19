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
import com.spacefireguard.presentation.screens.home.FireRiskCalculator

@Composable
fun SpaceHome() {
    var isSpace by remember { mutableStateOf(true) }
    val accent = Color(0xFFFF6B35)
    val darkBg = Color(0xFF0F172A)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(darkBg)
            .padding(16.dp)
    ) {
        // SPACE | EARTH
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(50.dp))
                .background(Color(0xFF1E293B))
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(50.dp))
                    .background(if (isSpace) Color.White else Color.Transparent)
                    .clickable { isSpace = true }
                    .padding(vertical = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "🚀 SPACE",
                    color = if (isSpace) Color.Black else Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(50.dp))
                    .background(if (!isSpace) Color.White else Color.Transparent)
                    .clickable { isSpace = false }
                    .padding(vertical = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "🌍 EARTH",
                    color = if (!isSpace) Color.Black else Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFF1E293B))
                .padding(16.dp)
        ) {
            Column {
                Text(
                    text = if (isSpace) "🛰️ Satellite Shield" else "🏠 Home Shield",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = if (isSpace) "Protecting satellites from fire risks" else "Protecting your home from fire risks",
                    color = if (isSpace) Color(0xFF94A3B8) else Color.Gray,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Check Status ->",
                    color = accent,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(accent),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Start Protection 🔥",
                color = Color.White, 
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    Spacer(modifier = Modifier.height(16.dp))
    FireRiskCalculator()
    }
}