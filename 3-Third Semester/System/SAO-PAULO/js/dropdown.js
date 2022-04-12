var $ = jQuery.noConflict();
$(document).ready(function() {
		/* for top navigation */
		$(" .navigation ul ").css({display: "none"}); // Opera Fix
		$(" .navigation li").hover(function(){
		$(this).find('ul:first').css({visibility: "visible",display: "none"}).slideDown(400);
		},function(){
		$(this).find('ul:first').css({visibility: "hidden"});
		});
		
});

function VincularCadastroExibe(){
        if(document.getElementById("MenuVincularCadastro")){
        document.getElementById("MenuVincularCadastro").style.display = "block";
        document.getElementById("MenuVincularCadastro2").style.display = "block";
        }
}

function VincularCadastroOculta(){
        document.getElementById("MenuVincularCadastro").style.display = "none";
        document.getElementById("MenuVincularCadastro2").style.display = "none";
}

function CadastrosProtocoloExibe(){
        if(document.getElementById("MenuCadastroProtocolo")){
        document.getElementById("MenuCadastroProtocolo").style.display = "block";
        document.getElementById("MenuCadastroProtocolo2").style.display = "block";
        }
}

function CadastrosProtocoloOculta(){
        document.getElementById("MenuCadastroProtocolo").style.display = "none";
        document.getElementById("MenuCadastroProtocolo2").style.display = "none";
}

function VincularProtocoloExibe(){
        if(document.getElementById("MenuVincularProtocolo")){
        document.getElementById("MenuVincularProtocolo").style.display = "block";
        document.getElementById("MenuVincularProtocolo2").style.display = "block";
        }
}

function VincularProtocoloOculta(){
        document.getElementById("MenuVincularProtocolo").style.display = "none";
        document.getElementById("MenuVincularProtocolo2").style.display = "none";
}