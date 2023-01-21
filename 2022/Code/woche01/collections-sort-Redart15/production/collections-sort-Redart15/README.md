Sort
---

Schreiben Sie ein Java-Programm `Sort`, das beliebig viele Textzeilen von der Standardeingabe einliest und anschließend die Zeilen alphabetisch sortiert ausgibt:
```
2022/4/18 - Nochmal clone geübt!

% cat text
Motivation
Standard Library
Schleifen
Git 1
Remote Mob
% java Sort < text
Git 1
Motivation
Remote Mob
Schleifen
Standard Library
```
(Wir implementieren hier also eine einfachere Variante des Konsolenbefehls [`sort`](https://manpages.debian.org/bullseye/coreutils/sort.1.en.html)).
Benutzen Sie dafür am besten `Scanner.nextLine`, eine `List` und `Collections.sort`.
Schauen Sie ggf. in der Dokumentation der Klassen nach, um herauszufinden, wie sie benutzt werden.

Um die automatischen Tests auszuführen, wechseln Sie in Ihrem Terminal in das Verzeichnis `test` und führen Sie den Befehl `./gradlew test` (bzw. unter Windows `gradlew.bat test`) aus.
(Was gradle ist, werden wir in den nächsten Wochen lernen.)
Wenn alle Tests erfolgreich durchgelaufen sind, sollten Sie `BUILD SUCCESSFUL` und dreimal `PASSED` sehen.
Beachten Sie, dass die Datei `Sort.java` im selben Ordner wie diese `README.md` sein muss.
