<div style="text-align:center; padding-top:10px;"><image src="./assets/star-wars.svg" height="100px"></div>

## What can I find in the app?

- Functional login / register
- Session manage with token
- Information about vehicles, starships, films and people of the Star Wars World

## How can I navigate the app?

- Clicking in [THIS TEXT](https://star-wars-three-iota.vercel.app/) for go to the app's deployment (May taje a while to load)
- Downloading this project and following next steps
  - PREVIUS REQUIREMENTS:
    - Have the latest version of java installed
    - Have the latest version of gradle installed
    - Have the latest version of node / npm installed
  - In the folder client, rename the file `.env-template` to `.env` and change the value of `VITE_API_BASE_URL` for your back url if you need it
  - Open two consoles in the app's root folder
  - With the first one put the following commands
  ```bash
  cd client
  npm i
  npm run dev
  ```
  - With the other console put these commands
  ```bash
  cd sw
  ./gradlew build
  java -jar ./build/libs/sw-0.0.1-SNAPSHOT.jar
  ```
  - With your favorite browser open [THIS LINK](http://127.0.0.1:5173/)
  - In case of you can't use the browser, can use [this postman collection](https://api.postman.com/collections/13175264-8d1c53b4-864d-462e-bd8b-ab865393520b?access_key=PMAT-01J2W71TM9CNWZKQ0K2PYC795Y) for test the back-end
    - For use the GET endpoints, you need to call register or login endpoint and when return the token you need put it in a header with key `Authorization` and value `Bearer <put here your token>` in heach GET call

## How can contact the developer in case of errors?

- Send an email to ignaciogimenez70@gmail.com
- Open an issue in this repository if you know the solution!