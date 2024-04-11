Lösungsidee
---

Die am Ende eines Reimes ausscheidende Person ist Person ((k - 1) % n) + lastElimIndex
Hierbei ist zu beachten, dass sobald der Index n überschreitet, er wieder bei 0 beginnt, wie in den Restklassen Zn

Somit ist die Lösung eine Rekursive Methode, die für jede verkleinerte Personenreihe die Ausscheider zurückgibt

Beispiel: Lösung für 13 Personen und 7 Silben im Abzählreim
---
Die Indicees Zählen hier von 0 - 12

Somit ist die Liste:
0,1,2,...,11,12

Elims nach Reihenfolge:
6 < 0 < 8 < 3 < 12 < 10 < 9 < 11 < 2 < 7 < 1 < 4 < 5 

Somit müssen Josephus und seine Freunde an den Stellen
11, 2, 7, 1, 4 und 5
stehen, um als letzte eliminiert zu werden.

