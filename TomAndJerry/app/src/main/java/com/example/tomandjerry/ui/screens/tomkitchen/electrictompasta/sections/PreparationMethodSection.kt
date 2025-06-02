package com.example.tomandjerry.ui.screens.tomkitchen.electrictompasta.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tomandjerry.ui.model.PreparationStep
import com.example.tomandjerry.ui.screens.tomkitchen.electrictompasta.components.PreparationStepItem

@Composable
fun PreparationMethodSection(modifier: Modifier = Modifier) {
    val preparationSteps = listOf(
        PreparationStep(
            stepNumber = 1,
            stepText = "Step 1: Prepare the pasta according to the package instructions."
        ),
        PreparationStep(
            stepNumber = 2,
            stepText = "Step 2: Heat the oil in a skillet over medium heat."
        ),
        PreparationStep(
            stepNumber = 3,
            stepText = "Step 3: Add the tomatoes, garlic, and salt to the skillet."
        ),
        PreparationStep(
            stepNumber = 4,
            stepText = "Step 4: Toss the pasta with the tomato mixture."
        ),PreparationStep(
            stepNumber = 1,
            stepText = "Step 1: Prepare the pasta according to the package instructions."
        ),
        PreparationStep(
            stepNumber = 2,
            stepText = "Step 2: Heat the oil in a skillet over medium heat."
        ),
        PreparationStep(
            stepNumber = 3,
            stepText = "Step 3: Add the tomatoes, garlic, and salt to the skillet."
        ),
        PreparationStep(
            stepNumber = 4,
            stepText = "Step 4: Toss the pasta with the tomato mixture."
        )
    )
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Preparation Method",
            style = MaterialTheme.typography.bodyLarge
        )

        preparationSteps.forEach { step ->
            PreparationStepItem(
                stepNumber = step.stepNumber,
                stepText = step.stepText
            )
        }
        /*
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(preparationSteps) { step ->
                PreparationStepItem(
                    stepNumber = step.stepNumber,
                    stepText = step.stepText
                )
            }
        }*/
    }

}