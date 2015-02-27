# Testausdokumentaatio

Käyttöliittymää ei testattu yksikkötesteillä, mutta loin sille Debuggaus-version, joka tavallisen GraafinenKayttoliittyma-olion
pyörittämisen lisäksi printtaa tiedotteita siitä, mitä kälin metodeja milloinkin kutsutaan, sekä suoraan pelilogiikalta pyydettäviä toString-pelitilannekuvauksia.

Pelinpyorittajan metodit ovat private-näkyvyydellä, joten niiden yksilöllistä toimintaa oli hankala testata, mutta loin 
testauskäyttöliittymän, joka käyttäjäsyötteiden sijaan arpoo pelilogiikalle palautettavaksi sekä sopivia että virheellisiä syötteitä, 
jolloin pelinpyorittajan testien onnistunut ajaminen kertoo, että se myös käsittelee syötteet oikein. Ennen tämän testauskälin kirjoittamisen älyämistä
pelasin myös peliä tekstikäyttöliittymän kautta monen monta kertaa ja yritin rikkoa sitä, mutta lopullinen koodi näytti näinkin toimivan pelin
sääntöjen mukaisesti.