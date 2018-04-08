TP_JPA
Le TP consiste en la réalisation d'un projet maven qui doit-être importé soit par intelliJ IDEA soit par eclipse.
Pour l'exécution, il faut lancer 'run-hsqldb-server' .bat sur windows / .sh sur linux pour lancer la base de données.
Notre base de donnée est sur le serveur de l'istic comme nous l'avons précisé dans le fichier "persistance.xml" avec le login et le mot de passe.
Pour démarrer le servlet, il faut démarrer la commande tomcat7: Run puisqu'il s'agit d'un projet maven.

Les API à considérer sont surtout pour la création, la récupération et la suppression des éléments pour le concept de Personne. Ainsi, nous avons:
GET 	/person 	display all the people,
GET 	/person/{id}/homes 	display all the houses owned by the person with the given {id} parameter,
POST 	/person 	create a new person,
GET 	/home 	display all the homes,
POST 	/home 	create a new home,

Quelques exemples de requêtes:

/person:
Prenom: String
Nom: String

/residence:
Id: Integer
Taille: Integer
Nb_piece: Integer
