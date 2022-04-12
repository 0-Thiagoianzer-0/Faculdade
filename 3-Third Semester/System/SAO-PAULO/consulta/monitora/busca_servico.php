<?php    
	include('../../include/conexao.php'); 
	session_start();
	
	$codigo_usuario = $_POST['cmbUsuario'];
	$data_inicial = $_POST['txtDataInicial'];
	$data_final = $_POST['txtDataFinal'];
	$codigo_classificar = $_POST['cmbClassificar'];
	
	$sql = "SELECT se.codigo_servico, pe.nome_razao_social cliente, peu.nome_razao_social usuario, ";
	$sql .= "sp.nome prioridade, ss.nome status, ss.cor_exibicao, se.descricao, se.data_abertura, ";
	$sql .= "se.hora_abertura, se.prazo ";
	$sql .= "FROM servico se ";
	$sql .= "INNER JOIN pessoa pe ON pe.codigo_pessoa = se.codigo_pessoa ";
	$sql .= "INNER JOIN servico_prioridade sp ON sp.codigo_servico_prioridade = se.codigo_servico_prioridade ";
	$sql .= "INNER JOIN servico_status ss ON ss.codigo_servico_status = se.codigo_servico_status ";
	$sql .= "INNER JOIN usuario us ON us.codigo_usuario = se.codigo_usuario ";
	$sql .= "INNER JOIN pessoa peu ON peu.codigo_pessoa = us.codigo_pessoa ";
	$sql .= "WHERE se.codigo_servico IS NULL ";
	
	$filtros = explode(",", $_POST['filtros']);
	if($filtros[0] == "true"){
		echo "aqui";
		$sql .= "OR se.codigo_servico_status = 1 ";
		if($codigo_usuario != ""){
			$sql .= "AND se.codigo_usuario = $codigo_usuario ";
		}
		if($data_inicial != "" and $data_final != ""){
			$sql .= "AND se.prazo BETWEEN to_date('$data_inicial' AND '$data_final') ";
		}
		if($data_inicial != "" and $data_final == ""){
			$sql .= "AND se.prazo >= '$data_inicial' ";
		}
		if($data_inicial == "" and $data_final != ""){
			$sql .= "AND se.prazo <= '$data_final' ";
		}
	} //PENDENTE
	if($filtros[1] == "true"){
		$sql .= "OR se.codigo_servico_status = 2 ";
		if($codigo_usuario != ""){
			$sql .= "AND se.codigo_usuario = $codigo_usuario ";
		}
		if($data_inicial != "" and $data_final != ""){
			$sql .= "AND se.prazo BETWEEN to_date('$data_inicial' AND '$data_final') ";
		}
		if($data_inicial != "" and $data_final == ""){
			$sql .= "AND se.prazo >= '$data_inicial' ";
		}
		if($data_inicial == "" and $data_final != ""){
			$sql .= "AND se.prazo <= '$data_final' ";
		}
	} //ATENDIMENTO
	if($filtros[2] == "true"){
		$sql .= "OR se.codigo_servico_status = 3 ";
		if($codigo_usuario != ""){
			$sql .= "AND se.codigo_usuario = $codigo_usuario ";
		}
		if($data_inicial != "" and $data_final != ""){
			$sql .= "AND se.prazo BETWEEN to_date('$data_inicial' AND '$data_final') ";
		}
		if($data_inicial != "" and $data_final == ""){
			$sql .= "AND se.prazo >= '$data_inicial' ";
		}
		if($data_inicial == "" and $data_final != ""){
			$sql .= "AND se.prazo <= '$data_final' ";
		}
	} //CONCLUÍDO
	if($filtros[3] == "true"){
		$sql .= "OR se.codigo_servico_status = 4 ";
		if($codigo_usuario != ""){
			$sql .= "AND se.codigo_usuario = $codigo_usuario ";
		}
		if($data_inicial != "" and $data_final != ""){
			$sql .= "AND se.prazo BETWEEN to_date('$data_inicial' AND '$data_final') ";
		}
		if($data_inicial != "" and $data_final == ""){
			$sql .= "AND se.prazo >= '$data_inicial' ";
		}
		if($data_inicial == "" and $data_final != ""){
			$sql .= "AND se.prazo <= '$data_final' ";
		}
	} //ATRASADO
	if($filtros[4] == "true"){
		$sql .= "OR se.codigo_servico_status = 1 ";
		if($codigo_usuario != ""){
			$sql .= "AND se.codigo_usuario = $codigo_usuario ";
		}
		if($data_inicial != "" and $data_final != ""){
			$sql .= "AND se.prazo BETWEEN to_date('$data_inicial' AND '$data_final') ";
		}
		if($data_inicial != "" and $data_final == ""){
			$sql .= "AND se.prazo >= '$data_inicial' ";
		}
		if($data_inicial == "" and $data_final != ""){
			$sql .= "AND se.prazo <= '$data_final' ";
		}
	} //CANCELADO

	if($codigo_classificar == "0"){ $sql .= "ORDER BY se.codigo_servico "; }
	else if($codigo_classificar == "1"){ $sql .= "ORDER BY usuario "; }
	else if($codigo_classificar == "2"){ $sql .= "ORDER BY cliente "; }
	else if($codigo_classificar == "3"){ $sql .= "ORDER BY prazo "; }
	else if($codigo_classificar == "3"){ $sql .= "ORDER BY status "; }

	$query = pg_query($sql);
	while($resultado = pg_fetch_assoc($query)){
		$dados .= "|" . $resultado['codigo_servico'];
		$dados .= "|" . $resultado['usuario'];
		$dados .= "|" . $resultado['cliente'];
		$dados .= "|" . $resultado['descricao'];
		$dados .= "|" . strftime("%d/%m/%Y", strtotime($resultado['prazo']));
		$dados .= "|" . $resultado['status'];
		$dados .= "|" . $resultado['cor_exibicao'];
	}

	//RETORNA PARA O AJAX OS VALORES
	echo "$dados";
?>