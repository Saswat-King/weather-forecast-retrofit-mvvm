# 🌤️ Weather Forecast — Retrofit & MVVM Practice
A simple Android practice app built with Kotlin to fetch and display real-time weather by city name using Retrofit.



---

## 🎬 Demo
 
<table>
  <tr>
    <td align="center">
      <img width="240" src="https://github.com/user-attachments/assets/bdce4e6d-aece-478f-84da-34e050c06c55">
    </td>
    <td align="center">
      <img width="240" src="https://github.com/user-attachments/assets/077ab416-e479-41e2-8e45-62ca001673b7">
    </td>
  </tr>
  <tr>
    <td align="center"><b>Search Weather by City</b></td>
    <td align="center"><b>City Not Found Error Handling</b></td>
  </tr>
</table>


---

 
## ✨ What the App Does
 
- 🔍 Enter any city name and tap **Search**
- 📡 App first calls the **Geocoding API** to convert city name into latitude & longitude
- 🌦️ Then calls the **Weather API** using those coordinates to fetch current weather
- 🌡️ Displays temperature in both **°C and °F**
- 🌤️ Shows weather condition mapped from WMO code — Clear Sky, Cloudy, Fog, Rain, Snow, Thunderstorm and more
- 💨 Shows wind speed and local observation time
- ⏳ Button disables and shows **"Searching..."** while fetching
- ❌ Displays a clear error message if city is not found or network fails

---

## 🧪 Concept Practice

This project was built to practice the following Kotlin & Android concepts:
 
- **Retrofit** — Defined two separate API interfaces (`WeatherApi`, `GeocodingApi`) using `@GET` and `@Query` annotations with `suspend` functions for async network calls
- **Gson Converter** — Used `GsonConverterFactory` to automatically parse JSON responses into Kotlin data classes, and `@SerializedName` to map JSON field names like `windspeed`, `winddirection`, `weathercode` to proper Kotlin naming
- **Two Retrofit Instances** — Created two separate Kotlin `object` singletons (`WeatherClient`, `GeocodingClient`) each pointing to a different base URL for weather and geocoding APIs
- **Kotlin Object & lazy** — Used Kotlin `object` for singleton Retrofit clients and `by lazy` to delay API interface creation until first use
- **Two-Step Sequential API Chain** — First called Geocoding API to convert city name → latitude/longitude, then used those coordinates to call the Weather API — two dependent network calls chained in one `suspend` function
- **Sealed Class for UI State** — Defined `WeatherUiState` as a sealed class with four states: `Idle`, `Loading`, `Success(data)`, and `Error(message)` to represent every possible UI condition
- **MVVM Architecture** — Separated app into Model (response/result data classes), Repository (`WeatherRepository`), ViewModel (`WeatherViewModel`), and View (`MainActivity`)
- **Repository Pattern** — Used `WeatherRepository` to handle both API calls and business logic (temperature conversion, weather code mapping), keeping the ViewModel clean
- **Kotlin Coroutines** — Used `suspend` functions for both API calls and `viewModelScope.launch` with `try-catch` for safe error handling off the main thread
- **StateFlow** — Used `MutableStateFlow<WeatherUiState>` in ViewModel and exposed it as `StateFlow` via `asStateFlow()` to push state updates to the UI
- **Lifecycle-aware Collection** — Used `lifecycleScope.launch` with `repeatOnLifecycle(Lifecycle.State.STARTED)` to safely collect StateFlow in the Activity
- **`when` Expression** — Used in `getWeatherCondition()` to map WMO weather codes to human-readable conditions (Clear Sky, Rain, Snow, Thunderstorm etc.), and again in `observeUiState()` to handle all four UI states
- **`by viewModels()` Delegate** — Used Kotlin property delegation to initialize `WeatherViewModel` in the Activity
- **ViewBinding** — Used `ActivityMainBinding` to access views without `findViewById`
- **Temperature Conversion Logic** — Manually converted Celsius to Fahrenheit `(°C × 9/5) + 32` inside the Repository
- **Input Validation** — Checked for blank city name input and displayed inline error on `TextInputEditText` before triggering search
- **Material Design Components** — Used `TextInputLayout`, `TextInputEditText`, `MaterialButton`, and `MaterialTextView` from the Material Design library

---
## 🛠️ Tech Stack
 
| Component | Technology |
|---|---|
| Language | Kotlin |
| Architecture | MVVM |
| Networking | Retrofit 3.0 |
| JSON Parsing | Gson Converter |
| API | Open-Meteo (Free, no key) |
| Async | Kotlin Coroutines |
| Reactive State | StateFlow |
| UI State | Sealed Class |
| View Access | ViewBinding |
| UI Components | Material Design 3 |
| Min SDK | 26 (Android 8.0) |

---
📚 More Projects <br>
Check out more of my projects on my [GitHub profile](https://github.com/Saswat-King)

