# Project Documentation

## Overview
This project demonstrates the implementation of a modern Android application using the following technologies and principles:
- **Retrofit**: For network communication.
- **Hilt**: For dependency injection.
- **Clean Architecture**: To ensure a clear separation of concerns and scalable code structure.
- **SOLID Principles**: Applied to ensure maintainable and scalable code design.

## Project Structure
The project follows a modular structure based on Clean Architecture principles, organized into the following layers:

### Core Module
#### `data/networking`
- **`Constants`**: Defines reusable constants for networking.
- **`Resource`**: A generic wrapper class for handling UI states (success, error, loading).
- **`SafeCall`**: A utility class to handle exceptions during network calls.
- **`ServerError`**: A model to parse server error responses.

#### `presentation`
- **`components`**
    - **`BottomNavBar.kt`**: UI component for the bottom navigation bar.
    - **`ErrorScreen.kt`**: UI component to display error states.
    - **`LoadingScreen.kt`**: UI component for loading states.

- **`navigation`**
    - **`BottomNavItem.kt`**: Defines items for bottom navigation.
    - **`NavGraph.kt`**: Navigation graph for managing app routes.
    - **`Screens.kt`**: Enum class for screen identifiers.

#### `util`
- **`FormatTimestamp.kt`**: Utility class to format timestamps.

#### `di`
- **`ApiModule.kt`**: Provides Retrofit and networking dependencies.
- **`RepoModule.kt`**: Provides repository dependencies.

### Features Module
#### `transactions`
##### `data`
- **`mappers`**
    - **`TransactionsMapper.kt`**: Maps DTOs to domain models.
- **`TransactionDto.kt`**: Data Transfer Object for transactions.
- **`TransactionsRepositoryImpl.kt`**: Repository implementation for handling data operations.
- **`TransactionsResponse.kt`**: Model for the API response.
- **`WebServices.kt`**: Interface defining Retrofit API endpoints.

##### `domain`
- **`Transaction.kt`**: Domain model for a single transaction.
- **`Transactions.kt`**: Domain model for a list of transactions.
- **`TransactionsRepository.kt`**: Interface defining repository methods.

##### `presentation`
- **`components`**
    - **`IconText.kt`**: A reusable component for displaying an icon with text.
    - **`TransactionCard.kt`**: UI component for a single transaction card.
    - **`TransactionSearchBar.kt`**: UI component for searching transactions.
    - **`TransactionsList.kt`**: UI component displaying a list of transactions.
    - **`TransactionsTopBar.kt`**: Top bar for the transactions screen.
- **`model`**
    - **`TransactionsEvents.kt`**: Defines events for user interactions.
    - **`TransactionsScreen.kt`**: State holder for the transactions screen.
    - **`TransactionsState.kt`**: UI state for transactions.
    - **`TransactionsViewModel.kt`**: ViewModel managing the transactions screen logic.

### UI Module
- **`MainActivity.kt`**: The main activity hosting the navigation graph.

## Key Features
1. **Clean Architecture**: The app follows a clear separation of concerns, dividing the code into `data`, `domain`, and `presentation` layers.
2. **Dependency Injection**: Hilt is used for managing dependencies, ensuring testability and modularity.
3. **Retrofit**: Handles API communication with proper error handling and DTO mapping.
4. **SOLID Principles**: The code design adheres to the following principles:
    - **Single Responsibility Principle (SRP)**: Each class has a single, well-defined responsibility.
        - Example: `TransactionsRepositoryImpl` handles data operations, while `TransactionsViewModel` manages UI state.
    - **Open/Closed Principle (OCP)**: Classes are open for extension but closed for modification.
        - Example: `TransactionsMapper` can be extended to include more mappings without modifying existing code.
    - **Interface Segregation Principle (ISP)**: Interfaces are designed to be specific to the needs of the client.
        - Example: `TransactionsRepository` only includes methods relevant to transaction data handling.
    - **Dependency Inversion Principle (DIP)**: High-level modules depend on abstractions rather than concrete implementations.
        - Example: `TransactionsViewModel` depends on `TransactionsRepository` rather than `TransactionsRepositoryImpl`.


