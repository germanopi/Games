if(keyboard_check(vk_up) && place_free(x,y-4)){
	y-=4;
}else if(keyboard_check(vk_down) && place_free(x,y+4)){
	y+=4;
} 

velocidadeVertical=0;
if(keyboard_check(vk_space)){
		jump=false;
		velocidadeVertical=-12;
		y-=12;
	}
