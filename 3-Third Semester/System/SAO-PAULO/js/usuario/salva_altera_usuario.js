function salvausuario(){
    ajax = IniciaAjax();
    if(ajax){
        ajax.onreadystatechange = function(){ 
            if(ajax.readyState==4){
                if(ajax.status==200){
                    var resposta = ajax.responseText;
                    document.getElementById("aviso").innerHTML = resposta;
                    document.getElementById("aviso").style.display ='block';
                    setTimeout("document.getElementById('aviso').style.display='none'", 8000);
                    //Passa a resposta para a div aviso
                    document.getElementById("aviso").innerHTML = resposta;         
                }else{
                    alert(ajax.statusText);
                }
            }
        }
		
        codigo_usuario = document.getElementById("txtCodigoUsuario").value;
        codigo_pessoa = document.getElementById("cmbPessoa").value;
		email = document.getElementById("txtEmail").value;
		valida_email = checkMail(email);
		senha = document.getElementById("txtSenha").value;
        ativo = document.forms["formUsuario"].elements["chkAtivo"];
        if(ativo.checked){
            ativo = 1;
        }else{
            ativo = 0;
        }

        //Monta Query String
        dados = '&txtCodigoUsuario=' + codigo_usuario + '&cmbPessoa=' + codigo_pessoa + '&txtEmail=' + email + '&txtSenha=' + senha +
			'&chkAtivo=' + ativo;
		
        if((codigo_usuario == '' || codigo_pessoa == '' || email == '' || senha == '') || !valida_email){
            document.getElementById("aviso").style.display = 'block';
            setTimeout("document.getElementById('aviso').style.display='none'", 8000);
            if(!valida_email && email != ''){
                document.getElementById("aviso").innerHTML = 'Informe um e-mail válido!';
			}else{
            	document.getElementById("aviso").innerHTML = 'Preencha todos os campos!';
			}
        }else{
            ajax.open('POST', 'grava_banco/salva_altera_usuario.php', true);
            ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            ajax.send(dados);
            limpar();
        }
    }
}