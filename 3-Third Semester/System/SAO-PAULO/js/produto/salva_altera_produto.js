function salvaproduto(){
    ajax = IniciaAjax();
    if(ajax){
        ajax.onreadystatechange = function(){ 
            if(ajax.readyState==4){
                if(ajax.status==200){
                    var resposta = ajax.responseText;
                    document.getElementById("aviso").innerHTML = resposta;
                    document.getElementById("aviso").style.display ='block';
                    setTimeout("document.getElementById('aviso').style.display='none'", 8000);
                    document.getElementById("aviso").innerHTML = resposta;         
                }else{
                    alert(ajax.statusText);
                }
            }
        }
		
        codigo_produto = document.getElementById("txtCodigoProduto").value;
        nome = document.getElementById("txtNome").value;
		codigo_tipo_produto = document.getElementById("cmbTipoProduto").value;
		cor = document.getElementById("txtCor").value;
		espessura = document.getElementById("txtEspessura").value;
		observacao = document.getElementById("txtObservacao").value;
        ativo = document.forms["formProduto"].elements["chkAtivo"];
        if(ativo.checked){
            ativo = 1;
        }else{
            ativo = 0;
        }
		
        dados = '&txtCodigoProduto=' + codigo_produto + '&txtNome=' + nome + '&cmbTipoProduto=' + codigo_tipo_produto + '&txtCor=' +
			cor + '&txtEspessura=' + espessura + '&txtObservacao=' + observacao + '&chkAtivo=' + ativo;
		
        if(codigo_produto == '' || nome == '' || codigo_tipo_produto == '' || cor == '' || espessura == ''){
            document.getElementById("aviso").style.display = 'block';
            setTimeout("document.getElementById('aviso').style.display='none'", 8000);
            document.getElementById("aviso").innerHTML = 'Preencha todos os campos!';
        }else{
            ajax.open('POST', 'grava_banco/salva_altera_produto.php', true);
            ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            ajax.send(dados);
            limpar();
        }
    }
}