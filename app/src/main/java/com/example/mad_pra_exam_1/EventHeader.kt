package com.example.mad_pra_exam_1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun EventHeader(title: String, location: String, description: String) {
    Column {
        // Header Image
        Image(
            painter = painterResource(id = R.drawable.event), // Replace 'event' with your drawable resource name
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Title, Location, and Description
        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall, // Use Material 3 typography
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = location,
            style = MaterialTheme.typography.bodyMedium, // Adjust if 'bodySmall' doesn't work
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = description,
            style = MaterialTheme.typography.bodySmall, // Ensure this style exists in your theme
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}
