<?php
    header('Content-Type: text/html; charset=utf-8');
    include('../../include/conexao.php');
    $consulta = pg_query("SELECT * FROM pessoa ORDER BY nome_razao_social ASC");
    while( $row = pg_fetch_assoc($consulta)){
        echo $row["nome_razao_social"] . "|" . $row["codigo_pessoa"] . ",";
    }
?>