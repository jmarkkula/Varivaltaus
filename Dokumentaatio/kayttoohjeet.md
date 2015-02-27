#Käyttöohjeet

###Pelin käynnistys:
Aja .jar tiedosto klikkaamalla sitä tai komentoriviltä Varivaltaus-hakemistossa komennolla "java -jar Varivaltaus.jar".

###Pelin säännöt:
Värivaltaus on kaksinpeli jossa tarkoituksena on vallata pelilaudalta ruutuja. 
Pelilauta koostuu suuresta määrästä eri värisiä, satunnaisesti generoituja ruutuja.  
Pelaajat aloittavat vastakkaisista kulmista (vasen ylä, oikea ala), vasemman ylänurkan pelaaja aloittaa.
Pelaajat valtaavat ruutuja valitsemalla vuorotellen uuden värin alueelleen, haluamansa väristä alareunan nappia painamalla. 
Värivaihtoehtoihin sisältyvät kaikki pelilaudan värit, paitsi pelaajan alueen senhetkinen väri, ja se joka vastustajan alueella sillä hetkellä on.
Ne oman alueen yhteydessä olevat ruudut, jotka ovat samanvärisiä kuin valittu väri, liitetään näin omaan alueeseen. Pelaaja, joka on ensimmäisenä vallannut vähintään 50% ruuduista, voittaa, jolloin peli loppuu.
