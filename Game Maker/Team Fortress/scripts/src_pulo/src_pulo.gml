vspd+=grvt;                               // A velocidade vertical sempre recebe efeito da gravidade 
if(!place_free(x,y+1) && jump)	{		  // Permite pular se estiver no chão 
	jump = false;
	vspd = jumpHeight;
}

if(place_free(x,y+vspd) == false){        // Evita colisão vertical durante o pulo
	var signVsp = 0;
	if(vspd >= 0){	 // Durante a descida
		signVsp = 1;
	}else{			// Durante a subida
		signVsp = -1;
	}
	
	while(place_free(x,y+signVsp)){   // Permite se movimentar até 1 pixel antes da colisão
		y+=signVsp;
	}
	vspd = 0;			// Objeto não se move ao colidir
}

y = y + vspd;  // Pula