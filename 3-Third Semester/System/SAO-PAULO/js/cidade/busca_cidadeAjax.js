function busca_cidadeAjax(){
    ajax=IniciaAjax();
    if(ajax){
        ajax.onreadystatechange = function(){
            if(ajax.readyState==4){
                if(ajax.status==200){
                    var res = ajax.responseText.split("|");
                    //CAMPOS
                    document.getElementById("txtCodigoCidade").value = res[1];
                    document.getElementById("txtNome").value = res[2];
					document.getElementById("cmbEstado").value = res[3];
                    document.getElementById("chkAtivo").value = res[4];
                    //ATIVO
                    if(res[4] == "t"){
                        document.formCidade.chkAtivo.checked = true;
                    }else{
                        document.formCidade.chkAtivo.checked = false;
                    }
                }else{
                    alert(ajax.statusText);
                }
            }
        }
        cidade = document.getElementById("cmbCidade").value;

        dados = 'cidade=' + cidade;
        
        ajax.open('POST','consulta/cidade/preenche_cidade_cadastro.php',true);
        ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
        ajax.send(dados);
    }
}