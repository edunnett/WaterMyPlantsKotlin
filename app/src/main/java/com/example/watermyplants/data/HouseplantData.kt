package com.example.watermyplants.data

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.watermyplants.data.Houseplant
import com.example.watermyplants.R
class HouseplantProvider: PreviewParameterProvider<Houseplant> {
    override val values = HouseplantData.list.asSequence()
}
object HouseplantData {
    val list = listOf(
        Houseplant(
            name = "Monstera",
            status = "Healthy",
            imageUrl = "https://images.pexels.com/photos/3153521/pexels-photo-3153521.jpeg?auto=compress&cs=tinysrgb&w=1600"
        ),
        Houseplant(
            name = "Snake Plant",
            status = "Alive",
            imageUrl = "https://images.pexels.com/photos/8098486/pexels-photo-8098486.jpeg?auto=compress&cs=tinysrgb&w=1600"
        ),
        Houseplant(
            name = "Lavendar",
            status = "Alive",
            imageUrl = "https://images.pexels.com/photos/12652589/pexels-photo-12652589.jpeg?auto=compress&cs=tinysrgb&w=1600"
        ),
        Houseplant(
            name = "Expensive Ficus",
            status = "Dead",
            imageUrl = "https://images.pexels.com/photos/6001644/pexels-photo-6001644.jpeg?auto=compress&cs=tinysrgb&w=1600"
        ),
        Houseplant(
            name = "Aloe Vera",
            status = "Almost Dead",
            imageUrl = "https://images.pexels.com/photos/2821822/pexels-photo-2821822.jpeg?auto=compress&cs=tinysrgb&w=1600"
        )
    )
}
