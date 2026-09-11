# Persönlicher Kommentar

Ich konnte das Rechner-Beispiel in meiner Umgebung nachspielen. Zuerst habe ich
geprüft, ob die JUnit-Tests lokal mit `mvn test` ausgeführt werden. Danach habe
ich einen GitHub-Actions-Workflow eingerichtet, der bei jedem Push automatisch
das Projekt kompiliert und die Tests ausführt. Ich habe auch absichtlich einen
falschen Erwartungswert in einem Test gepusht. Dadurch wurde der Build rot
markiert. Nach der Korrektur war der nächste Build wieder erfolgreich.

Ich habe verstanden, dass Maven den Build und die Tests lokal standardisiert,
während GitHub Actions dieselben Schritte automatisch auf einem unabhängigen
Build-Server wiederholt. Dadurch werden Fehler früh erkannt und nicht nur auf
dem eigenen Computer sichtbar. Mit JaCoCo kann ich zusätzlich erkennen, welche
Teile des Codes durch Tests abgedeckt sind.

In meinen nächsten Projekten werde ich Build- und Test-Automatisierung vor allem
bei Teamprojekten und bei Projekten mit regelmässigen Änderungen einsetzen. Sie
ist besonders sinnvoll, wenn mehrere Personen Code pushen oder wenn vor einem
Merge sichergestellt werden muss, dass bestehende Funktionen weiterhin korrekt
arbeiten. Auch bei meinem Diplomprojekt würde ich sie einsetzen, weil dort eine
zuverlässige und nachvollziehbare Entwicklung wichtig ist.
