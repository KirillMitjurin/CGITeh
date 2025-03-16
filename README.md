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
  
# Arenduse etapid
## Frontendi loomine
Alustasin lihtsa kasutajaliidesega, et kuvada andmeid. Kasutasin Vue.js-i ja Vite-i kiireks arendamiseks.
## Backendi arendus ja andmebaasi seadistamine
Esialgu tekkisid probleemid andmebaasi loomisega, kuna Entity klassid olid valesti seadistatud. Kasutasin PostgreSQL-i ja Spring Data JPA-d skeemi automaatseks genereerimiseks. Kui andmebaas töötas, lisasin lennud ja istekohtade konfiguratsiooni, luues täiendava tabeli.

## Filtrite rakendamine
Lennufiltrid realiseerisin frontendis, et näidata oma oskusi Vue.js-is. Kasutasin JavaScripti ja Vue.js-i komponente, et hallata filtrite loogikat.

## Soovitamise algoritmi loomine
Esialgu proovisin realiseerida seda SQL-päringu kaudu, kuid see osutus keeruliseks. Lõplik lahendus valmis Java kontrolleris, kasutades äriloogikat Java tasemel.

## Viimistlus ja UI kujundus
Vormistasin kõik elemendid kasutades CSS, HTML, JS

# Kokkuvõte
Selle ülesande lahendamiseks kulus mul kokku umbes 20 tundi. Kuna mul ei ole väga palju kogemusi veebiarenduses, siis mõned ülesanded olid minu jaoks uued ning pidin palju uurima ja õppima. See protsess andis mulle väärtuslikke kogemusi nii backendis (Spring Boot, PostgreSQL) kui ka frontendis (Vue.js).
