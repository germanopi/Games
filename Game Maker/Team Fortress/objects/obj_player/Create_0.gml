walkSpd = 2;  // Velocidade horizontal
vspd = 0;		// Velocidade vertical
grvt = 0.4;    // Gravidade

jumpHeight = -10; // Altura do pulo

jump = false;  // Detecta se a tecla de pulo foi pressionada

vida = 100; // Vida do jogador


while(place_free(x,y+1)){ // Colocar o jogador no chão ao começar o jogo
	y++;
}


ammo = 20; // Munição maxima do jogador

depth = -10;  // Prioridade de renderização maxima

alarm[0] = 5; // Chama o metodo alarm0 a cada 5 ticks