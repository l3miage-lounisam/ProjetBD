package l3miage.model;

/**
 * creation d'une enumération Définition permet de determiner si une station 
 * est Vplus(c'est a dire une station ou il y'a de l'emplacement libre par exemeple ) et une 
 * Station Vmoins(la présense de vélo disponible)ou Vnul (sans effet)
 * par exemple, vers le campus universitaire le matin(ici le campus est Vplus), et depuis le campus universitaire le soir
universitaire le matin, et depuis le campus universitaire le soir(ici il est Vmoins)
 * 
 */
public enum Definition {
    vplus,
    vmoins,
    vnul
}
