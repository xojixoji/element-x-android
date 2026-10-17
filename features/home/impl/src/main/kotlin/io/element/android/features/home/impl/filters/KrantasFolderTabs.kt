/*
 * Copyright 2026 Krantas.
 *
 * SPDX-License-Identifier: AGPL-3.0-only.
 * Please see LICENSE files in the repository root for full details.
 */

package io.element.android.features.home.impl.filters

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import io.element.android.compound.theme.ElementTheme
import io.element.android.features.home.impl.R
import io.element.android.libraries.designsystem.preview.ElementPreview
import io.element.android.libraries.designsystem.preview.PreviewsDayNight
import io.element.android.libraries.designsystem.theme.components.Text

/**
 * Krantas: папки чатов вкладками, как в Telegram. Выбрана всегда одна вкладка; «Все» снимает фильтры.
 * Рисуется на цветной шапке, поэтому текст белый.
 */
@Composable
fun KrantasFolderTabs(
    state: RoomListFiltersState,
    modifier: Modifier = Modifier,
    contentColor: Color = Color.White,
) {
    val selected = state.selectedFilters().firstOrNull()
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        item("all") {
            FolderTab(
                title = stringResource(R.string.krantas_folder_all),
                isSelected = selected == null,
                contentColor = contentColor,
                onClick = { state.eventSink(RoomListFiltersEvent.ClearSelectedFilters) },
            )
        }
        state.filterSelectionStates.forEach { filterState ->
            item(filterState.filter) {
                FolderTab(
                    title = stringResource(filterState.filter.stringResource),
                    isSelected = filterState.filter == selected,
                    contentColor = contentColor,
                    onClick = {
                        if (filterState.filter != selected) {
                            state.eventSink(RoomListFiltersEvent.ClearSelectedFilters)
                            state.eventSink(RoomListFiltersEvent.ToggleFilter(filterState.filter))
                        }
                    },
                )
            }
        }
    }
}

@Composable
private fun FolderTab(
    title: String,
    isSelected: Boolean,
    contentColor: Color,
    onClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .clickable(role = Role.Tab, onClick = onClick)
            .padding(horizontal = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier.height(44.dp),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = title,
                style = if (isSelected) ElementTheme.typography.fontBodyLgMedium else ElementTheme.typography.fontBodyLgRegular,
                color = if (isSelected) contentColor else contentColor.copy(alpha = 0.75f),
                maxLines = 1,
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .background(
                    color = if (isSelected) contentColor else Color.Transparent,
                    shape = RoundedCornerShape(topStart = 3.dp, topEnd = 3.dp),
                )
        )
    }
}

@PreviewsDayNight
@Composable
internal fun KrantasFolderTabsPreview() = ElementPreview {
    Box(modifier = Modifier.background(ElementTheme.colors.bgAccentRest)) {
        KrantasFolderTabs(state = aRoomListFiltersState())
    }
}
