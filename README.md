<h1 align="center">APP FOLIADAS</h1>

<p align="center">
<img src="https://img.shields.io/badge/STATUS-EN%20DESENVOLVEMENTO-green">
</p>

---

## Índice
1. [Descripción](#Descripción-do-proxecto)
2. [Funcionalidades principais](#Funcionalidades-principais)
3. [Estado actual do proxecto](#Estado-actual-do-proxecto)
4. [Aplicacions necesarias](#Aplicacións-necesarias)
5. [Instalacion](#Instalación)

---

## Descripción do proxecto

App foliadas é unha aplicación cliente-servidor para a xestión de información sobre foliadas, grupos e usuarios.

O sistema está composto por:
- Backend (API REST con Spring Boot)
- Frontend (Aplicación Android)

Permite a xestión de datos e información entre ambas partes para mostrar información na aplicación móbil

---

## Funcionalidades principais

### Backend
- CRUD de foliadas e grupos
- Xestión de usuarios
- Sistema de favoritos por usuario
- Filtrado de foliadas por provincia e por nome
- API REST para comunicación co cliente

### Frontend
- Visualización de foliadas e imaxes dende o servidor
- Consulta de datos dende a API
- Interfaz para o usuario
- Xestión de favoritos (en desenvolvemento)

---

## Estado actual do proxecto

O proxecto atopase nunha versión funcional completa lista para uso, con posibles melloras futuras:

- Backend completamente operativo
- Aplicacion Android funcional e conectada ao backend
- Comunicación cliente servidor implementada
- Base de datos relacional con múltiples entidades e relacións
- Búsqueda e visualización de datos funcionando correctamente
- Carga de imaxes dende servidor backend implementada

---

## Aplicacións necesarias

- Java 17+
- IntelliJ IDEA (para backend)
- Android Studio (para frontend)
- PostgreSQL
- pgAdmin (para a xestion da bd)
- Git

---

## Instalación 

### Clonación do proxecto: 

Para poder probar o proxecto necesitamos clonar o repositorio no que se atopa tanto backend como frontend.
Na terminal introducimos o seguinte comando:
git clone https://github.com/noeliamiguelez/App-Foliadas.git

---

## Configuración da base de datos:

O backend utiliza PostgreSQL como sistema de base de datos.
Dentro do proxecto existe unha carpeta:
- backend/foliadas-api/db/init.sql
Esta carpeta contén o arquivo 'init.sql' coa estructura da base de datos.

### Pasos para configurar a base de datos:

1. Crear unha base de datos en PostgreSQL chamada foliadeiros
2. Executar o script 'init.sql'.
3. Configurar o arquivo: src/main/resources/application.properties. Modifica os seguintes campos cos teus credenciales:
   - spring.datasource.url=jdbc:postgresql://localhost:5432/foliadeiros
   - spring.datasource.username=TU_USUARIO
   - spring.datasource.password=TU_PASSWORD

## Execución do proxecto

Unha vez clonado o respositorio e configurada a base de datos, é necesario executar backend e frontend por separado

### Backend(Spring Boot - IntelliJ IDEA)

1. Abrir IntelliJ
2. No menú seleccionar File>Open...
3. Escoller a carpeta 'foliadas-api' dentro de backend
4. Esperar que carguen as dependencias
5. Executar a aplicación

O servidor vaise iniciar en: http://localhost:8081

### Frontend(Android- Android Studio)

1. Abrir Android Studio
2. No menú seleccionar: File>Open...
3. Escoller a carpeta 'foliadeiros' dentro de frontend
4. Esperar á sincronización de Gradle
5. Executar a aplicación no emulador

#### ⚠️ Importante

É necesario executar primeiro o backend antes de iniciar frontend.
