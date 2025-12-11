# thmanyah Task  
A dynamic mobile app that displays podcasts, episodes, audiobooks, and audio articles in scrollable content sections.
The home screen loads data from an API and updates automatically, with each section shown in its own layout style.
The app also includes a fast, debounced search screen that displays results in the same modular format. Built using MVVM, 
Compose UI (Android), and SwiftUI (iOS), with clean architecture and unit tests for core logic.

---

## ✨ Features
- 🔎 Search for characters by name  
- 📱 Dynamic Home Screen

---

## 🛠️ Tech Stack
- **Language:** [Kotlin](https://kotlinlang.org/)  
- **Asynchronous Programming:** Coroutines & Flows  
- **UI:** [Jetpack Compose](https://developer.android.com/jetpack/compose)  
- **Image Loading:** [Coil](https://coil-kt.github.io/coil/)  
- **Networking:** [Retrofit](https://square.github.io/retrofit/)  
- **Architecture:** Clean Architecture + MVVM  
- **Testing:** Unit Tests with JUnit and Coroutines Test  

---

## 🏗️ Architecture
The project is organized into layers, following **Clean Architecture** principles:  

- **Presentation Layer (MVI):** Handles UI state and user interactions using Jetpack Compose  
- **Domain Layer:** Contains business logic, use cases, and pure Kotlin classes  
- **Data Layer:** Responsible for fetching data from the API via Retrofit and mapping it to domain models  

This separation ensures that each layer is independent, testable, and easy to maintain.  

---

## ✅ Testing
- Unit tests for business logic and data handling  
- Coroutines testing for asynchronous operations

---

## 📸 Screenshots
<img width="458" height="829" alt="Screenshot 2025-12-11 at 10 11 42 AM" src="https://github.com/user-attachments/assets/f3f1a825-edf4-43c4-a21e-f0cd2fcf27ec" />
<img width="458" height="829" alt="Screenshot 2025-12-11 at 10 11 50 AM" src="https://github.com/user-attachments/assets/b9bbc8b0-77ae-49e5-8585-59b969141734" />
<img width="458" height="829" alt="Screenshot 2025-12-11 at 10 13 23 AM" src="https://github.com/user-attachments/assets/8ee94761-7d63-4ed5-b6b7-b932650ff26f" />
<img width="458" height="829" alt="Screenshot 2025-12-11 at 10 13 46 AM" src="https://github.com/user-attachments/assets/bf9e085e-42e8-4696-ace4-c9cf01c87a0f" />
