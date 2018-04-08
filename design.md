Le projet est basé sur un modèle de plusieurs couches:
La première couche est le support de repos mis en œuvre avec Jersey. Elle a le rôle d'une façade et délègue la logique à la couche d'affaires ou de service
La couche de service est l'endroit où la logique se produit.
La couche d'accès aux données est l'endroit où se déroulent les communications avec le stockage de persistance.

Quelques technologies utilisées dans le projet:
1. JERSEY

Jersey est un framework open-source écrit en langage Java permettant de développer des services web selon l'architecture REST suivant les spécifications de JAX-RS


2. SERVICE Layer (Domain)

Le domaine de package contient le POJOS.
Le modèle de couche de service est comme le modèle de domaine, mais avec une mince couche en face de lui contenant les opérations commerciales qui peuvent être effectuées. 

3. JPA And Hibernate (Persistence layer)

Hibernate/JPA permet de sauvegarder rapidement un objet java dans une base de données. Il permet de s’affranchir des requêtes SQL écrite à la main et le plus souvent difficile à maintenir dans le temps

4. Tomcat (WEB CONTAINER)

Apache Tomcat est un conteneur web libre de servlets et JSP Java EE. Issu du projet Jakarta, c'est un des nombreux projets de l’Apache Software Foundation.
