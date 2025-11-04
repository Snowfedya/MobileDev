# RestaurantApp - Jules AI Agents Specification

## 📋 Project Overview
- **Project Name:** RestaurantApp (Restaurant Management System)
- **Tech Stack:** Kotlin, Android, Room Database, Firebase (planned)
- **Target API:** Android 8.0+ (API 26)
- **Branch:** lab3-4-1

## 🎯 Core Requirements

### Activity Structure
1. **SplashActivity** - App entry point (quick loading screen)
2. **SignInActivity** - User authentication/login
3. **SignUpActivity** - User registration
4. **HomeActivity** - Main screen with restaurant menu
5. **OnboardingActivity** - Initial app setup guide
6. **BaseActivity** - Parent class for shared functionality

### Database Layer
- **Room Database** with LocalDatabase configuration
- **Entity Models:**
    - User (id, email, password, profile_data)
    - Dish (id, name, description, price, imageUrl, category)
    - Order (id, userId, dishes, total_price, timestamp)
- **DAO Interfaces** for CRUD operations

### UI/UX Requirements
- **Material Design 3** compliance
- **Navigation:** Single Activity + Fragments (or Multi-Activity with proper navigation)
- **Lifecycle Logging:** All activity transitions must be logged
- **Clean, intuitive interface** with proper spacing and colors
- **Data Persistence:** Remember user session, favorites

### Authentication Flow
- Email/Password authentication
- Input validation (non-empty, email format, password strength)
- Session management
- Remember Me functionality (optional)

### Menu Display
- Recyclable list of dishes with images
- Click listener for dish details
- Price display
- Category filtering (optional for this sprint)

## 🔧 Technical Specs

### Manifest Configuration
- Remove unnecessary activities from manifest
- Keep single-activity pattern or proper multi-activity setup
- Proper Intent-filter for launcher activity
- Permissions: INTERNET (for future API calls)

### Navigation Implementation
- Proper back stack management
- No activity leaks
- Smooth transitions between screens
- Proper handling of savedInstanceState

### Data Passing Between Activities
- Use Parcelable or Serializable for complex objects
- Use Intent extras for primitives
- Avoid passing large data structures

### Code Quality
- No memory leaks
- Proper resource cleanup
- Consistent naming conventions (camelCase for vars, PascalCase for classes)
- Comments for complex logic

## 📦 Current Build Status
- ✅ Gradle Build: Successful
- ✅ SDK Configuration: Complete (`/home/snow/Android/Sdk`)
- ✅ NDK: Configured (`26.1.10909125`)
- ✅ Kotlin Support: Enabled

## 🐛 Known Issues to Fix
- Review SignInActivity deprecated methods
- Optimize DishAdapter performance
- Ensure proper lifecycle management in all activities
- Fix any UI layout issues

## 🚀 Next Steps
1. Implement proper activity lifecycle logging
2. Create working authentication flow
3. Build functional menu display with RecyclerView
4. Add database integration
5. Test data persistence
