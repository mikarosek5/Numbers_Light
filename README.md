
# Numbers Light (Android) v1.1

Recruitment task given by recruitment team.

I had to create Android application which cosume json data from REST API endpoint,
and display it to the user as list screen and details screen.









## Authors

- [@mikarosek5](https://www.github.com/mikarosek5)


## Tech Stack

 - [Architecture -MVVM](https://developer.android.com/topic/architecture#recommended-app-arch)
 - [Language- Kotlin](https://developer.android.com/kotlin)
 - [Dependency incjection - Dagger Hilt](https://dagger.dev/hilt/)
 - [Concurrency and data streams - RxJava](https://reactivex.io/)
 - [Networking - Retrofit/OkHttp/GSON/Picasso](https://square.github.io/)
 


## Screenshots
- Tablet
Portrait
![App Screenshot](https://i.ibb.co/gRPhK7F/Screenshot-from-2022-10-16-23-03-26.png)

Landscape
![App Screenshot](https://i.ibb.co/n8QL3Qz/Screenshot-20221016-231150.png)

---

- Phone
Portrait
![App Screenshot](https://i.ibb.co/VBS5sBf/Screenshot-20221016-231519.png)

Landscape
![App Screenshot](https://i.ibb.co/4ZqKFvY/Screenshot-20221016-231541.png)

Details
![App Screenshot](https://i.ibb.co/D97S69T/Screenshot-20221016-231601.png)

Internet not available (Red refresh button- Not clickable)
![App Screenshot](https://i.ibb.co/51kMBCh/Screenshot-20221016-231637.png)




## API Reference

#### Get all NumbersLights

```http
  GET /test/json.php
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `none` | | Returns list of NumberLight     |

#### Get NumberLightDetails

```http
  GET /test/json.php?name={$name}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`      | `string` | **Required**. Name of item to fetch details |



## Appendix

First time with RxJava.


## License

[MIT](https://choosealicense.com/licenses/mit/)

