# Dokumentacja API projektu

## Spis treści

1. [Kategorie (Category)](#kategorie-category)
    - [Endpointy](#endpointy-kategorii)
2. [Wydarzenia (Happening)](#wydarzenia-happening)
    - [Endpointy](#endpointy-wydarzen)
3. [Kody błędów](#kody-bledow)

---

## Kategorie (Category)

Model kategorii składa się z następujących pól:
- `id`: unikalny identyfikator kategorii (Integer).
- `name`: nazwa kategorii (String, nie może być pusta).

### Endpointy kategorii

#### 1. Pobierz wszystkie kategorie
- **Endpoint**: `GET /api/categories`
- **Opis**: Zwraca listę wszystkich kategorii.

##### Przykładowe zapytanie:
```http
GET /api/categories HTTP/1.1
Host: localhost:8080
```

##### Przykładowa odpowiedź:
```json
[
  {
    "id": 1,
    "name": "Sport"
  },
  {
    "id": 2,
    "name": "Kultura"
  }
]
```

---

#### 2. Pobierz szczegóły kategorii
- **Endpoint**: `GET /api/categories/{id}`
- **Opis**: Zwraca szczegóły kategorii na podstawie jej identyfikatora.

##### Przykładowe zapytanie:
```http
GET /api/categories/1 HTTP/1.1
Host: localhost:8080
```

##### Przykładowa odpowiedź:
```json
{
  "id": 1,
  "name": "Sport"
}
```

---

#### 3. Utwórz nową kategorię
- **Endpoint**: `POST /api/categories`
- **Opis**: Tworzy nową kategorię.

##### Przykładowe zapytanie:
```http
POST /api/categories HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
  "name": "Edukacja"
}
```

##### Przykładowa odpowiedź:
```json
{
  "id": 3,
  "name": "Edukacja"
}
```

---

#### 4. Zaktualizuj istniejącą kategorię
- **Endpoint**: `PUT /api/categories/{id}`
- **Opis**: Aktualizuje dane kategorii.

##### Przykładowe zapytanie:
```http
PUT /api/categories/1 HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
  "name": "Zmodyfikowana Kategoria"
}
```

##### Przykładowa odpowiedź:
```json
{
  "id": 1,
  "name": "Zmodyfikowana Kategoria"
}
```

---

#### 5. Usuń kategorię
- **Endpoint**: `DELETE /api/categories/{id}`
- **Opis**: Usuwa kategorię o podanym `id`.

##### Przykładowe zapytanie:
```http
DELETE /api/categories/1 HTTP/1.1
Host: localhost:8080
```

##### Przykładowa odpowiedź:
HTTP status: `200 OK`

## Wydarzenia (Happening)

Model wydarzenia składa się z pól:
- `id`: unikalny identyfikator wydarzenia (Integer).
- `name`: nazwa wydarzenia (String, nie może być pusta).
- `startingTime`: początek wydarzenia (LocalDateTime).
- `endingTime`: zakończenie wydarzenia (LocalDateTime).
- `category`: kategoria, do której wydarzenie należy (id kategorii).

### Endpointy wydarzeń

#### 1. Pobierz wszystkie wydarzenia
- **Endpoint**: `GET /api/happenings`
- **Opis**: Zwraca listę wszystkich wydarzeń.

##### Przykładowe zapytanie:
```http
GET /api/happenings HTTP/1.1
Host: localhost:8080
```

##### Przykładowa odpowiedź:
```json
[
   {
      "id": 40,
      "name": "Mecz",
      "startingTime": "2024-12-16T14:30:00",
      "endingTime": "2024-12-16T18:00:00",
      "category": {
         "id": 25,
         "name": "Sport"
      },
      "validTimes": true
   }
]
```

---

#### 2. Pobierz szczegóły wydarzenia
- **Endpoint**: `GET /api/happenings/{id}`
- **Opis**: Zwraca szczegóły wydarzenia na podstawie jego ID.

##### Przykładowe zapytanie:
```http
GET /api/happenings/1 HTTP/1.1
Host: localhost:8080
```

##### Przykładowa odpowiedź:
```json
{
  "id": 1,
  "name": "Koncert",
  "startingTime": "2023-12-15T18:00:00",
  "endingTime": "2023-12-15T22:00:00",
  "category": {
    "id": 2,
    "name": "Kultura"
  }
}
```

---

#### 3. Utwórz nowe wydarzenie
- **Endpoint**: `POST /api/happenings`
- **Opis**: Tworzy nowe wydarzenie.

##### Przykładowe zapytanie:
```http
POST /api/happenings HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
  "name": "Warsztaty",
  "startingTime": "2023-12-20T12:00:00",
  "endingTime": "2023-12-20T15:00:00",
  "category": {
    "id": 1
  }
}
```

##### Przykładowa odpowiedź:
```json
{
   "id": 2,
   "name": "Warsztaty",
   "startingTime": "2024-12-20T12:00:00",
   "endingTime": "2024-12-20T15:20:00",
   "category": {
      "id": 2,
      "name": "Edukacja"
   },
   "validTimes": true
}
```

---

#### 4. Zaktualizuj istniejące wydarzenie
- **Endpoint**: `PUT /api/happenings/{id}`
- **Opis**: Aktualizuje dane wydarzenia.

##### Przykładowe zapytanie:
```http
PUT /api/happenings/2 HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
  "name": "Warsztaty",
  "startingTime": "2023-12-20T12:00:00",
  "endingTime": "2023-12-20T15:00:00",
  "category": {
    "id": 2
  }
}
```

##### Przykładowa odpowiedź:
```json
{
   "id": 2,
   "name": "Warsztaty",
   "startingTime": "2023-12-20T12:00:00",
   "endingTime": "2023-12-20T15:00:00",
   "category": {
      "id": 2,
      "name": "Sport"
   },
   "validTimes": true
}
```

---

#### 5. Usuń wydarzenie
- **Endpoint**: `DELETE /api/happenings/{id}`
- **Opis**: Usuwa wydarzenie o podanym `id`.

##### Przykładowe zapytanie:
```http
DELETE /api/happenings/1 HTTP/1.1
Host: localhost:8080
```

##### Przykładowa odpowiedź:
HTTP status: `200 OK`

---

## Kody błędów

### 400 - Bad Request
- Nieprawidłowe dane wejściowe (np. puste pole, niewłaściwy format daty).

Przykład:
```json
{
  "name": "Nazwa nie może być pusta.",
  "endingTime": "Data końcowa nie może być przed datą początkową.", 
   "startingTime": "Data początkowa nie może być w przeszłości."
}
```

### 404 - Not Found
- Zasób o podanym ID nie istnieje.

Przykład:
```json
{
   "message": "Category not found",
   "details": "uri=/api/categories/1",
   "timestamp": "2024-12-14T15:57:17.60318677"
}
```

### 500 - Internal Server Error
- Wewnętrzny błąd serwera.

---
```json
{
   "message": "Internal server error",
   "details": "uri=/api/categories/1",
   "timestamp": "2024-12-14T15:57:17.60318677"
}
```

