# Kuidas paigaldada projekti

## BackEnd

Kaustas `Backend` on vaja käivitada Spring Boot rakendus `DemoApplication`
Kuna kasutatakse PostgreSQL andmebaasi, võib olla vaja muuta parool ja kasutajanimi failis src/main/resources/application.properties. Näiteks:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/mydatabase
spring.datasource.username=myuser
spring.datasource.password=mypassword
```
Spring Boot rakendus loob andmebaasi skeemi automaatselt Spring Data JPA migratsioonide abil. Kui andmebaas on tühi, taaskäivita rakendus. Andmed säilivad pärast taaskäivitamist.

## Frontend
Ava konsool kaustas frontend ja paigalda npm sõltuvused:

`npm install`

Pärast paigaldamist käivita FrontEnd osa:

`npm run dev`

Rakendus on kättesaadav aadressil http://localhost:5173.

# Kasutatud tehnoloogiad
## Backend
    Spring Boot (Spring MVC, Spring Data JPA)
    PostgreSQL (andmebaasihaldus)
    Maven (ehitamiseks ja sõltuvuste haldamiseks)
## Frontend 
    Vue.js 
    Vue router
  
