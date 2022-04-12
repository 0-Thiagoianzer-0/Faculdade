function busca_tipo_produtoAjax(){
    ajax=IniciaAjax();
    if(ajax){
        ajax.onreadystatechange = function(){
            if(ajax.readyState==4){
                if(ajax.status==200){
                    var res = ajax.responseText.split("|");
                    //CAMPOS
                    document.getElementById("txtCodigoTipoProduto").value = res[1];
                    document.getElementById("txtNome").value = res[2];
                    document.getElementById("txtDescricao").value = res[3];
                    //ATIVO
                    if(res[4] == "t"){
                        document.formTipoProduto.chkAtivo.checked = true;
                    }else{
                        document.formTipoProduto.chkAtivo.checked = false;
                    }
                }else{
                    alert(ajax.statusText);
                }
            }
        }
        tipo_produto = document.getElementById("cmbTipoProduto").value;

        dados = 'tipo_produto=' + tipo_produto;
        
        ajax.open('POST','consulta/tipo_produto/preenche_tipo_produto_cadastro.php',true);
        ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
        ajax.send(dados);
    }
}