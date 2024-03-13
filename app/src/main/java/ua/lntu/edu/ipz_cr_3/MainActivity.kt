package ua.lntu.edu.ipz_cr_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ua.lntu.edu.ipz_cr_3.ui.theme.IPZ_CR_3Theme
import ua.lntu.edu.ipz_cr_3.ui.theme.Purple40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IPZ_CR_3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ThirtyDaysApp()
                }
            }
        }
    }
}

@Composable
fun ThirtyDaysApp() {
    Column(modifier = Modifier.fillMaxSize()) {
        // Заголовок
        Text(
            text = "30 Days Of Wellness",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(16.dp)
        )

        // Список карточок
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)
        ) {
            itemsIndexed(dayList) { index, day ->
                DayCard(day = day)
                if (index < dayList.size - 1) {
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Composable
fun DayCard(day: Day) {
    var isExpanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(durationMillis = 300)
            )
            .clickable { isExpanded = !isExpanded },
        colors = CardDefaults.cardColors(Purple40)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Day ${day.day}", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = day.activity, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = day.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            if (isExpanded) {
                Text(
                    text = day.description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
data class Day(val day: Int, val activity: String, val image: Int, val description: String)

val dayList = listOf(
    Day(1, "Spend 15 days outdoors", R.drawable.nature, "Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
    Day(2, "Try a new workout routine", R.drawable.nature, "Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
    Day(3, "Try a new workout routine", R.drawable.nature, "Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
    Day(4, "Try a new workout routine", R.drawable.nature, "Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
    Day(5, "Try a new workout routine", R.drawable.nature, "Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
    Day(6, "Try a new workout routine", R.drawable.nature, "Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
    Day(7, "Try a new workout routine", R.drawable.nature, "Lorem ipsum dolor sit amet, consectetur adipiscing elit."),

    // Додаткові елементи списку днів можуть бути додані тут
)

@Preview
@Composable
fun PreviewThirtyDaysApp() {
    ThirtyDaysApp()
}