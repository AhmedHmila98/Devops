# Étape 1 : Utiliser une image de base OpenJDK légère
FROM openjdk:17-jdk-slim

# Étape 2 : Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Étape 3 : Copier le fichier .jar généré dans le conteneur
COPY target/SpringProjet-0.0.1-SNAPSHOT.jar app.jar

# Étape 4 : Exposer le port utilisé par Spring Boot
EXPOSE 8080

# Étape 5 : Démarrer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
