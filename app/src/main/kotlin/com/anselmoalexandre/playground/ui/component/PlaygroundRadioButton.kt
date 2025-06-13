package com.anselmoalexandre.playground.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun PlaygroundRadioButton(
    @DrawableRes icon: Int,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onSelectedChange: ((Boolean) -> Unit)? = null,
    enabled: Boolean = true,
    colors: PlaygroundRadioButtonColors = PlaygroundRadioButtonDefaults.colors(),
    interactionSource: MutableInteractionSource? = null
) {
    val containerColor = if (selected) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.background
    }

    val equityRadioButtonColors = colors.copy(
        containerColor = containerColor,
        contentColor = MaterialTheme.colorScheme.onPrimary,
    )

    val colors = CardDefaults
        .cardColors()
        .copy(
            containerColor = equityRadioButtonColors.containerColor,
            contentColor = equityRadioButtonColors.contentColor,
            disabledContainerColor = equityRadioButtonColors.disabledContainerColor,
            disabledContentColor = equityRadioButtonColors.disabledContentColor,
        )

    val onClick: () -> Unit = if (enabled) {
        if (onSelectedChange != null) {
            { onSelectedChange(!selected) }
        } else {
            {}
        }
    } else {
        {}
    }

    Card(
        onClick = onClick,
        enabled = enabled,
        shape = CircleShape,
        colors = colors,
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.primary
        ),
        interactionSource = interactionSource,
        modifier = modifier
            .requiredSize(
                width = 24.dp,
                height = 24.dp
            ),
    ) {
        if (selected) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.padding(2.dp),
            )
        }
    }
}

/** Defaults used in [RadioButton]. */
object PlaygroundRadioButtonDefaults {
    @Composable
    fun colors(
        containerColor: Color = Color.Unspecified,
        contentColor: Color = Color.Unspecified,
        disabledContainerColor: Color = Color.Unspecified,
        disabledContentColor: Color = Color.Unspecified,
    ): PlaygroundRadioButtonColors =
        PlaygroundRadioButtonColors(
            containerColor,
            contentColor,
            disabledContainerColor,
            disabledContentColor,
        )
}

@Immutable
class PlaygroundRadioButtonColors(
    val containerColor: Color,
    val contentColor: Color,
    val disabledContainerColor: Color,
    val disabledContentColor: Color,
) {
    fun copy(
        containerColor: Color = this.containerColor,
        contentColor: Color = this.contentColor,
        disabledContainerColor: Color = this.disabledContainerColor,
        disabledContentColor: Color = this.disabledContentColor,
    ) = PlaygroundRadioButtonColors(
        containerColor = containerColor.takeOrElse { this.containerColor },
        contentColor = contentColor.takeOrElse { this.contentColor },
        disabledContainerColor = disabledContainerColor.takeOrElse { this.disabledContainerColor },
        disabledContentColor = disabledContentColor.takeOrElse { this.disabledContentColor }
    )
}
