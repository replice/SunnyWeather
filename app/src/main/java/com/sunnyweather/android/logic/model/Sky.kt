package com.sunnyweather.android.logic.model

import com.sunnyweather.android.R

class Sky (val info: String, val icon: Int, val bg: Int)

private val sky = mapOf(
    "CLEAR_DAY" to Sky("晴", R.drawable.ic_clear_day, R.drawable.background_sunny),
    "CLEAR_NIGHT" to Sky("晴", R.drawable.ic_clear_night, R.drawable.background_sunny_night),
    "PARTLY_CLOUDY_DAY" to Sky("多云", R.drawable.ic_partly_cloud_day, R.drawable.background_cloudy),
    "PARTLY_CLOUDY_NIGHT" to Sky("多云", R.drawable.ic_partly_cloud_night, R.drawable.background_sunny_night),
    "CLOUDY" to Sky("阴", R.drawable.ic_cloudy, R.drawable.background_cloudy),
    "WIND" to Sky("大风", R.drawable.ic_cloudy, R.drawable.background_wind),
    "LIGHT_RAIN" to Sky("小雨", R.drawable.ic_light_rain, R.drawable.background_rain),
    "MODERATE_RAIN" to Sky("中雨", R.drawable.ic_moderate_rain, R.drawable.background_rain),
    "HEAVY_RAIN" to Sky("大雨", R.drawable.ic_heavy_rain, R.drawable.background_rain),
    "STORM_RAIN" to Sky("暴雨", R.drawable.ic_storm_rain, R.drawable.background_rain),
    "THUNDER_SHOWER" to Sky("雷阵雨", R.drawable.ic_thunder_shower, R.drawable.background_rain),
    "SLEET" to Sky("雨夹雪", R.drawable.ic_sleet, R.drawable.background_rain),
    "LIGHT_SNOW" to Sky("小雪", R.drawable.ic_light_snow, R.drawable.background_snow),
    "MODERATE_SNOW" to Sky("中雪", R.drawable.ic_moderate_snow, R.drawable.background_snow),
    "HEAVY_SNOW" to Sky("大雪", R.drawable.ic_heavy_snow, R.drawable.background_snow),
    "STORM_SNOW" to Sky("暴雪", R.drawable.ic_heavy_snow, R.drawable.background_snow),
    "HAIL" to Sky("冰雹", R.drawable.ic_hail, R.drawable.background_snow),
    "LIGHT_HAZE" to Sky("轻度雾霾", R.drawable.ic_light_haze, R.drawable.background_light_haze),
    "MODERATE_HAZE" to Sky("中度雾霾", R.drawable.ic_moderate_haze, R.drawable.background_moderate_haze),
    "HEAVY_HAZE" to Sky("重度雾霾", R.drawable.ic_heavy_haze, R.drawable.background_heavy_haze),
    "FOG" to Sky("雾", R.drawable.ic_fog, R.drawable.background_fog),
    "DUST" to Sky("浮尘", R.drawable.ic_fog, R.drawable.background_dust)
)

fun getSky(skycon: String): Sky {
    return sky[skycon] ?: sky["CLEAR_DAY"]!!
}