# springboot-intro
Spring boot 2 introduction with Gradle and Java 11

## Úvod do Spring boot 2 (s použitím Gradle a Java 11)
Jednoduchý úvod do Spring boot s použitím Gradlu (builder) a Java 11

Projekt je rozdelený na kroky, pričom každý krok je už výsledná aplikácia

## Čo je potrebné na spustenie
Inštalácia open jdk 11 z https://jdk.java.net/11 do adresára (_c:/Program Files/Java_  Na zapisovanie do adresára "Program Files" sú nutné admin práva)

Clone repository

V hlavnom adresáry v súbore _gradle.properties_ je nutné zadať cestu k jave
```
org.gradle.java.home=c:/Program Files/Java/jdk-11.0.2
```

Keďže v hlavnom adresári je gradle, tak každý podadresár dedí všetky gradle nastavenia. V každom kroku je len vlastný súbor _build.gradle_ ktorý špecifikuje, aké časti spring frameworku sa budu využívať.

Každý krok sa dá skompilovať z príkazového riadku pomocou ```gradlew build```

## Popis projektu
Jedná sa o projekt, ktorý bude demonštrovať spring-boot na jednoduchej aplikácii.

Aplikácia sa volá TrackManagement a mala by mať na starosti spravovanie koľají (naozaj železničných koľají :-) )

Každá koľaj je jednoznačne identifikovateľná pomocou dvoch číselných (_integer_) parametrov.

Koľaj

| Typ      | Meno Premennej | Význam |
|----------|----------------|--------|
| short    | NID_C          | Verzia projektovania. Pri každej zmene (napr. dĺžky koľaje sa musí zmeniť aj táto verzia) |
| integer  | NID_SP         | Číselná identifikácia koľaje |


## Poznámka
Gradle preberá frameworky z *maven repository* čo je centrálne web úložisko. Napr. spring-boot verzia 2.1.3 Release je https://mvnrepository.com/artifact/org.springframework.boot/spring-boot/2.1.3.RELEASE 
Samotný spring-boot referencuje ďaľších 53 Projektov (napr. logger, junit, springframework...)

