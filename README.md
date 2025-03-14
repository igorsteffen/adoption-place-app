# 🐶 AdoptionPlace  

## 📌 Project Overview  
**AdoptionPlace** is a mobile application designed to connect users with NGOs and shelters to facilitate dog adoptions. The app serves as a **centralized hub for adoption listings**, helping rescue organizations find homes for abandoned dogs. Users can browse available dogs, add them to an adoption cart, and complete the adoption process seamlessly.  

### 🔥 Key Features:  
✔ **User Registration & Login:** Users can create an account, log in, and track their adoption interests.  
✔ **Dog Listings with API Integration:** Fetches real-time dog images and breeds from an external API (Dog CEO API).  
✔ **Adoption Cart System:** Allows users to add dogs to their adoption cart and review selections before proceeding.  
✔ **Data Persistence:** Stores cart information using **SQLite/SharedPreferences** to maintain user selections even after closing the app.  
✔ **Smooth Navigation:** Includes a **bottom navigation bar** for seamless movement between different sections.  

---

## ⚙️ Setup Instructions  

### 🔹 1. Clone the Repository  
```sh
git clone https://github.com/your-username/AdoptionPlace.git
cd AdoptionPlace
```

### 🔹 2. Open the Project in Android Studio  
- Ensure **Android Studio** is installed (preferably the latest version).  
- Open the project and **sync Gradle** to fetch dependencies.  

### 🔹 3. Configure Firebase Authentication (Optional)  
1. Go to [Firebase Console](https://console.firebase.google.com/) and create a new project.  
2. Add an **Android App** with the same package name as your project.  
3. Download the `google-services.json` file and place it inside **app/** directory.  
4. Enable **Email/Password Authentication** in Firebase **Authentication settings**.  

### 🔹 4. Run the App  
- Connect an **Android device** or start an **emulator**.  
- Click **Run** ▶️ in Android Studio to launch the app.  

---

## 🚀 Usage Instructions  

1️⃣ **Launch the App:** The app opens with a **Splash Screen**, transitioning to the **Login Page**.  
2️⃣ **Sign In or Sign Up:** New users can **register** using their email and password.  
3️⃣ **Browse Available Dogs:** Dogs are listed with images, breeds, age, and gender (randomized for now).  
4️⃣ **Adopt a Dog:** Click **"Adopt"** to add a dog to your **Adoption Cart**.  
5️⃣ **Manage Adoption Cart:** Review selected dogs, remove unwanted ones, and proceed to adoption.  
6️⃣ **Logout:** Securely log out using the **Logout button** in the navigation bar.  

---

## ⚠️ Known Issues or Limitations  

🔸 **Fake Data for Age & Gender:** Since the API doesn't provide age/gender, these are currently **randomly generated**.  
🔸 **No Real Adoption Process Yet:** The app currently simulates the adoption cart but doesn't complete a real adoption process.  
🔸 **Limited Dog Information:** The API provides images but lacks details like personality or vaccination records.  
🔸 **No Payment or Verification System:** Future versions could integrate an adoption request system with approval by shelters.  

---

## 🏗️ Future Improvements  
✅ Implement **real adoption request submissions** to shelters.  
✅ Allow **users to post dogs for adoption** directly.  
✅ Improve **data persistence** using Firebase Firestore for real-time updates.  
✅ Add **dog profiles with detailed information** (vaccination status, behavior, etc.).  

---

## 🛠️ Technologies Used  
🔹 **Gradle / Java** for Android development  
🔹 **Retrofit** for API requests  
🔹 **Glide** for image loading  
🔹 **Firebase Authentication** for user management  
🔹 **SQLite / SharedPreferences** for data persistence  
🔹 **RecyclerView** for listing dogs efficiently  

---

## 📞 Contact  
For questions or contributions, feel free to reach out:  
📧 Email: **igorsteffen@hotmail.com**  
🔗 GitHub: igorsteffen(https://github.com/igorsteffen)  
