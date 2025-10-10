# Étape 1 : Build
FROM gradle:8.10-jdk21 AS builder
WORKDIR /app

# Copie tous les fichiers du projet
COPY . .

# Build du jar (ignore les tests si tu veux)
RUN gradle clean build -x test --no-daemon

# Étape 2 : Image finale pour exécuter l'application
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copie du jar généré depuis le stage "builder"
COPY --from=builder /app/build/libs/*.jar app.jar

# Lancement de l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
