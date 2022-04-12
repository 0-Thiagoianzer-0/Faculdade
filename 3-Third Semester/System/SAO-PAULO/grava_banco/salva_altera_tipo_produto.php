<?php
    session_start();
    include('../include/conexao.php');
    
    $codigo_tipo_produto = $_POST['txtCodigoTipoProduto'];
    $nome = strtoupper($_POST['txtNome']);
    $descricao = strtoupper($_POST['txtDescricao']);
    $ativo = $_POST['chkAtivo'];
    $hora = date("H:i:s");
    $data = date("d/m/Y");

    $testa_codigo = pg_query("SELECT * FROM tipo_produto WHERE codigo_tipo_produto='" . $codigo_tipo_produto . "'");
    $row = pg_num_rows($testa_codigo);
    //COMEÇA A SQL
    $sql = "BEGIN;";

    if($row>0){
        //ALTERA TIPO PRODUTO
        $sql .= "UPDATE tipo_produto SET codigo_tipo_produto=$codigo_tipo_produto, nome='$nome', descricao='$descricao', ativo='$ativo' ";
        $sql .= "WHERE codigo_tipo_produto=$codigo_tipo_produto ;";
        //SALVA LOG
        $descricao = "ALTERAÇÃO DE DADOS DO TIPO PRODUTO: $codigo_tipo_produto, NOME: $nome";
        $sql .= "INSERT INTO log (descricao, codigo_log_tipo_acao, codigo_formulario, codigo_usuario, data, hora) ";
        $sql .= "VALUES ('$descricao', 2, 5,{$_SESSION['codigo_usuario']}, '$data', '$hora');";
        //FINALIZA A SQL
        $sql .= "COMMIT;";
        pg_query($sql);
        if($sql){
            echo "Alterado com sucesso";
        }else{
            echo "Não pode ser alterado";
        }
        pg_close();
    }else{
        $testa_nome = pg_query("SELECT * FROM tipo_produto WHERE nome = '" . $nome . "'");
        $row = pg_num_rows($testa_nome);
        if($row > 0){
            echo "O TIPO PRODUTO já está cadastrado!";
        }else{
            //VERIFICA ÚLTIMO TIPO PRODUTO
            $select_codigo = pg_query("SELECT MAX (codigo_tipo_produto) FROM tipo_produto"); //PEGA O ULTIMO CODIGO DA TABELA
            $codigo_tipo_produto = pg_fetch_array($select_codigo);
            $codigo_tipo_produto = $codigo_tipo_produto[0] + 1; //ACRESCENTA 1 NO CODIGO
            //SALVA PODER
            $sql .= "INSERT INTO tipo_produto (codigo_tipo_produto, nome, descricao, ativo) ";
            $sql .= "VALUES($codigo_tipo_produto, '$nome', '$descricao', '$ativo');";
            //SALVA LOG
            $descricao = "CADASTRO DE DADOS DO TIPO PRODUTO: $codigo_tipo_produto, NOME: $nome";
            $sql .= "INSERT INTO log (descricao, codigo_log_tipo_acao, codigo_formulario, codigo_usuario, data, hora) ";
            $sql .= "VALUES ('$descricao', 1, 5,{$_SESSION['codigo_usuario']}, '$data', '$hora');";
            //FINALIZA A SQL
            $sql .= "COMMIT;";
            pg_query($sql);
            if($sql){
                echo'Cadastrado com sucesso';
            }else{
                echo'Não pode ser Cadastrado'; 
            }
        }
    }
?>