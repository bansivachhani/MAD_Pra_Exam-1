package com.example.mad_pra_exam_1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun EventDetailsScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        EventHeader(title = "Tech Conference 2024", location = "Mehsana, Gujarat | 2.5 km away",
            description ="This is a detailed description of the event..." )

        EventSchedule()
        ReviewsSection()
        ActionButtons()
    }
}

@Composable
fun EventHeader(title: String, location: String, description: String) {
    Column {
        // Event Header Image
        Image(
            painter = painterResource(id = R.drawable.event), // Your image here
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Event Title
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        // Event Location
        Text(
            text = location,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        // Event Description
        Text(
            text = description,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}

@Composable
fun EventSchedule() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Event Schedule", style = MaterialTheme.typography.titleMedium)

        // Schedule items
        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(listOf(
                "10:00 AM - Opening Ceremony",
                "10:30 AM - Keynote Speech",
                "11:30 AM - Networking Session"
            )) { event ->
                EventScheduleCard(event)
            }
        }
    }
}


@Composable
fun EventScheduleCard(event: String) {
    Card(
        modifier = Modifier
            .padding(end = 8.dp)
            .width(160.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp) // Material3 elevation
    )  {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = event.split(" - ")[0], // Time
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = event.split(" - ")[1], // Event name
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun ReviewsSection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Reviews", style = MaterialTheme.typography.titleMedium)

        // Example reviews
        ReviewCard("Alice Johnson", "Great event! Well-organized and informative.", 5)
        ReviewCard("Bob Smith", "Really enjoyed the keynote speaker. Would recommend!", 4)
        ReviewCard("Charlie Davis", "Good event overall, but some sessions were too short.", 4)
    }
}

@Composable
fun ReviewCard(name: String, review: String, rating: Int) {
    Card(modifier = Modifier.padding(vertical = 8.dp)) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            // User icon (replace with actual image or icon)
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(name, style = MaterialTheme.typography.bodyMedium)
                Text(review, style = MaterialTheme.typography.bodySmall)
            }
            // Rating (stars)
            Text("★".repeat(rating), style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun ActionButtons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(onClick = { /* Action for Buy Tickets */ }, modifier = Modifier.weight(1f)) {
            Text("Buy Tickets")
        }
        Button(onClick = { /* Action for Add to Calendar */ }, modifier = Modifier.weight(1f)) {
            Text("Add to Calendar")
        }
    }
}
