function busca_produtoAjax(){
    ajax=IniciaAjax();
    if(ajax){
        ajax.onreadystatechange = function(){
            if(ajax.readyState==4){
                if(ajax.status==200){
                    var res = ajax.responseText.split("|");
                    //CAMPOS
                    document.getElementById("txtCodigoProduto").value = res[1];
                    document.getElementById("txtNome").value = res[2];
					document.getElementById("cmbTipoProduto").value = res[3];
					document.getElementById("txtCor").value = res[4];
					document.getElementById("txtEspessura").value = res[5];
					document.getElementById("txtObservacao").value = res[6];
                    document.getElementById("chkAtivo").value = res[7];
                    //ATIVO
                    if(res[7] == "t"){
                        document.formProduto.chkAtivo.checked = true;
                    }else{
                        document.formProduto.chkAtivo.checked = false;
                    }
                }else{
                    alert(ajax.statusText);
                }
            }
        }
        produto = document.getElementById("cmbProduto").value;

        dados = 'produto=' + produto;
        
        ajax.open('POST','consulta/produto/preenche_produto_cadastro.php',true);
        ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
        ajax.send(dados);
    }
}