# HibernateProjectM2

# Instruction

Afin de créer et de pouvoir se connecter à la base de donnée, il est impératif de changer certains bouts de code pour que tout fonctionne. Attention, le champs `<password>` doit impérativement être remplacer par votre mot de passe root.

# Création de la base de donnée

```
$ mysql -uroot -p
$ Enter password: <password>
mysql> CREATE DATABASE PROJETM2 CHARACTER SET utf8;
mysql> exit
$ mysql --user=root --password=<password> PROJETM2 < dump_projet_spring_ali_NEHME_15600238.sql
```
Pour relier Hibernate avec la base de donnée, rendez-vous dans:
/TP3/src/main/webapp/WEB-INF/dispatcher-servlet.xml
Changez la valeur de la variable `"value"` pour la property `name="password"` en mettant votre vrai mot de passe root: 
```
<property name="password" value="<password>" />
```

À partir de là, l'application peut être lancé à partir du serveur Tomcat. Ce projet a été testé et fonctionne sur macOS Mojave 10.14.6 (et je suppose sur Debian/Ubuntu) sur "Eclipse IDE for Enterprise Java Developers" [Version: 2019-09 R (4.13.0)]

> NB: J'ai essayé de créer un utilisateur qui possède tout les privilèges de root 
> mais je ne parviens pas à connecter ma base de donnée avec celui-ci. 
> Je pense que seul root permet de se connecter à la base de donnée (ce qui est étrange).


> NOM/Prénom: NEHME Ali
> Master 2: Informatique
> 15600238
