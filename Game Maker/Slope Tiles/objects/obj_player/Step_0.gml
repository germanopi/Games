if(place_free(x,y+1)){
	y++;
}
if(keyboard_check(vk_right)&& place_free(x+1,y)){
	x++;
}
if(keyboard_check(vk_left)&& place_free(x-1,y)){
	x--;
}

// Colisão Slope
	while(place_meeting(x,y,obj_slope)){
		y--;
}
