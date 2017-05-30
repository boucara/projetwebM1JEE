# projetwebM1JEE

http://miageprojet2.unice.fr/Intranet_de_Michel_Buffa/Technologie_Web_M1_Miage_2016-2017

# Mini projet
## Sujet 1: site Web pour les JNMs 2018

Vous avez sans doute vu le site Web permettant de s'inscrire pour les journées Miage (http://jnm2017.fr/).   

Le site Web permet de s'enregistrer en tant que Miagiste, enseignant ou entreprise partenaire. Il possède une interface front-end et une interface back-end (admin).  

Prenons le cas d'un élève qui s'inscrit et qui désire participer (bouton "participer" en haut à droite, qui sert à s'inscrire, en fait). Quand on clique on a un formulaire en plusieurs étapes  

    * On lui demande son nom, son prénom, un email, un mot de passe
    * On demande ensuite s'il s'agit d'un miagiste, d'un enseignant ou d'une entreprise partenaire
        ** S'il s'agit d'un miagiste, on demande ensuite sa date de naissance, la Miage à laquelle il appartient (liste déroulante), une photo à uploader, puis il doti cocher si il est un miagiste diplômé (un ancien élève).
        ** S'il s'agit d'une entreprise, on demande sa fonction, son tel, nom de l'entreprise, adresse de l'entreprise, secteur d'activité de l'entreprise
        ** S'il s'agit d'un enseignant je ne sais pas, le truc est grisé. Mais de mémoire, l'an dernier une fois qu'on avait dit par mail à la miage organisatrice qu'on venait, un admin devait nous enregistrer dans la base et on pouvait alors se connecter et valider les élèves qui s'étaient inscrits.
           
    * Une fois inscrit on peut se connecter. Ca ne sert pas à grand chose à part qu'on peut voter pour le concours de tee shirt et pour le concours de videos, on peut voir les trombinoscopes des élèves par miage, on peut voir les résultats des votes
    * Les votes ont un sujet, une liste de réponses possibles (la liste des miages), et on devait voter pour 3 miages maxi. Les votes ont une date/heure de départ et une date/heure de fin (en général une tranche de 30mns après les présentations des videos et des tee shirts)
  
       
    * Une fois inscrit on peut choisir un pack (menu "informations pratiques"): pack étudiant à 110 euros, pack diplômé à 160 euros ou pack diplômé sans hébergement à 100 euros. 
    * Quand on a choisi on peut soit payer directement (on fera un mini formulaire qui simulera la chose), soit on ne paye pas, et dans ce cas, c'est la direction de la Miage qui paye de son côté. Dans ce cas on validera le paiment d'un élève depuis l'interface d'administration. (ce sont les admins qui valideront le paiement, c'est toujours le cas pour les enseignants par exemple).
     
    * Les entreprises partenaires ne paient pas.

