package com.example.projectintern.model

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import com.example.projectintern.utils.LanguageSelection
import java.util.Locale


fun updateAppLanguage(
    context: Context,
    resources: Resources,
    languageSelection: LanguageSelection,
) {
    val locale = when (languageSelection) {
        LanguageSelection.ENGLISH -> Locale.ENGLISH
        LanguageSelection.BANGLA -> Locale("bn")
    }



    val config = Configuration(resources.configuration)
    Locale.setDefault(locale)     // Set the new locale

    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR1) {
        config.setLocale(locale)
    } else {
        config.locale = locale
    }

    // Update the configuration and resources with the new locale
    context.resources.updateConfiguration(config, context.resources.displayMetrics)
}

