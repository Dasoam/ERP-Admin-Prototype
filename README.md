# ERP Prototype - Firebase Event Posting App

This is an Android application that allows users to post event messages with a title, content, and the name of the person posting the message. The application interacts with Firebase Firestore to store the posted data.

## Features

- **Message Posting**: Users can input a title, message content, and the name of the person posting.
- **Firestore Integration**: Posts are stored in Firebase Firestore in the `eventsMessages` collection.
- **Input Validation**: Ensures that all fields (title, message, posted by) are filled before submitting.
- **Success & Error Feedback**: Toast notifications inform the user about the success or failure of their message submission.

## Technologies Used

- **Android SDK**: The app is built using Android Studio with Java.
- **Firebase Firestore**: A NoSQL cloud database to store the posts.
- **Firebase Authentication (Optional)**: Not included but can be added for user management in the future.

## Requirements

- **Android Studio**: To build and run the app.
- **Firebase Account**: You will need a Firebase project to integrate Firestore.

## Installation

Follow the steps below to get this project up and running locally:

### Step 1: Clone the Repository

```bash
git clone https://github.com/Dasoam/ERP-Prototype.git
```

### Step 2: Set Up Firebase

1. Go to the [Firebase Console](https://console.firebase.google.com/).
2. Create a new Firebase project (or use an existing one).
3. Add an Android app to your Firebase project:
   - Enter the package name of the app (e.g., `com.dadash.erpadmin`).
   - Download the `google-services.json` file and place it in the `app` directory of your Android project.

### Step 3: Add Firebase SDK

1. Open `build.gradle` (Project-level) and add the following:
   ```gradle
   classpath 'com.google.gms:google-services:4.3.15' // Make sure the version is up to date
   ```

2. Open `build.gradle` (App-level) and add the following:
   ```gradle
   implementation 'com.google.firebase:firebase-firestore:24.3.0' // Firebase Firestore SDK
   implementation 'com.google.firebase:firebase-auth:21.2.0'    // Firebase Auth SDK (optional for authentication)
   apply plugin: 'com.google.gms.google-services'
   ```

### Step 4: Sync Gradle

Click **Sync Now** to sync the project with Gradle files after editing the `build.gradle` files.

### Step 5: Run the Application

- Open Android Studio and select the **Run** option to build and launch the app on an emulator or a physical device.
- The app should be up and running. You can now enter a title, message, and "posted by" information and hit **Post** to save the message to Firestore.

## Usage

Once the app is launched:

1. **Enter a title** in the `Title` field.
2. **Enter the message** you want to post in the `Message` field.
3. **Enter the name** of the person posting in the `Posted By` field.
4. Press the **Post** button.
   - If any fields are empty, the app will show a toast message: `"All fields are required"`.
   - If the post is successful, it will be saved to Firestore, and you will see a success toast message: `"Message posted successfully"`.
   - If there's an error while posting the message, an error toast will be shown: `"Error posting message"`.

## Firestore Structure

The posts are stored in Firebase Firestore under the collection `eventsMessages` with the following fields:

- **title** (String): The title of the event/message.
- **message** (String): The content of the post.
- **postedBy** (String): The name of the person who posted the message.
- **timestamp** (Long): The timestamp when the message was posted.

## Contributing

Contributions are welcome! To contribute to this project:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Open a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

### Notes:
- Feel free to add any additional setup or information relevant to the Firebase project or Android app configuration.
- If you have any other specific features or details to mention (like additional Firebase configurations), include them in the `Usage` or `Setup` sections. 

Let me know if you'd like to modify or add anything else to the README!
