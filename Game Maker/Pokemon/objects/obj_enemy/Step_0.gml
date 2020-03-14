mp_potential_step(obj_player.x,obj_player.y,1,false); // Perseguição 
depth=-y;

// Muda o lado da sprite
if(obj_player.x<obj_enemy.x){
	image_xscale=1;
}else if(obj_player.x>obj_enemy.x){
	image_xscale=-1;
}