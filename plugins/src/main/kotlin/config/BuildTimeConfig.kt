/*
 * Copyright (c) 2025 Element Creations Ltd.
 * Copyright 2025 New Vector Ltd.
 *
 * SPDX-License-Identifier: AGPL-3.0-only OR LicenseRef-Element-Commercial.
 * Please see LICENSE files in the repository root for full details.
 */

package config

object BuildTimeConfig {
    const val APPLICATION_ID = "uz.adminz.krantas"
    const val APPLICATION_NAME = "Krantas"
    val METADATA_HOST_REVERSED: String? = "uz.adminz.krantas"
    val OAUTH_CLIENT_URL_PATH: String? = "apps/android"
    val URL_WEBSITE: String? = "https://krantas.adminz.uz"
    val URL_LOGO: String? = "https://krantas.adminz.uz/app/logo.png"
    val URL_COPYRIGHT: String? = null
    val URL_ACCEPTABLE_USE: String? = "https://krantas.adminz.uz/app/terms"
    val URL_PRIVACY: String? = null
    val URL_POLICY: String? = "https://krantas.adminz.uz/app/privacy"
    val SERVICES_MAPTILER_BASE_URL: String? = null
    val SERVICES_MAPTILER_APIKEY: String? = null
    val SERVICES_MAPTILER_LIGHT_MAPID: String? = null
    val SERVICES_MAPTILER_DARK_MAPID: String? = null
    val SERVICES_POSTHOG_HOST: String? = null
    val SERVICES_POSTHOG_APIKEY: String? = null
    val SERVICES_SENTRY_DSN: String? = null
    val SERVICES_SENTRY_DSN_RUST: String? = null
    val BUG_REPORT_URL: String? = ""
    val BUG_REPORT_APP_NAME: String? = null
    const val PUSH_CONFIG_INCLUDE_FIREBASE: Boolean = true
    const val PUSH_CONFIG_INCLUDE_UNIFIED_PUSH: Boolean = true
    val PUSHER_APP_ID_RELEASE: String? = null
    val PUSHER_APP_ID_DEBUG: String? = null
    val PUSHER_APP_ID_NIGHTLY: String? = null
}
