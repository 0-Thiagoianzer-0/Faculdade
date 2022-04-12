function busca_orgao_emissorAjax(){
    ajax=IniciaAjax();
    if(ajax){
        ajax.onreadystatechange = function(){
            if(ajax.readyState==4){
                if(ajax.status==200){
                    var res = ajax.responseText.split("|");
                    //CAMPOS
                    document.getElementById("txtCodigoOrgaoEmissor").value = res[1];
                    document.getElementById("txtNome").value = res[2];
					document.getElementById("txtSigla").value = res[3];
                    document.getElementById("chkAtivo").value = res[4];
                    //ATIVO
                    if(res[4] == "t"){
                        document.formOrgaoEmissor.chkAtivo.checked = true;
                    }else{
                        document.formOrgaoEmissor.chkAtivo.checked = false;
                    }
                }else{
                    alert(ajax.statusText);
                }
            }
        }
        orgao_emissor = document.getElementById("cmbOrgaoEmissor").value;

        dados = 'orgao_emissor=' + orgao_emissor;
        
        ajax.open('POST','consulta/orgao_emissor/preenche_orgao_emissor_cadastro.php',true);
        ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
        ajax.send(dados);
    }
}