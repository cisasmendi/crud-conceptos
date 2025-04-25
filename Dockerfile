# Etapa 1: Construcción
FROM eclipse-temurin:24-jdk-alpine AS build

WORKDIR /app

# Copiamos todo el proyecto y compilamos con Maven
COPY . .
RUN ./mvnw clean package -DskipTests

# Etapa 2: Imagen final solo con el .jar
FROM eclipse-temurin:24-jdk-alpine

WORKDIR /app

# Copiamos el JAR desde la etapa de build
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

# Lanzamos la app
ENTRYPOINT ["java", "-jar", "app.jar"]
