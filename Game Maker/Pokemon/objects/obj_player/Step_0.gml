// Movimentação
if(keyboard_check(ord("W")) && place_free(x,y-spd) ){
	y-=spd;
}else if(keyboard_check(ord("S")) && place_free(x,y+spd)){
	y+=spd;
}else if(keyboard_check(ord("A")) && place_free(x-spd,y)){
	x-=spd;
}else if(keyboard_check(ord("D")) && place_free(x+spd,y)){
	x+=spd;
}

// Configura a camera para seguir o jogador
camera_set_view_pos(view_camera[0],x-view_wport[0]/2,y-view_hport[0]/2);
depth=-y;

if(place_meeting(x,y,obj_enemy)){
	if(random(100) <30){
		life--;
		audio_play_sound(snd_hurt,1,false);
	}
}
// Reinicia jogo
if(life<=0){
	room_restart();
}
// Mouse
if(mouse_check_button_pressed(mb_left)){
	var ray=instance_create_depth(x,y,1,obj_ray);
	ray.image_angle=point_direction(x,y,mouse_x,mouse_y);
	ray.direction=point_direction(x,y,mouse_x,mouse_y);
	ray.speed=7;
}

