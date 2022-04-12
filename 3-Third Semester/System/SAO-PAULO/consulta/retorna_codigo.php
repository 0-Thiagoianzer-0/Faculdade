<?php
	include('../include/conexao.php');
	
	$tabela = $_POST['tabela'];
	$chave_primaria = $_POST['chave_primaria'];
	
	$sql = "SELECT MAX($chave_primaria) FROM $tabela ";
	$consulta = pg_query($conexao, $sql);
	$registro = pg_fetch_row($consulta);
	$codigo_tabela = $registro[0] + 1;
	
	echo $codigo_tabela;
?>