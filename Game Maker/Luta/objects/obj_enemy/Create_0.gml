ataque=0;
defesa=1;
andar=2;
estado=2;
image_speed=0.2;

for(var i=0;i<5;i++){
	var xx =500 + (i* 20 +(5*i));
	var yy =20;
	instance_create_depth(xx,yy,0,obj_lifeEnemy);
}
