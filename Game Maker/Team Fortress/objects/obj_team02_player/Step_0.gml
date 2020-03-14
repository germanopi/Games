if(vida <= 0){ // Se o bot morrer contabiliza ponto e destroi ele
obj_contador.time_0++;
instance_destroy();
}

// Movimentação 
var move = false;
if(state == running){
if(dir == right){
if(place_free(x+walkSpd,y)){
	x+=walkSpd;
	image_xscale = 1;
	move = true;
}
}else if(dir == left){
	if(place_free(x-walkSpd,y)){
		x-=walkSpd;
		image_xscale = -1;
		move = true;
	}
}


if(random(100) < 5){ // Randomiza direção dos bots
	dir = choose(right,left);
}

if(random(100) < 1){ // Randomiza pulo dos bots
	if(jump == false){
		jump = true;
	}
}


if(random(100) < 2) { // Randomiza perseguição aos bots inimigos
   state = chasing;
}
	
}else if(state == chasing){

		var objTarget = instance_nearest(x,y,obj_team01_player); // Procura o inimigo mais proximo
		
		if(instance_exists(objTarget)){ // Se existir um inimigo proximo
		
		if(abs(objTarget.y) - abs(y) < 8){ // Se estiver em uma altura proxima 
		
		if(point_distance(x,y,objTarget.x,objTarget.y) < 130){ // Se estiverem a uma distancia proxima
			//Começar a atacar!
			if(random(100) < 30){ // Chance de começar a atirar
					var obj = instance_create_depth(x+(27*image_xscale),y,1,obj_bullet2);	
					obj.hspeed = 10*image_xscale;
			}
		}else{
					if(objTarget.x < x){ // Se aproxima do inimigo indo para esquerda
						dir = left;	
					}else if(objTarget.x > x){ // Se aproxima do inimigo indo para direita
						dir = right;
					}
	
					if(dir == right){
					if(place_free(x+walkSpd,y)){
						x+=walkSpd;
						image_xscale = 1;
						move = true;
					}
					}else if(dir == left){
						if(place_free(x-walkSpd,y)){
							x-=walkSpd;
							image_xscale = -1;
							move = true;
						}
					}
		}
		
		if(random(100) < 3){ // Se não estiver proximo do nem conseguiu se aproximar fique correndo
			state = running;	
		}
		}else{ // Se não estiver com uma altura proxima fique correndo
			state = running;	
		}
		}
}


src_pulo(); // Script de pulo
if(move){ // Alterna roupa correndo e parado
		sprite_index = spriteRoupaRunning;
}else{
		sprite_index = spriteRoupaIdle;
}


