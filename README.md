# springboot-intro
Spring boot 2 introduction with Gradle and Java 11

## Úvod do Spring boot 2 (s použitím Gradle a Java 11)
Jednoduchý úvod do Spring boot s použitím Gradlu (builder) a Java 11

Projekt je rozdelený na kroky, pričom každý krok je už výsledná aplikácia

## Čo je potrebné na spustenie
Inštalácia open jdk 11 z https://jdk.java.net/11 do adresára (c:/Program Files/Java  Na zapisovanie do adresára "Program Files" sú nutné admin práva)

Clone repository

Každý adresár obsahuje súbor _gradle.properties_ kde je nutné zadať cestu k jave
```
org.gradle.java.home=c:/Program Files/Java/jdk-11.0.2
```

Každý krok sa dá skompilovať z príkazového riadku pomocou ```gradlew build```

## Popis projektu
Jedná sa o projekt, ktorý bude demonštrovať spring-boot na jednoduchej aplikácii.

Aplikácia sa volá TrackManagement a mala by mať na starosti spravovanie koľají (naozaj železničných koľají :-) )

Každá koľaj je jodnoznačne identifikovateľná pomocou dvoch číselných (_integer_) parametrov.

Popis Koľaj

| Typ      | Meno Premennej | Význam |
|----------|----------------|--------|
| short    | NID_C          | Verzia projektovania. Pri každej zmene (napr. dĺžky koľaje sa musí zmeniť aj táto verzia) |
| intreger | NID_SP         | Číselná identifikácia koľaje |