<?php
	include('../include/conexao.php');
	include_once('../include/valida_sessoes.php');
	
	$sql = "SELECT se.codigo_servico, pe.nome_razao_social, se.codigo_usuario, sp.nome prioridade, ";
	$sql .= "ss.nome status, ss.cor_exibicao, se.descricao, se.data_abertura, se.hora_abertura, se.prazo ";
	$sql .= "FROM servico se ";
	$sql .= "INNER JOIN pessoa pe ON pe.codigo_pessoa = se.codigo_pessoa ";
	$sql .= "INNER JOIN servico_prioridade sp ON sp.codigo_servico_prioridade = se.codigo_servico_prioridade ";
	$sql .= "INNER JOIN servico_status ss ON ss.codigo_servico_status = ss.codigo_servico_status ";
	$sql .= "WHERE se.codigo_servico_status = ss.codigo_servico_status ";
	$sql .= "ORDER BY se.codigo_servico ";
	
	$query_select = pg_query($conexao, $sql);
	$data = array();
	while($row = pg_fetch_array($query_select)){
		$data[] = array(
		"codigo" => $row['codigo_servico'],
		"titulo" => $row['nome_razao_social'],
		$descricao = $row['descricao'],
		$descricao = "DESCRIÇÃO: ".$descricao,
		$prazo = $row['prazo'],
		$prazo = date("d/m/Y", strtotime($prazo)),
		$prazo = "PRAZO: ".$prazo,
		"descricao" => $descricao." - ".$prazo,
		"data_abertura" => $row['data_abertura'],
		"cor_exibicao" => $row['cor_exibicao']
		);
	}
	echo json_encode(array("resultado" => $data));
?>