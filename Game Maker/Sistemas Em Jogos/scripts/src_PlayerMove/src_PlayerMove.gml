if(keyboard_check(vk_right) && place_free(x+4,y)){
	if(!place_meeting(x+4,y,obj_elevator)){
		if(!place_meeting(x,y,obj_water)){
			x+=4;	
			if(onIce){
				velocidadeIce=2;
			}
		}else{
			x++;
			if(onIce){
				velocidadeIce=1;
			}
		}
	}
}else if(keyboard_check(vk_left) && place_free(x-4,y)){
	if(!place_meeting(x-4,y,obj_elevator)){
		if(!place_meeting(x,y,obj_water)){
			x-=4;	
			if(onIce){
				velocidadeIce=-2;
			}
		}else{
			x--;
			if(onIce){
				velocidadeIce=-1;
			}
		}
	}
}

if(place_free(x+velocidadeIce,y)){
		x+=velocidadeIce;
	}

	show_debug_message(x);