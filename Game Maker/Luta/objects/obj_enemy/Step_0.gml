if(point_distance(x,y,obj_player.x,obj_player.y)<30){
	if(random(100)<40 && sprite_index!=spr_kick){
		sprite_index=spr_kick;
		alarm[0]=5;
	}
}else{
if(estado==andar){
	if(x<obj_player.x){
		x+=2;
		image_xscale=1;
	}else{
		x-=2;
		image_xscale=-1;
	}
}
}

if(random(100)<3){
	estado=choose(andar,defesa,ataque);	
}

if(place_meeting(x,y,obj_player)){
	if(obj_player.sprite_index==spr_punch){	
		if(random(100)<10){
			var inst=instance_find(obj_lifeEnemy,0);
			instance_destroy(inst);
	}
	}
}

if(instance_number(obj_lifeEnemy)==0){
	room_restart();
}