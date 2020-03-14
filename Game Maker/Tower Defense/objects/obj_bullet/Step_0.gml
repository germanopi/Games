if(isDefined==false){  // Calcula a direção ao inimigo atual
	isDefined=true;
	if(instance_exists(enemyRef)){
	direction=point_direction(x,y,enemyRef.x,enemyRef.y);
	}
	speed=8;
}