package org.adam.resume.website.ui

import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable

val AppOutlinedTextFieldColors
    @Composable
    get() = TextFieldDefaults.outlinedTextFieldColors(
        backgroundColor = LocalAppColors.current.secondary,
        focusedBorderColor = LocalAppColors.current.primary,
        focusedLabelColor = LocalAppColors.current.onPrimary,
        unfocusedLabelColor = LocalAppColors.current.onSecondary,
        textColor = LocalAppColors.current.onSecondary,
    )

val AppButtonColors
    @Composable
    get() = ButtonDefaults.buttonColors(
        backgroundColor = LocalAppColors.current.primary,
        contentColor = LocalAppColors.current.onPrimary
    )
val SelectedButtonColors
    @Composable
    get() = ButtonDefaults.buttonColors(
        backgroundColor = LocalAppColors.current.secondary,
        contentColor = LocalAppColors.current.onSecondary
    )

val AppCheckboxColors
    @Composable
    get() = CheckboxDefaults.colors(
        checkedColor = LocalAppColors.current.primary,
        uncheckedColor = LocalAppColors.current.onPrimary,
        checkmarkColor = LocalAppColors.current.secondary,
    )