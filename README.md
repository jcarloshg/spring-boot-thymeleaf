# Tu CV Spring Boot

A simple Spring Boot web application for managing and displaying a CV (Curriculum Vitae) with skills, using Thymeleaf for templating.

## Features

- View a welcome page with a personalized greeting
- List available skills with filtering
- View details for each skill
- Add new skills via a form
- REST API endpoint to fetch person data
- Custom property configuration via `message.properties`

## Technologies Used

- Java 21
- Spring Boot 3.5.8
- Thymeleaf
- Maven
- Lombok

## Project Structure

```
src/
  main/
    java/com/proof/tu_cv_spring_boot/
      TuCvSpringBootApplication.java         # Main Spring Boot application
      config/MessagePropertyConfig.java      # Loads custom properties
      cv/model/Person.java                   # Person model (CV owner)
      cv/model/Skill.java                    # Skill model
      cv/controller/CvController.java        # Handles CV pages
      cv/controller/SkillsController.java    # Handles skills pages
      cv/rest/CvApiController.java           # REST API for person data
    resources/
      application.properties                 # Spring Boot config
      message.properties                     # Custom properties (e.g., person.firstName)
      static/css/style.css                   # Basic CSS styling
      templates/
        index.html                           # Welcome page
        skills.html                          # Skills list page
        skill-details.html                   # Skill details page
        add-skills.html                      # Add skill form
        pepe.html                            # Example page
  test/
    java/com/proof/tu_cv_spring_boot/TuCvSpringBootApplicationTests.java
```

## How It Works

- The application starts at `/cv` and displays a welcome message using a property from `message.properties`.
- `/skills` lists all skills, with optional filtering and links to details.
- `/skills/new` shows a form to add a new skill.
- `/skills/{index}` and `/skills/{name}/{level}` show details for a specific skill.
- `/api/cv` returns a sample person object as JSON.

## Getting Started

1. **Clone the repository**
   ```sh
   git clone <repo-url>
   cd tu-cv-spring-boot
   ```
2. **Build and run the application**
   ```sh
   ./mvnw spring-boot:run
   ```
3. **Access the app**
   - Web UI: [http://localhost:8080/cv](http://localhost:8080/cv)
   - Skills: [http://localhost:8080/skills](http://localhost:8080/skills)
   - REST API: [http://localhost:8080/api/cv](http://localhost:8080/api/cv)

## Customization

- Change the greeting name in `src/main/resources/message.properties`:
  ```properties
  person.firstName=Neo
  ```
- Add or modify skills in `SkillsController.java` or via the web form.

## License

This project is for educational/demo purposes.
