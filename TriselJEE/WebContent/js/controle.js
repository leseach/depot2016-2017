function verifForm(f)
{
	if(f.user.value == "")
	{
		alert("La saisie du code usager  est obligatoire!");
		f.user.focus();
		return false;
	}
	else {
		if(f.mdp.value == "") {
			alert("La saisie du mot de passe est obligatoire!");
			f.mdp.focus();
			return false;
		}
	}
}