# UpdatedCleanArchitecture
New clean architecture using 
kotlin's flow, state flow, coroutines, Sealed classes, hilt dependency injection.

**3 main layer's will be-** 
- **Data-** The Data layer is the place where the app needs to deal with APIs and 3rd party libraries. It contains Repositories — the single source of truth for the data, Models, and Data Sources (which can be local or remote).
it may include - retrofit related API services class, local DB query related classes, repository implementation classes etc.
- **Domain-** It interacts with the Data and Feature (presentation) layers using interfaces and interactors. It is also completely independent and can be tested regardless of external components. Each Domain layer has a unique use case, repository, and business model.
- **Feature/Presentation-**  this layer is responsible for presenting UI to the user. It's used to perform necessary UI logic based on the data received through the domain layer and user interactions.

**Key points in this structure will be-** 
- Separation of Concerns — Separation of code in different modules or sections with specific responsibilities making it easier for maintenance and further modification.
- Loose coupling — flexible code anything can be easily be changed without changing the system
- Easily Testable
