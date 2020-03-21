image_speed=0;
if(keyboard_check(vk_right)){
	x+=4;
	image_speed=0.4;
	image_xscale = abs(image_xscale); // abs se você trocou o tamanho do personagem
}else if (keyboard_check(vk_left)){
	x-=4;
	image_speed=0.4;
		image_xscale = abs(image_xscale)*-1; 
}

if(keyboard_check(ord("Z")) && sprite_index!=spr_punch){
	sprite_index=spr_punch;
	alarm[0]=5;
}

if(place_meeting(x,y,obj_enemy)){
	if(obj_enemy.sprite_index==spr_enemy){
		if(random(100)<10){
			var inst=instance_find(obj_lifePlayer,0);
			instance_destroy(inst);
	}
	}
}

if(instance_number(obj_lifePlayer)==0){
	room_restart();
}