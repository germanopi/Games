inst = instance_place(x,y,obj_key); // Pega a chave
if(inst!=noone){
	with(inst) instance_destroy();
	key=true;
}

with(obj_door){ // Abre a porta
	if(distance_to_object(other)<10){
		if(keyboard_check(ord("C"))	 && other.key==true){
			other.key=false;
			instance_destroy();
		 }	
	}
}
