# Sunshine

Sunshine is a free weather app for Android Devices that shows the weather forecast over the next 2 weeks. It uses the internet connection to display weather data. Sunshine is developed as a companion app for Udacity's course on Advanced Android Development as a part of Udacity's Android Developer Nanodegree program, owing to the Tata Trusts and Google India Scholarship Program.

## Available on Google Play

<a href="https://play.google.com/store/apps/details?id=com.passenger.android.sunshine.app">
<img alt="Get it on Google Play" src="http://steverichey.github.io/google-play-badge-svg/img/en_get.svg" />
</a>

## Features

* FORECAST : Weather Forecast for any location selected by the user including High/Low temperatures for the day along with the humidity level, wind speed and pressure for the selected day.

* LIVE WALLPAPERS : Sunshine sets your home screen wallpaper according to the current day's weather that updates as the forecast for the day changes so that you don't even have to open the app to know the day's weather ( You need to have Muzei installed for this functionality ).

* WIDGETS : Sunshine includes two different widgets, one displaying the current day's weather and the other displaying a list of weather forecasts, right on your home screen saving you the pain of opening the app constantly.

* NOTIFICATIONS : Sunshine pops a notification whenever the weather predictions change so that you are never at the wrong place at the wrong time.

* ACCESSIBILITY : The app works with the TalkBack functionality on your device so that the app is equally useful to people with certain disabilities responding to touches and gestures.

* SUPPORT FOR TABLETS AND ROTATION : Sunshine includes a separate design for both tablets and the landscape mode so that users are always presented the forecast in the most beautiful way possible, irrespective of how and where they choose to use it.

* ICONS: Users can select a different icon pack for displaying the weather predictions from the Settings screen.

## Getting Started

The app fetches weather data using [Open Weather Map](http://openweathermap.org/) API. You need to have your own API Key for running the app. When you get it, replace MyOpenWeatherAPIKey with the key you received in the following file:
    ```
    app/build.gradle
    ```

## Screenshots

![screen](../master/screens/Phone/1.png)

![screen](../master/screens/Phone/2.png)

![screen](../master/screens/Phone/3.png)

![screen](../master/screens/Phone/4.png)

![screen](../master/screens/Phone/5.png)

![screen](../master/screens/Phone/3.png)

![screen](../master/screens/Tablet/1.png)

![screen](../master/screens/Tablet/2.png)

![screen](../master/screens/Tablet/3.png)

## Libraries

* [Android Support Annotations](http://tools.android.com/tech-docs/support-annotations)
* [Glide](https://github.com/bumptech/glide)
* [Google Location API](https://developers.google.com/android/reference/com/google/android/gms/location/LocationServices)
* [Google Cloud Messaging](https://developers.google.com/cloud-messaging/)
* [Muzei](https://github.com/romannurik/muzei)

## Android Developer Nanodegree
[![udacity][1]][2]

[1]: ../master/screens/nanodegree.png
[2]: https://www.udacity.com/course/android-developer-nanodegree--nd801

## License

    Copyright 2016 Aman Dalmia

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
