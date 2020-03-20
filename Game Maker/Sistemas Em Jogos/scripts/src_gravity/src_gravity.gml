if(!place_meeting(x,y,obj_rope)){
if(!place_meeting(x,y,obj_water)){
	if(!place_free(x,y+1) && keyboard_check(vk_space)){
		velocidadeVertical = -12;
		jump = false;
	}
	if(!place_meeting(x+4,y,obj_elevator) && !place_meeting(x-4,y,obj_elevator)){
		velocidadeVertical+=gravidade; 
		if(!place_free(x,y+velocidadeVertical)|| place_meeting(x,y+velocidadeVertical,obj_plataform)) {
			sentidoVelocidadeVertical = 0;
			if(velocidadeVertical >= 0){
				sentidoVelocidadeVertical = 1;
			}else {
				sentidoVelocidadeVertical = -1;
			}
			while(place_free(x,y+sentidoVelocidadeVertical) && place_meeting(x,y+velocidadeVertical,obj_plataform)) {
				y = y+sentidoVelocidadeVertical;
			}
			velocidadeVertical = 0;
		}
		y = y + velocidadeVertical;
	}
}else{
	if(place_free(x,y+2)&& !keyboard_check(vk_space)){
		y+=2;
	}else{	
		if(keyboard_check(vk_space)){
			y-=2;
		}
	}
}		
}