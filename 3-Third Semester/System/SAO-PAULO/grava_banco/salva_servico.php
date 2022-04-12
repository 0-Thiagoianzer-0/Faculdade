<?php
	session_start();
	include('../include/conexao.php');

	$codigo_servico = $_POST['txtCodigoServico'];
	$codigo_pessoa = $_POST['cmbPessoa'];
	$codigo_prioridade = $_POST['cmbPrioridade'];
	$codigo_status = 1;
	$prazo = $_POST['txtPrazo'];
	$valor = $_POST['txtValor'];
	$valor = str_replace(",",".", $valor);
	$descricao = mb_strtoupper(trim($_POST['txtDescricao']), 'UTF-8');
	$anexo = $_POST['chkAnexo'];
	$hora = date("H:i:s");
	$data = date("d/m/Y");
		
	//COMEÇA A SQL
	$sql = "BEGIN;";
	$select_codigo = pg_query("SELECT MAX (codigo_servico) FROM servico"); //PEGA O ULTIMO CODIGO DA TABELA
	$codigo_servico = pg_fetch_array($select_codigo);
	$codigo_servico = $codigo_servico[0] + 1; //ACRESCENTA 1 NO CODIGO
	//SALVA SERVICO
	$sql .= "INSERT INTO servico (codigo_servico, codigo_pessoa, codigo_usuario, codigo_servico_prioridade, codigo_servico_status, prazo, ";
	$sql .= "valor, descricao, data_abertura, hora_abertura, anexo) ";
	$sql .= "VALUES($codigo_servico, $codigo_pessoa, {$_SESSION['codigo_usuario']}, $codigo_prioridade, $codigo_status, '$prazo', '$valor', ";
	$sql .= "'$descricao', '$data', '$hora', '$anexo'); ";

	if(isset($_SESSION['ordem_produto']['produto'])){
		foreach($_SESSION['ordem_produto']['produto'] as $indice_produto=> $produto){
			$sql .= "INSERT INTO servico_produto (codigo_servico, codigo_produto) ";
			$sql .= "VALUES ($codigo_servico, $produto[0]); ";
		}
	}
	
	//SALVA LOG
	$descricao = "CADASTRO DE DADOS DO SERVICO: $codigo_servico";
	$sql .= "INSERT INTO log (descricao, codigo_log_tipo_acao, codigo_formulario, codigo_usuario, data, hora) ";
	$sql .= "VALUES ('$descricao', 1, 8,{$_SESSION['codigo_usuario']}, '$data', '$hora');";
	//FINALIZA A SQL
	$sql .= "COMMIT;";
	pg_query($sql);
	if($sql){
		echo'Cadastrado com sucesso';
		$_SESSION['CodigoServico'] = $codigo_servico;
	}else{
		echo'Não pode ser Cadastrado'; 
	}
?>