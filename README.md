# UCE Génie Logiciel Avancé : Techniques de tests

Sujet de TP : 

- [TP0 - Fork them all !](https://github.com/Faylixe/ceri-m1-test/raw/resources/TP0 - fork them all.pdf)
- [TP1 - (Des)intégration continue](https://github.com/Faylixe/ceri-m1-test/raw/resources/TP1 - (Des)intégration continue.pdf)
- [TP2 - Pokeunit](https://github.com/Faylixe/ceri-m1-test/raw/resources/TP2 - Pokeunit.pdf)

- Nom : DESVILLETTES Aurelien.
- Groupe : Alternant.

[![CircleCI](https://circleci.com/gh/AurelienDE/ceri-m1-test.svg?style=svg)](https://circleci.com/gh/AurelienDE/ceri-m1-test)

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/d661323e496140c68f8a7a279ba2efc6)](https://www.codacy.com/app/AurelienDE/ceri-m1-test?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=AurelienDE/ceri-m1-test&amp;utm_campaign=Badge_Grade)

[![Codacy Badge](https://api.codacy.com/project/badge/Coverage/d661323e496140c68f8a7a279ba2efc6)](https://www.codacy.com/app/AurelienDE/ceri-m1-test?utm_source=github.com&utm_medium=referral&utm_content=AurelienDE/ceri-m1-test&utm_campaign=Badge_Coverage)


IPokemonTrainerFactory :
pour chaque trainer serialise sur le disk (json, …)
regarder si le fichier existe si
non le cree
oui le deserialiser

IpokemonmetadataProvider:
Pour une espece donne, donner les caracteristiques de l’espece
donne moi des pokemonmetadata pour un index donne, get from web

IpokemonFactory :
-> chercher un calculateur pour calculer les stats des pokemon
-> return un Pokemon avec les bonnes stats

IPokedex :
-> collection de pokemon
-> a chaque modification sauvegarder sur le disk les trainers

Utiliser un max de librairy
