package com.kova700.composestudy

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android

val ktorClient = HttpClient(Android) {}