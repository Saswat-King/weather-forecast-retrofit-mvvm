package com.kingstudio.weatherforecast.model.response

import com.kingstudio.weatherforecast.model.result.GeoCodingResult

data class GeoCodingResponse(

    val results: List<GeoCodingResult>?
)
