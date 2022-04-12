    function SelecionarAba(aba){
        //Botao Dar Parecer
        botao1 = document.getElementById('aba1');
        botao_combo1 = document.getElementById('botao_combo1');
        img1 = document.getElementById('img1');
        legenda1 = document.getElementById("legenda1");
        
        //Botao Colaborador
        botao2 = document.getElementById('aba2');
        botao_combo2 = document.getElementById('botao_combo2');
        img2 = document.getElementById('img2');
        legenda2 = document.getElementById("legenda2");
        
        if(aba == 'aba1'){
            //Botao Dar Parecer
            botao1.style.display = "block";
            botao_combo1.style.backgroundColor = "#D0D0D0";
            botao_combo1.style.marginTop = "0px";
            botao_combo1.style.height = "32px";
            img1.removeAttribute("width");
            legenda1.style.fontSize = "13px";
            legenda1.style.lineHeight = "15px";
            
            //Botao Colaborador
            botao2.style.display = "none";
            botao_combo2.style.backgroundColor = "#E1E1E1";
            botao_combo2.style.marginTop = "7px";
            botao_combo2.style.height = "24px";
            botao_combo2.style.marginLeft = "95px";
            img2.setAttribute("width", "23");
            legenda2.style.fontSize = "11px";
            legenda2.style.lineHeight = "11px";
        }else{
            
            //Botao Colaborador
            botao2.style.display = "block";
            botao_combo2.style.backgroundColor = "#D0D0D0";
            botao_combo2.style.marginTop = "0px";
            botao_combo2.style.marginLeft = "79px";
            botao_combo2.style.height = "32px";
            img2.removeAttribute("width");
            legenda2.style.fontSize = "13px";
            legenda2.style.lineHeight = "15px";
            
            //Botao Dar Parecer
            botao1.style.display = "none";
            botao_combo1.style.backgroundColor = "#E1E1E1";
            botao_combo1.style.marginTop = "7px";
            botao_combo1.style.height = "24px";
            img1.setAttribute("width", "23");
            legenda1.style.fontSize = "11px";
            legenda1.style.lineHeight = "11px";
        }
    }
    
    function AlteraArquivo(){
        diretorio = upload_arquivo_iframe.document.getElementById('pdf').value.split('\\');
        if(diretorio[1] == "fakepath"){
            document.getElementById('fake_pdf').value = diretorio[2];
        }else if(diretorio == ""){
            document.getElementById('fake_pdf').value = "Nenhum Arquivo Selecionado...";
        }else{
            document.getElementById('fake_pdf').value = upload_arquivo_iframe.document.getElementById('pdf').value;
        }
    }
    
    function AlteraArquivo(){
        iframe_form = upload_arquivo_iframe.document.formulario_pdf;
        files = upload_arquivo_iframe.document.getElementsByName('pdf[]');
        UltimoInput = -1;
        for(i=0;i < files.length;i++){
            UltimoInput++;
        }
        VerificaFormato(UltimoInput);
        VerificaTamanho(UltimoInput);
        diretorio = files[UltimoInput].value.split('\\');
        if(diretorio[1] == "fakepath"){
            document.getElementById('fake_pdf').value = diretorio[2];
        }else if(diretorio == ""){
            document.getElementById('fake_pdf').value = "Nenhum Arquivo Selecionado...";
        }else{
            document.getElementById('fake_pdf').value = files[UltimoInput].value;
        }
        AtualizaTabelaUpload();
    }
    
    function ObterAnexo(){
            if(document.getElementById('CheckboxArquivos').checked){
                document.getElementById('DivArquivos').style.display = "block";
            }else{
                document.getElementById('DivArquivos').style.display = "none";
            }
            AlteraArquivo();
        }
    
    function MudaVisibilidade(){
        if(document.getElementById("tipo_vizualizacao_enviadas").checked){
            document.getElementById("TabelaAcoesSolicitante").style.display = "block";
            document.getElementById("combo_abas").style.display = "none";
        }else{
            document.getElementById("TabelaAcoesSolicitante").style.display = "none";
            document.getElementById("combo_abas").style.display = "block";
        }
        AtualizaSolicitacaoParecer();
    }
    
    function PorqueDesabilitada(El, e, Acao){
        if(El.className == "Btn-Disabled"){
            var Div = document.getElementById("div_porque_desabilitada");
            if(Acao == "block"){
                document.body.setAttribute("onmousemove", "CoordenadasMouse(event)");
                AbrirPorqueDesabilitada = setTimeout("FuncAbrirPorqueDesabilitada()", 500);
            }else{
                document.body.removeAttribute("onmousemove");
                clearTimeout(AbrirPorqueDesabilitada);
                Div.style.display = "none";
            }
        }
    }
    
    function FuncAbrirPorqueDesabilitada(){
        //var Div = document.getElementById("div_porque_desabilitada");
        //Div.style.display = "block";
        $("#div_porque_desabilitada").show(100);
    }
    
    function CoordenadasMouse(){
        var posx = 0;
	    var posy = 0;
	    if(!e){
            var e = window.event;
	    }
	    if(e.pageX || e.pageY) 	{
		    posx = e.pageX;
		    posy = e.pageY;
	    }else if(e.clientX || e.clientY){
		    posx = e.clientX + document.body.scrollLeft + document.documentElement.scrollLeft;
		    posy = e.clientY + document.body.scrollTop + document.documentElement.scrollTop;
	    }
        var Div = document.getElementById("div_porque_desabilitada");
        Div.style.top = posy+10+"px";
        Div.style.left = posx+5+"px";
    }