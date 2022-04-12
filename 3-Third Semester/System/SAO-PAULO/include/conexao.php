<?php
	$dados_conexao = "dbname = db_saopaulo port = 5432
	user = postgres password = hariel5351";
	if (!($conexao = pg_connect($dados_conexao))){
		echo "Não foi possível realizar a conexão com o banco de dados";
		exit;
    }
?>