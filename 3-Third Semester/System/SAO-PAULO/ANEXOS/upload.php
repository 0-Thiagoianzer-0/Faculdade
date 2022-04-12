<?php
	session_start();
	include('../include/conexao.php');
	
	$codigo_servico = $_SESSION['CodigoServico'];
	$hora = date("H:i:s");
	$data = date("d/m/Y");
	
    $sql = "BEGIN;";
	
	if($codigo_servico == ""){
		echo "Erro ao realizar upload!";
		exit;
	}else if(!is_dir($codigo_servico . "/")){
		mkdir($codigo_servico . "/", 0777, "true");
	}
	
	$arquivo = $_FILES['file'];
	
	$path = $arquivo['name'];
	$extensao = "." . pathinfo($path, PATHINFO_EXTENSION);
	$novo_nome = md5(time() + $codigo_servico);
	$novo_nome_extensao = $novo_nome . $extensao;
	$diretorio = $codigo_servico . "/";
	move_uploaded_file($arquivo['tmp_name'], $diretorio.$novo_nome_extensao);
	
	$sql .= "INSERT INTO servico_arquivo (codigo_servico, nome, extensao, diretorio, hora, data) ";
	$sql .= "VALUES($codigo_servico, '$novo_nome', '$extensao', '$diretorio', '$hora', '$data'); ";
	
	//FINALIZA A SQL
	$sql .= "COMMIT;";
	pg_query($conexao, $sql);
	
	echo "Concluído!";
?>