package com.example.watermyplants

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// this is just a thing for hilt to decorate
// if we don't have it, we can't dependency inject
@HiltAndroidApp
class MyApp: Application()