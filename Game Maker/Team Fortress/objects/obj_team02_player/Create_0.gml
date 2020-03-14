//Inteligência artificial

vida = 100; 

right = 1;
left = -1;

dir = choose(right,left); // Randomiza a direção inicial dos bots

chasing = 1; 
running = 2;

state = running; // Estado inicial dos bots

//Variaveis de gravidade e velocidade

walkSpd = 2;  // Velocidade horizontal
vspd = 0;		// Velocidade vertical
grvt = 0.4;    // Gravidade

jumpHeight = -10; // Altura do pulo

jump = false;  // Detecta se a tecla de pulo foi pressionada

spriteArma = choose(spr_item01,spr_item02); // Randomiza a arma inicial

spriteRoupaIdle = choose(spr_team02_idle1,spr_team02_idle2); // Randomiza roupa inicial

if(spriteRoupaIdle == spr_team02_idle1){ // Determina a roupa de corrida para a do mesmo tipo que a inicial
	spriteRoupaRunning = spr_team02_running1;
}else if(spriteRoupaIdle == spr_team02_idle2){
	spriteRoupaRunning = spr_team02_running2;
}

