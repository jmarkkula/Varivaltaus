#Ohjelman rakenteen kuvaus

Kaynnistys-luokka luo Pelinalustaja olion, joka luo Pelaajat, sek� Ruudukon, joka luomansa Satunnaistajan avulla luo satunnaisen v�riset ruudut.

T�m�n j�lkeen Kaynnistys luo Kayttoliittyma-olion (joko teksti tai graafinen), jolle antaa viitteen Pelinalustaja-olioon,
jotta k�ytt�liittym� p��see kysym��n Ruudukkoon ja Pelaajiin liittyv�� pelitilannetietoa pirt�mist��n varten.

Viimeiseksi Kaynnistys luo Pelinpyorittajan, jolle antaa viitteet Pelinalustajaan (jotta pelinpy�ritt�j�
p��see k�siksi pelilaudan ja pelaajien tietoihin) ja Kayttoliittymaan, jonka julkisia metodeja Pelinpyorittajan
kutsuu aina tarpeen mukaan (kysyy v�ri� k�ytt�liittym�lt�, pyyt�� t�t� p�ivitt�m��n n�kym�� sopivissa v�leiss�).

Kun oliot on luotu, Kaynnistys pyyt�� Kayttoliittymaa aloittamaan piirt�misen (jos graafinen), ja kun k�li on valmis,
Kaynnistys kutsuu Pelinpyorittajan aloitaPeli()-metodia, jolloin peli alkaa.