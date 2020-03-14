depth=-y;
// Movimento isometrico
if(keyboard_check(vk_down) && place_free(x+4,y+2)){
	x+=4;
	y+=2;
} else if(keyboard_check(vk_up) && place_free(x-4,y-2)){
	x-=4;
	y-=2;
}

else if(keyboard_check(vk_right) && place_free(x+4,y-2)){
	x+=4;
	y-=2;
} else if(keyboard_check(vk_left) && place_free(x-4,y+2)){
	x-=4;
	y+=2;
}