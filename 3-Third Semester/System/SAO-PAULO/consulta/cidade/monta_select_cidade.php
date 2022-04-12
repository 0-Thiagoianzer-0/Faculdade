<?php
    header('Content-Type: text/html; charset=utf-8');
    include('../../include/conexao.php');
    $consulta = pg_query("SELECT * FROM cidade ORDER BY nome ASC");
    while( $row = pg_fetch_assoc($consulta)){
        echo $row["nome"] . "|" . $row["codigo_cidade"] . ",";
    }
?>