/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validateMdp2(mdp, mdpconfirm)
{
    var password = document.getElementById(mdp);
    var password2 = document.getElementById(mdpconfirm);
    var re = /^[a-z0-9A-Z]{6,20}/;
    if (re.exec(password.value) && password.value == password2.value)
    {
        // ici on supprime le message d'erreur personnalisé, et du coup mdp2 devient valide.
        document.getElementById(mdpconfirm).setCustomValidity('');
    }
    else
    {
        // ici on ajoute un message d'erreur personnalisé, et du coup mdp2 devient invalide.  
        document.getElementById(mdpconfirm).setCustomValidity('Les mots de passes doivent être égaux.');
    }
}

function validateEmail(emailid, url)
{
    var email = document.getElementById(emailid);
    $.get(url + "?etape=verificationEmail&email=" + email.value, function (res, error)
    {
        if (error == 'success')
        {
            document.getElementById(emailid).setCustomValidity('');
        }
    }).error(function () {
        document.getElementById(emailid).setCustomValidity("L'adresse email est déjà utilisée !");
    });
}