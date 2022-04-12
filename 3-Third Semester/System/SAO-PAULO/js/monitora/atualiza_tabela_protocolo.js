function atualiza_tabela_servico(){
	ajax = IniciaAjax();
	if(ajax){
        ajax.onreadystatechange = function(){
            if(ajax.readyState == 4){
                if (ajax.status == 200){
                    document.getElementById("tabela_servicos").innerHTML = '';
                    var res = ajax.responseText.split("|");
					if(res[1]){
						var html = "";
						html += "<table id='tabelaMonitora'>";
						html += "<thead>";
						html += "<tr>";
						html += "<th style='width:30px;'>Código</th>";
						html += "<th style='width:300px;'>Usuário</th>";
						html += "<th style='width:350px;'>Cliente</th>";
						html += "<th style='width:200px;'>Descrição</th>";
						html += "<th style='width:120px;'>Prazo</th>";
						html += "<th style='width:170px;'>Situação</th>";
						html += "<th style='width:40px;' colspan='2'>Ver</th>";
						html += "</tr>";
						html += "</thead>";
						html += "<tbody>";
						for(var i = 1; i < res.length; i++){
							html += "<tr style='height: 50px;'>";
							html += "<td style='width: 30px; height: 50px; color:black;'>" + res[i] + "</td>"
							html += "<td style='width: 300px; height: 50px; color:black;'>" + res[i + 1] + "</td>";
							html += "<td style='width: 350px; height: 50px; color:black;'>" + res[i + 2] + "</td>";
							html += "<td style='width: 200px; height: 50px; color:black;'>";
							html += "<textarea readonly='true' style='padding:3px; color:black; font-style:normal; height:30px; ";
							html += "width:200px; background:#f7f7f7; border:none; overflow-y: scroll;'>"
							+ res[i + 3] + "</textarea></td>";
							html += "<td style='width: 120px; height: 50px; color:black;'>" + res[i + 4] + "</td>";
							html += "<td style='width: 170px; height: 50px; color:black;'>" + res[i + 5] + "</td>";
							html += "<td><a style='float: none;' href=atende_servico.php?id=" + res[i] +"><img src='images/visualizar.png' width='25px' height='25px' style='padding: 5px' /></a></td>";
							html += "<td style='background-color:" + res[i + 6] + "; width:10px; height: 50px;'></td>";
							html += "</tr>";
							i = i + 6;
                        }
						html += '</tbody>';
						html += '</table>';
                    }else{
						html = "<div style='margin-left: 4px;margin-top: 10px;'>Não há nenhum protocolo com estes critérios.</div>";
                    }
                    document.getElementById("tabela_servicos").style.display = 'block';
                    var load = function () { loading(html) };
                    setTimeout(load, 1000);
                    function loading(html) {
                        document.getElementById("div_carregando").style.display = 'none';
                        document.getElementById("tabela_servicos").innerHTML = html;
                    }

                } else {
                    alert(ajax.statusText);
                    document.getElementById("div_carregando").style.display = 'none';
                }
            }
        }
		document.getElementById("tabela_servicos").innerHTML = "";
		document.getElementById("div_carregando").style.display = 'block';
		
		codigo_usuario = document.getElementById("cmbUsuario").value;
		data_inicial = document.getElementById("txtDataInicial").value;
		data_final = document.getElementById("txtDataFinal").value;
		codigo_classificar = document.getElementById("cmbClassificar").value;
		
		//FILTROS
		chkPendente = document.getElementById("chkPendente").checked;
		chkAtendimento = document.getElementById("chkAtendimento").checked;
		chkConcluido = document.getElementById("chkConcluido").checked;
		chkAtrasado = document.getElementById("chkAtrasado").checked;		
		chkCancelado = document.getElementById("chkCancelado").checked;
		
		//CRIA ARRAY DE FILTROS
		filtros = chkPendente + "," + chkAtendimento + "," + chkConcluido + "," + chkAtrasado + "," + chkCancelado;
		
		//MONTA QUERY STRING
		dados = '&cmbUsuario=' + codigo_usuario + '&txtDataInicial=' + data_inicial + '&txtDataFinal=' + data_final +
		'&cmbClassificar=' + codigo_classificar + '&filtros=' + filtros;

		//Faz a requisição e envio pelo metodo POST
		ajax.open('POST', 'consulta/monitora/busca_servico.php', true);
		ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		ajax.send(dados);

    }
}