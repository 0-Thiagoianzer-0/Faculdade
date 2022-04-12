<?php
    header('Content-Type: text/html; charset=utf-8');
    include('../../include/conexao.php');
	$sql = "SELECT u.codigo_usuario, p.nome_razao_social FROM usuario u ";
	$sql .= "INNER JOIN pessoa p ON p.codigo_pessoa = u.codigo_pessoa ";
	$sql .= "ORDER BY p.nome_razao_social ";
	$consulta = pg_query($sql);
    while( $row = pg_fetch_assoc($consulta)){
        echo $row["nome_razao_social"] . "|" . $row["codigo_usuario"] . ",";
    }
?>