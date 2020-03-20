velocidadeVertical=0;
if(keyboard_check(vk_up)){
	if(place_free(x,y-4)){
		y-=4;
	}
}else if(keyboard_check(vk_down)){
	if(place_free(x,y+4)){
		y+=4;
	}	
}
		
if(keyboard_check(vk_space)){
	if(!place_meeting(x,y-12,obj_stair)){
		y-=12;
		jump=false;
		velocidadeVertical=-12;
	}
}