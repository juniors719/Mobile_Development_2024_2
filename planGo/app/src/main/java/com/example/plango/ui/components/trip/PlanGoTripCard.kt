package com.example.plango.ui.components.trip

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plango.R
import com.example.plango.data.mock.mockTrips
import com.example.plango.data.model.Trip
import com.example.plango.ui.theme.Typography

@Composable
fun PlanGoTripCard(
    modifier: Modifier = Modifier,
    trip: Trip,
    onClick: (Trip) -> Unit
) {
    Card(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp)),
        onClick = {
            onClick(trip)
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .fillMaxWidth(0.3f)
                    .height(IntrinsicSize.Min)
                    .aspectRatio(ratio = 1f, matchHeightConstraintsFirst = true),
                contentScale = ContentScale.Crop,
                painter = painterResource(R.drawable.zermatt), // TODO: Substituir pela imagem do estabelecimento
                contentDescription = "Imagem de capa do estabelecimento"
            )
            Column{
                // Título do estabelecimento
                Text(text = trip.name, style = Typography.headlineSmall.copy(fontSize = 16.sp))

                Spacer(modifier = Modifier.height(8.dp))

                // Descrição do estabelecimento
                Text(
                    text = trip.description ?: "",
                    style = Typography.bodyMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Data de início e fim da viagem
                Text(
                    text = (trip.startDate ?: "") + " ~ " + (trip.endDate ?: ""),
                    style = Typography.bodyMedium
                )
            }
        }
    }
}

@Preview
@Composable
private fun PlanGoTripCardPreview() {
    PlanGoTripCard(
        trip = mockTrips.first(),
        onClick = {}
    )
}