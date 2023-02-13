### Installation

1. Version Java utilisée: 19

2. faire un clone du repertoire du projet:

```sh
   git clone https://github.com/RichardMargin/Exo-microservices/
```

3. Application de base monolithique découpée en microservices.
   Il y a d'abord l'appli service-config à lancer, il sera sur le port 8088 et ira chercher les configs centralisées de chaque service dans ce dépot git :
   https://github.com/walid-reh/myConfig

Ensuite nous avons l'appli service-eureka, qui est notre service discovery et permettra de voir les instances des différents services, celle-ci utilisera le port 8761
Nous avons également un service-proxy, sur le port 9999, qui permet de pouvoir rediriger chaque microservice sur le même port, afin de faciliter les requêtes de CRUD.
Et nous avons 3 micro services, un nommé medecin, sur le port 9091, un nommé patient sur le port 9092, un nommé rdv sur le port 9093.

Il faut patienter quelques secondes après avoir lancé les 6 applis, que tout se mette en place, avant de pouvoir tester les urls via le proxy.

4. Pour ce projet, nous utilisons 3 bases de données PostgreSQL sur le port 5432, une pour nos 3 microservices, il y a patient_db qui gère les patients, medecin_db qui gère les médecins, et rdv_db qui gère les rdvs et les consultations.

5. Lorsqu'un rendez-vous est créé, une consultation associée est automatiquement créée, et peut être remplie indépendamment par la suite.

6. Lorsqu'un rendez-vous est supprimé, la consultation associée est également supprimée pour garder une cohérence de donnée, et inversement.

7. Dans le dossier conception, il y a les différents diagrammes de classes, de cas d'utilisation, et les mld adaptés à notre nouvelle architecture en microservices.

8. Les services sont testables sur PostMan (localhost:9999)

En plus des crud classiques pour médecin et patient, utilisant le RestRessource, nous avons mis en place pour le microservice rdv notre propre mapping customisé, pour permettre d'avoir lorsque l'on affiche un rdv, le médecin et le patient associé, ainsi que la consultation, idem pour la liste des rdv. Il y a également une méthode pour afficher tous les rdvs d'un patient, et tous ceux d'un médecin. Ceci a été mis en place en faisant communiquer nos microservices par deux Api, une pour médecin et une pour client.

10. Nous avons inclus dans le dossier "collection_postman" une collection postman incluant l'enssemble des requêtes http sur les endpoints de notre application.

11. Membres du groupe:

- Sarah ROUINI. TEST
- Walid REHIOUI.
- Mohamed DESOKI.
- Richard MANGIN.
