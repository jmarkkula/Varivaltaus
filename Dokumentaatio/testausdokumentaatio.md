# Testausdokumentaatio

K�ytt�liittym�� ei testattu yksikk�testeill�, mutta loin sille Debuggaus-version, joka tavallisen GraafinenKayttoliittyma-olion
py�ritt�misen lis�ksi printtaa tiedotteita siit�, mit� k�lin metodeja milloinkin kutsutaan, sek� suoraan pelilogiikalta pyydett�vi� toString-pelitilannekuvauksia.

Pelinpyorittajan metodit ovat private-n�kyvyydell�, joten niiden yksil�llist� toimintaa oli hankala testata, mutta loin 
testausk�ytt�liittym�n, joka k�ytt�j�sy�tteiden sijaan arpoo pelilogiikalle palautettavaksi sek� sopivia ett� virheellisi� sy�tteit�, 
jolloin pelinpyorittajan testien onnistunut ajaminen kertoo, ett� se my�s k�sittelee sy�tteet oikein. Ennen t�m�n testausk�lin kirjoittamisen �ly�mist�
pelasin my�s peli� tekstik�ytt�liittym�n kautta monen monta kertaa ja yritin rikkoa sit�, mutta lopullinen koodi n�ytti n�inkin toimivan pelin
s��nt�jen mukaisesti.