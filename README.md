# Rechner – Maven, JUnit und GitHub Actions

Dieses kleine Java-Projekt zeigt, wie Unit-Tests lokal mit Maven und automatisch
auf einem Build-Server ausgeführt werden. Der Rechner unterstützt Addition,
Subtraktion, Multiplikation und Division.

## Voraussetzungen

- Java 17
- Maven 3.8 oder neuer
- Git

## Tests lokal ausführen

Im Hauptverzeichnis des Projekts:

```bash
mvn test
```

Maven kompiliert dabei den Quellcode und führt alle JUnit-Tests in `src/test`
aus. Das Resultat muss `BUILD SUCCESS` sowie `Tests run: 6, Failures: 0,
Errors: 0` enthalten.

## Test-Coverage erstellen

Als Vertiefung ist JaCoCo eingerichtet:

```bash
mvn clean verify
```

Danach kann der Bericht `target/site/jacoco/index.html` im Browser geöffnet
werden. Der Bericht zeigt, welche Programmzeilen durch Tests ausgeführt wurden.

## GitHub Actions

Der Workflow `.github/workflows/maven.yml` wird bei jedem Push und bei jedem
Pull Request ausgeführt. Er verwendet Java 17 und startet:

```bash
mvn --batch-mode --no-transfer-progress clean verify
```

Der erzeugte JaCoCo-Bericht wird zusätzlich als GitHub-Artefakt gespeichert.
Auf GitHub ist das Resultat im Repository unter **Actions** sichtbar.

## Verhalten bei einem fehlschlagenden Test prüfen

Damit im Commit-Verlauf sowohl ein fehlgeschlagener als auch ein erfolgreicher
Build sichtbar ist:

1. In `CalculatorTest.java` vorübergehend die erwartete Summe von `7` auf `8`
   ändern.
2. Die Änderung committen und pushen:

   ```bash
   git add src/test/java/ch/hftm/rechner/CalculatorTest.java
   git commit -m "test: demonstrate failing calculator test"
   git push
   ```

3. Unter **GitHub > Actions** prüfen: Der Workflow ist rot, weil der erwartete
   Wert nicht dem tatsächlichen Resultat entspricht.
4. Den erwarteten Wert wieder auf `7` korrigieren, erneut committen und pushen:

   ```bash
   git add src/test/java/ch/hftm/rechner/CalculatorTest.java
   git commit -m "fix: restore passing calculator test"
   git push
   ```

5. Der nächste Workflow muss grün sein.

Der Fehler soll nur kurz demonstriert und nicht in der endgültigen Abgabe
belassen werden.

## Projektstruktur

```text
.
├── .github/workflows/maven.yml
├── src/main/java/ch/hftm/rechner/Calculator.java
├── src/test/java/ch/hftm/rechner/CalculatorTest.java
├── ABGABE.md
└── pom.xml
```
