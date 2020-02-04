/*
 *
 * Copyright (c) 2019 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 */

package com.example.weatherappk.Data.Model

import android.os.Parcel
import android.os.Parcelable

data class Data(

    val time: Int,
    val summary: String?,
    val icon: String?,
    val sunriseTime: Int,
    val sunsetTime: Int,
    val moonPhase: Double,
    val precipIntensity: Double,
    val precipIntensityMax: Double,
    val precipIntensityMaxTime: Int,
    val precipProbability: Double,
    val precipType: String?,
    val temperatureHigh: Double,
    val temperatureHighTime: Int,
    val temperatureLow: Double,
    val temperatureLowTime: Int,
    val apparentTemperatureHigh: Double,
    val apparentTemperatureHighTime: Int,
    val apparentTemperatureLow: Double,
    val apparentTemperatureLowTime: Int,
    val dewPoint: Double,
    val humidity: Double,
    val pressure: Double,
    val windSpeed: Double,
    val windGust: Double,
    val windGustTime: Int,
    val windBearing: Int,
    val cloudCover: Double,
    val uvIndex: Int,
    val uvIndexTime: Int,
    val visibility: Double,
    val ozone: Double,
    val temperatureMin: Double,
    val temperatureMinTime: Int,
    val temperatureMax: Double,
    val temperatureMaxTime: Int,
    val apparentTemperatureMin: Double,
    val apparentTemperatureMinTime: Int,
    val apparentTemperatureMax: Double,
    val apparentTemperatureMaxTime: Int
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(time)
        parcel.writeString(summary)
        parcel.writeString(icon)
        parcel.writeInt(sunriseTime)
        parcel.writeInt(sunsetTime)
        parcel.writeDouble(moonPhase)
        parcel.writeDouble(precipIntensity)
        parcel.writeDouble(precipIntensityMax)
        parcel.writeInt(precipIntensityMaxTime)
        parcel.writeDouble(precipProbability)
        parcel.writeString(precipType)
        parcel.writeDouble(temperatureHigh)
        parcel.writeInt(temperatureHighTime)
        parcel.writeDouble(temperatureLow)
        parcel.writeInt(temperatureLowTime)
        parcel.writeDouble(apparentTemperatureHigh)
        parcel.writeInt(apparentTemperatureHighTime)
        parcel.writeDouble(apparentTemperatureLow)
        parcel.writeInt(apparentTemperatureLowTime)
        parcel.writeDouble(dewPoint)
        parcel.writeDouble(humidity)
        parcel.writeDouble(pressure)
        parcel.writeDouble(windSpeed)
        parcel.writeDouble(windGust)
        parcel.writeInt(windGustTime)
        parcel.writeInt(windBearing)
        parcel.writeDouble(cloudCover)
        parcel.writeInt(uvIndex)
        parcel.writeInt(uvIndexTime)
        parcel.writeDouble(visibility)
        parcel.writeDouble(ozone)
        parcel.writeDouble(temperatureMin)
        parcel.writeInt(temperatureMinTime)
        parcel.writeDouble(temperatureMax)
        parcel.writeInt(temperatureMaxTime)
        parcel.writeDouble(apparentTemperatureMin)
        parcel.writeInt(apparentTemperatureMinTime)
        parcel.writeDouble(apparentTemperatureMax)
        parcel.writeInt(apparentTemperatureMaxTime)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Data> {
        override fun createFromParcel(parcel: Parcel): Data {
            return Data(parcel)
        }

        override fun newArray(size: Int): Array<Data?> {
            return arrayOfNulls(size)
        }
    }
}