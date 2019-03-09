# Spring boot 2 introduction with Gradle and Java 11

| Build | Code quality check |
| ---   | --- |
| [![Build Status](https://travis-ci.com/PeterJakubik/springboot-intro.svg?branch=master)](https://travis-ci.com/PeterJakubik/springboot-intro) | [![Quality gate](https://sonarcloud.io/api/project_badges/quality_gate?project=PeterJakubik_springboot-intro)](https://sonarcloud.io/dashboard?id=PeterJakubik_springboot-intro) |



## Úvod do Spring boot 2 (s použitím Gradle a Java 11)
Jednoduchý úvod do Spring boot s použitím Gradlu a Java 11

Projekt je rozdelený na kroky, pričom každý krok je už výsledná aplikácia

## Čo je potrebné na spustenie
Inštalácia open jdk 11 z https://jdk.java.net/11 do adresára (_c:/Program Files/Java_  Na zapisovanie do adresára "Program Files" sú nutné admin práva)

Clone repository

V hlavnom adresáry v súbore _gradle.properties_ je nutné zadať cestu k jave
```
org.gradle.java.home=c:/Program Files/Java/jdk-11.0.2
```

Keďže v hlavnom adresári je gradle (a v settings.gradle je include subprojektov), tak každý podadresár dedí všetky gradle nastavenia. V každom kroku je len vlastný súbor _build.gradle_ ktorý špecifikuje, aké časti spring frameworku sa budu využívať.

Celý projekt sa dá skompilovať z príkazového riadku pomocou ```gradlew build``` (skompiluje celý projekt s spustí všetky testy)
Jednotlivé projekty sa dajú spustiť pomocou ```gradlew bootRun```. Spustiť program má zmysel len pre Step3 ktorý spustí lokálny Tomcat (embedded) server a čaká na REST Requesty. Step1 a Step2 sa po spustení hneď ukončia.

Pre projekt [Step 2 - JPA] je potrebné nainštalovať Databázu [mariadb](https://mariadb.org/). V Databáze treba zadať heslo 'root' pre užívateľa  'root' (meno a heslo do databázy sa v springboot zadávajú v resource súbore application.yml)

Pre projekt [Step 3 - REST] je potrebné nainštalovať aplikáciu [postman](https://www.getpostman.com/) na posielanie REST Requestov

## Popis projektu
Jedná sa o projekt, ktorý bude demonštrovať spring-boot na jednoduchej aplikácii.

Aplikácia by mala mať na starosti spravovanie koľají (naozaj železničných koľají :-) ).
Jednotlivé kroky na seba nadväzujú

* [Step 1 - Dependency injection](https://github.com/PeterJakubik/springboot-intro/tree/master/Step%201%20-%20Dependency%20injection) Dve Komponenty _TrackCalculator_ a _TrackRepository_ demonštrujú použitie anotácie ```@Component``` a ako sa dá izolovane otestovať jedna Komponente pomocou ```@MockBean```
* [Step 2 - JPA](https://github.com/PeterJakubik/springboot-intro/tree/master/Step%202%20-%20JPA) Komponenta _TrackRepository_ bude zapisovať do Databázy pomocou JPA
* [Step 3 - REST](https://github.com/PeterJakubik/springboot-intro/tree/master/Step%203%20-%20REST) Nová komponenta _TrackRepositoryController_ bude sprístupňovať REST Api a použiva _TrackRepository_. Na testovanie REST Api použijeme postman (treba do postmana naimportovať súbor z adresára _postman_ kde sú už pripravené REST Requesty )


Každá koľaj je jednoznačne identifikovateľná pomocou dvoch číselných (_integer_) parametrov.

_TrackId_

| Typ      | Meno Premennej | Význam |
|----------|----------------|--------|
| short    | nid_c          | Verzia projektovania. Pri každej zmene (napr. dĺžky koľaje sa musí zmeniť aj táto verzia) |
| integer  | nid_sp         | Číselná identifikácia koľaje |


## Poznámka
Gradle preberá frameworky z *maven repository* čo je centrálne web úložisko. Napr. spring-boot verzia 2.1.3 Release je https://mvnrepository.com/artifact/org.springframework.boot/spring-boot/2.1.3.RELEASE 
Samotný spring-boot referencuje ďaľších 53 Projektov (napr. logger, junit, springframework...)

