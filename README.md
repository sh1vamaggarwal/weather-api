# Weather API Wrapper Service

This is a Spring Boot application that acts as a wrapper service for the Visual Crossing weather API. It provides a simple REST API to get weather data for a specific location.

For more information about the project, please visit: https://roadmap.sh/projects/weather-api-wrapper-service

## Prerequisites

Before you begin, ensure you have the following installed:

*   **Java 17:** You can download it from [Oracle's website](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) or use a version manager like [SDKMAN!](https://sdkman.io/).
*   **Visual Crossing API Key:** You need to sign up for a free account at [Visual Crossing](https://www.visualcrossing.com/weather-api) to get an API key.

## Running the application

1.  **Clone the repository:**

    ```bash
    git clone https://github.com/your-username/weather-api.git
    cd weather-api
    ```

2.  **Set the `VISUAL_CROSSING_API_KEY` environment variable:**

    ```bash
    export VISUAL_CROSSING_API_KEY="YOUR_API_KEY"
    ```
    Replace `YOUR_API_KEY` with your actual Visual Crossing API key.

3.  **Run the application using Gradle:**

    ```bash
    ./gradlew bootRun
    ```

The application will start on port 8080.

## API Usage

You can get the weather forecast for a location by making a GET request to the `/api/weather` endpoint.

**Example using cURL:**

```bash
curl "http://localhost:8080/api/weather?location=New%20York"
```

This will return a JSON response with the weather forecast for New York.
