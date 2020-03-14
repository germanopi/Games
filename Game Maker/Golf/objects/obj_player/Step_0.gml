if(spawner==false){ // Cria o player em algum lugar
	x=irandom(room_width-32);
	y=irandom(room_width-32);
	while(place_meeting(x,y,obj_wall)){ // Tenta spawnar em outro local se spawnou no local de um bloco
		x=irandom(room_width-32);
		y=irandom(room_width-32);
		spawner=true;
	}
}

if(mouse_check_button_pressed(mb_left)){ // Verifica se clicou com o botão esquerdo do mouse
	if(isPressed=false){
		isPressed=true;
	}
}

// Controlador de estado do jogo
if(isPressed){  
	isPressed=false;
	if(state==nulo){ 
		state=medindoPoder; 
	}else if(state==medindoPoder){ 
		state=final;
	}
}

// Gerencia a velocidade da animação da barra de força
if(state==medindoPoder){
	if(stateAnimation=aumentando){
		velocidade+=aumentarVelocidade;
		if(velocidade>=maxVelocidade){
			velocidade=maxVelocidade;
			stateAnimation=diminuindo;
		}
	}else{
			velocidade-=aumentarVelocidade;
			if(velocidade<=0){
				velocidade=0;
				stateAnimation=aumentando;
			}
	}
}

if(state == target) {
	if(x+velx*velocidade+32>room_width || x+velx*velocidade<0 || !place_free(x+velx*velocidade,y) ){ // Impede de sair na horizontal e verifica colisão com parede
		velx*=-1;
	}
	if(y+vely*velocidade+32>room_height || y+vely*velocidade<0 || !place_free(x,y+vely*velocidade)){ // Impede de sair na vertical e verifica colisão com parede
		vely*=-1;
	}
	x+=velx*velocidade; // Aplica a força selecionada na bola
	y+=vely*velocidade; // Aplica a força selecionada na bola
	velocidade-=0.09; // Aplica resistencia
	
	if(velocidade<=1){ // Aumenta pontuação se colidir com o buraco
		if(place_meeting(x,y,obj_hole)){
			pontos++;
			tacadas=5;
			velocidade = 0;
			state = nulo;
			// Cria outra bola
			x=irandom(room_width-32);
			y=irandom(room_width-32);
			while(place_meeting(x,y,obj_wall)){ // Tenta spawnar em outro local se spawnou no local de um bloco
				x=irandom(room_width-32);
				y=irandom(room_width-32);
			}		
		}	
    }
	
	if(velocidade<=0){ // Para a bola
		velocidade = 0;
		state = nulo;
		tacadas--;
		if(tacadas==0){ // Acabou o numero de jogadas
			room_restart();
		}
	}
}

if(state==final){ 
	state = target;
	var angle = point_direction(x,y,mouse_x,mouse_y); // Gera angulo entre player e o local clicado
	velx = cos(degtorad(angle));
	vely = -sin(degtorad(angle));
}