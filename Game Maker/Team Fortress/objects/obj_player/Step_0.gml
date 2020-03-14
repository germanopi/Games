if(vida <= 0){ // Recomeçã o jogo se o jogador morrer
room_restart();
}

var move = false;

if(keyboard_check(vk_right) && place_free(x+walkSpd,y)){ // Avança se pressionar para direita e não for colidir
	x+=walkSpd;
	image_xscale = 1; // Muda a sprite para direita
	move = true;
}
if(keyboard_check(vk_left) && place_free(x-walkSpd,y)){ // Avança se pressionar para esquerda e não for colidir
	x-=walkSpd;
	image_xscale = -1; // Muda a sprite para direita
	move = true;
}

// Controla a camera para seguir o jogador
var camX = clamp(x - view_wport[0]/2,0,room_width - view_wport[0]);
camera_set_view_pos(view_camera[0],camX,0);


if(keyboard_check_pressed(ord("Z"))){ // Detecta se a tecla de pulo foi pressionada
	jump = true;
}

if(keyboard_check_pressed(ord("X"))){ // Detecla se a tecla de atirar foi pressionada
	if(ammo > 0){ // Se tiver munição sobrando 
	var obj = instance_create_depth(x+(27*image_xscale),y,1,obj_bullet);	// Cria a bullet
	obj.hspeed = 10*image_xscale; // Adiciona velocidade 
	ammo--; // Diminui a quantidade de munição
	}
}

src_pulo(); //Sistema de pulo

if(move){ // Alterna entre sprites parado e correndo
		sprite_index = spr_team_running1;
}else{
		sprite_index = spr_team_idle1;
}



