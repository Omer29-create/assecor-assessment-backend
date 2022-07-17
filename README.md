# assecor-assessment-backend

Akzeptanzkriterien

Die CSV Datei wurde eingelesen, und wird programmintern durch eine dem Schema entsprechende Modellklasse repräsentiert.
Der Zugriff auf die Datensätze so abstrahiert, dass eine andere Datenquelle angebunden werden kann, ohne den Aufruf anpassen zu müssen.
Die oben beschriebene REST-Schnittstelle wurde implementiert und liefert die korrekten Antworten.
Der Zugriff auf die Datensätze, bzw. auf die zugreifende Klasse wird über Dependency Injection gehandhabt.
Die REST-Schnittstelle ist mit Unit-Tests getestet.
Die sample-input.csv wurde nicht verändert

Bonuspunkte

Implementierung als MSBuild Projekt für kontinuierliche Integration auf TFS (C#/.NET) oder als Maven/Gradle Projekt (Java)
Implementieren Sie eine zusätzliche Methode POST/ Personen, die eine zusätzliche Aufzeichnung zur Datenquelle hinzufügen
Anbindung einer zweiten Datenquelle (z.B. Datenbank via Entity Framework)
