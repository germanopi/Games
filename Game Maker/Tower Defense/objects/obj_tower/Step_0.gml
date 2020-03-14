if(!isInventory){ // Torre fora do inventario
	with(obj_enemy){
		var dist=point_distance(other.x,other.y,x,y); // Calcula distancia da torre ao inimigo
		if(dist<=90){ // Inimigo dentro do alcance
			if(random(100)<30){ // Atira nos inimigos
				var obj=instance_create_depth(other.x+16,other.y+16,-1,obj_bullet);
				obj.enemyRef=self;
			}
			break;
		}
	}
}
			
		