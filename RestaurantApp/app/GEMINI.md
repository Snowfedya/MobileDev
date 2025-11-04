
# RestaurantApp - Gemini AI Context Guide

## 🎯 Project Summary
**RestaurantApp** - Android restaurant menu management application using Kotlin and Room Database.

## 📂 Project Structure
```
RestaurantApp/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/restaurantapp/
│   │   │   ├── activity/           # All Activities
│   │   │   │   ├── BaseActivity.kt
│   │   │   │   ├── SplashActivity.kt
│   │   │   │   ├── SignInActivity.kt
│   │   │   │   ├── SignUpActivity.kt
│   │   │   │   ├── HomeActivity.kt
│   │   │   │   └── OnboardingActivity.kt
│   │   │   ├── database/           # Room Database
│   │   │   │   ├── LocalDatabase.kt
│   │   │   │   ├── entity/
│   │   │   │   │   ├── User.kt
│   │   │   │   │   ├── Dish.kt
│   │   │   │   │   └── Order.kt
│   │   │   │   └── dao/
│   │   │   │       ├── UserDAO.kt
│   │   │   │       ├── DishDAO.kt
│   │   │   │       └── OrderDAO.kt
│   │   │   ├── adapter/           # RecyclerView Adapters
│   │   │   │   └── DishAdapter.kt
│   │   │   ├── util/              # Utilities & Constants
│   │   │   │   ├── Constants.kt
│   │   │   │   └── Validators.kt
│   │   │   └── model/             # Data Models
│   │   ├── res/
│   │   │   ├── layout/            # XML Layouts
│   │   │   ├── drawable/          # Icons & Images
│   │   │   └── values/            # Strings, Colors, Dimensions
│   │   └── AndroidManifest.xml
│   └── build.gradle.kts
├── local.properties               # SDK Configuration
├── AGENTS.md                       # Jules Agent Guide
├── GEMINI.md                       # Gemini AI Context
└── README.md                       # Project Documentation
```

## 🔑 Key Files & Their Purpose

| File | Purpose | Priority |
|------|---------|----------|
| `BaseActivity.kt` | Parent activity with shared logic | HIGH |
| `HomeActivity.kt` | Main menu display | HIGH |
| `SignInActivity.kt` | User login | HIGH |
| `LocalDatabase.kt` | Room database setup | HIGH |
| `DishAdapter.kt` | RecyclerView adapter for menu | MEDIUM |
| `AndroidManifest.xml` | App configuration | HIGH |

## 📋 Development Tasks

### Phase 1: Core Structure (Foundation)
- ✅ Setup local.properties with SDK paths
- ⏳ Implement BaseActivity lifecycle logging
- ⏳ Create SplashActivity with proper timing
- ⏳ Setup database entities and DAOs
- **Task:** Review manifest for unnecessary declarations

### Phase 2: Authentication (User Flow)
- ⏳ Implement SignInActivity (Email/Password validation)
- ⏳ Implement SignUpActivity (Registration)
- ⏳ Add session management
- **Task:** Ensure proper data passing between activities

### Phase 3: UI/UX (Interface)
- ⏳ Design HomeActivity layout with RecyclerView
- ⏳ Create DishAdapter for menu items
- ⏳ Implement proper spacing and Material Design
- ⏳ Add click listeners for dish selection
- **Task:** Test on multiple screen sizes

### Phase 4: Database Integration (Persistence)
- ⏳ Integrate Room Database with activities
- ⏳ Implement CRUD operations
- ⏳ Add user preferences storage
- **Task:** Verify data persistence after app restart

## 🛠️ Code Conventions

### Naming Standards
```
// Variables: camelCase
var userEmail: String
var dishPrice: Double

// Classes: PascalCase
class UserViewModel
class DishRepository

// Constants: UPPER_SNAKE_CASE
const val DB_VERSION = 1
const val TIMEOUT_MS = 5000

// Functions: camelCase
fun validateEmail(email: String): Boolean
fun getDishById(id: Int): Dish?
```

