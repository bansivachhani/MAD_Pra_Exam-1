package com.example.mad_pra_exam_1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EventDetailsScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("EventEase") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back button */ }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Handle share action */ }) {
                        Icon(imageVector = Icons.Default.Share, contentDescription = "Share")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Event Header
            EventHeader(
                title = "Tech Conference 2024",
                location = "Mehsana, Gujarat | 2.5 km away",
                description = "This is a detailed description of the event..."
            )


            Spacer(modifier = Modifier.height(16.dp))

            // Event Schedule
            EventSchedule()

            Spacer(modifier = Modifier.height(16.dp))

            // Reviews Section
            ReviewsSection()

            Spacer(modifier = Modifier.height(16.dp))

            // Bottom Buttons
            ActionButtons()
        }
    }
}

@Composable
fun EventHeader(title: String, location: String, description: String) {
    Column {
        // Event Image
        Box {
            Image(
                painter = painterResource(id = R.drawable.event), // Replace 'event' with your image name
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentScale = ContentScale.Crop
            )
            IconButton(
                onClick = { /* Handle share */ },
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(16.dp)
            ) {
                Icon(imageVector = Icons.Default.Share, contentDescription = "Share", tint = MaterialTheme.colorScheme.onPrimary)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Event Title, Location, and Description
        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = location,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
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
        Text(
            text = "Event Schedule",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            val scheduleList = listOf("10:00 AM\nKeynote Speech", "11:30 AM\nNetworking Session")
            items(scheduleList.size) { index ->
                Card(
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .height(80.dp)
                        .width(120.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(
                            text = scheduleList[index],
                            style = MaterialTheme.typography.bodySmall,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ReviewsSection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Reviews",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        val reviews = listOf(
            "Alice Johnson" to "Great event! Well-organized and informative.",
            "Bob Smith" to "Really enjoyed the keynote speaker. Would recommend!",
            "Charlie Davis" to "Good event overall, but some sessions were too short."
        )
        reviews.forEach { (name, review) ->
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                Row(modifier = Modifier.padding(8.dp)) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(MaterialTheme.shapes.small)
                            .background(MaterialTheme.colorScheme.primary)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(text = name, style = MaterialTheme.typography.titleSmall)
                        Text(text = review, style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}

@Composable
fun ActionButtons() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Button(onClick = { /* Handle Buy Tickets */ }) {
            Text(text = "Buy Tickets")
        }
        Button(onClick = { /* Handle Add to Calendar */ }) {
            Text(text = "Add to Calendar")
        }
    }
}
