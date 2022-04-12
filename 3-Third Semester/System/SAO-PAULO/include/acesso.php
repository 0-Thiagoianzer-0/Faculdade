<?php
    $rows = 0;
    $formulario_atual = explode("/",$_SERVER['PHP_SELF']); //RETORNA O NOME DO ARQUIVO
    $formulario_atual = end($formulario_atual);
    //COLOCA A MATRICULA DO COLABORADOR LOGADO NA SESSION
    $verifica_codigo_usuario = pg_query("SELECT * FROM usuario WHERE codigo_usuario = {$_SESSION['codigo_usuario']}");
    $verifica_codigo_usuario2 = pg_fetch_array($verifica_codigo_usuario);
    $_SESSION["codigo_usuario"] = $verifica_codigo_usuario2['codigo_usuario'];
    $_SESSION["email"] = $verifica_codigo_usuario2['email'];
?>