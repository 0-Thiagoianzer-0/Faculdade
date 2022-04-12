function retorna_codigo(tabela, chave_primaria, campo){
    ajax = IniciaAjax();
    if(ajax){
        ajax.onreadystatechange = function(){ 
            if(ajax.readyState==4){
                if(ajax.status==200){
                    var res = ajax.responseText;
					if(res != ""){
						document.getElementById(campo).value = res;
					}else{
						alert("Erro, contate o suporte!");
					}
                }else{
                    alert(ajax.statusText);
                }
            }
        }
		
        dados = '&tabela=' + tabela + '&chave_primaria=' + chave_primaria;
		
		ajax.open('POST', 'consulta/retorna_codigo.php', true);
		ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		ajax.send(dados);
    }
}