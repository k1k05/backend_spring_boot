# Podstawowe informacje

- RestAPI działa na wersji Java 23 i Spring Boot 3.4.0
- Aktualny projekt działa na bazie danych MariaDB. Jeżeli będzie odpalany na systemie Windows, gdzie korzysta się z MySQL należy zmienić ten fragment kodu w `pom.xml`:
    ```xml
    <dependency>
        <groupId>org.mariadb.jdbc</groupId>
        <artifactId>mariadb-java-client</artifactId>
        <scope>runtime</scope>
    </dependency>
    ```
    Na:
    ```xml
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>
    ```
    Oraz w `application.properties` zmienić `mariadb` na `mysql`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/calendar
    ```
- Frontend działa na wersji Angular CLI 19.0.4
  - Aby poprawnie odpalić aplikacje należy wywołać następujące polecenia w `bash/cmd`:
    - W folderze `/rekrutacyjne`:
      ```bash
      mvn spring-boot:run
      ```
    - W folderze `/frontend`:
      ```bash
      ng serve
      ```


