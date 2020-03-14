with(other){ 
	instance_destroy(); // Destroi a bullet
}
	if(random(100)<30){ // Dano no inimigo
		life-=10;
		if(life<=0){
			instance_destroy();
		}
	}