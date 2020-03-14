/// @description Insert description here
// You can write your code in this editor


//Inteligência artificial

right = 1;
left = -1;

dir = choose(right,left);

chasing = 1;
running = 2;

state = running;

//Variaveis de gravidade e velocidade

walkSpd = 2;

vspd = 0;
grvt = 0.4;

jumpHeight = -10;

jump = false;

//Escolha das armas de forma aleatória!
spriteArma = choose(spr_item01,spr_item02);

vida = 100;