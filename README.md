# Task Management Console Application

A simple console application for task management built with Java following SOLID principles.

## Features
- Create new tasks with title and description
- View all tasks with their status
- Mark tasks as completed
- Simple and intuitive console interface

## Prerequisites
- Java 17 or higher
- Maven

## How to Run

1. Clone the repository:
```bash
git clone <your-repository-url>
cd SOLID
```

2. Build the project:
```bash
mvn clean package
```

3. Run the application:
```bash
java -jar target/solid-console-app-1.0-SNAPSHOT.jar
```

## Project Structure
- `model` - Contains the Task entity
- `repository` - Data access layer
- `service` - Business logic layer
- `Main.java` - Application entry point 