package com.sunnyweather.android.logic.model

import com.google.gson.annotations.SerializedName

class RealtimeResponse(val status: String, val result: Result) {

    class Result(val realtime: Realtime)

    class Realtime(val skycon: String,
                   val temperature: Float,
                   @SerializedName("air_quality") val airQuality: AirQuality,
                   val humidity: Double,
                   val pressure: Double,
                   val visibility: Double,
                   val wind: Wind)

    class AirQuality(val aqi: AQI)

    class AQI(val chn: Float)

    data class Wind(
        val direction: Double,
        val speed: Double
    )

}


