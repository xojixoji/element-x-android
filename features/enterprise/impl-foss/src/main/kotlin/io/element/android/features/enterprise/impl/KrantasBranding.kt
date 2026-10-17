/*
 * Copyright 2026 Krantas.
 *
 * SPDX-License-Identifier: AGPL-3.0-only.
 * Please see LICENSE files in the repository root for full details.
 */

package io.element.android.features.enterprise.impl

import io.element.android.compound.annotations.CoreColorToken
import io.element.android.compound.colors.SemanticColorsLightDark
import io.element.android.compound.tokens.generated.SemanticColors
import io.element.android.compound.tokens.generated.compoundColorsDark
import io.element.android.compound.tokens.generated.compoundColorsLight
import io.element.android.compound.tokens.generated.internal.DarkColorTokens
import io.element.android.compound.tokens.generated.internal.LightColorTokens
import io.element.android.libraries.matrix.api.accountprovider.AccountProvider

/**
 * Krantas branding: the company server and a blue accent instead of Element green.
 */
@OptIn(CoreColorToken::class)
object KrantasBranding {
    val accountProvider = AccountProvider.Managed(
        serverName = "krantas.adminz.uz",
        baseUrl = "https://krantas.adminz.uz",
        canUseServerName = true,
    )

    val colors = SemanticColorsLightDark(
        light = compoundColorsLight.withBlueAccent(LightColorTokens),
        dark = compoundColorsDark.withBlueAccent(DarkColorTokens),
    )

    private fun SemanticColors.withBlueAccent(t: LightColorTokens) = blueAccent(
        t.colorBlue900, t.colorBlue1000, t.colorBlue1100, t.colorAlphaBlue300, t.colorBlue200, t.colorBlue400, t.colorBlue700, t.colorBlue800,
    )

    private fun SemanticColors.withBlueAccent(t: DarkColorTokens) = blueAccent(
        t.colorBlue900, t.colorBlue1000, t.colorBlue1100, t.colorAlphaBlue300, t.colorBlue200, t.colorBlue400, t.colorBlue700, t.colorBlue800,
    )

    private fun SemanticColors.blueAccent(
        b900: androidx.compose.ui.graphics.Color,
        b1000: androidx.compose.ui.graphics.Color,
        b1100: androidx.compose.ui.graphics.Color,
        alpha300: androidx.compose.ui.graphics.Color,
        b200: androidx.compose.ui.graphics.Color,
        b400: androidx.compose.ui.graphics.Color,
        b700: androidx.compose.ui.graphics.Color,
        b800: androidx.compose.ui.graphics.Color,
    ) = copy(
        bgAccentRest = b900,
        bgAccentHovered = b1000,
        bgAccentPressed = b1100,
        bgAccentSelected = alpha300,
        bgAccentSubtle = b200,
        bgBadgeAccent = b400,
        borderAccentPrimary = b900,
        borderAccentSubtle = b700,
        iconAccentPrimary = b900,
        iconAccentTertiary = b800,
        textActionAccent = b900,
        textBadgeAccent = b1100,
        // Главные кнопки синие, как в прототипе, а не почти чёрные
        bgActionPrimaryRest = b900,
        bgActionPrimaryHovered = b1000,
        bgActionPrimaryPressed = b1100,
    )
}
