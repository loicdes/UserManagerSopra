<fieldset><legend>Inscription</legend>
		Formulaire d'inscription, les champs (*) sont requis :
		<form action="Register" method="post">
			<label for="i_mail">Adresse mail <span>*</span></label>
			<input type="text" name="i_mail" value="${map_params['ATT_MAIL']}"/>
			<span class="error">${map_errors['err_mail']}</span><br>
			<label for="i_pwd">Mot de passe <span>*</span></label>
			<input type="password" name="i_pwd" />
			<span class="error">${map_errors['err_mdp']}</span><br>
			<label for="i_pwd1">Confirmez le mot de passe <span>*</span></label>
			<input type="password" name="i_pwd1"/>
			<span class="error">${map_errors['err_mdp']}</span><br>
			<label for="i_name">Nom d'utilisateur <span>*</span></label>
			<input type="text" name="i_name" value="${map_params['ATT_NAME']}"/>
			<span class="error">${map_errors['err_name']}</span><br>
			<input type="submit" value="Enregistrement"/>
		</form>
		<p class="info">${actionMessage}</p>
</fieldset>
