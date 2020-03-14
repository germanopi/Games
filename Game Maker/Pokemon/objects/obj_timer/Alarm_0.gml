// Spawna inimigos

if(instance_number(obj_enemy) < 5 || instance_number(obj_enemy2)<5 ){ 
		var obj=instance_create_depth(obj_timer.x+10,obj_timer.y+32,-1,obj_enemy);
		obj.sprite_index=choose(spr_enemy,spr_enemy2);
	}
tempo++;
// Avança o estagio
if(tempo>60){
	if(room==room_last){
		room_goto_previous();
	}else{
		room_goto(room_first);
	}	
}

alarm[0]=180;