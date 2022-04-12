function busca_usuarioAjax(){
    ajax=IniciaAjax();
    if(ajax){
        ajax.onreadystatechange = function(){
            if(ajax.readyState==4){
                if(ajax.status==200){
                    var res = ajax.responseText.split("|");
                    //CAMPOS
                    document.getElementById("txtCodigoUsuario").value = res[1];
                    document.getElementById("cmbPessoa").value = res[2];
					document.getElementById("txtEmail").value = res[3];
                    document.getElementById("chkAtivo").value = res[4];
                    //ATIVO
                    if(res[4] == "t"){
                        document.formUsuario.chkAtivo.checked = true;
                    }else{
                        document.formUsuario.chkAtivo.checked = false;
                    }
                }else{
                    alert(ajax.statusText);
                }
            }
        }
        usuario = document.getElementById("cmbUsuario").value;

        dados = 'usuario=' + usuario;
        
        ajax.open('POST','consulta/usuario/preenche_usuario_cadastro.php',true);
        ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
        ajax.send(dados);
    }
}