### Kotlin Best Practices
- Use `val` by default, `var` only when necessary
- Use scope functions: `let`, `apply`, `run` for null safety
- Use sealed classes for result handling
- Avoid raw types, use generics
- Use coroutines for async operations

### Android Patterns
- **MVVM:** ViewModel + LiveData/StateFlow
- **Repository Pattern:** Abstract data sources
- **Dependency Injection:** (if using Hilt)
- **Lifecycle Awareness:** Use lifecycle observers

## 📱 UI Requirements Checklist
- [ ] Consistent color scheme (primary, secondary, background)
- [ ] Proper touch targets (48dp minimum)
- [ ] Accessible text sizes (14sp minimum)
- [ ] Clear visual hierarchy
- [ ] Error message displays
- [ ] Loading state indicators
- [ ] Proper margins and padding

## 🔍 Quality Assurance Checklist
- [ ] No hardcoded strings (use strings.xml)
- [ ] No memory leaks (check with LeakCanary)
- [ ] Proper permission handling
- [ ] Database migrations in place
- [ ] Error handling with try-catch
- [ ] User feedback for async operations

## 💾 Database Schema

### User Table
```
CREATE TABLE user (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  email TEXT UNIQUE NOT NULL,
  password TEXT NOT NULL,
  name TEXT,
  created_at INTEGER
);
```

### Dish Table
```
CREATE TABLE dish (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  name TEXT NOT NULL,
  description TEXT,
  price REAL NOT NULL,
  image_url TEXT,
  category TEXT
);
```

### Order Table
```
CREATE TABLE order (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  user_id INTEGER NOT NULL,
  total_price REAL NOT NULL,
  created_at INTEGER,
  FOREIGN KEY(user_id) REFERENCES user(id)
);
```

## 🚀 Execution Commands

### Build & Run
```
# Clean build
./gradlew clean build

# Run on emulator/device
./gradlew installDebug

# View logs
adb logcat
```

### Debugging
```
# Check current activity
adb shell dumpsys activity | grep "mCurrentFocus"

# Monitor database
# Use Android Studio Device File Explorer: /data/data/com.example.restaurantapp/
```

## 📞 Communication Protocol

When using **Gemini CLI** for this project:

1. **File Context** - Always reference files with full path:
   ```
   "Check app/src/main/java/com/example/restaurantapp/activity/HomeActivity.kt"
   ```

2. **Problem Statement** - Be specific:
   ```
   "HomeActivity crashes on startup with NullPointerException in DishAdapter"
   ```

3. **Expected vs Actual** - Always describe both:
   ```
   "Expected: Menu displays 5 dishes, Actual: Blank screen with no errors"
   ```

4. **Code Context** - Provide relevant snippets when asking for help

## 🎓 Learning Resources (for agent training)
- Android Lifecycle: https://developer.android.com/guide/components/activities/activity-lifecycle
- Room Database: https://developer.android.com/training/data-storage/room
- Kotlin Coroutines: https://kotlinlang.org/docs/coroutines-overview.html
- Material Design: https://material.io/design

## ⚡ Quick Fixes (Common Issues)

### App crashes on startup
- Check `AndroidManifest.xml` for correct launcher activity
- Verify database initialization in Application or first Activity
- Check logcat for NPE or missing resources

### RecyclerView not showing items
- Verify adapter is attached to RecyclerView
- Check if data is being passed to adapter
- Verify layout file exists and is referenced correctly

### Database crashes
- Ensure Room entities have @Entity annotation
- Check DAO methods have proper @Query annotations
- Verify database version and migration if needed

## 📝 Notes for AI Agents
- **Jules:** Focus on architectural decisions and code organization
- **Gemini:** Focus on implementation details and debugging
- Both should reference this document for context
- Update AGENTS.md and GEMINI.md after major changes

---

**Last Updated:** 2025-11-04  
**Project Branch:** lab3-4-1  
**Status:** 🟢 Build Successful
```