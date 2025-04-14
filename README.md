# Rider Tracker App: Android Clean Architecture Multi-Repo

Welcome to the **Rider Tracker App**, a showcase project that demonstrates how to architect large-scale Android applications using **Clean Architecture**, **feature-based module isolation**, and **multi-repository collaboration**—ideal for enterprise-grade apps like **Uber**, **Grab**, or **Shopify super apps**.

## 🚀 Project Vision

This project demonstrates how to:
- Build scalable Android applications suitable for **large teams and enterprises**.
- Split development across multiple teams using **feature ownership**.
- Maintain **strict boundaries** and use **contracts (interfaces)** for communication.
- Implement **modular versioning**, allowing each feature to evolve independently.

## 🧱 Architecture Overview

The app follows **Clean Architecture**, separating concerns across:
- **Domain Layer** (contracts, interfaces)
- **Data Layer** (implementation)
- **Presentation Layer** (UI/ViewModels)

Each feature lives in its own repository and is **versioned independently**.

## 📦 Features (Modular Repositories)

### 1. [rider-auth](https://github.com/mobileguruvn/rider-auth)
- Handles login & authentication.
- Includes `auth-contract` and `auth-impl` modules.

### 2. [rider-trip](https://github.com/mobileguruvn/rider-trip)
- Displays a list of trips.
- Includes `trip-contract` and `trip-impl` modules.

### 3. [rider-tracking](https://github.com/mobileguruvn/rider-tracking)
- Tracks live GPS location.
- Includes `tracking-contract` and `tracking-impl` modules.

Each module:
- Communicates via **contract module** only (no direct implementation dependency).
- Publishes to **GitHub Maven Package**.

---

## 🔄 Feature Versioning & Dependency Management
- Each feature is versioned independently using **semantic versioning**.
- Published via **Gradle + Maven Publish Plugin** to GitHub Packages.
- Main application consumes features as versioned dependencies.

---

## ✅ Project Highlights
- Modular codebase with **feature ownership**.
- Use of **navigation contracts** and **DI via Hilt**.
- Isolation between modules via `*-contract` interfaces.
- Realistic **team-based structure** for scalable apps.

---

## 🔜 Upcoming Enhancements

### 📍 GPS Tracking
- Integrate **Google Maps SDK**
- Use **FusedLocationProviderClient** for efficient location updates

### 📊 Analytics
- Integrate **Firebase Analytics** to track user interactions and sessions

---

## 📚 Use This As:
- A reference for building **enterprise-scale** Android apps
- A guideline for **multi-repo CI/CD pipelines**
- A starter architecture for apps aiming for **multi-team development**

---

## 📫 Contributions & Collaboration
Contributions and ideas are welcome. Let’s build enterprise-grade apps the right way.

For any questions or collaboration, feel free to connect via GitHub Issues or Discussions.

---
