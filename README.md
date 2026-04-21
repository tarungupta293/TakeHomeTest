# Take Home Test - 

I focused on building a simple dashboard that combines two product experiences into one screen, while keeping the code clean and easy to scale.

Dashboard Screen with two main sections:
- Fuel Transactions
- Charge Sessions

## Each section:
Shows a couple of recent items
Displays them as individual cards (one card per row)
Is designed to be expandable later (e.g. “See all”, detail screens)

Since this was time-boxed (~2 hours), I focused on:

Clean structure over feature completeness
Readable and maintainable code
Showing how I’d build this in a real project

## Structure
I followed a simple clean architecture style:
data → domain → presentation
Data layer → provides mocked data
Domain layer → use case + Repository Interface
Presentation → ViewModel + Compose UI
🔄 Data flow
RepositoryManager → Usecase → ViewModel → UI
RepositoryManager returns mock data (no networking)
ViewModel converts it into UI state
UI observes state using Compose
📦 State handling

### Used a sealed class:
Loading
Success
Error

This made it easy to:
- Handle UI states clearly
- Test different scenarios
- UI decisions
- Each section is just a simple column (not a card)
- Each row inside is a card
- Keeps hierarchy clean and matches the requirement

Used vector icons for:
- Transactions
- Charging

I added unit tests for:
- ViewModel - Success case/Error case
- Repository (Manager) - Basic data validation

### Things covered:
- Coroutine testing (runTest)
- Mocking using Mockito
- Handling Dispatchers.Main in tests

### Time spent
~3 hours

### How to run
- Clone the repo
- Open in Android Studio
- Run on any recent Android device/emulator
