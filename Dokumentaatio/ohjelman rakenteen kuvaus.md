#Ohjelman rakenteen kuvaus

Kaynnistys-luokka luo Pelinalustaja olion, joka luo Pelaajat, sekä Ruudukon, joka luomansa Satunnaistajan avulla luo satunnaisen väriset ruudut.

Tämän jälkeen Kaynnistys luo Kayttoliittyma-olion (joko teksti tai graafinen), jolle antaa viitteen Pelinalustaja-olioon,
jotta käyttöliittymä pääsee kysymään Ruudukkoon ja Pelaajiin liittyvää pelitilannetietoa pirtämistään varten.

Viimeiseksi Kaynnistys luo Pelinpyorittajan, jolle antaa viitteet Pelinalustajaan (jotta pelinpyörittäjä
pääsee käsiksi pelilaudan ja pelaajien tietoihin) ja Kayttoliittymaan, jonka julkisia metodeja Pelinpyorittajan
kutsuu aina tarpeen mukaan (kysyy väriä käyttöliittymältä, pyytää tätä päivittämään näkymää sopivissa väleissä).

Kun oliot on luotu, Kaynnistys pyytää Kayttoliittymaa aloittamaan piirtämisen (jos graafinen), ja kun käli on valmis,
Kaynnistys kutsuu Pelinpyorittajan aloitaPeli()-metodia, jolloin peli alkaa. Pelinpyorittaja kutsuu käyttöliittymän kysyVari-, paivitaPelilauta- ja julistaVoittaja-metodeja tarpeensa (siis pelitilanteen etenemisen) mukaan.
